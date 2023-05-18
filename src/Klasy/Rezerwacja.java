package Klasy;

import java.util.Date;

public class Rezerwacja {
    private long id;
    private Date data_rezerwacji;
    private Pasazer pasazer;
    private String status;
    private int ilosc_miejsc;
    private Samolot samolot;

    public Rezerwacja(Date data, Pasazer pasazer, int ilosc, Samolot samolot){
        this.data_rezerwacji = data;
        this.pasazer = pasazer;
        this.ilosc_miejsc = ilosc;
        this.samolot = samolot;

    }
    public String data_wlasciciel(){    //pobranie od pasażera imie i nazwisko oraz dodanie daty
        String str = this.pasazer.dane_personalne() + "\t"+this.data_rezerwacji;
        return str;
    }
    public String daneRezerwacji(){ //wyświetlenie pełnych danych rezerwacji
        return "Data: " + this.data_rezerwacji + "\nWłaściciel:\n" + this.pasazer.danePasazera() + "\nSamolot:\n" + this.samolot.daneSamolotu();
    }
}
