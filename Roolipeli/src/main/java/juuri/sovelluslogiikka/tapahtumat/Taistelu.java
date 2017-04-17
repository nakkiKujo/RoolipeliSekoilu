package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Taistelu on tapahtuma, joka liittyy pelaajan hahmon ja luolassa olevan hirviön kohtaamiseen.
 * Pelaaja voi yrittää paeta taistelusta. Voittaessaan pelaaja saa itselleen hirviön kantamat esineet.
 * Taistelu tapahtuu käyttäen apuna TaisteluLaskinta, jonka avulla selvitetään, kuka taistelun voittaa.
 * @author PenaJones
 */
public class Taistelu extends Tapahtuma {
    
    private int koodi;
    private Kohde hirvio;
    private Hahmo pelaajanHahmo;

    public Taistelu(Kohde hirvio) {
        this.koodi = Tapahtuma.TAISTELU;
        this.hirvio = hirvio;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {
        this.tapahtumaTeksti = "Edessäsi on hirmuinen " + hirvio.getNimi() + "."
                + "\nTaisteluun!?";
        this.vaihtoehtoYksi = "Taistoon!!!";
        this.vaihtoehtoKaksi = "Yritän perääntyä.";
    }

    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
        
    }

    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
