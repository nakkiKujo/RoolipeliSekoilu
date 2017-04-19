package juuri.sovelluslogiikka.peli;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    private Peli peli;

    @Before
    public void setUp() {
        this.peli = new Peli();
    }

    @Test
    public void aloituksessaLuodaanOikeanniminenHahmo() {
        peli.aloitaPeli("kalle");
        assertTrue(peli.getPelaajanHahmo().getNimi().equals("kalle"));
    }

    @Test
    public void hahmonLiikkuessaLoytyyNullTapahtuma() {
        peli.aloitaPeli("pekka");
        peli.getPelaajanHahmo().getSijainti().setSijainti(6, 8);
        peli.getLuolasto().asetaKaytava(5, 8);
        Tapahtuma loydettyTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("vasen");

        boolean arvo = false;
        if (loydettyTapahtuma == null) {
            arvo = true;
        }

        assertTrue(arvo);
    }

    @Test
    public void hahmonLiikkuessaLoytyyTapahtuma() {
        peli.aloitaPeli("pekka");
        peli.getPelaajanHahmo().getSijainti().setSijainti(4, 4);
        peli.getLuolasto().asetaHirvio(4, 5);

        Tapahtuma loydettyTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("alas");
        assertEquals(Tapahtuma.TAISTELU, loydettyTapahtuma.getKoodi());

        peli.getPelaajanHahmo().getSijainti().setSijainti(5, 5);
        peli.getLuolasto().asetaLukittuOvi(6, 5, "kulta-avain");

        loydettyTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("oikea");
        assertEquals(Tapahtuma.OVENAVAUS, loydettyTapahtuma.getKoodi());
    }

    @Test
    public void vaarallaSuunnallaNull() {
        peli.aloitaPeli("pekka");
        peli.getPelaajanHahmo().getSijainti().setSijainti(4, 4);
        Tapahtuma loydetty = peli.liikutaanJaEtsitaanTapahtumaa("vsen");

        boolean arvo = false;
        if (loydetty == null) {
            arvo = true;
        }

        assertTrue(arvo);
    }
}
