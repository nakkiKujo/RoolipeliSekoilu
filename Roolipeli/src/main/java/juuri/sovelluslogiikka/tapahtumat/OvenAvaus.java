package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Ovi;

public class OvenAvaus implements Tapahtuma {

    //Jokainen OvenAvaus-tapahtuma tietää, mihin oveen se on kytkettynä.
    private Ovi ovi;
    private int koodi;
    
    public OvenAvaus(Ovi ovi) {
        this.koodi = Tapahtuma.OVENAVAUS;
        this.ovi = ovi;
    }

    @Override
    public void aloitaTapahtuma(Hahmo pelaajanHahmo) {
        boolean onkoOviLukossa = ovi.onkoLukittu();
    }
}
