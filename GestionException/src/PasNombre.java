import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PasNombre extends Exception {
    private static final Logger logger = (Logger) LogManager.getLogger(PasNombre.class);
    public PasNombre(){
        logger.info("La valeur saisie doit être un nombre!");
    }
}
