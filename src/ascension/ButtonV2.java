package ascension;

import javax.swing.*;

/**
 * Created by Nathan on 06/12/2016.
 */
public class ButtonV2 extends JButton{
    public String textBouton;
    public  int idBouton;

    public ButtonV2(String textBouton, int idBouton){
        super(textBouton);
        this.textBouton=textBouton;
        this.idBouton=idBouton;
    }

    public int getIdBouton(){
        return idBouton;
    }
}
