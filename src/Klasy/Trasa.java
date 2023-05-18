package Klasy;

public class Trasa {
    private String lotn_pocz,lotn_kon;
    private float odleglosc;

    public Trasa(String lotnisko_poczatek, String lotnisko_koniec, float odleglosc){
        this.lotn_pocz = lotnisko_poczatek;
        this.lotn_kon = lotnisko_koniec;
        this.odleglosc = odleglosc;
    }
}
