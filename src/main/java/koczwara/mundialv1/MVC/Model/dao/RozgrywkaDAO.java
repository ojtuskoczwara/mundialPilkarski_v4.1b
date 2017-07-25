package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Rozgrywka;

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
}
