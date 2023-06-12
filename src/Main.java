import Klasy.*;
import java.util.Scanner;

public class Main {
   /* public static void main(String[] args) {
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
    */
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

           switch(wybor1){
               case 1:
                   Scanner wybierz = new Scanner(System.in);
                   int wybor2;
                   do{
                       System.out.println("Dodaj pasażera - 1\nUsun pasażera - 2\nDodaj firme - 3\nUsun firme - 4\nLista klientów - 5\nWyjście - 0");
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
                            Firma f = new Firma(id,nazwa_firmy,krs);
                            systemRezerwacji.dodajKlienta(f);
                       }
                       if(wybor2==4){

                       }
                       if(wybor2==5){
                           System.out.println(systemRezerwacji.getListaKlientow());
                       }


                   }while (wybor2 !=0);

                   break;
               case 2: break;
               case 3: break;
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