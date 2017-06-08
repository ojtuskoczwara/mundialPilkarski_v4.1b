package koczwara.mundialv1.MVC.Controller;


import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;
import koczwara.mundialv1.MVC.View.ViewEkranGlowny;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerEkranGlowny {
    private ViewEkranGlowny view;

    public ControllerEkranGlowny(ViewEkranGlowny view) {
        this.view = view;
        this.view.addPanelAdministratoraButtonListener(new PanelAdministratoraListener());
    }

    private class PanelAdministratoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
        }
    }
}
