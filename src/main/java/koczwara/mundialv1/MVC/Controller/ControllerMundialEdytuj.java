package koczwara.mundialv1.MVC.Controller;


import koczwara.mundialv1.MVC.Model.dao.MundialDAO;
import koczwara.mundialv1.MVC.Model.dao.MundialDAOImpl;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewMundialEdytuj;
import koczwara.mundialv1.MVC.View.EkranGlowny.ViewPanelAdministratora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerMundialEdytuj {
    private ViewMundialEdytuj view;
    private Mundial model;
    private DefaultListModel dlm = new DefaultListModel();
    MundialDAO mundialDAO = new MundialDAOImpl();
    private String valueMundialLokalizacja;
    private int valueMundialRok;

    public ControllerMundialEdytuj(ViewMundialEdytuj view, Mundial model) {
        this.view = view;
        this.model = model;

        setDLM();
        this.view.setCofnijButtonListener(new CofnijButton());
        this.view.setMundialListMouseListener(new MundialListMouse());
        this.view.setEdytujButtonListener(new EdytujMundialButton());
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
            this.view.setMundialListModel(dlm); // Wywołanie metody, która ustawia modelMundiale w widoku
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class CofnijButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerPanelAdministratora(new ViewPanelAdministratora());
            view.setVisible(false);
            view.dispose();
        }
    }


    private class MundialListMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (!view.getMundialList().isSelectionEmpty()) {
                String valueMundial = view.getMundialList().getSelectedValue().toString();
                valueMundialLokalizacja = valueMundial.substring(0, valueMundial.length()-5);
                valueMundialRok = Integer.parseInt(valueMundial.substring(valueMundial.length()-4));
            }
        }
    }
 // zamiast mouselistener można to zrobić bez użycia kliknięcia myszką
    // przy kliknięciu bEdytuj pobieramy z listy zaznaczony element i zapisujemy go w valLokal i valRok ... tak jak wyżej w MundialListMouse
    private class EdytujMundialButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            int update = 0;

            try {
                model = mundialDAO.getIdMundialByLokalizacjaRok(valueMundialLokalizacja, valueMundialRok);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            id = model.getIdMundialu();


            if (view.getNowaLokalizacjaTextField().isEmpty() & view.getNowyRokTextField().isEmpty()) {
                view.showMyWarningMessage("Pola 'Lokalizacja' lub 'Rok' muszą zostać wypełnione!", "Wypełnij wymagane pola !");
            }
            else if (view.getNowaLokalizacjaTextField().isEmpty() || view.getNowyRokTextField().isEmpty()) {
                if (view.getNowaLokalizacjaTextField().isEmpty()) {
                    try {
                        update = mundialDAO.updateMundial(id,valueMundialLokalizacja, Integer.parseInt(view.getNowyRokTextField()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (view.getNowyRokTextField().isEmpty()) {
                    try {
                        update = mundialDAO.updateMundial(id,view.getNowaLokalizacjaTextField(), valueMundialRok);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else
                try {
                    update = mundialDAO.updateMundial(id,view.getNowaLokalizacjaTextField(), Integer.parseInt(view.getNowyRokTextField()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            if (update > 0) {
                view.showMyInfoMessage("Mundial został edytowany pomyślnie.", "Success");
                setDLM();
                view.setCzyszczenieNowaLokalizajcaTextField(null);
                view.setCzyszczenieNowyRokTextField(null);
            }
            else
                view.showMyErrorMessage("Błąd podczas edytowania mundialu!", "Error");


/*
            try {
                update = mundialDAO.updateMundial(id,view.getNowaLokalizacjaTextField(), Integer.parseInt(view.getNowyRokTextField()));
            } catch (SQLException e1) {
                e1.printStackTrace();
                try {
                    update = mundialDAO.updateMundial(id,valueMundialLokalizacja, Integer.parseInt(view.getNowyRokTextField()));
                } catch (SQLException e2) {
                    e2.printStackTrace();
                    try {
                        update = mundialDAO.updateMundial(id,view.getNowaLokalizacjaTextField(), valueMundialRok);
                    } catch (SQLException e3) {
                        e3.printStackTrace();
                        view.showMyWarningMessage("Pola 'Lokalizacja' lub 'Rok' muszą zostać wypełnione!", "Wypełnij wymagane pola !");
                    }
                }
            }
*/

/*
            try {
                boolean czyPrawda = !view.getNowaLokalizacjaTextField().isEmpty() & !view.getNowyRokTextField().isEmpty();
                if (Boolean.TRUE.equals(czyPrawda))
                    update = mundialDAO.updateMundial(id,view.getNowaLokalizacjaTextField(), Integer.parseInt(view.getNowyRokTextField()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            if (update > 0) {
                view.showMyInfoMessage("Mundial został edytowany pomyślnie.", "Success");
                setDLM();
                view.setCzyszczenieNowaLokalizajcaTextField(null);
                view.setCzyszczenieNowyRokTextField(null);
            }

*/


        }
     }
}

