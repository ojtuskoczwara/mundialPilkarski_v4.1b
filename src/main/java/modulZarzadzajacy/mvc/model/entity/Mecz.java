package modulZarzadzajacy.mvc.model.entity;


import java.sql.Date;

public class Mecz {
    private int idMeczu;
    private Date dataMeczu;
    private int idReprezentacji1;
    private int idReprezentacji2;
    private int idGrupy;
    private int idMundialu;
    private int goleRep1;
    private int goleRep2;

    public int getIdMeczu() {
        return idMeczu;
    }

    public void setIdMeczu(int idMeczu) {
        this.idMeczu = idMeczu;
    }

    public Date getDataMeczu() {
        return dataMeczu;
    }

    public void setDataMeczu(Date dataMeczu) {
        this.dataMeczu = dataMeczu;
    }

    public int getIdReprezentacji1() {
        return idReprezentacji1;
    }

    public void setIdReprezentacji1(int idReprezentacji1) {
        this.idReprezentacji1 = idReprezentacji1;
    }

    public int getIdReprezentacji2() {
        return idReprezentacji2;
    }

    public void setIdReprezentacji2(int idReprezentacji2) {
        this.idReprezentacji2 = idReprezentacji2;
    }

    public int getIdGrupy() {
        return idGrupy;
    }

    public void setIdGrupy(int idGrupy) {
        this.idGrupy = idGrupy;
    }

    public int getIdMundialu() {
        return idMundialu;
    }

    public void setIdMundialu(int idMundialu) {
        this.idMundialu = idMundialu;
    }

    public int getGoleRep1() {
        return goleRep1;
    }

    public void setGoleRep1(int goleRep1) {
        this.goleRep1 = goleRep1;
    }

    public int getGoleRep2() {
        return goleRep2;
    }

    public void setGoleRep2(int goleRep2) {
        this.goleRep2 = goleRep2;
    }
}
