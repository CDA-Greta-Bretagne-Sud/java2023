package modele.DAO;

import modele.metier.Client;
import modele.metier.Compte;
import modele.metier.CompteCourant;
import modele.metier.CompteEpargne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteSQLiteImpl implements CompteDAO{
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
                    compte = new CompteCourant(numero, intitule, solde, decouvert);
                } else {
                    compte = new CompteEpargne(numero, intitule, solde);
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
                    compte = new CompteCourant(numero, intitule, solde, decouvert);
                } else {
                    compte = new CompteEpargne(numero, intitule, solde);
                }
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return compte;
    }
}
