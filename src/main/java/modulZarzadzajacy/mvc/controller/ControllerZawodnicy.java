package modulZarzadzajacy.mvc.controller;

import modulZarzadzajacy.mvc.model.dao.*;
import modulZarzadzajacy.mvc.model.entity.Mundial;
import modulZarzadzajacy.mvc.model.entity.Reprezentacja;
import modulZarzadzajacy.mvc.model.entity.Zawodnik;
import modulZarzadzajacy.mvc.view.ViewEkranGlowny;
import modulZarzadzajacy.mvc.view.ViewZawodnicy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControllerZawodnicy {
    private ViewZawodnicy view;

    private Reprezentacja modelReprezentacja;
    private Mundial modelMundial;
    private ZawodnikDAO zawodnikDAO = new ZawodnikDAOImpl();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private DefaultListModel dlmZawodniks, dlmMundials, dlmReprezentacjas;


    public ControllerZawodnicy(ViewZawodnicy view, Mundial modelMundial, Reprezentacja modelReprezentacja){
        this.view = view;
        this.modelMundial = modelMundial;
        this.modelReprezentacja = modelReprezentacja;

        this.view.setCheckboxAllZawodniksListener(new ClickOnCheckboxAllZawodniks());
        this.view.setCheckboxSpecificMundialListener(new ClickOnCheckboxSpecificMundial());
        this.view.setCheckboxAllRepsListener(new ClickOnCheckboxAllReps());
        this.view.setCheckboxSpecificRepListener(new ClickOnCheckboxSpecifyRep());
        this.view.setListMundialMouseListener(new ClickOnElementOfListMundial());
        this.view.setListReprezentacjaMouseListener(new ClickOnElementOfListReprezentacja());
        this.view.addCofnijButtonListener(new ClickOnCofnijButton());
    }


    private DefaultListModel SearchZawodniks(int mundialId, int reprezentacjaId) {
        DefaultListModel dlm = new DefaultListModel();
        if (mundialId == 0) {
            // dao all zawodnikow
            try {
                List<Zawodnik> zawodnikListAll = zawodnikDAO.getAllZawodnicyImieNazwisko();
                for (Zawodnik z: zawodnikListAll){
                    String tempImieNazwisko = z.getImie() +" "+ z.getNazwisko();
                    dlm.addElement(tempImieNazwisko);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dlm;
        } else if (mundialId != 0 & reprezentacjaId == 0) {
            // dao all zawodnicy w danym mundialu
            try {
                List<Zawodnik> zawodnikListAll = zawodnikDAO.getZawodnicyImieNazwiskoInMundial(mundialId);
                for (Zawodnik z: zawodnikListAll){
                    String tempImieNazwisko = z.getImie() +" "+ z.getNazwisko();
                    dlm.addElement(tempImieNazwisko);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dlm;
        } else if (mundialId != 0 & reprezentacjaId != 0) {
            // zawodnicy w mundialu w danej rep
            try {
                List<Zawodnik> zawodnikListAll = zawodnikDAO.getZawodnicyImieNazwiskoInMundialInRep(mundialId, reprezentacjaId);
                for (Zawodnik z: zawodnikListAll){
                    String tempImieNazwisko = z.getImie() +" "+ z.getNazwisko();
                    dlm.addElement(tempImieNazwisko);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dlm;
        }
        return dlm;
    }

    private DefaultListModel SearchMundials() {
        DefaultListModel dlm = new DefaultListModel();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundials();
            for (Mundial m: mundialList){
                String tempLokalizacjaRok = m.getLokalizacja() +" "+ String.valueOf(m.getRok());
                dlm.addElement(tempLokalizacjaRok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }

    private DefaultListModel FindReprezentacjas(int mundialId){
        DefaultListModel dlm = new DefaultListModel();
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacjaInMundial(mundialId);
            for (Reprezentacja r: reprezentacjaList){
                dlm.addElement(r.getNazwa());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dlm;
    }

    private class ClickOnCheckboxAllZawodniks extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            view.setVisibleCheckboxGroupRepAllOrOne(false);
            view.setVisibleScrollPaneMundialReprezentacja(false);
            // Wyswietlenie wszystkich zaawodnikow
            dlmZawodniks = new DefaultListModel();
            dlmZawodniks = SearchZawodniks(0,0);
            view.setListZawodnikModel(dlmZawodniks);
            // Zerowanie mundialu i reprezentacji
            dlmMundials = new DefaultListModel();
            view.setListMundialModel(dlmMundials);
            dlmReprezentacjas = new DefaultListModel();
            view.setListReprezentacjaModel(dlmReprezentacjas);
        }
    }

    private class ClickOnCheckboxSpecificMundial extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            view.setVisibleCheckboxGroupRepAllOrOne(true);
            view.setVisibleScrollPaneMundialReprezentacja(true);
            dlmZawodniks = new DefaultListModel();
            view.setListZawodnikModel(dlmZawodniks);
        }
    }

    private class ClickOnCheckboxAllReps extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            //Zerowanie listyZawodnikow i listyReprezentacji
            dlmZawodniks = new DefaultListModel();
            view.setListZawodnikModel(dlmZawodniks);
            dlmReprezentacjas = new DefaultListModel();
            view.setListReprezentacjaModel(dlmReprezentacjas);
            // Wyswietlenie wszystkich mundiali
            dlmMundials = new DefaultListModel();
            dlmMundials = SearchMundials();
            view.setListMundialModel(dlmMundials);
        }
    }

    private class ClickOnElementOfListMundial extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            // get idMundialu/setIdMundialu
            String[] tempSelectedMundial = view.getListMundial().getSelectedValue().toString().split(" ");
            modelMundial.setLokalizacja(tempSelectedMundial[0]);
            modelMundial.setRok(Integer.parseInt(tempSelectedMundial[1]));
            try {
                modelMundial.setIdMundialu(mundialDAO.getMundialByLokalRok(modelMundial.getLokalizacja(), modelMundial.getRok()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            if (view.getCheckboxAllReps().getState() == true) { // Jezeli zaznaczony element to cbZawodnicyMundialu
                // Wyswietlenie wszystkich zawodnikow w danym mundialu
                dlmZawodniks = new DefaultListModel();
                dlmZawodniks= SearchZawodniks(modelMundial.getIdMundialu(),0);
                view.setListZawodnikModel(dlmZawodniks);

            } else if (view.getCheckboxSpecificRep().getState() == true){ // Jezeli zaznaczony jest cbZawodnicyMundialReprezentacja
                // Wyswietlenie reprezentacji
                dlmReprezentacjas = new DefaultListModel();
                dlmReprezentacjas = FindReprezentacjas(modelMundial.getIdMundialu());
                view.setListReprezentacjaModel(dlmReprezentacjas);
            }
        }
    }

    private class ClickOnCheckboxSpecifyRep extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            //Zerowanie listyZawodnikow i listyReprezentacji
            dlmZawodniks = new DefaultListModel();
            view.setListZawodnikModel(dlmZawodniks);
            dlmReprezentacjas = new DefaultListModel();
            view.setListReprezentacjaModel(dlmReprezentacjas);
            // Wyswietlenie wszystkich mundiali
            dlmMundials = new DefaultListModel();
            dlmMundials = SearchMundials();
            view.setListMundialModel(dlmMundials);
        }
    }

    private class ClickOnElementOfListReprezentacja extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            // get nazwa reprezentacji/ setNazwaReprezentacji
            modelReprezentacja.setNazwa(view.getListReprezentacja().getSelectedValue().toString());
            try {
                modelReprezentacja.setIdReprezentacji(reprezentacjaDAO.getReprezentacjaId(modelReprezentacja.getNazwa()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if (view.getCheckboxSpecificRep().getState() == true){ // Jezeli zaznaczony jest cbZawodnicyMundialReprezentacja
                // Wyswietlenie wszystkich zawodnikow w mundialu i reprezentacji
                dlmZawodniks = new DefaultListModel();
                dlmZawodniks= SearchZawodniks(modelMundial.getIdMundialu(),modelReprezentacja.getIdReprezentacji());
                view.setListZawodnikModel(dlmZawodniks);
            }
        }
    }

    private class ClickOnCofnijButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerEkranGlowny(new ViewEkranGlowny());
            view.setVisible(false);
            view.dispose();
        }
    }
}
