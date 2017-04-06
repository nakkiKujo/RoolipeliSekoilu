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

        //luodaan 4x4 luola, jossa ulkoreunat seinää ja sisällä on käytävää, sisällä myös yksi avoin ovi
        // XXXX
        // X OX
        // X  X
        // XXXX
        this.luola = new Luolasto(4, 4);
        luoLuola();
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
        String komento = "alas";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(2, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenOikealle() {
        String komento = "oikea";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(3, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenYlos() {
        String komento = "ylös";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenVasemmalle() {
        String komento = "vasen";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenMoneenSuuntaan() {
        String komento = "alas";
        String komento2 = "ylös";
        String komento3 = "oikea";
        String komento4 = "vasen";

        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento3, luola, hahmo);
        assertEquals(3, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(2, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento4, luola, hahmo);
        assertEquals(2, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento2, luola, hahmo);
        assertEquals(2, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento2, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenHuonoonPaikkaanEiLiikuta() {
        String komento = "ylös";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());

        komento = "oikea";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        ss.setSijainti(2, 1);
        assertEquals(ss, hahmo.getSijainti());

        komento = "alas";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        ss.setSijainti(2, 2);
        assertEquals(ss, hahmo.getSijainti());

        komento = "vasen";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        ss.setSijainti(1, 2);
        assertEquals(ss, hahmo.getSijainti());

        liikuttaja.liikutaHahmoa("alas", luola, hahmo);
        assertEquals(ss, hahmo.getSijainti());
    }

    @Test
    public void hahmonLiikuttaminenHuonoonPaikkaanEiLiikuta2() {
        luoLuolaLukitullaOvella();
        liikuttaja.liikutaHahmoa("ylös", luola, hahmo);
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());
        
        liikuttaja.liikutaHahmoa("oikea", luola, hahmo);
        assertEquals(ss, hahmo.getSijainti());
        
        liikuttaja.liikutaHahmoa("alas", luola, hahmo);
        liikuttaja.liikutaHahmoa("oikea", luola, hahmo);
        liikuttaja.liikutaHahmoa("ylös", luola, hahmo);
        ss.setSijainti(2, 2);
        assertEquals(ss, hahmo.getSijainti());
    }

    private void luoLuola() {
        for (int i = 0; i < 4; i++) {
            luola.asetaSeina(0, i);
            luola.asetaSeina(i, 0);
            luola.asetaSeina(3 - i, 3);
            luola.asetaSeina(3, 3 - i);
        }

        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                luola.asetaKaytava(i, j);
            }
        }

        luola.asetaAvoinOvi(2, 1);
    }
    
    private void luoLuolaLukitullaOvella() {
        luola = new Luolasto(9, 9);
        luola.luoTaso1();
    }

}
