package interfejsUzytkownikaModul.mvc;

import interfejsUzytkownikaModul.mvc.controller.ControllerEkranGlowny;
import interfejsUzytkownikaModul.mvc.view.ViewEkranGlowny;


public class AppStart {
    public AppStart() throws Exception {
    }

    public void start() {
        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);
    }
}


