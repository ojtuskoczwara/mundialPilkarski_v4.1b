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
        String sql = "SELECT id_reprezentacji_1, id_reprezentacji_2 " +
                " FROM t_rozgrywki WHERE id_mundialu = ? AND id_grupy = ? AND id_typu_grupy = ?";
        List<Rozgrywka> rozgrywkaList = new ArrayList<Rozgrywka>();
        Rozgrywka rozgrywka = new Rozgrywka();
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getIdMundialu(), grupa.getIdGrupy(), grupa.getIdTypuGrupyFK()).executeQuery();
        while (resultSet.next()) {
            rozgrywka.setIdReprezentacji1(resultSet.getInt("id_reprezentacji_1"));
            rozgrywka.setIdReprezentacji2(resultSet.getInt("id_reprezentacji_2"));
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
}
