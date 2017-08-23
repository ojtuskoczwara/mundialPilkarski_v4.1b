package koczwara.mundialv1.MVC.Model.dao;


import koczwara.mundialv1.MVC.Model.entity.Zawodnik;

import java.sql.SQLException;
import java.util.List;

public interface ZawodnikDAO {

    public void addZawodnik(Zawodnik zawodnik) throws SQLException;
    public Zawodnik getZawodnikById(int id) throws Exception;
    public List<Zawodnik> getZawodnicyByImieNazwisko(String imie, String nazwisko) throws Exception;
    public List<Zawodnik> getAllZawodnik() throws Exception;
    public void updateZawodnik(Zawodnik zawodnik) throws SQLException;
    public void deleteZawodnik(int idZawodnika) throws SQLException;
    public  Zawodnik getLastZawodnik() throws Exception;
    public void updateZawodnikById(String imie, String nazwisko, Zawodnik zawodnik) throws Exception;
    public List<Zawodnik> getZawodnicyImieNazwiskoSklad1ByMeczIdRep1Id(int meczId) throws Exception;
    public List<Zawodnik> getZawodnicyImieNazwiskoSklad2ByMeczIdRep1Id(int meczId) throws Exception;
}
