
package juuri.sovelluslogiikka.hahmo;

public class Soturi extends Hahmo {
    
    public Soturi(String nimi) {
        super(nimi);
        this.ammatti = "soturi";
        this.voima = 6;
        this.taikaVoima = 0;
        this.elamaPisteet = 6;
        this.ketteryys = 2;
    }

    @Override
    public String getAmmatti() {
        return this.ammatti;
    }
}
