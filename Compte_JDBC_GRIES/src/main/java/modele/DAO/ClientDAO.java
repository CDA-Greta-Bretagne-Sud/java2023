package modele.DAO;

import modele.metier.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> findAll();
    List<Client> findByName(String name);
    Client findById(String id);
    void create(Client client);
    void update(Client client);
    void delete(Client client);
}