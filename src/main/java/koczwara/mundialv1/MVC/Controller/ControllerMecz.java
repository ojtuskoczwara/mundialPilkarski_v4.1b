package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.entity.Mecz;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja1;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja2;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewMecz;

import java.util.ArrayList;
import java.util.List;

public class ControllerMecz {
    private ViewMecz view;
    private Mecz modelMecz;
    private SkladReprezentacja1 modelSkladReprezentacja1;
    private SkladReprezentacja2 modelSkladReprezentacja2;

    public ControllerMecz(ViewMecz view) {
        this.view = view;

        setZawodnicyRep1();
    }

    public void setZawodnicyRep1() {
        String zaw1 = "Jan Kowalski";
        String zaw2 = "Maciej Nowak";
        String zaw3 = "Robert Lewandowski";
        String zaw4 = "Lukasz Piszczek";
        List<String> listaZawodnikow = new ArrayList<String>();
        listaZawodnikow.add(zaw1);
        listaZawodnikow.add(zaw2);
        listaZawodnikow.add(zaw3);
        listaZawodnikow.add(zaw4);

        for (String z: listaZawodnikow) {
            view.addListModelToZaw1Rep1ComboBox(z);
        }
    }
}
