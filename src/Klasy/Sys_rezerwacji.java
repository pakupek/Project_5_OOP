package Klasy;
import java.util.ArrayList;
import java.util.List;
public class Sys_rezerwacji {

    private List<Klient> klienci = new ArrayList<>();
    private List<Samolot> samoloty = new ArrayList<>();

    public void dodajKlienta(Klient k){  //dodawanie rezerwacji do systemu
        klienci.add(k);
    }

    public void dodajKlienta(Firma f){
        klienci.add(f);
    }
    public void usunKlienta(Klient k){   //usuwanie rezerwacji z systemu
        klienci.remove(k);
    }

    public String lista_rezerwacji(){   //wyświetlenie dostępnych rezerwacji
        String str = "";
        String str2 = "";
        String tytul = "\t\tAktualne rezerwacje\nNr\t\tWłaściciel\t\tData\n";
        int i = 1;
        for(Klient klient : klienci){
            if(klient instanceof Pasazer){
                for(Rezerwacja rezerwacja : klient.listaRezerwacji()){
                    str += "#"+i+"\t"+ rezerwacja.data_wlasciciel() + "\n";
                }
            }
            else if(klient instanceof Firma){
                for(Rezerwacja rezerwacja : klient.listaRezerwacji()){
                    str += "#"+i+"\t"+ ((Firma) klient).getNazwa()+ "\t"+ ((Firma) klient).getKRS()+ "\t"+rezerwacja.getData()+"\n";
                }
            }
            i++;
        }
        return tytul + str;
    }
    public List<Klient> getKlienci(){
        List l = new ArrayList<>();
        for(Klient klient : klienci){
            if(klient instanceof Klient){
                l.add(klient);
            }
            else if(klient instanceof Firma){
                l.add(klient);
            }
        }
        return l;
    }
}
