package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Mecz;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;

import java.sql.Date;


public interface MeczDAO {
    public void addMecz1(Rozgrywka rozgrywka, Mecz mecz) throws Exception;
    public void addMecz(int meczId, Date dataMeczu, int rep1Id, int rep2Id, int grupaId, int mundialId, int goleRep1, int goleRep2) throws Exception;

}
