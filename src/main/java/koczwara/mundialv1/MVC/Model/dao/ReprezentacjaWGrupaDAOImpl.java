package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReprezentacjaWGrupaDAOImpl implements ReprezentacjaWGrupaDAO{
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addReprezentacjeToGrupa(Reprezentacja reprezentacja, Grupa grupa, Mundial mundial) throws Exception {
        String sql = "INSERT INTO t_reprezentacje_w_grupach VALUES(?, ?, ?)";
        parserSQL.parseQuery(sql, reprezentacja.getIdReprezentacji(), grupa.getIdGrupy(), mundial.getIdMundialu()).executeUpdate();
    }

    @Override
    public List<Reprezentacja> getAllReprezentacjeInGrupaByIdMundialuIdGrupy(Mundial mundial, Grupa grupa) throws Exception {
        String sql = "SELECT rep.nazwa_reprezentacji FROM t_reprezentacje rep, t_reprezentacje_w_grupach rwg " +
                " WHERE rwg.id_mundialu = ? AND rwg.id_grupy = ? AND rep.id_reprezentacji = rwg.id_reprezentacji";
        List<Reprezentacja> reprezentacjaList = new ArrayList<Reprezentacja>();
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getIdMundialu(), grupa.getIdGrupy()).executeQuery();
        while (resultSet.next()) {
            Reprezentacja reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa_reprezentacji"));
            reprezentacjaList.add(reprezentacja);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacjaList;
    }
}
