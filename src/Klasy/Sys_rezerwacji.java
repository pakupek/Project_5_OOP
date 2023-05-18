package Klasy;
import java.util.ArrayList;
import java.util.List;
public class Sys_rezerwacji {

    private List<Klient> klienci = new ArrayList<>();

    public void dodajKlienta(Klient k){  //dodawanie rezerwacji do systemu
        klienci.add(k);
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
            else {
                str2 += "#"+i+"\t";
            }
            i++;
        }
        return tytul + str;
    }
}
