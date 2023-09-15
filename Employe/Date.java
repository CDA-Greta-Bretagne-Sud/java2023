
public class Date {

private	int jour;
private	int mois;
private	int annee;
private int heure;
private int min;
	


public Date(int jour, int mois, int annee,int h, int m) {

	this.jour = jour;
	this.mois = mois;
	this.annee = annee;
	this.heure=h;
	this.min=m;
}
public Date(int jour, int mois, int annee) {

	this.jour = jour;
	this.mois = mois;
	this.annee = annee;

}
public Date( int mois, int annee) {


	this.mois = mois;
	this.annee = annee;
}
public Date(  int annee) {


	this.annee = annee;
}
public Date() {

}

 public int getJour() {
		return jour;
	}


public void setJour(int jour) {
		this.jour = jour;
	}

public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}


public String afficherDate() {
	 return(this.jour +"/"+this.mois+"/"+this.annee + " " + this.heure+":"+this.min);
 }
 
 

 
 public int getHeure() {
	return heure;
}
public void setHeure(int heure) {
	this.heure = heure;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
@Override
public String toString() {
	
	if(this.heure>0) {
	 return "Date : "+getJour() + "-" + getMois() + "-" + getAnnee() + " " + this.heure+":"+this.min;
	}
	return "Date : "+getJour() + "-" + getMois() + "-" + getAnnee() ;
}
 
 
 
 
 
 
 
 
 
 
public static boolean bissextile(int a ){
	 return ((a%4==0) && (!(a%100 ==0) || a%400==0));
	 
 }
 public static int longueur(int m , int a ){
 if (m == 1 || m== 3 || m==5 ||m== 7 || m==8|| m==10 || m== 12){
	 return 31;
	 } 
 else if (m==2) {
 if ( bissextile(a)){
	 return 29;
	 } 
 else {
	 return 28;
	 }
 }
  else {
	  return 30;
	  }
 }
}
