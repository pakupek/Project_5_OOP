package Klasy;
import java.util.ArrayList;
import java.util.List;
public class Sys_rezerwacji {

    private List<Klient> klienci = new ArrayList<>();
    private List<Samolot> samoloty = new ArrayList<>();
    private List<Trasa> trasy = new ArrayList<>();
    private List<Lotnisko> lotniska = new ArrayList<>();


    public List<Samolot> getSamoloty(){
        return samoloty;
    }

    public List<Trasa> getTrasy(){
        return trasy;
    }

    public void dodajKlienta(Klient k){  //dodawanie rezerwacji do systemu
        klienci.add(k);
    }

    public void usunKlienta(Klient k){   //usuwanie rezerwacji z systemu
        klienci.remove(k);
    }

    public void dodajSamolot(Samolot s){
        samoloty.add(s);
    }

    public void usunSamolot(Samolot s){
        samoloty.remove(s);
    }

    public void dodajTrase(int Idlotniska_pocz, int Idlotniska_kon, float Dystans, int czas){
    }

    public List<Klient> getKlienci(){
        List l = new ArrayList<>();
        for(Klient klient : klienci){
            if(klient instanceof Klient){
                l.add(klient);
            }
            else if(klient instanceof Firma){
                l.add(klient);
            }
        }
        return l;
    }
}
