package modulZarzadzajacy;

import modulZarzadzajacy.mvc.AppStart;

public class ModulZarzadzajacy {
    public static void main(String[] args) {
        try {
            AppStart aplikacja = new AppStart();
            aplikacja.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
