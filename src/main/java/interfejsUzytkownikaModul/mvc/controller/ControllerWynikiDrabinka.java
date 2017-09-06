package interfejsUzytkownikaModul.mvc.controller;

import interfejsUzytkownikaModul.mvc.model.entity.Mundial;
import interfejsUzytkownikaModul.mvc.view.ViewWynikiDrabinka;
import interfejsUzytkownikaModul.mvc.model.dao.MundialDAO;
import interfejsUzytkownikaModul.mvc.model.dao.MundialDAOImpl;

import javax.swing.*;
import java.util.List;

public class ControllerWynikiDrabinka {
    private ViewWynikiDrabinka view;
    private Mundial modelMundial;
    private DefaultComboBoxModel dcbmMundial;

    private MundialDAO mundialDAO = new MundialDAOImpl();

    public ControllerWynikiDrabinka(ViewWynikiDrabinka view, Mundial modelMundial) {
        this.view = view;
        this.modelMundial = modelMundial;

        dcbmMundial = setMundialModel(); // Wyswietlenie wszystkich mundiali
        this.view.setMundialModel(dcbmMundial);

    }

    // Pobranie wszystkich mundiali do zmiennej i zwrocenie jej
    private DefaultComboBoxModel setMundialModel(){
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m: mundialList) {
                String tempLokalizacjaRok = m.getLokalizacja() +" "+ m.getRok();
                dcbm.addElement(tempLokalizacjaRok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dcbm;
    }
}
