package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja1;
import koczwara.mundialv1.MVC.Model.entity.Zawodnik;

public interface SkladReprezentacjaDAO {
    public void addSkladRep1(Rozgrywka rozgrywka, Zawodnik zawodnik, SkladReprezentacja1 skladReprezentacja1) throws Exception;
    public void addSkladRep2(Rozgrywka rozgrywka, Zawodnik zawodnik, SkladReprezentacja1 skladReprezentacja1) throws Exception;
}
