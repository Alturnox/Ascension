package ascension;

import java.util.ArrayList;

/**
 * Created by nmolle2 on 18/11/16.
 */
public class Joueur {
    public int nbRunesDispo;
    private int degats;
    private int ptsHonneur;
    public int attaqueDispo;
    public String nomJoueur;
    Deck deck;
    public boolean estEntraindeJouer;

    public Joueur(int ptsHonneur) {
        this.ptsHonneur=ptsHonneur;
    }

    public Joueur(String nomJoueur) {
        this.nomJoueur=nomJoueur;
        deck = new Deck();
        deck.initialiserDeck();
        estEntraindeJouer=false;
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
        this.ptsHonneur = ptsHonneurs;
        return this.ptsHonneur;
    }

    public void acquerirUneCarteRunes(Cards c1,Plateau plat) {
        if (c1.getRunes()>0){
            if (nbRunesDispo>=c1.getRunes()){
                this.deck.defausse.add(c1);
                nbRunesDispo-=c1.getRunes();
                plat.remplacerLaLigneCentrale(plat.supprimerCarteCentrale(c1));
            }
        }
    }

    public void tuerUneCarteAvecDeLattaque(Cards c1, Plateau plat, ArrayList<Cards> neant) {
        if (attaqueDispo>=c1.getAttaque() && c1.getAttaque()!=0){
            attaqueDispo-=c1.getAttaque();
            gagnerPointsHonneur(c1.getRecompense());
            neant.add(c1);
            plat.remplirLigneCentrale();

        }
    }

    public void tuerUneCarteAvecDeLattaqueGratuitement(Plateau plateau) {



    }


    public void jouerUneCarte(Cards cards, Plateau plateau){
        deck.tapis.add(cards);
        deck.hand.remove(cards);
        cards.effetDeCarte(cards.getEffet(),this, plateau);

    }

    public void finDuTour(){
        if (deck.tapis.size()>0){
            for (Cards carteF : deck.tapis) {
                deck.defausse.add(carteF);
        }
            deck.defausse.clear();
        }
        attaqueDispo=0;
        nbRunesDispo=0;
        deck.piocherMain();
        estEntraindeJouer=false;
    }

    public void printPtsHonneur(){
        System.out.println(nomJoueur + " nombreDePoints D'Honneur : " + ptsHonneur);
    }

    public int calculerPtsHonneurFinaux() {
        //////////////// vider la défausse et pour chaque carte ajouter pts honneur au pts honneur/////////:
        if (deck.defausse.size()!=0) {
            for (Cards cA : deck.defausse){
                deck.list.add(cA);
            }
        }
        if (deck.hand.size()!=0){
            for (Cards cA : deck.hand){
                deck.list.add(cA);
            }
        }
        for (Cards cards : deck.list){
            ptsHonneur+=cards.getRecompense();
        }
        return  ptsHonneur;
    }


}
