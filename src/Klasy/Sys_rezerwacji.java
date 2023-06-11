package Klasy;
import java.util.ArrayList;
import java.util.List;
public class Sys_rezerwacji {
    private List<Klient> klienci = new ArrayList<>();
    private List<Samolot> samoloty = new ArrayList<>();
    private List<Trasa> trasy = new ArrayList<>();
    private List<Lotnisko> lotniska = new ArrayList<>();
    private List<Lot> loty = new ArrayList<>();
    private List<Rezerwacja> rezerwacje = new ArrayList<>();

    public List<Samolot> getSamoloty(){
        return samoloty;
    }

    public List<Trasa> getTrasy(){
        return trasy;
    }

    public String listaRezerwacji(){
        for(Lot lot : loty){
            rezerwacje.addAll(lot.getRezerwacje());
        }
        String str = "";
        for(Lot lot : loty){
            str += "Miejsce odlotu: "+lot.getTrasa().getMiejsce_odlotu().getNazwa()+"("+lot.getTrasa().getMiejsce_odlotu().getKraj()+")"+
                    "\tMiejsce prylotu: "+lot.getTrasa().getMiejsce_przylotu().getNazwa()+"("+lot.getTrasa().getMiejsce_przylotu().getKraj()+")"+
                    "\n"+lot.getRezerwacje();
        }
        return str;
    }

    public void dodajLot(Lot lt){ loty.add(lt); }

    public void dodajKlienta(Klient k){  //dodawanie klienta do systemu
        klienci.add(k);
    }

    public void usunKlienta(Klient k){   //usuwanie klienta z systemu
        klienci.remove(k);
    }

    public void dodajSamolot(Samolot s){    //dodawanie samolotu do systemu
        samoloty.add(s);
    }

    public void usunSamolot(Samolot s){ //usuwanie samolotu z systemu
        samoloty.remove(s);
    }

    public void dodajLotnisko(Lotnisko l){ lotniska.add(l); }   //dodawanie lotniska do systemu

    public void usunLotnisko(Lotnisko l){ lotniska.remove(l); } //usuwanie lotniska z systemu

    public void dodajTrase(Trasa t){ trasy.add(t); }    //dodawanie rasy do systemu

    public void usunTrase(Trasa t){ trasy.remove(t); }  //usuwanie trasy z systemu

    public List<Klient> getKlienci(){   //lista klientów w systemie
        return klienci;
    }

    public void utworzRezerwacje(Klient k,int ilosc, Lot lt){   //tworzenie rezerwacji dla klienta
        Rezerwacja r = new Rezerwacja(k,ilosc);
        rezerwacje.add(r);
        lt.dodajRezerwacje(r);
    }

    public void usunRezerwacje(Klient k,Lot lt){    //usuwanie rezerwacji dla klienta
        for(Rezerwacja rezerwacja : rezerwacje){
            if(rezerwacja.getKlient() == k){
                rezerwacje.remove(rezerwacja);
                loty.remove(rezerwacja);
                for(Lot lot : loty){
                    lot.usunRezerwacje(rezerwacja);
                }
            }
        }
    }

    public List<Lot> getLoty(){ //lista dostępnych lotów w systemie
        return loty;
    }
}
