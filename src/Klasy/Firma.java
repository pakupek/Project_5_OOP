package Klasy;
import java.util.*;
public class Firma extends Klient{
    private String Nazwa,KRS;

    public Firma(String nazwa,String krs){
        int r = new Random().nextInt();
        this.Nazwa = nazwa;
        this.KRS = krs;
        super.Id = r;
    }

    public Firma(Firma f){
        this.Nazwa = f.Nazwa;
        this.KRS = f.KRS;
    }

    public String getNazwa(){
        return this.Nazwa;
    }

    public String toString(){
        return "Nazwa: " + this.Nazwa + "\tKRS: " + this.KRS;
    }

    public String getKRS(){
        return this.KRS;
    }
}
