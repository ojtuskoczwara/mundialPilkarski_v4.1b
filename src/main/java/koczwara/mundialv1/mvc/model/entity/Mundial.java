package koczwara.mundialv1.mvc.model.entity;


public class Mundial {

    private int idMundialu;
    private String lokalizacja;
    private int rok;

    public Mundial() {}

    public Mundial(String lokalizacja, int rok) {
        this.lokalizacja = lokalizacja;
        this.rok = rok;
    }

    public int getIdMundialu() {
        return idMundialu;
    }

    public void setIdMundialu(int idMundialu) {
        this.idMundialu = idMundialu;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }
}
