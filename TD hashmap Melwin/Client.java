package com.bankonet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    private String nom;
    private String prenom;
    private String identifiant;
    private List<Compte> compteList = new ArrayList<>();
    HashMap<String, Compte> compteMap = new HashMap<>();

    public Client(String nom, String prenom, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
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

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public List<Compte> getComptesList() {
        return compteList;
    }

    public void setComptesList(List<Compte> comptesList) {
        this.compteList = comptesList;
    }

    public HashMap<String, Compte> getCompteMap() {
        return compteMap;
    }

    public void creerCompte(Compte compte) {
//        compteList.add(compte);
        compteMap.put(compte.getNumero(), compte);
    }

    public void supprimerCompte(Compte compte) {
//        compteList.remove(compte);
        compteMap.remove(compte.getNumero());
    }

    public Compte retournerCompte(String numero) throws CompteNonTrouveException {
//        Compte compte = null;
//        for (Compte c : compteList) {
//            if (numero.equals(c.getNumero())) {
//                compte = c;
//            }
//        }
//        if (compte == null) {
//            throw new CompteNonTrouveException("Aucun compte n'a été trouvé avec ce numéro de compte.");
//        }
//        return compte;
        Compte compte = compteMap.get(numero);
        if (compte == null) {
            throw new CompteNonTrouveException("Aucun compte n'a ete trouve avec ce numero de compte");
        }
        return compte;
    }

    public void supprimerCompte(String numero) throws CompteNonTrouveException {
//        supprimerCompte(retournerCompte(numero));
        compteMap.remove(numero);
    }

    public double calculerAvoirGlobal() {
        double res = 0;
//        for (Compte c : compteList) {
//            res += c.getSolde();
//        }
//        return res;
        for (Compte value : compteMap.values()) {
            res += value.getSolde();
        }
        return res;
    }
}
