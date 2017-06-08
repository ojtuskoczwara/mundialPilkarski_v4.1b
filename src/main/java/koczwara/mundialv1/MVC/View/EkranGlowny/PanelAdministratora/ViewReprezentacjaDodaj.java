package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewReprezentacjaDodaj extends JFrame {
    private JLabel nazwaReprezentacjiLabel = new JLabel("Nazwa reprezentacji:");
    private JTextField nazwaReprezentacjiTextField = new JTextField();
    private JButton dodajReprezentacjeButton = new JButton("Add >>");
    private JButton cofnijButton = new JButton("<<< Cofnij");
    private JList reprezentacjaList;
    private DefaultListModel reprezentacjaListModel;

    public ViewReprezentacjaDodaj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Mundial");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        nazwaReprezentacjiLabel.setBounds(30, 20, 150, 30);
        add(nazwaReprezentacjiLabel);
        nazwaReprezentacjiTextField.setBounds(30, 50, 150, 30);
        add(nazwaReprezentacjiTextField);
        dodajReprezentacjeButton.setBounds(200, 80, 100, 50);
        add(dodajReprezentacjeButton);

        reprezentacjaListModel = new DefaultListModel();
        reprezentacjaList = new JList();
        reprezentacjaList.setBounds(350, 20, 120, 200);
        add(reprezentacjaList);

        cofnijButton.setBounds(30, 400, 100, 50);
        add(cofnijButton);
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
}
