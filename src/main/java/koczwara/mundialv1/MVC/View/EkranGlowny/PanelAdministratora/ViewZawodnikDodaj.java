package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * Created by Wojtek on 2017-05-30.
 */
public class ViewZawodnikDodaj extends JFrame {
    private JLabel imieLabel = new JLabel("Imię:");
    private JTextField imieTextField = new JTextField();
    private JLabel nazwiskoLabel = new JLabel("Nazwisko:");
    private JTextField nazwiskoTextField = new JTextField();
    private JButton dodajZawodnikaButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList;
    private JList reprezentacjaList;
    private JList zawodnikList;


    public ViewZawodnikDodaj() {
        super("Dodawanie reprezentacji");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        mundialList = new JList();
        JScrollPane mundialScrollList = new JScrollPane(mundialList);
        mundialScrollList.setBounds(10,20,160,200);
        add(mundialScrollList);

        reprezentacjaList = new JList();
        JScrollPane reprezentacjaScrollList = new JScrollPane(reprezentacjaList);
        reprezentacjaScrollList.setBounds(180,20,160,200);
        add(reprezentacjaScrollList);

        zawodnikList = new JList();
        JScrollPane zawodnikScrollList = new JScrollPane(zawodnikList);
        zawodnikScrollList.setBounds(350,20,160,200);
        add(zawodnikScrollList);

        imieLabel.setBounds(50,250,50,30);
        add(imieLabel);
        imieTextField.setBounds(90,250,150,30);
        add(imieTextField);
        nazwiskoLabel.setBounds(250,250,60,30);
        add(nazwiskoLabel);
        nazwiskoTextField.setBounds(320,250,150,30);
        add(nazwiskoTextField);
        dodajZawodnikaButton.setBounds(250,400,100,30);
        add(dodajZawodnikaButton);
        cofnijButton.setBounds(20,400,100,30);
        add(cofnijButton);
    }

    public void addDodajZawodnikaButtonListener(ActionListener listenDodajZawodnikaButton) {
        dodajZawodnikaButton.addActionListener(listenDodajZawodnikaButton);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public String getImieZawodnika() {
        return imieTextField.getText();
    }

    public String getNazwiskoZawodnika() {
        return nazwiskoTextField.getText();
    }

    public JList getMundialList() {
        return mundialList;
    }

    public JList getReprezentacjaList() {
        return reprezentacjaList;
    }

    public JList getZawodnikList() {
        return zawodnikList;
    }

    public void addListModelToMundialList(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }

    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }

    public void addListModelToZawodnikList(DefaultListModel zawodnikListModel) {
        zawodnikList.setModel(zawodnikListModel);
    }

    public void addMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }

    public void addReprezentacjaListMouseListener(MouseAdapter listenReprezentacjaList) {
        reprezentacjaList.addMouseListener(listenReprezentacjaList);
    }

}
