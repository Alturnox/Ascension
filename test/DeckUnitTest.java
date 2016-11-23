import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Nathan on 21/11/2016.
 */
public class DeckUnitTest {
    @Test
    public void testPiocherNombreDeCartesEnMoinsDansLeDeck() {
        Deck deck = new Deck();
        deck.list=new ArrayList<Cards>();
        Cards c1= new Cards("c1");
        Cards c2= new Cards("c2");
        Cards c3= new Cards("c3");
        Cards c4= new Cards("c4");

        deck.list.add(c1);
        deck.list.add(c2);
        deck.list.add(c3);
        deck.list.add(c4);
        Assert.assertTrue(deck.list.size()==4);
        deck.piocher(2);
        Assert.assertTrue(deck.list.size()==2);

    }

    @Test
    public void testPiocherUneCartePiocherVaDansLaMain() {
        Deck deck = new Deck();
        deck.list=new ArrayList<Cards>();
        deck.hand=new ArrayList<Cards>();
        Cards c1= new Cards("c1");
        Cards c2= new Cards("c2");
        Cards c3= new Cards("c3");
        Cards c4= new Cards("c4");

        deck.list.add(c1);
        deck.list.add(c2);
        deck.list.add(c3);
        deck.list.add(c4);

        deck.piocher(1);
        Assert.assertEquals(c1,deck.hand.get(0));

    } @Test
    public void testPiocherDesCartesPiocherVontDansLaMain() {
        Deck deck = new Deck();
        deck.list=new ArrayList<Cards>();
        deck.hand=new ArrayList<Cards>();
        ArrayList<Cards> testArray= new ArrayList<Cards>();

        Cards c1= new Cards("c1");
        Cards c2= new Cards("c2");
        Cards c3= new Cards("c3");
        Cards c4= new Cards("c4");
        Cards c5= new Cards("c5");

        deck.list.add(c1);
        deck.list.add(c2);
        deck.list.add(c3);
        deck.list.add(c4);
        deck.list.add(c5);


        testArray.add(c1);
        testArray.add(c2);
        testArray.add(c3);

        deck.piocher(3);
        Assert.assertEquals(testArray,deck.hand);

    }





    @Test
    public void testMelangerDeck(){
        Deck deck = new Deck();

        Cards c1=new Cards("c1");
        Cards c2=new Cards("c2");
        Cards c3=new Cards("c3");
        Cards c4=new Cards("c4");
        deck.add(c1);
        deck.add(c2);
        deck.add(c3);
        deck.add(c4);

        Deck deck2 = new Deck();
        deck2.add(c1);
        deck2.add(c2);
        deck2.add(c3);
        deck2.add(c4);
        Assert.assertEquals(deck, deck2);
        deck2.melange();
        Assert.assertNotEquals(deck, deck2);


    }

    @Test
    public void testAfficherNombreDeCarteDansSaMain(){
        Deck deck = new Deck();
        deck.hand = new ArrayList<Cards>();

        Cards c1=new Cards("c1");
        Cards c2=new Cards("c2");
        Cards c3=new Cards("c3");
        Cards c4=new Cards("c4");

        deck.hand.add(c1);
        deck.hand.add(c2);
        deck.hand.add(c3);
        deck.hand.add(c4);

        Assert.assertTrue(deck.tailleMain()==deck.hand.size());



    }

    @Test
    public void testAfficherNombreDeRestantDansSonDeck(){
        Deck deck = new Deck();
        deck.list=new ArrayList<Cards>();
        Cards c1=new Cards("c1");
        Cards c2=new Cards("c2");
        Cards c3=new Cards("c3");
        Cards c4=new Cards("c4");
        deck.list.add(c1);
        deck.list.add(c2);
        deck.list.add(c3);
        deck.list.add(c4);

        Assert.assertTrue(deck.nombreDeCarteDansSonDeck()==deck.list.size());



    }




}
