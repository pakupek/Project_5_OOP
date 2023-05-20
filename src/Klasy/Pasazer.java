package Klasy;
import java.util.*;
public class Pasazer extends Klient{
    private long id;
    private String imie,nazwisko;
    private int nr_tel;
    //private List<Rezerwacja> rezerwacje = new ArrayList<>();

    public Pasazer(String imie,String nazwisko,int nr_telefonu){
        long  r = new Random().nextLong();
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel = nr_telefonu;
        this.id = r;
    }
    public String dane_personalne(){
        return this.imie + " " + this.nazwisko + " ";
    }
    public String danePasazera(){
        return "Imie: " + this.imie + "\nNazwisko: " + this.nazwisko + "\nNr telefonu: " + this.nr_tel + "\nId: " + this.id;
    }

    @Override
    public String toString(){
        return "Imie: " + this.imie + "\nNazwisko: " + this.nazwisko + "\nNr telefonu: " + this.nr_tel + "\nId: " + this.id + "\n";
    }
}
