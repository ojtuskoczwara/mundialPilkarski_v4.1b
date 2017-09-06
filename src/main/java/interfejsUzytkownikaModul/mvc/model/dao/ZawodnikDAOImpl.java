package interfejsUzytkownikaModul.mvc.model.dao;

import interfejsUzytkownikaModul.mvc.model.entity.Zawodnik;
import interfejsUzytkownikaModul.service.ConnectionDB;
import interfejsUzytkownikaModul.repository.utils.ParserSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZawodnikDAOImpl implements ZawodnikDAO {

    private ParserSQL parserSQL = new ParserSQL();

    public void addZawodnik(Zawodnik zawodnik) throws SQLException {
        String sql = "INSERT INTO t_zawodnicy(imie,nazwisko) VALUES(?,?)";
        parserSQL.parseQuery(sql, zawodnik.getImie(), zawodnik.getNazwisko())
                .executeUpdate();
    }

    public Zawodnik getZawodnikById(int id) throws Exception {
        String sql = "SELECT * FROM t_zawodnicy WHERE id_zawodnika = ?";
        Zawodnik zawodnik = null;
        ResultSet result = parserSQL.parseQuery(sql, id)
                .executeQuery();
        if (result.next()) {
            zawodnik = new Zawodnik();
            zawodnik.setIdZawodnika(result.getInt("id_zawodnika"));
            zawodnik.setImie(result.getString("imie"));
            zawodnik.setNazwisko(result.getString("nazwisko"));
        }
        ConnectionDB.disconnect(result);
        return zawodnik;
    }

    public List<Zawodnik> getZawodnicyByImieNazwisko(String imie, String nazwisko) throws Exception {
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        String sql = "SELECT * FROM t_zawodnicy WHERE imie = ? AND nazwisko = ?";

        ResultSet results = parserSQL.parseQuery(sql, imie, nazwisko)
                .executeQuery();

        while (results.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setIdZawodnika(results.getInt("id_zawodnika"));
            zawodnik.setImie(results.getString("imie"));
            zawodnik.setNazwisko(results.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.disconnect(results);
        return zawodnicy;
    }


    public List<Zawodnik> getAllZawodnik() throws Exception {
        List<Zawodnik> zawodnicy = new ArrayList<Zawodnik>();
        String sql = "SELECT * FROM t_zawodnicy";

        ResultSet results = parserSQL.parseQuery(sql).executeQuery();

        while (results.next()) {
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(results.getString("imie"));
            zawodnik.setNazwisko(results.getString("nazwisko"));
            zawodnicy.add(zawodnik);
        }
        ConnectionDB.disconnect(results);
        return zawodnicy;
    }

    public void updateZawodnik(Zawodnik zawodnik) throws SQLException {
        String sql = "UPDATE t_zawodnicy SET imie=?, nazwisko=? WHERE id_zawodnika = ?";
        parserSQL.parseQuery(sql, zawodnik.getImie(), zawodnik.getNazwisko(), zawodnik.getIdZawodnika()).executeUpdate();
    }

    public void deleteZawodnik(int idZawodnika) throws SQLException {
        String sql = "DELETE FROM t_zawodnicy WHERE id_zawodnika = ?";
        parserSQL.parseQuery(sql, idZawodnika).executeUpdate();
    }

    @Override
    public Zawodnik getLastZawodnik() throws Exception {
        String sql = "SELECT * FROM t_zawodnicy WHERE id_zawodnika IN (SELECT MAX(id_zawodnika) FROM t_zawodnicy)";
        Zawodnik zawodnik = null;
        ResultSet result = parserSQL.parseQuery(sql).executeQuery();
        if (result.next()) {
            zawodnik = new Zawodnik();
            zawodnik.setIdZawodnika(result.getInt("id_zawodnika"));
            zawodnik.setImie(result.getString("imie"));
            zawodnik.setNazwisko(result.getString("nazwisko"));
        }
        ConnectionDB.disconnect(result);
        return zawodnik;

    }

    @Override
    public void updateZawodnikById(String imie, String nazwisko, Zawodnik zawodnik) throws Exception {
        String sql = "UPDATE t_zawodnicy SET imie=?, nazwisko=? WHERE id_zawodnika=?";
        parserSQL.parseQuery(sql, imie, nazwisko, zawodnik.getIdZawodnika()).executeUpdate();
    }

    @Override
    public List<Zawodnik> getZawodnicyImieNazwiskoSklad1ByMeczIdRep1Id(int meczId) throws Exception {
        String sql = "SELECT imie,nazwisko FROM v_sklady_rep_1_view5 WHERE id_meczu=?";
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        ResultSet resultSet = parserSQL.parseQuery(sql,meczId).executeQuery();
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
    public List<Zawodnik> getZawodnicyImieNazwiskoSklad2ByMeczIdRep1Id(int meczId) throws Exception {
        String sql = "SELECT imie,nazwisko FROM v_sklady_rep_2_view5 WHERE id_meczu=?";
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        ResultSet resultSet = parserSQL.parseQuery(sql,meczId).executeQuery();
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
    public List<Zawodnik> getAllZawodnicyImieNazwisko() throws Exception {
        String sql = "SELECT DISTINCT(id_zawodnika), imie, nazwisko FROM v_zawodnicy_view1 ORDER BY id_zawodnika";
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()){
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(resultSet.getString("imie"));
            zawodnik.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(zawodnik);
        }
        ConnectionDB.disconnect(resultSet);
        return zawodnikList;
    }

    @Override
    public List<Zawodnik> getZawodnicyImieNazwiskoInMundial(int mundialId) throws Exception {
        String sql = "SELECT imie, nazwisko FROM v_zawodnicy_view1 WHERE id_mundialu = ? ORDER BY id_zawodnika;";
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId).executeQuery();
        while (resultSet.next()){
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(resultSet.getString("imie"));
            zawodnik.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(zawodnik);
        }
        ConnectionDB.disconnect(resultSet);
        return zawodnikList;
    }

    @Override
    public List<Zawodnik> getZawodnicyImieNazwiskoInMundialInRep(int mundialId, int reprezentacjaId) throws Exception {
        String sql = "SELECT imie, nazwisko FROM v_zawodnicy_view1 WHERE id_mundialu= ? AND id_reprezentacji= ? ORDER BY id_zawodnika;";
        List<Zawodnik> zawodnikList = new ArrayList<Zawodnik>();
        ResultSet resultSet = parserSQL.parseQuery(sql,mundialId,reprezentacjaId).executeQuery();
        while (resultSet.next()){
            Zawodnik zawodnik = new Zawodnik();
            zawodnik.setImie(resultSet.getString("imie"));
            zawodnik.setNazwisko(resultSet.getString("nazwisko"));
            zawodnikList.add(zawodnik);
        }
        ConnectionDB.disconnect(resultSet);
        return zawodnikList;
    }
}
