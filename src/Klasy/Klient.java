package Klasy;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    List<Rezerwacja> rezerwacje = new ArrayList<>();
    public void dodajRezerwacje(Rezerwacja r){
        rezerwacje.add(r);
    }

    public void usunRezerwacje(Rezerwacja r){
        rezerwacje.remove(r);
    }

    public  List<Rezerwacja> listaRezerwacji(){
        return rezerwacje;
    }
    public String toString(){
        return "";
    }


}
