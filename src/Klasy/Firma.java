package Klasy;

public class Firma extends Klient{
    private String Nazwa,KRS;

    public Firma(String nazwa,String krs){
        this.Nazwa = nazwa;
        this.KRS = krs;
    }

    public String getNazwa(){
        return this.Nazwa;
    }
    @Override
    public String toString(){
        return "Nazwa: " + this.Nazwa + "\tKRS: " + this.KRS;
    }

    public String getKRS(){
        return this.KRS;
    }
}
