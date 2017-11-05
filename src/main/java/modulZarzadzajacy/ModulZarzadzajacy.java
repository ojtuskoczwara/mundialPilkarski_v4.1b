package modulZarzadzajacy;

import modulZarzadzajacy.mvc.AppStart;
import modulZarzadzajacy.mvc.controller.ControllerEkranGlowny;
import modulZarzadzajacy.mvc.view.ViewEkranGlowny;

public class ModulZarzadzajacy {
    public static void main(String[] args) {

     /*   try {
            AppStart aplikacja = new AppStart();
            aplikacja.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    */
        ControllerEkranGlowny aplikacja = new ControllerEkranGlowny(new ViewEkranGlowny());
        aplikacja.Start();
    }
}
