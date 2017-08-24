package koczwara.mundialv1.MVC.View;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewMundialUsun extends JFrame {
    private JList mundialeList;
    private JButton usunButton = new JButton("Usuń");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JTextField lokalizacjaTF = new JTextField();
    private JTextField rokTF = new JTextField();
    private JLabel infoLabel = new JLabel();

    public ViewMundialUsun() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Mundial usuń");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        usunButton.setBounds(210, 60, 100, 50);
        add(usunButton);
        cofnijButton.setBounds(30, 400, 100, 30);
        add(cofnijButton);

        mundialeList = new JList();
        JScrollPane mundialeScrollList = new JScrollPane(mundialeList);
        mundialeScrollList.setBounds(30,20,160,200);
        add(mundialeScrollList);

        lokalizacjaTF.setBounds(330, 50, 100, 50);
        rokTF.setBounds(330, 110, 100, 50);
        add(lokalizacjaTF);
        add(rokTF);
        infoLabel.setBounds(330,170,350,50);
        add(infoLabel);
    }

    public void setCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void setUsunButtonListener(ActionListener listenUsunButton) {
        usunButton.addActionListener(listenUsunButton);
    }

    public void setMundialeListMouseListener(MouseAdapter listenMundialeList) {
        mundialeList.addMouseListener(listenMundialeList);
    }

    public void setListMundialeModel(DefaultListModel mundialeModel) {
        this.mundialeList.setModel(mundialeModel);
    }

    public JList getMundialListSelectedValue() {
        return mundialeList;
    }


    public void setLokalizacjaTF(String lokalizacja) {
        this.lokalizacjaTF.setText(lokalizacja);
    }

    public void setRokTF(String rok) {
        this.rokTF.setText(rok);
    }

    public void setInfoLabelText(String tekst) {
        this.infoLabel.setText(tekst);
    }
}
