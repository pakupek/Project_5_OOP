package Klasy;

public class Rezerwacja {
    private Klient klient;
    private int Liczba_miejsc;

    public Rezerwacja(Klient k, int ilosc_miejsc){
        this.klient = k;
        this.Liczba_miejsc = ilosc_miejsc;

    }
    public Klient getKlient(){
        return this.klient;
    }

    public int getLiczba_miejsc(){
        return this.Liczba_miejsc;
    }

    public String toString(){
        return this.getKlient()+"\nIlość miejsc: "+this.getLiczba_miejsc();
    }
}
