package com.bankonet;

public class TestStockage {

    public static void main(String[] args) throws CompteException {


        Client<String> client1 = new Client<>("Le Mouëllic", "Emmanuel", "0123");
        Client<String> client2 = new Client<>("Dupont Huin", "Nicolas", "0127");
        Client<String> client3 = new Client<>("Mihaljovic", "Miodrag", "0131");

        // Instanciation de la classe Stockage pour relier les clients à leur compte
        Stockage<String, Compte> stockage = new Stockage<>();



        CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 0.0, 400.0);
        CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 0.0, 400.0);
        CompteEpargne cc3 = new CompteEpargne("CC001", "COMPTE EPARGNE 1", 1500, 3);

        stockage.ajouter(client1.getIdentifiant(),cc1 );
        stockage.ajouter(client2.getIdentifiant(),cc2 );
        stockage.ajouter(client3.getIdentifiant(),cc3 );

        // retourner le stockage par identifiant client
        String cleRecherche = client1.getIdentifiant();
        Compte compteRecherche = stockage.retournerElement(cleRecherche);

        if (compteRecherche != null) {
            System.out.println("Compte trouvé : " + compteRecherche);
        } else {
            System.out.println("Compte non trouvé pour la clé " + cleRecherche);
        }




    }

}
