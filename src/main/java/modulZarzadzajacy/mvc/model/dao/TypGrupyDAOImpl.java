package modulZarzadzajacy.mvc.model.dao;

import modulZarzadzajacy.mvc.model.entity.TypGrupy;
import modulZarzadzajacy.repository.utils.ParserSQL;
import modulZarzadzajacy.service.ConnectionDB;

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
