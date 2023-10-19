package modele.DAO;

import modele.metier.Compte;
import modele.metier.CompteCourant;
import modele.metier.CompteEpargne;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompteSQLiteImpl implements CompteDAO {
    private Connection connection;

    public CompteSQLiteImpl(String dbfile) {
        try {
            Class.forName("org.sqlite.JDBC");
            String jdbcURL = "jdbc:sqlite:" + dbfile;
            connection = DriverManager.getConnection(jdbcURL);
            if (connection != null) {
                System.out.println("Connexion reussie");
            } else {
                System.out.println("Probleme de connexion");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Compte> findAll() {
        String q = "select * from compte";
        List<Compte> listeCompte = new ArrayList<>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(q);
            while (rs.next()) {
                Compte compte;
                String typeCompte = rs.getString("typeCompte");
                String numero = rs.getString("numero");
                String intitule = rs.getString("intitule");
                double solde = rs.getDouble("solde");
                if (typeCompte.equalsIgnoreCase("courant")) {
                    double decouvert = rs.getDouble("decouvertAutorise");
                    compte = new CompteCourant(numero, intitule, solde, typeCompte, decouvert);
                } else {
                    compte = new CompteEpargne(numero, intitule, solde, typeCompte);
                }
                listeCompte.add(compte);
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeCompte;
    }

    @Override
    public Compte findByNumero(String numero) {
        String q = "select * from compte where numero=?";
        Compte compte = null;
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.setString(1,numero);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String typeCompte = rs.getString("typeCompte");
                String intitule = rs.getString("intitule");
                double solde = rs.getDouble("solde");
                if (typeCompte.equalsIgnoreCase("courant")) {
                    double decouvert = rs.getDouble("decouvertAutorise");
                    compte = new CompteCourant(numero, intitule, solde, typeCompte, decouvert);
                } else {
                    compte = new CompteEpargne(numero, intitule, solde, typeCompte);
                }
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return compte;
    }

    @Override
    public void createJoint(Compte compte, String idClient1, String idClient2) {
        try {
            // On va récupérer le numero le plus grand de la base pour assigner au nouveau
            // compte le numero + 1. S'il n'y a pas de numero, on le met à 0.
            String sql = "SELECT numero from compte order by numero DESC limit 1";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int numero;
            if (rs.getString("numero") != null) {
                numero = Integer.parseInt(rs.getString("numero"));
            } else {
                numero = 0;
            }
            compte.setNumero(String.valueOf(++numero));
            rs.close();

            // On insert d'abord le nouveau compte dans la base
            sql = "INSERT INTO compte (numero, typeCompte, intitule, solde, typeCompte) VALUES(?,?,?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, compte.getNumero());
            pst.setString(2, compte.getTypeCompte());
            pst.setString(3, compte.getIntitule());
            pst.setDouble(4, compte.getSolde());
            pst.setString(5, compte.getTypeCompte());
            pst.executeUpdate();

            // On insert ensuite le premier client avec le idClient1 et on récupère le numéro du
            // compte créé juste avant
            sql = "INSERT INTO posseder (id_client, numero_compte, dateCrea) VALUES(?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, idClient1);
            pst.setString(2, compte.getNumero());
            pst.setString(3, String.valueOf(LocalDate.now()));
            pst.executeUpdate();

            // On insert ensuite le premier client avec le idClient2 et on récupère le numéro du
            // compte créé juste avant
            sql = "INSERT INTO posseder (id_client, numero_compte, dateCrea) VALUES(?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, idClient2);
            pst.setString(2, compte.getNumero());
            pst.setString(3, String.valueOf(LocalDate.now()));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Compte compte, String idClient) {
        try {
            // On va récupérer le numero le plus grand de la base pour assigner au nouveau
            // compte le numero + 1. S'il n'y a pas de numero, on le met à 0.
            String sql = "SELECT numero from compte order by numero DESC limit 1";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int numero;
            if (rs.getString("numero") != null) {
                numero = Integer.parseInt(rs.getString("numero"));
            } else {
                numero = 0;
            }
            compte.setNumero(String.valueOf(++numero));
            rs.close();
            // Selon le compte créé, on n'a pas les même champ à remplir. Si CompteCourant, decouvertAutorise est a
            // renseigner.
            if(compte instanceof CompteCourant) {
                sql = "INSERT INTO compte (numero, typeCompte, intitule, solde, decouvertAutorise) VALUES(?,?,?,?,?)";
                pst = connection.prepareStatement(sql);
                pst.setString(1, compte.getNumero());
                String typeCompte = compte.getTypeCompte();
                pst.setString(2, typeCompte);
                String intitule = compte.getIntitule();
                pst.setString(3, intitule);
                double solde = compte.getSolde();
                pst.setDouble(4, solde);
                double decouvert = ((CompteCourant) compte).getMontantDecouvertAutorise();
                pst.setDouble(5, decouvert);

            } else if (compte instanceof CompteEpargne){
                sql = "INSERT INTO compte (numero, typeCompte, intitule, solde) VALUES(?,?,?,?)";
                pst = connection.prepareStatement(sql);
                pst.setString(1, compte.getNumero());
                pst.setString(2, compte.getTypeCompte());
                pst.setString(3, compte.getIntitule());
                pst.setDouble(4, compte.getSolde());

            }
            pst.executeUpdate();
            //Après la création d'un compte, on ajoute à posséder une nouvelle entrée correspondant au compte et a
            // l'idClient passé en paramètre.
            sql = "INSERT INTO posseder (id_client, numero_compte, dateCrea) VALUES(?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, idClient);
            pst.setString(2, compte.getNumero());
            pst.setString(3, String.valueOf(LocalDate.now()));

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Compte compte) {
        String id = compte.getNumero();
        try {
            if(compte instanceof CompteEpargne){
                String requete = "UPDATE compte SET  typeCompte = ?, intitule = ?, solde = ? WHERE numero = ?";
                PreparedStatement pst = connection.prepareStatement(requete);
                pst.setString(1, compte.getTypeCompte());
                pst.setString(2, compte.getIntitule());
                pst.setDouble(3, compte.getSolde());
                pst.setString(4, id);
                pst.executeUpdate();
            } else if (compte instanceof CompteCourant) {
                String requete = "UPDATE compte SET  typeCompte = ?, intitule = ?, solde = ?, decouvertAutorise = ? WHERE numero = ?";
                PreparedStatement pst = connection.prepareStatement(requete);
                pst.setString(1, compte.getTypeCompte());
                pst.setString(2, compte.getIntitule());
                pst.setDouble(3, compte.getSolde());
                pst.setDouble(4, ((CompteCourant) compte).getMontantDecouvertAutorise());
                pst.setString(5, id);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Compte compte) {
        String id = compte.getNumero();
        // Il faut delete d'abord les tables dépendantes pour éviter les soucis de contrainte de clefs étrangères
        try {
            String requete = "DELETE FROM posseder WHERE numero_compte = ?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, compte.getNumero());
            pst.executeUpdate();

            requete = "DELETE FROM compte WHERE numero = ?";
            pst = connection.prepareStatement(requete) ;
            pst.setString(1, id) ;
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
