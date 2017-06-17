package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.*;
import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.utils.ShowMyMessage;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewGrupaDodaj;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControllerGrupaDodaj {
    private ViewGrupaDodaj view;
    private Mundial modelMundial;
    private Reprezentacja modelReprezentacja;
    private Grupa modelGrupa;
    private DefaultListModel mundialListModel = new DefaultListModel();
    private DefaultListModel reprezentacjaListModel = new DefaultListModel();
    private DefaultListModel grupaAListModel = new DefaultListModel();
    private DefaultListModel grupaBListModel = new DefaultListModel();
    private DefaultListModel grupaCListModel = new DefaultListModel();
    private DefaultListModel grupaDListModel = new DefaultListModel();
    private DefaultListModel grupaEListModel = new DefaultListModel();
    private DefaultListModel grupaFListModel = new DefaultListModel();
    private DefaultListModel grupaGListModel = new DefaultListModel();
    private DefaultListModel grupaHListModel = new DefaultListModel();
    MundialDAO mundialDAO = new MundialDAOImpl();
    ReprezentacjaWGrupaDAO reprezentacjaWGrupaDAO = new ReprezentacjaWGrupaDAOImpl();
    ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    GrupaDAO grupaDAO = new GrupaDAOImpl();
    ShowMyMessage showMyMessage = new ShowMyMessage();
    private String valueMundial, valueMundialLokalizacja, valueReprezentacjaNazwa;
    private int valueMundialRok;


    public ControllerGrupaDodaj(ViewGrupaDodaj view, Mundial modelMundial, Reprezentacja modelReprezentacja, Grupa modelGrupa) {
        this.view = view;
        this.modelMundial = modelMundial;
        this.modelReprezentacja = modelReprezentacja;
        this.modelGrupa = modelGrupa;

        setMundialDLM();
        this.view.addMundialListMouseListener(new PressedOnElementOfMundialList());
        this.view.addReprezentacjaListMouseListener(new PressedOnElementOfReprezentacjaList());
        this.view.addCofnijButtonListener(new BackToPanelAdmin());
        this.view.addDodajGrAButtonListener(new AddReprezentacjaToGrupaA());
        this.view.addDodajGrBButtonListener(new AddReprezentacjaToGrupaB());
        this.view.addDodajGrCButtonListener(new AddReprezentacjaToGrupaC());
        this.view.addDodajGrDButtonListener(new AddReprezentacjaToGrupaD());
        this.view.addDodajGrEButtonListener(new AddReprezentacjaToGrupaE());
        this.view.addDodajGrFButtonListener(new AddReprezentacjaToGrupaF());
        this.view.addDodajGrGButtonListener(new AddReprezentacjaToGrupaG());
        this.view.addDodajGrHButtonListener(new AddReprezentacjaToGrupaH());


    }


    public void setMundialDLM() {
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

    public void setReprezentacjaDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        reprezentacjaListModel.removeAllElements();
        try {
            // Pobranie wartości z JListMundial, elementu który jest zaznaczony
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacja();
            for (Reprezentacja r : reprezentacjaList) {
                reprezentacjaListModel.addElement(r.getNazwa());
            }
            this.view.addListModelToReprezentacjaList(reprezentacjaListModel); // Wywołanie metody, która ustawia modelRep w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGrupaA_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaAListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("A");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaAListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaAList(grupaAListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaB_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaBListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("B");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaBListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaBList(grupaBListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaC_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaCListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("C");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaCListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaCList(grupaCListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaD_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaDListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("D");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaDListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaDList(grupaDListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaE_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaEListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("E");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaEListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaEList(grupaEListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaF_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaFListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("F");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaFListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaFList(grupaFListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaG_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaGListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("G");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaGListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaGList(grupaGListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setGrupaH_DLM() {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            grupaHListModel.removeAllElements();
            modelGrupa.setNazwaGrupy("H");
            try {
                modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getAllReprezentacjeInGrupaByIdMundialuIdGrupy(modelMundial, modelGrupa);
                for (Reprezentacja r : reprezentacjaList) {
                    grupaHListModel.addElement(r.getNazwa());
                }
                this.view.addListModelToGrupaHList(grupaHListModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
                setReprezentacjaDLM();
                setGrupaA_DLM();
                setGrupaB_DLM();
                setGrupaC_DLM();
                setGrupaD_DLM();
                setGrupaE_DLM();
                setGrupaF_DLM();
                setGrupaG_DLM();
                setGrupaH_DLM();
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


    private class AddReprezentacjaToGrupaA implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("A");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaA_DLM();
            }
        }
    }

    private class PressedOnElementOfReprezentacjaList extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getReprezentacjaList().isSelectionEmpty()) {
                valueReprezentacjaNazwa = view.getReprezentacjaList().getSelectedValue().toString();
                try {
                    modelReprezentacja = reprezentacjaDAO.getIdRepByNazwa(valueReprezentacjaNazwa);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    private class AddReprezentacjaToGrupaB implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("B");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaB_DLM();
            }
        }
    }

    private class AddReprezentacjaToGrupaC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("C");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaC_DLM();
            }
        }
    }

    private class AddReprezentacjaToGrupaD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("D");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaD_DLM();
            }
        }
    }

    private class AddReprezentacjaToGrupaE implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("E");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaE_DLM();
            }
        }
    }

    private class AddReprezentacjaToGrupaF implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("F");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaF_DLM();
            }
        }
    }

    private class AddReprezentacjaToGrupaG implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("G");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaG_DLM();
            }
        }
    }

    private class AddReprezentacjaToGrupaH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("H");
                try {
                    modelGrupa = grupaDAO.getIdGrupyByIdMundialuNazwaGrupy(modelMundial, modelGrupa);
                    reprezentacjaWGrupaDAO.addReprezentacjeToGrupa(modelReprezentacja,modelGrupa, modelMundial);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaH_DLM();
            }
        }
    }
}
