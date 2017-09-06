package interfejsUzytkownikaModul.mvc.model.dao;

import interfejsUzytkownikaModul.mvc.model.entity.TypGrupy;

public interface TypGrupyDAO {
    public TypGrupy getNazwaTypuGrupyByIdTypuGrupy(int typGrupyId) throws Exception;
}
