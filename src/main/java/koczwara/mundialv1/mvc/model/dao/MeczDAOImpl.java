package koczwara.mundialv1.mvc.model.dao;

import koczwara.mundialv1.service.ConnectionDB;
import koczwara.mundialv1.mvc.model.entity.Mecz;
import koczwara.mundialv1.mvc.model.entity.Rozgrywka;
import koczwara.mundialv1.repository.utils.ParserSQL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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

    @Override
    public List<Mecz> getAllByMundialId(int mundialId) throws Exception {
        List<Mecz> meczList = new ArrayList<Mecz>();
        String sql = "SELECT * FROM t_mecz WHERE id_mundialu= ? ORDER BY id_mundialu,id_grupy,id_meczu";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId).executeQuery();
        while (resultSet.next()) {
            Mecz mecz = new Mecz();
            mecz.setIdMeczu(resultSet.getInt("id_meczu"));
            mecz.setDataMeczu(resultSet.getDate("data_meczu"));
            mecz.setIdReprezentacji1(resultSet.getInt("id_reprezentacji_1"));
            mecz.setIdReprezentacji2(resultSet.getInt("id_reprezentacji_2"));
            mecz.setIdGrupy(resultSet.getInt("id_grupy"));
            mecz.setIdMundialu(resultSet.getInt("id_mundialu"));
            mecz.setGoleRep1(resultSet.getInt("gole_r1"));
            mecz.setGoleRep2(resultSet.getInt("gole_r2"));
            meczList.add(mecz);
        }
        ConnectionDB.disconnect(resultSet);
        return meczList;
    }

}
