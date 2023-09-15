
public class Commercial extends Employe {
	int venteDuMois; 
	public Commercial(String nom, String prenom, Date dateNais) {
		super(nom, prenom, dateNais);
		// TODO Auto-generated constructor stub
	}

	public Commercial(String nom, String prenom, Date dateNais, int matricule, double indiceSalarial) {
		super(nom, prenom, dateNais, matricule, indiceSalarial);
		// TODO Auto-generated constructor stub
	}

		public void enregistreVentes(int i){ 
			venteDuMois = i;
		}
		public double calculSalaire(){
		return (getIndiceSalarial() *VALEUR_SMIC)+(this.venteDuMois/10);
		}
}
