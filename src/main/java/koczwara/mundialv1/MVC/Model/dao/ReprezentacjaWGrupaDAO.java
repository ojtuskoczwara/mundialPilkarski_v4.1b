package koczwara.mundialv1.MVC.Model.dao;

import koczwara.mundialv1.MVC.Model.entity.Grupa;
import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;

import java.util.List;

public interface ReprezentacjaWGrupaDAO {
    public void addReprezentacjeToGrupa(Reprezentacja reprezentacja, Grupa grupa, Mundial mundial) throws Exception;
    public List<Reprezentacja> getAllReprezentacjeInGrupaByIdMundialuIdGrupy(Mundial mundial, Grupa grupa) throws Exception;
    public void deleteReprezentacjaFromGrupa(int reprezentacjaId, int grupaId, int mundialId) throws Exception;
    public List<Reprezentacja> getReprezentacjeNazwaByGrupaIdMundialId(int grupaId, int mundialId) throws Exception;
    public void addReprezentacjaToGrupa(int reprezentacjaId, int grupaId, int mundialId) throws Exception;

}
