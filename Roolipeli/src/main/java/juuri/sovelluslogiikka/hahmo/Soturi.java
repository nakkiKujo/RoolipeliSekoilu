
package juuri.sovelluslogiikka.hahmo;

public class Soturi extends Hahmo {
    
    public Soturi(String nimi) {
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
