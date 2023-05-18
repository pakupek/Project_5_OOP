import Klasy.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Sys_rezerwacji sys = new Sys_rezerwacji();

        //tworzenie nowych pasażerów
        Pasazer p1 = new Pasazer("Adam","Akimowicz",533042402);
        Pasazer p2 = new Pasazer("Marcin","Malinowski",678233154);

        //tworzenie samolotu
        Samolot s1 = new Samolot("Boeing 447","Pasażerski",320,743);

        //tworzenie rezerwacji
        Rezerwacja r1 = new Rezerwacja(new Date(120,3,21,30,15),p1,1,s1);
        Rezerwacja r2 = new Rezerwacja(new Date(120,3,21,30,15),p2,1,s1);

        p2.dodajRezerwacje(r2);
        p1.dodajRezerwacje(r1);

        //dodawanie rezerwacji do systemu
        sys.dodajKlienta(p1);
        sys.dodajKlienta(p2);


        System.out.println(sys.lista_rezerwacji()); //lista rezerwacji w systemie
        System.out.println(r1.daneRezerwacji()+"\n\n"+r2.daneRezerwacji()); //wyswietlanie danych rezerwacji
        System.out.println(p1.danePasazera()+"\n\n"+p2.danePasazera()); //wypisanie danych pasażera
    }
}