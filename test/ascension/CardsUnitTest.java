package ascension;

import ascension.Joueur;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by nmolle2 on 14/11/16.
 */
public class CardsUnitTest {


    @Test
    public void testEstDeType(){
        Cards card = new Cards("toto");
        Assert.assertTrue("évents",card.estDetype("évents"));
        assertFalse("évents",card.estDetype("events"));
        assertTrue("Héros",card.estDetype("Héros"));
        assertTrue("Monstre",card.estDetype("Monstre"));
        assertTrue("Artéfact",card.estDetype("Artéfact"));


    }

    @Test
    public void testNom(){
        Cards card = new Cards("azer", "La description de la carte", 2,2);
        Assert.assertEquals(card.getNom(),"azer");

    }
    @Test
    public void testDescription(){
        Cards card = new Cards("azer","La description de la carte", 2,1);
        Assert.assertEquals(card.getDescription(),"La description de la carte");
    }

    @Test
    public void testNombreDeRunes() {
        Cards cards = new Cards("azer", "des", 2,1);
        Assert.assertTrue(2 == cards.getRunes());
    }

    @Test
    public void testAttaque(){
        Cards cards = new Cards("azer","des", 2, 0);
        Assert.assertTrue(0==cards.getAttaque());
    }

    @Test
    public void testGagnerDesRunes(){
        Cards cards = new Cards(5,"évents");
        Joueur joueur= new Joueur("j1");
        joueur.setRunes(5);
//        int i=joueur.nbRunesDispo;
// en gros il faut tester les ruens au début + les runes ajouter = runes total
        Assert.assertTrue(joueur.nbRunesDispo+5==cards.gagnerDesRunes(joueur,5));
    }

    @Test
    public void testGagnerDesDegats(){
        Cards cards = new Cards(7,"évents");
        Joueur joueur= new Joueur("j1");
        joueur.setDegats(5);
        Assert.assertTrue(joueur.attaqueDispo+5==cards.gagnerDesDegats(joueur,5));
    }







}
