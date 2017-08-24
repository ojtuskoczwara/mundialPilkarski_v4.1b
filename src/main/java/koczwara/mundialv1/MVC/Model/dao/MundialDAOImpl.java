package koczwara.mundialv1.MVC.Model.dao;


import koczwara.mundialv1.MVC.Controller.DatabaseConnection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Tools.utils.ParserSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MundialDAOImpl implements MundialDAO{

    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public void addMundial(Mundial mundial) throws Exception {
        String sql = "INSERT INTO t_mundiale(lokalizacja,rok) VALUES(?,?)";
        parserSQL.parseQuery(sql, mundial.getLokalizacja(), mundial.getRok()).executeUpdate();
    }

    @Override
    public List<Mundial> getAllMundial() throws Exception {
        List<Mundial> mundiale = new ArrayList<Mundial>();
        String sql = "SELECT * FROM t_mundiale";
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Mundial mundial = new Mundial();
            mundial.setLokalizacja(resultSet.getString("lokalizacja"));
            mundial.setRok(resultSet.getInt("rok"));
            mundiale.add(mundial);
        }
        ConnectionDB.disconnect(resultSet);
        return mundiale;
    }

    @Override
    public Mundial getIdMundialuByLokalizacjaRok(Mundial mundial) throws Exception {
        String sql = "SELECT * FROM t_mundiale WHERE lokalizacja = ? AND rok = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql,mundial.getLokalizacja(), mundial.getRok()).executeQuery();
        Mundial m = null;
        while (resultSet.next()) {
            m = new Mundial();
            m.setIdMundialu(resultSet.getInt("id_mundialu"));
        }
        ConnectionDB.disconnect(resultSet);
        return m;
    }

    @Override
    public int deleteMundialByIdMundialu(int idMundialu) throws SQLException {
        String sql = "DELETE FROM t_mundiale WHERE id_mundialu = ?";
        int wynik = parserSQL.parseQuery(sql, idMundialu).executeUpdate();
        return wynik;
    }

    @Override
    public Mundial getIdMundialByLokalizacjaRok(String lokalizacja, int rok) throws Exception {
        String sql = "SELECT * FROM t_mundiale WHERE lokalizacja = ? AND rok = ?";
        ResultSet resultSet = parserSQL.parseQuery(sql,lokalizacja, rok).executeQuery();
        Mundial m = null;
        while (resultSet.next()) {
            m = new Mundial();
            m.setIdMundialu(resultSet.getInt("id_mundialu"));
        }
        ConnectionDB.disconnect(resultSet);
        return m;
    }

    @Override
    public int updateMundial(int idMundialu, String nowaLokalizacja, int nowyRok) throws SQLException {
        String sql = "UPDATE t_mundiale SET lokalizacja = ?, rok = ? WHERE id_mundialu = ?";
        PreparedStatement ps= parserSQL.parseQuery(sql, nowaLokalizacja, nowyRok, idMundialu);
        int wynik = ps.executeUpdate();
        return wynik;
    }

    @Override
    public int getMundialByLokalRok(String lokalizacja, int rok) throws Exception {
        String sql = "SELECT id_mundialu FROM t_mundiale WHERE lokalizacja = ? AND rok = ?";
        ResultSet rs = parserSQL.parseQuery(sql,lokalizacja, rok).executeQuery();
        int id = 0;
        while (rs.next()){
            id = rs.getInt("id_mundialu");
        }
        ConnectionDB.disconnect(rs);
        return id;
    }

    @Override
    public List<Mundial> getMundialWithoutSomeMundialByMundialId(int mundialId) throws Exception {
        List<Mundial> mundiale = new ArrayList<Mundial>();
        String sql = "SELECT lokalizacja, rok FROM t_mundiale WHERE id_mundialu NOT IN(?)";
        ResultSet resultSet = parserSQL.parseQuery(sql, mundialId).executeQuery();
        while (resultSet.next()){
            Mundial mundial = new Mundial();
            mundial.setLokalizacja(resultSet.getString("lokalizacja"));
            mundial.setRok(resultSet.getInt("rok"));
            mundiale.add(mundial);
        }
        ConnectionDB.disconnect(resultSet);
        return mundiale;
    }

    @Override
    public List<Mundial> getAllMundials() throws Exception {
        List<Mundial> mundialList = new ArrayList<Mundial>();
        String sql = "SELECT lokalizacja,rok FROM v_mundiale_view1 ";
        ResultSet resultSet = parserSQL.parseQuery(sql).executeQuery();
        while (resultSet.next()) {
            Mundial mundial = new Mundial();
            mundial.setLokalizacja(resultSet.getString("lokalizacja"));
            mundial.setRok(resultSet.getInt("rok"));
            mundialList.add(mundial);
        }
        ConnectionDB.disconnect(resultSet);
        return mundialList;
    }

}
