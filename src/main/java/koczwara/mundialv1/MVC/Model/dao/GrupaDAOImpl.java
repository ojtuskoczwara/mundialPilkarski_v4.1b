package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.TypGrupy;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

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
}
