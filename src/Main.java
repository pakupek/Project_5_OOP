import Klasy.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Sys_rezerwacji sys = new Sys_rezerwacji();

        //tworzenie nowych pasażerów
        Pasazer p1 = new Pasazer("Adam","Akimowicz",255437996,533042402);

        //tworzenie firmy




        //tworzenie samolotu


        //tworzenie rezerwacji


        //Rezerwacja r1 = new Rezerwacja(new Date(120,3,21,30,15),p1,1,s1);
        //Rezerwacja r2 = new Rezerwacja(new Date(120,3,21,30,15),p2,1,s1);


        //dodawanie rezerwacji do systemu
        sys.dodajKlienta(p1);



        System.out.println(sys.getKlienci()); //lista rezerwacji w systemie
        //System.out.println(r1.daneRezerwacji()+"\n\n"+r2.daneRezerwacji()); //wyswietlanie danych rezerwacji
        //System.out.println(p1.danePasazera()+"\n\n"+p2.danePasazera()); //wypisanie danych pasażera
        //System.out.println(sys.getKlienci());   //wyswietlenie wszystkich klientow z systemu
    }
}