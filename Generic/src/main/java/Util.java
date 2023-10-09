import java.util.Comparator;

public class Util {

    public static Comparator<Paire> comparatorPaire=new Comparator<Paire>() {
        @Override
        public int compare(Paire o1, Paire o2) {
            return o1.getPremier().toString().compareTo(o2.getPremier().toString());

        }
    };
}
