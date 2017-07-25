package koczwara.mundialv1.MVC.Model.entity;


public class TypGrupy {
    private int idTypuGrupy;
    private String nazwaTypu;
    private int maksLiczbaReprezentacji;

    public TypGrupy(){}

    public TypGrupy(int idTypuGrupy, String nazwaTypu, int maksLiczbaReprezentacji){
        this.idTypuGrupy = idTypuGrupy;
        this.nazwaTypu = nazwaTypu;
        this.maksLiczbaReprezentacji = maksLiczbaReprezentacji;
    }

    public int getIdTypuGrupy() {
        return idTypuGrupy;
    }

    public void setIdTypuGrupy(int idTypuGrupy) {
        this.idTypuGrupy = idTypuGrupy;
    }

    public String getNazwaTypu() {
        return nazwaTypu;
    }

    public void setNazwaTypu(String nazwaTypu) {
        this.nazwaTypu = nazwaTypu;
    }

    public int getMaksLiczbaReprezentacji() {
        return maksLiczbaReprezentacji;
    }

    public void setMaksLiczbaReprezentacji(int maksLiczbaReprezentacji) {
        this.maksLiczbaReprezentacji = maksLiczbaReprezentacji;
    }

}
