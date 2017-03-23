
package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;

public abstract class Kohde {
    protected Sijainti sijainti;
    protected int koodi;
    
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
}
