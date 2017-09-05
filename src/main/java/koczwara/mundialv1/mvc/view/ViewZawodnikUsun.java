package koczwara.mundialv1.mvc.view;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewZawodnikUsun extends JFrame {
    private JButton usunButton = new JButton("Usuń");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList;
    private JList reprezentacjaList;
    private JList zawodnikList;

    public ViewZawodnikUsun(){
        super("Zawodnik usuń");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        mundialList= new JList();
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

        usunButton.setBounds(250,400,100,30);
        add(usunButton);
        cofnijButton.setBounds(20,400,100,30);
        add(cofnijButton);
    }
//Cofnij do PanelAdministratora
    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }
// Klikniecie na button UsunZawodnika
    public void addUsunZawodnikaButtonListener(ActionListener listenUsunZawodnikaButton) {
        usunButton.addActionListener(listenUsunZawodnikaButton);
    }
//Ustawienie modelu mundialListModel do JList mundialList, bez tego w JList nie wyswietli sie lista mundiali
    public void addListModelToMundialList(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }
//Ustawienie modelu reprezentacjaListModel do JList reprezentacjaList
    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }
//Ustawienie modelu zawodnikListModel do JList zawodnikList
    public void addListModelToZawodnikList(DefaultListModel zawodnikListModel) {
        zawodnikList.setModel(zawodnikListModel);
    }
//Interakcja po kliknięciu na listę(JList) mundiali - mundialList
    public void addMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }
//Interakcja po kliknięciu na listę(JList) reprezentacji - reprezentacjaList
    public void addReprezentacjaListMouseListener(MouseAdapter listenReprezentacjaList) {
        reprezentacjaList.addMouseListener(listenReprezentacjaList);
    }
//Interakcja po kliknięciu na listę(JList) zawodników - zawodnikList
    public void addZawodnikListMouseListener(MouseAdapter listenZawodnikList) {
        zawodnikList.addMouseListener(listenZawodnikList);
    }
//Zwrócenie całej JList mundialList, aby móc pobrać z niej zaznaczony aktualnie element listy
    public JList getMundialList() {
        return mundialList;
    }
//Zwrócenie całej JList reprezentacjaList, aby móc pobrać z niej zaznaczony aktualnie element listy
    public JList getReprezentacjaList() {
        return reprezentacjaList;
    }
//Zwrócenie całej JList zawodnikList, aby móc pobrać z niej zaznaczony aktualnie element listy
    public JList getZawodnikList() {
        return zawodnikList;
    }
}
