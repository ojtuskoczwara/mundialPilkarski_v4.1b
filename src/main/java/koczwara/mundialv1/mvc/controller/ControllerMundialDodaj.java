package koczwara.mundialv1.mvc.controller;

import koczwara.mundialv1.mvc.model.dao.MundialDAO;
import koczwara.mundialv1.mvc.model.dao.MundialDAOImpl;
import koczwara.mundialv1.mvc.model.entity.Mundial;
import koczwara.mundialv1.mvc.model.entity.Reprezentacja;
import koczwara.mundialv1.repository.ShowMyMessage;
import koczwara.mundialv1.mvc.view.ViewMundialDodaj;
import koczwara.mundialv1.mvc.view.ViewReprezentacjaDodaj;
import koczwara.mundialv1.mvc.view.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerMundialDodaj {
    private ViewMundialDodaj view;
    private Mundial model;
    private DefaultListModel dlm = new DefaultListModel();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ShowMyMessage showMyMessage = new ShowMyMessage();

    public ControllerMundialDodaj(ViewMundialDodaj view, Mundial model) {
        this.view = view;
        this.model = model;

        setDLM(); // Ustawienie modelu(listy mundiali) do JList
        this.view.setDodajMundialButtonListener(new DodajMundialButtonListener());
        this.view.setCofnijButtonListener(new CofnijButtonListener());
        this.view.setButtonDalejReprezentacjaActionListener(new ButtonDalejReprezentacja());
    }

    private class DodajMundialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.setLokalizacja(view.getNazwaMundialu());
                model.setRok(Integer.parseInt(view.getRokMundialu()));
                mundialDAO.addMundial(model);
                setDLM(); // odświeżenie listy mundiali w Jlist
                showMyMessage.informationMessage("Dodanie mundialu zakończone pomyślnie", "Success");
            } catch (NumberFormatException ex) {
                showMyMessage.warningMessage("Wypełnij wszystkie pola!","Warning");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private class CofnijButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }

    private void setDLM() {
        // Wstrzyknięcie danych do modeluMundialu który później jest argumentem JListMundiale
        dlm.removeAllElements();
        try {
            List<Mundial> mundialList = mundialDAO.getAllMundial();
            for (Mundial m : mundialList) {
                String valueLokalizacjaRok = m.getLokalizacja() + " " + m.getRok();
                dlm.addElement(valueLokalizacjaRok);
            }
            this.view.setListToMundialeList(dlm); // Wywołanie metody, która ustawia modelMundiale w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class ButtonDalejReprezentacja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerReprezentacjaDodaj(new ViewReprezentacjaDodaj(), new Reprezentacja());
            view.setVisible(false);
        }
    }
}
