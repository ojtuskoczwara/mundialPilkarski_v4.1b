package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.ReprezentacjaDAO;
import koczwara.mundialv1.MVC.Model.dao.ReprezentacjaDAOImpl;
import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.utils.*;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewGrupaDodaj;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewReprezentacjaDodaj;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerReprezentacjaDodaj {
    private ViewReprezentacjaDodaj view;
    private Reprezentacja model;
    ReprezentacjaDAO reprezentacjaDAO = new ReprezentacjaDAOImpl();
    private DefaultListModel dlm = new DefaultListModel();
    ShowMyMessage showMyMessage = new ShowMyMessage();


    public ControllerReprezentacjaDodaj(ViewReprezentacjaDodaj view, Reprezentacja model) {
        this.view = view;
        this.model = model;

        setRepDLM();
        this.view.addDodajReprezentacjeButtonListener(new DodajReprezentacjaButton());
        this.view.addCofnijButtonListener(new CofnijDoPanelAdmin());
        this.view.setButtonDalejDodajRepDoGrupyActionListener(new ButtonDalejRepDoGrupy());
    }


    public void setRepDLM() {
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
