package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewReprezentacjaEdytuj extends JFrame {
    private JList reprezentacjaList;
    private DefaultListModel reprezentacjaListModel;
    private JButton edytujButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij");
    private JLabel nowaNazwaLabel = new JLabel("Podaj nową nazwę:");
    private JTextField nowaNazwaTextField = new JTextField();

    public ViewReprezentacjaEdytuj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Mundial");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        cofnijButton.setBounds(30, 400, 100, 50);
        add(cofnijButton);

        reprezentacjaListModel = new DefaultListModel();
        reprezentacjaList = new JList();
        reprezentacjaList.setBounds(30, 20, 120, 200);
        add(reprezentacjaList);

        edytujButton.setBounds(160, 60, 100, 50);
        add(edytujButton);

        nowaNazwaLabel.setBounds(270,20,150,30);
        add(nowaNazwaLabel);
        nowaNazwaTextField.setBounds(270,50,100,30);
        add(nowaNazwaTextField);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void addEdytujButtonListener(ActionListener listenEdytujReprezentacjaButton) {
        edytujButton.addActionListener(listenEdytujReprezentacjaButton);
    }

    public String getNowaNazwaReprezentacji() {
        return nowaNazwaTextField.getText();
    }

    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }

    public JList getReprezentacjaList() {
        return reprezentacjaList;
    }
}
