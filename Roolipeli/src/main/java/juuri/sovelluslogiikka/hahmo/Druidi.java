
package juuri.sovelluslogiikka.hahmo;

public class Druidi extends Hahmo {
    
    public Druidi(String nimi) {
        super(nimi);
        this.ammatti = "druidi";
        this.voima = 3;
        this.elamaPisteet = 3;
        this.ketteryys = 5;
        this.taikaVoima = 3;
    }

    @Override
    public String getAmmatti() {
         return this.ammatti;
    }

    
    
}
