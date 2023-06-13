package Klasy;

public class Trasa {
    private int id;
    private float dystans;
    private Lotnisko miejsce_odlotu,miejsce_przylotu;
    private int czas;

    public Trasa(int id,float dystans,Lotnisko miejsce_odlotu, Lotnisko miejsce_przylotu,int czas){
        this.id = id;
        this.dystans = dystans;
        this.miejsce_przylotu = miejsce_przylotu;
        this.miejsce_odlotu = miejsce_odlotu;
        this.czas = czas;
    }
    public Trasa(Trasa trasa){
        this.id=trasa.id;
        this.dystans=trasa.dystans;
        this.miejsce_odlotu=trasa.miejsce_odlotu;
        this.miejsce_przylotu=trasa.miejsce_przylotu;
        this.czas=trasa.czas;

    }
    public int getId(){
        return this.id;
    }

    public float getDystans(){
        return this.dystans;
    }

    public Lotnisko getMiejsce_odlotu() {
        return miejsce_odlotu;
    }

    public Lotnisko getMiejsce_przylotu() {
        return miejsce_przylotu;
    }

    public int getCzas() {
        return czas;
    }

    public String wypisz()
    {
        return id + "\n" + dystans + "\n" + miejsce_przylotu.getNazwa()
                + "\n" + miejsce_odlotu.getNazwa() + "\n" + czas + "\n";
    }
    @Override
    public String toString() {
        return "Trasa{" +
                "\n\tID= " + getId() +
                "\n\tdystans= " + getDystans() +
                "\n\tmiejsce_odlotu= " + getMiejsce_odlotu() +
                "\n\tmiejsce_przylotu= " + getMiejsce_przylotu() +
                "\n\tczas= " + getCzas() +
                '}';
    }
}
