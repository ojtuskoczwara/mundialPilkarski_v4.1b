package koczwara.mundialv1.MVC.View;


import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewReprezentacjaDodaj extends JFrame {
    private JLabel nazwaReprezentacjiLabel = new JLabel("Nazwa reprezentacji:");
    private JTextField nazwaReprezentacjiTextField = new JTextField();
    private JButton dodajReprezentacjeButton = new JButton("Add >>"), buttonDalejDodajRepDoGrupy;
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JList reprezentacjaList;

    public ViewReprezentacjaDodaj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Reprezentacja dodaj");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        nazwaReprezentacjiLabel.setBounds(30, 20, 150, 30);
        add(nazwaReprezentacjiLabel);
        nazwaReprezentacjiTextField.setBounds(30, 50, 150, 30);
        add(nazwaReprezentacjiTextField);
        dodajReprezentacjeButton.setBounds(200, 80, 100, 50);
        add(dodajReprezentacjeButton);


        reprezentacjaList = new JList();
        JScrollPane reprezentacjaScrollList = new JScrollPane(reprezentacjaList);
        reprezentacjaScrollList.setBounds(350,20,160,200);
        add(reprezentacjaScrollList);

        cofnijButton.setBounds(30, 400, 100, 30);
        add(cofnijButton);

            buttonDalejDodajRepDoGrupy = new JButton(">> Dalej >>");
        buttonDalejDodajRepDoGrupy.setBounds(410,400,100,30);
        add(buttonDalejDodajRepDoGrupy);
    }

    public String getNazwaReprezentacji() {
        return nazwaReprezentacjiTextField.getText();
    }

    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void addDodajReprezentacjeButtonListener(ActionListener listenDodajReprezentacjeButton) {
        dodajReprezentacjeButton.addActionListener(listenDodajReprezentacjeButton);
    }

    public void setButtonDalejDodajRepDoGrupyActionListener(ActionListener listenButtonDalejRepDoGrupy) {
        buttonDalejDodajRepDoGrupy.addActionListener(listenButtonDalejRepDoGrupy);
    }
}
