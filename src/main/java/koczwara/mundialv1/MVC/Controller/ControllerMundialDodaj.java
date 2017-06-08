package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.dao.MundialDAO;
import koczwara.mundialv1.MVC.Model.dao.MundialDAOImpl;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewMundialDodaj;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerMundialDodaj {
    private ViewMundialDodaj view;
    private Mundial model;
    private DefaultListModel dlm = new DefaultListModel();
    MundialDAO mundialDAO = new MundialDAOImpl();

    public ControllerMundialDodaj(ViewMundialDodaj view, Mundial model) {
        this.view = view;
        this.model = model;

        setDLM(); // Ustawienie modelu(listy mundiali) do JList
        this.view.setDodajMundialButtonListener(new DodajMundialButtonListener());
        this.view.setCofnijButtonListener(new CofnijButtonListener());
    }

    private class DodajMundialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.setLokalizacja(view.getNazwaMundialu());
                model.setRok(Integer.parseInt(view.getRokMundialu()));
                mundialDAO.addMundial(model);
                setDLM(); // odświeżenie listy mundiali w Jlist
                String info = null;
                info = "Dodawanie mundialu zakończone powodzeniem.";
                view.setInfoJLabel(info);
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

    public void setDLM() {
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


}
