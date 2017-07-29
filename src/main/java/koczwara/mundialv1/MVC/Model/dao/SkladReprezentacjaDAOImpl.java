package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;
import koczwara.mundialv1.MVC.Model.entity.SkladReprezentacja1;
import koczwara.mundialv1.MVC.Model.entity.Zawodnik;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

public class SkladReprezentacjaDAOImpl implements SkladReprezentacjaDAO{
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addSkladRep1(Rozgrywka rozgrywka, Zawodnik zawodnik, SkladReprezentacja1 skladReprezentacja1) throws Exception {
        String sql = "INSERT INTO t_sklady_rep_1 VALUES(?, ?, ?, ?, ?, ?, ?)";
        parserSQL.parseQuery(sql, rozgrywka.getIdReprezentacji1(), rozgrywka.getIdReprezentacji2(), rozgrywka.getIdGrupy(), rozgrywka.getIdMundialu(),
                zawodnik.getIdZawodnika(), rozgrywka.getIdRozgrywki(), skladReprezentacja1.getPozycja()).executeUpdate();
    }
    @Override
    public void addSkladRep2(Rozgrywka rozgrywka, Zawodnik zawodnik, SkladReprezentacja1 skladReprezentacja1) throws Exception {
    }

    @Override
    public void addSkladReprezentacja1(int rep1Id, int rep2Id, int grupaId, int mundialId, int zawodnikId, int meczId) throws Exception {
        String sql = "INSERT INTO t_sklady_rep_1 VALUES(?, ?, ?, ?, ?, ?)";
        parserSQL.parseQuery(sql,rep1Id, rep2Id, grupaId, mundialId, zawodnikId, meczId).executeUpdate();
    }

    @Override
    public void addSkladReprezentacja2(int rep1Id, int rep2Id, int grupaId, int mundialId, int zawodnikId, int meczId) throws Exception {
        String sql = "INSERT INTO t_sklady_rep_2 VALUES(?, ?, ?, ?, ?, ?)";
        parserSQL.parseQuery(sql,rep1Id, rep2Id, grupaId, mundialId, zawodnikId, meczId).executeUpdate();
    }
}
