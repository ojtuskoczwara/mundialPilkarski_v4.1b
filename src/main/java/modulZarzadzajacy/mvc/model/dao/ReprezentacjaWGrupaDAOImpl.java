package modulZarzadzajacy.mvc.model.dao;

import modulZarzadzajacy.mvc.model.entity.Mundial;
import modulZarzadzajacy.service.ConnectionDB;
import modulZarzadzajacy.mvc.model.entity.Grupa;
import modulZarzadzajacy.mvc.model.entity.Reprezentacja;
import modulZarzadzajacy.repository.utils.ParserSQL;

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

    @Override
    public void deleteReprezentacjaFromGrupa(int reprezentacjaId, int grupaId, int mundialId) throws Exception {
        String sql = "DELETE FROM t_reprezentacje_w_grupach WHERE id_reprezentacji = ? AND id_grupy = ? AND id_mundialu = ?";
        parserSQL.parseQuery(sql, reprezentacjaId, grupaId, mundialId).executeUpdate();
    }

    @Override
    public List<Reprezentacja> getReprezentacjeNazwaByGrupaIdMundialId(int grupaId, int mundialId) throws Exception {
        String sql = "SELECT nazwa_reprezentacji FROM t_reprezentacje INNER JOIN t_reprezentacje_w_grupach" +
                " USING(id_reprezentacji) WHERE id_grupy = ? AND id_mundialu = ?";
        List<Reprezentacja> reprezentacjaList = new ArrayList<Reprezentacja>();
        ResultSet resultSet = parserSQL.parseQuery(sql,grupaId, mundialId).executeQuery();
        while (resultSet.next()) {
            Reprezentacja reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa_reprezentacji"));
            reprezentacjaList.add(reprezentacja);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacjaList;
    }

    @Override
    public void addReprezentacjaToGrupa(int reprezentacjaId, int grupaId, int mundialId) throws Exception {
        String sql = "INSERT INTO t_reprezentacje_w_grupach VALUES(?, ?, ?)";
        parserSQL.parseQuery(sql, reprezentacjaId, grupaId, mundialId).executeUpdate();
    }
}
