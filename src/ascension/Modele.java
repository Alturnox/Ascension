package ascension;

import javax.swing.*;

/**
 * Created by Nathan on 01/12/2016.
 */
public class Modele extends JPanel {
    Joueur joueur2;
    Plateau p;
    Joueur joueur;
    int aQuiDeJouer;

    public Modele(){
        p=new Plateau();
        joueur=new Joueur("j1");
        joueur2=new Joueur("j2");
        p.listeDeJoueurs.add(joueur);
        p.listeDeJoueurs.add(joueur2);
        p.quiCommence(p.listeDeJoueurs);
        aQuiDeJouer=0;
        joueurActuel().piocherMain();
        setLayout(null);
    }

    public Cards trouverLaBonneCarte(int indexDelaCarte) {
                return joueurActuel().getCarteJouer(indexDelaCarte);
    }


    public void joueurJoueUneCarte(Joueur j, Cards cards, Plateau p) {
        j.jouerUneCarte(cards,p);
    }

    public Joueur joueurActuel() {return p.listeDeJoueurs.get(aQuiDeJouer);}

    public Cards trouverLaBonneCarteCentrale(int indexDelaCarte) {return p.getCartecentrale(indexDelaCarte);}



    public int toucherAUneCarteCentraleM(Cards cards, Plateau p, Joueur joueur) { return joueur.toucherAUneCarteCentrale(cards,p);}

    public void finDuTour() {

        joueurActuel().finDuTour();
    }

    public void passerTour() {
        System.out.print(aQuiDeJouer);
        if (aQuiDeJouer>=p.listeDeJoueurs.size()-1){
            aQuiDeJouer=0;
            joueurActuel();
        }else {

            joueurActuel();
            aQuiDeJouer+=1;
        }

    }
}
