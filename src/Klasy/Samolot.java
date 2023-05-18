package Klasy;

public class Samolot {
    private long id;
    private String typ,nazwa;
    private int liczba_miejsc;
    private float zasieg;

    public Samolot(String nazwa,String typ, int liczba_miejsc,float zasieg){
        this.nazwa = nazwa;
        this.typ = typ;
        this.liczba_miejsc = liczba_miejsc;
        this.zasieg = zasieg;
    }

    public String daneSamolotu(){   //wyświetlenie pełnych danych o samolocie
        return "Nazwa: " + this.nazwa + "\nTyp: " + this.typ + "\nZasięg: " + this.zasieg + "(km)";
    }
}
