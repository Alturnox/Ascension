package ascension;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.shuffle;

/**
 * Created by Nathan on 21/11/2016.
 */
public class Deck extends ArrayList {

    public ArrayList<Cards>list;
    public ArrayList<Cards> hand;


    public Deck(){
        this.list=new ArrayList<Cards>();
        this.hand=new ArrayList<Cards>();
    }

    public void piocher(int nbDeCartePiocher) {
        // pas finis faut copier la carte dans le hand
        if (isListVide()==false){
            for (int i=0;i<nbDeCartePiocher;i++){
                hand.add(list.get(0));
                list.remove(0);
            }
        }


    }

    public void melange() {
        shuffle(this);

    }

    public int tailleMain() {
        return hand.size();
    }

    public int nombreDeCarteDansSonDeck() {
        return list.size();
    }

    public boolean isListVide() {
        if (list.size()==0) return true;
        else return false;
    }

    public void piocherMain() {
        for (int i=0;i<5;i++){
            hand.add(list.get(0));
            list.remove(0);
        }
    }
}
