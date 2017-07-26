package koczwara.mundialv1.MVC.Model.dao;


import koczwara.mundialv1.MVC.Model.entity.Mundial;
import koczwara.mundialv1.MVC.Model.entity.Reprezentacja;
import koczwara.mundialv1.MVC.Model.entity.Zawodnik;

import java.util.List;

public interface ZawodnikWReprezentacjaDAO {
    public List<Zawodnik> getAllZawodnicyAtMundialInRep(String mundialValue, String repValue) throws Exception;
    public void addZawodnikRepMundial(int idZawodnika, int idReprezentacji, int idMundialu) throws Exception;
    public List<Reprezentacja> getAllReprezentacjeAtMundial(String mundialName, int mundialRok) throws Exception;
    public int getIdZawodnikByLokalizacjaNazwaImieNazwisko(String mundialLokalizacja, String reprezentacjaNazwa, Zawodnik zawodnik) throws Exception;
    public Zawodnik getZawodnikIdByLokalizacjaRokNazwaImieNazwisko(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception;
    public void deleteRowsByMundialIdReprezentacjaIdZawodnikId(Mundial mundial, Reprezentacja reprezentacja, Zawodnik zawodnik) throws Exception;
    public void deleteRowsByIdMundialu(Mundial mundial) throws Exception;
    public void deleteRowsByIdReprezentacji(Reprezentacja reprezentacja) throws Exception;
    public List<Zawodnik> getImieNazwiskoZawodnikaByIdMundialuIdReprezentacji(int mundialId, int reprezentacjaId) throws Exception;
    public Zawodnik getZawodnikIdByMundialIdReprezentacjaIdImieNazwisko(int mundialId, int reprezentacjaId, String imie, String nazwisko) throws Exception;

}
