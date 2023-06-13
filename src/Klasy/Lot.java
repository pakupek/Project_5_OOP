package Klasy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Lot {
    private int Id;
    private Samolot samolot;
    private List<Rezerwacja> rezerwacje = new ArrayList<>();
    private int Wolne_miejsca;
    private Trasa trasa;
    private LocalDateTime Czas_odlotu,Czas_przylotu;

    public Lot(int id,Samolot s, Trasa t, LocalDateTime czas_odlotu){
        this.Id = id;
        this.samolot = s;
        this.trasa = t;
        this.Czas_odlotu = czas_odlotu;
        Wolne_miejsca = s.getLiczba_miejsc();
        Czas_przylotu= czas_odlotu.plusMinutes(trasa.getCzas());
    }


    public int getId() {
        return Id;
    }

    public Samolot getSamolot() {
        return samolot;
    }
    public Trasa getTrasa() {
        return trasa;
    }
    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public int getWolne_miejsca() {
        return Wolne_miejsca;
    }

    public LocalDateTime getCzas_odlotu() {
        return Czas_odlotu;
    }

    public LocalDateTime getCzas_przylotu() {
        return Czas_przylotu;
    }

    public void dodajRezerwacje(Rezerwacja r){
        rezerwacje.add(r);
        Wolne_miejsca -= r.getLiczba_miejsc();
    }

    public void usunRezerwacje(Rezerwacja r){
        rezerwacje.remove(r);
        Wolne_miejsca += r.getLiczba_miejsc();
    }

    public String wypisz()
    {
        return getId() + "\n" + samolot.getNazwa() + "\n" + trasa.getId() + "\n" + Czas_odlotu + "\n";
    }

    @Override
    public String toString() {
        return "Lot{" +
                "Id=" + Id +
                ", samolot=" + samolot +
                ", rezerwacje=" + rezerwacje +
                ", Wolne_miejsca=" + Wolne_miejsca +
                ", trasa=" + trasa +
                ", Czas_odlotu=" + Czas_odlotu +
                ", Czas_przylotu=" + Czas_przylotu +
                '}';
    }
}
