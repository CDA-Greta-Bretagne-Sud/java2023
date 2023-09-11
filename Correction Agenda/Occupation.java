public class Occupation {
    static boolean[][] occupee = {{false,true,true,true,false,true,true,false,true,false},
            {false,true,true,true,false,true,true,false,true,false},
            {false,false,true,true,false,false,true,false,true,false},
            {true,true,false,true,false,true,true,false,true,true},
            {false,true,false,true,false,true,true,false,false,false}};

    public static void main(String[]args){

        String[] jours = {"lundi", "mardi", "mercredi", "jeudi", "vendredi"};
        String[] heures = {" de 9h00 à 10h00"," de 10h00 à 11h00"," de 11h00 à 12h00"," de 12h00 à 13h00","de 13h00 à 14h00"," de 14h00 à 15h00"," de 15h00 à 16h00"," de 16h00 à 17h00"," de 17h00 à 18h00"," de 18h00 à 19h00"};
        for (int i=0; i<jours.length; i++){
            for(int j=0;j<heures.length;j++)
                if (occupee[i][j]==true){
                System.out.print("Salle occupée le "+jours[i]+" "+heures[j]);
                System.out.println();
        }
                else{
                    System.out.print("Salle n'est pas occupée le "+jours[i] + " " + heures[j]);
                System.out.println();
                }

            }
        double tauxDoccupation;
        int plages = 0;
        int res=0;
        for (int i = 0; i<5; i++){
            for (int j = 0; j<10; j++){
                plages++;
                if (occupee[i][j] == true){
                    res++;
                }
            }
        }

        tauxDoccupation = (double) res/plages;
        System.out.print("nombre des plages : " + plages);
        System.out.println();
        System.out.print("plages occupee : " + res);
        System.out.println();

        System.out.print("Taux d'occupation est : "+ tauxDoccupation*100 + "%");
    }

}
