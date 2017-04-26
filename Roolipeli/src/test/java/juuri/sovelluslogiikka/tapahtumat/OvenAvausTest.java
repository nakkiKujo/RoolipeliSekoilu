package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.maailma.Ovi;
import juuri.sovelluslogiikka.peli.KohteidenLuoja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OvenAvausTest {

    private OvenAvaus avoin;
    private OvenAvaus lukittu;
    private Soturi hahmoAvaimella;
    private Soturi hahmoEiAvainta;
    private Ovi avoinOvi;
    private Ovi lukittuOvi;
    private Luolasto luola;

    @Before
    public void setUp() {
        this.luola = new Luolasto();
        luola.luoSeuraavaTaso();
        luola.asetaAvoinOvi(3, 3);
        luola.asetaLukittuOvi(4, 4, KohteidenLuoja.OVIPRONSSIAVAAJA);

        this.avoinOvi = (Ovi) luola.haeKoordinaateista(3, 3);
        this.avoin = (OvenAvaus) avoinOvi.getTapahtuma();

        this.lukittuOvi = (Ovi) luola.haeKoordinaateista(4, 4);
        this.lukittu = (OvenAvaus) lukittuOvi.getTapahtuma();

        this.hahmoAvaimella = new Soturi("pekka");
        hahmoAvaimella.getReppu().asetaEsineReppuun(Esine.PRONSSIAVAIN);

        this.hahmoEiAvainta = new Soturi("janne");
    }

    @Test
    public void valmisteleeAvoimenOikein() {
        avoin.valmisteleTapahtuma(hahmoAvaimella);
        assertTrue(avoin.getTapahtumateksti().equals("Edessäsi on " + avoinOvi.getNimi() + ". Ovi ei ole lukossa."));
        assertTrue(avoin.getVaihtoehtoYksi().equals("Avaa ovi."));
        assertTrue(avoin.getVaihtoehtoKaksi().equals("Älä avaa ovea."));
    }

    @Test
    public void valmisteleeLukitunOikeinAvaimellinen() {
        lukittu.valmisteleTapahtuma(hahmoAvaimella);
        assertTrue(lukittu.getTapahtumateksti().equals("Edessäsi on " + lukittuOvi.getNimi() + ". Sen avaamiseen tarvitset esineen: " + lukittuOvi.getAvaaja().getNimi()
                + "\nSinulta löytyy kyseinen avain."));
    }

    @Test
    public void valmisteleeLukitunOikeinAvaimeton() {
        lukittu.valmisteleTapahtuma(hahmoEiAvainta);
        assertTrue(lukittu.getTapahtumateksti().equals("Edessäsi on " + lukittuOvi.getNimi() + ". Sen avaamiseen tarvitset esineen: " + lukittuOvi.getAvaaja().getNimi()
                + "\nSinulla ei ole kyseistä avainta."));
    }

    @Test
    public void toteuttaaLukitunOikeinAvaimellinen() {
        lukittu.valmisteleTapahtuma(hahmoAvaimella);
        lukittu.toteutaVaihtoehtoYksi(hahmoAvaimella, luola);
        assertFalse(hahmoAvaimella.getReppu().onkoRepussa(new YleisEsine("kupariavain", Esine.AVAIN)));
        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(4, 4).getKoodi());
    }
    
    @Test
    public void toteuttaaLukitunOikeinAvaimeton() {
        lukittu.valmisteleTapahtuma(hahmoEiAvainta);
        lukittu.toteutaVaihtoehtoYksi(hahmoEiAvainta, luola);
        assertFalse(hahmoEiAvainta.getReppu().onkoRepussa(new YleisEsine("kupariavain", Esine.AVAIN)));
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(4, 4).getKoodi());
    }

    @Test
    public void toteuttaaAvoimenOikein() {
        avoin.valmisteleTapahtuma(hahmoAvaimella);
        avoin.toteutaVaihtoehtoYksi(hahmoAvaimella, luola);
        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(3, 3).getKoodi());
    }

}
