package ihm;

import projet.GUISite;
import projet.Media;
import projet.Mediatheque;
import projet.Emprunteur;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

import static util.SaveToFile.writeToFile;
import static util.TTS.speak;

public class GUIEmprunt implements FormulaireInt {
    private GUISite formPP;
    private Mediatheque m;

    private JList<Emprunteur> listEmprunteurs;
    private JList<Media> listMedias;

    public GUIEmprunt(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;

        JFrame frame = new JFrame("Emprunt");
        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

        listEmprunteurs = new JList<>(m.getEmprunteurs().toArray(new Emprunteur[0]));
        listEmprunteurs.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // cette condition empêche la double invocation
                    Emprunteur selectedEmprunteur = listEmprunteurs.getSelectedValue();
                    if (selectedEmprunteur != null) {
                        speak(selectedEmprunteur.toString());
                    }
                }
            }
        });

        listMedias = new JList<>(m.getMedias().toArray(new Media[0]));
        listMedias.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // cette condition empêche la double invocation
                    Media selectedMedia = listMedias.getSelectedValue();
                    if (selectedMedia != null) {
                        speak(selectedMedia.toString());
                    }
                }
            }
        });


        JScrollPane scrollEmprunteurs = new JScrollPane(listEmprunteurs);
        JScrollPane scrollMedias = new JScrollPane(listMedias);

        Button btnValider = getButton(formPP, m, frame);

        frame.add(scrollEmprunteurs);
        frame.add(scrollMedias);
        frame.add(btnValider);
        frame.setVisible(true);
    }


    private Button getButton(GUISite formPP, Mediatheque m, JFrame frame) {
        Button btnValider = new Button("Valider");
        btnValider.setSize(new Dimension(100, 30));
        btnValider.addActionListener(e -> {
            Emprunteur selectedEmprunteur = listEmprunteurs.getSelectedValue();
            Media selectedMedia = listMedias.getSelectedValue();
            speak(selectedMedia.toString());
            speak(selectedEmprunteur.toString());
            if (selectedEmprunteur != null && selectedMedia != null) {
                if (!selectedMedia.isEmprunte()){
                m.emprunter(selectedEmprunteur, selectedMedia);
                formPP.updateAffMediaInscrits();
                try {
                    writeToFile(m.getEmprunteurs(), m.getMedias(), "data.txt");
                    selectedMedia.setEmprunte(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame, "Emprunt validé !");
                frame.dispose();}
                else{
                    JOptionPane.showMessageDialog(frame, "Média déjà emprunté !");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un emprunteur et un media !");
            }
        });
        return btnValider;
    }

    @Override
    public void submit(Formulaire form, String nom) {
    }

    public GUISite getFormPP() {
        return formPP;
    }

    public void setFormPP(GUISite formPP) {
        this.formPP = formPP;
    }

    public Mediatheque getM() {
        return m;
    }

    public void setM(Mediatheque m) {
        this.m = m;
    }
}
