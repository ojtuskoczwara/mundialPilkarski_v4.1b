package interfejsUzytkownikaModul.mvc.model.dao;


import interfejsUzytkownikaModul.mvc.model.entity.Mundial;

import java.sql.SQLException;
import java.util.List;

public interface MundialDAO {
    public void addMundial(Mundial mundial) throws Exception;

    public List<Mundial> getAllMundial() throws Exception;

    public Mundial getIdMundialuByLokalizacjaRok(Mundial mundial) throws Exception;

    public int deleteMundialByIdMundialu(int idMundialu) throws SQLException;

    public Mundial getIdMundialByLokalizacjaRok(String lokalizacja, int rok) throws Exception;

    public int updateMundial(int idMundialu, String nowaLokalizacja, int nowyRok) throws SQLException;

    public int getMundialByLokalRok(String lokalizacja, int rok) throws Exception;

    public List<Mundial> getMundialWithoutSomeMundialByMundialId(int mundialId) throws Exception;

    public List<Mundial> getAllMundials() throws Exception;
}
