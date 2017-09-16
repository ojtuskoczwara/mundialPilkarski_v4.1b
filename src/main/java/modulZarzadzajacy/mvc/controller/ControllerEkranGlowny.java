package modulZarzadzajacy.mvc.controller;


import modulZarzadzajacy.mvc.model.entity.*;
import modulZarzadzajacy.mvc.view.ViewPanelAdministratora;
import modulZarzadzajacy.mvc.view.ViewWyniki;
import modulZarzadzajacy.mvc.view.ViewZawodnicy;
import modulZarzadzajacy.mvc.view.ViewEkranGlowny;

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
