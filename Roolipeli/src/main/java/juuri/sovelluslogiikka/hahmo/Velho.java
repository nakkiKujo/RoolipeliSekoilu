package juuri.sovelluslogiikka.hahmo;

public class Velho extends Hahmo {

    public Velho(String nimi) {
        super(nimi);
        this.ammatti = "velho";
        this.voima = 1;
        this.taikaVoima = 6;
        this.elamaPisteet = 5;
        this.ketteryys = 2;
    }

    @Override
    public String ammatinKuvaus() {
        return "Velhot ovat ovelia, nokkelia taikuria. SIMSALA BIM!!";
    }
}
