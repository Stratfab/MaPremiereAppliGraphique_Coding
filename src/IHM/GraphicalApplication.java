package IHM;

import object.Biblio;
import object.Livre;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class GraphicalApplication extends JFrame {


    JRadioButton romanBouton;
    JRadioButton magazineBouton;
    JRadioButton mangaBouton;


    public GraphicalApplication() {

        /*********************************************/
        /********* Configuration de la JFrame ********/
        /*********************************************/
        super("L'appli graphique bancale de Fabien");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);

        /********************************************************/
        /********* Instantiation de l'objet Bibliothèque ********/
        /********************************************************/

        Biblio maBiblio = new Biblio();
        /***********************************************************/
        /********* Configuration du JPanel (seconde couche) ********/
        /***********************************************************/
        JPanel container = (JPanel) this.getContentPane();


        /***********************************************************/
        /********* Configuration du Layout (troisième couche) ******/
        /***********************************************************/
        FlowLayout monLayout = new FlowLayout();
        container.setLayout(monLayout);


        /***********************************************************/
        /********* Configuration des Composants (4ème Couches   ****/
        /***********************************************************/

        JLabel labelTitre = new JLabel();
        labelTitre.setText("Titre : ");

        JLabel labelAuteur = new JLabel();
        labelAuteur.setText("Auteur : ");


        JLabel labelAnnee = new JLabel();
        labelAnnee.setText("Année : ");


        JLabel labelEditeur = new JLabel();
        labelEditeur.setText("Editeur : ");


        JLabel labelLangue = new JLabel();
        labelLangue.setText("Langue : ");


        JLabel labelIndiceRef = new JLabel();
        labelIndiceRef.setText("Indice Réference : ");


        JTextField maJTextFieldTitre = new JTextField();
        maJTextFieldTitre.setPreferredSize(new Dimension(60, 25));
        maJTextFieldTitre.setText("");


        JTextField maJTextFieldAuteur = new JTextField();
        maJTextFieldAuteur.setPreferredSize(new Dimension(60, 25));
        maJTextFieldAuteur.setText("");

        JTextField maJTextFieldAnnee = new JTextField();
        maJTextFieldAnnee.setPreferredSize(new Dimension(60, 25));
        maJTextFieldAnnee.setText("");

        JTextField maJTextFieldEditeur = new JTextField();
        maJTextFieldEditeur.setPreferredSize(new Dimension(60, 25));
        maJTextFieldEditeur.setText("");

        JTextField maJTextFieldLangue = new JTextField();
        maJTextFieldLangue.setPreferredSize(new Dimension(60, 25));
        maJTextFieldLangue.setText("");

        JTextField maJTextFieldIndiceRef = new JTextField();
        maJTextFieldIndiceRef.setPreferredSize(new Dimension(60, 25));
        maJTextFieldIndiceRef.setText("");


        JButton monBoutonValider = new JButton();
        monBoutonValider.setToolTipText("Information que va réaliser le boutton");
        monBoutonValider.setText("Valider");


        JButton monBoutonBiblio = new JButton();
        monBoutonBiblio.setText("Biblio");

        JButton monBoutonLetrreA = new JButton();
        monBoutonLetrreA.setText("Première lettre A");

        JButton monBoutonIndiceImpair = new JButton();
        monBoutonIndiceImpair.setText("Indices impairs");

        romanBouton = new JRadioButton("Roman");
        magazineBouton = new JRadioButton("Magazine");
        mangaBouton = new JRadioButton("Manga");

        ButtonGroup genre = new ButtonGroup();
        genre.add(romanBouton);
        genre.add(magazineBouton);
        genre.add(mangaBouton);

        this.add(romanBouton);
        this.add(magazineBouton);
        this.add(mangaBouton);


        JLabel labelCR = new JLabel();

        JLabel labelA = new JLabel();

        JLabel labelImpair = new JLabel();

        /***********************************************************/
        /********* Gestion des actions de l'utilisateurs     ******/
        /***********************************************************/

        //monPremierBoutton.setToolTipText("Ici il faut indiquer ici le titre du livre");
        container.add(labelTitre);
        container.add(maJTextFieldTitre);
        container.add(labelAuteur);
        container.add(maJTextFieldAuteur);
        container.add(labelAnnee);
        container.add(maJTextFieldAnnee);
        container.add(labelEditeur);
        container.add(maJTextFieldEditeur);
        container.add(labelLangue);
        container.add(maJTextFieldLangue);
        container.add(labelIndiceRef);
        container.add(maJTextFieldIndiceRef);
        container.add(monBoutonValider);
        container.add(monBoutonBiblio);
        container.add(monBoutonLetrreA);
        container.add(monBoutonIndiceImpair);

        container.add(labelCR);
        container.add(labelA);
        container.add(labelImpair);


        /***********************************************************/
        /********* Gestion des actions de l'utilisateurs     ******/
        /***********************************************************/

        monBoutonValider.addActionListener(new ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                                   int annee = Integer.parseInt(maJTextFieldAnnee.getText());
                                                   int ref = Integer.parseInt(maJTextFieldIndiceRef.getText());
                                                   createBook(maJTextFieldTitre.getText(), maJTextFieldAuteur.getText(), annee, maJTextFieldEditeur.getText(),
                                                           maJTextFieldLangue.getText(), ref, maBiblio);


                                               }
                                           }
        );
        monBoutonBiblio.addActionListener(new ActionListener() {
                                              public void actionPerformed(ActionEvent e) {
                                                  affichLivreBiblio(maBiblio, labelCR);
                                              }
                                          }
        );

        monBoutonLetrreA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficheLettreA(maBiblio, labelA);

            }
        });

        monBoutonIndiceImpair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficheIndiceImpair(maBiblio, labelImpair);
            }
        });
        /***********************************************************/
        /********* Configuration du Menu de l'application     ******/
        /***********************************************************/

        JMenuBar monMenu = new JMenuBar();
        this.setJMenuBar(monMenu);

        JMenu menuFichier = new JMenu("Fichier");
        monMenu.add(menuFichier);

        JMenuItem subMenuExit = new JMenuItem("Exit");
        JMenuItem subMenuNew = new JMenuItem("Nouveau");

        menuFichier.add(subMenuNew);
        menuFichier.add(subMenuExit);


        JMenu menuEdition = new JMenu("Edition");
        monMenu.add(menuEdition);

        JMenuItem subMenuCopy = new JMenuItem("Copier");
        JMenuItem subMenuPaste = new JMenuItem("Coller");

        menuEdition.add(subMenuCopy);
        menuEdition.add(subMenuPaste);


        /***********************************************************/
        /********* Gestion des actions de l'utilisateurs     ******/
        /***********************************************************/

        subMenuExit.addActionListener(new ActionListener() {
                                          public void actionPerformed(ActionEvent e) {
                                              System.exit(0);
                                          }
                                      }
        );


    }

    private void affichLivreBiblio(Biblio maBiblio, JLabel labelCR) {
        String cr = "";
        for (int i = 0; i < maBiblio.getListDeLivres().size(); i++) {
            cr += maBiblio.getListDeLivres().get(i).getTitre() + " / " + maBiblio.getListDeLivres().get(i).getAuteur() + " / " + maBiblio.getListDeLivres().get(i).getAnnee()
                    + " / " + maBiblio.getListDeLivres().get(i).getEditeur() + " / " + maBiblio.getListDeLivres().get(i).getLangue() + " / " + maBiblio.getListDeLivres().get(i).getIndiceRef() + " ## ";
        }
        labelCR.setText(cr);
    }

    private void createBook(String titre, String auteur, int annee, String editeur, String langue, int indiceRef, Biblio maBiblio) {
        boolean isExist = verifyIndiceRefOfBook(indiceRef, maBiblio.getListDeLivres());
        if (isExist) {
            JOptionPane.showMessageDialog(null, "cette Référence existe déjà", "Erreur de référence livre", JOptionPane.ERROR_MESSAGE);
        } else {
            Livre monLivre = new Livre(titre, auteur, annee, editeur, langue, indiceRef);
            maBiblio.getListDeLivres().add(monLivre);
        }
    }


    private void afficheLettreA(Biblio maBiblio, JLabel labelA) {
        String lettreA = "";
        lettreA += maBiblio.getAllBooksWithNameStartByA();
        labelA.setText(lettreA);
    }


    private void afficheIndiceImpair(Biblio maBiblio, JLabel labelImpair) {
        String impair = "";
        impair += maBiblio.getAllBooksWhithIDSNOdd();
        labelImpair.setText(impair);

    }

    private boolean verifyIndiceRefOfBook(int indiceRef, ArrayList<Livre> listDeLivres) {
        boolean isAlredyExist = false;
        for (int i = 0; i < listDeLivres.size(); i++) {
            Livre livreAVerifier = listDeLivres.get(i);
            if (livreAVerifier.getIndiceRef() == Integer.parseInt(String.valueOf(indiceRef))) {
                isAlredyExist = true;
                return isAlredyExist;
            }

        }
        return isAlredyExist;

    }

   /* public void actionperformed(ActionEvent e) {

        if (romanBouton.isSelected())

        if (magazineBouton.isSelected())

            if (mangaBouton.isSelected())



    }*/
}

