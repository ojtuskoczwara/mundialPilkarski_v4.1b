package koczwara.mundialv1.MVC.Model.dao;


import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;

import java.util.List;

public interface ReprezentacjaDAO {
    public void addReprezentacja(Reprezentacja reprezentacja) throws Exception;
    public Reprezentacja getReprezentacjaById(int id) throws Exception;
    public List<Reprezentacja> getAllReprezentacja() throws Exception;
    public void deleteReprezentacja(int id) throws Exception;
    public void updateReprezentacjaById(Reprezentacja reprezentacja) throws Exception;
    public Reprezentacja getIdRepByNazwa(String nazwaRep) throws Exception;
}
