package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewZawodnikEdytuj extends JFrame{
    private JLabel imieLabel = new JLabel("Wpisz imię:");
    private JTextField imieTextField = new JTextField();
    private JLabel nazwiskoLabel = new JLabel("Wpisz nazwisko:");
    private JTextField nazwiskoTextField = new JTextField();
    private JButton edytujButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList;
    private JList reprezentacjaList;
    private JList zawodnikList;
    private DefaultListModel zawodnikListModel;
    private DefaultListModel mundialListModel;
    private DefaultListModel reprezentacjaListModel;

    public ViewZawodnikEdytuj() {
        super("Edytuj zawodnika");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        mundialListModel = new DefaultListModel();
        mundialList= new JList();
        JScrollPane mundialScrollList = new JScrollPane(mundialList);
        mundialScrollList.setBounds(10,20,160,200);
        add(mundialScrollList);

        reprezentacjaListModel = new DefaultListModel();
        reprezentacjaList = new JList();
        JScrollPane reprezentacjaScrollList = new JScrollPane(reprezentacjaList);
        reprezentacjaScrollList.setBounds(180,20,160,200);
        add(reprezentacjaScrollList);

        zawodnikListModel = new DefaultListModel();
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
        edytujButton.setBounds(250,400,100,30);
        add(edytujButton);
        cofnijButton.setBounds(20,400,100,30);
        add(cofnijButton);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void addEdytujZawodnikaButtonListener(ActionListener listenEdytujZawodnikaButton) {
        edytujButton.addActionListener(listenEdytujZawodnikaButton);
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

    public void addZawodnikListMouseListener(MouseAdapter listenZawodnikList) {
        zawodnikList.addMouseListener(listenZawodnikList);
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

}
