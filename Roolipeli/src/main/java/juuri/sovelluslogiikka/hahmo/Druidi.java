
package juuri.sovelluslogiikka.hahmo;

public class Druidi extends Hahmo {
    
    public Druidi(String nimi) {
        super(nimi);
    }

    @Override
    public void setAmmatti(String am) {
        this.ammatti = am;
    }

    @Override
    public String getAmmatti() {
         return this.ammatti;
    }
    
    
}
