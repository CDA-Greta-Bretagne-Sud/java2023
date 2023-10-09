import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Programme principal pour tester les classe génériques
 */
public class Main {
    /**
     * methode principale
     * @param toto  un tableau d'argument
     */
    public static void main(String toto[]) {

        //Appel objet Paire
        Paire<String> p = new Paire<String>("un", "deux");
        System.out.println("valeur de p: premier" + p.getPremier() + " deuxieme:" + p.getSecond());
        Paire<Integer> pi = new Paire<Integer>(1, 2);
        System.out.println("valeur de p: premier" + pi.getPremier() + " deuxieme:" + pi.getSecond());

        List<Paire> listeP= new ArrayList<>();
        Paire<String> pa= new Paire<String>("un", "deux");
        Paire<String> pb= new Paire<String>("tata", "titi");
        Paire<String> pc= new Paire<String>("aaa", "bbbbb");
        listeP.add(pa);
        listeP.add(pb);
        listeP.add(pc);
        System.out.println(listeP.toString());
        //Appel objet PaireE
        List <String> listPe=new ArrayList<>();
        listPe.add("toto");
        listPe.add("titi");
        listPe.add("tata");
        PaireE<Integer> pe1=new PaireE<>(14,listPe);
        System.out.println(pe1);
        System.out.println(listeP.toString());
        Collections.sort(listeP,Util.comparatorPaire);
        System.out.println(listeP.toString());
    }
}
