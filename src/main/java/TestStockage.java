public class TestStockage {

    public static void main(String[] args) throws CompteException
    {

        Stockage<String, Client> stockageClients = new Stockage<>();

        Client client1 = new Client("C1", "MENDES", "Anthony");
        Client client2 = new Client("C2", "FROST", "Emma");
        Client client3 = new Client("C3", "BANNER", "Bruce");

        stockageClients.ajouter(client1.getIndentifiant(), client1);
        stockageClients.ajouter(client2.getIndentifiant(), client2);
        stockageClients.ajouter(client3.getIndentifiant(), client3);

        // Affichage de tout les clients
        System.out.println("Liste des clients : ");
        for (Client client : stockageClients.getStockageMap().values()) {
            System.out.println("Client : " + client.getNom() + " " + client.getPrenom());
        }

        // Trouver un client par sa cle
        Client clientTrouve = stockageClients.getElement("C1");
        System.out.println(stockageClients);
        System.out.println("_______________________");
        System.out.println("Client trouve : "+ clientTrouve.getNom() + " " + client1.getPrenom());

        // Supprimer un client
        stockageClients.supprimer("C2");
        System.out.println("_______________________");
        System.out.println("Client supprimer !" + stockageClients.getElement("C2"));

        // Affichage de tout les clients après suppression
        System.out.println("_______________________");
        System.out.println("Liste des clients après suppression du n°2 : ");
        for (Client client : stockageClients.getStockageMap().values()) {
            System.out.println("Client : " + client.getNom() + " " + client.getPrenom());
        }

        Stockage<String, Compte> stockageCompte = new Stockage<>();

        CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 3500.0, 400.0);
        CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 200.0, 400.0);
        CompteEpargne ce1 = new CompteEpargne("CE001", "COMPTE EPARGNE", 200.00, 2.00);

        stockageCompte.ajouter(cc1.getNumero(), cc1);
        stockageCompte.ajouter(cc2.getNumero(), cc2);
        stockageCompte.ajouter(ce1.getNumero(), ce1);

        System.out.println("_______________________");
        System.out.println("_______________________");

        // Affichage de tout les comptes
        System.out.println("Liste des comptes : ");
        for (Compte compte : stockageCompte.getStockageMap().values()) {
            System.out.println("Compte : " + compte.getNumero() + " " + compte.getIntitule());
        }

        // Trouver un compte par sa cle
        Compte compteTrouve = stockageCompte.getElement("CC001");
        System.out.println(stockageCompte);
        System.out.println("_______________________");
        System.out.println("Compte trouvé : "+ compteTrouve.getNumero() + " " + compteTrouve.getIntitule());

        // Supprimer un compte
        stockageCompte.supprimer("CC002");
        System.out.println("_______________________");
        System.out.println("Compte supprmier avec succès !" + stockageCompte.getElement("cc2"));

        // Affichage de tout les clients après suppression
        System.out.println("_______________________");
        System.out.println("Liste des comptes après suppression du n°2 : ");
        for (Compte compte : stockageCompte.getStockageMap().values()) {
            System.out.println("Compte : " + compte.getNumero() + " " + compte.getIntitule());
        }

    }

}


