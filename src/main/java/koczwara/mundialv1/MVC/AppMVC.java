package koczwara.mundialv1.MVC;

import koczwara.mundialv1.MVC.Controller.ControllerEkranGlowny;
import koczwara.mundialv1.MVC.View.ViewEkranGlowny;


public class AppMVC {
    public static void main(String[] args) {
/*
        ZawodnikView view = new ZawodnikView();
        Zawodnik model = new Zawodnik();
        Controller controller = new Controller(view, model);

        view.setVisible(true);

*/

        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);
    }
}
