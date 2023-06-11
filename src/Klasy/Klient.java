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
}
