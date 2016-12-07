package ascension;

/**
 * Created by Nathan on 01/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by user on 20/05/2016.
 */
public class ControlButton implements ActionListener {
    public Modele2 m;
    public Vue fen;
    public int indexDelaCarte;


    public ControlButton(Vue fen, Modele2 m) {
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
                System.out.print(bv2.getIdBouton());
//            // joue la carte du joueur
//            // Idea : recup l'index, puis le nom de la carte , retourner la le nom de la carte direct pour
              indexDelaCarte=fen.retourneLenomCarte(bv2);
               m.joueurJoueUneCarte(m.joueur,m.trouverLaBonneCarte(indexDelaCarte),m.p);
                fen.carteJouer(bv2);

            }


        }
    }
}
