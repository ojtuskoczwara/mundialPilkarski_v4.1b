package koczwara.mundialv1.mvc.model.dao;


import koczwara.mundialv1.mvc.model.entity.Grupa;
import koczwara.mundialv1.mvc.model.entity.Mundial;
import koczwara.mundialv1.mvc.model.entity.TypGrupy;

import java.util.List;

public interface GrupaDAO {
    public void addGrupa(Grupa grupa, Mundial mundial, TypGrupy typGrupy) throws Exception;
    public List<Grupa> getAllGrupa() throws Exception;
    public Grupa getIdGrupyByIdMundialuNazwaGrupy(Mundial mundial, Grupa grupa) throws Exception;
    public void updateGrupaByIdGrupy(Grupa grupa, Mundial mundial, TypGrupy typGrupy) throws Exception;
    public void deleteGrupaByIdGrupy(Grupa grupa) throws Exception;
    public Grupa getNazwaByIdGrupyIdMundialu(int grupaId, int mundialId) throws Exception;
    public int getGrupaIdByMundialIdGrupaNazwa(int mundialId, String grupaNazwa) throws Exception;
    public int getIdTypuGrByGrupaId(int grupaId) throws Exception;


}
