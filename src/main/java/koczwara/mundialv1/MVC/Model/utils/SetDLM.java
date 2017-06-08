package koczwara.mundialv1.MVC.Model.utils;

import koczwara.mundialv1.MVC.Model.dao.MundialDAO;
import koczwara.mundialv1.MVC.Model.dao.MundialDAOImpl;
import koczwara.mundialv1.MVC.Model.dao.ZawodnikWReprezentacjaDAO;
import koczwara.mundialv1.MVC.Model.dao.ZawodnikWReprezentacjaDAOImpl;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.entity.Zawodnik;

import javax.swing.*;
import java.util.List;

public class SetDLM {
    private static MundialDAO mundialDAO = new MundialDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();

    public DefaultListModel setMundialDLM(DefaultListModel dlm) {
        dlm.removeAllElements();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m: mundialList) {
                String valueLokalizacjaRok = m.getLokalizacja() +" "+ m.getRok();
                dlm.addElement(valueLokalizacjaRok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }

    public DefaultListModel setReprezentacjaDLM(DefaultListModel dlm, String lokalizacja, int rok) {
        dlm.removeAllElements();
        try {
            List<Reprezentacja> reprezentacjaList = zawodnikWReprezentacjaDAO.getAllReprezentacjeAtMundial(lokalizacja, rok);
            for (Reprezentacja r: reprezentacjaList) {
                dlm.addElement(r.getNazwa());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }

    public DefaultListModel setZawodnikDLM(DefaultListModel dlm, String lokalizacjaMun, String nazwaRep) {
        try {
            List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getAllZawodnicyAtMundialInRep(lokalizacjaMun, nazwaRep);
            dlm.removeAllElements();
            for (Zawodnik z: zawodnikList) {
                String zawodnikImieNazwisko = z.getImie() +" "+ z.getNazwisko();
                dlm.addElement(zawodnikImieNazwisko);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }
}
