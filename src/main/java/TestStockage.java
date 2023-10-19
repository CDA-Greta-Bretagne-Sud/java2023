

public class TestStockage {
    public static void main(String[] args) {
        // Créer trois clients
        Client client1 = new Client("Jean", "Valjean", "1JV");
        Client client2 = new Client("Brigitte", "Bardot", "2BB");
        Client client3 = new Client("Manu", "Macron", "3EM");

        // Créer un stockage dédié aux clients
        Stockage<String, Client> stockageClients = new Stockage<>();

        // Ajouter les clients au stockage
        stockageClients.ajouter(client1.getIdentifiant(), client1);
        stockageClients.ajouter(client2.getIdentifiant(), client2);
        stockageClients.ajouter(client3.getIdentifiant(), client3);

        System.out.println("Client avec identifiant '1JV':");
        Client clientRetourne = stockageClients.retournerElement("1JV");
        System.out.println(clientRetourne.getNom() + " " + clientRetourne.getPrenom());
        stockageClients.supprimer("1JV");
        System.out.println(stockageClients.retournerElement("1JV"));

        // Créer trois comptes
        Compte compte1 = new CompteCourant("CC1", "Jean Premier", 1000.0, 1000);
        Compte compte2 = new CompteCourant("CC2", "Florence la Premiere", 2000.0, 2000);
        Compte compte3 = new CompteEpargne("E1", "Jean_Louis" ,5000.0, 0.05);

        Stockage<String, Compte> stockageComptes = new Stockage<>();

        // Ajouter les comptes au stockage
        stockageComptes.ajouter(compte1.getNumero(), compte1);
        stockageComptes.ajouter(compte2.getNumero(), compte2);
        stockageComptes.ajouter(compte3.getNumero(), compte3);

        System.out.println("\nCompte avec numéro 'CC1':");
        Compte compteRetourne = stockageComptes.retournerElement("CC1");
        System.out.println(compteRetourne);

        System.out.println("Suppression du compte avec numéro 'CC2'");
        stockageComptes.supprimer("CC2");
        System.out.println(stockageComptes.retournerElement("CC2"));


    }
}