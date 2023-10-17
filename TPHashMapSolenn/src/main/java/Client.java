import java.util.ArrayList;
import java.util.List;

public class Client<T> {

    private T nom;
    private T prenom;
    private T identifiant;
    private List<Compte> comptesList = new ArrayList<>();

    public Client(T nom, T prenom, T identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
    }

    // TODO ajoute un compte dans compteList
    public void creerCompte(Compte compte){
        comptesList.add(compte);
    }

    // TODO supprime un compte de compteList
    public void supprimerCompte(Compte compte) {
        comptesList.remove(compte);
    }

    // TODO une méthode qui retourne le premier compte dont le numéro correspond à la chaîne de caractères passée en paramètre
    public Compte retournerCompte(String numero) {
        for (Compte compte : comptesList) {
            if (compte.getNumero().equals(numero)) {
                return compte;
            }
        }
        return null; // Aucun compte trouvé avec le numéro spécifié
    }

    // TODO une méthode qui supprime le premier compte dont le numéro correspond avec la chaîne de caractères passée en paramètre
    public void supprimerCompte(String numero) {
        Compte compteASupprimer = retournerCompte(numero);
        if (compteASupprimer != null) {
            comptesList.remove(compteASupprimer);
            System.out.println("Compte supprimé : " + compteASupprimer);
        } else {
            System.out.println("Aucun compte trouvé avec le numéro " + numero);
        }
    }

    // TODO une méthode qui retourne le solde de l'ensemble des comptes d'un client
    public double calculerAvoirGlobal(){
        double avoirGlobal = 0.0;
        for (Compte compte : comptesList) {
            avoirGlobal = avoirGlobal + compte.getSolde();
        }
        return avoirGlobal;
    }

    public void setNom(T nom) {
        this.nom = nom;
    }

    public void setPrenom(T prenom) {
        this.prenom = prenom;
    }

    public void setIdentifiant(T identifiant) {
        this.identifiant = identifiant;
    }

    public T getNom() {
        return nom;
    }

    public T getPrenom() {
        return prenom;
    }

    public T getIdentifiant() {
        return identifiant;
    }

    public List<Compte> getComptesList() {
        return comptesList;
    }

    public void setComptesList(List<Compte> comptesList) {
        this.comptesList = comptesList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", comptesList=" + comptesList +
                '}';
    }
}
