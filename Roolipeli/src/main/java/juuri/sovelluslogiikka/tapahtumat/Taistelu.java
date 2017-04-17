package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;

public class Taistelu implements Tapahtuma {
    
    private int koodi;
    private Kohde hirvio;

    public Taistelu(Kohde hirvio) {
        this.koodi = Tapahtuma.TAISTELU;
        this.hirvio = hirvio;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {

    }

}
