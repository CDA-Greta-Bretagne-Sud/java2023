package modele.DAO;

import modele.metier.Compte;
import modele.metier.CompteCourant;
import modele.metier.CompteEpargne;

import java.util.List;

public interface CompteDAO {
    List<Compte> findAll();
    Compte findByNumero(String numero);
    void createJoint(Compte compte, String idClient1, String idClient2);
    void create(Compte compte, String idClient1);
    void update(Compte compte);
    void delete(Compte compte);
}