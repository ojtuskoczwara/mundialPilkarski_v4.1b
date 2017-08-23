package koczwara.mundialv1.MVC.View.EkranGlowny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewWyniki extends JFrame{
    private JButton cofnijButton = new JButton("<< Cofnij");
    private JLabel dataMeczLabel = new JLabel("Data meczu:");
    private JLabel wynikLabel = new JLabel("Wynik:");
    private JLabel dataRokLabel, dataMiesiacLabel, dataDzienLabel;
    private JLabel nazwaRep1Label,nazwaRep2Label;
    private JLabel goleRep1Label, goleRep2Label;
    private JList mundialList, meczList;
    private JLabel r1z1,r1z2,r1z3,r1z4,r1z5,r1z6,r1z7,r1z8,r1z9,r1z10,r1z11,r1z12,r1z13,r1z14,r1z15,r1z16;
    private JLabel r2z1,r2z2,r2z3,r2z4,r2z5,r2z6,r2z7,r2z8,r2z9,r2z10,r2z11,r2z12,r2z13,r2z14,r2z15,r2z16;

    public ViewWyniki() {
        super("Aktualizuj mecz");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

//Lista rozwijalna Mundiale
        mundialList= new JList();
        JScrollPane mundialScrollList = new JScrollPane(mundialList);
        mundialScrollList.setBounds(10,20,160,200);
        add(mundialScrollList);

//Lista rozwijalna Mecze w wybranym mundialu
        meczList= new JList();
        JScrollPane meczScrollList = new JScrollPane(meczList);
        meczScrollList.setBounds(410,20,365,200);
        add(meczScrollList);

//Wszystko dotyczace ustawienia daty meczu
        dataMeczLabel.setBounds(220,50,120,40);
        add(dataMeczLabel);

        dataRokLabel = new JLabel();
        dataRokLabel.setBounds(220,90,30,30);
        dataRokLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(dataRokLabel);

        JLabel przecinekLabel = new JLabel("-");
        przecinekLabel.setBounds(255,90,10,30);
        add(przecinekLabel);

        dataMiesiacLabel = new JLabel();
        dataMiesiacLabel.setBounds(265,90,30,30);
        dataMiesiacLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(dataMiesiacLabel);

        JLabel przecinek2Label = new JLabel("-");
        przecinek2Label.setBounds(298,90,10,30);
        add(przecinek2Label);

        dataDzienLabel = new JLabel();
        dataDzienLabel.setBounds(310,90,30,30);
        dataDzienLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(dataDzienLabel);

//Label wynik i dwukropek oraz TF gole_r1 gole_r2
        wynikLabel.setBounds(265,130,50,30);
        add(wynikLabel);

        goleRep1Label = new JLabel();
        goleRep1Label.setBounds(200,160,50,50);
        add(goleRep1Label);

        JLabel dwukropek = new JLabel(":");
        dwukropek.setBounds(287,160,50,50);
        add(dwukropek);

        goleRep2Label = new JLabel();
        goleRep2Label.setBounds(325,160,50,50);
        add(goleRep2Label);

//nazwaRep1 nazwaRep2 label
        nazwaRep1Label = new JLabel();
        nazwaRep1Label.setBounds(10,230,160,50);
        nazwaRep1Label.setHorizontalAlignment(SwingConstants.CENTER);
        nazwaRep1Label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(nazwaRep1Label);

        nazwaRep2Label = new JLabel();
        nazwaRep2Label.setBounds(410,230,160,50);
        nazwaRep2Label.setHorizontalAlignment(SwingConstants.CENTER);
        nazwaRep2Label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(nazwaRep2Label);

//Sklady reprezentacji_1
        r1z1= new JLabel();
        r1z2= new JLabel();
        r1z3= new JLabel();
        r1z4= new JLabel();
        r1z5= new JLabel();
        r1z6= new JLabel();
        r1z7= new JLabel();
        r1z8= new JLabel();
        r1z9= new JLabel();
        r1z10= new JLabel();
        r1z11= new JLabel();
        r1z12= new JLabel();
        r1z13= new JLabel();
        r1z14= new JLabel();
        r1z15= new JLabel();
        r1z16= new JLabel();
        JLabel lp1Rep1 = new JLabel("1. ");
        lp1Rep1.setBounds(10,290,20,30);
        add(lp1Rep1);
        r1z1.setBounds(30,290,200,30);
        add(r1z1);
        JLabel lp2Rep1 = new JLabel("2. ");
        lp2Rep1.setBounds(10,325,20,30);
        add(lp2Rep1);
        r1z2.setBounds(30,325,200,30);
        add(r1z2);
        JLabel lp3Rep1 = new JLabel("3. ");
        lp3Rep1.setBounds(10,360,20,30);
        add(lp3Rep1);
        r1z3.setBounds(30,360,200,30);
        add(r1z3);
        JLabel lp4Rep1 = new JLabel("4. ");
        lp4Rep1.setBounds(10,395,20,30);
        add(lp4Rep1);
        r1z4.setBounds(30,395,200,30);
        add(r1z4);
        JLabel lp5Rep1 = new JLabel("5. ");
        lp5Rep1.setBounds(10,430,20,30);
        add(lp5Rep1);
        r1z5.setBounds(30,430,200,30);
        add(r1z5);
        JLabel lp6Rep1 = new JLabel("6. ");
        lp6Rep1.setBounds(10,465,20,30);
        add(lp6Rep1);
        r1z6.setBounds(30,465,200,30);
        add(r1z6);
        JLabel lp7Rep1 = new JLabel("7. ");
        lp7Rep1.setBounds(10,500,20,30);
        add(lp7Rep1);
        r1z7.setBounds(30,500,200,30);
        add(r1z7);
        JLabel lp8Rep1 = new JLabel("8. ");
        lp8Rep1.setBounds(10,535,20,30);
        add(lp8Rep1);
        r1z8.setBounds(30,535,200,30);
        add(r1z8);
        JLabel lp9Rep1 = new JLabel("9. ");
        lp9Rep1.setBounds(10,570,20,30);
        add(lp9Rep1);
        r1z9.setBounds(30,570,200,30);
        add(r1z9);
        JLabel lp10Rep1 = new JLabel("10. ");
        lp10Rep1.setBounds(10,605,20,30);
        add(lp10Rep1);
        r1z10.setBounds(30,605,200,30);
        add(r1z10);
        JLabel lp11Rep1 = new JLabel("11. ");
        lp11Rep1.setBounds(10,640,20,30);
        add(lp11Rep1);
        r1z11.setBounds(30,640,200,30);
        add(r1z11);
        JLabel lp12Rep1 = new JLabel("12. ");
        lp12Rep1.setBounds(10,675,20,30);
        add(lp12Rep1);
        r1z12.setBounds(30,675,200,30);
        add(r1z12);
        JLabel lp13Rep1 = new JLabel("13. ");
        lp13Rep1.setBounds(10,710,20,30);
        add(lp13Rep1);
        r1z13.setBounds(30,710,200,30);
        add(r1z13);
        JLabel lp14Rep1 = new JLabel("14. ");
        lp14Rep1.setBounds(10,745,20,30);
        add(lp14Rep1);
        r1z14.setBounds(30,745,200,30);
        add(r1z14);
        JLabel lp15Rep1 = new JLabel("15. ");
        lp15Rep1.setBounds(10,780,20,30);
        add(lp15Rep1);
        r1z15.setBounds(30,780,200,30);
        add(r1z15);
        JLabel lp16Rep1 = new JLabel("16. ");
        lp16Rep1.setBounds(10,815,20,30);
        add(lp16Rep1);
        r1z16.setBounds(30,815,200,30);
        add(r1z16);

//Sklady reprezentacji_2
        r2z1= new JLabel();
        r2z2= new JLabel();
        r2z3= new JLabel();
        r2z4= new JLabel();
        r2z5= new JLabel();
        r2z6= new JLabel();
        r2z7= new JLabel();
        r2z8= new JLabel();
        r2z9= new JLabel();
        r2z10= new JLabel();
        r2z11= new JLabel();
        r2z12= new JLabel();
        r2z13= new JLabel();
        r2z14= new JLabel();
        r2z15= new JLabel();
        r2z16= new JLabel();
        JLabel lp1Rep2 = new JLabel("1. ");
        lp1Rep2.setBounds(310, 290,20,30);
        add(lp1Rep2);
        r2z1.setBounds(330,290,200,30);
        add(r2z1);
        JLabel lp2Rep2 = new JLabel("2. ");
        lp2Rep2.setBounds(310,325,20,30);
        add(lp2Rep2);
        r2z2.setBounds(330,325,200,30);
        add(r2z2);
        JLabel lp3Rep2 = new JLabel("3. ");
        lp3Rep2.setBounds(310,360,20,30);
        add(lp3Rep2);
        r2z3.setBounds(330,360,200,30);
        add(r2z3);
        JLabel lp4Rep2 = new JLabel("4. ");
        lp4Rep2.setBounds(310,395,20,30);
        add(lp4Rep2);
        r2z4.setBounds(330,395,200,30);
        add(r2z4);
        JLabel lp5Rep2 = new JLabel("5. ");
        lp5Rep2.setBounds(310,430,20,30);
        add(lp5Rep2);
        r2z5.setBounds(330,430,200,30);
        add(r2z5);
        JLabel lp6Rep2 = new JLabel("6. ");
        lp6Rep2.setBounds(310,465,20,30);
        add(lp6Rep2);
        r2z6.setBounds(330,465,200,30);
        add(r2z6);
        JLabel lp7Rep2 = new JLabel("7. ");
        lp7Rep2.setBounds(310,500,20,30);
        add(lp7Rep2);
        r2z7.setBounds(330,500,200,30);
        add(r2z7);
        JLabel lp8Rep2 = new JLabel("8. ");
        lp8Rep2.setBounds(310,535,20,30);
        add(lp8Rep2);
        r2z8.setBounds(330,535,200,30);
        add(r2z8);
        JLabel lp9Rep2 = new JLabel("9. ");
        lp9Rep2.setBounds(310,570,20,30);
        add(lp9Rep2);
        r2z9.setBounds(330,570,200,30);
        add(r2z9);
        JLabel lp10Rep2 = new JLabel("10. ");
        lp10Rep2.setBounds(310,605,20,30);
        add(lp10Rep2);
        r2z10.setBounds(330,605,200,30);
        add(r2z10);
        JLabel lp11Rep2 = new JLabel("11. ");
        lp11Rep2.setBounds(310,640,20,30);
        add(lp11Rep2);
        r2z11.setBounds(330,640,200,30);
        add(r2z11);
        JLabel lp12Rep2 = new JLabel("12. ");
        lp12Rep2.setBounds(310,675,20,30);
        add(lp12Rep2);
        r2z12.setBounds(330,675,200,30);
        add(r2z12);
        JLabel lp13Rep2 = new JLabel("13. ");
        lp13Rep2.setBounds(310,710,20,30);
        add(lp13Rep2);
        r2z13.setBounds(330,710,200,30);
        add(r2z13);
        JLabel lp14Rep2 = new JLabel("14. ");
        lp14Rep2.setBounds(310,745,20,30);
        add(lp14Rep2);
        r2z14.setBounds(330,745,200,30);
        add(r2z14);
        JLabel lp15Rep2 = new JLabel("15. ");
        lp15Rep2.setBounds(310,780,20,30);
        add(lp15Rep2);
        r2z15.setBounds(330,780,200,30);
        add(r2z15);
        JLabel lp16Rep2 = new JLabel("16. ");
        lp16Rep2.setBounds(310,815,20,30);
        add(lp16Rep2);
        r2z16.setBounds(330,815,200,30);
        add(r2z16);

        cofnijButton.setBounds(10,900,100,50);
        add(cofnijButton);
    }

    public void addListModelToMundialList(DefaultListModel mundialListModel) { mundialList.setModel(mundialListModel);}
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

    public void setRokLabel(String rok) { dataRokLabel.setText(rok); }
    public void setMiesiacLabel(String miesiac) { dataMiesiacLabel.setText(miesiac);}
    public void setDzienLabel(String dzien) { dataDzienLabel.setText(dzien);}

    public void setGoleRep1(Object gole) { goleRep1Label.setText(String.valueOf(gole));}
    public void setGoleRep2(Object gole) { goleRep2Label.setText(String.valueOf(gole));}

    public void setNazwaRep1(String nazwaReprezentacji) {nazwaRep1Label.setText(nazwaReprezentacji); }
    public void setNazwaRep2(String nazwaReprezentacji) {nazwaRep2Label.setText(nazwaReprezentacji); }

    public void setRep1Zaw1Label(String imieNazwisko) { r1z1.setText(imieNazwisko);}
    public void setRep1Zaw2Label(String imieNazwisko) { r1z2.setText(imieNazwisko);}
    public void setRep1Zaw3Label(String imieNazwisko) { r1z3.setText(imieNazwisko);}
    public void setRep1Zaw4Label(String imieNazwisko) { r1z4.setText(imieNazwisko);}
    public void setRep1Zaw5Label(String imieNazwisko) { r1z5.setText(imieNazwisko);}
    public void setRep1Zaw6Label(String imieNazwisko) { r1z6.setText(imieNazwisko);}
    public void setRep1Zaw7Label(String imieNazwisko) { r1z7.setText(imieNazwisko);}
    public void setRep1Zaw8Label(String imieNazwisko) { r1z8.setText(imieNazwisko);}
    public void setRep1Zaw9Label(String imieNazwisko) { r1z9.setText(imieNazwisko);}
    public void setRep1Zaw10Label(String imieNazwisko) { r1z10.setText(imieNazwisko);}
    public void setRep1Zaw11Label(String imieNazwisko) { r1z11.setText(imieNazwisko);}
    public void setRep1Zaw12Label(String imieNazwisko) { r1z12.setText(imieNazwisko);}
    public void setRep1Zaw13Label(String imieNazwisko) { r1z13.setText(imieNazwisko);}
    public void setRep1Zaw14Label(String imieNazwisko) { r1z14.setText(imieNazwisko);}
    public void setRep1Zaw15Label(String imieNazwisko) { r1z15.setText(imieNazwisko);}
    public void setRep1Zaw16Label(String imieNazwisko) { r1z16.setText(imieNazwisko);}

    public void setRep2Zaw1Label(String imieNazwisko) { r2z1.setText(imieNazwisko);}
    public void setRep2Zaw2Label(String imieNazwisko) { r2z2.setText(imieNazwisko);}
    public void setRep2Zaw3Label(String imieNazwisko) { r2z3.setText(imieNazwisko);}
    public void setRep2Zaw4Label(String imieNazwisko) { r2z4.setText(imieNazwisko);}
    public void setRep2Zaw5Label(String imieNazwisko) { r2z5.setText(imieNazwisko);}
    public void setRep2Zaw6Label(String imieNazwisko) { r2z6.setText(imieNazwisko);}
    public void setRep2Zaw7Label(String imieNazwisko) { r2z7.setText(imieNazwisko);}
    public void setRep2Zaw8Label(String imieNazwisko) { r2z8.setText(imieNazwisko);}
    public void setRep2Zaw9Label(String imieNazwisko) { r2z9.setText(imieNazwisko);}
    public void setRep2Zaw10Label(String imieNazwisko) { r2z10.setText(imieNazwisko);}
    public void setRep2Zaw11Label(String imieNazwisko) { r2z11.setText(imieNazwisko);}
    public void setRep2Zaw12Label(String imieNazwisko) { r2z12.setText(imieNazwisko);}
    public void setRep2Zaw13Label(String imieNazwisko) { r2z13.setText(imieNazwisko);}
    public void setRep2Zaw14Label(String imieNazwisko) { r2z14.setText(imieNazwisko);}
    public void setRep2Zaw15Label(String imieNazwisko) { r2z15.setText(imieNazwisko);}
    public void setRep2Zaw16Label(String imieNazwisko) { r2z16.setText(imieNazwisko);}

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {cofnijButton.addActionListener(listenCofnijButton); }
}
