package koczwara.mundialv1.mvc.controller;

import koczwara.mundialv1.mvc.model.dao.ReprezentacjaDAO;
import koczwara.mundialv1.mvc.model.dao.ReprezentacjaDAOImpl;
import koczwara.mundialv1.mvc.model.entity.Reprezentacja;
import koczwara.mundialv1.repository.ShowMyMessage;
import koczwara.mundialv1.mvc.view.ViewReprezentacjaEdytuj;
import koczwara.mundialv1.mvc.view.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerReprezentacjaEdytuj {
    private ViewReprezentacjaEdytuj view;
    private Reprezentacja model;
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private DefaultListModel dlm = new DefaultListModel();
    private ShowMyMessage showMyMessage = new ShowMyMessage();

    public ControllerReprezentacjaEdytuj(ViewReprezentacjaEdytuj view, Reprezentacja model) {
        this.view = view;
        this.model = model;

        setRepDLM();
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.addEdytujButtonListener(new EdytujReprezentacjaButton());
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

    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }

    private class EdytujReprezentacjaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getReprezentacjaList().isSelectionEmpty()) {
                try {
                    model = reprezentacjaDAO.getIdRepByNazwa(view.getReprezentacjaList().getSelectedValue().toString());
                    model.setNazwa(view.getNowaNazwaReprezentacji());
                    reprezentacjaDAO.updateReprezentacjaById(model);
                    setRepDLM();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else showMyMessage.errorMessage("Nie wybrałeś żadnej reprezentacji z listy!", "Błąd");
        }
    }
}
