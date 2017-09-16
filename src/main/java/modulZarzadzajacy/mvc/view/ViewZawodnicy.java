package modulZarzadzajacy.mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ViewZawodnicy extends JFrame{
    private Checkbox checkboxAllZawodniks, checkboxSpecificMundial, checkboxAllReps, checkboxSpecificRep;
    private CheckboxGroup checkboxGroupMundialAllOrOne, checkboxGroupRepAllOrOne;
    private JList listMundial, listReprezentacja, listZawodnik;
    private JScrollPane scrollPaneMundial,scrollPaneReprezentacja;
    private JButton buttonCofnij;
    private JLabel labelMundial, labelReprezentacja;

    public ViewZawodnicy() {
        super("Zawodnicy");
        setSize(600, 630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        int cbX = 10;
        int cbY = 10;
        int cbSzer = 200;
        int cbWys = 30;
        int cb2X = 30;
        int lX = cb2X+cbSzer+10;
        int lY = cbY+cbWys*2-40;
        int lSzer = 160;
        int lWys = 160;
        int jcbX = cbX;
        int jcbY = lY+lWys+10;
        int jcbSzer = 150;
        int jcbWys = 30;


            checkboxGroupMundialAllOrOne = new CheckboxGroup();
            checkboxAllZawodniks = new Checkbox("Wszyscy zawodnicy", checkboxGroupMundialAllOrOne, false);
        checkboxAllZawodniks.setBounds(cbX,cbY,cbSzer,cbWys);
        add(checkboxAllZawodniks);
            checkboxSpecificMundial = new Checkbox("Zawodnicy w mundialu", checkboxGroupMundialAllOrOne, false);
        checkboxSpecificMundial.setBounds(cbX,cbY+cbWys,cbSzer,cbWys);
        add(checkboxSpecificMundial);

            checkboxGroupRepAllOrOne = new CheckboxGroup();
            checkboxAllReps = new Checkbox("Wszyscy zawodnicy w mundialu", checkboxGroupRepAllOrOne, false);
        checkboxAllReps.setBounds(cb2X,cbY+cbWys*2,cbSzer,cbWys);
        add(checkboxAllReps);
        checkboxAllReps.setVisible(false);
            checkboxSpecificRep = new Checkbox("Zawodnicy w reprezentacji", checkboxGroupRepAllOrOne, false);
        checkboxSpecificRep.setBounds(cb2X,cbY+cbWys*3,cbSzer,cbWys);
        add(checkboxSpecificRep);
        checkboxSpecificRep.setVisible(false);

            labelMundial = new JLabel("MUNDIALE");
        labelMundial.setBounds(lX+50,lY-25,120,30);
        add(labelMundial);
        labelMundial.setVisible(false);
            listMundial = new JList();
            scrollPaneMundial = new JScrollPane(listMundial);
        scrollPaneMundial.setBounds(lX,lY,lSzer,lWys);
        add(scrollPaneMundial);
        scrollPaneMundial.setVisible(false);

            labelReprezentacja = new JLabel("REPREZENTACJE");
        labelReprezentacja.setBounds(lX+lSzer+40,lY-25,120,30);
        add(labelReprezentacja);
        labelReprezentacja.setVisible(false);
            listReprezentacja = new JList();
        scrollPaneReprezentacja = new JScrollPane(listReprezentacja);
        scrollPaneReprezentacja.setBounds(lX+lSzer+5,lY,lSzer,lWys);
        add(scrollPaneReprezentacja);
        scrollPaneReprezentacja.setVisible(false);

            JLabel labelZawodnik = new JLabel("LISTA ZAWODNIKÓW");
        labelZawodnik.setBounds(jcbX+190,jcbY+jcbWys-30,120,30);
        add(labelZawodnik);
            listZawodnik = new JList();
            JScrollPane scrollPaneZawodnik = new JScrollPane(listZawodnik);
        scrollPaneZawodnik.setBounds(jcbX+120,jcbY+jcbWys,lSzer+100,lSzer*2-10);
        scrollPaneZawodnik.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scrollPaneZawodnik);

            buttonCofnij = new JButton("<< Cofnij <<");
        buttonCofnij.setBounds(10,550,100,30);
        add(buttonCofnij);
    }

    public void addCofnijButtonListener(ActionListener listenCofnijButton) {buttonCofnij.addActionListener(listenCofnijButton); }

    public void setCheckboxAllZawodniksListener(MouseAdapter listenClickOnCheckboxAllZawodniks) {
        checkboxAllZawodniks.addMouseListener(listenClickOnCheckboxAllZawodniks); }

    public void setCheckboxSpecificMundialListener(MouseAdapter listenClickOnCheckboxSpecificMundial){
        checkboxSpecificMundial.addMouseListener(listenClickOnCheckboxSpecificMundial);}

    public void setCheckboxAllRepsListener(MouseAdapter listenClickOnCheckboxAllReps) {
        checkboxAllReps.addMouseListener(listenClickOnCheckboxAllReps);}

    public void setCheckboxSpecificRepListener(MouseAdapter listenClickOnCheckboxSpecificRep) {
        checkboxSpecificRep.addMouseListener(listenClickOnCheckboxSpecificRep);}

    public void setListMundialMouseListener(MouseAdapter listenClickOnElementListMundial){
        listMundial.addMouseListener(listenClickOnElementListMundial);}

    public void setListReprezentacjaMouseListener(MouseAdapter listenClickOnElementListReprezentacja) {
        listReprezentacja.addMouseListener(listenClickOnElementListReprezentacja);}

    public void setVisibleCheckboxGroupRepAllOrOne(boolean trueFalse) {
        checkboxAllReps.setVisible(trueFalse);
        checkboxSpecificRep.setVisible(trueFalse); }

    public void setVisibleScrollPaneMundialReprezentacja(boolean trueFalse) {
        scrollPaneMundial.setVisible(trueFalse);
        scrollPaneReprezentacja.setVisible(trueFalse);
        labelMundial.setVisible(trueFalse);
        labelReprezentacja.setVisible(trueFalse);}

    public void setListMundialModel(DefaultListModel dlm){
        listMundial.setModel(dlm); }

    public void setListReprezentacjaModel(DefaultListModel dlm) {
        listReprezentacja.setModel(dlm);}

    public void setListZawodnikModel(DefaultListModel dlm) {
        listZawodnik.setModel(dlm);}

    public JList getListMundial() { return listMundial; }

    public JList getListReprezentacja() { return listReprezentacja; }

    public Checkbox getCheckboxAllReps() { return checkboxAllReps; }

    public Checkbox getCheckboxSpecificRep() { return checkboxSpecificRep; }


}
