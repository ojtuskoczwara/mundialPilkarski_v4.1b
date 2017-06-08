package koczwara.mundialv1.MVC.View;


import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewEkranGlowny extends JFrame {

    private JButton mundialeButton = new JButton("Mundiale");
    private JButton zawodnicyButton = new JButton("Zawodnicy");
    private JButton wynikiButton = new JButton("Wyniki");
    private JButton panelAdministratoraButton = new JButton("Panel Administratora");



    public ViewEkranGlowny() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Ekran główny");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        mundialeButton.setBounds(250,30,100,50);
        add(mundialeButton);
        zawodnicyButton.setBounds(250,90,100,50);
        add(zawodnicyButton);
        wynikiButton.setBounds(250,150,100,50);
        add(wynikiButton);
        panelAdministratoraButton.setBounds(400,400,170,30);
        add(panelAdministratoraButton);
    }

    public void addPanelAdministratoraButtonListener(ActionListener listenForPanelAdministratoraButton) {
        panelAdministratoraButton.addActionListener(listenForPanelAdministratoraButton);
    }

    public void addMundialeButtonListener(ActionListener listenForMundialeButton) {
        mundialeButton.addActionListener(listenForMundialeButton);
    }

    public void addZawodnicyButtonListener(ActionListener listenForZawodnicyButton) {
        zawodnicyButton.addActionListener(listenForZawodnicyButton);
    }

    public void addWynikiButtonListener(ActionListener listenForWynikiButton) {
        wynikiButton.addActionListener(listenForWynikiButton);
    }

}
