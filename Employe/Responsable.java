
public class Responsable extends Employe {
	
	private Employe listeEmploye[]=new Employe[LISTE_EMPLOYE_RESP];
	private int nbEmploye=0;

	public Responsable(String nom, String prenom, Date dateNais) {
		super(nom, prenom, dateNais);
	
	}

	public Responsable(String nom, String prenom, Date dateNais, int matricule, double indiceSalarial) {
		super(nom, prenom, dateNais, matricule, indiceSalarial);
		
	}
	void afficherEmploye(){
		System.out.println("Liste Employe du responsable "+ super.toString());
		for (int i = 0; i<this.listeEmploye.length; i++){ 
			
			if(this.listeEmploye[i]!=null) {
			System.out.println(this.listeEmploye[i].toString());
			}
		}
		}
		void ajouter(Employe e ){
			this.listeEmploye[this.nbEmploye] = e; 
			this.nbEmploye++;
		}
		

}
