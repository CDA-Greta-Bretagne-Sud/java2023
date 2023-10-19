package modele.DAO;

import modele.metier.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> findAll();
    List<Client> findByName(String name);
    Client findById(String id);

    // TODO
    void create(Client client);
    Client findByEmail(String email);
    void update(Client client);
    void delete(Client client);
}
