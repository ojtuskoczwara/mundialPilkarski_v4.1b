package koczwara.mundialv1.mvc.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewReprezentacjaEdytuj extends JFrame {
    private JList reprezentacjaList;
    private JButton edytujButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JLabel nowaNazwaLabel = new JLabel("Podaj nową nazwę:");
    private JTextField nowaNazwaTextField = new JTextField();

    public ViewReprezentacjaEdytuj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Reprezentacja edytuj");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        cofnijButton.setBounds(30, 400, 100, 30);
        add(cofnijButton);

        reprezentacjaList = new JList();
        JScrollPane reprezentacjaScrollList = new JScrollPane(reprezentacjaList);
        reprezentacjaScrollList.setBounds(30,20,160,200);
        add(reprezentacjaScrollList);

        edytujButton.setBounds(210, 60, 100, 50);
        add(edytujButton);

        nowaNazwaLabel.setBounds(330,20,150,30);
        add(nowaNazwaLabel);
        nowaNazwaTextField.setBounds(330,50,100,30);
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
