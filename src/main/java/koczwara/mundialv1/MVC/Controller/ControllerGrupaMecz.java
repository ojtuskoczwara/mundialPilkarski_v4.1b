package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.*;
import koczwara.mundialv1.MVC.Model.entity.*;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewMecz;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControllerGrupaMecz {
    private ViewMecz view;
    private Mundial modelMundial;
    private Mecz modelMecz;
    private Rozgrywka modelRozgrywka;
    private TypGrupy modelTypGrupy;
    private Grupa modelGrupa;
    private Reprezentacja modelReprezentacja;
    private SkladReprezentacja1 modelSkladReprezentacja1;
    private SkladReprezentacja2 modelSkladReprezentacja2;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel meczListModel = new DefaultListModel();
    private DefaultComboBoxModel zaw1Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw2Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw3Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw4Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw5Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw6Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw7Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw8Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw9Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw10Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw11Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw12Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw13Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw14Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw15Rep1ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw16Rep1ComboBoxModel = new DefaultComboBoxModel();

    private DefaultComboBoxModel zaw1Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw2Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw3Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw4Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw5Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw6Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw7Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw8Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw9Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw10Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw11Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw12Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw13Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw14Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw15Rep2ComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel zaw16Rep2ComboBoxModel = new DefaultComboBoxModel();

    MundialDAO mundialDAO = new MundialDAOImpl();
    ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    RozgrywkaDAO rozgrywkaDAO = new RozgrywkaDAOImpl();
    TypGrupyDAO typGrupyDAO = new TypGrupyDAOImpl();
    GrupaDAO grupaDAO = new GrupaDAOImpl();
    ZawodnikDAO zawodnikDAO = new ZawodnikDAOImpl();
    ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private String valueMundialLokalizacja, valueMundial, valueRep1, valueRep2;
    private int valueMundialRok;

    public ControllerGrupaMecz(ViewMecz view, Mundial modelMundial, Rozgrywka modelRozgrywka, TypGrupy modelTypGrupy, Grupa modelGrupa, Reprezentacja modelReprezentacja) {
        this.view = view;
        this.modelMundial = modelMundial;
        this.modelRozgrywka = modelRozgrywka;
        this.modelTypGrupy = modelTypGrupy;
        this.modelGrupa = modelGrupa;
        this.modelReprezentacja = modelReprezentacja;

        setMundialDLM();
        this.view.addCofnijButtonListener(new BackToAdminPanel());
        this.view.addMundialListMouseListener(new PressedOnElementOfMundialList());
        this.view.addMeczListMouseListener(new PressedOnElementOfMeczList());

    }



    private class BackToAdminPanel implements ActionListener {
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

    public void setMeczDLM() {
        // Wstrzyknięcie danych do modeluMecz który później jest argumentem JListMecz
        meczListModel.removeAllElements();
        try {
            List<Rozgrywka> rozgrywkaList = rozgrywkaDAO.getAllRozgrywkaByIdMundialu(modelMundial.getIdMundialu());
            for (Rozgrywka r: rozgrywkaList) {
                modelTypGrupy = typGrupyDAO.getNazwaTypuGrupyByIdTypuGrupy(r.getIdTypuGrupy()); // Szukanie nazwy typu grupy po Id typu grupy
                modelGrupa = grupaDAO.getNazwaByIdGrupyIdMundialu(r.getIdGrupy(), r.getIdMundialu()); // Szukanie nazwy grupy po id grupy i id mundialu
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(r.getIdReprezentacji1());
                valueRep1 = modelReprezentacja.getNazwa();
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(r.getIdReprezentacji2());
                valueRep2 = modelReprezentacja.getNazwa();
//                String valueDaneRozgrywki = r.getIdRozgrywki() +"/ "+ r.getIdGrupy() +"/ "+ r.getIdGrupy1() +"/ "+ r.getIdReprezentacji1()
//                        +"/ "+ r.getIdGrupy2() +"/ "+ r.getIdReprezentacji2() +"/ "+ r.getIdMundialu() +"/ "+ r.getIdTypuGrupy();
//                String valueDaneRozgrywki = modelTypGrupy.getNazwaTypu() +"/ "+ modelGrupa.getNazwaGrupy() +"/ "+ valueRep1 +" - "+ valueRep2;
                String valueDaneRozgrywki = valueRep1 +" - "+ valueRep2 +" (grupa: "+ modelGrupa.getNazwaGrupy() +") ["+ modelTypGrupy.getNazwaTypu() +"]";
                meczListModel.addElement(valueDaneRozgrywki);
            }
            this.view.addListModelToMeczList(meczListModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setZawodnicyComboBoxModel(int idMundialu, int idReprezentacji1, int idReprezentacji2) {
        zaw1Rep1ComboBoxModel.removeAllElements();
        zaw2Rep1ComboBoxModel.removeAllElements();
        zaw3Rep1ComboBoxModel.removeAllElements();
        zaw4Rep1ComboBoxModel.removeAllElements();
        zaw5Rep1ComboBoxModel.removeAllElements();
        zaw6Rep1ComboBoxModel.removeAllElements();
        zaw7Rep1ComboBoxModel.removeAllElements();
        zaw8Rep1ComboBoxModel.removeAllElements();
        zaw9Rep1ComboBoxModel.removeAllElements();
        zaw10Rep1ComboBoxModel.removeAllElements();
        zaw11Rep1ComboBoxModel.removeAllElements();
        zaw12Rep1ComboBoxModel.removeAllElements();
        zaw13Rep1ComboBoxModel.removeAllElements();
        zaw14Rep1ComboBoxModel.removeAllElements();
        zaw15Rep1ComboBoxModel.removeAllElements();
        zaw16Rep1ComboBoxModel.removeAllElements();

        zaw1Rep2ComboBoxModel.removeAllElements();
        zaw2Rep2ComboBoxModel.removeAllElements();
        zaw3Rep2ComboBoxModel.removeAllElements();
        zaw4Rep2ComboBoxModel.removeAllElements();
        zaw5Rep2ComboBoxModel.removeAllElements();
        zaw6Rep2ComboBoxModel.removeAllElements();
        zaw7Rep2ComboBoxModel.removeAllElements();
        zaw8Rep2ComboBoxModel.removeAllElements();
        zaw9Rep2ComboBoxModel.removeAllElements();
        zaw10Rep2ComboBoxModel.removeAllElements();
        zaw11Rep2ComboBoxModel.removeAllElements();
        zaw12Rep2ComboBoxModel.removeAllElements();
        zaw13Rep2ComboBoxModel.removeAllElements();
        zaw14Rep2ComboBoxModel.removeAllElements();
        zaw15Rep2ComboBoxModel.removeAllElements();
        zaw16Rep2ComboBoxModel.removeAllElements();
        try { //
            List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getImieNazwiskoZawodnikaByIdMundialuIdReprezentacji(idMundialu, idReprezentacji1);
            for (Zawodnik z: zawodnikList) {
                String tempImieNazwisko = z.getImie() +" "+ z.getNazwisko();
                zaw1Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw2Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw3Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw4Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw5Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw6Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw7Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw8Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw9Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw10Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw11Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw12Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw13Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw14Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw15Rep1ComboBoxModel.addElement(tempImieNazwisko);
                zaw16Rep1ComboBoxModel.addElement(tempImieNazwisko);
            }
            this.view.addComboBoxModelToZawodnik1Rep1ComboBox(zaw1Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik2Rep1ComboBox(zaw2Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik3Rep1ComboBox(zaw3Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik4Rep1ComboBox(zaw4Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik5Rep1ComboBox(zaw5Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik6Rep1ComboBox(zaw6Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik7Rep1ComboBox(zaw7Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik8Rep1ComboBox(zaw8Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik9Rep1ComboBox(zaw9Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik10Rep1ComboBox(zaw10Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik11Rep1ComboBox(zaw11Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik12Rep1ComboBox(zaw12Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik13Rep1ComboBox(zaw13Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik14Rep1ComboBox(zaw14Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik15Rep1ComboBox(zaw15Rep1ComboBoxModel);
            this.view.addComboBoxModelToZawodnik16Rep1ComboBox(zaw16Rep1ComboBoxModel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<Zawodnik> zawodnikList = zawodnikWReprezentacjaDAO.getImieNazwiskoZawodnikaByIdMundialuIdReprezentacji(idMundialu, idReprezentacji2);
            for (Zawodnik z: zawodnikList) {
                String tempImieNazwisko = z.getImie() +" "+ z.getNazwisko();
                zaw1Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw2Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw3Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw4Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw5Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw6Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw7Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw8Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw9Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw10Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw11Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw12Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw13Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw14Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw15Rep2ComboBoxModel.addElement(tempImieNazwisko);
                zaw16Rep2ComboBoxModel.addElement(tempImieNazwisko);
            }
            this.view.addComboBoxModelToZawodnik1Rep2ComboBox(zaw1Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik2Rep2ComboBox(zaw2Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik3Rep2ComboBox(zaw3Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik4Rep2ComboBox(zaw4Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik5Rep2ComboBox(zaw5Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik6Rep2ComboBox(zaw6Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik7Rep2ComboBox(zaw7Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik8Rep2ComboBox(zaw8Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik9Rep2ComboBox(zaw9Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik10Rep2ComboBox(zaw10Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik11Rep2ComboBox(zaw11Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik12Rep2ComboBox(zaw12Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik13Rep2ComboBox(zaw13Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik14Rep2ComboBox(zaw14Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik15Rep2ComboBox(zaw15Rep2ComboBoxModel);
            this.view.addComboBoxModelToZawodnik16Rep2ComboBox(zaw16Rep2ComboBoxModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class PressedOnElementOfMundialList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty()) {
                valueMundial = view.getMundialList().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0, valueMundial.length() - 5);
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length() - 4));

                modelMundial.setLokalizacja(valueMundialLokalizacja);
                modelMundial.setRok(valueMundialRok);
                try {
                    modelMundial = mundialDAO.getIdMundialuByLokalizacjaRok(modelMundial); //set idMundialu
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setMeczDLM();
                // Label data Rok
                view.setRokToLabel(String.valueOf(valueMundialRok));
            }
        }
    }


    private class PressedOnElementOfMeczList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            // ComboBoxy
            int valueIndeks = view.getMeczList().getSelectedIndex(); // Przypisanie do zmiennej valueIndeks wartosci indeksu(pozycji na ktorej znajduje sie zaznaczony element) JListMecz
            int valueIdRep1 = 0,valueIdRep2 = 0;
            try { //Przypisanie zmiennym valueIdRep1 i valueIdRep2 wartosci(IdRep1 i IdRep2 danego meczu - aktualnie zaznaczonego elementu JListMecz)
                 modelRozgrywka = rozgrywkaDAO.getIdReprezentacji1ByIndexMeczuIdMundialu(valueIndeks,modelMundial.getIdMundialu());
                 valueIdRep1 = modelRozgrywka.getIdReprezentacji1();
                 modelRozgrywka = rozgrywkaDAO.getIdReprezentacji2ByIndexMeczuIdMundialu(valueIndeks, modelMundial.getIdMundialu());
                 valueIdRep2 = modelRozgrywka.getIdReprezentacji2();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            setZawodnicyComboBoxModel(modelMundial.getIdMundialu(), valueIdRep1, valueIdRep2); // Wywolanie metody, która wstawia zawodnikow w ComboBoxy
            // Label Reprezentacja1
            try {
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(valueIdRep1);
                view.setNazwaRep1(modelReprezentacja.getNazwa()); //Ustawienie nazwy LabelReprezentacja1
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // Label Reprezentacja2
            try {
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(valueIdRep2);
                view.setNazwaRep2(modelReprezentacja.getNazwa());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // TextField Data Miesiac



        }
    }
}
