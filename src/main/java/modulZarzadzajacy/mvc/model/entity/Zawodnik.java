package modulZarzadzajacy.mvc.model.entity;

public class Zawodnik {

    private int idZawodnika;
    private String imie;
    private String nazwisko;

    public Zawodnik() {
    }

    public Zawodnik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getIdZawodnika() {
        return idZawodnika;
    }

    public void setIdZawodnika(int idZawodnika) {
        this.idZawodnika = idZawodnika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
