package interfejsUzytkownikaModul.mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewMecze extends JFrame{
    private JList mundialList;
    private JList meczList;
    private JButton cofnijButton = new JButton("<< Cofnij <<"), buttonDalejDoPanelAdministratora;
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


    public ViewMecze() {
        super("Aktualizuj mecz");
        setSize(1050, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        int x = 10;
        int xx = 560;
        int h = 30;
        int y = 290;
        int w = 200;
        int a = 20;
        int b = 40;
        int d = 360;

//Lista rozwijalna Mundiale
        mundialList= new JList();
        JScrollPane mundialScrollList = new JScrollPane(mundialList);
        mundialScrollList.setBounds(10,20,160,200);
        add(mundialScrollList);

//Lista rozwijalna Mecze w wybranym mundialu
        meczList= new JList();
        JScrollPane meczScrollList = new JScrollPane(meczList);
        meczScrollList.setBounds(xx+95,20,365,200);
        add(meczScrollList);

//Wszystko dotyczace ustawienia daty meczu
        dataMeczLabel.setBounds(d,50,120,40);
        add(dataMeczLabel);

        dataRokLabel.setBounds(d-5,90,35,30);
        dataRokLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(dataRokLabel);

        JLabel przecinekLabel = new JLabel("-");
        przecinekLabel.setBounds(d+35,90,10,30);
        add(przecinekLabel);

        dataMiesiacTextField.setBounds(d+45,90,30,30);
        add(dataMiesiacTextField);

        JLabel przecinek2Label = new JLabel("-");
        przecinek2Label.setBounds(d+80,90,10,30);
        add(przecinek2Label);

        dataDzienTextField.setBounds(d+90,90,30,30);
        add(dataDzienTextField);

//Label wynik i dwukropek oraz TF gole_r1 gole_r2
        wynikLabel.setBounds(d+45,130,50,30);
        add(wynikLabel);

        goleRep1TextField.setBounds(d-20,160,50,50);
        add(goleRep1TextField);

        JLabel dwukropek = new JLabel(":");
        dwukropek.setBounds(d+70,160,50,50);
        add(dwukropek);

        goleRep2TextField.setBounds(d+105,160,50,50);
        add(goleRep2TextField);

//nazwaRep1 nazwaRep2 label
        nazwaRep1Label.setBounds(x+110,230,220,50);
        nazwaRep1Label.setHorizontalAlignment(SwingConstants.CENTER);
        nazwaRep1Label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(nazwaRep1Label);

        nazwaRep2Label.setBounds(xx+110,230,220,50);
        nazwaRep2Label.setHorizontalAlignment(SwingConstants.CENTER);
        nazwaRep2Label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(nazwaRep2Label);

//Sklady reprezentacji_1
        JLabel lp1Rep1 = new JLabel("1. ");
        JLabel lp2Rep1 = new JLabel("2. ");
        JLabel lp3Rep1 = new JLabel("3. ");
        JLabel lp4Rep1 = new JLabel("4. ");
        JLabel lp5Rep1 = new JLabel("5. ");
        JLabel lp6Rep1 = new JLabel("6. ");
        JLabel lp7Rep1 = new JLabel("7. ");
        JLabel lp8Rep1 = new JLabel("8. ");
        JLabel lp9Rep1 = new JLabel("9. ");
        JLabel lp10Rep1 = new JLabel("10. ");
        JLabel lp11Rep1 = new JLabel("11. ");
        JLabel lp12Rep1 = new JLabel("12. ");
        JLabel lp13Rep1 = new JLabel("13. ");
        JLabel lp14Rep1 = new JLabel("14. ");
        JLabel lp15Rep1 = new JLabel("15. ");
        JLabel lp16Rep1 = new JLabel("16. ");

        lp1Rep1.setBounds(x,y,a,h);
        lp3Rep1.setBounds(x,y+(h+5)*1,a,h);
        lp5Rep1.setBounds(x,y+(h+5)*2,a,h);
        lp7Rep1.setBounds(x,y+(h+5)*3,a,h);
        lp9Rep1.setBounds(x,y+(h+5)*4,a,h);
        lp11Rep1.setBounds(x,y+(h+5)*5,a,h);
        lp13Rep1.setBounds(x,y+(h+5)*6,a,h);
        lp15Rep1.setBounds(x,y+(h+5)*7,a,h);

        lp2Rep1.setBounds(x+w+b,y,a,h);
        lp4Rep1.setBounds(x+w+b,y+(h+5)*1,a,h);
        lp6Rep1.setBounds(x+w+b,y+(h+5)*2,a,h);
        lp8Rep1.setBounds(x+w+b,y+(h+5)*3,a,h);
        lp10Rep1.setBounds(x+w+b,y+(h+5)*4,a,h);
        lp12Rep1.setBounds(x+w+b,y+(h+5)*5,a,h);
        lp14Rep1.setBounds(x+w+b,y+(h+5)*6,a,h);
        lp16Rep1.setBounds(x+w+b,y+(h+5)*7,a,h);

        zaw1Rep1ComboBox.setBounds(x+a,y,w,h);
        zaw3Rep1ComboBox.setBounds(x+a,y+(h+5)*1,w,h);
        zaw5Rep1ComboBox.setBounds(x+a,y+(h+5)*2,w,h);
        zaw7Rep1ComboBox.setBounds(x+a,y+(h+5)*3,w,h);
        zaw9Rep1ComboBox.setBounds(x+a,y+(h+5)*4,w,h);
        zaw11Rep1ComboBox.setBounds(x+a,y+(h+5)*5,w,h);
        zaw13Rep1ComboBox.setBounds(x+a,y+(h+5)*6,w,h);
        zaw15Rep1ComboBox.setBounds(x+a,y+(h+5)*7,w,h);

        zaw2Rep1ComboBox.setBounds(x+w+a+b,y,w,h);
        zaw4Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*1,w,h);
        zaw6Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*2,w,h);
        zaw8Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*3,w,h);
        zaw10Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*4,w,h);
        zaw12Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*5,w,h);
        zaw14Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*6,w,h);
        zaw16Rep1ComboBox.setBounds(x+w+a+b,y+(h+5)*7,w,h);

        add(lp1Rep1);
        add(lp2Rep1);
        add(lp3Rep1);
        add(lp4Rep1);
        add(lp5Rep1);
        add(lp6Rep1);
        add(lp7Rep1);
        add(lp8Rep1);
        add(lp9Rep1);
        add(lp10Rep1);
        add(lp11Rep1);
        add(lp12Rep1);
        add(lp13Rep1);
        add(lp14Rep1);
        add(lp15Rep1);
        add(lp16Rep1);

        add(zaw1Rep1ComboBox);
        add(zaw2Rep1ComboBox);
        add(zaw3Rep1ComboBox);
        add(zaw4Rep1ComboBox);
        add(zaw5Rep1ComboBox);
        add(zaw6Rep1ComboBox);
        add(zaw7Rep1ComboBox);
        add(zaw8Rep1ComboBox);
        add(zaw9Rep1ComboBox);
        add(zaw10Rep1ComboBox);
        add(zaw11Rep1ComboBox);
        add(zaw12Rep1ComboBox);
        add(zaw13Rep1ComboBox);
        add(zaw14Rep1ComboBox);
        add(zaw15Rep1ComboBox);
        add(zaw16Rep1ComboBox);

//Sklady reprezentacji_2
        JLabel lp1Rep2 = new JLabel("1. ");
        JLabel lp2Rep2 = new JLabel("2. ");
        JLabel lp3Rep2 = new JLabel("3. ");
        JLabel lp4Rep2 = new JLabel("4. ");
        JLabel lp5Rep2 = new JLabel("5. ");
        JLabel lp6Rep2 = new JLabel("6. ");
        JLabel lp7Rep2 = new JLabel("7. ");
        JLabel lp8Rep2 = new JLabel("8. ");
        JLabel lp9Rep2 = new JLabel("9. ");
        JLabel lp10Rep2 = new JLabel("10. ");
        JLabel lp11Rep2 = new JLabel("11. ");
        JLabel lp12Rep2 = new JLabel("12. ");
        JLabel lp13Rep2 = new JLabel("13. ");
        JLabel lp14Rep2 = new JLabel("14. ");
        JLabel lp15Rep2 = new JLabel("15. ");
        JLabel lp16Rep2 = new JLabel("16. ");

        lp1Rep2.setBounds(xx,y,a,h);
        lp3Rep2.setBounds(xx,y+(h+5)*1,a,h);
        lp5Rep2.setBounds(xx,y+(h+5)*2,a,h);
        lp7Rep2.setBounds(xx,y+(h+5)*3,a,h);
        lp9Rep2.setBounds(xx,y+(h+5)*4,a,h);
        lp11Rep2.setBounds(xx,y+(h+5)*5,a,h);
        lp13Rep2.setBounds(xx,y+(h+5)*6,a,h);
        lp15Rep2.setBounds(xx,y+(h+5)*7,a,h);

        lp2Rep2.setBounds(xx+w+b,y,a,h);
        lp4Rep2.setBounds(xx+w+b,y+(h+5)*1,a,h);
        lp6Rep2.setBounds(xx+w+b,y+(h+5)*2,a,h);
        lp8Rep2.setBounds(xx+w+b,y+(h+5)*3,a,h);
        lp10Rep2.setBounds(xx+w+b,y+(h+5)*4,a,h);
        lp12Rep2.setBounds(xx+w+b,y+(h+5)*5,a,h);
        lp14Rep2.setBounds(xx+w+b,y+(h+5)*6,a,h);
        lp16Rep2.setBounds(xx+w+b,y+(h+5)*7,a,h);

        zaw1Rep2ComboBox.setBounds(xx+a,y,w,h);
        zaw3Rep2ComboBox.setBounds(xx+a,y+(h+5)*1,w,h);
        zaw5Rep2ComboBox.setBounds(xx+a,y+(h+5)*2,w,h);
        zaw7Rep2ComboBox.setBounds(xx+a,y+(h+5)*3,w,h);
        zaw9Rep2ComboBox.setBounds(xx+a,y+(h+5)*4,w,h);
        zaw11Rep2ComboBox.setBounds(xx+a,y+(h+5)*5,w,h);
        zaw13Rep2ComboBox.setBounds(xx+a,y+(h+5)*6,w,h);
        zaw15Rep2ComboBox.setBounds(xx+a,y+(h+5)*7,w,h);

        zaw2Rep2ComboBox.setBounds(xx+w+a+b,y,w,h);
        zaw4Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*1,w,h);
        zaw6Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*2,w,h);
        zaw8Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*3,w,h);
        zaw10Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*4,w,h);
        zaw12Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*5,w,h);
        zaw14Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*6,w,h);
        zaw16Rep2ComboBox.setBounds(xx+w+a+b,y+(h+5)*7,w,h);

        add(lp1Rep2);
        add(lp2Rep2);
        add(lp3Rep2);
        add(lp4Rep2);
        add(lp5Rep2);
        add(lp6Rep2);
        add(lp7Rep2);
        add(lp8Rep2);
        add(lp9Rep2);
        add(lp10Rep2);
        add(lp11Rep2);
        add(lp12Rep2);
        add(lp13Rep2);
        add(lp14Rep2);
        add(lp15Rep2);
        add(lp16Rep2);

        add(zaw1Rep2ComboBox);
        add(zaw2Rep2ComboBox);
        add(zaw3Rep2ComboBox);
        add(zaw4Rep2ComboBox);
        add(zaw5Rep2ComboBox);
        add(zaw6Rep2ComboBox);
        add(zaw7Rep2ComboBox);
        add(zaw8Rep2ComboBox);
        add(zaw9Rep2ComboBox);
        add(zaw10Rep2ComboBox);
        add(zaw11Rep2ComboBox);
        add(zaw12Rep2ComboBox);
        add(zaw13Rep2ComboBox);
        add(zaw14Rep2ComboBox);
        add(zaw15Rep2ComboBox);
        add(zaw16Rep2ComboBox);

// Przyciski cofnij i zatwierdz
        cofnijButton.setBounds(10,600,100,30);
        add(cofnijButton);
        dodajButton.setBounds(470,580,100,50);
        add(dodajButton);
            buttonDalejDoPanelAdministratora = new JButton(">> Koniec <<");
        buttonDalejDoPanelAdministratora.setBounds(910,600,110,30);
        add(buttonDalejDoPanelAdministratora);
    }

    public void addListModelToMundialList(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }
    public JList getMundialList() {
        return mundialList;
    }
    public void addMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }

    public void addListModelToMeczList(DefaultListModel meczListModel) { meczList.setModel(meczListModel);}
    public JList getMeczList() { return meczList; }
    public void addMeczListMouseListener(MouseAdapter listenMeczList) {
        meczList.addMouseListener(listenMeczList);
    }

    public void setRokToLabel(String rok) { dataRokLabel.setText(rok); }
    public String getMiesiacFromTextField() { return dataMiesiacTextField.getText(); }
    public void setMiesiacToTF(Object miesiac) { dataMiesiacTextField.setText(String.valueOf(miesiac));}
    public String getDzienFromTextField() { return dataDzienTextField.getText(); }
    public void setDzienToTF(Object dzien) { dataDzienTextField.setText(String.valueOf(dzien));}

    public String getGoleRep1() { return goleRep1TextField.getText(); }
    public void setGoleRep1(Object gole) { goleRep1TextField.setText(String.valueOf(gole));}
    public String getGoleRep2() { return goleRep2TextField.getText(); }
    public void setGoleRep2(Object gole) {goleRep2TextField.setText(String.valueOf(gole));}

    public void setNazwaRep1(String nazwaReprezentacji) {nazwaRep1Label.setText(nazwaReprezentacji); }
    public void setNazwaRep2(String nazwaReprezentacji) {nazwaRep2Label.setText(nazwaReprezentacji); }
    public String getNazwaReprezentacji1FromLabel() { return nazwaRep1Label.getText(); }
    public String getNazwaReprezentacji2FromLabel() { return nazwaRep2Label.getText(); }

    public void addComboBoxModelToZawodnik1Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw1Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik2Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw2Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik3Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw3Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik4Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw4Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik5Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw5Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik6Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw6Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik7Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw7Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik8Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw8Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik9Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw9Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik10Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw10Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik11Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw11Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik12Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw12Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik13Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw13Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik14Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw14Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik15Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw15Rep1ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik16Rep1ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw16Rep1ComboBox.setModel(zawodnikComboBoxModel);}

    public void addComboBoxModelToZawodnik1Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw1Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik2Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw2Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik3Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw3Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik4Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw4Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik5Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw5Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik6Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw6Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik7Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw7Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik8Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw8Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik9Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw9Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik10Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw10Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik11Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw11Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik12Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw12Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik13Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw13Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik14Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw14Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik15Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw15Rep2ComboBox.setModel(zawodnikComboBoxModel);}
    public void addComboBoxModelToZawodnik16Rep2ComboBox(DefaultComboBoxModel zawodnikComboBoxModel) {zaw16Rep2ComboBox.setModel(zawodnikComboBoxModel);}

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {cofnijButton.addActionListener(listenCofnijButton); }
    public void addDodajButtonListener(ActionListener listenDodajButton) {dodajButton.addActionListener(listenDodajButton); }

    public void setButtonDalejDoPanelAdministratoraActionListener(ActionListener listenButtonDalejDoPanelAdministratora) {
        buttonDalejDoPanelAdministratora.addActionListener(listenButtonDalejDoPanelAdministratora);
    }



}
