package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReprezentacjaDAOImpl implements ReprezentacjaDAO {
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception {
        String sql = "INSERT INTO t_reprezentacje(nazwa_reprezentacji) VALUES(?)";
        parserSQL.parseQuery(sql,reprezentacja.getNazwa()).executeUpdate();
    }

    @Override
    public Reprezentacja getNazwaReprezentacjaByIdReprezentacja(int id) throws Exception {
        String sql = "SELECT nazwa_reprezentacji FROM t_reprezentacje WHERE id_reprezentacji = ?";
        Reprezentacja reprezentacja = null;
        ResultSet resultSet = parserSQL.parseQuery(sql, id).executeQuery();
        while (resultSet.next()) {
            reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa_reprezentacji"));
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacja;
    }

    @Override
    public List<Reprezentacja> getAllReprezentacja() throws Exception {
        List<Reprezentacja> reprezentacje = new ArrayList<Reprezentacja>();
        String sql = "SELECT * FROM t_reprezentacje";
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Reprezentacja reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa_reprezentacji"));
            reprezentacje.add(reprezentacja);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacje;
    }

    @Override
    public void deleteReprezentacja(int id) throws Exception {
        String sql = "DELETE FROM t_reprezentacje WHERE id_reprezentacji = ?";
        parserSQL.parseQuery(sql, id).executeUpdate();
    }

    @Override
    public void updateReprezentacjaById(Reprezentacja reprezentacja) throws Exception {
        String sql = "UPDATE t_reprezentacje SET nazwa_reprezentacji = ? WHERE id_reprezentacji = ?";
        parserSQL.parseQuery(sql,reprezentacja.getNazwa(), reprezentacja.getIdReprezentacji()).executeUpdate();
    }

    @Override
    public Reprezentacja getIdRepByNazwa(String nazwaRep) throws Exception {
        String sql = "SELECT * FROM t_reprezentacje WHERE nazwa_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, nazwaRep).executeQuery();
        Reprezentacja reprezentacja = null;
        while (resultSet.next()) {
            reprezentacja = new Reprezentacja();
            reprezentacja.setIdReprezentacji(resultSet.getInt("id_reprezentacji"));
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacja;
    }

    @Override
    public Reprezentacja getIdReprezentacjaByNazwaRep(Reprezentacja reprezentacja) throws Exception {
        String sql = "SELECT id_reprezentacji FROM t_reprezentacje WHERE nazwa_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, reprezentacja.getNazwa()).executeQuery();
        Reprezentacja rep = null;
        while (resultSet.next()) {
            rep = new Reprezentacja();
            rep.setIdReprezentacji(resultSet.getInt("id_reprezentacji"));
        }
        ConnectionDB.disconnect(resultSet);
        return rep;
    }

    @Override
    public int getReprezentacjaIdByReprezentacjaNazwa(String reprezentacjaNazwa) throws Exception {
        String sql = "SELECT id_reprezentacji FROM t_reprezentacje WHERE nazwa_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, reprezentacjaNazwa).executeQuery();
        int reprezentacjaId = 0;
        resultSet.next();
        reprezentacjaId = resultSet.getInt("id_reprezentacji");
        ConnectionDB.disconnect(resultSet);
        return reprezentacjaId;
    }

    @Override
    public List<Reprezentacja> getAllReprezentacjaInMundial(int mundialId) throws Exception {
        String sql = "SELECT nazwa_reprezentacji FROM v_reprezentacje_view1 WHERE id_mundialu= ?";
        List<Reprezentacja> reprezentacjaList = new ArrayList<Reprezentacja>();
        ResultSet resultSet = parserSQL.parseQuery(sql,mundialId).executeQuery();
        while (resultSet.next()){
            Reprezentacja reprezentacja = new Reprezentacja();
            reprezentacja.setNazwa(resultSet.getString("nazwa_reprezentacji"));
            reprezentacjaList.add(reprezentacja);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacjaList;
    }

    @Override
    public int getReprezentacjaId(String reprezentacjaNazwa) throws Exception {
        String sql = "SELECT DISTINCT id_reprezentacji FROM v_reprezentacje_view1 WHERE nazwa_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, reprezentacjaNazwa).executeQuery();
        int id = 0;
        while (resultSet.next()) {
            id= resultSet.getInt("id_reprezentacji");
        }
        ConnectionDB.disconnect(resultSet);
        return id;
    }
}
