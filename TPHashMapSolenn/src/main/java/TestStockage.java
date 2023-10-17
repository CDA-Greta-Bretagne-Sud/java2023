import java.util.concurrent.Callable;

public class TestStockage {

    public static void main(String[] args) throws CompteException {

        Client client1 = new Client("Durant", "Axel", "1");
        Client client2 = new Client("Dupond", "Sophie", "2");
        Client client3 = new Client("XX", "Linda", "3");

        Stockage stockClient = new Stockage<>();

        stockClient.ajouter("1", client1);
        stockClient.ajouter("2", client2);
        stockClient.ajouter("3", client3);
        System.out.println(stockClient.toString());

        Client client = (Client) stockClient.retournerElement("2");
        System.out.println("Le client associé au stockage 2 est " + client.getNom() + " " + client.getPrenom());

        stockClient.supprimer("2");
        System.out.println(stockClient.toString());

        System.out.println();

        CompteCourant cc1 = new CompteCourant("CC001", "COMPTE COURANT 1", 0.0, 400.0);
        CompteCourant cc2 = new CompteCourant("CC002", "COMPTE COURANT 2", 0.0, 400.0);
        CompteEpargne ce1 = new CompteEpargne("CE001", "COMPTE EPARGNE 1", 0.0, 4);

        Stockage stockCompte = new Stockage<>();

        stockCompte.ajouter("1", cc1 );
        stockCompte.ajouter("2", cc2 );
        stockCompte.ajouter("3", ce1 );
        System.out.println(stockCompte.toString());

        Compte compte = (Compte) stockCompte.retournerElement("2");
        System.out.println("Le compte associé au stockage 2 est " + compte.getNumero() + " " + compte.getIntitule() );

        stockCompte.supprimer("2");
        System.out.println(stockCompte.toString());

    }

}
