package com.bankonet;

public class TestCompteCourant {
	
	public static void main(String[] args) throws CompteException {
		Client<String> client1 = new Client<>("Le Mouëllic", "Emmanuel", "0123");
		Client<String> client2 = new Client<>("Dupont Huin", "Nicolas", "0127");
		Client<String> client3 = new Client<>("Mihaljovic", "Miodrag", "0131");

		CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 0.0, 400.0);
		CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 0.0, 400.0);
		CompteCourant cc3 = new CompteCourant("CC003", "COMPTE COURANT 3", 1.0, 400.0);

		client1.creerCompte(cc1);
		client2.creerCompte(cc2);
		client3.creerCompte(cc3);
		System.out.println("Nombre de comptes = " + CompteCourant.getNbCompteCourant());

		
		cc1.crediter(300.0);
		cc1.debiter(150.0);
		
		cc2.crediter(400.0);
		
		try {
			cc3.debiter(1000.0);
		} catch(DebitException e) {
			System.out.println(e.getMessage());
		}
		
		Client[] clients = {client1, client2, client3};
		CompteCourant[] compteCourantTab = {cc1, cc2, cc3};

		for (Client client : clients){
			System.out.println(client);
		}
		for(CompteCourant cc : compteCourantTab) {
			System.out.println(cc);
		}






	}

}
