
public class Employe extends Constantes{

private String nom;
private String prenom;
private Date dateNais;
private int matricule;
private double indiceSalarial;

public Employe(String nom, String prenom, Date dateNais) {

	this.nom = nom;
	this.prenom = prenom;
	this.dateNais = dateNais;
}
public Employe(String nom, String prenom,Date dateNais,int matricule,double indiceSalarial) {

	this.nom = nom;
	this.prenom = prenom;
	this.dateNais = dateNais;
	this.matricule=matricule;
	this.indiceSalarial=indiceSalarial;

}

public int getMatricule() {
	return matricule;
}
public void setMatricule(int matricule) {
	this.matricule = matricule;
}
public double getIndiceSalarial() {
	return indiceSalarial;
}
public void setIndiceSalarial(double indiceSalarial) {
	this.indiceSalarial = indiceSalarial;
}
public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public Date getDateNais() {
	return dateNais;
}

public void setDateNais(Date dateNais) {
	this.dateNais = dateNais;
}
public double calculSalaire() {
	return BASE_SALAIRE*getIndiceSalarial();
}
@Override
public String toString() {
	return "Employe [Nom=" + getNom() + ", Prenom=" + getPrenom() + ", DateNais=" + getDateNais() + 
			"matricule:"+getMatricule()+ " Indice Salarial:" +getIndiceSalarial()  +"salaire:"+calculSalaire()+ "]";
}




}
