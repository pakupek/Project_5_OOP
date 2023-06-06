package Klasy;

public class Trasa {
    private int Id;
    private float Dystans;
    private Lotnisko miejsce_odlotu,miejsce_przylotu;
    private int Czas;

    public Trasa(float dystans,int id, Lotnisko miejsce_odlotu, Lotnisko miejsce_przylotu){
        this.Dystans = dystans;
        this.Id = id;
        this.miejsce_przylotu = miejsce_przylotu;
        this.miejsce_odlotu = miejsce_odlotu;
    }

    public int getId(){
        return this.Id;
    }

    public float getDystans(){
        return this.Dystans;
    }
}
