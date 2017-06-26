package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import java.awt.*;

public class ViewMecz extends JFrame{
    private JList mundialList;
    private JList meczList;
    private DefaultListModel mundialListModel;
    private DefaultListModel meczListModel;
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
    private JLabel zawodnik1Rep1 = new JLabel();
    private JLabel zawodnik2Rep1 = new JLabel();
    private JLabel zawodnik3Rep1 = new JLabel();
    private JLabel zawodnik4Rep1 = new JLabel();
    private JLabel zawodnik5Rep1 = new JLabel();
    private JLabel zawodnik6Rep1 = new JLabel();
    private JLabel zawodnik7Rep1 = new JLabel();
    private JLabel zawodnik8Rep1 = new JLabel();
    private JLabel zawodnik9Rep1 = new JLabel();
    private JLabel zawodnik10Rep1 = new JLabel();
    private JLabel zawodnik11Rep1 = new JLabel();
    private JLabel zawodnik12Rep1 = new JLabel();
    private JLabel zawodnik13Rep1 = new JLabel();
    private JLabel zawodnik14Rep1 = new JLabel();
    private JLabel zawodnik15Rep1 = new JLabel();
    private JLabel zawodnik16Rep1 = new JLabel();
    private JLabel zawodnik17Rep1 = new JLabel();
    private JLabel zawodnik18Rep1 = new JLabel();
    private JLabel zawodnik1Rep2 = new JLabel();
    private JLabel zawodnik2Rep2 = new JLabel();
    private JLabel zawodnik3Rep2 = new JLabel();
    private JLabel zawodnik4Rep2 = new JLabel();
    private JLabel zawodnik5Rep2 = new JLabel();
    private JLabel zawodnik6Rep2 = new JLabel();
    private JLabel zawodnik7Rep2 = new JLabel();
    private JLabel zawodnik8Rep2 = new JLabel();
    private JLabel zawodnik9Rep2 = new JLabel();
    private JLabel zawodnik10Rep2 = new JLabel();
    private JLabel zawodnik11Rep2 = new JLabel();
    private JLabel zawodnik12Rep2 = new JLabel();
    private JLabel zawodnik13Rep2 = new JLabel();
    private JLabel zawodnik14Rep2 = new JLabel();
    private JLabel zawodnik15Rep2 = new JLabel();
    private JLabel zawodnik16Rep2 = new JLabel();
    private JLabel zawodnik17Rep2 = new JLabel();
    private JLabel zawodnik18Rep2 = new JLabel();


    public ViewMecz() {
        super("Aktualizuj mecz");
        setSize(600,600);
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
         lp1Rep1.setBounds(10,300,20,30);
         add(lp1Rep1);
         zawodnik1Rep1.setBounds(30,300,180,30);
         zawodnik1Rep1.setBorder(BorderFactory.createLineBorder(Color.black));
         add(zawodnik1Rep1);
        JComboBox pozycjaZaw1Rep1ComboBox = new JComboBox();
         pozycjaZaw1Rep1ComboBox.setBounds(220,300,50,30);
         pozycjaZaw1Rep1ComboBox.addItem("N");
         add(pozycjaZaw1Rep1ComboBox);

        JLabel lp2Rep1 = new JLabel("2. ");
         lp2Rep1.setBounds(10,340,20,30);
         add(lp2Rep1);
         zawodnik2Rep1.setBounds(30,340,180,30);
         zawodnik2Rep1.setBorder(BorderFactory.createLineBorder(Color.black));
         add(zawodnik2Rep1);
        JComboBox pozycjaZaw2Rep1ComboBox = new JComboBox();
         pozycjaZaw2Rep1ComboBox.setBounds(220,340,50,30);
         add(pozycjaZaw2Rep1ComboBox);

        JLabel lp3Rep1 = new JLabel("3. ");
         lp3Rep1.setBounds(10,380,20,30);
         add(lp3Rep1);
         zawodnik3Rep1.setBounds(30,380,180,30);
         zawodnik3Rep1.setBorder(BorderFactory.createLineBorder(Color.black));
         add(zawodnik3Rep1);
        JComboBox pozycjaZaw3Rep1ComboBox = new JComboBox();
         pozycjaZaw3Rep1ComboBox.setBounds(220,380,50,30);
         add(pozycjaZaw3Rep1ComboBox);

        JLabel lp4Rep1 = new JLabel("4. ");
        lp4Rep1.setBounds(10,420,20,30);
        add(lp4Rep1);
        zawodnik4Rep1.setBounds(30,420,180,30);
        zawodnik4Rep1.setBorder(BorderFactory.createLineBorder(Color.black));
        zawodnik4Rep1.setText("Jan Kowalski");
        add(zawodnik4Rep1);
        JComboBox pozycjaZaw4Rep1ComboBox = new JComboBox();
        pozycjaZaw4Rep1ComboBox.setBounds(220,420,50,30);
        add(pozycjaZaw4Rep1ComboBox);

//Sklady reprezentacji_2
        JLabel lp1Rep2 = new JLabel("1. ");
         lp1Rep2.setBounds(310, 300,20,30);
         add(lp1Rep2);
         zawodnik1Rep2.setBounds(330,300,180,30);
         zawodnik1Rep2.setBorder(BorderFactory.createLineBorder(Color.black));
         add(zawodnik1Rep2);
        JComboBox pozycjaZaw1Rep2ComboBox = new JComboBox();
         pozycjaZaw1Rep2ComboBox.setBounds(520,300,50,30);
         pozycjaZaw1Rep2ComboBox.addItem("ŚO");
         add(pozycjaZaw1Rep2ComboBox);
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


}
