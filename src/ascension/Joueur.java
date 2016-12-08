package ascension;

import java.util.ArrayList;

/**
 * Created by nmolle2 on 18/11/16.
 */
public class Joueur {
    public int nbRunesDispo;
    public int degats;
    public int ptsHonneur;
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
        setDegats(0);
        setRunes(0);
        setPtsHonneurs(0);
    }

    public int setRunes(int nbRunesDispo) {
        this.nbRunesDispo = nbRunesDispo;
        return this.nbRunesDispo;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int setPtsHonneurs(int ptsHonneurs) {
        this.ptsHonneur = ptsHonneurs;
        return this.ptsHonneur;
    }

    public int getPtsHonneur() {
        return ptsHonneur;
    }

    public Cards getCarteJouer(int indexDelaCarte) {
        return getHand().get(indexDelaCarte);
    }

    public int getRunes() {return nbRunesDispo;}

    public ArrayList<Cards> getHand(){return deck.getHand();}
    public ArrayList<Cards> getTapis() { return  deck.getTapis();}
    public ArrayList<Cards> getList() { return  deck.getList();}
    public ArrayList<Cards> getDefausse() { return  deck.getDefausse();}
    public ArrayList<Cards> getConstruct() { return  deck.getConstruc();}

    public void gagnerPointsHonneur(int pts) {
        ptsHonneur+=pts;
    }

    public int gagnerDegats(int degats) {
        attaqueDispo+=degats;
        return attaqueDispo;
    }

    public int gagnerRunes(int runes) {
        nbRunesDispo+=runes;
        return nbRunesDispo;
    }


    public int toucherAUneCarteCentrale(Cards c, Plateau plateau){
        if (c.getRunes()==0){
            return tuerUneCarteAvecDeLattaque(c,plateau);

        }else if (c.getAttaque()==0){
            return acquerirUneCarteRunes(c,plateau);
        }else {
            return -1;
        }

    }
    public int acquerirUneCarteRunes(Cards c1,Plateau plat) {
        if (c1.getRunes()>0 && nbRunesDispo>=c1.getRunes()){
            getDefausse().add(c1);
            nbRunesDispo-=c1.getRunes();
            plat.remplacerLaLigneCentrale(plat.supprimerCarteCentrale(c1));
            return 2;

        }
        else return -1;
    }

    public int tuerUneCarteAvecDeLattaque(Cards c1, Plateau plat) {
        if (attaqueDispo>=c1.getAttaque() && c1.getAttaque()!=0){
            attaqueDispo-=c1.getAttaque();
            gagnerPointsHonneur(c1.getRecompense());
            plat.getNeant().add(c1);
            plat.remplirLigneCentrale();
            return 1;

        }
        else return -1;
    }

    public void tuerUneCarteAvecDeLattaqueGratuitement(Plateau plateau){
        // a faire
    }


    public void jouerUneCarte(Cards cards, Plateau plateau){
        getTapis().add(cards);
        cards.effetDeCarte(cards.getEffet(),this, plateau);

    }

    public void piocherMain(){
        deck.piocherMain();
    }




    public void finDuTour(){
        if (getTapis().size()>0){
            for (Cards carteF : getTapis()) {
                getDefausse().add(carteF);
        }
            getDefausse().clear();
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
        if (getDefausse().size()!=0) {
            for (Cards cA : getDefausse()){
                getList().add(cA);
            }
        }
        if (getHand().size()!=0){
            for (Cards cA : getHand()){
                getList().add(cA);
            }
        }
        for (Cards cards : getList()){
            ptsHonneur+=cards.getRecompense();
        }
        return  ptsHonneur;
    }


    public void afficherLesCartesDansSaMain() {
        deck.afficherLesCartesDansSaMain();
    }



}
