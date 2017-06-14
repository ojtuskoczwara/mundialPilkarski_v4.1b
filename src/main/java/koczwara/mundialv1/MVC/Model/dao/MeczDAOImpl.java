package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Mecz;
import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;



public class MeczDAOImpl implements MeczDAO{
    private ParserSQL parserSQL = new ParserSQL();


    @Override
    public void addMecz(Rozgrywka rozgrywka, Mecz mecz) throws Exception {
        String sql = "INSERT INTO t_mecz(id_meczu, data_meczu, id_reprezentacji_1, id_reprezentacji_2, id_grupy, id_mundialu, gole_r1, gole_r2)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?";
        parserSQL.parseQuery(sql, rozgrywka.getIdRozgrywki(), mecz.getDataMeczu(), rozgrywka.getIdReprezentacji1(), rozgrywka.getIdReprezentacji2(),
                rozgrywka.getIdGrupy(), rozgrywka.getIdMundialu(), mecz.getGoleRep1(), mecz.getGoleRep2()).executeUpdate();
    }
}
