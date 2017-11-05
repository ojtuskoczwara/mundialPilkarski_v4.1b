package modulZarzadzajacy.mvc.controller;


import modulZarzadzajacy.mvc.model.dao.*;
import modulZarzadzajacy.mvc.model.entity.*;
import modulZarzadzajacy.mvc.view.ViewMecze;
import modulZarzadzajacy.mvc.view.ViewPanelAdministratora;
import modulZarzadzajacy.mvc.view.ViewZawodnikDodaj;
import modulZarzadzajacy.repository.exceptions.CheckBoxUnchecked;
import modulZarzadzajacy.repository.exceptions.MundialNotSelected;
import modulZarzadzajacy.repository.ShowMyMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerZawodnikDodaj {
    private ViewZawodnikDodaj view;
    private Zawodnik modelZawodnik;
    private Reprezentacja modelReprezentacja;
    private Mundial modelMundial;
    private ZawodnikWReprezentacja modelZawodnikWReprezentacja;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel reprezentacjaListModel = new DefaultListModel();
    private DefaultListModel zawodnikListModel = new DefaultListModel();
    private DefaultListModel zawodnik2ListModel = new DefaultListModel();
    private DefaultListModel mundial2ListModel = new DefaultListModel();
    private ZawodnikDAO zawodnikDAO = new ZawodnikDAOImpl();
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private ShowMyMessage showMyMessage = new ShowMyMessage();
    private String valueMundial, valueMundialLokalizacja, valueReprezentacjaNazwa;
    private int valueMundialRok;


    public ControllerZawodnikDodaj(ViewZawodnikDodaj view, Zawodnik modelZawodnik, Reprezentacja modelReprezentacja,
                                   Mundial modelMundial, ZawodnikWReprezentacja modelZawodnikWReprezentacja) {
        this.view = view;
        this.modelZawodnik = modelZawodnik;
        this.modelReprezentacja = modelReprezentacja;
        this.modelMundial = modelMundial;
        this.modelZawodnikWReprezentacja = modelZawodnikWReprezentacja;

        setMundialDLM();
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.addMundialListMouseListener(new WybranieElementuMundialList());
        this.view.addReprezentacjaListMouseListener(new WybranieElementuReprezentacjaList());
        this.view.addDodajZawodnikaButtonListener(new DodajZawodnikaButton());
        this.view.addCheckBoxIstniejacyZawodnikActionListener(new WybranieIstniejacyZawodnikDoNowyMundial());
        this.view.addCheckBoxNowyZawodnikActionListener(new WybranieNowyZawodnikDoNowyMundial());
        this.view.addMundial2ListMouseListener(new WybranieElementuMundial2List() );
        this.view.setButtonDalejDataWynikiSkladyActionListener(new PrzejscieDoDalejDataWynikiSkladyMeczu());
    }


    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
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

    private void setMundial2DLMWithoutSomeMundial() {
        mundial2ListModel.removeAllElements();

        try {
            if (!view.getMundialList().isSelectionEmpty()) {
                valueMundial = view.getMundialList().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0, valueMundial.length() - 5);
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length() - 4));
                modelMundial = mundialDAO.getIdMundialByLokalizacjaRok(valueMundialLokalizacja,valueMundialRok);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showMyMessage.errorMessage("Nie można odczytać danych mundialu", "Błąd odczytu danych");
        }
        try {
            if (modelMundial.getIdMundialu() != 0){
                List<Mundial> mundial2List = mundialDAO.getMundialWithoutSomeMundialByMundialId(modelMundial.getIdMundialu());
                for (Mundial m: mundial2List) {
                    String valueMundial = m.getLokalizacja() + " " + m.getRok();
                    mundial2ListModel.addElement(valueMundial);
                }
                this.view.addListModelToMundial2List(mundial2ListModel); // Dodanie do listy mundial2 wszystkich mundiali procz wybranego w listMundial1
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setReprezentacjaDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        reprezentacjaListModel.removeAllElements();
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacja();
            for (Reprezentacja r : reprezentacjaList) {
                reprezentacjaListModel.addElement(r.getNazwa());
            }
            this.view.addListModelToReprezentacjaList(reprezentacjaListModel); // Wywołanie metody, która ustawia modelRep w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DefaultListModel setZawodnikDLM(int mundialId, int reprezentacjaId){
        DefaultListModel dlm = new DefaultListModel();
        dlm.removeAllElements();
        try {
            List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getZawodnikImieNazwiskoByMundialIdRepId(mundialId, reprezentacjaId);
            for (Zawodnik z: zawodnikList){
                String zaw = z.getImie() + " " + z.getNazwisko();
                dlm.addElement(zaw);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }

//Wyswietlenie listy reprezentacji oraz wyczyszczenie listy zawodnikow po kliknieciu na ktorykolwiek element listy mundial
    private class WybranieElementuMundialList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty())
                setReprezentacjaDLM();
            zawodnikListModel.removeAllElements();
            if (view.getValueSelectedCheckBoxIstniejacyZawodnik()==true) {
                setMundial2DLMWithoutSomeMundial();
            }
        }
    }

//Wyswietlenie listy zawodnikow ktorzy sa na danym mundialu i w danej reprezentacji po kliknieciu na listy(mundial i reprezentacja)
    private class WybranieElementuReprezentacjaList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            zawodnikListModel.removeAllElements();
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                valueMundial = view.getMundialList().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0, valueMundial.length() - 5);
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length() - 4));
                valueReprezentacjaNazwa = view.getReprezentacjaList().getSelectedValue().toString();
                try {
                    List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getAllZawodnicyAtMundialInRep(valueMundialLokalizacja, valueReprezentacjaNazwa);
                    for (Zawodnik z : zawodnikList) {
                        String zaw = z.getImie() + " " + z.getNazwisko();
                        zawodnikListModel.addElement(zaw);
                    }
                    view.addListModelToZawodnikList(zawodnikListModel);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    private class DodajZawodnikaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getValueSelectedCheckBoxIstniejacyZawodnik() == true & view.getValueSelectedCheckBoxNowyZawodnik() == false & !view.getMundialList().isSelectionEmpty() & !view.getReprezentacjaList().isSelectionEmpty()
                    & !view.getZawodnikList().isSelectionEmpty() & !view.getMundial2List().isSelectionEmpty()) {
                int zawodnikIndeksValue = view.getZawodnikList().getSelectedIndex();
                String mundial2SelectedValue = view.getMundial2List().getSelectedValue().toString();
                String[] lokalizacjaRok = mundial2SelectedValue.split(" ");
                Mundial mundial2 = new Mundial();
                mundial2.setLokalizacja(lokalizacjaRok[0]);
                mundial2.setRok(Integer.parseInt(lokalizacjaRok[1]));
                try {
                    modelMundial = mundialDAO.getIdMundialByLokalizacjaRok(valueMundialLokalizacja, valueMundialRok);
                    mundial2 = mundialDAO.getIdMundialByLokalizacjaRok(mundial2.getLokalizacja(), mundial2.getRok());
                    modelReprezentacja = reprezentacjaDAO.getIdRepByNazwa(valueReprezentacjaNazwa);
                    modelZawodnik.setIdZawodnika(zawodnikWReprezentacjaDAO.getIdZawodnikaAtMundialRepByMundialIdRepIdIndexValue(modelMundial.getIdMundialu(),modelReprezentacja.getIdReprezentacji(), zawodnikIndeksValue));
                    zawodnikWReprezentacjaDAO.addZawodnikRepMundial(modelZawodnik.getIdZawodnika(), modelReprezentacja.getIdReprezentacji(), mundial2.getIdMundialu());
                    // Pobranie zawodnikow z DB do JListZawodnik
                    zawodnik2ListModel = setZawodnikDLM(mundial2.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                    view.setListModelToZawodnik2PodgladList(zawodnik2ListModel);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else {
                if (view.getValueSelectedCheckBoxIstniejacyZawodnik() == true & (view.getMundialList().isSelectionEmpty() ||
                        view.getReprezentacjaList().isSelectionEmpty() || view.getZawodnikList().isSelectionEmpty() || view.getMundial2List().isSelectionEmpty())) {
                    showMyMessage.informationMessage("Wybierz mundial,reprezentacje,zawodnika oraz mundial do którego chcesz go dodać.","Nie wybrano zawodnika");
                }
                else if (view.getValueSelectedCheckBoxIstniejacyZawodnik() == false & view.getValueSelectedCheckBoxNowyZawodnik() == true & !view.getMundialList().isSelectionEmpty() & !view.getReprezentacjaList().isSelectionEmpty()
                         & !view.getImieZawodnika().isEmpty() & !view.getNazwiskoZawodnika().isEmpty()) {
                    //Dodanie zawodnika do tabeli Zawodnik
                    modelZawodnik.setImie(view.getImieZawodnika());
                    modelZawodnik.setNazwisko(view.getNazwiskoZawodnika());
                    try {
                        //Dodanie zawodnika do tabeli Zawodnik
                        zawodnikDAO.addZawodnik(modelZawodnik);
                        //Pobranie idMundialu z tabeli t_Mundial automatycznie po dodaniu nowego uzytkownika, idMundialu == zaznaczony element z JList mundialList
                        modelMundial = mundialDAO.getIdMundialByLokalizacjaRok(valueMundialLokalizacja, valueMundialRok);
                        //Pobranie idReprezentacji z tabeli t_Reprezentacja, idReprezentacja == zaznaczony element z JList reprezentacjaList
                        modelReprezentacja = reprezentacjaDAO.getIdRepByNazwa(valueReprezentacjaNazwa);
                        //Pobranie idZawodnika z tabeli t_Zawodnik, idZawodnika == ostatni dodany zawodnik
                        modelZawodnik = zawodnikDAO.getLastZawodnik();
                        //Dodanie zawodnika,reprezentacji,mundialu do tabeli t_Zawodnik_W_Reprezentacja
                        zawodnikWReprezentacjaDAO.addZawodnikRepMundial(modelZawodnik.getIdZawodnika(), modelReprezentacja.getIdReprezentacji(), modelMundial.getIdMundialu());
                        // Pobranie zawodnikow z DB do JListZawodnik
                        zawodnikListModel = setZawodnikDLM(modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                        view.addListModelToZawodnikList(zawodnikListModel);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                else if (view.getValueSelectedCheckBoxNowyZawodnik() == true & (view.getMundialList().isSelectionEmpty() ||
                        view.getReprezentacjaList().isSelectionEmpty() || view.getZawodnikList().isSelectionEmpty() || view.getMundial2List().isSelectionEmpty() || view.getImieZawodnika().isEmpty() || view.getNazwiskoZawodnika().isEmpty())) {
                    showMyMessage.informationMessage("Wybierz mundial,reprezentacje oraz wypełnij pola IMIE i NAZWISKO.","Nie wybrano zawodnika");
                }
            }
        }

    }

    private class WybranieIstniejacyZawodnikDoNowyMundial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getValueSelectedCheckBoxIstniejacyZawodnik() == true) {
                    view.setCheckBoxNowyZawodnik(false);
                    view.setVisibleJScrollMundial2(true);
                    view.setVisibleImieNazwiskoTextField(false);
                    try {
                        if (!view.getMundialList().isSelectionEmpty()) {
                            setMundial2DLMWithoutSomeMundial();
                        } else
                            throw new MundialNotSelected("Nie wybrano mundialu z listy powyżej");
                    } catch (MundialNotSelected mns) {
                        showMyMessage.warningMessage("Wybierz mundial z listy powyżej!", "Nie wybrano mundialu");
                    }
                }else {
                    throw new CheckBoxUnchecked("Istniejacy zawodnik unchecked");
                }
            } catch (CheckBoxUnchecked ec) {
                view.setCheckBoxNowyZawodnik(true);
                view.setVisibleJScrollMundial2(false);
                view.setVisibleImieNazwiskoTextField(true);
                mundial2ListModel.removeAllElements(); //usuniecie pozostaosci po wczesniejszym select na liscie mundial2
                view.addListModelToMundial2List(mundial2ListModel); //wyswietlenie powyzszego modelu
            }
        }
    }

    private class WybranieNowyZawodnikDoNowyMundial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getValueSelectedCheckBoxNowyZawodnik() == true){
                    view.setCheckBoxIstniejacyZawodnik(false);
                    view.setVisibleImieNazwiskoTextField(true);
                    view.setVisibleJScrollMundial2(false);
                } else
                    throw new CheckBoxUnchecked("Nowy zawodnik unchecked");
            } catch (CheckBoxUnchecked ec) {
                view.setCheckBoxIstniejacyZawodnik(true);
                view.setVisibleImieNazwiskoTextField(false);
                view.setVisibleJScrollMundial2(true);
            }
        }
    }

    private class WybranieElementuMundial2List extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (view.getValueSelectedCheckBoxIstniejacyZawodnik() == true &  !view.getMundialList().isSelectionEmpty() & !view.getReprezentacjaList().isSelectionEmpty()
                     & !view.getMundial2List().isSelectionEmpty()) {
                int zawodnikIndeksValue = view.getZawodnikList().getSelectedIndex();
                String mundial2SelectedValue = view.getMundial2List().getSelectedValue().toString();
                String[] lokalizacjaRok = mundial2SelectedValue.split(" ");
                Mundial mundial2 = new Mundial();
                mundial2.setLokalizacja(lokalizacjaRok[0]);
                mundial2.setRok(Integer.parseInt(lokalizacjaRok[1]));
                try {
                    mundial2 = mundialDAO.getIdMundialByLokalizacjaRok(mundial2.getLokalizacja(), mundial2.getRok());
                    modelReprezentacja = reprezentacjaDAO.getIdRepByNazwa(valueReprezentacjaNazwa);
                    // Pobranie zawodnikow z DB do JListZawodnik
                    zawodnik2ListModel = setZawodnikDLM(mundial2.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                    view.setListModelToZawodnik2PodgladList(zawodnik2ListModel);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else
                showMyMessage.informationMessage("Wybierz mundial,reprezentacje,zawodnika aby wyświetlić zawodników w nowym mundialu.","Nie wybrano mundialu,reprezentacji i zawodnika");
        }
    }

    private class PrzejscieDoDalejDataWynikiSkladyMeczu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerMecze(new ViewMecze(), new Mundial(), new Rozgrywka(), new TypGrupy(), new Grupa(), new Reprezentacja(), new Mecz(), new Zawodnik());
            view.setVisible(false);
        }
    }
}
