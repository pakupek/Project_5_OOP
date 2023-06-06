package Klasy;

import java.util.Random;

public class Klient {
    protected int Id;

    public Klient(){
        int r = new Random().nextInt();
        this.Id = r;
    }

    public int getId(){
        return this.Id;
    }
}
