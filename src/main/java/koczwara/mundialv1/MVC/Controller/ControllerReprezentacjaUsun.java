package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.ReprezentacjaDAO;
import koczwara.mundialv1.MVC.Model.dao.ReprezentacjaDAOImpl;
import koczwara.mundialv1.MVC.Model.dao.ZawodnikWReprezentacjaDAO;
import koczwara.mundialv1.MVC.Model.dao.ZawodnikWReprezentacjaDAOImpl;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Tools.ShowMyMessage;
import koczwara.mundialv1.MVC.View.ViewReprezentacjaUsun;
import koczwara.mundialv1.MVC.View.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerReprezentacjaUsun {
    private ViewReprezentacjaUsun view;
    private Reprezentacja model;
    private ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private DefaultListModel dlm = new DefaultListModel();
    private ShowMyMessage showMyMessage = new ShowMyMessage();

    public ControllerReprezentacjaUsun(ViewReprezentacjaUsun view, Reprezentacja model) {
        this.view = view;
        this.model = model;

        setRepDLM();
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.addUsunReprezentacjeButtonListener(new UsunReprezentacjaButton());
    }

    private class CofnijDoPanelAdmin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
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

    private class UsunReprezentacjaButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!view.getReprezentacjaList().isSelectionEmpty()) {
                view.addShowNazwaReprezentacjiTextField((String) view.getReprezentacjaList().getSelectedValue());
                int idReprezentacja = 0;
                try {
                    model = reprezentacjaDAO.getIdRepByNazwa(view.getReprezentacjaList().getSelectedValue().toString());
                    zawodnikWReprezentacjaDAO.deleteRowsByIdReprezentacji(model);
                    idReprezentacja = model.getIdReprezentacji();
                    reprezentacjaDAO.deleteReprezentacja(idReprezentacja);
                    setRepDLM();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else showMyMessage.errorMessage("Nie wybrałeś żadnej reprezentacji z listy!", "Błąd");
        }
    }
}
