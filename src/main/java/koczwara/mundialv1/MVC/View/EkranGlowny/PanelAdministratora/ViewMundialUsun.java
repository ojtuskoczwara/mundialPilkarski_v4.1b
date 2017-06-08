package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewMundialUsun extends JFrame {
    private JList mundialeList;
    private DefaultListModel mundialeModel;
    private JButton usunButton = new JButton("Usuń");
    private JButton cofnijButton = new JButton("<< Cofnij");
    private JTextField lokalizacjaTF = new JTextField();
    private JTextField rokTF = new JTextField();
    private JLabel infoLabel = new JLabel();

    public ViewMundialUsun() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Mundial");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        usunButton.setBounds(160, 60, 100, 50);
        add(usunButton);
        cofnijButton.setBounds(30, 250, 100, 50);
        add(cofnijButton);

        mundialeModel = new DefaultListModel();
        mundialeList = new JList(mundialeModel);
        mundialeList.setBounds(30, 20, 120, 200);
        add(mundialeList);

        lokalizacjaTF.setBounds(270, 50, 100, 50);
        rokTF.setBounds(270, 110, 100, 50);
        add(lokalizacjaTF);
        add(rokTF);
        infoLabel.setBounds(170,170,350,50);
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
        //return mundialeList.getSelectedValue().toString();
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
