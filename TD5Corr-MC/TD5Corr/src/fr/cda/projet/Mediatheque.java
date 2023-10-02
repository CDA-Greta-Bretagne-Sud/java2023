package fr.cda.projet;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;
import fr.cda.util.Terminal;

public class Mediatheque {

	private ArrayList<Media> listemedia;
	
	private ArrayList<Emprunteur> listeEmprunteur;
	
    private int compteurMedia;
	public Mediatheque() {
		super();
		this.listemedia = new ArrayList<Media>();
		this.listeEmprunteur = new ArrayList<Emprunteur>();
		this.compteurMedia = 1;
	}
    
    public String ajouterMedia(String categorie,
            String sousCategorie,
            String description){
    	Calendar date= Calendar.getInstance();
    	int annee=date.get(Calendar.YEAR);
    	int mois=date.get(Calendar.MONTH);
    	String ident  = String.format("%d-%d-%d",annee,mois,compteurMedia);
    	 compteurMedia++;
    	  // Cr�ation du m�dia
         Media m = new Media(ident,
                             categorie,
                             sousCategorie,
                             description);
         // Ajout du m�dia dans la collection des m�dias de la m�diath�que
         listemedia.add(m);
         return ident;
    }
    public void ajouterInscrit(Emprunteur e)
    {
        e.setNumero(getNumeroInscrit());
        listeEmprunteur.add(e);
    }
 // Affiche dans la console le contenu de la m�diath�que : 
    //    - la liste des m�dias
    //    - la liste des inscrits
    //
    public String afficher()
    {
    	String res ="";
        res="Les medias de la mediatheque :\n";
        for(Media m:listemedia)
            {
                res+=m.toString()+"\n";
               
            }
        
        res+="Les inscrits de la mediatheque \n:";
        for(Emprunteur e:listeEmprunteur)
            {
        	 res+=e.toString()+"\n";
        	 res+="-------------------------\n";
            }
        return res;
         }
 // Cette m�thode retourne le num�ro d'inscription le plus haut + 1
    // Ce num�ro est utilis� pour inscrire un nouvel emprunteur.
    //
    private int getNumeroInscrit()
    {
        if (listeEmprunteur.size()==0) return 1;


        int max=listeEmprunteur.get(0).getNumero();

        for(Emprunteur e:listeEmprunteur)
            if(e.getNumero()>max)
                max=e.getNumero();
        return max+1;
    }
    
    //=======================================================================
    // M�thode qui permet d'emprunter un media dans la console
    //
    public void emprunterModeConsole()
    {
        // On affiche les emprunteurs en fonction d'un crit�re de recherche sur
        //   le nom ou le pr�nom
        //
        Terminal.ecrireStringln("Choix de l'emprunteur");
        Terminal.ecrireString("Saisir un mot qui est recherch� dans le nom ou le pr�nom (\"exit\" pour arr�ter) : ");
        String mot = Terminal.lireString();
        while (! (mot.equals("exit")))
            {
                for(Emprunteur e:this.listeEmprunteur)
                    {
                        if ( (e.getNom().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                             (e.getPrenom().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                            {
                                Terminal.ecrireStringln(e.toString());
                            }
                    }
                Terminal.ecrireStringln("------------------------------");
                Terminal.ecrireString("Nouvelle recherche: ");
                mot = Terminal.lireString();
            }

        // Demande de saisie du num�ro de l'emprunteur
        //
        Terminal.ecrireString("Numero de l'emprunteur: ");
        int numeroEmprunteur = Terminal.lireInt();

        //On affiche les medias en fonction d'un critere de recherche sur
        //  categorie, sous-cat�gorie ou description
        //
        Terminal.ecrireStringln("Choix du media");
        Terminal.ecrireString("Saisir un mot qui est recherch� dans la categorie, la sous-categorie ou la description (\"exit\" pour arr�ter) : ");
        mot = Terminal.lireString();
        while (! (mot.equals("exit")))
            {
                for(Media e:this.listemedia)
                    {
                        if ( (e.getCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                             (e.getSousCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                             (e.getDescription().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                            {
                                Terminal.ecrireStringln(e.toString());
                            }
                    }
                Terminal.ecrireStringln("------------------------------");
                Terminal.ecrireString("Nouvelle recherche: ");
                mot = Terminal.lireString();
            }

        // Demance de saisie de l'identificateur du media
        //
        Terminal.ecrireString("Identificateur du media : ");
        String identMedia = Terminal.lireString();
        
        // Appel du traitement d'emprunt d'un media par un emprunteur
        emprunter(identMedia,numeroEmprunteur);
        
    }
    // M�thode d'emprunt :
    //   identMedia : identificateur du m�dia devant �tre emprunt�
    //   numeroEmprunteur : num�ro d'inscription de l'emprunteur
    public void emprunter(String identMedia,int numeroEmprunteur)
    {
        // On recherche le m�dia et l'emprunteur
        //
        Media mediaEmprunte = null;
        Emprunteur emprunteur = null;

        Media r = new Media(identMedia);
        int index = listemedia.indexOf(r);
        if (index==-1)
            {
                Terminal.ecrireStringln("********** Ce media " + identMedia + " n'existe pas");
                return;
            }
        else
            {
                mediaEmprunte = listemedia.get(index);
            }
        
        Emprunteur e = new Emprunteur(numeroEmprunteur);
        index = listeEmprunteur.indexOf(e);
        if (index==-1)
            {
                Terminal.ecrireStringln("********** Cet emprunteur " + numeroEmprunteur + " n'existe pas");
                return;
            }
        else
            {
                emprunteur =  listeEmprunteur.get(index);
            }
        
        // Le m�dia est emprunt� par l'emprunteur

        // On renseigne le num�ro de l'emprunteur
        mediaEmprunte.setEmprunteur(numeroEmprunteur);

        // On renseigne la date d'emprunt
        Calendar cal = Calendar.getInstance();
        mediaEmprunte.setDateEmprunt(cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));

        // L'emprunteur a un m�dia de plus emprunt�
        //
        emprunteur.addEmprunt(identMedia);
        
    }
    public String RechercheMedia(String mot) {
    	  
    	String res="";
                  for(Media e:this.listemedia)
                      {
                          if ( (e.getCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                               (e.getSousCategorie().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                               (e.getDescription().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                              {
                                  res+= e.toString();
                              }
                      }
           
    	return res;
    }
    public String RechercheInscrit(String mot) {
    	String res="";
    	 for(Emprunteur e:this.listeEmprunteur)
         {
             if ( (e.getNom().toLowerCase().indexOf(mot.toLowerCase())!=-1) ||
                  (e.getPrenom().toLowerCase().indexOf(mot.toLowerCase())!=-1) )
                 {
                     res+= e.toString();
                 }
         }
    	 return res;
    }
    /**
     * methode pour afficher et selectionner les emprunteurs dans liste
     * @return [] string
     */
    public String [] ListeEmprunteurs() {
    	String [] res=new String[this.listeEmprunteur.size()];
    	int i=0;
    	for(Emprunteur e:this.listeEmprunteur) {
    		res[i]=e.getNumero() +" "+e.getNom() + " " + e.getPrenom();
    		i++;
    	}
    	return  res;
    }
    /**
     * methode pourafficher et  selectionner les medias dans liste
     * @return [] string
     */
    public String [] ListeMedia() {
    	String [] res=new String[this.listemedia.size()];
    	int i=0;
    	for(Media m:this.listemedia) {
    		res[i]=m.getIdentificateur() +" "+m.getCategorie() + " " + m.getSousCategorie()+ " "+m.getDescription();
    		i++;
    	}
    	return  res;
    }

    public void sauverDonnees() throws IOException {
        PrintWriter ecrire;
        File rep = new File("texte");
        rep.mkdir(); // Si le repertoire existe d?j? cette m?thode ne fait rien

        // D�claration du fichier de sortie
        String nomFichierSortie = "texte"+File.separator+"monfichier.dat";

        ecrire =  new PrintWriter(new BufferedWriter
                (new FileWriter(nomFichierSortie)));
        for(Media m:listemedia) {
            ecrire.println(m);
        }
        for(Emprunteur e:listeEmprunteur) {
            ecrire.println(e);
        }
        ecrire.close();
    }

    public String ouvrirFichierTexte() {
        String result = "";
        try {
            // Le fichier d'entr�e
            FileInputStream file = new FileInputStream("texte"+File.separator+"monfichier.dat");
            Scanner scanner = new Scanner(file);

            //renvoie true s'il y a une autre ligne � lire
            while(scanner.hasNextLine()) {
                result+=scanner.nextLine();
                result+= "\n";
            }
            scanner.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return result;
    }

//    public void writeJson() throws IOException {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            ArrayNode mediaArray = mapper.createArrayNode();
//            String file = "texte/fichier.json";
//
//            for(Media m:listemedia) {
//                ObjectNode json = mapper.createObjectNode();
//                json.put("id", m.getIdentificateur());
//                json.put("categorie", m.getCategorie());
//                json.put("sous-categorie", m.getSousCategorie());
//                json.put("description", m.getDescription());
//                json.put("emprunteur", m.getEmprunteur());
//                json.put("date-emprunt", m.getDateEmprunt());
//                mediaArray.add(json); // ajouter json au tableau json des m�dias
//            }
//            String jsonFile = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mediaArray);
//            FileWriter fichier = new FileWriter(file);
//            fichier.write(jsonFile);
//            fichier.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
