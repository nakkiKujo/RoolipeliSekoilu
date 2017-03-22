
package juuri.sovelluslogiikka.hahmo;

public class Velho extends Hahmo {
    
    
    public Velho(String nimi) {
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
