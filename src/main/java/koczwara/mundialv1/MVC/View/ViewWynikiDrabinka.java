package koczwara.mundialv1.MVC.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class ViewWynikiDrabinka extends JFrame{
    private JComboBox mundialComboBox = new JComboBox();
    private CheckboxGroup checkboxGroupWyniki;
    private Checkbox checkboxGrupa, checkboxJednaOsma, checkboxJednaCzwarta, checkboxJednaDruga, checkboxFinal;
    private JLabel labelGrARep1,labelGrARep2, labelGrBRep1,labelGrBRep2, labelGrCRep1,labelGrCRep2, labelGrDRep1,labelGrDRep2, labelGrERep1,labelGrERep2, labelGrFRep1,labelGrFRep2, labelGrGRep1,labelGrGRep2, labelGrHRep1,labelGrHRep2;
    private JLabel labelGrA, labelGrB, labelGrC, labelGrD, labelGrE, labelGrF, labelGrG, labelGrH;
    private JPanel panelGorny, panelDolny, panelFazaGrupowa, panelFazaJednaOsma, panelFazaJednaCzwarta, panelFazaJednaDruga, panelFinal;
    private JPanel panelFazaGrupowaGrA,panelFazaGrupowaGrB, panelFazaGrupowaGrC,panelFazaGrupowaGrD,panelFazaGrupowaGrE,panelFazaGrupowaGrF,panelFazaGrupowaGrG,panelFazaGrupowaGrH;
    private JButton buttonCofnij;
    private JLabel labelJednaOsmaHash1,labelJednaOsmaHash2,labelJednaOsmaHash3,labelJednaOsmaHash4,labelJednaOsmaHash5,labelJednaOsmaHash6,labelJednaOsmaHash7,labelJednaOsmaHash8;
    private JLabel label18Hash1Rep1,label18Hash1Rep2,label18Hash2Rep1, label18Hash2Rep2,label18Hash3Rep1,label18Hash3Rep2,label18Hash4Rep1,label18Hash4Rep2,label18Hash5Rep1,label18Hash5Rep2,label18Hash6Rep1,label18Hash6Rep2;
    private JLabel label18Hash7Rep1,label18Hash7Rep2,label18Hash8Rep1,label18Hash8Rep2;
    private JLabel labelJednaOsmaHash1GoleRep1,labelJednaOsmaHashGoleRep2,labelJednaOsmaHash2GoleRep1,labelJednaOsmaHash2GoleRep2,labelJednaOsmaHash3GoleRep1,labelJednaOsmaHash3GoleRep2,labelJednaOsmaHash4GoleRep1,labelJednaOsmaHash4GoleRep2;
    private JLabel labelJednaOsmaHash5GoleRep1,labelJednaOsmaHash5GoleRep2,labelJednaOsmaHash6GoleRep1,labelJednaOsmaHash6GoleRep2,labelJednaOsmaHash7GoleRep1,labelJednaOsmaHash7GoleRep2,labelJednaOsmaHash8GoleRep1,labelJednaOsmaHash8GoleRep2;
    private JLabel labelJednaCzwartaHash1,labelJednaCzwartaHash2,labelJednaCzwartaHash3,labelJednaCzwartaHash4;
    private JLabel labelJednaDrugaHash1,labelJednaDrugaHash2;
    private JLabel labelFinal;

    public ViewWynikiDrabinka() {
        int maxSzer = 600;
        int maxWys = 500;
        int szer = 180;
        int wys = 80;
        int x1 = 10;
        int y1 = 10;
        int x2 = x1+szer+10;
        int y2 = y1+wys+10;
        int x3 = x2+szer+10;
        int y3 = y2+wys+10;
        int xLabel = 20;
        int yLabel1 = 30;
        int yLabel2 = 50;
        int xLabelGr = szer/2 -20;
        int szerLabel = szer-xLabel;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(maxSzer,maxWys);
        setTitle("Wyniki meczów");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

// Panel gorny w ktorym sa MundialLista oraz checkboxyFazaMundialu
        panelGorny = new JPanel();
        panelGorny.setBounds(5,5,maxSzer-20,35);
        panelGorny.setBackground(Color.GRAY);
        mundialComboBox.setBounds(10,10,150,30);
        panelGorny.add(mundialComboBox);
        checkboxGroupWyniki = new CheckboxGroup();
        checkboxGrupa = new Checkbox("Faza grupowa", checkboxGroupWyniki, true);
        panelGorny.add(checkboxGrupa);
        checkboxJednaOsma = new Checkbox("1/8", checkboxGroupWyniki,false);
        panelGorny.add(checkboxJednaOsma);
        checkboxJednaCzwarta = new Checkbox("1/4", checkboxGroupWyniki, false);
        panelGorny.add(checkboxJednaCzwarta);
        checkboxJednaDruga = new Checkbox("1/2", checkboxGroupWyniki, false);
        panelGorny.add(checkboxJednaDruga);
        checkboxFinal = new Checkbox("Final", checkboxGroupWyniki, false);
        panelGorny.add(checkboxFinal);
        this.add(panelGorny);

// Panel dolny w ktorym sa buttonCofnij
        panelDolny = new JPanel();
        panelDolny.setBounds(5,maxWys-100, maxSzer-20,60);
        panelDolny.setBackground(Color.GRAY);
        buttonCofnij = new JButton("<< COFNIJ");
        buttonCofnij.setBounds(10,10, 60,60);
        panelDolny.add(buttonCofnij);
        this.add(panelDolny);

// PANEL FAZA GRUPOWA
        panelFazaGrupowa = new JPanel();
        panelFazaGrupowa.setBounds(5,45, maxSzer-20, maxWys-150);
        panelFazaGrupowa.setBackground(Color.GRAY);
        panelFazaGrupowa.setLayout(null);
        //------------------------- Panel podrzedny grupa A ------------------------------------
        panelFazaGrupowaGrA = new JPanel();
        panelFazaGrupowaGrA.setBounds(x1,y1,szer, wys);
        panelFazaGrupowaGrA.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrA.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrA.setLayout(null);
         //Label do Gr A
        labelGrA = new JLabel("Grupa A");
        labelGrA.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrA.add(labelGrA);
        JLabel lp1A = new JLabel("1. ");
        lp1A.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrA.add(lp1A);
        labelGrARep1 = new JLabel();
        labelGrARep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrA.add(labelGrARep1);
        JLabel lp2A = new JLabel("2. ");
        lp2A.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrA.add(lp2A);
        labelGrARep2 = new JLabel();
        labelGrARep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrA.add(labelGrARep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrA);
        //------------------------- Panel podrzedny grupa B ------------------------------------
        panelFazaGrupowaGrB = new JPanel();
        panelFazaGrupowaGrB.setBounds(x2,y1,szer,wys);
        panelFazaGrupowaGrB.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrB.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrB.setLayout(null);
        //Label do Gr C
        labelGrB = new JLabel("Grupa B");
        labelGrB.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrB.add(labelGrB);
        JLabel lp1B = new JLabel("1. ");
        lp1B.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrB.add(lp1B);
        labelGrBRep1 = new JLabel();
        labelGrBRep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrB.add(labelGrBRep1);
        JLabel lp2B = new JLabel("2. ");
        lp2B.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrB.add(lp2B);
        labelGrBRep2 = new JLabel();
        labelGrBRep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrB.add(labelGrBRep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrB);
        //------------------------- Panel podrzedny grupa C ------------------------------------
        panelFazaGrupowaGrC = new JPanel();
        panelFazaGrupowaGrC.setBounds(x3,y1,szer,wys);
        panelFazaGrupowaGrC.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrC.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrC.setLayout(null);
        //Label do Gr C
        labelGrC = new JLabel("Grupa C");
        labelGrC.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrC.add(labelGrC);
        JLabel lp1C = new JLabel("1. ");
        lp1C.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrC.add(lp1C);
        labelGrCRep1 = new JLabel();
        labelGrCRep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrC.add(labelGrCRep1);
        JLabel lp2C = new JLabel("2. ");
        lp2C.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrC.add(lp2C);
        labelGrCRep2 = new JLabel();
        labelGrCRep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrC.add(labelGrCRep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrC);
        //------------------------- Panel podrzedny grupa D ------------------------------------
        panelFazaGrupowaGrD = new JPanel();
        panelFazaGrupowaGrD.setBounds(x1,y2,szer,wys);
        panelFazaGrupowaGrD.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrD.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrD.setLayout(null);
        //Label do Gr D
        labelGrD = new JLabel("Grupa D");
        labelGrD.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrD.add(labelGrD);
        JLabel lp1D = new JLabel("1. ");
        lp1D.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrD.add(lp1D);
        labelGrDRep1 = new JLabel();
        labelGrDRep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrD.add(labelGrDRep1);
        JLabel lp2D = new JLabel("2. ");
        lp2D.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrD.add(lp2D);
        labelGrDRep2 = new JLabel();
        labelGrDRep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrD.add(labelGrDRep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrD);
        //------------------------- Panel podrzedny grupa E ------------------------------------
        panelFazaGrupowaGrE = new JPanel();
        panelFazaGrupowaGrE.setBounds(x2,y2,szer,wys);
        panelFazaGrupowaGrE.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrE.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrE.setLayout(null);
        //Label do Gr E
        labelGrE = new JLabel("Grupa E");
        labelGrE.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrE.add(labelGrE);
        JLabel lp1E = new JLabel("1. ");
        lp1E.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrE.add(lp1E);
        labelGrERep1 = new JLabel();
        labelGrERep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrE.add(labelGrERep1);
        JLabel lp2E = new JLabel("2. ");
        lp2E.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrE.add(lp2E);
        labelGrERep2 = new JLabel();
        labelGrERep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrE.add(labelGrERep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrE);
        //------------------------- Panel podrzedny grupa F ------------------------------------
        panelFazaGrupowaGrF = new JPanel();
        panelFazaGrupowaGrF.setBounds(x3,y2,szer,wys);
        panelFazaGrupowaGrF.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrF.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrF.setLayout(null);
        //Label do Gr F
        labelGrF = new JLabel("Grupa F");
        labelGrF.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrF.add(labelGrF);
        JLabel lp1F = new JLabel("1. ");
        lp1F.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrF.add(lp1F);
        labelGrFRep1 = new JLabel();
        labelGrFRep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrF.add(labelGrFRep1);
        JLabel lp2F = new JLabel("2. ");
        lp2F.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrF.add(lp2F);
        labelGrFRep2 = new JLabel();
        labelGrFRep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrF.add(labelGrFRep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrF);
        //------------------------- Panel podrzedny grupa G ------------------------------------
        panelFazaGrupowaGrG = new JPanel();
        panelFazaGrupowaGrG.setBounds(x1,y3,szer,wys);
        panelFazaGrupowaGrG.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrG.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrG.setLayout(null);
        //Label do Gr G
        labelGrG = new JLabel("Grupa G");
        labelGrG.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrG.add(labelGrG);
        JLabel lp1G = new JLabel("1. ");
        lp1G.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrG.add(lp1G);
        labelGrGRep1 = new JLabel();
        labelGrGRep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrG.add(labelGrGRep1);
        JLabel lp2G = new JLabel("2. ");
        lp2G.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrG.add(lp2G);
        labelGrGRep2 = new JLabel();
        labelGrGRep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrG.add(labelGrGRep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrG);
        //------------------------- Panel podrzedny grupa H ------------------------------------
        panelFazaGrupowaGrH = new JPanel();
        panelFazaGrupowaGrH.setBounds(x2,y3,szer,wys);
        panelFazaGrupowaGrH.setBackground(Color.LIGHT_GRAY);
        panelFazaGrupowaGrH.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFazaGrupowaGrH.setLayout(null);
        //Label do Gr H
        labelGrH = new JLabel("Grupa H");
        labelGrH.setBounds(xLabelGr,0,50,20);
        panelFazaGrupowaGrH.add(labelGrH);
        JLabel lp1H = new JLabel("1. ");
        lp1H.setBounds(5,yLabel1,20,20);
        panelFazaGrupowaGrH.add(lp1H);
        labelGrHRep1 = new JLabel();
        labelGrHRep1.setBounds(xLabel,yLabel1,szerLabel,20);
        panelFazaGrupowaGrH.add(labelGrHRep1);
        JLabel lp2H = new JLabel("2. ");
        lp2H.setBounds(5,yLabel2,20,20);
        panelFazaGrupowaGrH.add(lp2H);
        labelGrHRep2 = new JLabel();
        labelGrHRep2.setBounds(xLabel,yLabel2,szerLabel,20);
        panelFazaGrupowaGrH.add(labelGrHRep2);
        panelFazaGrupowa.add(panelFazaGrupowaGrH);
        this.add(panelFazaGrupowa);

// PANEL FAZA 1/8


        panelFazaJednaOsma = new JPanel();
        panelFazaJednaOsma.setBounds(5,45, maxSzer-20, maxWys-150);
        panelFazaJednaOsma.setBackground(Color.GRAY);
        panelFazaJednaOsma.setLayout(null);
        //------------------------- Panel podrzedny 1/8 #1 ------------------------------------





        panelFazaGrupowa.setVisible(false);
    }

    public void setMundialModel(DefaultComboBoxModel dcbm) { mundialComboBox.setModel(dcbm); }
    public JComboBox getObjectModelMundialComboBox() { return mundialComboBox; }
    public void mundialComboBoxMouseListener(MouseAdapter listenClickOnMundialComboBox) { mundialComboBox.addMouseListener( listenClickOnMundialComboBox);}

    // chechboxyFazaRozgrywek
    public void checkboxFazaGrupowaMouseListener(MouseAdapter listenClickOnChechboxFazaGrupowa) { checkboxGrupa.addMouseListener(listenClickOnChechboxFazaGrupowa);}
    public void checkboxJednaOsmaMouseListener(MouseAdapter listenClickOnChechboxJednaOsma) { checkboxJednaOsma.addMouseListener(listenClickOnChechboxJednaOsma);}
    public void checkboxJednaCzwartaMouseListener(MouseAdapter listenClickOnChechboxJednaCzwarta) { checkboxJednaCzwarta.addMouseListener(listenClickOnChechboxJednaCzwarta);}
    public void checkboxJednaDrugaMouseListener(MouseAdapter listenClickOnChechboxJednaDruga) { checkboxJednaDruga.addMouseListener(listenClickOnChechboxJednaDruga);}
    public void checkboxFinalMouseListener(MouseAdapter listenClickOnChechboxFinal) { checkboxFinal.addMouseListener(listenClickOnChechboxFinal);}

    // faza grupowa action
    public void panelFazaGrupowaSetVisible(boolean trueOrFalse) { panelFazaGrupowa.setVisible(trueOrFalse);}

    public void setGrARep1(String reprezentacjaNazwa) { labelGrARep1.setText(reprezentacjaNazwa);}
    public void setGrARep2(String reprezentacjaNazwa) { labelGrARep2.setText(reprezentacjaNazwa);}
    public void setGrBRep1(String reprezentacjaNazwa) { labelGrBRep1.setText(reprezentacjaNazwa);}
    public void setGrBRep2(String reprezentacjaNazwa) { labelGrBRep2.setText(reprezentacjaNazwa);}
    public void setGrCRep1(String reprezentacjaNazwa) { labelGrCRep1.setText(reprezentacjaNazwa);}
    public void setGrCRep2(String reprezentacjaNazwa) { labelGrCRep2.setText(reprezentacjaNazwa);}
    public void setGrDRep1(String reprezentacjaNazwa) { labelGrDRep1.setText(reprezentacjaNazwa);}
    public void setGrDRep2(String reprezentacjaNazwa) { labelGrDRep2.setText(reprezentacjaNazwa);}
    public void setGrERep1(String reprezentacjaNazwa) { labelGrERep1.setText(reprezentacjaNazwa);}
    public void setGrERep2(String reprezentacjaNazwa) { labelGrERep2.setText(reprezentacjaNazwa);}
    public void setGrFRep1(String reprezentacjaNazwa) { labelGrFRep1.setText(reprezentacjaNazwa);}
    public void setGrFRep2(String reprezentacjaNazwa) { labelGrFRep2.setText(reprezentacjaNazwa);}
    public void setGrGRep1(String reprezentacjaNazwa) { labelGrGRep1.setText(reprezentacjaNazwa);}
    public void setGrGRep2(String reprezentacjaNazwa) { labelGrGRep2.setText(reprezentacjaNazwa);}
    public void setGrHRep1(String reprezentacjaNazwa) { labelGrHRep1.setText(reprezentacjaNazwa);}
    public void setGrHRep2(String reprezentacjaNazwa) { labelGrHRep2.setText(reprezentacjaNazwa);}

    // faza 1/8


}
