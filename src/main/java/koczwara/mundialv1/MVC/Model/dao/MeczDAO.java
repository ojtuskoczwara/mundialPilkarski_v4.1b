package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Mecz;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;


public interface MeczDAO {
    public void addMecz(Rozgrywka rozgrywka, Mecz mecz) throws Exception;

}
