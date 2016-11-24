package ascension;

import ascension.Deck;

import java.util.ArrayList;

/**
 * Created by nmolle2 on 18/11/16.
 */
public class Joueur {
    public int nbRunesDispo;
    private int degats;
    private int ptsHonneur;
    public int attaqueDispo;
    private int ptsHonneurs;
    Deck deck;

    public Joueur(int ptsHonneur) {
        this.ptsHonneur=ptsHonneur;
    }

    public Joueur() {

    }

    public int setRunes(int nbRunesDispo) {
        this.nbRunesDispo = nbRunesDispo;
        return this.nbRunesDispo;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getPtsHonneur() {
        return ptsHonneur;
    }

    public void gagnerPointsHonneur(int pts) {
        this.ptsHonneur=ptsHonneur+pts;
    }

    public int setPtsHonneurs(int ptsHonneurs) {
        this.ptsHonneurs = ptsHonneurs;
        return this.ptsHonneur;
    }

    public boolean acquerirUneCarteRunes(Cards c1, Deck deck) {
        if (c1.getRunes()>0){
            if (nbRunesDispo>=c1.getRunes()){
                this.deck.hand.add(c1);
                nbRunesDispo-=c1.getRunes();
                return true;
            }
            else return false;
        }
        else return false;

    }

    public boolean tuerUneCarteAvecDeLattaque(Cards c1, Cards[] ligneCentrale, ArrayList<Cards> neant) {
        if (attaqueDispo>=c1.getAttaque()){
            attaqueDispo-=c1.getAttaque();
            neant.add(c1);
            return true;
        }
        else return false;

    }
}
