import Klasy.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sys_rezerwacji sys = new Sys_rezerwacji();

        //tworzenie nowych pasażerów
        Pasazer p1 = new Pasazer(1932,"Adam","Akimowicz",255437996,533042402);

        //tworzenie firmy
        Firma f1 = new Firma(8353,"Firma A","33216578");
        Firma f2 = new Firma(1,"Firma B","323257765");

        //tworzenie samolotu
        Samolot s1 = new Samolot("Samolot 1","Pasażerski",210,630);

        //tworzenie rezerwacji
        Rezerwacja r1 = new Rezerwacja(p1,1);

        //tworzenie lotniska
        Lotnisko l1 = new Lotnisko("Lotnisko Chopin'a","Warszawa","Polska");
        Lotnisko l2 = new Lotnisko("Lotnisko B","Kraków","Polska");

        //tworzenie trasy
        Trasa t1 = new Trasa(443,1540,l1,l2,180);

        //tworzenie lotu
        Lot lt1 = new Lot( new Random().nextInt(),s1,t1, LocalDateTime.now());


        //dodawanie danych do systemu
        sys.dodajKlienta(p1);
        sys.dodajKlienta(f1);
        sys.dodajKlienta(f2);
        sys.dodajSamolot(s1);
        sys.dodajTrase(t1);
        sys.dodajLot(lt1);

        sys.utworzRezerwacje(p1,2,lt1); //klient tworzy rezerwacje lotu

        System.out.println(sys.getKlienci());
        System.out.println(lt1.getCzas_odlotu());
        System.out.println("Loty:\n"+sys.getLoty());    //lista lotów
        System.out.println("Lista rezerwacji:\n"+sys.listaRezerwacji());    //lista rezerwacji
        System.out.println("Lista samolotów:\n"+sys.getSamoloty()); //lista amolotów
        sys.usunRezerwacje(p1,lt1); //Usuwanie rezerwacji klienta dla danego lotu
    }
}