package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewMecz extends JFrame{
    private JList mundialList;
    private JList meczList;
    private DefaultListModel mundialListModel, meczListModel, reprezentacja1ListModel, reprezentacja2ListModel;
    private JButton cofnijButton = new JButton("<< Cofnij");
    private JButton dodajButton = new JButton("Zatwierdź");
    private JLabel dataMeczLabel = new JLabel("Wybierz datę meczu:");
    private JLabel wynikLabel = new JLabel("Wynik:");
    private JLabel dataRokLabel = new JLabel();
    private JLabel nazwaRep1Label = new JLabel();
    private JLabel nazwaRep2Label = new JLabel();
    private JTextField goleRep1TextField = new JTextField();
    private JTextField goleRep2TextField = new JTextField();
    private JTextField dataMiesiacTextField = new JTextField();
    private JTextField dataDzienTextField = new JTextField();
    private JComboBox zaw1Rep1ComboBox = new JComboBox();
    private JComboBox zaw2Rep1ComboBox = new JComboBox();
    private JComboBox zaw3Rep1ComboBox = new JComboBox();
    private JComboBox zaw4Rep1ComboBox = new JComboBox();
    private JComboBox zaw5Rep1ComboBox = new JComboBox();
    private JComboBox zaw6Rep1ComboBox = new JComboBox();
    private JComboBox zaw7Rep1ComboBox = new JComboBox();
    private JComboBox zaw8Rep1ComboBox = new JComboBox();
    private JComboBox zaw9Rep1ComboBox = new JComboBox();
    private JComboBox zaw10Rep1ComboBox = new JComboBox();
    private JComboBox zaw11Rep1ComboBox = new JComboBox();
    private JComboBox zaw12Rep1ComboBox = new JComboBox();
    private JComboBox zaw13Rep1ComboBox = new JComboBox();
    private JComboBox zaw14Rep1ComboBox = new JComboBox();
    private JComboBox zaw15Rep1ComboBox = new JComboBox();
    private JComboBox zaw16Rep1ComboBox = new JComboBox();
    private JComboBox zaw1Rep2ComboBox = new JComboBox();
    private JComboBox zaw2Rep2ComboBox = new JComboBox();
    private JComboBox zaw3Rep2ComboBox = new JComboBox();
    private JComboBox zaw4Rep2ComboBox = new JComboBox();
    private JComboBox zaw5Rep2ComboBox = new JComboBox();
    private JComboBox zaw6Rep2ComboBox = new JComboBox();
    private JComboBox zaw7Rep2ComboBox = new JComboBox();
    private JComboBox zaw8Rep2ComboBox = new JComboBox();
    private JComboBox zaw9Rep2ComboBox = new JComboBox();
    private JComboBox zaw10Rep2ComboBox = new JComboBox();
    private JComboBox zaw11Rep2ComboBox = new JComboBox();
    private JComboBox zaw12Rep2ComboBox = new JComboBox();
    private JComboBox zaw13Rep2ComboBox = new JComboBox();
    private JComboBox zaw14Rep2ComboBox = new JComboBox();
    private JComboBox zaw15Rep2ComboBox = new JComboBox();
    private JComboBox zaw16Rep2ComboBox = new JComboBox();


    public ViewMecz() {
        super("Aktualizuj mecz");
        setSize(600, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


//Lista rozwijalna Mundiale
        mundialListModel = new DefaultListModel();
        mundialList= new JList();
        JScrollPane mundialScrollList = new JScrollPane(mundialList);
        mundialScrollList.setBounds(10,20,160,200);
        add(mundialScrollList);

//Lista rozwijalna Mecze w wybranym mundialu
        meczListModel = new DefaultListModel();
        meczList= new JList();
        JScrollPane meczScrollList = new JScrollPane(meczList);
        meczScrollList.setBounds(410,20,160,200);
        add(meczScrollList);

//Wszystko dotyczace ustawienia daty meczu
        dataMeczLabel.setBounds(220,50,120,40);
        add(dataMeczLabel);

        dataRokLabel.setBounds(220,90,30,30);
        dataRokLabel.setText("2014");
        dataRokLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(dataRokLabel);

        JLabel przecinekLabel = new JLabel("-");
        przecinekLabel.setBounds(255,90,10,30);
        add(przecinekLabel);

        dataMiesiacTextField.setBounds(265,90,30,30);
        add(dataMiesiacTextField);

        JLabel przecinek2Label = new JLabel("-");
        przecinek2Label.setBounds(298,90,10,30);
        add(przecinek2Label);

        dataDzienTextField.setBounds(310,90,30,30);
        add(dataDzienTextField);

//Label wynik i dwukropek oraz TF gole_r1 gole_r2
        wynikLabel.setBounds(265,130,50,30);
        add(wynikLabel);

        goleRep1TextField.setBounds(200,160,50,50);
        add(goleRep1TextField);

        JLabel dwukropek = new JLabel(":");
        dwukropek.setBounds(287,160,50,50);
        add(dwukropek);

        goleRep2TextField.setBounds(325,160,50,50);
        add(goleRep2TextField);

//nazwaRep1 nazwaRep2 label
        nazwaRep1Label.setBounds(10,230,160,50);
        nazwaRep1Label.setText("Polska");
        nazwaRep1Label.setHorizontalAlignment(SwingConstants.CENTER);
        nazwaRep1Label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(nazwaRep1Label);

        nazwaRep2Label.setBounds(410,230,160,50);
        nazwaRep2Label.setText("Wybrzeże Kości Słoniowej");
        nazwaRep2Label.setHorizontalAlignment(SwingConstants.CENTER);
        nazwaRep2Label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(nazwaRep2Label);

//Sklady reprezentacji_1
        JLabel lp1Rep1 = new JLabel("1. ");
         lp1Rep1.setBounds(10,290,20,30);
         add(lp1Rep1);
         zaw1Rep1ComboBox.setBounds(30,290,200,30);
         add(zaw1Rep1ComboBox);
        JLabel lp2Rep1 = new JLabel("2. ");
         lp2Rep1.setBounds(10,325,20,30);
         add(lp2Rep1);
         zaw2Rep1ComboBox.setBounds(30,325,200,30);
         add(zaw2Rep1ComboBox);
        JLabel lp3Rep1 = new JLabel("3. ");
         lp3Rep1.setBounds(10,360,20,30);
         add(lp3Rep1);
         zaw3Rep1ComboBox.setBounds(30,360,200,30);
         add(zaw3Rep1ComboBox);
        JLabel lp4Rep1 = new JLabel("4. ");
         lp4Rep1.setBounds(10,395,20,30);
         add(lp4Rep1);
         zaw4Rep1ComboBox.setBounds(30,395,200,30);
         add(zaw4Rep1ComboBox);
        JLabel lp5Rep1 = new JLabel("5. ");
        lp5Rep1.setBounds(10,430,20,30);
        add(lp5Rep1);
        zaw5Rep1ComboBox.setBounds(30,430,200,30);
        add(zaw5Rep1ComboBox);
        JLabel lp6Rep1 = new JLabel("6. ");
        lp6Rep1.setBounds(10,465,20,30);
        add(lp6Rep1);
        zaw6Rep1ComboBox.setBounds(30,465,200,30);
        add(zaw6Rep1ComboBox);
        JLabel lp7Rep1 = new JLabel("7. ");
        lp7Rep1.setBounds(10,500,20,30);
        add(lp7Rep1);
        zaw7Rep1ComboBox.setBounds(30,500,200,30);
        add(zaw7Rep1ComboBox);
        JLabel lp8Rep1 = new JLabel("8. ");
        lp8Rep1.setBounds(10,535,20,30);
        add(lp8Rep1);
        zaw8Rep1ComboBox.setBounds(30,535,200,30);
        add(zaw8Rep1ComboBox);
        JLabel lp9Rep1 = new JLabel("9. ");
        lp9Rep1.setBounds(10,570,20,30);
        add(lp9Rep1);
        zaw9Rep1ComboBox.setBounds(30,570,200,30);
        add(zaw9Rep1ComboBox);
        JLabel lp10Rep1 = new JLabel("10. ");
        lp10Rep1.setBounds(10,605,20,30);
        add(lp10Rep1);
        zaw10Rep1ComboBox.setBounds(30,605,200,30);
        add(zaw10Rep1ComboBox);
        JLabel lp11Rep1 = new JLabel("11. ");
        lp11Rep1.setBounds(10,640,20,30);
        add(lp11Rep1);
        zaw11Rep1ComboBox.setBounds(30,640,200,30);
        add(zaw11Rep1ComboBox);
        JLabel lp12Rep1 = new JLabel("12. ");
        lp12Rep1.setBounds(10,675,20,30);
        add(lp12Rep1);
        zaw12Rep1ComboBox.setBounds(30,675,200,30);
        add(zaw12Rep1ComboBox);
        JLabel lp13Rep1 = new JLabel("13. ");
        lp13Rep1.setBounds(10,710,20,30);
        add(lp13Rep1);
        zaw13Rep1ComboBox.setBounds(30,710,200,30);
        add(zaw13Rep1ComboBox);
        JLabel lp14Rep1 = new JLabel("14. ");
        lp14Rep1.setBounds(10,745,20,30);
        add(lp14Rep1);
        zaw14Rep1ComboBox.setBounds(30,745,200,30);
        add(zaw14Rep1ComboBox);
        JLabel lp15Rep1 = new JLabel("15. ");
        lp15Rep1.setBounds(10,780,20,30);
        add(lp15Rep1);
        zaw15Rep1ComboBox.setBounds(30,780,200,30);
        add(zaw15Rep1ComboBox);
        JLabel lp16Rep1 = new JLabel("16. ");
        lp16Rep1.setBounds(10,815,20,30);
        add(lp16Rep1);
        zaw16Rep1ComboBox.setBounds(30,815,200,30);
        add(zaw16Rep1ComboBox);

//Sklady reprezentacji_2
        JLabel lp1Rep2 = new JLabel("1. ");
         lp1Rep2.setBounds(310, 290,20,30);
         add(lp1Rep2);
         zaw1Rep2ComboBox.setBounds(330,290,200,30);
         add(zaw1Rep2ComboBox);
        JLabel lp2Rep2 = new JLabel("2. ");
        lp2Rep2.setBounds(310,325,20,30);
        add(lp2Rep2);
        zaw2Rep2ComboBox.setBounds(330,325,200,30);
        add(zaw2Rep2ComboBox);
        JLabel lp3Rep2 = new JLabel("3. ");
        lp3Rep2.setBounds(310,360,20,30);
        add(lp3Rep2);
        zaw3Rep2ComboBox.setBounds(330,360,200,30);
        add(zaw3Rep2ComboBox);
        JLabel lp4Rep2 = new JLabel("4. ");
        lp4Rep2.setBounds(310,395,20,30);
        add(lp4Rep2);
        zaw4Rep2ComboBox.setBounds(330,395,200,30);
        add(zaw4Rep2ComboBox);
        JLabel lp5Rep2 = new JLabel("5. ");
        lp5Rep2.setBounds(310,430,20,30);
        add(lp5Rep2);
        zaw5Rep2ComboBox.setBounds(330,430,200,30);
        add(zaw5Rep2ComboBox);
        JLabel lp6Rep2 = new JLabel("6. ");
        lp6Rep2.setBounds(310,465,20,30);
        add(lp6Rep2);
        zaw6Rep2ComboBox.setBounds(330,465,200,30);
        add(zaw6Rep2ComboBox);
        JLabel lp7Rep2 = new JLabel("7. ");
        lp7Rep2.setBounds(310,500,20,30);
        add(lp7Rep2);
        zaw7Rep2ComboBox.setBounds(330,500,200,30);
        add(zaw7Rep2ComboBox);
        JLabel lp8Rep2 = new JLabel("8. ");
        lp8Rep2.setBounds(310,535,20,30);
        add(lp8Rep2);
        zaw8Rep2ComboBox.setBounds(330,535,200,30);
        add(zaw8Rep2ComboBox);
        JLabel lp9Rep2 = new JLabel("9. ");
        lp9Rep2.setBounds(310,570,20,30);
        add(lp9Rep2);
        zaw9Rep2ComboBox.setBounds(330,570,200,30);
        add(zaw9Rep2ComboBox);
        JLabel lp10Rep2 = new JLabel("10. ");
        lp10Rep2.setBounds(310,605,20,30);
        add(lp10Rep2);
        zaw10Rep2ComboBox.setBounds(330,605,200,30);
        add(zaw10Rep2ComboBox);
        JLabel lp11Rep2 = new JLabel("11. ");
        lp11Rep2.setBounds(310,640,20,30);
        add(lp11Rep2);
        zaw11Rep2ComboBox.setBounds(330,640,200,30);
        add(zaw11Rep2ComboBox);
        JLabel lp12Rep2 = new JLabel("12. ");
        lp12Rep2.setBounds(310,675,20,30);
        add(lp12Rep2);
        zaw12Rep2ComboBox.setBounds(330,675,200,30);
        add(zaw12Rep2ComboBox);
        JLabel lp13Rep2 = new JLabel("13. ");
        lp13Rep2.setBounds(310,710,20,30);
        add(lp13Rep2);
        zaw13Rep2ComboBox.setBounds(330,710,200,30);
        add(zaw13Rep2ComboBox);
        JLabel lp14Rep2 = new JLabel("14. ");
        lp14Rep2.setBounds(310,745,20,30);
        add(lp14Rep2);
        zaw14Rep2ComboBox.setBounds(330,745,200,30);
        add(zaw14Rep2ComboBox);
        JLabel lp15Rep2 = new JLabel("15. ");
        lp15Rep2.setBounds(310,780,20,30);
        add(lp15Rep2);
        zaw15Rep2ComboBox.setBounds(330,780,200,30);
        add(zaw15Rep2ComboBox);
        JLabel lp16Rep2 = new JLabel("16. ");
        lp16Rep2.setBounds(310,815,20,30);
        add(lp16Rep2);
        zaw16Rep2ComboBox.setBounds(330,815,200,30);
        add(zaw16Rep2ComboBox);
// Przyciski cofnij i zatwierdz
        cofnijButton.setBounds(10,900,100,50);
        add(cofnijButton);
        dodajButton.setBounds(230,870,100,50);
        add(dodajButton);
    }

    public void addListModelToMundialList(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }
    public JList getMundialList() {
        return mundialList;
    }

    public void addListModelToMeczList(DefaultListModel meczListModel) { meczList.setModel(meczListModel);}
    public JList getMeczList() { return meczList; }

    public void addRokToLabel(String rok) { dataRokLabel.setText(rok); }
    public String getMiesiacFromTextField() { return dataMiesiacTextField.getText(); }
    public String getDzienFromTextField() { return dataDzienTextField.getText(); }

    public int getGoleRep1() { return Integer.parseInt(goleRep1TextField.getText()); }
    public int getGoleRep2() { return Integer.parseInt(goleRep2TextField.getText()); }

    public void setNazwaRep1(String nazwaReprezentacji) {nazwaRep1Label.setText(nazwaReprezentacji); }
    public void setNazwaRep2(String nazwaReprezentacji) {nazwaRep2Label.setText(nazwaReprezentacji); }

    public void addListModelToZaw1Rep1ComboBox(String zawodnikImieNazwisko) { zaw1Rep1ComboBox.addItem(zawodnikImieNazwisko); }


    public void addCofnijButtonListener(ActionListener listenCofnijButton) {cofnijButton.addActionListener(listenCofnijButton); }
    public void addDodajButtonListener(ActionListener listenDodajButton) {dodajButton.addActionListener(listenDodajButton); }



}
