package koczwara.mundialv1.mvc.model.dao;


import koczwara.mundialv1.mvc.model.entity.Reprezentacja;

import java.util.List;

public interface ReprezentacjaDAO {
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception;
    public Reprezentacja getNazwaReprezentacjaByIdReprezentacja(int id) throws Exception;
    public List<Reprezentacja> getAllReprezentacja() throws Exception;
    public void deleteReprezentacja(int id) throws Exception;
    public void updateReprezentacjaById(Reprezentacja reprezentacja) throws Exception;
    public Reprezentacja getIdRepByNazwa(String nazwaRep) throws Exception;
    public Reprezentacja getIdReprezentacjaByNazwaRep(Reprezentacja reprezentacja) throws Exception;
    public int getReprezentacjaIdByReprezentacjaNazwa(String reprezentacjaNazwa) throws Exception;
    public List<Reprezentacja> getAllReprezentacjaInMundial(int mundialId) throws Exception;
    public int getReprezentacjaId(String reprezentacjaNazwa) throws Exception;
}
