package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.Connection.ConnectionDB;
import koczwara.mundialv1.MVC.Model.entity.TypGrupy;
import koczwara.mundialv1.MVC.Model.utils.ParserSQL;

import java.sql.ResultSet;

public class TypGrupyDAOImpl implements TypGrupyDAO{
    private ParserSQL parserSQL = new ParserSQL();

    @Override
    public TypGrupy getNazwaTypuGrupyByIdTypuGrupy(int typGrupyId) throws Exception {
        String sql = "SELECT nazwa_typu FROM t_typ_grupy WHERE id_typu_grupy = ?";
        ResultSet result = parserSQL.parseQuery(sql, typGrupyId).executeQuery();
        TypGrupy typGrupy = new TypGrupy();
        while (result.next()) {
            typGrupy.setNazwaTypu(result.getString("nazwa_typu"));
        }
        ConnectionDB.disconnect(result);
        return typGrupy;
    }
}
