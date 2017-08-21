package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.*;
import koczwara.mundialv1.MVC.Model.entity.*;
import koczwara.mundialv1.MVC.Model.utils.ShowMyMessage;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewMecz;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerGrupaMecz {
    private ViewMecz view;
    private Mundial modelMundial;
    private Mecz modelMecz;
    private Rozgrywka modelRozgrywka;
    private TypGrupy modelTypGrupy;
    private Grupa modelGrupa;
    private Reprezentacja modelReprezentacja;
    private Zawodnik modelZawodnik;
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
    private ShowMyMessage showMyMessage = new ShowMyMessage();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private RozgrywkaDAO rozgrywkaDAO = new RozgrywkaDAOImpl();
    private TypGrupyDAO typGrupyDAO = new TypGrupyDAOImpl();
    private GrupaDAO grupaDAO = new GrupaDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private MeczDAO meczDAO = new MeczDAOImpl();
    private SkladReprezentacjaDAO skladReprezentacjaDAO = new SkladReprezentacjaDAOImpl();
    private String valueMundialLokalizacja, valueMundial, valueRep1, valueRep2;
    private int valueMundialRok;

    public ControllerGrupaMecz(ViewMecz view, Mundial modelMundial, Rozgrywka modelRozgrywka, TypGrupy modelTypGrupy, Grupa modelGrupa,
                               Reprezentacja modelReprezentacja, Mecz modelMecz, Zawodnik modelZawodnik) {
        this.view = view;
        this.modelMundial = modelMundial;
        this.modelRozgrywka = modelRozgrywka;
        this.modelTypGrupy = modelTypGrupy;
        this.modelGrupa = modelGrupa;
        this.modelReprezentacja = modelReprezentacja;
        this.modelMecz = modelMecz;
        this.modelZawodnik = modelZawodnik;

        setMundialDLM();
        this.view.addCofnijButtonListener(new BackToAdminPanel());
        this.view.addMundialListMouseListener(new PressedOnElementOfMundialList());
        this.view.addMeczListMouseListener(new PressedOnElementOfMeczList());
        this.view.addDodajButtonListener(new AddMeczButton());

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
            try { //Przypisanie zmiennym valueIdRep1 i valueIdRep2 wartosci(IdRep1 i IdRep2 danego meczu - aktualnie zaznaczonego elementu JListMecz)
                modelRozgrywka = rozgrywkaDAO.getAllByMundialIdMeczIndex(modelMundial.getIdMundialu(), valueIndeks);
                modelMecz.setIdReprezentacji1(modelRozgrywka.getIdReprezentacji1());
                modelMecz.setIdReprezentacji2(modelRozgrywka.getIdReprezentacji2());
                modelMecz.setIdGrupy(modelRozgrywka.getIdGrupy());
                modelMecz.setIdMeczu(modelRozgrywka.getIdRozgrywki());


            } catch (Exception e1) {
                e1.printStackTrace();
            }
            setZawodnicyComboBoxModel(modelMundial.getIdMundialu(), modelMecz.getIdReprezentacji1(), modelMecz.getIdReprezentacji2()); // Wywolanie metody, która wstawia zawodnikow w ComboBoxy
            // Label Reprezentacja1
            try {
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(modelMecz.getIdReprezentacji1());
                view.setNazwaRep1(modelReprezentacja.getNazwa()); //Ustawienie nazwy LabelReprezentacja1
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // Label Reprezentacja2
            try {
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(modelMecz.getIdReprezentacji2());
                view.setNazwaRep2(modelReprezentacja.getNazwa());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // Wyswietlenie wyniku i daty - jezeli mecz zostal juz wczesniej edytowany wyswietla sie dane, jezeli nie to bd puste pola
            Mecz mecz2 = new Mecz();
            try {
                mecz2 = meczDAO.getDataGoleR1GoleR2ByIdMeczu(modelMecz.getIdMeczu());
                view.setMiesiacToTF(String.valueOf(mecz2.getDataMeczu()).substring(5,7));
                view.setDzienToTF(String.valueOf(mecz2.getDataMeczu()).substring(8));
                view.setGoleRep1(mecz2.getGoleRep1());
                view.setGoleRep2(mecz2.getGoleRep2());
            } catch (NullPointerException ex) {
                view.setMiesiacToTF("");
                view.setDzienToTF("");
                view.setGoleRep1("");
                view.setGoleRep2("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private class AddMeczButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() & !view.getMeczList().isSelectionEmpty() & !view.getMiesiacFromTextField().isEmpty()
                    & !view.getDzienFromTextField().isEmpty() & !view.getGoleRep1().isEmpty() & !view.getGoleRep2().isEmpty()) {
                //Przypisanie modelMecz danych idRep1, idRep2, idGrupy, idMundialu - te dane już mamy
                //modelMecz.setIdMeczu(modelRozgrywka.getIdRozgrywki());
                //modelMecz.setIdReprezentacji1(modelRozgrywka.getIdReprezentacji1());
                //modelMecz.setIdReprezentacji2(modelRozgrywka.getIdReprezentacji2());
                //modelMecz.setIdGrupy(modelRozgrywka.getIdGrupy());
                modelMecz.setIdMundialu(modelMundial.getIdMundialu());

                // Sprawdza czy gole sa cyfra czy litera i parsuje do int
                String wyrazenieRegularneGole = "\\d{1,2}"; // Wyrazenie regularne: 1 lub 2 cyfry 0-9
                Pattern pattern = Pattern.compile(wyrazenieRegularneGole);
                Matcher matcher = pattern.matcher(view.getGoleRep1());
                if (matcher.matches() == true) {
                    int wynikReprezentacja1 = Integer.parseInt(view.getGoleRep1()); // zamiast zmiennej wstawic modelMecz(goleR1);
                    matcher = pattern.matcher(view.getGoleRep2());
                    if (matcher.matches() == true) {
                        int wynikReprezentacja2 = Integer.parseInt(view.getGoleRep2()); // zamiast zmiennej wstawic modelMecz(goleR2);
                        modelMecz.setGoleRep1(Integer.parseInt(view.getGoleRep1()));
                        modelMecz.setGoleRep2(Integer.parseInt(view.getGoleRep2()));
                        // Sprawdza czy DATA jest dobrze zapisana i parsowanie jej do int
                        pattern = Pattern.compile("\\d{2}");
                        matcher = pattern.matcher(view.getMiesiacFromTextField());
                        if (matcher.matches() == true) { // jezeli wprowadzone dane do miesiac to cyfry
                            int tempMiesiac = (Integer.parseInt(view.getMiesiacFromTextField())); // parsowanie String na int
                            if (tempMiesiac > 0 & tempMiesiac <= 12) { // jesli  miesiac ma wartosc 1-12 to ...
                                matcher = pattern.matcher(view.getDzienFromTextField());
                                if (matcher.matches() == true) { //jezeli wprowadzone dane do dzien to cyfry
                                    int tempDzien = (Integer.parseInt(view.getDzienFromTextField()));
                                    if (tempDzien > 0 & tempDzien <= 31) { // jesli dzien ma wartosc 1-31 to ..
                                        String tempData = String.valueOf(valueMundialRok) +"-"+ view.getMiesiacFromTextField() +"-"+ view.getDzienFromTextField();
                                        Date parsed = null;
                                        parsed = java.sql.Date.valueOf(tempData);
                                        modelMecz.setDataMeczu((java.sql.Date) parsed);
                                        // Sprawdzenie czy zawodnicy w ComboBoxach sie powtarzaja dla obu reprezentacji
                                        String[] tablicaZawodnikowReprezentacja1 = dodanieZawodnikReprezentacja1ComboBoxDoTablicy();
                                        String[] tablicaZawodnikowReprezentacja2 = dodanieZawodnikReprezentacja2ComboBoxDoTablicy();
                                        int licznikPowtorzen = sprawdzaniePowtarzaniaSieZawodnikow(tablicaZawodnikowReprezentacja1,view.getNazwaReprezentacji1FromLabel());
                                        if (licznikPowtorzen == 0) { // jezeli zawodnicy rep1 sie nie powtarzaja
                                            licznikPowtorzen = sprawdzaniePowtarzaniaSieZawodnikow(tablicaZawodnikowReprezentacja2, view.getNazwaReprezentacji2FromLabel());
                                            if (licznikPowtorzen == 0) { // jezeli zawodnicy rep2 sie nie powtarzaja
                                                // Szukanie i tworzenie tablicy zawodnicyId
                                                int[] zawodnicyRep1Id = szukanieIdZawodnikowZComboBox(tablicaZawodnikowReprezentacja1, modelMecz.getIdMundialu(), modelMecz.getIdReprezentacji1());
                                                int[] zawodnicyRep2Id = szukanieIdZawodnikowZComboBox(tablicaZawodnikowReprezentacja2, modelMecz.getIdMundialu(), modelMecz.getIdReprezentacji2());
                                                // Dodawanie danych do t_mecz
                                                try {
                                                    meczDAO.addMecz(modelMecz.getIdMeczu(),modelMecz.getDataMeczu(), modelMecz.getIdReprezentacji1(), modelMecz.getIdReprezentacji2(), modelMecz.getIdGrupy(), modelMecz.getIdMundialu(),modelMecz.getGoleRep1(), modelMecz.getGoleRep2());
                                                } catch (Exception e1) {
                                                    e1.printStackTrace();
                                                }
                                                // Dodawanie danych do t_sklady_rep_1 ORAZ t_sklady_rep_2, w petli FOR
                                                for (int i=0; i<16; i++) {
                                                    try {
                                                        skladReprezentacjaDAO.addSkladReprezentacja1(modelMecz.getIdReprezentacji1(), modelMecz.getIdReprezentacji2(), modelMecz.getIdGrupy(), modelMecz.getIdMundialu(), zawodnicyRep1Id[i], modelMecz.getIdMeczu());
                                                    } catch (Exception e1) {
                                                        e1.printStackTrace();
                                                    }
                                                    try {
                                                        skladReprezentacjaDAO.addSkladReprezentacja2(modelMecz.getIdReprezentacji1(), modelMecz.getIdReprezentacji2(), modelMecz.getIdGrupy(), modelMecz.getIdMundialu(), zawodnicyRep2Id[i], modelMecz.getIdMeczu());
                                                    } catch (Exception e1) {
                                                        e1.printStackTrace();
                                                    }
                                                }
                                            } else {
                                                showMyMessage.errorMessage("Jeden lub więcej zawodników powtarza się w składzie reprezentacji "+view.getNazwaReprezentacji2FromLabel()+". Zawodnicy nie mogą się powtarzać!", "SKŁAD "+view.getNazwaReprezentacji2FromLabel()+": błąd podczas wyboru zawodnika");
                                            }
                                        } else {
                                            showMyMessage.errorMessage("Jeden lub więcej zawodników powtarza się w składzie reprezentacji "+view.getNazwaReprezentacji1FromLabel()+". Zawodnicy nie mogą się powtarzać!", "SKŁAD "+view.getNazwaReprezentacji1FromLabel()+": błąd podczas wyboru zawodnika");
                                        }

                                    } else showMyMessage.errorMessage("Wprowadź cyfry 01-31 do kolumny dzien, np. 07 - siódmy", "DATA DZIEŃ: niepoprawnie wprowadzone dane");
                                } else showMyMessage.errorMessage("Wprowadź dwie cyfry (0-9) do kolumny dzień, np. 03 - trzeci", "DATA DZIEŃ: niepoprawnie wprowadzone dane");
                            } else showMyMessage.errorMessage("Wprowadź date 01-12 dla kolumny miesiąc, np. 02 - luty", "DATA MIESIĄC: niepoprawnie wprowadzone dane");
                        } else showMyMessage.errorMessage("Wprowadź dwie cyfry 0-9", "DATA MIESIĄC: niepoprawnie wprowadzone dane");
                    } else showMyMessage.errorMessage("Wprowadź jedną lub dwie cyfry 0-9", "GOLE "+view.getNazwaReprezentacji2FromLabel()+": Podane dane są nieprawidłowe");
                } else showMyMessage.errorMessage("Wprowadź jedną lub dwie cyfry 0-9", "GOLE "+view.getNazwaReprezentacji1FromLabel()+": Podane dane są nieprawidłowe");
            }
        }
    }

    private int sprawdzaniePowtarzaniaSieZawodnikow(String[] tabZawodnikReprezentacja, String nazwaReprezentacji) {
        int licznikPowtorzen = 0;
        for (int i=0; i<15; i++) {
            for (int j = i + 1; j < 16; j++) {
                if (tabZawodnikReprezentacja[i].equals(tabZawodnikReprezentacja[j]) == true) {
                    //showMyMessage.errorMessage("Jeden lub więcej zawodników powtarza się w składzie reprezentacji gospodarzy. Zawodnicy nie mogą się powtarzać!", "SKŁAD "+nazwaReprezentacji+": błąd podczas wyboru zawodnika");
                    licznikPowtorzen += 1;
                }
            }
        }
        return licznikPowtorzen;
    }

    private int[] szukanieIdZawodnikowZComboBox(String[] tabImieNazwisko, int mundialId, int reprezentacjaId) {
        int[] zawodnikId = new int[16];
        for (int i=0; i<16; i++) {
            String[] tempZawodnikImieNazwisko = tabImieNazwisko[i].split("\\s");
            try {
                modelZawodnik = zawodnikWReprezentacjaDAO.getZawodnikIdByMundialIdReprezentacjaIdImieNazwisko(mundialId, reprezentacjaId, tempZawodnikImieNazwisko[0], tempZawodnikImieNazwisko[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            zawodnikId[i] = modelZawodnik.getIdZawodnika();
        }
        return zawodnikId;
    }

    private String[] dodanieZawodnikReprezentacja1ComboBoxDoTablicy() {
        String tabZawodnikReprezentacja1ComboBox[] = new String[16];
        tabZawodnikReprezentacja1ComboBox[0] = zaw1Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[1] = zaw2Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[2] = zaw3Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[3] = zaw4Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[4] = zaw5Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[5] = zaw6Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[6] = zaw7Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[7] = zaw8Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[8] = zaw9Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[9] = zaw10Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[10] = zaw11Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[11] = zaw12Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[12] = zaw13Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[13] = zaw14Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[14] = zaw15Rep1ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja1ComboBox[15] = zaw16Rep1ComboBoxModel.getSelectedItem().toString();
        return tabZawodnikReprezentacja1ComboBox;
    }

    private String[] dodanieZawodnikReprezentacja2ComboBoxDoTablicy() {
        String tabZawodnikReprezentacja2ComboBox[] = new String[16];
        tabZawodnikReprezentacja2ComboBox[0] = zaw1Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[1] = zaw2Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[2] = zaw3Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[3] = zaw4Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[4] = zaw5Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[5] = zaw6Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[6] = zaw7Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[7] = zaw8Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[8] = zaw9Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[9] = zaw10Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[10] = zaw11Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[11] = zaw12Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[12] = zaw13Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[13] = zaw14Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[14] = zaw15Rep2ComboBoxModel.getSelectedItem().toString();
        tabZawodnikReprezentacja2ComboBox[15] = zaw16Rep2ComboBoxModel.getSelectedItem().toString();
        return tabZawodnikReprezentacja2ComboBox;
    }

}
