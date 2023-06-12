package Klasy;
import java.util.*;
public class Firma extends Klient{
    private String Nazwa,KRS;

    public Firma(int Id,String nazwa,String krs){
        super(Id);
        this.Nazwa = nazwa;
        this.KRS = krs;
    }

    public Firma(Firma f){
        super(f.Id);
        this.Nazwa = f.Nazwa;
        this.KRS = f.KRS;
    }

    public String getNazwa(){
        return Nazwa;
    }
    public String getNumer(){
        return KRS;
    }
    public String toString(){
        return "\nNazwa: " + getNazwa() + "\nKRS: " + getNumer();
    }

}
