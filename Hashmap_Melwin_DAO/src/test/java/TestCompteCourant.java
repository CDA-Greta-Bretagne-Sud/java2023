import modele.metier.*;

import java.util.HashMap;

public class TestCompteCourant {

    public static void main(String[] args) throws CompteException, CompteNonTrouveException {
        CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 0.0, 400.0);
        CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 0.0, 400.0);
        CompteCourant cc3 = new CompteCourant("CC003", "COMPTE COURANT 3", -1.0, 400.0);

        System.out.println("Nombre de comptes = " + CompteCourant.getNbCompteCourant());

        cc1.crediter(300.0);
        cc1.debiter(150.0);

        cc2.crediter(400.0);

        try {
            cc3.debiter(100.0);
        } catch (DebitException e) {
            System.out.println(e.getMessage());
        }

//		CompteCourant[] compteCourantTab = {cc1, cc2, cc3};

//		for(CompteCourant cc : compteCourantTab) {
//			System.out.println(cc);
//		}

        // version List
//		Client client = new Client("nomClient", "prenomClient", "1");
//		client.creerCompte(cc1);
//		client.creerCompte(cc2);
//		client.creerCompte(cc3);
//		List<Compte>compteList = client.getComptesList();
//		System.out.println("Avant suppression par compte : " + compteList);
//		client.supprimerCompte(cc3);
//		System.out.println("Apres suppression par compte : " + compteList);
//		System.out.println("Compte retourne : " + client.retournerCompte("CC002"));
//		client.creerCompte(cc3);
//		System.out.println("Avant suppression par numero : " + compteList);
//		client.supprimerCompte("CC002");
//		System.out.println("Apres suppression par numero : " + compteList);
//		System.out.println("Avoir global avant credit de 200 : " + client.calculerAvoirGlobal());
//		cc3.crediter(200);
//		System.out.println("Avoir global apres credit de 200 : " + client.calculerAvoirGlobal());

//        Client client = new Client("nomClient", "prenomClient", "1");
//        client.creerCompte(cc1);
//        client.creerCompte(cc2);
//        client.creerCompte(cc3);
//        HashMap<String, Compte> compteMap = client.getCompteMap();
//        System.out.println("Avant suppression par compte : " + compteMap);
//        client.supprimerCompte(cc3);
//        System.out.println("Apres suppression par compte : " + compteMap);
//        System.out.println("Compte retourne : " + client.retournerCompte("CC002"));
//        client.creerCompte(cc3);
//        System.out.println("Avant suppression par numero : " + compteMap);
//        client.supprimerCompte("CC002");
//        System.out.println("Apres suppression par numero : " + compteMap);
//        System.out.println("Avoir global avant credit de 200 : " + client.calculerAvoirGlobal());
//        cc3.crediter(200);
//        System.out.println("Avoir global apres credit de 200 : " + client.calculerAvoirGlobal());
//
//        System.out.println("Mauvais numero de compte : ");
//        System.out.println(client.retournerCompte("compteNonTrouve"));

    }

}
