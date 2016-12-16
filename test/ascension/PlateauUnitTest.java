package ascension;

import ascension.Plateau;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nathan on 23/11/2016.
 */
public class PlateauUnitTest {

    @Test
    public void testFaireLaLigneCentrale(){

        Plateau p=new Plateau();
        Cards c1=new Cards("c1");
        Cards c2=new Cards("c2");
        Cards c3=new Cards("c3");
        Cards c4=new Cards("c4");
        Cards c5=new Cards("c5");
        Cards c6=new Cards("c6");
        Cards c7=new Cards("c7");

        p.deck.add(c1);
        p.deck.add(c2);
        p.deck.add(c3);
        p.deck.add(c4);
        p.deck.add(c5);
        p.deck.add(c6);
        p.deck.add(c7);
        Cards tab[]=new Cards[6];
        tab[0]=c1;
        tab[1]=c2;
        tab[2]=c3;
        tab[3]=c4;
        tab[4]=c5;
        tab[5]=c6;
        assertArrayEquals(tab, p.faireLaLigneCentrale());

    }

//    @Test
//    public void testRemplacerLaLigneCentrale(){
//        Plateau p=new Plateau();
//        Cards c1=new Cards("c1");
//        Cards c2=new Cards("c2");
//        Cards c3=new Cards("c3");
//        Cards c4=new Cards("c4");
//        Cards c5=new Cards("c5");
//        Cards c6=new Cards("c6");
//        Cards c7=new Cards("c7");
//        p.deck.add(c1);
//        p.deck.add(c2);
//        p.deck.add(c3);
//        p.deck.add(c4);
//        p.deck.add(c5);
//        p.deck.add(c6);
//        p.deck.add(c7);
//        p.faireLaLigneCentrale();
//        Assert.assertEquals(c7,p.remplacerLaLigneCentrale(4));
//    }




}
