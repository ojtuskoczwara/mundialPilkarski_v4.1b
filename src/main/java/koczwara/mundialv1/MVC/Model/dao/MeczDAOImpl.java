package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Mecz;
import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

import java.sql.Date;
import java.sql.ResultSet;


public class MeczDAOImpl implements MeczDAO{
    private ParserSQL parserSQL = new ParserSQL();


    @Override
    public void addMecz1(Rozgrywka rozgrywka, Mecz mecz) throws Exception {
        String sql = "INSERT INTO t_mecz(id_meczu, data_meczu, id_reprezentacji_1, id_reprezentacji_2, id_grupy, id_mundialu, gole_r1, gole_r2)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?";
        parserSQL.parseQuery(sql, rozgrywka.getIdRozgrywki(), mecz.getDataMeczu(), rozgrywka.getIdReprezentacji1(), rozgrywka.getIdReprezentacji2(),
                rozgrywka.getIdGrupy(), rozgrywka.getIdMundialu(), mecz.getGoleRep1(), mecz.getGoleRep2()).executeUpdate();
    }

    @Override
    public void addMecz(int meczId, Date dataMeczu, int rep1Id, int rep2Id, int grupaId, int mundialId, int goleRep1, int goleRep2) throws Exception {
        String sql = "INSERT INTO t_mecz VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        parserSQL.parseQuery(sql, meczId, dataMeczu, rep1Id, rep2Id, grupaId, mundialId, goleRep1, goleRep2).executeUpdate();
    }

    @Override
    public Mecz getDataGoleR1GoleR2ByIdMeczu(int meczId) throws Exception {
        String sql = "SELECT data_meczu, gole_r1, gole_r2 FROM t_mecz WHERE id_meczu = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, meczId).executeQuery();
        Mecz mecz = null;
        while (resultSet.next()) {
            mecz = new Mecz();
            mecz.setDataMeczu(resultSet.getDate("data_meczu"));
            mecz.setGoleRep1(resultSet.getInt("gole_r1"));
            mecz.setGoleRep2(resultSet.getInt("gole_r2"));
        }
        ConnectionDB.disconnect(resultSet);
        return mecz;
    }
}
