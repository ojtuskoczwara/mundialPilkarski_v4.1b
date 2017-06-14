package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja1;
import koczwara.mundialv1.MVC.Model.entity.Zawodnik;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

public class SkladReprezentacja2DAOImpl implements SkladReprezentacjaDAO{
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addSkladRep1(Rozgrywka rozgrywka, Zawodnik zawodnik, SkladReprezentacja1 skladReprezentacja1) throws Exception {
    }

    @Override
    public void addSkladRep2(Rozgrywka rozgrywka, Zawodnik zawodnik, SkladReprezentacja1 skladReprezentacja1) throws Exception {
        String sql = "INSERT INTO t_sklady_rep_1 VALUES(?, ?, ?, ?, ?, ?, ?)";
        parserSQL.parseQuery(sql, rozgrywka.getIdReprezentacji1(), rozgrywka.getIdReprezentacji2(), rozgrywka.getIdGrupy(), rozgrywka.getIdMundialu(),
                zawodnik.getIdZawodnika(), rozgrywka.getIdRozgrywki(), skladReprezentacja1.getPozycja()).executeUpdate();
    }
}
