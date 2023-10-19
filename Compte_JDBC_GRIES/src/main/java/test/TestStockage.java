package test;

import modele.DAO.ClientSQLiteImpl;
import modele.DAO.CompteSQLiteImpl;
import modele.DAO.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestStockage {
    public static void main(String[] args) {
        String dbFile = "c:\\sqlite\\banque.db";
        ClientSQLiteImpl cl = new ClientSQLiteImpl(dbFile);
        System.out.println(cl.findAll());
        System.out.println(cl.findByName("Chenu"));
        System.out.println(cl.findById("1"));
        CompteSQLiteImpl cpt = new CompteSQLiteImpl(dbFile);
        System.out.println(cpt.findAll());
        System.out.println(cpt.findByNumero("1"));

//        try {
//            Class.forName("org.sqlite.JDBC");
//            String jdbcURL = "jdbc:sqlite:c:\\sqlite\\users.db";
//            Connection con = DriverManager.getConnection(jdbcURL);
//            if (con != null) {
//                System.out.println("Connexion reussie");
//                List<User> listeUser = listAll(con);
//                System.out.println(listeUser);
//            } else {
//                System.out.println("Probleme de connexion");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }

//        Client c1 = new Client("nomClient1", "prenomClient1", "1");
//        Client c2 = new Client("nomClient2", "prenomClient2", "2");
//        Client c3 = new Client("nomClient3", "prenomClient3", "3");
//
//        // stockage client
//        Stockage<String, Client> stockageClient = new Stockage<>();
//        stockageClient.ajouter(c1.getIdentifiant(),c1);
//        stockageClient.ajouter(c2.getIdentifiant(),c2);
//        stockageClient.ajouter(c3.getIdentifiant(),c3);
//        System.out.println(stockageClient.retournerElement(c3.getIdentifiant()));;
//        stockageClient.supprimer(c2.getIdentifiant());
//        System.out.println(stockageClient);
//
//        // stockage compte
//        CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 50.0, 400.0);
//        CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 100.0, 400.0);
//        CompteCourant cc3 = new CompteCourant("CC003", "COMPTE COURANT 3", 200.0, 400.0);
//        Stockage<String, Compte> stockageCompte = new Stockage<>();
//        stockageCompte.ajouter(cc1.getNumero(),cc1);
//        stockageCompte.ajouter(cc2.getNumero(),cc2);
//        stockageCompte.ajouter(cc3.getNumero(),cc3);
//        System.out.println(stockageCompte.retournerElement(cc2.getNumero()));
//        stockageCompte.supprimer(cc3.getNumero());
//        System.out.println(stockageCompte);
    }

    private static List<User> listAll(Connection con) {
        String q = "select * from personnes";
        List<User> res = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(q);
            while (rs.next()) {
                User u = new User();
                u.setFirstName(rs.getString("firstname"));
                u.setLastName(rs.getString("lastname"));
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                String date = rs.getString("birthday");

                SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-dd-MM");
                java.util.Date parsedDate = dbDateFormat.parse(date);

                // Formate la date dans le format "dd-MM-yyyy"
                SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strFormattedDate = desiredDateFormat.format(parsedDate);

                Date formattedDate = desiredDateFormat.parse(strFormattedDate);

                System.out.println(formattedDate);
                u.setBirthday(formattedDate);
                res.add(u);
            }
            rs.close();
            stm.close();
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}