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
        String sql = "INSERT INTO t_grupa(id_mundialu, nazwa_grupy, id_typu_grupy) VALUES(?,?,?)";
        parserSQL.parseQuery(sql, mundial.getIdMundialu(), grupa.getNazwaGrupy(), typGrupy.getIdTypuGrupy()).executeUpdate();
    }

    @Override
    public List<Grupa> getAllGrupa() throws Exception {
        String sql = "SELECT g.id_grupy, g.id_mundialu, sg.wartosc, g.id_typu_grupy FROM t_grupa g, slownik_grupy sg WHERE g.nazwa_grupy = sg.wartosc";
        List<Grupa> grupaList = new ArrayList<Grupa>();
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Grupa grupa = new Grupa();
            grupa.setIdGrupy(resultSet.getInt("id_grupy"));
            grupa.setIdMundialuPFK(resultSet.getInt("id_mundialu"));
            grupa.setNazwaGrupy(resultSet.getString("wartosc"));
            grupa.setIdTypuGrupyFK(resultSet.getInt("id_typu_grupy"));
            grupaList.add(grupa);
        }
        ConnectionDB.disconnect(resultSet);
        return grupaList;
    }

    @Override
    public Grupa getIdGrupyByIdMundialuNazwaGrupy(Mundial mundial, Grupa grupa) throws Exception {
        String sql = "SELECT g.id_grupy FROM t_grupa g, slownik_grupy sg WHERE g.id_mundialu = ? AND g.nazwa_grupy = sg.wartosc AND sg.klucz = ?";
        Grupa grupa1 = new Grupa();
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getIdMundialu(),)
        return null;
    }

    @Override
    public void updateGrupaByIdGrupy(Grupa grupa, Mundial mundial, TypGrupy typGrupy) throws Exception {

    }

    @Override
    public void deleteGrupaByIdGrupy(Grupa grupa) throws Exception {

    }
}
