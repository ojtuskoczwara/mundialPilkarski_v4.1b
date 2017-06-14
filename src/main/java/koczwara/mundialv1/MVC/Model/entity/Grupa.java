package koczwara.mundialv1.MVC.Model.entity;

public class Grupa {
    private int idGrupy;
    private int idMundialuPFK;
    private String nazwaGrupy;
    private int idTypuGrupyFK;


    public int getIdGrupy() {
        return idGrupy;
    }

    public void setIdGrupy(int idGrupy) {
        this.idGrupy = idGrupy;
    }

    public int getIdMundialuPFK() {
        return idMundialuPFK;
    }

    public void setIdMundialuPFK(int idMundialuPFK) {
        this.idMundialuPFK = idMundialuPFK;
    }

    public String  getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    public int getIdTypuGrupyFK() {
        return idTypuGrupyFK;
    }

    public void setIdTypuGrupyFK(int idTypuGrupyFK) {
        this.idTypuGrupyFK = idTypuGrupyFK;
    }


}
