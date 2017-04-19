package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Taistelu on tapahtuma, joka liittyy pelaajan hahmon ja luolassa olevan hirviön kohtaamiseen.
 * Pelaaja voi yrittää paeta taistelusta. Voittaessaan pelaaja saa itselleen hirviön kantamat esineet.
 * Taistelu tapahtuu käyttäen apuna TaisteluLaskinta, jonka avulla selvitetään, kuka taistelun voittaa.
 */
public class Taistelu extends Tapahtuma {
    
    private Kohde hirvio;

    public Taistelu(Kohde hirvio) {
        this.koodi = Tapahtuma.TAISTELU;
        this.hirvio = hirvio;
    }
    /**
     * Metodi kysyy pelaajalta, tahtooko hän lähteä taistoo vai pyrkiä 
     * pakoon. Vaihtoehto yksi on taistella, vaihtoehto kaksi on pyrkiä pakoon.
     * @param hahmo pelaajan hahmo
     */
    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {
        this.tapahtumaTeksti = "Edessäsi on hirmuinen " + hirvio.getNimi() + "."
                + "\nTaisteluun!?";
        this.vaihtoehtoYksi = "Taistoon!!!";
        this.vaihtoehtoKaksi = "Yritän perääntyä.";
    }
    
    /**
     * Metodi aloittaa taistelun.
     * @param hahmo
     * @param luola 
     */
    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
       
        
        
        
        
    }
    
    /**
     * Metodi tapahtuu, kun hahmo yrittää välttyä taistelulta.
     * @param hahmo pelaajan hahmo
     * @param luola luolasto, jossa seikkaillaan
     */
    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
        
    }
    
    public void pelaajaLyo() {
        
    }

}
