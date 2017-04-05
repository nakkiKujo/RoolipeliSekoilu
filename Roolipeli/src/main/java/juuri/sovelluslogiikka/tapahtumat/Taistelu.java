
package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;

public class Taistelu implements Tapahtuma {
    private Kohde hirvio;
    
    public Taistelu(Kohde hirvio) {
        this.hirvio = hirvio;
    }
    
    @Override
    public void aloitaTapahtuma(Hahmo hahmo) {
        
    }
    
}
