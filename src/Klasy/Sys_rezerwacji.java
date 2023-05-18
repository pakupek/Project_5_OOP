package Klasy;
import java.util.ArrayList;
import java.util.List;
public class Sys_rezerwacji {

    private List<Rezerwacja> rezerwacje = new ArrayList<>();

    public void dodajRezerwacje(Rezerwacja r){  //dodawanie rezerwacji do systemu
        rezerwacje.add(r);
    }
    public void usunRezerwacje(Rezerwacja r){   //usuwanie rezerwacji z systemu
        rezerwacje.remove(r);
    }

    public String lista_rezerwacji(){   //wyświetlenie dostępnych rezerwacji
        String str = "";
        String tytul = "\t\tAktualne rezerwacje\nNr\t\tWłaściciel\t\tData\n";
        int i = 1;
        for(Rezerwacja rezerwacja : rezerwacje){
            str +=  "#"+ i + "\t"+rezerwacja.data_wlasciciel() + "\n";
            i++;
        }
        return tytul + str;
    }
}
