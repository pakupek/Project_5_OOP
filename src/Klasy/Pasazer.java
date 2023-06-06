package Klasy;
import java.util.*;
public class Pasazer extends Klient{
    private String imie,nazwisko;
    private int nr_tel;
    private int Pesel;


    public Pasazer(String imie,String nazwisko,int pesel,int nr_telefonu){
        int r = new Random().nextInt();
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.Pesel = pesel;
        this.nr_tel = nr_telefonu;
        super.Id = r;
    }
    public String getImie(){
        return this.imie;
    }

    public String getNazwisko(){
        return this.nazwisko;
    }

    public int getNr_tel(){
        return this.nr_tel;
    }

    public int getPesel(){
        return this.Pesel;
    }

    public String toString(){
        return "Imie: " + this.imie + "\nNazwisko: " + this.nazwisko + "\nNr telefonu: " + this.nr_tel + "\nId: " + super.Id;
    }

}
