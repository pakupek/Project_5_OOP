package Klasy;

import java.util.Random;

abstract class Klient {
    protected int Id;

    public Klient(int Id){
        this.Id= Id;
    }
    public int getId(){
        return this.Id;
    }
    public abstract String getNazwa();
    public abstract String getNumer();
    public String wypisz()
    {
        return Id + "\n" + getNazwa() + "\n" + getNumer() + "\n";
    }
}
