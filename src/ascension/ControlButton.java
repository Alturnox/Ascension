package ascension;

/**
 * Created by Nathan on 01/12/2016.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by user on 20/05/2016.
 */
public class ControlButton implements ActionListener {
    public Modele m;
    public Vue fen;
    public int indexDelaCarte;
    public int intRetourToucherUneCarte;
    private boolean jeTestJusteUnTruc;


    public ControlButton(Vue fen, Modele m) {
        this.m = m;
        this.fen = fen;
        this.jeTestJusteUnTruc=false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == fen.btnNeant) {
            // afficher le neant
        }
        if (e.getSource() == fen.btnPasser) {
            // Passer le tour du Joueur / fin tour du joueur
            fen.nettoyerTapis();
            fen.nettoyerMain();
            m.finDuTour();
            m.passerTour();
            fen.actualiserJoueur();


        }
        if (e.getSource() == fen.btnDefausse) {
            // afficher la defausse
        }

        if (e.getSource()==fen.btnMystique){
            m.joueurActuel().acquerirUneCarteRunes(m.p.tableauHabitantsR[0],m.p);
            fen.actualiserJ(m.joueurActuel(),m);
        }
        if (e.getSource()==fen.btnInfanteriesLourdes){
            m.joueurActuel().acquerirUneCarteRunes(m.p.tableauHabitantsR[1],m.p);
            fen.actualiserJ(m.joueurActuel(),m);
        }
        if (e.getSource()==fen.btnCultiste){
            // bug
            m.tuerLeCultiste();
            fen.actualiserJ(m.joueurActuel(),m);

        }

        for (ButtonV2 bv2 : fen.listeDeBoutons) {
            if (e.getSource() == bv2) {
//            // Idea : recup l'index, puis le nom de la carte , retourner la le nom de la carte direct pour
              indexDelaCarte=fen.retourneIndexDeLaCarte(bv2);
                m.joueurJoueUneCarte(m.joueurActuel(),m.trouverLaBonneCarte(indexDelaCarte),m.p);
                faireLesEffets(m.joueurActuel(),m.trouverLaBonneCarte(indexDelaCarte),m.p);
                // un test pour supprimer la main
                jeTestJusteUnTruc=true;
                //
                fen.carteJouer(bv2);
                fen.actualiserRunesEtAttaqueJoueur(m.joueurActuel(),m);
                bv2.removeActionListener(this);

            }
        }

        if (jeTestJusteUnTruc==true){
            fen.listeDeBoutons.remove(indexDelaCarte);
            m.joueurActuel().getHand().remove(indexDelaCarte);

            jeTestJusteUnTruc=false;

        }

        for (ButtonV2 bv22 : fen.tableauBtnCentrale) {
            // problememe a resoudre : si la carte n'est pas "achetable" les boutons changet de place
            if (e.getSource() == bv22) {
                // Faut differencier si on veut tuer ou acquerir la carte
                int intRetourner=m.toucherAUneCarteCentraleM(m.trouverLaBonneCarteCentrale(bv22.getIdBouton()),m.p,m.joueurActuel());
                if (intRetourner>0){
                    String nomStocke = m.p.ligneCentrale[bv22.getIdBouton()].getNom() +" r"+m.p.ligneCentrale[bv22.getIdBouton()].getRunes()+ " d"+m.p.ligneCentrale[bv22.getIdBouton()].getAttaque();
                    // fonction tuerUneCartecentrale
                    fen.actualiserLigneCentrale(bv22,nomStocke);
                    fen.actualiserRunesEtAttaqueJoueur(m.joueurActuel(),m);
                    fen.actualiserPtsHonneur(m.joueurActuel(),m);
                }
            }
        }

    }

    public void faireLesEffets(Joueur joueur, Cards cards, Plateau p) {
        // les effets qui sont la influence la vue ou ont besoins d'une interaction avec la vue
        /**liste des effets : 0 1 2  -> piocher 1 2 3 cartes
         * 15 16  tuer un mostre avec 4 ou 6 D gratuitement
         * 17 : bannir une carte centrale
         * 18 : se défausser d'une carte , si on le fait en pioche deux
         * 19 copy l'effet d'un héros jouer ce tour ci
         * 20 : une fois par tour vous piocher une carte
         * 21 System.out.println("You may banish this Construct to take an additional turn after this one.");
         * 22  System.out.println("Acquire a Hero without paying its cost. Place in on top of your deck.");
         * 25 : piocher une carte
         * 26    System.out.println("Once per turn, gain 1 runes, the first time you play a lifebound hero, each turn gain 1 recompense");
         * 27 "Once per turn , gain 1d    "Once per turn, you may spend 4r to gain 3 recompense");
         * 28 : Draw a card
         * 28 : System.out.println("Gain 1d or 1r");
         * 30 : Gain 2r You pay 1R less the next time you acquire a Construc this turn"
         * 31 Once per turn, when you put a Mechana Construc into play (including this one) , draw a card"
         * 32 Once per turn, gain 2d35 : "Once per turn, when you acquire another Mechana Construc, you may put it directly into play
         *.You may spend it only to acquire Mechana Construct");
         * Once per turn ,gain 1 r . you may spend it only to acquire Mechana Construc
         *
         * 37 : "Banish a card in you hand"
         * 38 : "Banish a card in you hand or discard pile"
         * 39 Banish a card in you hand or discard pile
         * 43  Unbanishable You may acquire or defeat any car in the center row without paying its cost"
         * 44 Each opponent must destryo a Construc he controls
         * 45 "Banish a card un the center row and/or in you discard pile"
         * 46 Banish a card un the center row
         * 47 If an opponent has more than one construct, that player must destroy all but one Construct he controls
         * 48 Take a card at random from each oppenent's hand and add that card to your hands
         */
        switch (cards.getEffet()){
            case 0:
                fen.actualiserMain(m);
                break;
            case 1:
                fen.actualiserMain(m);
                break;
            case 2:
                fen.actualiserMain(m);
                break;

        }

    }
}
