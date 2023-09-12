import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {

    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Lancement du programme");
        logger.debug("Lancement du programme");
        String[] st1 = {"Partir loin", "Rester au lit", "Se lever"};
        String[] st2 = {"Rouge", "Vert", "Bleu", "Jaune", "Violet"};
        String[] st3 = {"Canard", "Poule", "Pintade", "Oie", "Dinde",
                "Corbeau"};

        Menu[] mt = new Menu[3];
        boolean saisieOk;
        try {
            mt[0] = new Menu("Que voulez-vous faire? ", st1);
            mt[1] = new Menu("Quelle est votre couleur préférée?", st2);
            mt[2] = new Menu("Trouvez l’intrus.", st3);
        } catch (NPasBon ex) {
            logger.info("NPASBON :"+ex);
        }
        for (int i = 0; i < 5; i++) {
            do {
                try {
                    saisieOk = true;
                    mt[i % 3].executerMenu();
                } catch (HorsIntervalle ex) {
                    System.out.print("Vous devez entrer un");
                    System.out.println(" des choix proposés.");
                    logger.info("HorsIntervalle:"+ex);
                    saisieOk = false;
                } catch (PasNombre ex) {
                    System.out.println("Vous devez entrer un nombre.");
                    logger.info("PasNombre:"+ex);
                    saisieOk = false;
                }
            } while (!saisieOk);
        }
    }


}


