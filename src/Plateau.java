import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toString;

/**
 * Created by Nathan on 23/11/2016.
 */
public class Plateau {

    public Cards[] ligneCentrale;
    public Cards c;
    public ArrayList<Cards> neant;
    public ArrayList<Cards> deck;


    public Plateau(){
        ligneCentrale=new Cards[6];
        deck=new ArrayList<Cards>();
        neant=new ArrayList<Cards>();
    }

    public Cards[] faireLaLigneCentrale() {
        for (int i=0; i<6; i++){
            c=deck.get(0);
            deck.remove(0);
            ligneCentrale[i]=c;
        }
        return ligneCentrale;
    }

    public Cards remplacerLaLigneCentrale(int index, Cards carteQuiRemplace) {
        ligneCentrale[index]=carteQuiRemplace;
        return ligneCentrale[index];
    }
}
