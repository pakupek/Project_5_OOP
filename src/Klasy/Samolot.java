package Klasy;

public class Samolot {
    private String typ,nazwa;
    private int liczba_miejsc;
    private float zasieg;

    public Samolot(String nazwa,String typ, int liczba_miejsc,float zasieg){
        this.nazwa = nazwa;
        this.typ = typ;
        this.liczba_miejsc = liczba_miejsc;
        this.zasieg = zasieg;
    }

    public String toString(){   //wyświetlenie pełnych danych o samolocie
        return "Nazwa: " + this.nazwa + "\nTyp: " + this.typ + "\nZasięg: " + this.zasieg + "(km)" + "\nLiczba miejsc: " + this.liczba_miejsc;
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

    public String getTyp(){
        return this.typ;
    }
}
