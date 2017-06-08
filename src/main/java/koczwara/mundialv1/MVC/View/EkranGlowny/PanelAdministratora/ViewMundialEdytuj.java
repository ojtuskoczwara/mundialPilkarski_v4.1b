package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewMundialEdytuj extends JFrame {
    private JList mundialList;
    private DefaultListModel mundialListModel;
    private JButton edytujButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij");
    private JLabel nowaLokalizacjaLabel = new JLabel("Podaj nową lokalizację:");
    private JLabel nowyRokLabel = new JLabel("Podaj nowy rok:");
    private JTextField nowaLokalizajcaTextField = new JTextField();
    private JTextField nowyRokTextField = new JTextField();



    public ViewMundialEdytuj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Mundial");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        cofnijButton.setBounds(30, 400, 100, 50);
        add(cofnijButton);

        mundialListModel = new DefaultListModel();
        mundialList = new JList(mundialListModel);
        mundialList.setBounds(30, 20, 120, 200);
        add(mundialList);

        edytujButton.setBounds(160, 60, 100, 50);
        add(edytujButton);

        nowaLokalizacjaLabel.setBounds(270,20,150,30);
        add(nowaLokalizacjaLabel);
        nowaLokalizajcaTextField.setBounds(270,50,100,30);
        add(nowaLokalizajcaTextField);

        nowyRokLabel.setBounds(270,100,150,30);
        add(nowyRokLabel);
        nowyRokTextField.setBounds(270,130,100,30);
        add(nowyRokTextField);

    }

    public void setCofnijButtonListener(ActionListener listenCofnijButton) {
        cofnijButton.addActionListener(listenCofnijButton);
    }

    public void setEdytujButtonListener(ActionListener listenEdytujMundialButton) {
        edytujButton.addActionListener(listenEdytujMundialButton);
    }

    public String getNowaLokalizacjaTextField() {
        return nowaLokalizajcaTextField.getText();
    }

    public String getNowyRokTextField() {
        return nowyRokTextField.getText();
    }

    public void setMundialListModel(DefaultListModel mundialListModel) {
        mundialList.setModel(mundialListModel);
    }

    public JList getMundialList() {
        return mundialList;
    }

    public void setMundialListMouseListener(MouseAdapter listenMundialList) {
        mundialList.addMouseListener(listenMundialList);
    }
    public void showMyWarningMessage(String message, String messageTitle) {
        JOptionPane.showMessageDialog(this, message, messageTitle, JOptionPane.WARNING_MESSAGE);
    }

    public void showMyInfoMessage(String message, String messageTitle) {
        JOptionPane.showMessageDialog(this, message, messageTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMyErrorMessage(String message, String messageTitle) {
        JOptionPane.showMessageDialog(this, message, messageTitle, JOptionPane.ERROR_MESSAGE);
    }

    public void setCzyszczenieNowaLokalizajcaTextField(String text) {
        nowaLokalizajcaTextField.setText(text);
    }

    public void setCzyszczenieNowyRokTextField(String text) {
        nowyRokTextField.setText(text);
    }


}

