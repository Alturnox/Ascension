package ascension;

import ascension.Deck;
import ascension.Joueur;
import ascension.Plateau;
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
        Joueur j = new Joueur("j1");
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
        Plateau plateau=new Plateau();
        j.deck = new Deck();
        j.nbRunesDispo=10;
        Cards c1=new Cards(10,0);

    }
    @Test
    public void testPasPossibleDAcquerirUneCarteAvecDEsRunes(){
        Plateau plateau=new Plateau();

        Joueur j = new Joueur(30);
        j.nbRunesDispo=9;
        Cards c1=new Cards(10,0);

    }

    @Test
    public void testPasPossibleDAcquerirUneCarteAvecDEsRunesSiElleNenAPas(){
        Plateau plateau=new Plateau();

        Joueur j = new Joueur(30);
        j.nbRunesDispo=30;
        Cards c1=new Cards(0,10);

    }

    @Test
    public void testAcquerirUneCarteDansSaMain(){
        Joueur j = new Joueur(30);
        Plateau plateau=new Plateau();

        j.deck=new Deck();
        j.deck.hand=new ArrayList<Cards>();
        j.nbRunesDispo=30;
        Cards c1=new Cards(1,0);
        j.acquerirUneCarteRunes(c1,plateau);
        Assert.assertEquals(c1,j.deck.hand.get(0));

    }

    @Test
    public void testAcquerirUneCarteDansSaMainEtPerdreDesRunes(){
        Joueur j = new Joueur(30);
        Plateau plateau=new Plateau();

        j.deck=new Deck();
        j.deck.hand=new ArrayList<Cards>();
        j.nbRunesDispo=30;
        Cards c1=new Cards(1,0);
        j.acquerirUneCarteRunes(c1,plateau);
        Assert.assertTrue(j.nbRunesDispo==30-c1.getRunes());

    }

    @Test
    public void testPossibleDeTuerUneCarteAvecDeLattaque(){
        Joueur j = new Joueur(30);
        j.deck = new Deck();
        Plateau p=new Plateau();
        j.attaqueDispo=10;
        Cards c1=new Cards(0,10);

    }

    @Test
    public void testPasPossibleDeTuerUneCarteAvecDeLattaque(){
        Joueur j = new Joueur(30);
        j.deck=new Deck();
        Plateau p=new Plateau();
        j.attaqueDispo=10;
        Cards c1=new Cards(0,11);

    }

    @Test
    public void testTuerUneCarteAvecDeLattaqueEtEllePartAuNeant(){
        Joueur j = new Joueur(30);
        Plateau p=new Plateau();
        j.attaqueDispo=30;
        Cards c1=new Cards(0,10);
        Assert.assertEquals(p.neant.get(p.neant.size()-1),c1);

        Cards c2=new Cards(0,2);
        Assert.assertEquals(p.neant.get(p.neant.size()-1),c2);

    }

    @Test
    public void testTuerUneCarteAvecDeLattaqueEtEnPerdre(){
        Joueur j = new Joueur(30);
        Plateau p=new Plateau();
        j.attaqueDispo=30;
        int i=j.attaqueDispo;
        Cards c1=new Cards(0,10);
        j.tuerUneCarteAvecDeLattaque(c1,p,p.neant);
        Assert.assertTrue(i-c1.getAttaque()==j.attaqueDispo);

    }








}
