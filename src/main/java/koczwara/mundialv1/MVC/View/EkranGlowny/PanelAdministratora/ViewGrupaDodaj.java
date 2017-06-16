package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import java.awt.*;

public class ViewGrupaDodaj extends JFrame{
    private JButton dodajGrAButton = new JButton("Add A >");
    private JButton dodajGrBButton = new JButton("Add B >");
    private JButton dodajGrCButton = new JButton("Add C >");
    private JButton dodajGrDButton = new JButton("Add D >");
    private JButton dodajGrEButton = new JButton("Add E >");
    private JButton dodajGrFButton = new JButton("Add F >");
    private JButton dodajGrGButton = new JButton("Add G >");
    private JButton dodajGrHButton = new JButton("Add H >");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList mundialList, reprezentacjaList;
    private JList grupaAList, grupaBList, grupaCList, grupaDList, grupaEList, grupaFList, grupaGList, grupaHList;
    private DefaultListModel mundialListModel, reprezentacjaListModel;
    private DefaultListModel grupaAListModel,grupaBListModel,grupaCListModel,grupaDListModel,grupaEListModel,grupaFListModel,grupaGListModel,grupaHListModel;
    private JLabel grupaALabel = new JLabel("Grupa A");
    private JLabel grupaBLabel = new JLabel("Grupa B");
    private JLabel grupaCLabel = new JLabel("Grupa C");
    private JLabel grupaDLabel = new JLabel("Grupa D");
    private JLabel grupaELabel = new JLabel("Grupa E");
    private JLabel grupaFLabel = new JLabel("Grupa F");
    private JLabel grupaGLabel = new JLabel("Grupa G");
    private JLabel grupaHLabel = new JLabel("Grupa H");

    public ViewGrupaDodaj() {
        super("Dodawanie reprezentacji do grup");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        mundialListModel = new DefaultListModel();
        mundialList= new JList();
        mundialList.setBounds(50,20,120,200);
        add(mundialList);

        reprezentacjaListModel = new DefaultListModel();
        reprezentacjaList = new JList();
        reprezentacjaList.setBounds(200,20,120,200);
        JScrollPane scrollPaneGrupaAList = new JScrollPane(reprezentacjaList);
        scrollPaneGrupaAList.setBounds(200,20,120,200);
        add(scrollPaneGrupaAList);

        grupaAListModel = new DefaultListModel();
        grupaAList = new JList();
        grupaALabel.setBounds(120, 240, 60, 20);
        add(grupaALabel);
        grupaAList.setBounds(100, 260, 150, 100);
        add(grupaAList);
        dodajGrAButton.setBounds(10,280,80,50);
        add(dodajGrAButton);

        grupaBListModel = new DefaultListModel();
        grupaBList = new JList();
        grupaBLabel.setBounds(380,240,60,20);
        add(grupaBLabel);
        grupaBList.setBounds(360,260,150,100);
        add(grupaBList);
        dodajGrBButton.setBounds(270,280,80,50);
        add(dodajGrBButton);

        grupaCListModel = new DefaultListModel();
        grupaCList = new JList();
        grupaCLabel.setBounds(640, 240, 60, 20);
        add(grupaCLabel);
        grupaCList.setBounds(620, 260, 150, 100);
        add(grupaCList);
        dodajGrCButton.setBounds(530,280,80,50);
        add(dodajGrCButton);

        grupaDListModel = new DefaultListModel();
        grupaDList = new JList();
        grupaDLabel.setBounds(120,380,60,20);
        add(grupaDLabel);
        grupaDList.setBounds(100,400,150,100);
        add(grupaDList);
        dodajGrDButton.setBounds(10,420,80,50);
        add(dodajGrDButton);

        grupaEListModel = new DefaultListModel();
        grupaEList = new JList();
        grupaELabel.setBounds(380,380,60,20);
        add(grupaELabel);
        grupaEList.setBounds(360,400,150,100);
        add(grupaEList);
        dodajGrEButton.setBounds(270,420,80,50);
        add(dodajGrEButton);

        grupaFListModel = new DefaultListModel();
        grupaFList = new JList();
        grupaFLabel.setBounds(640,380,60,20);
        add(grupaFLabel);
        grupaFList.setBounds(620,400,150,100);
        add(grupaFList);
        dodajGrFButton.setBounds(530,420,80,50);
        add(dodajGrFButton);

        grupaGListModel = new DefaultListModel();
        grupaGList = new JList();
        grupaGLabel.setBounds(120,520,60,20);
        add(grupaGLabel);
        grupaGList.setBounds(100,540,150,100);
        add(grupaGList);
        dodajGrGButton.setBounds(10,560,80,50);
        add(dodajGrGButton);

        grupaHListModel = new DefaultListModel();
        grupaHList = new JList();
        grupaHLabel.setBounds(380,520,60,20);
        add(grupaHLabel);
        grupaHList.setBounds(360,540,150,100);
        add(grupaHList);
        dodajGrHButton.setBounds(270,560,80,50);
        add(dodajGrHButton);

        cofnijButton.setBounds(20,680,100,30);
        add(cofnijButton);


    }



}
