package koczwara.mundialv1.MVC;

import koczwara.mundialv1.MVC.Controller.ControllerEkranGlowny;
import koczwara.mundialv1.MVC.Controller.ControllerZawodnicy;
import koczwara.mundialv1.MVC.Model.dao.ReprezentacjaDAO;
import koczwara.mundialv1.MVC.Model.dao.ReprezentacjaDAOImpl;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewZawodnicy;
import koczwara.mundialv1.MVC.View.ViewEkranGlowny;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AppMVC {
    public AppMVC() throws Exception {
    }

    public static void main(String[] args) {

        ViewEkranGlowny view = new ViewEkranGlowny();
        ControllerEkranGlowny controller = new ControllerEkranGlowny(view);
        view.setVisible(true);

    }
}


