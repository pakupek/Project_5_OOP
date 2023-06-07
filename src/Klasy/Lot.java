package Klasy;

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
        this.Wolne_miejsca = s.getLiczba_miejsc();
    }

    public int getId(){
        return this.Id;
    }

    public int getWolne_miejsca(){
        return this.Wolne_miejsca;
    }

    public void dodajRezerwacje(Rezerwacja r){
        rezerwacje.add(r);
        Wolne_miejsca -= r.getLiczba_miejsc();
    }

    public void usunRezerwacje(Rezerwacja r){
        rezerwacje.remove(r);
        Wolne_miejsca += r.getLiczba_miejsc();
    }

    public LocalDateTime getCzas_odlotu(){
        return this.Czas_odlotu;
    }
}
