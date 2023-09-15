
public class Employetest {

	public static void main(String[] args) {
		Employe e1= new Employe("Brigitte","Macron",new Date(13,4,1953),1001,2.5);
		Employe e2= new Employe("Emmanuel","Macron",new Date(21,12,1977),1002,3.5);
//affichage employe
		System.out.println(e1);
		System.out.println(e2);


		//saisie des responsazbles
		Responsable r1=new Responsable("Chirac","Jacques",new Date(13,4,1943),1003,5.5);
		r1.ajouter(e1);
		r1.ajouter(e2);
		r1.afficherEmploye();
		
		//saisie des commerciaux
		Commercial c1, c2, c3;
		c1 = new Commercial("Jean","Valjean",new Date(13,9,1963),1004,2); 
		c1.enregistreVentes(1200);
		c2 = new Commercial("Bernard","Dupont",new Date(11,3,1973),1005,2); 
		c2.enregistreVentes(1100);
		c3 =  new Commercial("Jacques","Martin",new Date(19,1,1978),1006,2);  
		c3.enregistreVentes(700);
		System.out.println("Liste des commerciaux:");
		Employe[] t1 = {c1, c2, c3};
		afficherTableau(t1);
		}
	public  static void afficherTableau(Employe tab[]) {
		for (int i=0; i <tab.length;i++) {
			System.out.println(tab[i].toString());

			
		}	
	}
		
	}


