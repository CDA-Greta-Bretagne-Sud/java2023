import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class CaractereIncorrect extends Exception {

    protected static final Logger logger = (Logger) LogManager.getLogger(Main.class);

    public CaractereIncorrect(String s){
        logger.info("les caractères doivent être compris de a à z");
    }


}
