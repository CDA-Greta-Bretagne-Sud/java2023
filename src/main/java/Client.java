import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    private String nom;
    private String prenom;
    private String identifiant;
    private List<Compte> comptesList = new ArrayList();


    private Map<String, Compte> compteMap = new HashMap<>();

    public Client(String nom, String prenom, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        }

    public String getNom() {
        return nom;
    }




    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public List getComptesList() {
        return comptesList;
    }

    public void setComptesList(List comptesList) {
        this.comptesList = comptesList;
    }

    public Map<String, Compte> getCompteMap() {
        return compteMap;
    }

    public void setCompteMap(Map<String, Compte> compteMap) {
        this.compteMap = compteMap;
    }

    public void creerCompte(Compte compte) {
        this.comptesList.add(compte);
    }

    public void supprimerCompte(Compte compte) {
        this.comptesList.remove(compte);
    }

    public void supprimerCompte(String numero) throws CompteNonTrouveException {
        Compte compteASupprimer = null;

        for (Compte compte : comptesList) {
            if (compte.getNumero().equals(numero)) {
                compteASupprimer = compte;
                break;
            }
        }

        if (compteASupprimer != null) {
            comptesList.remove(compteASupprimer);
        } else {
            throw new CompteNonTrouveException("Compte n'existe pas");
        }

    }

    public Compte retournerCompte(String numero) {
        for (Compte comptes : comptesList
        ) {
            if (comptes.getNumero().equals(numero)) {
                return comptes;
            }

        }
        return null;
    }

    public double calculerAvoirGlobal(double a) {
        return a * a;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                '}';
    }
}
