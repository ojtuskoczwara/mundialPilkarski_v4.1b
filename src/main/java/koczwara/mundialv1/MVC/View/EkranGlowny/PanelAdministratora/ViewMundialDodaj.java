package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewMundialDodaj extends JFrame {
    private JLabel nazwaMundialuLabel = new JLabel("Lokalizacja");
    private JTextField nazwaMundialuTextField = new JTextField();
    private JLabel rokMundialuLabel = new JLabel("Rok");
    private JTextField rokMundialuTextField = new JTextField();
    private JButton dodajMundialButton = new JButton("Add >>");
    private JButton cofnijButton = new JButton("<<< Cofnij");
    private JList mundialeList ;

    public ViewMundialDodaj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Mundial dodaj");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        nazwaMundialuLabel.setBounds(30,20,150,30);
        add(nazwaMundialuLabel);
        nazwaMundialuTextField.setBounds(30,45, 150, 30);
        add(nazwaMundialuTextField);
        rokMundialuLabel.setBounds(30,90,150,30);
        add(rokMundialuLabel);
        rokMundialuTextField.setBounds(30,115,50,30);
        add(rokMundialuTextField);
        dodajMundialButton.setBounds(200,80,100,50);
        add(dodajMundialButton);

        mundialeList = new JList();
        JScrollPane mundialeScrollList = new JScrollPane(mundialeList);
        mundialeScrollList.setBounds(350,20,160,200);
        add(mundialeScrollList);

        cofnijButton.setBounds(30,400,100,50);
        add(cofnijButton);
    }

    public String getNazwaMundialu() { return nazwaMundialuTextField.getText(); }

    public String getRokMundialu() { return rokMundialuTextField.getText().toString(); }

    public void setDodajMundialButtonListener(ActionListener listenDodajMundialButton) {
        dodajMundialButton.addActionListener(listenDodajMundialButton);
    }

    public void setCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void setListToMundialeList(DefaultListModel modelListyMundiali) {
        mundialeList.setModel(modelListyMundiali);
    }
}
