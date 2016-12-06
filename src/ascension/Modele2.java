package ascension;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 01/12/2016.
 */
public class Modele2 extends JPanel {
    Plateau p;
    Joueur joueur;

    public Modele2(){
        p=new Plateau();
        joueur=new Joueur("j1");
        p.listeDeJoueurs.add(joueur);
        p.quiCommence(p.listeDeJoueurs);
        joueur.piocherMain();
        setLayout(null);

    }

    public Cards trouverLaBonneCarte(int indexDelaCarte) {
                return joueur.getCarteJouer(indexDelaCarte);
    }


    public void joueurJoueUneCarte(Joueur j, Cards cards, Plateau p) {
        j.jouerUneCarte(cards,p);
    }

    public Joueur joueurActuel() {
        return p.listeDeJoueurs.get(0);
    }
}
