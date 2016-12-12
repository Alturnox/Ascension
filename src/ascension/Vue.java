package ascension;

/**
 * Created by Nathan on 01/12/2016.
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 20/05/2016.
 */
public class Vue extends JFrame {
    protected JPanel all;
    protected JPanel gen;
    protected JMenuBar menu;
    protected JPanel cadreTemps;
    protected JButton button;
    public JTextField textField;
    public String t;

    public ControlButton appuie;
    public JTextField txtTourJoueur;
    public JPanel contentPane;
    public JTextField txtTourjoueur;
    public JButton btnDeck;
    public JPanel panelMainJoueur;
    public ButtonV2 carteMainJoueur;
    public JPanel panelTapis;
    public JButton btnNeant;
    public JButton btnPasser;
    public JButton btnDefausse;
    public ArrayList<ButtonV2> listeDeBoutons;
    public ButtonV2[] tableauBtnCentrale;
    public JPanel pane;
    public JLabel jlabelRunesEtAttaqueDispo;
    public ButtonV2 btnCarteCentrale;
    public ControlButton cb;
    public Modele m;
    public JPanel panelLigneCentrale;
    public JLabel jlabelPtsHonneur;
    public JLabel jb;


    public Vue(Modele m){
        this.m=m;
        init(m);
        creerWidget(m);
        setSize(1200, 650);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void init(Modele m){
        cb=new ControlButton(this,m);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 653, 480);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnOption = new JMenu("option");
        menuBar.add(mnOption);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel habitants = new JPanel();
        habitants.setBounds(40, 45, 650, 52);
        contentPane.add(habitants);
        habitants.setLayout(new GridLayout(1, 0, 0, 0));

        JButton btnHabitant = new JButton(m.p.tableauHabitantsR[0].getNom());
        habitants.add(btnHabitant);

        JButton btnHabitant_1 = new JButton(m.p.tableauHabitantsR[1].getNom());
        habitants.add(btnHabitant_1);

        JButton btnHabitant_2 = new JButton(m.p.tableauHabitantsR[2].getNom());
        habitants.add(btnHabitant_2);

        panelLigneCentrale = new JPanel();
        panelLigneCentrale.setBounds(40, 137, 1150, 74);
        contentPane.add(panelLigneCentrale);
        panelLigneCentrale.setLayout(new GridLayout(1, 0, 0, 0));


        tableauBtnCentrale =new ButtonV2[6];
        for (int i=0; i<6; i++){
            btnCarteCentrale = new ButtonV2(m.p.ligneCentrale[i].getNom() +" r"+m.p.ligneCentrale[i].getRunes()+ " d"+m.p.ligneCentrale[i].getAttaque(),i);
            btnCarteCentrale.addActionListener(cb);
            tableauBtnCentrale[i]=btnCarteCentrale;
            panelLigneCentrale.add(btnCarteCentrale);
        }

        contentPane.add(panelLigneCentrale);



        btnNeant = new JButton("Neant");
        btnNeant.addActionListener(cb);
        btnNeant.setBounds(1200, 45, 100, 52);
        btnNeant.setForeground(Color.magenta);
        contentPane.add(btnNeant);

        btnDeck = new JButton("deck");
        btnDeck.addActionListener(cb);
        btnDeck.setBounds(10, 306, 100, 52);
        contentPane.add(btnDeck);

        btnDefausse = new JButton("défausse");
        btnDefausse.setBounds(1200, 306, 100, 52);
        btnDefausse.addActionListener(cb);
        contentPane.add(btnDefausse);

        btnPasser = new JButton("passer");
        btnPasser.addActionListener(cb);
        btnPasser.setBounds(1200, 236, 100, 52);
        contentPane.add(btnPasser);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(142, 321, 350, 68);
        contentPane.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 0, 0, 0));

        panelTapis = new JPanel();
        panelTapis.setBounds(89, 222, 600, 68);
        contentPane.add(panelTapis);
        panelTapis.setLayout(new GridLayout(1, 0, 0, 0));

        listeDeBoutons=new ArrayList<ButtonV2>();
        panelMainJoueur = new JPanel();
        panelMainJoueur.setBounds(100,580,1050 ,50);
//        for (int i=0; i<m.joueur.getHand().size();i++){
//            carteMainJoueur= new ButtonV2(m.joueur.getHand().get(i).getNom(),i);
//            listeDeBoutons.add(carteMainJoueur);
//            listeDeBoutons.get(i).addActionListener(cb);
//            panelMainJoueur.add(listeDeBoutons.get(i));
//
//        }
//        contentPane.add(panelMainJoueur);
        debutMainJoueur();
        panelMainJoueur.setLayout(new GridLayout(1, 0, 0, 0));






        jb= new JLabel("Tour du joueur : " + m.joueurActuel().nomJoueur);
        jb.setBounds(258, 11, 200, 20);

        jlabelPtsHonneur= new JLabel("Points d'Honneur : " + m.joueurActuel().getPtsHonneur());
        jlabelPtsHonneur.setBounds(1200, 490, 200, 52);

        contentPane.add(jlabelPtsHonneur);

        jlabelRunesEtAttaqueDispo= new JLabel("Runes :  " + m.joueurActuel().nbRunesDispo + "  Attaque : " + m.joueurActuel().attaqueDispo);
        jlabelRunesEtAttaqueDispo.setBounds(1200,460,500,52);
//        jb.setColumns(10);
        contentPane.add(jlabelRunesEtAttaqueDispo);
        contentPane.add(jb);



    }

    public void display() {

        setVisible(true);
    }

    public void undisplay() {

        setVisible(false);
    }


    public void creerWidget(Modele m){
        setContentPane(contentPane);
    }




    public int retourneIndexDeLaCarte(ButtonV2 carteMainJoueur) {
        return listeDeBoutons.indexOf(carteMainJoueur);

    }


    public void carteJouer(ButtonV2 buttonV2) {
        panelTapis.add(buttonV2);
//       listeDeBoutons.remove(buttonV2);  problème détecter : on modifie l'aspect de la boucle pendant le parcours
        panelMainJoueur.remove(buttonV2);
        invalidate();
        validate();
        repaint();

    }

    public void actualiserRunesEtAttaqueJoueur(Joueur joueur,Modele m) {
        contentPane.remove(jlabelRunesEtAttaqueDispo);
        jlabelRunesEtAttaqueDispo= new JLabel("Runes :  " + joueur.getRunes() + "  Attaque : " + joueur.attaqueDispo);
        jlabelRunesEtAttaqueDispo.setBounds(1200,460,500,52);
        contentPane.add(jlabelRunesEtAttaqueDispo);

        invalidate();
        validate();
        repaint();
    }


    public void actualiserLigneCentrale(ButtonV2 bv22, String nomStocke) {
        int idDeStockage=bv22.getIdBouton();
         panelLigneCentrale.remove(tableauBtnCentrale[bv22.getIdBouton()]);

        tableauBtnCentrale[bv22.getIdBouton()]=new ButtonV2(nomStocke,idDeStockage);
        tableauBtnCentrale[bv22.getIdBouton()].addActionListener(cb);
        panelLigneCentrale.add(tableauBtnCentrale[idDeStockage]);
        invalidate();
        validate();
        repaint();
    }


    public void actualiserPtsHonneur(Joueur joueur, Modele m) {
//        contentPane.remove(jlabelPtsHonneur);
//        jlabelPtsHonneur= new JLabel("Points d'Honneur : " + m.joueurActuel().getPtsHonneur());
//        jlabelPtsHonneur.setBounds(1200,460,500,52);
//        contentPane.add(jlabelPtsHonneur);

        jlabelPtsHonneur.setText("Points d'Honneur : " + m.joueurActuel().getPtsHonneur());

        invalidate();
        validate();
        repaint();
    }

    public void actualiserJoueur() {
        jb.setText("Tour du joueur : " + m.joueurActuel().nomJoueur);
        actualiserPtsHonneur(m.joueurActuel(),m);
        actualiserRunesEtAttaqueJoueur(m.joueurActuel(),m);
        debutMainJoueur();



    }

    public void debutMainJoueur(){

        for (int i=0; i<m.joueurActuel().getHand().size();i++){
            carteMainJoueur= new ButtonV2(m.joueurActuel().getHand().get(i).getNom(),i);
            listeDeBoutons.add(carteMainJoueur);
            listeDeBoutons.get(i).addActionListener(cb);
            panelMainJoueur.add(listeDeBoutons.get(i));

        }
        contentPane.add(panelMainJoueur);
        panelMainJoueur.setLayout(new GridLayout(1, 0, 0, 0));
    }

    public void nettoyerTapis() {
        panelTapis.removeAll();
        m.joueurActuel().piocherMain();

        invalidate();
        validate();
        repaint();
    }

    public void nettoyerMain() {
        panelMainJoueur.removeAll();
        listeDeBoutons.removeAll(listeDeBoutons);

        invalidate();
        validate();
        repaint();
    }
}
