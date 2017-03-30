
package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Ovi;

public class OvenAvaus implements Tapahtuma {
    //Jokainen OvenAvaus-tapahtuma tietää, mihin oveen se on kytkettynä.
    private Ovi ovi;
    
    public OvenAvaus(Ovi ovi) {
        this.ovi = ovi;
    }
    
    @Override
    public void aloitaTapahtuma(Hahmo pelaajanHahmo) {
        boolean onkoOviLukossa = ovi.onkoLukittu();
        
        if(onkoOviLukossa) {
            System.out.println("Ovi on lukossa, onko sinulla avainta? Ei ole BYYEEEE");
        }
    }
}
