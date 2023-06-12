package Klasy;

public class Lotnisko {
    private String Nazwa,Miejscowosc,Kraj;

    public Lotnisko(String nazwa,String miejcowosc,String kraj){
        this.Nazwa = nazwa;
        this.Miejscowosc = miejcowosc;
        this.Kraj = kraj;
    }
    public Lotnisko(Lotnisko lotnisko)
    {
        this.Nazwa=lotnisko.Nazwa;
        this.Miejscowosc=lotnisko.Miejscowosc;
        this.Kraj= lotnisko.Kraj;
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

    public String wypisz()
    {
        return Nazwa + "\n" + Miejscowosc + "\n" + Kraj + "\n";
    }

    @Override
    public String toString() {
        return "Lotnisko{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Miejscowosc='" + Miejscowosc + '\'' +
                ", Kraj='" + Kraj + '\'' +
                '}';
    }
}
