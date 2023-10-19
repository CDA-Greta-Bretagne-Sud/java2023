public class TestClient {
    public static void main (String []args) throws CompteNonTrouveException {
        Client c1 = new Client("Bon Jovi","John","AK457");
        System.out.println(c1.getComptesList());
        Compte compte1 = new Compte("00001",c1.getNom()+c1.getPrenom(),300.45) {
            @Override
            protected double calculerDebitMaximum() {
                return 400;
            }
        };
        Compte compte2 = new Compte("00002",c1.getNom()+c1.getPrenom(),800.45) {
            @Override
            protected double calculerDebitMaximum() {
                return 400;
            }
        };
        Compte compte3 = new Compte(c1.getNom()+c1.getPrenom(),1200) {
            @Override
            protected double calculerDebitMaximum() {
                return 100;
            }
        };
        c1.setCompteMap(c1.getCompteMap());
        c1.creerCompte(compte1);
        c1.creerCompte(compte2);
        System.out.println(c1.getCompteMap());
    }
}
