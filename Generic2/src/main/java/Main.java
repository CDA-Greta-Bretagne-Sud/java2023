import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String []tata){

        List<Legume> listeL= new ArrayList<>();
        listeL.add(new Tomate("Tomate Roma","rouge"));
        listeL.add(new Tomate("Tomate Coeur de Boeuf","rouge"));
        listeL.add(new Tomate("Tomate Marmande","jaunez"));
        listeL.add(new Carotte("Carotte Parise","Marché de paris"));
        listeL.add(new Carotte("Carotte Chantenay","Chantenay"));
        Plantation<List<Legume>> pl=new Plantation<List<Legume>>(listeL, "Lycée lesage");
        System.out.println(pl);
        Garage g=new Garage("BMW",200,"Orvault");
        //TODO instanciation de plantation chez BMW
        PlantationG<List<Legume>,Garage> pg=new PlantationG<>(listeL,g);
        System.out.println(pg);

    }
}
