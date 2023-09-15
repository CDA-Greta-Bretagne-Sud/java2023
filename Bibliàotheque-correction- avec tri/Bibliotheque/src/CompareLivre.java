import java.util.Comparator;

public abstract class CompareLivre implements Comparator<Livre> {
    /**
     * Comparator pour faire un tri par titre
     */
    public static Comparator<Livre> TitreComparator = new Comparator<Livre>() {

        @Override
        public int compare(Livre l1, Livre l2) {
            boolean nullFirst = true;

            if (l1 == null) {
                return (l1 == null) ? 0 : (nullFirst ? -1 : 1);
            } else if (l2 == null) {
                return nullFirst ? 1 : -1;
            } else {
                return l1.getTitre().compareTo(l2.getTitre());
            }
        }
    };
        public static Comparator<Livre> AuteurComparator = new Comparator<Livre>() {

            @Override
            public int compare(Livre l1, Livre l2) {
                boolean nullFirst = true;

                if (l1 == null) {
                    return (l1 == null) ? 0 : (nullFirst ? -1 : 1);
                } else if (l2 == null) {
                    return nullFirst ? 1 : -1;
                } else {
                    return l1.getAuteur().compareTo(l2.getAuteur());
                }
            }
        };
        public static Comparator<Livre> EditeurComparator = new Comparator<Livre>() {

            @Override
            public int compare(Livre l1, Livre l2) {
                boolean nullFirst = true;

                if (l1 == null) {
                    return (l1 == null) ? 0 : (nullFirst ? -1 : 1);
                } else if (l2 == null) {
                    return nullFirst ? 1 : -1;
                } else {
                    return l1.getEditeur().compareTo(l2.getEditeur());
                }
            }
        };

    }
