package koczwara.mundialv1.MVC.View;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewGrupaDodaj extends JFrame{
    private JButton dodajGrAButton = new JButton("A >");
    private JButton dodajGrBButton = new JButton("B >");
    private JButton dodajGrCButton = new JButton("C >");
    private JButton dodajGrDButton = new JButton("D >");
    private JButton dodajGrEButton = new JButton("E >");
    private JButton dodajGrFButton = new JButton("F >");
    private JButton dodajGrGButton = new JButton("G >");
    private JButton dodajGrHButton = new JButton("H >");
    private JButton cofnijButton = new JButton("<< Cofnij <<"), buttonDalejDodajZawodnika;
    private JList mundialList, reprezentacjaList;
    private JList grupaAList, grupaBList, grupaCList, grupaDList, grupaEList, grupaFList, grupaGList, grupaHList;
    private JLabel grupaALabel = new JLabel("Grupa A");
    private JLabel grupaBLabel = new JLabel("Grupa B");
    private JLabel grupaCLabel = new JLabel("Grupa C");
    private JLabel grupaDLabel = new JLabel("Grupa D");
    private JLabel grupaELabel = new JLabel("Grupa E");
    private JLabel grupaFLabel = new JLabel("Grupa F");
    private JLabel grupaGLabel = new JLabel("Grupa G");
    private JLabel grupaHLabel = new JLabel("Grupa H");
    private JButton usunGrAButton = new JButton("< A");
    private JButton usunGrBButton = new JButton("< B");
    private JButton usunGrCButton = new JButton("< C");
    private JButton usunGrDButton = new JButton("< D");
    private JButton usunGrEButton = new JButton("< E");
    private JButton usunGrFButton = new JButton("< F");
    private JButton usunGrGButton = new JButton("< G");
    private JButton usunGrHButton = new JButton("< H");

    public ViewGrupaDodaj() {
        super("Dodawanie reprezentacji do grup");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        mundialList= new JList();
        JScrollPane mundialScrollPane = new JScrollPane(mundialList);
        mundialScrollPane.setBounds(50,20,160,200);
        add(mundialScrollPane);

        reprezentacjaList = new JList();
        JScrollPane scrollPaneGrupaAList = new JScrollPane(reprezentacjaList);
        scrollPaneGrupaAList.setBounds(220,20,180,200);
        add(scrollPaneGrupaAList);

        grupaAList = new JList();
        grupaALabel.setBounds(120, 235, 60, 20);
        add(grupaALabel);
        grupaAList.setBounds(80, 255, 150, 110);
        add(grupaAList);
        dodajGrAButton.setBounds(10,255,60,50);
        add(dodajGrAButton);
        usunGrAButton.setBounds(10,315,60,50);
        add(usunGrAButton);

        grupaBList = new JList();
        grupaBLabel.setBounds(380,235,60,20);
        add(grupaBLabel);
        grupaBList.setBounds(340,255,150,110);
        add(grupaBList);
        dodajGrBButton.setBounds(270,255,60,50);
        add(dodajGrBButton);
        usunGrBButton.setBounds(270,315,60,50);
        add(usunGrBButton);

        grupaCList = new JList();
        grupaCLabel.setBounds(640, 235, 60, 20);
        add(grupaCLabel);
        grupaCList.setBounds(600, 255, 150, 110);
        add(grupaCList);
        dodajGrCButton.setBounds(530,255,60,50);
        add(dodajGrCButton);
        usunGrCButton.setBounds(530,315,60,50);
        add(usunGrCButton);

        grupaDList = new JList();
        grupaDLabel.setBounds(120,375,60,20);
        add(grupaDLabel);
        grupaDList.setBounds(80,395,150,110);
        add(grupaDList);
        dodajGrDButton.setBounds(10,395,60,50);
        add(dodajGrDButton);
        usunGrDButton.setBounds(10,455,60,50);
        add(usunGrDButton);

        grupaEList = new JList();
        grupaELabel.setBounds(380,375,60,20);
        add(grupaELabel);
        grupaEList.setBounds(340,395,150,110);
        add(grupaEList);
        dodajGrEButton.setBounds(270,395,60,50);
        add(dodajGrEButton);
        usunGrEButton.setBounds(270,455,60,50);
        add(usunGrEButton);

        grupaFList = new JList();
        grupaFLabel.setBounds(640,375,60,20);
        add(grupaFLabel);
        grupaFList.setBounds(600,395,150,110);
        add(grupaFList);
        dodajGrFButton.setBounds(530,395,60,50);
        add(dodajGrFButton);
        usunGrFButton.setBounds(530,455,60,50);
        add(usunGrFButton);

        grupaGList = new JList();
        grupaGLabel.setBounds(120,515,60,20);
        add(grupaGLabel);
        grupaGList.setBounds(80,535,150,110);
        add(grupaGList);
        dodajGrGButton.setBounds(10,535,60,50);
        add(dodajGrGButton);
        usunGrGButton.setBounds(10,595,60,50);
        add(usunGrGButton);

        grupaHList = new JList();
        grupaHLabel.setBounds(380,515,60,20);
        add(grupaHLabel);
        grupaHList.setBounds(340,535,150,110);
        add(grupaHList);
        dodajGrHButton.setBounds(270,535,60,50);
        add(dodajGrHButton);
        usunGrHButton.setBounds(270,595,60,50);
        add(usunGrHButton);

        cofnijButton.setBounds(20,680,100,30);
        add(cofnijButton);

            buttonDalejDodajZawodnika = new JButton(">> Dalej >>");
        buttonDalejDodajZawodnika.setBounds(650,680,100,30);
        add(buttonDalejDodajZawodnika);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void addListModelToMundialList(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }

    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }

    public void addMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }

    public void addReprezentacjaListMouseListener(MouseAdapter listenReprezentacjaList) {
        reprezentacjaList.addMouseListener(listenReprezentacjaList);
    }

    public JList getMundialList() {
        return mundialList;
    }

    public JList getReprezentacjaList() {
        return reprezentacjaList;
    }

    public void addListModelToGrupaAList(DefaultListModel grupaAListModel) {
        grupaAList.setModel(grupaAListModel);
    }

    public void addListModelToGrupaBList(DefaultListModel grupaBListModel) {
        grupaBList.setModel(grupaBListModel);
    }

    public void addListModelToGrupaCList(DefaultListModel grupaCListModel) {
        grupaCList.setModel(grupaCListModel);
    }

    public void addListModelToGrupaDList(DefaultListModel grupaDListModel) {
        grupaDList.setModel(grupaDListModel);
    }

    public void addListModelToGrupaEList(DefaultListModel grupaEListModel) {
        grupaEList.setModel(grupaEListModel);
    }

    public void addListModelToGrupaFList(DefaultListModel grupaFListModel) {
        grupaFList.setModel(grupaFListModel);
    }

    public void addListModelToGrupaGList(DefaultListModel grupaGListModel) {
        grupaGList.setModel(grupaGListModel);
    }

    public void addListModelToGrupaHList(DefaultListModel grupaHListModel) {
        grupaHList.setModel(grupaHListModel);
    }

    public void addDodajGrAButtonListener(ActionListener listenDodajGrupaAButton) {
        dodajGrAButton.addActionListener(listenDodajGrupaAButton);
    }

    public void addDodajGrBButtonListener(ActionListener listenDodajGrupaBButton) {
        dodajGrBButton.addActionListener(listenDodajGrupaBButton);
    }

    public void addDodajGrCButtonListener(ActionListener listenDodajGrupaCButton) {
        dodajGrCButton.addActionListener(listenDodajGrupaCButton);
    }

    public void addDodajGrDButtonListener(ActionListener listenDodajGrupaDButton) {
        dodajGrDButton.addActionListener(listenDodajGrupaDButton);
    }

    public void addDodajGrEButtonListener(ActionListener listenDodajGrupaEButton) {
        dodajGrEButton.addActionListener(listenDodajGrupaEButton);
    }

    public void addDodajGrFButtonListener(ActionListener listenDodajGrupaFButton) {
        dodajGrFButton.addActionListener(listenDodajGrupaFButton);
    }

    public void addDodajGrGButtonListener(ActionListener listenDodajGrupaGButton) {
        dodajGrGButton.addActionListener(listenDodajGrupaGButton);
    }

    public void addDodajGrHButtonListener(ActionListener listenDodajGrupaHButton) {
        dodajGrHButton.addActionListener(listenDodajGrupaHButton);
    }

    public void addUsunGrAButtonListener(ActionListener listenUsunGrupaAButton) {
        usunGrAButton.addActionListener(listenUsunGrupaAButton);
    }

    public void addUsunGrBButtonListener(ActionListener listenUsunGrupaBButton) {
        usunGrBButton.addActionListener(listenUsunGrupaBButton);
    }

    public void addUsunGrCButtonListener(ActionListener listenUsunGrupaCButton) {
        usunGrCButton.addActionListener(listenUsunGrupaCButton);
    }

    public void addUsunGrDButtonListener(ActionListener listenUsunGrupaDButton) {
        usunGrDButton.addActionListener(listenUsunGrupaDButton);
    }

    public void addUsunGrEButtonListener(ActionListener listenUsunGrupaEButton) {
        usunGrEButton.addActionListener(listenUsunGrupaEButton);
    }

    public void addUsunGrFButtonListener(ActionListener listenUsunGrupaFButton) {
        usunGrFButton.addActionListener(listenUsunGrupaFButton);
    }

    public void addUsunGrGButtonListener(ActionListener listenUsunGrupaGButton) {
        usunGrGButton.addActionListener(listenUsunGrupaGButton);
    }

    public void addUsunGrHButtonListener(ActionListener listenUsunGrupaHButton) {
        usunGrHButton.addActionListener(listenUsunGrupaHButton);
    }

    public JList getGrupaAList() { return grupaAList; }
    public JList getGrupaBList() { return grupaBList; }
    public JList getGrupaCList() { return grupaCList; }
    public JList getGrupaDList() { return grupaDList; }
    public JList getGrupaEList() { return grupaEList; }
    public JList getGrupaFList() { return grupaFList; }
    public JList getGrupaGList() { return grupaGList; }
    public JList getGrupaHList() { return grupaHList; }

    public void setButtonDalejDodajZawodnikaActionListener(ActionListener listenButtonDalejDodajZawodnika) {
        buttonDalejDodajZawodnika.addActionListener(listenButtonDalejDodajZawodnika);
    }
}
