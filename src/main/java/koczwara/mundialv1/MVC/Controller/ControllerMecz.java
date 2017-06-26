package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.entity.Mecz;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja1;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja2;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewMecz;

public class ControllerMecz {
    private ViewMecz view;
    private Mecz modelMecz;
    private SkladReprezentacja1 modelSkladReprezentacja1;
    private SkladReprezentacja2 modelSkladReprezentacja2;

    public ControllerMecz(ViewMecz view) {
        this.view = view;

    }
}
