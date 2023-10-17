package com.bankonet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Client<T> {

    private String nom;
    private String prenom;
    private String identifiant;

    private ArrayList<Compte> comptesList;
private HashMap<String, Compte> compteMap;

    public Client(String nom, String prenom, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.comptesList = new ArrayList<Compte>();
        this.compteMap = new HashMap<>();
    }


    public HashMap<String, Compte> getComptesList() {
        return compteMap;
    }

    public void creerCompte(Compte compte) {
        comptesList.add(compte);
    }

    public void supprimerCompte(Compte compte) {
        comptesList.remove(compte);
    }

    public Compte retournerCompte(String numero) throws CompteNonTrouveException {
        for (Compte compte : comptesList){
            if (Objects.equals(compte.getNumero(), numero)){
                return compte;
            }
        }
        throw new CompteNonTrouveException("Compte inexistant");
    }

    public void supprimerCompte(String numero) throws CompteNonTrouveException{
        Compte supprimerCompte = retournerCompte(numero);
        comptesList.remove(supprimerCompte);

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", comptesList=" + comptesList +
                '}';
    }
}
