package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.*;
import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.utils.SetDLM;
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
    private SetDLM setDLM1 = new SetDLM();
    SetDLM setDLM2 = new SetDLM();
    SetDLM setDLM3 = new SetDLM();
    SetDLM setDLM4 = new SetDLM();
    SetDLM setDLM5 = new SetDLM();
    SetDLM setDLM6 = new SetDLM();
    SetDLM setDLM7 = new SetDLM();
    SetDLM setDLM8 = new SetDLM();


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
        this.view.addUsunGrAButtonListener(new DeleteReprezentacjaFromGrupaA());
        this.view.addDodajGrBButtonListener(new AddReprezentacjaToGrupaB());
        this.view.addDodajGrCButtonListener(new AddReprezentacjaToGrupaC());
        this.view.addDodajGrDButtonListener(new AddReprezentacjaToGrupaD());
        this.view.addDodajGrEButtonListener(new AddReprezentacjaToGrupaE());
        this.view.addDodajGrFButtonListener(new AddReprezentacjaToGrupaF());
        this.view.addDodajGrGButtonListener(new AddReprezentacjaToGrupaG());
        this.view.addDodajGrHButtonListener(new AddReprezentacjaToGrupaH());


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
/*
                modelGrupa.setNazwaGrupy("A");
                grupaAListModel = setDLM1.setGrupaNazwaDLM(grupaAListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaAList(grupaAListModel);

                modelGrupa.setNazwaGrupy("B");
                grupaBListModel = setDLM2.setGrupaNazwaDLM(grupaBListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaAList(grupaBListModel);

                modelGrupa.setNazwaGrupy("C");
                grupaCListModel = setDLM3.setGrupaNazwaDLM(grupaCListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaCList(grupaCListModel);

                modelGrupa.setNazwaGrupy("D");
                grupaDListModel = setDLM4.setGrupaNazwaDLM(grupaDListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaDList(grupaDListModel);

                modelGrupa.setNazwaGrupy("E");
                grupaEListModel = setDLM5.setGrupaNazwaDLM(grupaEListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaEList(grupaEListModel);

                modelGrupa.setNazwaGrupy("F");
                grupaFListModel = setDLM6.setGrupaNazwaDLM(grupaFListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaFList(grupaFListModel);

                modelGrupa.setNazwaGrupy("G");
                grupaGListModel = setDLM7.setGrupaNazwaDLM(grupaGListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaGList(grupaGListModel);

                modelGrupa.setNazwaGrupy("H");
                grupaHListModel = setDLM8.setGrupaNazwaDLM(grupaHListModel, modelGrupa, modelMundial);
                view.addListModelToGrupaHList(grupaHListModel);
*/
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
//                grupaAListModel = setDLM1.setGrupaNazwaDLM(grupaAListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaAList(grupaAListModel);
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
//                grupaBListModel = setDLM2.setGrupaNazwaDLM(grupaBListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaAList(grupaBListModel);
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
//                grupaCListModel = setDLM3.setGrupaNazwaDLM(grupaCListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaCList(grupaCListModel);
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
//                grupaDListModel = setDLM4.setGrupaNazwaDLM(grupaDListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaDList(grupaDListModel);
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
//                grupaEListModel = setDLM5.setGrupaNazwaDLM(grupaEListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaEList(grupaEListModel);
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
//                grupaFListModel = setDLM6.setGrupaNazwaDLM(grupaFListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaFList(grupaFListModel);
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
//                grupaGListModel = setDLM7.setGrupaNazwaDLM(grupaGListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaGList(grupaGListModel);
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
//                grupaHListModel = setDLM8.setGrupaNazwaDLM(grupaHListModel, modelGrupa, modelMundial);
//                view.addListModelToGrupaHList(grupaHListModel);
            }
        }
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

    private void setGrupaDLM(String grupaNazwa, int grupaId, int mundialId) {
        if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
            DefaultListModel dlm = new DefaultListModel();
            dlm.removeAllElements();
            try {
                List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getReprezentacjeNazwaByGrupaIdMundialId(grupaId, mundialId);
                for (Reprezentacja r: reprezentacjaList)
                    dlm.addElement(r.getNazwa());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (grupaNazwa.equals("A"))
                this.view.addListModelToGrupaAList(dlm);
            if (grupaNazwa.equals("B"))
                this.view.addListModelToGrupaBList(dlm);
            if (grupaNazwa.equals("C"))
                this.view.addListModelToGrupaCList(dlm);
            if (grupaNazwa.equals("D"))
                this.view.addListModelToGrupaDList(dlm);
            if (grupaNazwa.equals("E"))
                this.view.addListModelToGrupaEList(dlm);
            if (grupaNazwa.equals("F"))
                this.view.addListModelToGrupaFList(dlm);
            if (grupaNazwa.equals("G"))
                this.view.addListModelToGrupaGList(dlm);
            else
                this.view.addListModelToGrupaHList(dlm);

        } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
    }

    private class DeleteReprezentacjaFromGrupaA implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("A");
                // setIdRep, idRep = idRep zaznaczonego elementu w JList
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                // usuwanie zaznaczonej rep / setIdGrupy, idGrupy = idGrupy usunietego elementu
                modelGrupa.setIdGrupy(deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji()));
                // wyswietlenie reprezentacji w JListGrupa nalezacych do jednej grupy,mundialu
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                //setGrupaA_DLM();
            }
        }
    }

    private int getIdReprezentacjiFromJListGrupa(String nazwaGrupy) {
        String nazwaReprezentacji;
        int reprezentacjaId =0;
        if (nazwaGrupy.equals("A"))
            nazwaReprezentacji = this.view.getGrupaAList().getSelectedValue().toString();
        else if (nazwaGrupy.equals("B"))
            nazwaReprezentacji = this.view.getGrupaBList().getSelectedValue().toString();
        else if (nazwaGrupy.equals("C"))
            nazwaReprezentacji = this.view.getGrupaCList().getSelectedValue().toString();
        else if (nazwaGrupy.equals("D"))
            nazwaReprezentacji = this.view.getGrupaDList().getSelectedValue().toString();
        else if (nazwaGrupy.equals("E"))
            nazwaReprezentacji = this.view.getGrupaEList().getSelectedValue().toString();
        else if (nazwaGrupy.equals("F"))
            nazwaReprezentacji = this.view.getGrupaFList().getSelectedValue().toString();
        else if (nazwaGrupy.equals("G"))
            nazwaReprezentacji = this.view.getGrupaGList().getSelectedValue().toString();
        else
            nazwaReprezentacji = this.view.getGrupaHList().getSelectedValue().toString();
        try {
            reprezentacjaId = reprezentacjaDAO.getReprezentacjaIdByReprezentacjaNazwa(nazwaReprezentacji);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reprezentacjaId;
    }

    private int deleteReprezentacjaFromGrupa(String nazwaGrupy, int mundialId, int reprezentacjaId) {
        int grupaId =0;
        try {
            grupaId = grupaDAO.getGrupaIdByMundialIdGrupaNazwa(mundialId, nazwaGrupy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            reprezentacjaWGrupaDAO.deleteReprezentacjaFromGrupa(reprezentacjaId, grupaId, mundialId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupaId;
    }


}
