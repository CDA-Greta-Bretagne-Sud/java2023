package modele.metier;

import java.util.Date;
import java.util.HashMap;

public class Client {
    private String nom;
    private String prenom;
    private String identifiant;
//    List<metier.Compte> compteList = new ArrayList<>();
    // Key, Value
//    HashMap<String, Compte> compteHashMap = new HashMap<>();

    public Client(String identifiant, String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(){}

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

//    public HashMap<String, Compte> getCompteHashMap() {
//        return compteHashMap;
//    }
//
//    public void setCompteHashMap(HashMap<String, Compte> compteHashMap) {
//        this.compteHashMap = compteHashMap;
//    }
//
//    public void creerCompte(Compte compte) {
//        compteHashMap.put(compte.getNumero(), compte);
//    }
//
//    public void supprimerCompte(Compte compte) {
//        compteHashMap.remove(compte.getNumero());
//    }
//
//    public void supprimerCompteNum(String numero) throws CompteException.CompteNomTrouveException {
//        compteHashMap.remove(numero);
//    }
//
//    public Compte retournerCompte(String numero) {
//        Compte res = compteHashMap.get(numero);
//        if(res == null) {
//            System.out.println("metier.Compte non trouvé");
//        }
//        return res;
//    }
//
//    public double calculerAvoirGlobal() {
//        double res = 0;
//        for (Compte compte : compteHashMap.values()) {
//            res += compte.getSolde();
//        }
//        return res;
//    }


//    public List<metier.Compte> getCompteList() {
//        return compteList;
//    }
//
//    public void setCompteList(List<metier.Compte> compteList) {
//        this.compteList = compteList;
//    }
//
//    public void creerCompte(metier.Compte compte) {
//        compteList.add(compte);
//    }
//
//    public void supprimerCompte(metier.Compte compte) {
//        compteList.remove(compte);
//    }
//
//    public metier.Compte retournerCompte(String numero) throws metier.CompteException {
//        metier.Compte res = null;
//        for (metier.Compte compte : compteList) {
//            if (compte.getNumero().equalsIgnoreCase(numero)) {
//                res = compte;
//            }
//        }
//        if(res == null) {
//            System.out.println("metier.Compte non trouvé");
//        }
//        return res;
//    }
//
//    public void supprimerCompteNum(String numero) throws metier.CompteException {
//        metier.Compte res = retournerCompte(numero);
//        compteList.remove(res);
//    }
//
//    public double calculerAvoirGlobal() {
//        double res = 0;
//        for(metier.Compte compte : compteList) {
//            res += compte.getSolde();
//        }
//        return res;
//    }
//

    @Override
    public String toString() {
        return "metier.Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
//                ", compteHashMap=" + compteHashMap +
                '}';
    }
}
