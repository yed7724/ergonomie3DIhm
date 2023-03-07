package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.controler.CtrlConnexion;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.observeurPattern.ObservbleInscriptionConnexion;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurInscription;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitubMainFrame extends JFrame  implements ObservbleInscriptionConnexion {

    protected Set<ObserveurInscription> mObserveurs = new HashSet<ObserveurInscription>();





/**
 * Constructeur.
 */
public TwitubMainFrame() {

    this.setJMenuBar(menu());
    this.setTitle("Twitub");
    this.setSize(300, 200);
    this.setVisible(true);
}

    public JMenuBar menu( ) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Fichier");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Quitter");
        menu.add(menuItem);
        //item quit app
        menuItem.addActionListener(e -> System.exit(0));
        //add icone to menu
        ImageIcon icon = new ImageIcon("src/main/resources/images/exitIcon_20.png");
        menuItem.setIcon(icon);

        JMenu aPropos = new JMenu("?");
        menuBar.add(aPropos);
        //open dialogbox about app
        JMenuItem about = new JMenuItem("A propos");
        aPropos.add(about);
        about.addActionListener(e -> about());

        JMenuItem inscription = new JMenuItem("Inscription");
        aPropos.add(inscription);
        inscription.addActionListener(e -> notifyObservateurInscription());
        JMenuItem connexion = new JMenuItem("Connexion");
        aPropos.add(connexion);
        connexion.addActionListener(e -> notifyObservateurConnexion());

        return menuBar;
    }

    //button open inscription view


    //button open connexion view


     //add dialogbox about app
     public void about() {
         JLabel label = new JLabel("<html><div style='text-align: center;'>UBO M2-TIIL<br/>Département infromatique<br/></div></html>");

         ImageIcon icon = new ImageIcon("src/main/resources/images/logo_50.jpg");

         JOptionPane optionPane = new JOptionPane();
         optionPane.showMessageDialog(null, label, "A propos", JOptionPane.INFORMATION_MESSAGE, icon);
     }

     public void addandvalide(JPanel monPanel) {
         this.add(monPanel);
         this.validate();
     }




    @Override
    public void addObservateur(ObserveurInscription o) {
    mObserveurs.add(o);

    }

    @Override
    public void removeObservateur(ObserveurInscription o) {
    mObserveurs.remove(o);

    }

    @Override
    public void notifyObservateurInscription() {
    for (ObserveurInscription o : mObserveurs) {
        o.updateInscription();
    }

    }

    @Override
    public void notifyObservateurConnexion() {
        for (ObserveurInscription o : mObserveurs) {
            o.updateConnexion();
        }
    }

    @Override
    public void notifyObservateurConnecte() {

    }
}