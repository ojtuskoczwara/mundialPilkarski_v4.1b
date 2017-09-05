package koczwara.mundialv1;

import koczwara.mundialv1.mvc.controller.ControllerEkranGlowny;
import koczwara.mundialv1.mvc.view.ViewEkranGlowny;


public class AppStart {
    public AppStart() throws Exception {
    }

    public static void main(String[] args) {

        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);

    }
}


