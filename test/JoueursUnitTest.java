import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nathan on 21/11/2016.
 */
public class JoueursUnitTest {

    @Test
    public void testGagnerDesPtsHonneurs(){
        Joueur j = new Joueur();
        int i=j.getPtsHonneur();
        j.gagnerPointsHonneur(5);
        Assert.assertTrue(5==j.getPtsHonneur());
    }

    @Test
    public void testNbPtsHonneur(){
        Joueur j = new Joueur(30);
        Assert.assertTrue(j.getPtsHonneur()==30);

    }

    @Test
    public void testPossibleDAcquerirUneCarteAvecDEsRunes(){
        Joueur j = new Joueur(30);
        j.deck = new Deck();
        j.nbRunesDispo=10;
        Cards c1=new Cards(10);
        Assert.assertTrue(j.acquerirUneCarteRunes(c1,j.deck));

    }
    @Test
    public void testPasPossibleDAcquerirUneCarteAvecDEsRunes(){
        Joueur j = new Joueur(30);
        j.nbRunesDispo=9;
        Cards c1=new Cards(10);
        Assert.assertFalse(j.acquerirUneCarteRunes(c1, j.deck));

    }

    @Test
    public void testPasPossibleDAcquerirUneCarteAvecDEsRunesSiElleNenAPas(){
        Joueur j = new Joueur(30);
        j.nbRunesDispo=30;
        Cards c1=new Cards(0);
        Assert.assertFalse(j.acquerirUneCarteRunes(c1, j.deck));

    }@Test
    public void testAcquerirUneCarteDansSaMain(){
        Joueur j = new Joueur(30);
        j.deck=new Deck();
        j.deck.hand=new ArrayList<Cards>();
        j.nbRunesDispo=30;
        Cards c1=new Cards(1);
        j.acquerirUneCarteRunes(c1, j.deck);
        Assert.assertEquals(c1,j.deck.hand.get(0));

    }






}
