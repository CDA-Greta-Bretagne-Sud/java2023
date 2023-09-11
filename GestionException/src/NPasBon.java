import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class NPasBon extends Exception {
    private static final Logger logger = (Logger) LogManager.getLogger(NPasBon.class);
    public NPasBon(){
        logger.info("La valeur saisi n'est pas correcte!");
    }
}
