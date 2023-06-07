import Klasy.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sys_rezerwacji sys = new Sys_rezerwacji();

        //tworzenie nowych pasażerów
        Pasazer p1 = new Pasazer("Adam","Akimowicz",255437996,533042402);

        //tworzenie firmy
        Firma f1 = new Firma("Firma A","33216578");



        //tworzenie samolotu
        Samolot s1 = new Samolot("Samolot 1","Pasażerski",210,630);

        //tworzenie rezerwacji
        Rezerwacja r1 = new Rezerwacja(p1,1);

        //Rezerwacja r1 = new Rezerwacja(new Date(120,3,21,30,15),p1,1,s1);
        //Rezerwacja r2 = new Rezerwacja(new Date(120,3,21,30,15),p2,1,s1);

        //tworzenie lotniska
        Lotnisko l1 = new Lotnisko("Lotnisko Chopin'a","Warszawa","Polska");
        Lotnisko l2 = new Lotnisko("Lotnisko B","Kraków","Polska");

        //tworzenie trasy
        Trasa t1 = new Trasa(443,1,l1,l2);

        //tworzenie lotu
        Lot lt1 = new Lot( new Random().nextInt(),s1,t1, LocalDateTime.now());
        lt1.dodajRezerwacje(r1);

        //dodawanie rezerwacji do systemu
        sys.dodajKlienta(p1);
        sys.dodajSamolot(s1);
        sys.dodajTrase(t1);


        System.out.println(sys.getKlienci()); //lista rezerwacji w systemie
        System.out.println(lt1.getCzas_odlotu());

        //System.out.println(r1.daneRezerwacji()+"\n\n"+r2.daneRezerwacji()); //wyswietlanie danych rezerwacji
        //System.out.println(p1.danePasazera()+"\n\n"+p2.danePasazera()); //wypisanie danych pasażera
        //System.out.println(sys.getKlienci());   //wyswietlenie wszystkich klientow z systemu
    }
}