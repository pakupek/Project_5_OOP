package Klasy;

public class Lotnisko {
    private String Nazwa,Miejscowosc,Kraj;

    public Lotnisko(String nazwa,String miejcowosc,String kraj){
        this.Nazwa = nazwa;
        this.Miejscowosc = miejcowosc;
        this.Kraj = kraj;
    }

    public String getNazwa(){
        return this.Nazwa;
    }

    public String getMiejscowosc(){
        return this.Miejscowosc;
    }

    public String getKraj(){
        return this.Kraj;
    }

}
