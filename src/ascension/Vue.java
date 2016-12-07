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
    public JPanel panel_4;
    public ButtonV2 carteMainJoueur;
    public JPanel panel_3;
    public JButton btnNeant;
    public JButton btnPasser;
    public JButton btnDefausse;
    public ArrayList<ButtonV2> listeDeBoutons;
    public JPanel pane;


    public Vue(Modele2 m){

        init(m);
        creerWidget(m);
        setSize(1200, 650);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void init(Modele2 m){
        ControlButton cb=new ControlButton(this,m);
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

        JPanel panelLigneCentrale = new JPanel();
        panelLigneCentrale.setBounds(40, 137, 1150, 74);
        contentPane.add(panelLigneCentrale);
        panelLigneCentrale.setLayout(new GridLayout(1, 0, 0, 0));

        JButton btnCarteCentrale = new JButton(m.p.ligneCentrale[0].getNom());
        panelLigneCentrale.add(btnCarteCentrale);

        JButton btnCartecentral = new JButton(m.p.ligneCentrale[1].getNom());
        panelLigneCentrale.add(btnCartecentral);

        JButton btnCartecentrale = new JButton(m.p.ligneCentrale[2].getNom());
        panelLigneCentrale.add(btnCartecentrale);

        JButton btnCartecentrale_1 = new JButton(m.p.ligneCentrale[3].getNom());
        panelLigneCentrale.add(btnCartecentrale_1);

        JButton btnCartecentrale_2 = new JButton(m.p.ligneCentrale[4].getNom());
        panelLigneCentrale.add(btnCartecentrale_2);

        JButton btnCartecentrale_3 = new JButton(m.p.ligneCentrale[5].getNom());
        panelLigneCentrale.add(btnCartecentrale_3);

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

        panel_3 = new JPanel();
        panel_3.setBounds(89, 222, 600, 68);
        contentPane.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 0, 0, 0));

        listeDeBoutons=new ArrayList<ButtonV2>();
        panel_4 = new JPanel();
        panel_4.setBounds(100,580,1050 ,50);
        for (int i=0; i<m.joueur.getHand().size();i++){
            carteMainJoueur= new ButtonV2(m.joueur.getHand().get(i).getNom(),i);
            listeDeBoutons.add(carteMainJoueur);
            listeDeBoutons.get(i).addActionListener(cb);
            panel_4.add(listeDeBoutons.get(i));

        }
        contentPane.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 0, 0, 0));






        JLabel jb= new JLabel("Tour du joueur : " + m.joueurActuel().nomJoueur);
        JLabel jlabelRunesEtAttaqueDispo= new JLabel("Runes :  " + m.joueurActuel().nbRunesDispo + "  Attaque : " + m.joueurActuel().attaqueDispo);


        jb.setBounds(258, 11, 200, 20);
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


    public void creerWidget(Modele2 m){
        setContentPane(contentPane);
    }




    public int retourneLenomCarte(JButton carteMainJoueur) {
        return listeDeBoutons.indexOf(carteMainJoueur);

    }

    public void carteJouer(ButtonV2 buttonV2) {
        panel_3.add(buttonV2);
//       listeDeBoutons.remove(buttonV2);  problème détecter : on modifie l'aspect de la boucle pendant le parcours
        panel_4.remove(buttonV2);
        invalidate();
        validate();
        repaint();

    }
}
