package modulZarzadzajacy.mvc.view;


import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewReprezentacjaUsun extends JFrame {
    private JList reprezentacjaList;
    private JButton usunButton = new JButton("Usuń");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JTextField nazwaTextField = new JTextField();

    public ViewReprezentacjaUsun() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Reprezentacja usuń");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        usunButton.setBounds(210, 60, 100, 50);
        add(usunButton);
        cofnijButton.setBounds(30, 400, 100, 30);
        add(cofnijButton);

        reprezentacjaList = new JList();
        JScrollPane reprezentacjaScrollList = new JScrollPane(reprezentacjaList);
        reprezentacjaScrollList.setBounds(30,20,160,200);
        add(reprezentacjaScrollList);

        nazwaTextField.setBounds(330, 50, 100, 50);
        add(nazwaTextField);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void addUsunReprezentacjeButtonListener(ActionListener listenUsunReprezentacjeButton) {
        usunButton.addActionListener(listenUsunReprezentacjeButton);
    }

    public void addListModelToReprezentacjaList(DefaultListModel reprezentacjaListModel) {
        reprezentacjaList.setModel(reprezentacjaListModel);
    }

    public JList getReprezentacjaList() {
        return reprezentacjaList;
    }

    public void addShowNazwaReprezentacjiTextField(String nazwa) {
        nazwaTextField.setText(nazwa);
    }
}
