package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.*;
import koczwara.mundialv1.MVC.Model.entity.*;
import koczwara.mundialv1.MVC.Model.utils.ShowMyMessage;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewWyniki;
import koczwara.mundialv1.MVC.View.ViewEkranGlowny;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControllerWyniki {
    private ViewWyniki view;
    private Mundial modelMundial;
    private Mecz modelMecz;
    private Rozgrywka modelRozgrywka;
    private TypGrupy modelTypGrupy;
    private Grupa modelGrupa;
    private Reprezentacja modelReprezentacja;
    private Zawodnik modelZawodnik;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel meczListModel = new DefaultListModel();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private RozgrywkaDAO rozgrywkaDAO = new RozgrywkaDAOImpl();
    private TypGrupyDAO typGrupyDAO = new TypGrupyDAOImpl();
    private GrupaDAO grupaDAO = new GrupaDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private MeczDAO meczDAO = new MeczDAOImpl();
    private ZawodnikDAO zawodnikDAO = new ZawodnikDAOImpl();
    private SkladReprezentacjaDAO skladReprezentacjaDAO = new SkladReprezentacjaDAOImpl();
    private String valueMundialLokalizacja;
    private int valueMundialRok;
    ShowMyMessage showMyMessage = new ShowMyMessage();


    public ControllerWyniki( ViewWyniki view, Mundial modelMundial, Rozgrywka modelRozgrywka, TypGrupy modelTypGrupy, Grupa modelGrupa,
                             Reprezentacja modelReprezentacja, Mecz modelMecz, Zawodnik modelZawodnik){
        this.view = view;
        this.modelMundial = modelMundial;
        this.modelRozgrywka = modelRozgrywka;
        this.modelTypGrupy = modelTypGrupy;
        this.modelGrupa = modelGrupa;
        this.modelReprezentacja = modelReprezentacja;
        this.modelMecz = modelMecz;
        this.modelZawodnik = modelZawodnik;

        setMundialDLM();
        this.view.addMundialListMouseListener(new PressedOnElementOfMundialList());
        this.view.addMeczListMouseListener(new PressedOnElementOfMeczList());
        this.view.addCofnijButtonListener(new BackToPanelAdministratora());

    }

    private void setZawodnicyDoRepXZawXLabel(int meczId, int reprezentacja1Id, int reprezentacja2Id){
        // Wstawianie skladow reprezentacji_1
        try {
            List<Zawodnik> zawodnikList = zawodnikDAO.getZawodnicyImieNazwiskoSklad1ByMeczIdRep1Id(meczId);
            int i=0;
            String tempImieNazwiskoZawodnika[] = new String[16];
            for (Zawodnik z: zawodnikList){
                tempImieNazwiskoZawodnika[i] = z.getImie() +" "+ z.getNazwisko();
                i++;
            }
            this.view.setRep1Zaw1Label(tempImieNazwiskoZawodnika[0].toString());
            this.view.setRep1Zaw2Label(tempImieNazwiskoZawodnika[1].toString());
            this.view.setRep1Zaw3Label(tempImieNazwiskoZawodnika[2].toString());
            this.view.setRep1Zaw4Label(tempImieNazwiskoZawodnika[3].toString());
            this.view.setRep1Zaw5Label(tempImieNazwiskoZawodnika[4].toString());
            this.view.setRep1Zaw6Label(tempImieNazwiskoZawodnika[5].toString());
            this.view.setRep1Zaw7Label(tempImieNazwiskoZawodnika[6].toString());
            this.view.setRep1Zaw8Label(tempImieNazwiskoZawodnika[7].toString());
            this.view.setRep1Zaw9Label(tempImieNazwiskoZawodnika[8].toString());
            this.view.setRep1Zaw10Label(tempImieNazwiskoZawodnika[9].toString());
            this.view.setRep1Zaw11Label(tempImieNazwiskoZawodnika[10].toString());
            this.view.setRep1Zaw12Label(tempImieNazwiskoZawodnika[11].toString());
            this.view.setRep1Zaw13Label(tempImieNazwiskoZawodnika[12].toString());
            this.view.setRep1Zaw14Label(tempImieNazwiskoZawodnika[13].toString());
            this.view.setRep1Zaw15Label(tempImieNazwiskoZawodnika[14].toString());
            this.view.setRep1Zaw16Label(tempImieNazwiskoZawodnika[15].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Wstawianie skladow reprezentacji_2
        try {
            List<Zawodnik> zawodnikList2 = zawodnikDAO.getZawodnicyImieNazwiskoSklad2ByMeczIdRep1Id(meczId);
            int i=0;
            String tempImieNazwiskoZawodnika[] = new String[16];
            for (Zawodnik z: zawodnikList2){
                tempImieNazwiskoZawodnika[i] = z.getImie() +" "+ z.getNazwisko();
                i++;
            }
            this.view.setRep2Zaw1Label(tempImieNazwiskoZawodnika[0].toString());
            this.view.setRep2Zaw2Label(tempImieNazwiskoZawodnika[1].toString());
            this.view.setRep2Zaw3Label(tempImieNazwiskoZawodnika[2].toString());
            this.view.setRep2Zaw4Label(tempImieNazwiskoZawodnika[3].toString());
            this.view.setRep2Zaw5Label(tempImieNazwiskoZawodnika[4].toString());
            this.view.setRep2Zaw6Label(tempImieNazwiskoZawodnika[5].toString());
            this.view.setRep2Zaw7Label(tempImieNazwiskoZawodnika[6].toString());
            this.view.setRep2Zaw8Label(tempImieNazwiskoZawodnika[7].toString());
            this.view.setRep2Zaw9Label(tempImieNazwiskoZawodnika[8].toString());
            this.view.setRep2Zaw10Label(tempImieNazwiskoZawodnika[9].toString());
            this.view.setRep2Zaw11Label(tempImieNazwiskoZawodnika[10].toString());
            this.view.setRep2Zaw12Label(tempImieNazwiskoZawodnika[11].toString());
            this.view.setRep2Zaw13Label(tempImieNazwiskoZawodnika[12].toString());
            this.view.setRep2Zaw14Label(tempImieNazwiskoZawodnika[13].toString());
            this.view.setRep2Zaw15Label(tempImieNazwiskoZawodnika[14].toString());
            this.view.setRep2Zaw16Label(tempImieNazwiskoZawodnika[15].toString());
        } catch (Exception e) {
            e.printStackTrace();
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
                String valueRep1 = modelReprezentacja.getNazwa();
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(r.getIdReprezentacji2());
                String valueRep2 = modelReprezentacja.getNazwa();
                String valueDaneRozgrywki = valueRep1 +" - "+ valueRep2 +" (grupa: "+ modelGrupa.getNazwaGrupy() +") ["+ modelTypGrupy.getNazwaTypu() +"]";
                meczListModel.addElement(valueDaneRozgrywki);
            }
            this.view.addListModelToMeczList(meczListModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class PressedOnElementOfMundialList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty()) {
                String valueMundial = view.getMundialList().getSelectedValue().toString();
                String[] lokalizacjaRok = valueMundial.split(" ");
                valueMundialLokalizacja = lokalizacjaRok[0];
                valueMundialRok = Integer.parseInt(lokalizacjaRok[1]);
                modelMundial.setLokalizacja(valueMundialLokalizacja);
                modelMundial.setRok(valueMundialRok);
                try {
                    modelMundial = mundialDAO.getIdMundialuByLokalizacjaRok(modelMundial); //set idMundialu
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setMeczDLM();
                // Label data Rok
                view.setRokLabel(String.valueOf(valueMundialRok));
            }
        }
    }

    private class PressedOnElementOfMeczList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            int valueIndeks = view.getMeczList().getSelectedIndex(); // Przypisanie do zmiennej valueIndeks wartosci indeksu(pozycji na ktorej znajduje sie zaznaczony element) JListMecz
            try { //Przypisanie zmiennym valueIdRep1 i valueIdRep2 wartosci(IdRep1 i IdRep2 danego meczu - aktualnie zaznaczonego elementu JListMecz)
                modelRozgrywka = rozgrywkaDAO.getAllByMundialIdMeczIndex(modelMundial.getIdMundialu(), valueIndeks);
                modelMecz = meczDAO.getDataGoleR1GoleR2ByIdMeczu(modelRozgrywka.getIdRozgrywki());
                modelMecz.setIdReprezentacji1(modelRozgrywka.getIdReprezentacji1());
                modelMecz.setIdReprezentacji2(modelRozgrywka.getIdReprezentacji2());
                modelMecz.setIdGrupy(modelRozgrywka.getIdGrupy());
                modelMecz.setIdMeczu(modelRozgrywka.getIdRozgrywki());

                String[] dataMeczuRokMiesiacDzien = modelMecz.getDataMeczu().toString().split("-");
                view.setMiesiacLabel(dataMeczuRokMiesiacDzien[1]);
                view.setDzienLabel(dataMeczuRokMiesiacDzien[2]);

                view.setGoleRep1(String.valueOf(modelMecz.getGoleRep1()));
                view.setGoleRep2(String.valueOf(modelMecz.getGoleRep2()));

                setZawodnicyDoRepXZawXLabel(modelMecz.getIdMeczu(), modelMecz.getIdReprezentacji1(), modelMecz.getIdReprezentacji2());

                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(modelMecz.getIdReprezentacji1());
                view.setNazwaRep1(modelReprezentacja.getNazwa());
                modelReprezentacja = reprezentacjaDAO.getNazwaReprezentacjaByIdReprezentacja(modelMecz.getIdReprezentacji2());
                view.setNazwaRep2(modelReprezentacja.getNazwa());
            } catch (Exception e1) {
                e1.printStackTrace();

            }
        }
    }

    private class BackToPanelAdministratora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerEkranGlowny(new ViewEkranGlowny());
            view.setVisible(false);
            view.dispose();
        }
    }
}
