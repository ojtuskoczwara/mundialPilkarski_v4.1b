package koczwara.mundialv1.MVC.View.EkranGlowny;


import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewPanelAdministratora extends JFrame {
    private JButton dodajMundialButton = new JButton("Dodaj mundial");
    private JButton edytujMundialButton = new JButton("Edytuj mundial");
    private JButton usunMundialButton = new JButton("Usuń mundial");
    private JButton dodajReprezentacjaButton = new JButton("Dodaj reprezentacje");
    private JButton edytujReprezentacjaButton = new JButton("Edytuj reprezentacje");
    private JButton usunReprezentacjaButton = new JButton("Usuń reprezentacje");
    private JButton dodajZawodnikaButton = new JButton("Dodaj zawodnika");
    private JButton edytujZawodnikaButton = new JButton("Edytuj zawodnika");
    private JButton usunZawodnikaButton = new JButton("Usuń zawodnika");
    private JButton dodajReprezentacjaDoGrupaButton = new JButton("Dodaj reprezentacje do grup");
    private JButton dodajWynikiMeczuButton = new JButton("Dodaj wynik meczu");
    private JButton cofnijButton = new JButton("<<< Cofnij");

    public ViewPanelAdministratora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);
        setTitle("Panel administratora");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        JPanel mundialPanel = new JPanel();
        dodajMundialButton.setBounds(50,50,150,50);
        mundialPanel.add(dodajMundialButton);
        edytujMundialButton.setBounds(250,50,150,50);
        mundialPanel.add(edytujMundialButton);
        usunMundialButton.setBounds(450,50,150,50);
        mundialPanel.add(usunMundialButton);
        mundialPanel.setBounds(10,10,450,100);
        mundialPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Mundial Panel"));
        this.add(mundialPanel);

        JPanel reprezentacjaPanel = new JPanel();
        dodajReprezentacjaButton.setBounds(50,140,150,50);
        reprezentacjaPanel.add(dodajReprezentacjaButton);
        edytujReprezentacjaButton.setBounds(250,140,150,50);
        reprezentacjaPanel.add(edytujReprezentacjaButton);
        usunReprezentacjaButton.setBounds(450,140,150,50);
        reprezentacjaPanel.add(usunReprezentacjaButton);
        reprezentacjaPanel.setBounds(10,120,450,100);
        reprezentacjaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Reprezentacja Panel"));
        this.add(reprezentacjaPanel);

        JPanel zawodnikPanel = new JPanel();
        dodajZawodnikaButton.setBounds(50,230,150,50);
        edytujZawodnikaButton.setBounds(250,230,150,50);
        usunZawodnikaButton.setBounds(450,230,150,50);
        zawodnikPanel.add(dodajZawodnikaButton);
        zawodnikPanel.add(edytujZawodnikaButton);
        zawodnikPanel.add(usunZawodnikaButton);
        zawodnikPanel.setBounds(10,230,450,100);
        zawodnikPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Zawodnik Panel"));
        this.add(zawodnikPanel);

        JPanel grupaPanel = new JPanel();
        dodajReprezentacjaDoGrupaButton.setBounds(50,340,150,50);
        grupaPanel.add(dodajReprezentacjaDoGrupaButton);
        dodajWynikiMeczuButton.setBounds(50,400,150,50);
        grupaPanel.add(dodajWynikiMeczuButton);
        grupaPanel.setBounds(10,340,450,100);
        grupaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Grupa Panel"));
        this.add(grupaPanel);



        cofnijButton.setBounds(10,500,100,30);
        add(cofnijButton);
    }

    public void addDodajMundialButtonListener(ActionListener listenDodajMundialButton) {
        dodajMundialButton.addActionListener(listenDodajMundialButton);
    }

    public void addEdytujMundialButtonListener(ActionListener listenEdytujMundialButton) {
        edytujMundialButton.addActionListener(listenEdytujMundialButton);
    }

    public void addUsunMundialButtonListener(ActionListener listenUsunMundialButton) {
        usunMundialButton.addActionListener(listenUsunMundialButton);
    }

    public void addDodajReprezentacjaButtonListener(ActionListener listenDodajReprezentacjaButton) {
        dodajReprezentacjaButton.addActionListener(listenDodajReprezentacjaButton);
    }

    public void addEdytujReprezentacjaButtonListener(ActionListener listenEdytujReprezentacjaButton) {
        edytujReprezentacjaButton.addActionListener(listenEdytujReprezentacjaButton);
    }
    public void addUsunReprezentacjaButtonListener(ActionListener listenUsunReprezentacjaButton) {
        usunReprezentacjaButton.addActionListener(listenUsunReprezentacjaButton);
    }

    public void addDodajZawodnikButtonListener(ActionListener listenDodajZawodnikButton) {
        dodajZawodnikaButton.addActionListener(listenDodajZawodnikButton);
    }

    public void addEdytujZawodnikButtonListener(ActionListener listenEdytujZawodnikButton) {
        edytujZawodnikaButton.addActionListener(listenEdytujZawodnikButton);
    }

    public void addUsunZawodnikButtonListener(ActionListener listenUsunZawodnikButton) {
        usunZawodnikaButton.addActionListener(listenUsunZawodnikButton);
    }

    public void addDodajReprezentacjaDoGrupaButtonListener(ActionListener listenDodajReprezentacjaDoGrupaButton) {
        dodajReprezentacjaDoGrupaButton.addActionListener(listenDodajReprezentacjaDoGrupaButton);
    }

    public void addDodajWynikMeczuButtonListener(ActionListener listenDodajWynikMeczuButton) {
        dodajWynikiMeczuButton.addActionListener(listenDodajWynikMeczuButton);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

}
