package projet;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Mediatheque {
    List<Media> medias = new ArrayList<Media>();
    List<Emprunteur> emprunteurs = new ArrayList<Emprunteur>();

    private int compteurMedia;

    public Mediatheque(List<Media> medias, List<Emprunteur> emprunteurs) {
        this.medias = medias;
        this.emprunteurs = emprunteurs;
    }

    public Mediatheque(List<Media> medias) {
        this.medias = medias;
    }

    public void addEmprunteur(Emprunteur e){
        this.emprunteurs.add(e);
    }
    public void addMedia(Media m){
        this.medias.add(m);
    }
    public void emprunter(Emprunteur emp, Media m){
        List<Media> list = emp.getMediaEmpruntes();
        list.add(m);
        emp.setMediaEmpruntes(list);
    }
    public void rendre(Emprunteur emp, Media m){
        emp.getMediaEmpruntes().remove(m);
        m.setEmprunte(false);
    }
    public ArrayList<Media> rechercheMedia(String str) {
        ArrayList<Media> list = new ArrayList<>();
        for (Media media : this.medias) {
            if (media.getId().contains(str)
                    || media.getCategorie().contains(str)
                    || media.getDescription().contains(str)
                    || media.getSousCategorie().contains(str)) {
                list.add(media);
            }
        }
        return list;
    }
    public void ajouterMedia(Media m){
        this.medias.add(m);
    }
    public void ajouterInscrit(Emprunteur e){
        this.emprunteurs.add(e);
    }

    public int getCompteurMedia() {
        return compteurMedia;
    }

    public void setCompteurMedia(int compteurMedia) {
        this.compteurMedia = compteurMedia;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Emprunteur> getEmprunteurs() {
        return emprunteurs;
    }

    public void setEmprunteurs(List<Emprunteur> emprunteurs) {
        this.emprunteurs = emprunteurs;
    }

    @Override
    public String toString() {
        return "Mediatheque{" +
                "medias=" + medias +
                ", emprunteurs=" + emprunteurs +
                '}';
    }
}
