package modulZarzadzajacy.mvc.model.dao;

import modulZarzadzajacy.mvc.model.entity.TypGrupy;

public interface TypGrupyDAO {
    public TypGrupy getNazwaTypuGrupyByIdTypuGrupy(int typGrupyId) throws Exception;
}
