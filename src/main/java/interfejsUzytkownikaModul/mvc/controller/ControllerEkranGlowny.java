package interfejsUzytkownikaModul.mvc.controller;


import interfejsUzytkownikaModul.mvc.model.entity.*;
import interfejsUzytkownikaModul.mvc.view.ViewPanelAdministratora;
import interfejsUzytkownikaModul.mvc.view.ViewWyniki;
import interfejsUzytkownikaModul.mvc.view.ViewZawodnicy;
import interfejsUzytkownikaModul.mvc.view.ViewEkranGlowny;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerEkranGlowny {
    private ViewEkranGlowny view;

    public ControllerEkranGlowny(ViewEkranGlowny view) {
        this.view = view;
        this.view.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
        this.view.addWynikiButtonListener(new WynikiListener());
        this.view.addZawodnicyButtonListener(new ZawodnicyListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
        }
    }

    private class WynikiListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerWyniki(new ViewWyniki(), new Mundial(), new Rozgrywka(), new TypGrupy(), new Grupa(), new Reprezentacja(), new Mecz(), new Zawodnik());
            view.setVisible(false);
        }
    }

    private class ZawodnicyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerZawodnicy(new ViewZawodnicy(), new Mundial(), new Reprezentacja());
            view.setVisible(false);
        }
    }
}
