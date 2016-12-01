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
    public ArrayList<Cards> defausse;
    public ArrayList<Cards> tapis;

    public int nbDeCarteRestanteAPiocher;
    public ArrayList<Cards> construc;


    public Deck(){
        this.list=new ArrayList<Cards>();
        this.hand=new ArrayList<Cards>();
        this.defausse=new ArrayList<Cards>();
        this.tapis=new ArrayList<Cards>();
    }

    public void piocher(int nbDeCartePiocher) {
       remplirDeck();
        if (list.size()<nbDeCartePiocher){
            nbDeCarteRestanteAPiocher=nbDeCartePiocher-list.size();
            for (int i=0; i<=list.size();i++){
                hand.add(list.get(0));
                list.remove(0);
            }
            remplirDeck();
            for (int j=0; j<nbDeCarteRestanteAPiocher ; j++) {
                hand.add(list.get(0));
                list.remove(0);
            }
        }else {
            for (int k =0; k<nbDeCartePiocher; k++){
                hand.add(list.get(0));
                list.remove(0);
            }
        }
    }

    public void melange(ArrayList<Cards> idk) {
        shuffle(idk);
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

    public void remplirDeck(){
        if (isListVide()){
            for (int i=0;i<list.size();i++){
                Cards c =defausse.get(i);
                list.add(c);
            }
            defausse.clear();
            melange(list);
        }
    }

    public void piocherMain() {
        piocher(5);
    }

    public void initialiserDeck(){
        for (int i=0;i<8;i++){
            Cards c=new Cards("Apprentis",7,"Héros",1,0,"",0);
            list.add(c);
        }
        for (int j=0;j<2;j++){
            Cards c=new Cards("Milices",3,"Héros",0,1,"",0);
            list.add(c);
        }
        shuffle(list);
    }

    public void afficherLesCartesDansSaMain(){
        for (Cards c : hand) {
            c.print();
        }
    }
}
