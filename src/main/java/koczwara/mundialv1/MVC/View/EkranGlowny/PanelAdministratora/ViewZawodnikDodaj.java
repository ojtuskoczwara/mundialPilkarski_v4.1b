package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import javax.swing.border.Border;
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
    private JList mundialList, reprezentacjaList, zawodnikList, mundial2List;
    private JScrollPane mundial2ScrollList;
    private JCheckBox checkBoxIstniejacyZawodnik, checkBoxNowyZawodnik;
    private JPanel panelIstniejacyZawodnik, panelNowyZawodnik;


    public ViewZawodnikDodaj() {
        super("Dodawanie reprezentacji");
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

        imieLabel.setBounds(330,260,50,30);
        add(imieLabel);
        imieTextField.setBounds(360,260,150,30);
        add(imieTextField);
        nazwiskoLabel.setBounds(300,310,60,30);
        add(nazwiskoLabel);
        nazwiskoTextField.setBounds(360,310,150,30);
        add(nazwiskoTextField);
        dodajZawodnikaButton.setBounds(250,520,100,30);
        add(dodajZawodnikaButton);
        cofnijButton.setBounds(20,520,100,30);
        add(cofnijButton);

        checkBoxIstniejacyZawodnik = new JCheckBox("Dodanie zawodnika istniejącego już w bazie");
        checkBoxIstniejacyZawodnik.setBounds(10,240,20,20);
        add(checkBoxIstniejacyZawodnik);
        checkBoxNowyZawodnik = new JCheckBox("Dodanie nowego zawodnika");
        checkBoxNowyZawodnik.setSelected(true);
        checkBoxNowyZawodnik.setBounds(270,240,20,20);
        add(checkBoxNowyZawodnik);

        JLabel istniejacyZawodnikLabel = new JLabel("Dodanie zawodnika istniejącego już w bazie");
        istniejacyZawodnikLabel.setBounds(30,240,120,30);
        add(istniejacyZawodnikLabel);

        mundial2List = new JList();
        mundial2ScrollList = new JScrollPane(mundial2List);
        mundial2ScrollList.setBounds(30,260,160,200);
        add(mundial2ScrollList);
        mundial2ScrollList.setVisible(false);

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

    public void addMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }

    public void addReprezentacjaListMouseListener(MouseAdapter listenReprezentacjaList) {
        reprezentacjaList.addMouseListener(listenReprezentacjaList);
    }

    public void setVisibleJScrollMundial2(boolean visibleTrueFalse) { mundial2ScrollList.setVisible(visibleTrueFalse); }
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
