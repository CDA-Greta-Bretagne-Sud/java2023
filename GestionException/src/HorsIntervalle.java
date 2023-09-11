import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class HorsIntervalle extends Exception {
    private static final Logger logger = (Logger) LogManager.getLogger(HorsIntervalle.class);
    public HorsIntervalle(){
        logger.info("La valeur saisie est hors intervalles!");
    }
}

