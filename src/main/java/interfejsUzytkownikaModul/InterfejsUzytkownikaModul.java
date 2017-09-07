package interfejsUzytkownikaModul;

import interfejsUzytkownikaModul.mvc.AppStart;

public class InterfejsUzytkownikaModul {
    public static void main(String[] args) {
        try {
            AppStart aplikacja = new AppStart();
            aplikacja.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
