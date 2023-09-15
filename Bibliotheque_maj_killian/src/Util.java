import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Scanner;

public class Util {
    /**
     * Logger static
     */
   protected static final Logger logger = (Logger) LogManager.getLogger(Main.class);
    /**
     * scanner static
     */
    protected static Scanner scan =
            new Scanner(System.in);
}
