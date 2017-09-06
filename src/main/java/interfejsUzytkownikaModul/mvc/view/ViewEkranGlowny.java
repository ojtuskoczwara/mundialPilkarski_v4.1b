package interfejsUzytkownikaModul.mvc.view;


import javafx.scene.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;

public class ViewEkranGlowny extends JFrame {

    private JButton mundialeButton = new JButton("Mundiale");
    private JButton zawodnicyButton = new JButton("Zawodnicy");
    private JButton wynikiButton = new JButton("Wyniki");
    private JButton panelAdministratoraButton = new JButton("Panel Administratora");



    public ViewEkranGlowny() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,450);
        setTitle("Ekran główny");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        zawodnicyButton.setBounds(50,20,300,100);
        add(zawodnicyButton);
        wynikiButton.setBounds(50,130,300,100);
        add(wynikiButton);
        panelAdministratoraButton.setBounds(50,300,200,70);
        add(panelAdministratoraButton);
    }

    public void addPanelAdministratoraButtonListener(ActionListener listenForPanelAdministratoraButton) {
        panelAdministratoraButton.addActionListener(listenForPanelAdministratoraButton);
    }

    public void addZawodnicyButtonListener(ActionListener listenForZawodnicyButton) {
        zawodnicyButton.addActionListener(listenForZawodnicyButton);
    }

    public void addWynikiButtonListener(ActionListener listenForWynikiButton) {
        wynikiButton.addActionListener(listenForWynikiButton);
    }

}
