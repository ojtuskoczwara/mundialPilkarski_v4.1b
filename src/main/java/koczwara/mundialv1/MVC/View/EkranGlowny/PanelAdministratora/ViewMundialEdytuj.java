package koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewMundialEdytuj extends JFrame {
    private JList mundialList;
    private JButton edytujButton = new JButton("Edytuj");
    private JButton cofnijButton = new JButton("<< Cofnij <<");
    private JLabel nowaLokalizacjaLabel = new JLabel("Podaj nową lokalizację:");
    private JLabel nowyRokLabel = new JLabel("Podaj nowy rok:");
    private JTextField nowaLokalizajcaTextField = new JTextField();
    private JTextField nowyRokTextField = new JTextField();



    public ViewMundialEdytuj() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Mundial edytuj");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        cofnijButton.setBounds(30, 400, 100, 30);
        add(cofnijButton);


        mundialList = new JList();
        JScrollPane mundialeScrollList = new JScrollPane(mundialList);
        mundialeScrollList.setBounds(30,20,160,200);
        add(mundialeScrollList);

        edytujButton.setBounds(200, 60, 100, 50);
        add(edytujButton);

        nowaLokalizacjaLabel.setBounds(330,20,150,30);
        add(nowaLokalizacjaLabel);
        nowaLokalizajcaTextField.setBounds(330,50,100,30);
        add(nowaLokalizajcaTextField);

        nowyRokLabel.setBounds(330,100,150,30);
        add(nowyRokLabel);
        nowyRokTextField.setBounds(330,130,100,30);
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

    public void setCzyszczenieNowaLokalizajcaTextField(String text) {
        nowaLokalizajcaTextField.setText(text);
    }

    public void setCzyszczenieNowyRokTextField(String text) {
        nowyRokTextField.setText(text);
    }


}

