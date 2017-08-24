package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.*;
import koczwara.mundialv1.MVC.Model.entity.*;
import koczwara.mundialv1.MVC.Tools.ShowMyMessage;
import koczwara.mundialv1.MVC.View.ViewGrupaDodaj;
import koczwara.mundialv1.MVC.View.ViewZawodnikDodaj;
import koczwara.mundialv1.MVC.View.ViewPanelAdministratora;

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
        this.view.addUsunGrAButtonListener(new DeleteReprezentacjaFromGrupaA());
        this.view.addDodajGrBButtonListener(new AddReprezentacjaToGrupaB());
        this.view.addUsunGrBButtonListener(new DeleteReprezentacjaFromGrupaB());
        this.view.addDodajGrCButtonListener(new AddReprezentacjaToGrupaC());
        this.view.addUsunGrCButtonListener(new DeleteReprezentacjaFromGrupaC());
        this.view.addDodajGrDButtonListener(new AddReprezentacjaToGrupaD());
        this.view.addUsunGrDButtonListener(new DeleteReprezentacjaFromGrupaD());
        this.view.addDodajGrEButtonListener(new AddReprezentacjaToGrupaE());
        this.view.addUsunGrEButtonListener(new DeleteReprezentacjaFromGrupaE());
        this.view.addDodajGrFButtonListener(new AddReprezentacjaToGrupaF());
        this.view.addUsunGrFButtonListener(new DeleteReprezentacjaFromGrupaF());
        this.view.addDodajGrGButtonListener(new AddReprezentacjaToGrupaG());
        this.view.addUsunGrGButtonListener(new DeleteReprezentacjaFromGrupaG());
        this.view.addDodajGrHButtonListener(new AddReprezentacjaToGrupaH());
        this.view.addUsunGrHButtonListener(new DeleteReprezentacjaFromGrupaH());
        this.view.setButtonDalejDodajZawodnikaActionListener(new GoToZawodnikAdding());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.view.addListModelToMundialList(mundialListModel); // Wywołanie metody, która ustawia modelMundiale w widoku
    }

    public void setReprezentacjaDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        reprezentacjaListModel.removeAllElements();
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacja();
            for (Reprezentacja r : reprezentacjaList)
                reprezentacjaListModel.addElement(r.getNazwa());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.view.addListModelToReprezentacjaList(reprezentacjaListModel); // Wywołanie metody, która ustawia modelRep w widoku
    }

    private void setGrupaDLM(String grupaNazwa, int mundialId) {
        DefaultListModel dlm = new DefaultListModel();
        dlm.removeAllElements();
        try {
            modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(mundialId, grupaNazwa));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaWGrupaDAO.getReprezentacjeNazwaByGrupaIdMundialId(modelGrupa.getIdGrupy(), mundialId);
            for (Reprezentacja r: reprezentacjaList)
                dlm.addElement(r.getNazwa());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (grupaNazwa.equals("A"))
            this.view.addListModelToGrupaAList(dlm);
        else if (grupaNazwa.equals("B"))
            this.view.addListModelToGrupaBList(dlm);
        else if (grupaNazwa.equals("C"))
            this.view.addListModelToGrupaCList(dlm);
        else if (grupaNazwa.equals("D"))
            this.view.addListModelToGrupaDList(dlm);
        else if (grupaNazwa.equals("E"))
            this.view.addListModelToGrupaEList(dlm);
        else if (grupaNazwa.equals("F"))
            this.view.addListModelToGrupaFList(dlm);
        else if (grupaNazwa.equals("G"))
            this.view.addListModelToGrupaGList(dlm);
        else if (grupaNazwa.equals("H"))
            this.view.addListModelToGrupaHList(dlm);

    }

    private int getIdReprezentacjiFromJListGrupa(String nazwaGrupy) {
        String nazwaReprezentacji = null;
        int reprezentacjaId = 0;
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
        else if (nazwaGrupy.equals("H"))
            nazwaReprezentacji = this.view.getGrupaHList().getSelectedValue().toString();
        try {
            reprezentacjaId = reprezentacjaDAO.getReprezentacjaIdByReprezentacjaNazwa(nazwaReprezentacji);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reprezentacjaId;
    }

    private void deleteReprezentacjaFromGrupa(String nazwaGrupy, int mundialId, int reprezentacjaId) {
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
                setGrupaDLM("A",modelMundial.getIdMundialu());
                setGrupaDLM("B",modelMundial.getIdMundialu());
                setGrupaDLM("C",modelMundial.getIdMundialu());
                setGrupaDLM("D",modelMundial.getIdMundialu());
                setGrupaDLM("E",modelMundial.getIdMundialu());
                setGrupaDLM("F",modelMundial.getIdMundialu());
                setGrupaDLM("G",modelMundial.getIdMundialu());
                setGrupaDLM("H",modelMundial.getIdMundialu());
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
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaB implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("B");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("C");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("D");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaE implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("E");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaF implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("F");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaG implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("G");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class AddReprezentacjaToGrupaH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getReprezentacjaList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("H");
                try {
                    modelGrupa.setIdGrupy(grupaDAO.getGrupaIdByMundialIdGrupaNazwa(modelMundial.getIdMundialu(), modelGrupa.getNazwaGrupy()));
                    reprezentacjaWGrupaDAO.addReprezentacjaToGrupa(modelReprezentacja.getIdReprezentacji(), modelGrupa.getIdGrupy(), modelMundial.getIdMundialu());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz dodać do grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaA implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaAList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("A");
                // setIdRep, idRep = idRep zaznaczonego elementu w JList
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                // usuwanie zaznaczonej rep / setIdGrupy, idGrupy = idGrupy usunietego elementu
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                // wyswietlenie reprezentacji w JListGrupa nalezacych do jednej grupy,mundialu
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }


    private class DeleteReprezentacjaFromGrupaB implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaBList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("B");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaCList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("C");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaD implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaDList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("D");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaE implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaEList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("E");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaF implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaFList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("F");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaG implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() || !view.getGrupaGList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("G");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class DeleteReprezentacjaFromGrupaH implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getMundialList().isSelectionEmpty() & !view.getGrupaHList().isSelectionEmpty()) {
                modelGrupa.setNazwaGrupy("H");
                modelReprezentacja.setIdReprezentacji(getIdReprezentacjiFromJListGrupa(modelGrupa.getNazwaGrupy()));
                deleteReprezentacjaFromGrupa(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu(), modelReprezentacja.getIdReprezentacji());
                setGrupaDLM(modelGrupa.getNazwaGrupy(), modelMundial.getIdMundialu());
            } else showMyMessage.errorMessage("Wybierz mundial oraz reprezentację, którą chcesz usunąć z grupy.", "Nie wybrano mundialu lub reprezentacji");
        }
    }

    private class GoToZawodnikAdding implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerZawodnikDodaj(new ViewZawodnikDodaj(), new Zawodnik(), new Reprezentacja(), new Mundial(), new ZawodnikWReprezentacja());
            view.setVisible(false);
        }
    }
}
