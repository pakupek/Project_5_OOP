package Klasy;

public class Samolot {
    private String nazwa;
    private int liczba_miejsc;
    private float zasieg;

    public Samolot(String nazwa,int miejsca,float zasieg){
        this.nazwa = nazwa;
        this.liczba_miejsc = miejsca;
        this.zasieg = zasieg;
    }
    public String wypisz(){
        return getLiczba_miejsc()+"\n"+ getZasieg()+"\n"+getNazwa()+"\n";
    }
    public String toString(){   //wyświetlenie pełnych danych o samolocie
        return "Nazwa: "+getNazwa()+"\nZasięg: "+getZasieg()+"(km)"+"\nLiczba miejsc: "+getLiczba_miejsc();
    }

    public float getZasieg(){
        return this.zasieg;
    }

    public int getLiczba_miejsc(){
        return this.liczba_miejsc;
    }

    public String getNazwa(){
        return this.nazwa;
    }
}
