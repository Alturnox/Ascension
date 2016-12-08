package ascension;

import javax.swing.*;

/**
 * Created by Nathan on 01/12/2016.
 */
public class Modele extends JPanel {
    Plateau p;
    Joueur joueur;

    public Modele(){
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

    public Joueur joueurActuel() {return p.listeDeJoueurs.get(0);}

    public Cards trouverLaBonneCarteCentrale(int indexDelaCarte) {return p.getCartecentrale(indexDelaCarte);}



    public int toucherAUneCarteCentraleM(Cards cards, Plateau p, Joueur joueur) { return joueur.toucherAUneCarteCentrale(cards,p);}
}
