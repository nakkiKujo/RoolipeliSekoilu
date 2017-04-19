package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmonliikuttajaTest {

    private Hahmo hahmo;
    private Luolasto luola;
    private Hahmonliikuttaja liikuttaja;

    @Before
    public void setUp() {
        this.liikuttaja = new Hahmonliikuttaja();
        this.hahmo = new Soturi("Janne");
        
        this.luola = new Luolasto();
        luola.luoTaso1();
    }

    @Test
    public void hahmonLiikuttaminenVaarallaKomennollaOnNull() {
        String komento = "vase";
        Kohde kk = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        boolean onkoTosi = true;
        if (!(kk == null)) {
            onkoTosi = false;
        }

        assertTrue(onkoTosi);
    }

    @Test
    public void hahmonLiikuttaminenAlas() {
        luola.asetaAarre(1, 2, "pekan aarre");
        String komento = "alas";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.AARRE, loydettyKohde.getKoodi());
        assertEquals("pekan aarre", loydettyKohde.getNimi());
        Sijainti eiLiikkunut = new Sijainti();
        eiLiikkunut.setSijainti(1, 1);
        assertEquals(eiLiikkunut, hahmo.getSijainti());
        
        luola.asetaKaytava(1, 2);
        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        Sijainti liikkui = new Sijainti();
        liikkui.setSijainti(1, 2);
        assertEquals(liikkui, hahmo.getSijainti());
    }

    @Test
    public void hahmonLiikuttaminenOikealle() {
        String komento = "oikea";
        
        luola.asetaLukittuOvi(2, 1, "avain");
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.OVI, loydettyKohde.getKoodi());
        Sijainti eiLiikkunut = new Sijainti();
        eiLiikkunut.setSijainti(1, 1);
        assertEquals(eiLiikkunut, hahmo.getSijainti());
        
        luola.asetaKaytava(2, 1);
        luola.asetaKaytava(3, 1);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        Sijainti liikkui = new Sijainti();
        liikkui.setSijainti(3, 1);
        assertEquals(liikkui, hahmo.getSijainti());
    }

    @Test
    public void hahmonLiikuttaminenYlos() {
        String komento = "ylös";
        
        luola.asetaHirvio(1, 0);
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.HIRVIO, loydettyKohde.getKoodi());
        Sijainti eiLiikkunut = new Sijainti();
        eiLiikkunut.setSijainti(1, 1);
        assertEquals(eiLiikkunut, hahmo.getSijainti());
        
        luola.asetaKaytava(1, 0);
        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        Sijainti liikkui = new Sijainti();
        liikkui.setSijainti(1, 0);
        assertEquals(liikkui, hahmo.getSijainti());
    }

    @Test
    public void hahmonLiikuttaminenVasemmalle() {
        String komento = "vasen";
        
        luola.asetaLukittuOvi(0, 1, "kulta-avain");
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.OVI, loydettyKohde.getKoodi());
        Sijainti eiLiikkunut = new Sijainti();
        eiLiikkunut.setSijainti(1, 1);
        assertEquals(eiLiikkunut, hahmo.getSijainti());
        
        luola.asetaKaytava(0, 1);
        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        Sijainti liikkui = new Sijainti();
        liikkui.setSijainti(0, 1);
        assertEquals(liikkui, hahmo.getSijainti());
    }

    @Test
    public void hahmonLiikuttaminenMoneenSuuntaan() {
        String komentoAlas = "alas";
        String komentoYlos = "ylös";
        String komentoOikea = "oikea";
        String komentoVasen = "vasen";
        
        luola.asetaKaytava(2, 1);
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komentoOikea, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        
        luola.asetaAarre(3, 1, "suuri aarre");
        loydettyKohde = liikuttaja.liikutaHahmoa(komentoOikea, luola, hahmo);
        assertEquals(Kohde.AARRE, loydettyKohde.getKoodi());
        assertEquals(2, hahmo.getSijainti().getX());
        
        luola.asetaKaytava(2, 2);
        loydettyKohde = liikuttaja.liikutaHahmoa(komentoAlas, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        assertEquals(2, hahmo.getSijainti().getY());
        
        luola.asetaLukittuOvi(2, 3, "hopea avain");
        loydettyKohde = liikuttaja.liikutaHahmoa(komentoAlas, luola, hahmo);
        assertEquals(Kohde.OVI, loydettyKohde.getKoodi());
        assertEquals(2, hahmo.getSijainti().getY());
        
        luola.asetaKaytava(1, 2);
        luola.asetaKaytava(1, 3);
        loydettyKohde = liikuttaja.liikutaHahmoa(komentoVasen, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        assertEquals(1, hahmo.getSijainti().getX());
        loydettyKohde = liikuttaja.liikutaHahmoa(komentoAlas, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        assertEquals(3, hahmo.getSijainti().getY());
        
        luola.asetaKaytava(2, 3);
        luola.asetaKaytava(3, 3);
        luola.asetaKaytava(3, 2);
        liikuttaja.liikutaHahmoa(komentoOikea, luola, hahmo);
        liikuttaja.liikutaHahmoa(komentoOikea, luola, hahmo);
        liikuttaja.liikutaHahmoa(komentoYlos, luola, hahmo);
        assertEquals(Kohde.KAYTAVA, loydettyKohde.getKoodi());
        assertEquals(2, hahmo.getSijainti().getY());
        assertEquals(3, hahmo.getSijainti().getX());
    }
}
