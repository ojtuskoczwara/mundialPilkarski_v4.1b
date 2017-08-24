package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Controller.DatabaseConnection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.entity.Zawodnik;
import koczwara.mundialv1.MVC.Tools.utils.ParserSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikWReprezentacjaDAOImpl implements ZawodnikWReprezentacjaDAO {
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public List<Zawodnik> getAllZawodnicyAtMundialInRep(String mundialValueFromJList, String repValueFromJList) throws Exception {
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        String sql = "SELECT z.imie, z.nazwisko FROM t_zawodnicy z, t_mundiale m, t_reprezentacje r, t_zawodnicy_w_reprezentacji zwr" +
                " WHERE r.id_reprezentacji = zwr.id_reprezentacji AND m.id_mundialu = zwr.id_mundialu AND z.id_zawodnika = zwr.id_zawodnika" +
                " AND m.lokalizacja = ? AND r.nazwa_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialValueFromJList, repValueFromJList).executeQuery();
        while (resultSet.next()) {
            Zawodnik z = new Zawodnik();
            z.setImie(resultSet.getString("imie"));
            z.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(z);
        }
        return zawodnikList;
    }

    @Override
    public void addZawodnikRepMundial(int idZawodnika, int idReprezentacji, int idMundialu) throws Exception {
        String sql = "INSERT INTO t_zawodnicy_w_reprezentacji VALUES(?,?,?)";
        parserSQL.parseQuery(sql,idZawodnika, idReprezentacji, idMundialu).executeUpdate();
    }

    @Override
    public List<Reprezentacja> getAllReprezentacjeAtMundial(String mundialName, int mundialRok) throws Exception {
        List<Reprezentacja> reprezentacjaList = new ArrayList<Reprezentacja>();
        String sql = "SELECT distinct r.nazwa_reprezentacji FROM t_reprezentacje r, t_mundiale m, t_zawodnicy_w_reprezentacji zwr" +
                " WHERE m.id_mundialu = zwr.id_mundialu AND r.id_reprezentacji = zwr.id_reprezentacji AND m.lokalizacja = ? AND m.rok = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialName, mundialRok).executeQuery();
        while (resultSet.next()) {
            Reprezentacja r = new Reprezentacja();
            r.setNazwa(resultSet.getString("nazwa_reprezentacji"));
            reprezentacjaList.add(r);
        }
        ConnectionDB.disconnect(resultSet);
        return reprezentacjaList;
    }

    @Override
    public int getIdZawodnikByLokalizacjaNazwaImieNazwisko(String lokalizacja, String nazwa, Zawodnik zawodnik) throws Exception {
        String sql = "SELECT z.id_zawodnika FROM t_zawodnicy z, t_reprezentacje r, t_mundiale m, t_zawodnicy_w_reprezentacji zwr" +
                " WHERE m.id_mundialu = zwr.id_mundialu AND r.id_reprezentacji = zwr.id_reprezentacji AND z.id_zawodnika = zwr.id_zawodnika" +
                " AND m.lokalizacja = ? AND r.nazwa_reprezentacji = ? AND z.imie = ? AND z.nazwisko = ?";
        PreparedStatement ps = parserSQL.parseQuery(sql, lokalizacja, nazwa, zawodnik.getImie(), zawodnik.getNazwisko());
        ResultSet resultSet = ps.executeQuery();
        int idZawodnika = resultSet.getInt("id_zawodnika");
        ConnectionDB.disconnect(resultSet);
        return idZawodnika;
    }

    @Override
    public Zawodnik getZawodnikIdByLokalizacjaRokNazwaImieNazwisko(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception {
        String sql = "SELECT z.id_zawodnika, z.imie, z.nazwisko FROM t_zawodnicy z, t_reprezentacje r, t_mundiale m, t_zawodnicy_w_reprezentacji zwr" +
                " WHERE m.id_mundialu = zwr.id_mundialu AND r.id_reprezentacji = zwr.id_reprezentacji AND z.id_zawodnika = zwr.id_zawodnika" +
                " AND m.lokalizacja = ? AND m.rok = ? AND r.nazwa_reprezentacji = ? AND z.imie = ? AND z.nazwisko = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundial.getLokalizacja(), mundial.getRok(), reprezentacja.getNazwa(), zawodnik.getImie(), zawodnik.getNazwisko()).executeQuery();
        Zawodnik z = new Zawodnik();
        while (resultSet.next()){
            z.setIdZawodnika(resultSet.getInt("id_zawodnika"));
            z.setImie(resultSet.getString("imie"));
            z.setNazwisko(resultSet.getString("nazwisko"));
        }
        ConnectionDB.disconnect(resultSet);
        return z;
    }

    @Override
    public void deleteRowsByMundialIdReprezentacjaIdZawodnikId(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception {
        String sql = "DELETE FROM t_zawodnicy_w_reprezentacji WHERE id_mundialu = ? AND id_reprezentacji = ? AND id_zawodnika = ?";
        parserSQL.parseQuery(sql, mundial.getIdMundialu(), reprezentacja.getIdReprezentacji(), zawodnik.getIdZawodnika()).executeUpdate();
    }

    @Override
    public void deleteRowsByIdMundialu(Mundial mundial) throws Exception {
        String sql = "DELETE FROM t_zawodnicy_w_reprezentacji WHERE id_mundialu = ?";
        parserSQL.parseQuery(sql, mundial.getIdMundialu()).executeUpdate();
    }

    @Override
    public void deleteRowsByIdReprezentacji(Reprezentacja reprezentacja) throws Exception {
        String sql = "DELETE FROM t_zawodnicy_w_reprezentacji WHERE id_reprezentacji = ?";
        parserSQL.parseQuery(sql, reprezentacja.getIdReprezentacji()).executeUpdate();
    }

    @Override
    public List<Zawodnik> getImieNazwiskoZawodnikaByIdMundialuIdReprezentacji(int mundialId, int reprezentacjaId) throws Exception {
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        String sql = "SELECT z.imie, z.nazwisko FROM t_zawodnicy z, t_mundiale m, t_reprezentacje r, t_zawodnicy_w_reprezentacji zwr" +
                " WHERE r.id_reprezentacji = zwr.id_reprezentacji AND m.id_mundialu = zwr.id_mundialu AND z.id_zawodnika = zwr.id_zawodnika" +
                " AND m.id_mundialu = ? AND r.id_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId, reprezentacjaId).executeQuery();
        while (resultSet.next()) {
            Zawodnik z = new Zawodnik();
            z.setImie(resultSet.getString("imie"));
            z.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(z);
        }
        return zawodnikList;
    }

    @Override
    public Zawodnik getZawodnikIdByMundialIdReprezentacjaIdImieNazwisko(int mundialId, int reprezentacjaId, String imie, String nazwisko) throws Exception {
        String sql = "SELECT z.id_zawodnika FROM t_zawodnicy z, t_zawodnicy_w_reprezentacji zwr" +
                " WHERE z.id_zawodnika = zwr.id_zawodnika AND zwr.id_mundialu = ? AND zwr.id_reprezentacji = ? AND z.imie = ? AND z.nazwisko = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId, reprezentacjaId, imie, nazwisko).executeQuery();
        Zawodnik z = new Zawodnik();
        while (resultSet.next()){
            z.setIdZawodnika(resultSet.getInt("id_zawodnika"));
        }
        ConnectionDB.disconnect(resultSet);
        return z;
    }

    @Override
    public List<Zawodnik> getZawodnikImieNazwiskoByMundialIdRepId(int mundialId, int reprezentacjaId) throws Exception {
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        String sql = "SELECT z.imie, z.nazwisko FROM t_zawodnicy z INNER JOIN t_zawodnicy_w_reprezentacji zwr USING(id_zawodnika) " +
                "WHERE id_mundialu = ? AND id_reprezentacji = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId, reprezentacjaId).executeQuery();
        while (resultSet.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(resultSet.getString("imie"));
            zawodnik.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(zawodnik);
        }
        ConnectionDB.disconnect(resultSet);
        return zawodnikList;
    }

    @Override
    public int getIdZawodnikaAtMundialRepByMundialIdRepIdIndexValue(int mundialId, int repId, int indexValue) throws Exception {
        String sql = "SELECT z.id_zawodnika FROM t_zawodnicy z INNER JOIN t_zawodnicy_w_reprezentacji USING(id_zawodnika) " +
                "WHERE id_reprezentacji = ? AND id_mundialu = ? ORDER BY id_zawodnika LIMIT 1 OFFSET ?";
        ResultSet resultSet = parserSQL.parseQuery(sql, repId, mundialId, indexValue).executeQuery();
        int idZawodnika = 0;
        while (resultSet.next()) {
            idZawodnika = resultSet.getInt("id_zawodnika");
        }
        ConnectionDB.disconnect(resultSet);
        return idZawodnika;
    }

}
