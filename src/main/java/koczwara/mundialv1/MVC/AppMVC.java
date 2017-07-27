package koczwara.mundialv1.MVC;

import koczwara.mundialv1.MVC.Controller.ControllerEkranGlowny;
import koczwara.mundialv1.MVC.View.ViewEkranGlowny;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AppMVC {
    public static void main(String[] args) {

        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);



    }
}
