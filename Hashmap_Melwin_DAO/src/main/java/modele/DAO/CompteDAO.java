package modele.DAO;

import modele.metier.Compte;

import java.util.List;

public interface CompteDAO {
    List<Compte> findAll();
    Compte findByNumero(String numero);

    // TODO
//    void create(Client client);
//    Client findByEmail(String email);
//    void update(Client client);
//    void delete(Client client);
}
