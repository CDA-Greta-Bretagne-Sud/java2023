import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {

    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);
   public static void main(String []args ){
       logger.info("Lancement du programme");
       logger.debug("Lancement du programme");
   }

}
