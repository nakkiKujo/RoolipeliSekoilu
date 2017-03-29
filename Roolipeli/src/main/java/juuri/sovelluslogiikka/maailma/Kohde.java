
package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;

public abstract class Kohde {
    protected Sijainti sijainti;
    protected int koodi;
    protected String nimi;
    
    public Kohde() {
    }
    
    public int getKoodi() {
        return koodi;
    }
    
    @Override
    public boolean equals(Object o) {
        Kohde toinen = (Kohde) o;
        if(this.koodi == toinen.getKoodi()) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "Olet kohteessa: " + this.nimi;
    }
}
