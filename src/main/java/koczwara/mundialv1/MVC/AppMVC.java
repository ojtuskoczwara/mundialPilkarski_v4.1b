package koczwara.mundialv1.MVC;

import koczwara.mundialv1.MVC.Controller.ControllerEkranGlowny;
import koczwara.mundialv1.MVC.View.ViewEkranGlowny;


public class AppMVC {
    public AppMVC() throws Exception {
    }

    public static void main(String[] args) {

        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);

    }
}


