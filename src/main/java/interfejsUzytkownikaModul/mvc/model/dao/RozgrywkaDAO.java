package interfejsUzytkownikaModul.mvc.model.dao;

import interfejsUzytkownikaModul.mvc.model.entity.Grupa;
import interfejsUzytkownikaModul.mvc.model.entity.Mundial;
import interfejsUzytkownikaModul.mvc.model.entity.Rozgrywka;

import java.util.List;

public interface RozgrywkaDAO {
    public List<Rozgrywka> getFazaGrupowaByIdMundialuIdGrupyIdTypuGrupy(Mundial mundial, Grupa grupa) throws Exception;
    public Rozgrywka getFazaJednaOsmaByIdMundialu(Mundial mundial) throws Exception;
    public Rozgrywka getFazaJednaCzwartaByIdMundialu(Mundial mundial) throws Exception;
    public Rozgrywka getFazaJednaDrugaByIdMundialu(Mundial mundial) throws Exception;
    public Rozgrywka getFazaFinalByIdMundialu(Mundial mundial) throws Exception;
    public List<Rozgrywka> getAllRozgrywkaByIdMundialu(int mundialId) throws Exception;
    public Rozgrywka getIdReprezentacji1ByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception;
    public Rozgrywka getIdReprezentacji2ByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception;
    public Rozgrywka getIdGrupyByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception;
    public Rozgrywka getIdRozgrywkiByIndexMeczuIdMundialu(int meczIndex, int mundialId) throws Exception;
    public Rozgrywka getAllByMundialIdMeczIndex(int mundialId, int meczIndex) throws Exception;
}
