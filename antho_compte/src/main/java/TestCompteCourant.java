import java.util.HashMap;

public class TestCompteCourant {
	
	public static void main(String[] args) throws CompteException {
		CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 0.0, 400.0);
		CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 0.0, 400.0);
		CompteCourant cc3 = new CompteCourant("CC003", "COMPTE COURANT 3", -1.0, 400.0);
		
//		System.out.println("Nombre de comptes = " + CompteCourant.getNbCompteCourant());
		
		cc1.crediter(300.0);
		cc1.debiter(150.0);
		
		cc2.crediter(400.0);
		
		try {
			cc3.debiter(100.0);
		} catch(DebitException e) {
			System.out.println(e.getMessage());
		}
		
		CompteCourant[] compteCourantTab = {cc1, cc2, cc3};
		
//		for(CompteCourant cc : compteCourantTab) {
//			System.out.println(cc);
//		}

		System.out.println("---------------------");
		System.out.println("TEST");

		Client client = new Client("010101", "MENDES", "Anthony");
//		client.creerCompte(cc1);
//		client.creerCompte(cc2);
//		client.creerCompte(cc3);
		Compte compte1 = new CompteEpargne("00001", "CompteEpargneAnthony1", 1000, 10) ;
		Compte compte2 = new CompteEpargne("00002", "CompteEpargneAnthony2", 1500, 4) ;
		Compte compte3 = new CompteCourant("00003", "CompteAnthony", 2000, 100) ;

		// Instanciation de la Hasmap
		//HashMap<String, Compte> compteMap = client.getComptesMap();

		client.creerCompte(compte1);
		client.creerCompte(compte2);
		client.creerCompte(compte3);

		System.out.println(compte1);
		System.out.println(compte2);
		System.out.println(compte3);

		System.out.println("---------------------");

		Compte retourClient = client.retournerCompte("00003");
		System.out.println("numero de compte rechercher = 3 : "+retourClient);

		System.out.println("---------------------");

		Double avoirGlobal = client.calculerAvoirGlobal();
		System.out.println("Avoir global de tous les comptes : " +avoirGlobal +"€");
		System.out.println("---------------------");

		try {
			client.supprimerCompte("00004");
			System.out.println("Compte supprimer avec succès");
		} catch(CompteNonTrouveException e) {
			System.out.println(e.getMessage());
		}









	}

}
