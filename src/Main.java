import Klasy.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
           switch(wybor1){
               case 1:
                   do{
                       System.out.println("Dodaj pasażera - 1\nUsun klienta - 2\nDodaj firme - 3\nLista klientów - 4\nWyjście - 0");
                       wybor2 = wybierz.nextInt();

                       if(wybor2==1){
                           Scanner klient = new Scanner(System.in);
                           System.out.println("Wprowadź imię pasażera ");
                           String imie = klient.nextLine();
                           System.out.println("Wprowadź nazwisko pasażera ");
                           String nazwisko = klient.nextLine();
                           System.out.println("Numer id ");
                           int id = klient.nextInt();
                           System.out.println("Numer kontatkowy (9 cyfr) ");
                           int nr_telefonu = klient.nextInt();
                           Pasazer p = new Pasazer(id,imie,nazwisko,nr_telefonu);
                           systemRezerwacji.dodajKlienta(p);
                       }
                       if(wybor2==2){
                           Scanner klient = new Scanner(System.in);
                           System.out.println("Podaj ID klienta do usuniecia: ");
                           int id = klient.nextInt();
                           systemRezerwacji.usunKlienta(id);
                       }
                       if(wybor2==3){
                            Scanner firma = new Scanner(System.in);
                            System.out.println("Podaj nazwę firmy ");
                            String nazwa_firmy = firma.nextLine();
                            System.out.println("Podaj KRS (10 cyfr) ");
                            String krs = firma.nextLine();
                            System.out.println("Podaj ID ");
                            int id = firma.nextInt();
                            systemRezerwacji.dodajKlienta(new Firma(id,nazwa_firmy,krs));
                       }
                       if(wybor2==4){
                           systemRezerwacji.pokazKlienta();
                       }
                   }while (wybor2 !=0);

                   break;
               case 2:
                   do{
                       System.out.println("Dodaj trase - 1\nUsun trase - 2\nLista dostępnych tras - 3 \nWyjście - 0");
                       wybor2 = wybierz.nextInt();
                       if(wybor2==1){
                           Scanner trasa = new Scanner(System.in);
                           trasa.useLocale(Locale.US);
                           if(systemRezerwacji.getListaLotnisk().isEmpty()){
                               System.out.println("Wprowadź dane lotniska poczatkowego\nNazwa Lotniska");
                               String nazwa_lotniska = trasa.nextLine();
                               System.out.println("Miejscowość w której znajduje się lotnisko ");
                               String miejscowosc = trasa.nextLine();
                               System.out.println("Podaj kraj w którym znajduje się lotnisko");
                               String kraj = trasa.nextLine();
                               Lotnisko lp = new Lotnisko(nazwa_lotniska,miejscowosc,kraj);
                               System.out.println("Wprowadź dane lotniska końcowego\nNazwa Lotniska");
                               nazwa_lotniska = trasa.nextLine();
                               System.out.println("Miejscowość w której znajduje się lotnisko ");
                               miejscowosc = trasa.nextLine();
                               System.out.println("Podaj kraj w którym znajduje się lotnisko");
                               kraj = trasa.nextLine();
                               Lotnisko lk = new Lotnisko(nazwa_lotniska,miejscowosc,kraj);
                               System.out.println("Podaj odległość między lotniskami");
                               float odleglosc = trasa.nextFloat();
                               System.out.println("Podaj czas trwania lotu (w minutach)");
                               int czas = trasa.nextInt();
                               System.out.println("Podaj id trasy");
                               int id = trasa.nextInt();
                               Trasa t = new Trasa(id,odleglosc,lp,lk,czas);
                               systemRezerwacji.dodajLotnisko(lp);
                               systemRezerwacji.dodajLotnisko(lk);
                               systemRezerwacji.dodajTrase(t);
                           }
                           else{
                               System.out.println("Lista dostępnych lotnisk");
                               systemRezerwacji.pokazLotniska();
                               System.out.println("Wybierz lotnisko początkowe");
                               String nazwa = trasa.nextLine();
                               ArrayList<Lotnisko> lotniska = systemRezerwacji.getListaLotnisk();
                               Lotnisko lotn_pocz=null,lotn_kon=null;
                               for(Lotnisko lotnisko : lotniska){
                                   if(lotnisko.getNazwa().equals(nazwa)){
                                       lotn_pocz = new Lotnisko(lotnisko);
                                       break;
                                   }
                               }
                               System.out.println("Wybierz lotnisko końcowe");
                               nazwa = trasa.nextLine();
                               for(Lotnisko lotnisko : lotniska){
                                   if(lotnisko.getNazwa().equals(nazwa)){
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
                               Trasa t = new Trasa(id,odleglosc,lotn_pocz,lotn_kon,czas);
                               systemRezerwacji.dodajTrase(t);
                           }
                       }
                       if(wybor2==2){
                            Scanner trasa = new Scanner(System.in);
                            System.out.println("Podaj id trasy do usunięcia");
                            int id = trasa.nextInt();
                            systemRezerwacji.usunTrase(id);
                       }
                       if(wybor2==3){
                           systemRezerwacji.pokazTrasy();
                       }
                   }while(wybor2!=0);
                   break;
               case 3:
                   do {
                       System.out.println("Dodaj samolot - 1\nUsun samolot - 2\nLista samolotów - 3 \nWyjście - 0");
                       wybor2 = wybierz.nextInt();
                       if(wybor2==1){
                           Scanner s = new Scanner(System.in);
                           s.useLocale(Locale.US);
                           System.out.println("Podaj nazwe samolotu ");
                           String nazwa_samolotu = s.nextLine();
                           System.out.println("Podaj ilość dostępnych miejsc w samolocie ");
                           int ilosc_miejsc = s.nextInt();
                           System.out.println("Podaj zasięg samolotu ");
                           float zasieg;
                           zasieg = s.nextFloat();
                           Samolot samolot = new Samolot(nazwa_samolotu,ilosc_miejsc,zasieg);
                           systemRezerwacji.dodajSamolot(samolot);
                       }
                       if(wybor2==2){
                           Scanner samolot = new Scanner(System.in);
                           System.out.println("Podaj nazwę samolotu do usunięcia ");
                           String nazwa_samolotu = samolot.nextLine();
                           systemRezerwacji.usunSamolot(nazwa_samolotu);


                       }
                       if(wybor2==3){
                           systemRezerwacji.pokazSamoloty();
                       }
                   }while(wybor2!=0);
                   break;
               case 4:
                   do{
                       System.out.println("Dodaj lotnisko - 1\nUsun lotnisko - 2\nLista dostępnych lotnisk - 3 \nWyjście - 0");
                       wybor2 = wybierz.nextInt();
                       if(wybor2==1){
                           Scanner lotnisko = new Scanner(System.in);
                           System.out.println("Podaj nazwę lotniska");
                           String nazwa = lotnisko.nextLine();
                           System.out.println("Podaj miejscowość w której znajduje się lotnisko");
                           String miejsce = lotnisko.nextLine();
                           System.out.println("Podaj kraj w którym znajduje się lotnisko");
                           String kraj = lotnisko.nextLine();
                           Lotnisko l = new Lotnisko(nazwa,miejsce,kraj);
                           systemRezerwacji.dodajLotnisko(l);
                       }
                       if(wybor2==2){
                            Scanner lotnisko = new Scanner(System.in);
                            System.out.println("Podaj nazwę lotniska do usunięcia");
                            String nazwa = lotnisko.nextLine();
                            systemRezerwacji.usunLotnisko(nazwa);
                       }
                       if(wybor2==3){
                            systemRezerwacji.pokazLotniska();
                       }
                   }while(wybor2!=0);
                   break;
               case 5:
                   do{
                       System.out.println("Dodaj rezerwacje dla pasażera - 1\nUsun rezerwację dla pasażera - 2" +
                               "\nDodaj rezerwację dla firmy - 3 \nUsun rezerwacje dla firmy - 4\nWyjście - 0");
                       wybor2 = wybierz.nextInt();
                       if(wybor2==1){
                           Scanner pasazer = new Scanner(System.in);
                           System.out.println("Podaj dane pasażera:\nWprowadź imie");
                           String imie = pasazer.nextLine();
                           System.out.println("Podaj nazwisko");
                           String nazwisko = pasazer.nextLine();
                           System.out.println("Podaj numer kontaktowy (9 cyfr)");
                           int nr_tel = pasazer.nextInt();
                           System.out.println("Podaj ID");
                           int id = pasazer.nextInt();
                           Pasazer p = new Pasazer(id,imie,nazwisko,nr_tel);
                           System.out.println("Podaj ilość miejsc");
                           int miejsca = pasazer.nextInt();
                           Rezerwacja r = new Rezerwacja(p,miejsca);

                       }
                       if(wybor2==2){

                       }
                       if(wybor2==3){

                       }
                   }while(wybor2!=0);
                   break;
               case 6:
                   do{
                       System.out.println("Generuj loty - 1\nWyświetl listę dostępnych lotów - 2" + "\nWyjście - 0");
                       wybor2 = wybierz.nextInt();
                       if(wybor2==1){
                           List<Trasa> trasy = new ArrayList<>(systemRezerwacji.getListaTras());
                           Iterator<Trasa> iter_trasa = trasy.iterator();
                           List<Samolot> samoloty = new ArrayList<>(systemRezerwacji.getListaSamolotow());
                           Iterator<Samolot> iter_samolot = samoloty.iterator();
                           int day = ThreadLocalRandom.current().nextInt(1, 29);
                           int month = ThreadLocalRandom.current().nextInt(1,13);
                           int year = ThreadLocalRandom.current().nextInt(2023,2025);
                           int hour = ThreadLocalRandom.current().nextInt(0,24);
                           int minute = ThreadLocalRandom.current().nextInt(0,60);
                           int sec = ThreadLocalRandom.current().nextInt(0,60);

                           LocalDate data = LocalDate.of(year,month,day);
                           LocalTime time = LocalTime.of(hour,minute,sec);
                           LocalDateTime czas = LocalDateTime.of(data,time);

                           while(iter_trasa.hasNext()){
                               Trasa trasa = iter_trasa.next();
                               while(iter_samolot.hasNext()){
                                   Samolot samolot = iter_samolot.next();
                                   if(samolot.getZasieg()>trasa.getDystans()){
                                       Lot l = new Lot(trasa.getId(), samolot,trasa,czas);
                                       systemRezerwacji.dodajLot(l);
                                       iter_samolot.remove();
                                       break;
                                   }
                               }
                               iter_trasa.remove();
                           }
                       }
                       if(wybor2==2){
                           System.out.println(systemRezerwacji.getListaLotow());
                       }
                   }while(wybor2!=0);

                   break;
               case 7: kontynuacja=false; break;
               default: System.out.println("Nieprawidłowy wybór!\n");
           }
       }

       try{
           systemRezerwacji.zapisz();
       } catch (Throwable t) {
           t.printStackTrace();
       }
   }


}