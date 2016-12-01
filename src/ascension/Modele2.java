package ascension;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 01/12/2016.
 */
public class Modele2 extends JPanel {
    Plateau p;
    Joueur j;

    public Modele2(){
        Plateau p=new Plateau();
        Joueur joueur=new Joueur("j1");
        p.listeDeJoueurs.add(joueur);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(36, 111, 497, 86);
        add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
    }
}
