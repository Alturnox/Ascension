/**
 * Created by nmolle2 on 14/11/16.
 */
public class Cards {
    Joueur j;
    private String effet;
    private String description;
    private String nom;
    private String[] tabtype = new String[] {"évents","Monstre","Héros","Artéfact"};
    private String type;
    private int runes;

    private int attaque;

    public Cards(String nom, String description, int rune, int attaque) {
        this.nom=nom;
        this.description=description;
        this.runes=rune;
        this.attaque=attaque;
    }

    public Cards(String effet, String type) {
        this.effet=effet;
        estDetype(type);        // à faire exception
    }


    public Cards(String effet) {
        this.effet = effet;
    }

    public Cards(String effet, String type, int runes, int attaque, String description) {
        this.effet=effet;
        this.type=type;
        this.runes=runes;
        this.attaque=attaque;
        this.description=description;
    }

    public Cards(int runes, int attaque) {
        this.runes=runes;
        this.attaque=attaque;
    }


    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getRunes() {
        return runes;
    }

    public int getAttaque() {
        return attaque;
    }

    public int gagnerDesRunes(Joueur j, int runes) {
        j.nbRunesDispo= j.nbRunesDispo+runes;
        return j.nbRunesDispo;

    }


    public int gagnerDesDegats(Joueur joueur, int degats) {
        joueur.attaqueDispo=joueur.attaqueDispo+degats;
        return  joueur.attaqueDispo;
    }

    public boolean estDetype(String type) {
        for (int i = 0; i< tabtype.length; i++){
            if ( type.equals(tabtype[i])){
                this.type = type;
                return true;
            }
        }
        return  false;
    }
}
