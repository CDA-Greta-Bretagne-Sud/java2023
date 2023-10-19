package modele.DAO;

import modele.metier.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientSQLiteImpl implements ClientDAO {

    private Connection connection;

    public ClientSQLiteImpl(String dbfile) {
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
    public List<Client> findAll() {
        String q = "select * from client";
        List<Client> res = new ArrayList<>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(q);
            while (rs.next()) {
                Client client = new Client();
                client.setIdentifiant(rs.getString("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                res.add(client);
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public List<Client> findByName(String name) {
        String q = "select * from client where nom=?";
        List<Client> listeClient = new ArrayList<>();
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.setString(1,name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setIdentifiant(rs.getString("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                listeClient.add(client);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeClient;
    }

    @Override
    public Client findById(String id) {
        String q = "select * from client where id=?";
        Client client = new Client();
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.setString(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                client.setIdentifiant(rs.getString("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return client;
    }

    @Override
    public void create(Client client) {

    }

    @Override
    public Client findByEmail(String email) {
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

}
