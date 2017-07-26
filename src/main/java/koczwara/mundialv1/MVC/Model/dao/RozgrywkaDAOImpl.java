package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RozgrywkaDAOImpl implements RozgrywkaDAO{
    private ParserSQL parserSQL = new ParserSQL();


    @Override // zamiast idRep mozna pobierac nazwyRep ale trzeba zmienic w t_rozgrywki trigger (zamiast generowac idRep ma generowac nazwyRep + rep1 i rep2 z int na charvar)
    public List<Rozgrywka> getFazaGrupowaByIdMundialuIdGrupyIdTypuGrupy(Mundial mundial, Grupa grupa) throws Exception {
        String sql = "SELECT * FROM t_rozgrywki WHERE id_mundialu = ?";
        List<Rozgrywka> rozgrywkaList = new ArrayList<Rozgrywka>();
        Rozgrywka rozgrywka = new Rozgrywka();
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getIdMundialu(), grupa.getIdGrupy(), grupa.getIdTypuGrupyFK()).executeQuery();
        while (resultSet.next()) {
            rozgrywka.setIdRozgrywki(resultSet.getInt("id_rozgrywki"));
            rozgrywka.setIdGrupy(resultSet.getInt("id_grupy"));
            rozgrywka.setIdGrupy1(resultSet.getInt("id_grupy_1"));
            rozgrywka.setIdReprezentacji1(resultSet.getInt("id_reprezentacji_1"));
            rozgrywka.setIdGrupy2(resultSet.getInt("id_grupy_2"));
            rozgrywka.setIdReprezentacji2(resultSet.getInt("id_reprezentacji_2"));
            rozgrywka.setIdMundialu(resultSet.getInt("id_mundialu"));
            rozgrywka.setIdTypuGrupy(resultSet.getInt("id_typu_grupy"));
            rozgrywkaList.add(rozgrywka);
        }
        ConnectionDB.disconnect(resultSet);
        return rozgrywkaList;
    }

    @Override
    public Rozgrywka getFazaJednaOsmaByIdMundialu(Mundial mundial) throws Exception {
        return null;
    }

    @Override
    public Rozgrywka getFazaJednaCzwartaByIdMundialu(Mundial mundial) throws Exception {
        return null;
    }

    @Override
    public Rozgrywka getFazaJednaDrugaByIdMundialu(Mundial mundial) throws Exception {
        return null;
    }

    @Override
    public Rozgrywka getFazaFinalByIdMundialu(Mundial mundial) throws Exception {
        return null;
    }

    @Override
    public List<Rozgrywka> getAllRozgrywkaByIdMundialu(int mundialId) throws Exception {
        String sql = "SELECT * FROM t_rozgrywki WHERE id_mundialu = ?";
        List<Rozgrywka> rozgrywkaList = new ArrayList<Rozgrywka>();

        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId).executeQuery();
        while (resultSet.next()) {
            Rozgrywka rozgrywka = new Rozgrywka();
            rozgrywka.setIdRozgrywki(resultSet.getInt("id_rozgrywki"));
            rozgrywka.setIdGrupy(resultSet.getInt("id_grupy"));
            rozgrywka.setIdGrupy1(resultSet.getInt("id_grupy_1"));
            rozgrywka.setIdReprezentacji1(resultSet.getInt("id_reprezentacji_1"));
            rozgrywka.setIdGrupy2(resultSet.getInt("id_grupy_2"));
            rozgrywka.setIdReprezentacji2(resultSet.getInt("id_reprezentacji_2"));
            rozgrywka.setIdMundialu(resultSet.getInt("id_mundialu"));
            rozgrywka.setIdTypuGrupy(resultSet.getInt("id_typu_grupy"));
            rozgrywkaList.add(rozgrywka);
        }
        ConnectionDB.disconnect(resultSet);
        return rozgrywkaList;
    }

    @Override
    public Rozgrywka getIdReprezentacji1ByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception {
        String sql = "SELECT id_reprezentacji_1 FROM t_rozgrywki WHERE id_mundialu = ? ORDER BY id_rozgrywki LIMIT 1 OFFSET ?";
        ResultSet result = parserSQL.parseQuery(sql, mundialId, meczIndex).executeQuery();
        Rozgrywka rozgrywka = new Rozgrywka();
        while (result.next()) {
            rozgrywka.setIdReprezentacji1(result.getInt("id_reprezentacji_1"));
        }
        ConnectionDB.disconnect(result);
        return rozgrywka;
    }

    @Override
    public Rozgrywka getIdReprezentacji2ByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception {
        String sql = "SELECT id_reprezentacji_2 FROM t_rozgrywki WHERE id_mundialu = ? ORDER BY id_rozgrywki LIMIT 1 OFFSET ?";
        ResultSet result = parserSQL.parseQuery(sql, mundialId, meczIndex).executeQuery();
        Rozgrywka rozgrywka = new Rozgrywka();
        while (result.next()) {
            rozgrywka.setIdReprezentacji2(result.getInt("id_reprezentacji_2"));
        }
        ConnectionDB.disconnect(result);
        return rozgrywka;
    }

    @Override
    public Rozgrywka getIdGrupyByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception {
        String sql = "SELECT id_grupy FROM t_rozgrywki WHERE id_mundialu = ? ORDER BY id_rozgrywki LIMIT 1 OFFSET ?";
        ResultSet result = parserSQL.parseQuery(sql, mundialId, meczIndex).executeQuery();
        Rozgrywka rozgrywka = new Rozgrywka();
        while (result.next()) {
            rozgrywka.setIdGrupy(result.getInt("id_grupy"));
        }
        ConnectionDB.disconnect(result);
        return rozgrywka;
    }
}
