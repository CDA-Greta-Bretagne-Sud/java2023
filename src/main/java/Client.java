import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client<T extends Compte> {
    private String nom;
    private String prenom;
    private String indentifiant;
//    private ArrayList<Compte> comptesList;
    private List<T> comptesList;
    private HashMap<String, T> compteMap;

    // Hasmap
//    HashMap<String, Compte> compteMap = new HashMap<>();

    // Constructeur
    public Client(String indentifiant, String nom, String prenom)
    {
        this.indentifiant = indentifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.comptesList = new ArrayList<>();
        this.compteMap = new HashMap<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getIndentifiant() {
        return indentifiant;
    }

    public HashMap<String, T> getCompteMap() {
        return compteMap;
    }

    //    public ArrayList<Compte> getComptesList()
    //    {
    //        return comptesList;
    //    }
    public List<T> getComptesList()
    {
        return comptesList;
    }

    // Création d'un compte
//    public void creerCompte(Compte compte)
//    {
//        comptesList.add(compte);
//    }

    /**
     * Creation compte (mode generic)
     * @param compte
     */
    public void creerCompte(T compte)
    {
        comptesList.add(compte);
        compteMap.put(compte.getNumero(), compte);
    }

    // Renvoyer un compte
//    public Compte retournerCompte(String numero)
//    {
//        Compte compteRetour = null;
//        for(Compte compte : comptesList){ // On parcours tout les comptes
//            if(compte.getNumero().equals(numero)){
//                compteRetour = compte;
//            }
//        }
//        return compteRetour;
//    }

    /**
     * Renvoyer un compte (mode generic)
     * @param numero
     * @throws CompteNonTrouveException
     */
    public T retournerCompte(String numero)
    {
        return compteMap.get(numero);
    }

    // Supprimer un compte
//    public void supprimerCompte(String numero) throws CompteNonTrouveException
//    {
//        Compte compteASupprimer = retournerCompte(numero);
//        if(compteASupprimer != null){
//            comptesList.remove(compteASupprimer);
//        }else{
//            throw new CompteNonTrouveException("Le compte avec le numéro "+numero+" n'existe pas ! ");
//        }
//    }

    /**
     * Supprmier un compte (mode generic)
     * @return
     */
    public void supprimerCompte(String numero) throws CompteNonTrouveException {
        T compteASupprimer = (T) retournerCompte(numero);
        if (compteASupprimer != null) {
            comptesList.remove(compteASupprimer);
            compteMap.remove(numero);
        } else {
            throw new CompteNonTrouveException("Le compte avec le numéro " + numero + " n'existe pas ! ");
        }
    }

    // Calculer un avoir global
//    public double calculerAvoirGlobal()
//    {
//        double avoirTotal = 0.0;
//        for(Compte compte : comptesList){
//            avoirTotal += compte.getSolde();
//        }
//        return avoirTotal;
//    }

    /**
     * Calculer un avoir global (mode generic)
     * @return
     */
    public double calculerAvoirGlobal()
    {
        double avoirTotal = 0.0;
        for(T compte : comptesList){
            avoirTotal += compte.getSolde();
        }
        return avoirTotal;
    }
}
