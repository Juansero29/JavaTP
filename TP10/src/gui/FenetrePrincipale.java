package gui;

import application.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by provot on 14/03/17.
 */
public class FenetrePrincipale extends JFrame implements ActionListener, ListSelectionListener {
    private JTextArea zoneDescription;
    private JList<Recette> listeRecettes;
    private LivreRecettes livreRecettes;

    public FenetrePrincipale(LivreRecettes livre) throws IllegalArgumentException {
        super("Mes Recettes");

        if (livre == null) throw new IllegalArgumentException("Le livre de recettes ne doit pas être null");
        livreRecettes = livre;

        Container mainPane = getContentPane();
        // le contentPane gère le placement de ses composants avec un BorderLayout par défaut
        mainPane.add(creerListeRecettes(),   BorderLayout.LINE_START);
        mainPane.add(creerZoneDescription(), BorderLayout.CENTER);
        mainPane.add(creerPanelBoutons(),    BorderLayout.PAGE_END);

        // pour terminer le programme quand la dernière fenêtre est fermée
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JTextArea creerZoneDescription() {
        zoneDescription = new JTextArea("Veuillez selectionner une recette…");
        zoneDescription.setEditable(false);
        return zoneDescription;
    }

    private JList<Recette> creerListeRecettes() {
        DefaultListModel<Recette> model = new DefaultListModel<>();
        for (Recette r : livreRecettes.getLivre().keySet()) {
            model.addElement(r);
        }
        listeRecettes = new JList<>(model);
        // mise en place du listener permettant de réagir à un changement de selection dans la liste
        listeRecettes.addListSelectionListener(this);
        return listeRecettes;
    }

    private JPanel creerPanelBoutons() {
        JPanel buttonsPanel = new JPanel();
        // le JPanel gère le placement de ses composants avec un FlowLayout par défaut
        buttonsPanel.add(new JButton("Ajouter"));
        JButton boutonQuitter = new JButton("Quitter");
        buttonsPanel.add(boutonQuitter);
        // mise en place du listener permettant de réagir à un clic sur le bouton
        boutonQuitter.addActionListener(this);

        return buttonsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Recette recette = listeRecettes.getModel().getElementAt(listeRecettes.getSelectedIndex());
        zoneDescription.setText("Ingredients :\n");
        zoneDescription.append("----------------------\n");
        for (Ingredient i : livreRecettes.getLivre().get(recette))
            zoneDescription.append(i.toString() + "\n");
        zoneDescription.append("----------------------\n");
        zoneDescription.append(recette.getDescription());
    }


    public static void main(String[] args) {
        LivreRecettes livre = creerLivreRecettes();
        // Swing n'est pas thread safe, il faut donc gérer tout ce
        // qui touche à la partie graphique dans le thread graphique
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame mainWin = new FenetrePrincipale(livre);
                mainWin.pack();
                mainWin.setVisible(true);
            }
        });
    }


    private static LivreRecettes creerLivreRecettes() {
        LivreRecettes bouquin = new LivreRecettes();

        java.util.List<Ingredient> list = new ArrayList<Ingredient>();
        list.add(new Ingredient("poireaux", new Quantite(2f, Unite.UNITE)));
        list.add(new Ingredient("pommes de terre", new Quantite(100, Unite.G)));
        list.add(new Ingredient("pommes de terre", new Quantite(200, Unite.G)));
        list.add(new Ingredient("eau", new Quantite(50, Unite.CL)));
        bouquin.ajouterRecette(new Recette("soupe de poireaux", "Faire cuire les légumes puis mixer."), list);


        list = new ArrayList<Ingredient>();
        list.add(new Ingredient("carottes", new Quantite(1.2f, Unite.KG)));
        list.add(new Ingredient("pommes de terre", new Quantite(500, Unite.G)));
        list.add(new Ingredient("beurre", new Quantite(20, Unite.G)));
        bouquin.ajouterRecette(new Recette("purée de carottes", "Faire cuire les légumes puis écraser et mélanger."), list);

        list = new ArrayList<Ingredient>();
        list.add(new Ingredient("poisson", new Quantite(1f, Unite.KG)));
        list.add(new Ingredient("oeuf", new Quantite(4f, Unite.UNITE)));
        list.add(new Ingredient("bisque de homard", new Quantite(300, Unite.G)));
        list.add(new Ingredient("pincée de noix de muscade", new Quantite(1, Unite.UNITE)));
        bouquin.ajouterRecette(new Recette("pain de Poisson", "Faire cuire les filets de poisson. \n "
                + "Une fois refroidis, les émietter. \n Puis mélanger avec les oeufs et la bisque de homard. \n "
                + "Assaisonner avec la noix de muscade. \n Faire cuire 45 min à 180."), list);


        list = new ArrayList<Ingredient>();
        list.add(new Ingredient("carottes", new Quantite(1.2f, Unite.KG)));
        list.add(new Ingredient("courgette", new Quantite(1f, Unite.KG)));
        list.add(new Ingredient("eau", new Quantite(25, Unite.G)));
        bouquin.ajouterRecette(new Recette("purée de carottes", "Faire cuire les légumes puis écraser et mélanger avec le beurre."), list);

        return bouquin;
    }
}
