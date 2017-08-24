package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewZawodnikDodaj extends JFrame {
    private JLabel imieLabel = new JLabel("Imię:");
    private JTextField imieTextField = new JTextField();
    private JLabel nazwiskoLabel = new JLabel("Nazwisko:");
    private JTextField nazwiskoTextField = new JTextField();
    private JButton dodajZawodnikaButton = new JButton("Dodaj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList, reprezentacjaList, zawodnikList, mundial2List, zawodnik2PodgladList;
    private JScrollPane mundial2ScrollList, zawodnik2PodgladScrollList;
    private JCheckBox checkBoxIstniejacyZawodnik, checkBoxNowyZawodnik;


    public ViewZawodnikDodaj() {
        super("Zawodnik dodaj");
        setSize(600,600);
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

        imieLabel.setBounds(380,260,50,30);
        add(imieLabel);
        imieTextField.setBounds(410,260,150,30);
        add(imieTextField);
        nazwiskoLabel.setBounds(350,310,60,30);
        add(nazwiskoLabel);
        nazwiskoTextField.setBounds(410,310,150,30);
        add(nazwiskoTextField);

        dodajZawodnikaButton.setBounds(250,520,100,30);
        add(dodajZawodnikaButton);
        cofnijButton.setBounds(20,520,100,30);
        add(cofnijButton);

        checkBoxIstniejacyZawodnik = new JCheckBox();
        checkBoxIstniejacyZawodnik.setBounds(10,240,20,20);
        add(checkBoxIstniejacyZawodnik);
        checkBoxNowyZawodnik = new JCheckBox();
        checkBoxNowyZawodnik.setSelected(true);
        checkBoxNowyZawodnik.setBounds(350,240,20,20);
        add(checkBoxNowyZawodnik);

        JLabel istniejacyZawodnikLabel = new JLabel("Zawodnik z bazy danych");
        istniejacyZawodnikLabel.setBounds(30,235,150,30);
        add(istniejacyZawodnikLabel);

        JLabel nowyZawodnikLabel = new JLabel("Nowy zawodnik");
        nowyZawodnikLabel.setBounds(370,235,150,30);
        add(nowyZawodnikLabel);

        mundial2List = new JList();
        mundial2ScrollList = new JScrollPane(mundial2List);
        mundial2ScrollList.setBounds(10,260,160,200);
        add(mundial2ScrollList);
        mundial2ScrollList.setVisible(false);

        zawodnik2PodgladList = new JList();
        zawodnik2PodgladScrollList = new JScrollPane(zawodnik2PodgladList);
        zawodnik2PodgladScrollList.setBounds(180,260,160,200);
        add(zawodnik2PodgladScrollList);
        zawodnik2PodgladScrollList.setVisible(false);

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

    public JList getMundial2List() { return mundial2List; }

    public void addListModelToMundialList(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }

    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }

    public void addListModelToZawodnikList(DefaultListModel zawodnikListModel) {
        zawodnikList.setModel(zawodnikListModel);
    }

    public void addListModelToMundial2List(DefaultListModel mundial2ListModel) { mundial2List.setModel(mundial2ListModel); }

    public void setListModelToZawodnik2PodgladList(DefaultListModel dlmZawodnik2) { zawodnik2PodgladList.setModel(dlmZawodnik2);}

    public void addMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }

    public void addMundial2ListMouseListener(MouseAdapter listenClickMundial2List) { mundial2List.addMouseListener(listenClickMundial2List);}

    public void addReprezentacjaListMouseListener(MouseAdapter listenReprezentacjaList) {
        reprezentacjaList.addMouseListener(listenReprezentacjaList);
    }

    public void setVisibleJScrollMundial2(boolean visibleTrueFalse) {
        mundial2ScrollList.setVisible(visibleTrueFalse);
        zawodnik2PodgladScrollList.setVisible(visibleTrueFalse);
    }

    public void setVisibleImieNazwiskoTextField(boolean visibleTrueFalse) {
        imieTextField.setVisible(visibleTrueFalse);
        nazwiskoTextField.setVisible(visibleTrueFalse);
        imieLabel.setVisible(visibleTrueFalse);
        nazwiskoLabel.setVisible(visibleTrueFalse);
    }

    public void addCheckBoxIstniejacyZawodnikActionListener(ActionListener listenChechBoxIstniejacyZawodnik) {
        checkBoxIstniejacyZawodnik.addActionListener(listenChechBoxIstniejacyZawodnik);
    }

    public void addCheckBoxNowyZawodnikActionListener(ActionListener listenCheckBoxNowyZawodnik) {
        checkBoxNowyZawodnik.addActionListener(listenCheckBoxNowyZawodnik);
    }

    public boolean getValueSelectedCheckBoxIstniejacyZawodnik() { return checkBoxIstniejacyZawodnik.isSelected(); }
    public boolean getValueSelectedCheckBoxNowyZawodnik() {return checkBoxNowyZawodnik.isSelected(); }

    public void setCheckBoxIstniejacyZawodnik(boolean trueFalse) { checkBoxIstniejacyZawodnik.setSelected(trueFalse); }
    public void setCheckBoxNowyZawodnik(boolean trueFalse) { checkBoxNowyZawodnik.setSelected(trueFalse); }
}
