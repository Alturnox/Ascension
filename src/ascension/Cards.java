package ascension;

/**
 * Created by nmolle2 on 14/11/16.
 */
public class Cards {
    private int effet;
    private String description;
    private String nom;
    private String[] tabtype = new String[] {"évents","Monstre","Héros","Constructeur","Héros Lifebound", "Constructeur Lifebound", "Héros Mechana", "Constructeur Mechana"};
    private String type;
    private int runes;
    private int recompense;
    private int attaque;

    public Cards(String nom, String description, int rune, int attaque) {
        this.nom=nom;
        this.description=description;
        this.runes=rune;
        this.attaque=attaque;
    }

    public Cards(int effet, String type) {
        this.effet=effet;
        estDetype(type);        // à faire exception
    }


    public Cards(int effet) {
        this.effet = effet;
    }

    ///Le plus gros constructeur//
    public Cards(String nom, int effet, String type, int runes, int attaque, String description, int recompense) {
       this.nom=nom;
        this.recompense=recompense;
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
    public Cards(String toto) {
        this.nom=toto;
    }



    //////////////// Getteur //////////////////////
    public String getNom() {
        return nom;
    }

    public int getRecompense() { return recompense;}

    public String getDescription() {
        return description;
    }

    public int getRunes() {
        return runes;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getEffet() {return effet; }




    public int gagnerDesRunes(Joueur j, int runes) {
        System.out.println( "joueur " + j.nomJoueur +"runes  "+j.nbRunesDispo +" " );
        j.nbRunesDispo= j.nbRunesDispo+runes;
        System.out.println( "runes  " +j.nbRunesDispo + " +");


        return j.nbRunesDispo;
    }

    public int gagnerDesDegats(Joueur joueur, int degats) {return joueur.gagnerDegats(degats);}

    public boolean estDetype(String type) {
        for (int i = 0; i< tabtype.length; i++){
            if ( type.equals(tabtype[i])){
                this.type = type;
                return true;
            }
        }
        return  false;
    }

    public  void print(){
        System.out.println(""+nom+ " runes " + runes + " attaque : " + attaque);
    }

    public void effetDeCarte(int idEffet, Joueur joueurQuiJoueLaCarte, Plateau plateau) {
// encore plein de truc a faire
        switch (idEffet) {
            case 0:
                joueurQuiJoueLaCarte.deck.piocher(1);
                break;
            case 1:
                joueurQuiJoueLaCarte.deck.piocher(2);
                break;
            case 2:
                joueurQuiJoueLaCarte.deck.piocher(3);
                break;
            case 3:
                joueurQuiJoueLaCarte.gagnerDegats(1);
                break;
            case 4:
                joueurQuiJoueLaCarte.gagnerDegats(2);
                break;
            case 5:
                joueurQuiJoueLaCarte.gagnerDegats(3);

                break;
            case 6:
                joueurQuiJoueLaCarte.gagnerDegats(4);
                break;
            case 7:
                joueurQuiJoueLaCarte.gagnerRunes(1);
                break;
            case 8:
                gagnerDesRunes(joueurQuiJoueLaCarte,2);
                break;
            case 9:
                gagnerDesRunes(joueurQuiJoueLaCarte,3);
                break;
            case 11:
                gagnerDesRunes(joueurQuiJoueLaCarte,1);
                gagnerDesDegats(joueurQuiJoueLaCarte,1);
                break;
            case 12:
                joueurQuiJoueLaCarte.gagnerPointsHonneur(1);
                break;
            case 15:
                joueurQuiJoueLaCarte.tuerUneCarteAvecDeLattaqueGratuitement(plateau);
               System.out.println("DEfeat a monster that has 4 D or less without paying it cost");
                break;
            case 16:
               System.out.println("DEfeat a monster that has 6 D or less without paying it cost");
                break;
            case 17:
                joueurQuiJoueLaCarte.deck.piocher(1);
               System.out.println(" You may banish a card in the center row");
                break;
            case 18:
               System.out.println("Discard a card, if you do,  draw two cards");
                break;
            case 19:
               System.out.println("Copy l'effet d'un Héros joué ce tour-ci");
                break;
            case 20:
               System.out.println("Once per turn you may draw a card");
                break;
            case 21:
               System.out.println("You may banish this Construct to take an additional turn after this one.");
                break;
            case 22:
               System.out.println("Acquire a Hero without paying its cost. Place in on top of your deck.");
                break;
            case 23:
                joueurQuiJoueLaCarte.gagnerPointsHonneur(1);
                gagnerDesRunes(joueurQuiJoueLaCarte,1);
                break;
            case 24:
               gagnerDesRunes(joueurQuiJoueLaCarte,2);
                verifLifebound(joueurQuiJoueLaCarte);
                break;
            case 25:
                gagnerDesRunes(joueurQuiJoueLaCarte,1);
                joueurQuiJoueLaCarte.deck.piocher(1);
                break;
            case 26:
               System.out.println("Once per turn, gain 1 runes, the first time you play a lifebound hero, each turn gain 1 recompense");
                break;
            case 27:
               System.out.println("Once per turn , gain 1d" +
                       "Once per turn, you may spend 4r to gain 3 recompense");
                break;
            case 28:
                gagnerDesDegats(joueurQuiJoueLaCarte,2);
                plusDeDeuxConstructeur(joueurQuiJoueLaCarte);
               System.out.println("Draw a card if you control 2 or moreConstrcut");
                break;
            case 29:
               System.out.println("Gain 1d or 1r");
                break;
            case 30:
                joueurQuiJoueLaCarte.gagnerPointsHonneur(2);
               System.out.println("Gain 2r You pay 1R less the next time you acquire a Construc this turn");
                break;
            case 31:
                joueurQuiJoueLaCarte.gagnerPointsHonneur(2);
               System.out.println("Once per turn, when you put a Mechana Construc into play (including this one) , draw a card");
                break;
            case 32:
                joueurQuiJoueLaCarte.gagnerPointsHonneur(2);
               System.out.println("Once per turn, gain 2d.You may spend it only to acquire Mechana Construct");
                break;
            case 33:
                joueurQuiJoueLaCarte.gagnerPointsHonneur(2);
                System.out.println(" Once per turn");
                gagner1DParTourPourChaqueMechaConstruct(joueurQuiJoueLaCarte);

                break;
            case 34:
               System.out.println("You may treat all Construcs as Mechana Construcs");
                break;
            case 35:
               System.out.println("Once per turn, when you acquire another Mechana Construc, you may put it directly into play");
                break;
            case 36:
               System.out.println("Once per turn ,gain 1 r . you may spend it only to acquire Mechana Construc");
                break;
            case 37:
                joueurQuiJoueLaCarte.deck.piocher(2);
               System.out.println("Banish a card in you hand");
                break;
            case 38:
                gagnerDesDegats(joueurQuiJoueLaCarte,2);
               System.out.println("Banish a card in you hand or discard pile");
                break;
            case 39:
                gagnerDesDegats(joueurQuiJoueLaCarte,1);
               System.out.println("Banish a card in you hand or discard pile");
                break;
            case 40:
               System.out.println("Once per turn, gain 3d");
                break;
            case 41:
               System.out.println("Once per turn, gain 1d");
                break;
            case 42:
               System.out.println("Once per turn gain 1 The first time you deafeat a monster in the center row each turn, gain 1 R");
                break;
            case 43:
               System.out.println("Unbanishable You may acquire or defeat any car in the center row without paying its cost");
                break;
            case 44:
               System.out.println("Each opponent must destryo a Construc he controls");
                break;
            case 45:
                System.out.println("Banish a card un the center row and/or in you discard pile");
                break;
            case 46:
                System.out.println("Banish a card un the center row");
                break;
            case 47:
                System.out.println("If an opponent has more than one construct, that player must destroy all but one Construct he controls");
                break;
            case 48:
                System.out.println("Take a card at random from each oppenent's hand and add that card to your hands");
                break;
        }

    }

    private void gagner1DParTourPourChaqueMechaConstruct(Joueur joueurQuiJoueLaCarte) {
        int gainD=0;
        if (!joueurQuiJoueLaCarte.getConstruct().isEmpty()){
            for (Cards carte : joueurQuiJoueLaCarte.getConstruct()){
                if (carte.type.equals("Constructeur Mechana")){
                    gainD+=1;
                }
            }
        }

        gagnerDesDegats(joueurQuiJoueLaCarte,gainD);
    }

    public void verifLifebound(Joueur joueurQuiJoueLaCarte) {
        for (Cards carte : joueurQuiJoueLaCarte.getTapis()){
            if (carte.type.equals("Héros Lifebound")){
                gagnerDesDegats(joueurQuiJoueLaCarte,2);
            }
        }
    }

    public void plusDeDeuxConstructeur(Joueur joueurQuiJoueLaCarte) {
        int i=0;
        if (!joueurQuiJoueLaCarte.getConstruct().isEmpty()){
            for (Cards c : joueurQuiJoueLaCarte.getConstruct()){
                if (c.type.equals("Constructeur Mechana")){
                    i++;
                }
            }
        }
        if (i>1){
            joueurQuiJoueLaCarte.piocher(1);
        }

    }


}
