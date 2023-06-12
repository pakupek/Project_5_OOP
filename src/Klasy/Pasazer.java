package Klasy;
import java.util.*;
public class Pasazer extends Klient{
    private String imie,nazwisko;
    private int nr_tel;



    public Pasazer(int Id,String imie,String nazwisko,int nr_telefonu){
        super(Id);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel = nr_telefonu;
    }
    public Pasazer(Pasazer pasazer){
        super(pasazer.Id);
        this.imie=pasazer.imie;
        this.nazwisko=pasazer.nazwisko;
        this.nr_tel=pasazer.nr_tel;
    }
    public String getImie(){
        return this.imie;
    }

    public String getNazwisko(){
        return this.nazwisko;
    }

    public String getNazwa()
    {
        return imie + " " + nazwisko;
    }

    public String getNumer() {
        return Integer.toString(nr_tel);
    }

    public String toString(){
        return "Imie: " + getImie() + "\nNazwisko: " + getNazwisko() + "\nNr telefonu: " + getNumer() + "\nId: " + getId();
    }

}
