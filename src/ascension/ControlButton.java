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


    public ControlButton(Vue fen, Modele m) {
        this.m = m;
        this.fen = fen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == fen.btnNeant) {
            // afficher le neant
        } else if (e.getSource() == fen.btnPasser) {
            // Passer le tour du Joueur / fin tour du joueur
        } else if (e.getSource() == fen.btnDefausse) {
            // afficher la defausse
        }

        for (ButtonV2 bv2 : fen.listeDeBoutons) {
            if (e.getSource() == bv2) {
//            // Idea : recup l'index, puis le nom de la carte , retourner la le nom de la carte direct pour
              indexDelaCarte=fen.retourneIndexDeLaCarte(bv2);
               m.joueurJoueUneCarte(m.joueurActuel(),m.trouverLaBonneCarte(indexDelaCarte),m.p);
                fen.carteJouer(bv2);
                fen.actualiserRunesEtAttaqueJoueur(m.joueurActuel(),m);
                bv2.removeActionListener(this);
            }
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

//        if(e.getSource()==fen.btnPasser){
//            m.finDuTour();
//            fen.clearTapis();
//        }
    }
}
