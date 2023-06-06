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
    }

    public int getId(){
        return this.Id;
    }

    public int getWolne_miejsca(){
        return this.Wolne_miejsca;
    }
}
