import Klasy.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
   public static void main(String[] args) {
       Sys_rezerwacji systemRezerwacji = new Sys_rezerwacji();
       try {
           systemRezerwacji.wczytaj();
       } catch (Throwable t) {
           t.printStackTrace();
       }

       boolean kontynuacja = true;
       while(kontynuacja){
           System.out.println("----------MENU----------");
           System.out.println("1.Klienci");
           System.out.println("2.Trasy");
           System.out.println("3.Samoloty");
           System.out.println("4.Lotniska");
           System.out.println("5.Rezerwacja");
           System.out.println("6.Loty");
           System.out.println("7.Exit");

           Scanner scanner = new Scanner(System.in);
           String wybor;
           int wybor1;
           wybor = scanner.next();
           wybor1 = Integer.parseInt(wybor);
           Scanner wybierz = new Scanner(System.in);
           int wybor2;
           switch (wybor1) {
               case 1 -> {
                   do {
                       System.out.println("""
                       Dodaj pasażera - 1
                       Usun klienta - 2
                       Dodaj firme - 3
                       Lista klientów - 4
                       Wyjście - 0
                       """);
                       wybor2 = wybierz.nextInt();

                       if (wybor2 == 1) {
                           Scanner klient = new Scanner(System.in);
                           System.out.println("Wprowadź imię pasażera ");
                           String imie = klient.nextLine();
                           System.out.println("Wprowadź nazwisko pasażera ");
                           String nazwisko = klient.nextLine();
                           System.out.println("Numer id ");
                           int id = klient.nextInt();
                           System.out.println("Numer kontatkowy (9 cyfr) ");
                           int nr_telefonu = klient.nextInt();
                           Pasazer p = new Pasazer(id, imie, nazwisko, nr_telefonu);
                           systemRezerwacji.dodajKlienta(p);
                       }
                       if (wybor2 == 2) {
                           Scanner klient = new Scanner(System.in);
                           System.out.println("Podaj ID klienta do usuniecia: ");
                           int id = klient.nextInt();
                           systemRezerwacji.usunKlienta(id);
                       }
                       if (wybor2 == 3) {
                           Scanner firma = new Scanner(System.in);
                           System.out.println("Podaj nazwę firmy ");
                           String nazwa_firmy = firma.nextLine();
                           System.out.println("Podaj KRS (10 cyfr) ");
                           String krs = firma.nextLine();
                           System.out.println("Podaj ID ");
                           int id = firma.nextInt();
                           systemRezerwacji.dodajKlienta(new Firma(id, nazwa_firmy, krs));
                       }
                       if (wybor2 == 4) {
                           systemRezerwacji.pokazKlienta();
                       }
                   } while (wybor2 != 0);
               }
               case 2 -> {
                   do {
                       System.out.println("""
                       Dodaj trase - 1
                       Usun trase - 2
                       Lista dostępnych tras - 3
                       Wyjście - 0
                       """);
                       wybor2 = wybierz.nextInt();
                       if (wybor2 == 1) {
                           Scanner trasa = new Scanner(System.in);
                           trasa.useLocale(Locale.US);
                           if (systemRezerwacji.getListaLotnisk().isEmpty()) {
                               System.out.println("Wprowadź dane lotniska poczatkowego\nNazwa Lotniska");
                               String nazwa_lotniska = trasa.nextLine();
                               System.out.println("Miejscowość w której znajduje się lotnisko ");
                               String miejscowosc = trasa.nextLine();
                               System.out.println("Podaj kraj w którym znajduje się lotnisko");
                               String kraj = trasa.nextLine();
                               Lotnisko lp = new Lotnisko(nazwa_lotniska, miejscowosc, kraj);
                               System.out.println("Wprowadź dane lotniska końcowego\nNazwa Lotniska");
                               nazwa_lotniska = trasa.nextLine();
                               System.out.println("Miejscowość w której znajduje się lotnisko ");
                               miejscowosc = trasa.nextLine();
                               System.out.println("Podaj kraj w którym znajduje się lotnisko");
                               kraj = trasa.nextLine();
                               Lotnisko lk = new Lotnisko(nazwa_lotniska, miejscowosc, kraj);
                               System.out.println("Podaj odległość między lotniskami");
                               float odleglosc = trasa.nextFloat();
                               System.out.println("Podaj czas trwania lotu (w minutach)");
                               int czas = trasa.nextInt();
                               System.out.println("Podaj id trasy");
                               int id = trasa.nextInt();
                               Trasa t = new Trasa(id, odleglosc, lp, lk, czas);
                               systemRezerwacji.dodajLotnisko(lp);
                               systemRezerwacji.dodajLotnisko(lk);
                               systemRezerwacji.dodajTrase(t);
                           } else {
                               System.out.println("Lista dostępnych lotnisk");
                               systemRezerwacji.pokazLotniska();
                               System.out.println("Wybierz lotnisko początkowe");
                               String nazwa = trasa.nextLine();
                               ArrayList<Lotnisko> lotniska = systemRezerwacji.getListaLotnisk();
                               Lotnisko lotn_pocz = null, lotn_kon = null;
                               for (Lotnisko lotnisko : lotniska) {
                                   if (lotnisko.getNazwa().equals(nazwa)) {
                                       lotn_pocz = new Lotnisko(lotnisko);
                                       break;
                                   }
                               }
                               System.out.println("Wybierz lotnisko końcowe");
                               nazwa = trasa.nextLine();
                               for (Lotnisko lotnisko : lotniska) {
                                   if (lotnisko.getNazwa().equals(nazwa)) {
                                       lotn_kon = new Lotnisko(lotnisko);
                                       break;
                                   }
                               }
                               System.out.println("Podaj odległość między lotniskami");
                               float odleglosc = trasa.nextFloat();
                               System.out.println("Podaj czas trwania lotu (w minutach)");
                               int czas = trasa.nextInt();
                               System.out.println("Podaj id trasy");
                               int id = trasa.nextInt();
                               Trasa t = new Trasa(id, odleglosc, lotn_pocz, lotn_kon, czas);
                               systemRezerwacji.dodajTrase(t);
                           }
                       }
                       if (wybor2 == 2) {
                           Scanner trasa = new Scanner(System.in);
                           System.out.println("Podaj id trasy do usunięcia");
                           int id = trasa.nextInt();
                           systemRezerwacji.usunTrase(id);
                       }
                       if (wybor2 == 3) {
                           systemRezerwacji.pokazTrasy();
                       }
                   } while (wybor2 != 0);
               }
               case 3 -> {
                   do {
                       System.out.println("""
                       Dodaj samolot - 1
                       Usun samolot - 2
                       Lista samolotów - 3
                       Wyjście - 0
                       """);
                       wybor2 = wybierz.nextInt();
                       if (wybor2 == 1) {
                           Scanner s = new Scanner(System.in);
                           s.useLocale(Locale.US);
                           System.out.println("Podaj nazwe samolotu ");
                           String nazwa_samolotu = s.nextLine();
                           System.out.println("Podaj ilość dostępnych miejsc w samolocie ");
                           int ilosc_miejsc = s.nextInt();
                           System.out.println("Podaj zasięg samolotu ");
                           float zasieg;
                           zasieg = s.nextFloat();
                           Samolot samolot = new Samolot(nazwa_samolotu, ilosc_miejsc, zasieg);
                           systemRezerwacji.dodajSamolot(samolot);
                       }
                       if (wybor2 == 2) {
                           Scanner samolot = new Scanner(System.in);
                           System.out.println("Podaj nazwę samolotu do usunięcia ");
                           String nazwa_samolotu = samolot.nextLine();
                           systemRezerwacji.usunSamolot(nazwa_samolotu);


                       }
                       if (wybor2 == 3) {
                           systemRezerwacji.pokazSamoloty();
                       }
                   } while (wybor2 != 0);
               }
               case 4 -> {
                   do {
                       System.out.println("""
                       Dodaj lotnisko - 1
                       Usun lotnisko - 2
                       Lista dostępnych lotnisk - 3
                       Wyjście - 0
                       """);
                       wybor2 = wybierz.nextInt();
                       if (wybor2 == 1) {
                           Scanner lotnisko = new Scanner(System.in);
                           System.out.println("Podaj nazwę lotniska");
                           String nazwa = lotnisko.nextLine();
                           System.out.println("Podaj miejscowość w której znajduje się lotnisko");
                           String miejsce = lotnisko.nextLine();
                           System.out.println("Podaj kraj w którym znajduje się lotnisko");
                           String kraj = lotnisko.nextLine();
                           Lotnisko l = new Lotnisko(nazwa, miejsce, kraj);
                           systemRezerwacji.dodajLotnisko(l);
                       }
                       if (wybor2 == 2) {
                           Scanner lotnisko = new Scanner(System.in);
                           System.out.println("Podaj nazwę lotniska do usunięcia");
                           String nazwa = lotnisko.nextLine();
                           systemRezerwacji.usunLotnisko(nazwa);
                       }
                       if (wybor2 == 3) {
                           systemRezerwacji.pokazLotniska();
                       }
                   } while (wybor2 != 0);
               }
               case 5 -> {
                   do {
                       System.out.println("""
                               Dodaj rezerwacje dla pasażera - 1
                               Usun rezerwację dla pasażera - 2
                               Dodaj rezerwację dla firmy - 3
                               Usun rezerwacje dla firmy - 4
                               Lista rezerwacji - 5
                               Wyjście - 0
                               """);
                       wybor2 = wybierz.nextInt();
                       if (wybor2 == 1) {
                           Scanner sc = new Scanner(System.in);
                           System.out.println("Podaj miejsce początku lotu: ");
                           String pocz = sc.nextLine();
                           System.out.println("Podaj docelowe miejsce lotu");
                           String kon = sc.nextLine();
                           System.out.println("Podaj dane pasażera:\nWprowadź imie i nazwisko");
                           String dane = sc.nextLine();
                           Pasazer p = null;
                           for(Klient pasazer : systemRezerwacji.getListaKlientow()){
                               if(pasazer.getNazwa().equals(dane)){
                                   p = new Pasazer((Pasazer) pasazer);
                               }
                           }
                           System.out.println("Podaj ilość miejsc");
                           int miejsca = sc.nextInt();
                           Rezerwacja r = new Rezerwacja(p, miejsca);
                           if (!systemRezerwacji.getListaLotow().isEmpty()) {
                               for (Lot lot : systemRezerwacji.getListaLotow()) {
                                   if (lot.getTrasa().getMiejsce_odlotu().getMiejscowosc().equals(pocz) && lot.getTrasa().getMiejsce_przylotu().getMiejscowosc().equals(kon)) {
                                       lot.dodajRezerwacje(r);
                                       break;
                                   }
                               }
                           }
                       }
                       if (wybor2 == 2) {
                           Scanner pasazer = new Scanner(System.in);
                           System.out.println("Podaj imie i nazwisko pasażera aby usunąć dla niego bilety");
                           String dane = pasazer.nextLine();
                           for (Lot lot : systemRezerwacji.getListaLotow()) {
                               for (Rezerwacja rezerwacja : lot.getRezerwacje()) {
                                   Klient k = rezerwacja.getKlient();
                                   if (k.getNazwa().equals(dane)) {
                                       lot.usunRezerwacje(rezerwacja);
                                       break;
                                   }
                               }
                           }
                       }
                       if (wybor2 == 3) {
                           Firma firma1 = null;
                           Scanner f = new Scanner(System.in);
                           System.out.println("Podaj nazwę firmy aby dodać rezerwację");
                           String nazwa = f.nextLine();
                           for(Klient firma : systemRezerwacji.getListaKlientow()){
                               if(firma.getNazwa().equals(nazwa)){
                                   firma1 = new Firma((Firma) firma);
                                   break;
                               }
                           }
                           System.out.println("Podaj miejsce początku lotu: ");
                           String pocz = f.nextLine();
                           System.out.println("Podaj docelowe miejsce lotu");
                           String kon = f.nextLine();
                           System.out.println("Podaj ilość miejsc");
                           int miejsca = f.nextInt();
                           Rezerwacja r = new Rezerwacja(firma1,miejsca);

                           if (!systemRezerwacji.getListaLotow().isEmpty()) {
                               for (Lot lot : systemRezerwacji.getListaLotow()) {
                                   if (lot.getTrasa().getMiejsce_odlotu().getMiejscowosc().equals(pocz) && lot.getTrasa().getMiejsce_przylotu().getMiejscowosc().equals(kon)) {
                                       lot.dodajRezerwacje(r);
                                       break;
                                   }
                               }
                           }
                       }
                       if (wybor2 == 4){
                           Scanner firma = new Scanner(System.in);
                           System.out.println("Podaj nazwę firmy aby usunąć rezerwację");
                           String nazwa = firma.nextLine();
                           for (Lot lot : systemRezerwacji.getListaLotow()) {
                               for (Rezerwacja rezerwacja : lot.getRezerwacje()) {
                                   Klient k = rezerwacja.getKlient();
                                   if (k.getNazwa().equals(nazwa)) {
                                       lot.usunRezerwacje(rezerwacja);
                                       break;
                                   }
                               }
                           }
                       }
                       if (wybor2 == 5){
                           System.out.println("Lista aktualnych rezerwacji:\n"+systemRezerwacji.listaRezerwacji());
                       }
                   } while (wybor2 != 0);
               }
               case 6 -> {
                   do {
                       System.out.println("""
                               Generuj loty - 1
                               Wyświetl listę dostępnych lotów - 2
                               Wyjście - 0
                               """);
                       wybor2 = wybierz.nextInt();
                       if (wybor2 == 1) {
                           List<Trasa> trasy = new ArrayList<>(systemRezerwacji.getListaTras());
                           Iterator<Trasa> iter_trasa = trasy.iterator();
                           List<Samolot> samoloty = new ArrayList<>(systemRezerwacji.getListaSamolotow());
                           Iterator<Samolot> iter_samolot = samoloty.iterator();
                           int day = ThreadLocalRandom.current().nextInt(1, 29);
                           int month = ThreadLocalRandom.current().nextInt(1, 13);
                           int year = ThreadLocalRandom.current().nextInt(2023, 2025);
                           int hour = ThreadLocalRandom.current().nextInt(0, 24);
                           int minute = ThreadLocalRandom.current().nextInt(0, 60);
                           int sec = ThreadLocalRandom.current().nextInt(0, 60);

                           LocalDate data = LocalDate.of(year, month, day);
                           LocalTime time = LocalTime.of(hour, minute, sec);
                           LocalDateTime czas = LocalDateTime.of(data, time);

                           while (iter_trasa.hasNext()) {
                               Trasa trasa = iter_trasa.next();
                               while (iter_samolot.hasNext()) {
                                   Samolot samolot = iter_samolot.next();
                                   if (samolot.getZasieg() > trasa.getDystans()) {
                                       Lot l = new Lot(trasa.getId(), samolot, trasa, czas);
                                       systemRezerwacji.dodajLot(l);
                                       iter_samolot.remove();
                                       break;
                                   }
                               }
                               iter_trasa.remove();
                           }
                       }
                       if (wybor2 == 2) {
                           System.out.println(systemRezerwacji.getListaLotow());
                       }
                   } while (wybor2 != 0);
               }
               case 7 -> kontynuacja = false;
               default -> System.out.println("Nieprawidłowy wybór!\n");
           }
       }

       try{
           systemRezerwacji.zapisz();
       } catch (Throwable t) {
           t.printStackTrace();
       }
   }


}