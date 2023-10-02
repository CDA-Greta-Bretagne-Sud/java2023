package ihm;

import projet.GUISite;
import projet.Media;
import projet.Mediatheque;
import projet.Emprunteur;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static util.SaveToFile.writeToFile;

public class GUIRendu implements FormulaireInt {
    private GUISite formPP;
    private Mediatheque m;

    private JList<Emprunteur> listEmprunteurs;
    private JList<Media> listMediasEmpruntes;

    public GUIRendu(GUISite formPP, Mediatheque m) {
        this.formPP = formPP;
        this.m = m;

        JFrame frame = new JFrame("Rendu de Média");
        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 3));

        listEmprunteurs = new JList<>(m.getEmprunteurs().toArray(new Emprunteur[0]));
        listEmprunteurs.addListSelectionListener(e -> updateMediaList());

        listMediasEmpruntes = new JList<>();

        JScrollPane scrollEmprunteurs = new JScrollPane(listEmprunteurs);
        JScrollPane scrollMedias = new JScrollPane(listMediasEmpruntes);

        Button btnRendre = getButton(frame);

        frame.add(scrollEmprunteurs);
        frame.add(scrollMedias);
        frame.add(btnRendre);
        frame.setVisible(true);
    }

    private void updateMediaList() {
        Emprunteur selected = listEmprunteurs.getSelectedValue();
        if (selected != null) {
            listMediasEmpruntes.setListData(selected.getMediaEmpruntes().toArray(new Media[0]));
        }
    }

    private Button getButton(JFrame frame) {
        Button btnRendre = new Button("Rendre le média");
        btnRendre.setSize(new Dimension(100, 30));
        btnRendre.addActionListener(e -> {
            Media selectedMedia = listMediasEmpruntes.getSelectedValue();
            Emprunteur emp = listEmprunteurs.getSelectedValue();
            if (selectedMedia != null) {
                m.rendre(emp, selectedMedia);
                formPP.updateAffMediaInscrits();
                try {
                    writeToFile(m.getEmprunteurs(), m.getMedias(), "data.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame, "Média rendu avec succès !");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un media à rendre !");
            }
        });
        return btnRendre;
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
