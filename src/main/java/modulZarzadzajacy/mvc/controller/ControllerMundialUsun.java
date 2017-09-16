package modulZarzadzajacy.mvc.controller;


import modulZarzadzajacy.mvc.model.dao.ZawodnikWReprezentacjaDAO;
import modulZarzadzajacy.mvc.model.dao.ZawodnikWReprezentacjaDAOImpl;
import modulZarzadzajacy.mvc.model.entity.Mundial;
import modulZarzadzajacy.mvc.view.ViewMundialUsun;
import modulZarzadzajacy.mvc.view.ViewPanelAdministratora;
import modulZarzadzajacy.mvc.model.dao.MundialDAO;
import modulZarzadzajacy.mvc.model.dao.MundialDAOImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControllerMundialUsun {
    private ViewMundialUsun view;
    private Mundial model;
    private DefaultListModel dlm = new DefaultListModel();
    private MundialDAO mundialDAO = new MundialDAOImpl();
    private ZawodnikWReprezentacjaDAO zawodnikWReprezentacjaDAO = new ZawodnikWReprezentacjaDAOImpl();
    private String valueMundial;
    private String valueMundialLokalizacja;
    private int valueMundialRok;

    public ControllerMundialUsun(ViewMundialUsun view, Mundial model) {
        this.view = view;
        this.model = model;

        setDLM();
        this.view.setCofnijButtonListener(new CofnijButtonListener());
        this.view.setUsunButtonListener(new UsunMundialButtonListener());
        this.view.setMundialeListMouseListener(new MundialeListMouseListener());
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
            this.view.setListMundialeModel(dlm); // Wywołanie metody, która ustawia modelMundiale w widoku
        } catch (Exception e) {
            e.printStackTrace();
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

    private class UsunMundialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int wynik = 0;
            try {
                model = mundialDAO.getIdMundialuByLokalizacjaRok(model); // setIdMundialu
                zawodnikWReprezentacjaDAO.deleteRowsByIdMundialu(model); // Usuniecie wierszy z t_zwr gdzie idMundialu = wartowsci getIdMundialu (powyzej)
                wynik = mundialDAO.deleteMundialByIdMundialu(model.getIdMundialu()); //Usuniecie mundialu z t_mundial
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if (wynik > 0) {
                view.setInfoLabelText("Usunięcie mundialu zakończone powodzeniem!");
                view.setLokalizacjaTF("");
                view.setRokTF(null);
            }
            else
                view.setInfoLabelText("Operacja usunięcia mundialu nie powiodła się.");
            setDLM();
        }
    }

    private class MundialeListMouseListener extends MouseAdapter { // element z JList jest pobierany i uzyty w DAOMundial
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialListSelectedValue().isSelectionEmpty()){ //jezeli element z listy JList jest wybrany/zaznaczony
                valueMundial = view.getMundialListSelectedValue().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0,valueMundial.length()-5); // toString do MundialLokalizacja
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length()-4)); // parseInt do MundialRok
                model.setLokalizacja(valueMundial.substring(0,valueMundial.length()-5)); //od razu setterem przypisac wartosc zamiast tworzyc String valueMundialLokalizacja itp
                model.setRok(Integer.parseInt(valueMundial.substring(valueMundial.length()-4)));
                view.setLokalizacjaTF(valueMundialLokalizacja);
                view.setRokTF(String.valueOf(valueMundialRok));
            }
        }
    }
}
