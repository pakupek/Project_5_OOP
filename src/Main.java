import Klasy.*;
import java.util.Scanner;
import java.util.Locale;
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
           System.out.println("6.Exit");

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
                           System.out.println("Wprowadź imię pasażera:");
                           String imie = klient.nextLine();
                           System.out.println("Wprowadź nazwisko pasażera:");
                           String nazwisko = klient.nextLine();
                           System.out.println("Numer id: ");
                           int id = klient.nextInt();
                           System.out.println("Numer kontatkowy:");
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
                            System.out.println("Podaj KRS ");
                            String krs = firma.nextLine();
                            System.out.println("Podaj ID");
                            int id = firma.nextInt();
                            systemRezerwacji.dodajKlienta(new Firma(id,nazwa_firmy,krs));
                       }
                       if(wybor2==4){
                           System.out.println(systemRezerwacji.getListaKlientow());
                       }
                   }while (wybor2 !=0);

                   break;
               case 2:
                   do{
                       System.out.println("Dodaj trase - 1\nUsun trase - 2\nLista dostępnych tras - 3 \nWyjście - 0");
                       wybor2 = wybierz.nextInt();
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
                           System.out.println("Wprowadzony float: "+zasieg);
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
                           System.out.println(systemRezerwacji.getListaSamolotow());
                       }
                   }while(wybor2!=0);
                   break;
               case 4: break;
               case 5: break;
               case 6: kontynuacja=false; break;
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