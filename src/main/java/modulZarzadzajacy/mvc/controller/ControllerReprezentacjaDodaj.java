package modulZarzadzajacy.mvc.controller;

import modulZarzadzajacy.mvc.model.dao.ReprezentacjaDAO;
import modulZarzadzajacy.mvc.model.entity.Grupa;
import modulZarzadzajacy.mvc.model.entity.Mundial;
import modulZarzadzajacy.mvc.model.entity.Reprezentacja;
import modulZarzadzajacy.mvc.view.ViewGrupaDodaj;
import modulZarzadzajacy.mvc.view.ViewPanelAdministratora;
import modulZarzadzajacy.mvc.view.ViewReprezentacjaDodaj;
import modulZarzadzajacy.mvc.model.dao.ReprezentacjaDAOImpl;
import modulZarzadzajacy.repository.ShowMyMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerReprezentacjaDodaj {
    private ViewReprezentacjaDodaj view;
    private Reprezentacja model;
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private DefaultListModel dlm = new DefaultListModel();
    private ShowMyMessage showMyMessage = new ShowMyMessage();


    public ControllerReprezentacjaDodaj(ViewReprezentacjaDodaj view, Reprezentacja model) {
        this.view = view;
        this.model = model;

        setRepDLM();
        this.view.addDodajReprezentacjeButtonListener(new DodajReprezentacjaButton());
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.setButtonDalejDodajRepDoGrupyActionListener(new ButtonDalejRepDoGrupy());
    }


    private void setRepDLM() {
        // Wstrzyknięcie danych do modeluRep który później jest argumentem JListRep
        dlm.removeAllElements();
        try {
            List<Reprezentacja> reprezentacjaList = reprezentacjaDAO.getAllReprezentacja();
            for (Reprezentacja r : reprezentacjaList) {
                dlm.addElement(r.getNazwa());
            }
            this.view.addListModelToReprezentacjaList(dlm); // Wywołanie metody, która ustawia modelRep w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private class DodajReprezentacjaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getNazwaReprezentacji().equals("")){
                showMyMessage.warningMessage("Wypełnij wszystkie pola!","Warning");
            }
            else if (!view.getNazwaReprezentacji().equals("")){
                model.setNazwa(view.getNazwaReprezentacji());
                try {
                    reprezentacjaDAO.addReprezentacja(model);
                    setRepDLM();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class ButtonDalejRepDoGrupy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerGrupaDodaj(new ViewGrupaDodaj(), new Mundial(), new Reprezentacja(), new Grupa());
            view.setVisible(false);
        }
    }
}
