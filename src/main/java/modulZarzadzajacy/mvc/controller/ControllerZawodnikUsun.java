package modulZarzadzajacy.mvc.controller;


import modulZarzadzajacy.mvc.model.dao.*;
import modulZarzadzajacy.mvc.model.entity.Mundial;
import modulZarzadzajacy.mvc.model.entity.Reprezentacja;
import modulZarzadzajacy.mvc.model.entity.Zawodnik;
import modulZarzadzajacy.mvc.view.ViewPanelAdministratora;
import modulZarzadzajacy.mvc.model.entity.ZawodnikWReprezentacja;
import modulZarzadzajacy.repository.ShowMyMessage;
import modulZarzadzajacy.mvc.view.ViewZawodnikUsun;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerZawodnikUsun {
    private ViewZawodnikUsun view;
    private Zawodnik modelZawodnik;
    private Reprezentacja modelReprezentacja;
    private Mundial modelMundial;
    private ZawodnikWReprezentacja modelZawodnikWReprezentacja;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel reprezentacjaListModel = new DefaultListModel();
    private DefaultListModel zawodnikListModel = new DefaultListModel();
    private ZawodnikDAO zawodnikDAO = new ZawodnikDAOImpl();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private ShowMyMessage showMyMessage = new ShowMyMessage();
    private String valueMundial, valueMundialLokalizacja, valueReprezentacjaNazwa;
    private int valueMundialRok;

    public ControllerZawodnikUsun(ViewZawodnikUsun view, Zawodnik modelZawodnik, Reprezentacja modelReprezentacja, Mundial modelMundial, ZawodnikWReprezentacja modelZawodnikWReprezentacja){
        this.view = view;
        this.modelZawodnik = modelZawodnik;
        this.modelReprezentacja = modelReprezentacja;
        this.modelMundial = modelMundial;
        this.modelZawodnikWReprezentacja = modelZawodnikWReprezentacja;

        setMundialDLM();
        this.view.addMundialListMouseListener(new PressedOnElementOfMundialList());
        this.view.addReprezentacjaListMouseListener(new PressedOnElementOfReprezentacjaList());
        this.view.addZawodnikListMouseListener(new PressedOnElementOfZawodnikList());
        this.view.addCofnijButtonListener(new BackToPanelAdmin());
        this.view.addUsunZawodnikaButtonListener(new UsunZawodnika());

    }


    private void setMundialDLM() {
        // Wstrzyknięcie danych do modeluMundialu który później jest argumentem JListMundiale
        mundialListModel.removeAllElements();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m : mundialList) {
                String valueLokalizacjaRok = m.getLokalizacja() + " " + m.getRok();
                mundialListModel.addElement(valueLokalizacjaRok);
            }
            this.view.addListModelToMundialList(mundialListModel); // Wywołanie metody, która ustawia modelMundiale w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setReprezentacjaDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        reprezentacjaListModel.removeAllElements();
        try {
            // Pobranie wartości z JListMundial, elementu który jest zaznaczony
            List<Reprezentacja> reprezentacjaList = zawodnikWReprezentacjaDAO.getAllReprezentacjeAtMundial(valueMundialLokalizacja, valueMundialRok);
            for (Reprezentacja r : reprezentacjaList) {
                reprezentacjaListModel.addElement(r.getNazwa());
            }
            this.view.addListModelToReprezentacjaList(reprezentacjaListModel); // Wywołanie metody, która ustawia modelRep w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setZawodnikDLM() {
        valueReprezentacjaNazwa = view.getReprezentacjaList().getSelectedValue().toString();
        try {
            List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getAllZawodnicyAtMundialInRep(valueMundialLokalizacja, valueReprezentacjaNazwa);
            zawodnikListModel.removeAllElements();
            for (Zawodnik z : zawodnikList) {
                String zaw = z.getImie() + " " + z.getNazwisko();
                zawodnikListModel.addElement(zaw);
            }
            view.addListModelToZawodnikList(zawodnikListModel);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private class PressedOnElementOfMundialList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty()){
                valueMundial = view.getMundialList().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0, valueMundial.length() - 5);
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length() - 4));
                setReprezentacjaDLM();
            }
            zawodnikListModel.removeAllElements();
        }
    }

    private class PressedOnElementOfReprezentacjaList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty() && !view.getReprezentacjaList().isSelectionEmpty())
                setZawodnikDLM();
        }
    }

    private class PressedOnElementOfZawodnikList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                //Zaznaczony element String dzielimy na imie i nazwisko Separatorem jest spacja, +setter imie nazwisko
                String[] splited = view.getZawodnikList().getSelectedValue().toString().split("\\s");
                modelZawodnik.setImie(splited[0]);
                modelZawodnik.setNazwisko(splited[1]);
            }
        }
    }

    private class BackToPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }


    private class UsunZawodnika implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() & !view.getReprezentacjaList().isSelectionEmpty() & !view.getZawodnikList().isSelectionEmpty()) {
                //Pobranie idMundialu i zapisanie w modelMundial
                String imie = null, nazwisko= null;
                try {
                    modelMundial = mundialDAO.getIdMundialByLokalizacjaRok(valueMundialLokalizacja, valueMundialRok);
                    modelMundial.setLokalizacja(valueMundialLokalizacja); //Ustawienie lokalizacji poprzez setter
                    modelMundial.setRok(valueMundialRok); //Ustawienie roku poprzez setter
                    //Pobranie idReprezentacji i zapisanie w modelReprezentacja
                    modelReprezentacja = reprezentacjaDAO.getIdRepByNazwa(valueReprezentacjaNazwa);
                    modelReprezentacja.setNazwa(valueReprezentacjaNazwa); //Ustawienie nazwyReprezentacji poprzez setter
                    //Pobranie idZawodnika poprzez munLokalizacja i rok repNazwaRep oraz zawImie i nazwisko
                    imie = modelZawodnik.getImie();
                    nazwisko = modelZawodnik.getNazwisko();
                    modelZawodnik = zawodnikWReprezentacjaDAO.getZawodnikIdByLokalizacjaRokNazwaImieNazwisko(modelMundial, modelReprezentacja, modelZawodnik);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                int idZawodnika = modelZawodnik.getIdZawodnika();
                try {
                    zawodnikWReprezentacjaDAO.deleteRowsByMundialIdReprezentacjaIdZawodnikId(modelMundial, modelReprezentacja, modelZawodnik); //Usunięcie wierszy z ZWR poprzez idMun idRep idZaw
                    zawodnikDAO.deleteZawodnik(idZawodnika); //Usunięcie zawodnika z t_Zawodnik
                    setZawodnikDLM();
                    showMyMessage.informationMessage("Zawodnik: '" +imie+" "+nazwisko+"' został usunięty.","Success");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else showMyMessage.errorMessage("Wybierz mundial, reprezentacje i zawodnika, którego chcesz usunąć.", "Wybierz zawodnika");
        }
    }
}
