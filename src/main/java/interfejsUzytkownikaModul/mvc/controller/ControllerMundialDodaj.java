package interfejsUzytkownikaModul.mvc.controller;

import interfejsUzytkownikaModul.mvc.model.dao.MundialDAO;
import interfejsUzytkownikaModul.mvc.model.entity.Mundial;
import interfejsUzytkownikaModul.mvc.model.entity.Reprezentacja;
import interfejsUzytkownikaModul.mvc.view.ViewMundialDodaj;
import interfejsUzytkownikaModul.mvc.view.ViewPanelAdministratora;
import interfejsUzytkownikaModul.mvc.view.ViewReprezentacjaDodaj;
import interfejsUzytkownikaModul.repository.ShowMyMessage;
import interfejsUzytkownikaModul.mvc.model.dao.MundialDAOImpl;

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
