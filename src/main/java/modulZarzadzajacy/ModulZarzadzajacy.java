package modulZarzadzajacy;

import modulZarzadzajacy.mvc.controller.ControllerEkranGlowny;
import modulZarzadzajacy.mvc.view.ViewEkranGlowny;

public class ModulZarzadzajacy {
    public static void main(String[] args) {

        ControllerEkranGlowny aplikacja = new ControllerEkranGlowny(new ViewEkranGlowny());
        aplikacja.Start();
    }
}
