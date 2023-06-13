package Klasy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sys_rezerwacji {
    private ArrayList<Klient> klienci = new ArrayList<>();
    private ArrayList<Samolot> samoloty = new ArrayList<>();
    private ArrayList<Trasa> trasy = new ArrayList<>();
    private ArrayList<Lotnisko> lotniska = new ArrayList<>();
    private ArrayList<Lot> loty = new ArrayList<>();
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<>();

    public ArrayList<Samolot> getListaSamolotow() {return this.samoloty;}

    public ArrayList<Lot> getListaLotow()
    {
        return this.loty;
    }

    public ArrayList<Trasa> getListaTras()
    {
        return this.trasy;
    }

    public ArrayList<Klient> getListaKlientow()
    {
        return this.klienci;
    }

    public ArrayList<Lotnisko> getListaLotnisk()
    {
        return this.lotniska;
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

    public void dodajLot(Lot lt){ loty.add(lt); }    //dodaje lot

    public void dodajKlienta(Klient k){  //dodawanie klienta do systemu
        klienci.add(k);
    }   //dodaje klienta

    public void usunKlienta(int idKlienta){   //usuwanie klienta z systemu
        Iterator<Klient> iterator = klienci.iterator();
        while(iterator.hasNext()){
            Klient klient = iterator.next();
            if(idKlienta == klient.getId()){
                iterator.remove();
            }
        }
    }

    public void pokazKlienta(){
        for(Klient klient: klienci){
            System.out.println(klient);
        }
    }

    public void dodajSamolot(Samolot s){    //dodawanie samolotu do systemu
        samoloty.add(s);
    }

    public void usunSamolot(String nazwaSamolotu){ //usuwanie samolotu z systemu
        Iterator<Samolot> iterator = samoloty.iterator();
        while(iterator.hasNext()){
            Samolot s = iterator.next();
            if(nazwaSamolotu.equals(s.getNazwa())){
                iterator.remove();
            }
        }
    }
    public void pokazSamoloty(){          //wyswietlenie samolotow
        for(Samolot samolot: samoloty){
            System.out.println(samolot);
        }
    }

    public void dodajLotnisko(Lotnisko l){ lotniska.add(l); }   //dodawanie lotniska do systemu

    public void usunLotnisko(String nazwaLotniska){     //usuwanie lotniska z systemu
        Iterator<Lotnisko> iterator = lotniska.iterator();
        while(iterator.hasNext()){
            Lotnisko lotnisko = iterator.next();
            if(lotnisko.getNazwa().equals(nazwaLotniska)){
                iterator.remove();
            }
        }
    }

    public void pokazLotniska(){            //wyswietl lotniska
        for(Lotnisko lotnisko: lotniska){
            System.out.println(lotnisko);
        }
    }

    public void dodajTrase(Trasa t){ trasy.add(t); }    //dodawanie rasy do systemu

    public void usunTrase(int idTrasy){     //usuwanie trasy z systemu
        Iterator<Trasa> iterator = trasy.iterator();
        while(iterator.hasNext()){
            Trasa trasa = iterator.next();
            if(trasa.getId()==idTrasy){
                iterator.remove();
            }
        }
    }

    public void pokazTrasy(){                    //wyswietl trase
        for(Trasa trasa: trasy){
            System.out.println(trasa);
        }
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

    void wczytajSamoloty() throws FileNotFoundException                //wczytywanie samolotow
    {
        File plikSamoloty = new File("listaSamolotow.txt");
        Scanner scanner = new Scanner(plikSamoloty);

        Samolot samolot;
        String l1,l2,l3,l4;
        while(scanner.hasNext())
        {
            l1 = scanner.nextLine();
            l2 = scanner.nextLine();
            l3 = scanner.nextLine();
            l4 = scanner.nextLine();

            samolot = new Samolot(l3,Integer.parseInt(l1),Float.parseFloat(l2));
            samoloty.add(samolot);
        }
        scanner.close();
    }
    void wczytajLoty() throws FileNotFoundException                         //wczytywanie lotow
    {
        File plikLot = new File("listaLotow.txt");
        Scanner scanner = new Scanner(plikLot);

        Lot lot;
        String l1,l2,l3,l4,l5;
        while(scanner.hasNext())
        {
            l1 = scanner.nextLine();
            l2 = scanner.nextLine();
            l3 = scanner.nextLine();
            l4 = scanner.nextLine();
            l5 = scanner.nextLine();

            Samolot naszSamolot = null;
            for(Samolot samolot : samoloty)
            {
                if(samolot.getNazwa().equals(l2))
                {
                    naszSamolot = samolot;
                }
            }
            Trasa naszaTrasa = null;
            for(Trasa trasa : trasy)
            {
                if(trasa.getId() == Integer.parseInt(l3))
                {
                    naszaTrasa = trasa;
                }
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            lot = new Lot(Integer.parseInt(l1),naszSamolot,naszaTrasa, LocalDateTime.parse(l4, formatter));
            loty.add(lot);
        }
        scanner.close();
    }
    void wczytajLotniska() throws FileNotFoundException                   //wczytywanie lotnisk
    {
        File plikLotnisko = new File("listaLotnisk.txt");
        Scanner scanner = new Scanner(plikLotnisko);

        String l1,l2,l3,l4;
        Lotnisko lotnisko;

        while(scanner.hasNext())
        {
            l1 = scanner.nextLine();
            l2 = scanner.nextLine();
            l3 = scanner.nextLine();
            l4 = scanner.nextLine();

            lotnisko = new Lotnisko(l1,l2,l3);
            lotniska.add(lotnisko);
        }
        scanner.close();
    }

    void wczytajKlientow() throws FileNotFoundException                //wczytywanie klientow
    {
        File plikKlient = new File("listaKlientow.txt");
        Scanner scanner = new Scanner(plikKlient);

        Firma firma;
        Pasazer pasazer;
        String l1,l2,l3,l4;
        int indeks;
        while(scanner.hasNext())
        {
            l1 = scanner.nextLine();
            l2 = scanner.nextLine();
            l3 = scanner.nextLine();
            l4 = scanner.nextLine();

            if(l3.length() == 10)
            {
                firma = new Firma(Integer.parseInt(l1),l2,l3);
                klienci.add((firma));
            }
            else if(l3.length()==9)
            {
                indeks = l2.indexOf(" ");
                pasazer = new Pasazer(Integer.parseInt(l1),l2.substring(0, indeks),l2.substring(indeks+1, l2.length()),Integer.parseInt(l3));
                klienci.add(pasazer);
            }
            else{
                System.out.println("Błędnie wprowadzone dane!");
            }
        }
        scanner.close();
    }
    void wczytajTrase() throws FileNotFoundException               //wczytywanie tras
    {
        File plikTrasa = new File("listaTras.txt");
        Scanner scanner = new Scanner(plikTrasa);

        Trasa trasa;
        String l1,l2,l3,l4,l5,l6;
        while(scanner.hasNext())
        {
            l1 = scanner.nextLine();
            l2 = scanner.nextLine();
            l3 = scanner.nextLine();
            l4 = scanner.nextLine();
            l5 = scanner.nextLine();
            l6 = scanner.nextLine();

            Lotnisko miejsceOdlotu = null, miejscePrzylotu = null;
            for(Lotnisko lotnisko : lotniska)
            {
                if(lotnisko.getNazwa().equals(l3))
                {
                    miejsceOdlotu = lotnisko;
                }
                if(lotnisko.getNazwa().equals(l4))
                {
                    miejscePrzylotu = lotnisko;
                }
            }

            trasa = new Trasa(Integer.parseInt(l1),Float.parseFloat(l2),
                    miejscePrzylotu,miejsceOdlotu,Integer.parseInt(l5));
            trasy.add(trasa);
        }
        scanner.close();
    }
    public void wczytaj() throws FileNotFoundException
    {
        wczytajKlientow();
        wczytajSamoloty();
        wczytajLotniska();
        wczytajTrase();
        wczytajLoty();
    }
    public void zapisz() throws FileNotFoundException {                              //zapis do plikow
        File plikSamoloty = new File("listaSamolotow.txt");
        PrintWriter writerSamoloty = new PrintWriter(plikSamoloty);

        for (Samolot samolot : samoloty) {
            writerSamoloty.println(samolot.wypisz());
        }
        writerSamoloty.close();

        File plikLoty = new File("listaLotow.txt");
        PrintWriter writerLoty = new PrintWriter(plikLoty);

        for (Lot lot : loty) {
            writerLoty.println(lot.wypisz());
        }
        writerLoty.close();

        File plikTrasy = new File("listaTras.txt");
        PrintWriter writerTrasy = new PrintWriter(plikTrasy);

        for (Trasa trasa : trasy) {
            writerTrasy.println(trasa.wypisz());
        }
        writerTrasy.close();

        File plikKlienci = new File("listaKlientow.txt");
        PrintWriter writerKlienci = new PrintWriter(plikKlienci);

        for (Klient klient : klienci) {
            writerKlienci.println(klient.wypisz());
        }
        writerKlienci.close();

        File plikLotniska = new File("listaLotnisk.txt");
        PrintWriter writerLotniska = new PrintWriter(plikLotniska);

        for (Lotnisko lotnisko : lotniska) {
            writerLotniska.println(lotnisko.wypisz());
        }
        writerLotniska.close();
    }

}
