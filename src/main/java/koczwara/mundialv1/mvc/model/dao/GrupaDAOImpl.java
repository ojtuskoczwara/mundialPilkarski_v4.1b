package koczwara.mundialv1.mvc.model.dao;

import koczwara.mundialv1.service.ConnectionDB;
import koczwara.mundialv1.mvc.model.entity.Grupa;
import koczwara.mundialv1.mvc.model.entity.Mundial;
import koczwara.mundialv1.mvc.model.entity.TypGrupy;
import koczwara.mundialv1.repository.utils.ParserSQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrupaDAOImpl implements GrupaDAO{

    private ParserSQL parserSQL = new ParserSQL();


    @Override
    public void addGrupa(Grupa grupa, Mundial mundial, TypGrupy typGrupy) throws Exception {
        String sql = "INSERT INTO t_grupy(id_mundialu, nazwa_grupy, id_typu_grupy) VALUES(?,?,?)";
        parserSQL.parseQuery(sql, mundial.getIdMundialu(), grupa.getNazwaGrupy(), typGrupy.getIdTypuGrupy()).executeUpdate();
    }

    @Override
    public List<Grupa> getAllGrupa() throws Exception {
        String sql = "SELECT * FROM t_grupy";
        List<Grupa> grupaList = new ArrayList<Grupa>();
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Grupa grupa = new Grupa();
            grupa.setIdGrupy(resultSet.getInt("id_grupy"));
            grupa.setIdMundialuPFK(resultSet.getInt("id_mundialu"));
            grupa.setNazwaGrupy(resultSet.getString("nazwa_grupy"));
            grupa.setIdTypuGrupyFK(resultSet.getInt("id_typu_grupy"));
            grupaList.add(grupa);
        }
        ConnectionDB.disconnect(resultSet);
        return grupaList;
    }

    @Override
    public Grupa getIdGrupyByIdMundialuNazwaGrupy(Mundial mundial, Grupa grupa) throws Exception {
        String sql = "SELECT * FROM t_grupy WHERE id_mundialu = ? AND nazwa_grupy = ?";
        Grupa grupa1 = new Grupa();
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getIdMundialu(), grupa.getNazwaGrupy()).executeQuery();
        while (resultSet.next()) {
            grupa1.setIdGrupy(resultSet.getInt("id_grupy"));
        }
        ConnectionDB.disconnect(resultSet);
        return grupa1;
    }

    @Override
    public void updateGrupaByIdGrupy(Grupa grupa, Mundial mundial, TypGrupy typGrupy) throws Exception {
        String sql = "UPDATE t_grupy SET id_mundialu = ?, nazwa_grupy = ?, id_typu_grupy = ? WHERE id_grupy = ?";
        parserSQL.parseQuery(sql, grupa.getIdMundialuPFK(), grupa.getNazwaGrupy(), grupa.getIdTypuGrupyFK(), grupa.getIdGrupy()).executeUpdate();
    }

    @Override
    public void deleteGrupaByIdGrupy(Grupa grupa) throws Exception {
        String sql = "DELETE FROM t_grupy WHERE id_grupy = ?";
        parserSQL.parseQuery(sql, grupa.getIdGrupy()).executeUpdate();
    }

    @Override
    public Grupa getNazwaByIdGrupyIdMundialu(int grupaId, int mundialId) throws Exception {
        String sql = "SELECT nazwa_grupy FROM t_grupy WHERE id_grupy = ? AND id_mundialu = ?";
        ResultSet result = parserSQL.parseQuery(sql, grupaId, mundialId).executeQuery();
        Grupa grupa = new Grupa();
        while (result.next()) {
            grupa.setNazwaGrupy(result.getString("nazwa_grupy"));
        }
        ConnectionDB.disconnect(result);
        return grupa;
    }

    @Override
    public int getGrupaIdByMundialIdGrupaNazwa(int mundialId, String grupaNazwa) throws Exception {
        String sql = "SELECT id_grupy FROM t_grupy WHERE id_mundialu = ? AND nazwa_grupy = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId, grupaNazwa).executeQuery();
        resultSet.next();
        int grupaId = resultSet.getInt("id_grupy");
        ConnectionDB.disconnect(resultSet);
        return grupaId;
    }

    @Override
    public int getIdTypuGrByGrupaId(int grupaId) throws Exception {
        String sql = "SELECT id_typu_grupy FROM t_grupy WHERE id_grupy= ?";
        int idTypuGrupy = 0;
        ResultSet resultSet = parserSQL.parseQuery(sql,grupaId).executeQuery();
        while (resultSet.next()) {
            idTypuGrupy = resultSet.getInt("id_typu_grupy");
        }
        ConnectionDB.disconnect(resultSet);
        return idTypuGrupy;
    }


}
