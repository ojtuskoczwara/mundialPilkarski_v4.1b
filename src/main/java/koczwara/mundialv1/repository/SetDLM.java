package koczwara.mundialv1.repository;

import koczwara.mundialv1.mvc.model.dao.*;
import koczwara.mundialv1.mvc.model.entity.Grupa;
import koczwara.mundialv1.mvc.model.entity.Mundial;
import koczwara.mundialv1.mvc.model.entity.Reprezentacja;
import koczwara.mundialv1.mvc.model.entity.Zawodnik;

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

    public DefaultListModel setGrupaNazwaDLM(DefaultListModel dlm, Grupa grupa, Mundial mundial) {
        GrupaDAO grupaDAO = new GrupaDAOImpl();
        ReprezentacjaWGrupaDAO reprezentacjaWGrupaDAO = new ReprezentacjaWGrupaDAOImpl();
        dlm.removeAllElements();
        try {
            grupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(mundial, grupa);
            List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(mundial, grupa);
            for (Reprezentacja r : reprezentacjaList) {
                dlm.addElement(r.getNazwa());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }
}
