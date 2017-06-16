package koczwara.mundialv1.MVC.Controller;

import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.View.EkranGlowny.PanelAdministratora.ViewGrupaDodaj;

import javax.swing.*;

public class ControllerGrupaDodaj {
    private ViewGrupaDodaj view;
    private Mundial modelMundial;
    private Reprezentacja modelReprezentacja;
    private Grupa modelGrupa;
    DefaultListModel dlm = new DefaultListModel();


    public ControllerGrupaDodaj(ViewGrupaDodaj view, Mundial modelMundial, Reprezentacja modelReprezentacja, Grupa modelGrupa) {
        this.view = view;
        this.modelMundial = modelMundial;
        this.modelReprezentacja = modelReprezentacja;
        this.modelGrupa = modelGrupa;
    }
}
