package modulZarzadzajacy.mvc.controller;


import modulZarzadzajacy.mvc.model.entity.*;
import modulZarzadzajacy.mvc.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPanelAdministratora {
    private ViewPanelAdministratora view;

    public ControllerPanelAdministratora(ViewPanelAdministratora view) {
        this.view = view;
        this.view.addCofnijButtonListener(new CofnijDoEkranGlownyListener());
        this.view.addDodajMundialButtonListener(new DodajMundialListener());
        this.view.addEdytujMundialButtonListener(new EdytujMundialListener());
        this.view.addUsunMundialButtonListener(new UsunMundialListener());
        this.view.addDodajReprezentacjaButtonListener(new DodajReprezentacjeListener());
        this.view.addEdytujReprezentacjaButtonListener(new EdytujReprezentacjeListener());
        this.view.addUsunReprezentacjaButtonListener(new UsunReprezentacjeListener());
        this.view.addDodajZawodnikButtonListener(new DodajZawodnikListener());
        this.view.addEdytujZawodnikButtonListener(new EdytujZawodnikListener());
        this.view.addUsunZawodnikButtonListener(new UsunZawodnikListener());
        this.view.addDodajReprezentacjaDoGrupaButtonListener(new DodajReprezentacjeDoGrupyListener());
        this.view.addDodajWynikMeczuButtonListener(new DodajWynikMeczuListener());


    }

    private class CofnijDoEkranGlownyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerEkranGlowny(new ViewEkranGlowny());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class DodajMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMundialDodaj(new ViewMundialDodaj(), new Mundial());
            view.setVisible(false);
        }
    }

    private class EdytujMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMundialEdytuj(new ViewMundialEdytuj(), new Mundial());
            view.setVisible(false);
        }
    }

    private class UsunMundialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMundialUsun(new ViewMundialUsun(), new Mundial());
            view.setVisible(false);
        }
    }

    private class DodajReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaDodaj(new ViewReprezentacjaDodaj(), new Reprezentacja());
            view.setVisible(false);

        }
    }

    private class EdytujReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaEdytuj(new ViewReprezentacjaEdytuj(), new Reprezentacja());
            view.setVisible(false);
        }
    }

    private class UsunReprezentacjeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaUsun(new ViewReprezentacjaUsun(), new Reprezentacja());
            view.setVisible(false);
        }
    }


    private class DodajZawodnikListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerZawodnikDodaj(new ViewZawodnikDodaj(), new Zawodnik(), new Reprezentacja(), new Mundial(), new ZawodnikWReprezentacja());
            view.setVisible(false);
        }
    }

    private class EdytujZawodnikListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerZawodnikEdytuj(new ViewZawodnikEdytuj(), new Zawodnik(), new Reprezentacja(), new Mundial(), new ZawodnikWReprezentacja());
            view.setVisible(false);
        }
    }

    private class UsunZawodnikListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerZawodnikUsun(new ViewZawodnikUsun(), new Zawodnik(), new Reprezentacja(), new Mundial(), new ZawodnikWReprezentacja());
            view.setVisible(false);
        }
    }

    private class DodajReprezentacjeDoGrupyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerGrupaDodaj(new ViewGrupaDodaj(), new Mundial(), new Reprezentacja(), new Grupa());
            view.setVisible(false);
        }
    }

    private class DodajWynikMeczuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMecze(new ViewMecze(), new Mundial(), new Rozgrywka(), new TypGrupy(), new Grupa(), new Reprezentacja(), new Mecz(), new Zawodnik());
            view.setVisible(false);
        }
    }
}
