package ascension;

/**
 * Created by Nathan on 01/12/2016.
 */
public class ControlGroup {
    public Modele2 m;
    public Vue fen;
    public ControlButton ctrb;

    public ControlGroup(Modele2 m) {
        this.m = m;
        fen = new Vue(m);
        ctrb = new ControlButton(fen,m);
        fen.display();
    }
}
