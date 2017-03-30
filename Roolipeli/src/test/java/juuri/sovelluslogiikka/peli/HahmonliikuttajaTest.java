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
        String komento = "liiku vasenmalle";
        Kohde kk = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        boolean onkoTosi = true;
        if (!(kk == null)) {
            onkoTosi = false;
        }

        assertTrue(onkoTosi);
    }

    @Test
    public void hahmonLiikuttaminenAlas() {
        String komento = "liiku alas";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(2, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenOikealle() {
        String komento = "liiku oikealle";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(3, loydettyKohde.getKoodi());

        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenYlos() {
        String komento = "liiku ylös";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenVasemmalle() {
        String komento = "liiku vasemmalle";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }

    @Test
    public void hahmonLiikuttaminenMoneenSuuntaan() {
        String komento = "liiku alas";
        String komento2 = "liiku ylös";
        String komento3 = "liiku oikealle";
        String komento4 = "liiku vasemmalle";

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
        String komento = "liiku ylös";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());

        komento = "liiku oikealle";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        ss.setSijainti(2, 1);
        assertEquals(ss, hahmo.getSijainti());

        komento = "liiku alas";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        ss.setSijainti(2, 2);
        assertEquals(ss, hahmo.getSijainti());

        komento = "liiku vasemmalle";
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        ss.setSijainti(1, 2);
        assertEquals(ss, hahmo.getSijainti());

        liikuttaja.liikutaHahmoa("liiku alas", luola, hahmo);
        assertEquals(ss, hahmo.getSijainti());
    }

    @Test
    public void hahmonLiikuttaminenHuonoonPaikkaanEiLiikuta2() {
        luoLuolaLukitullaOvella();
        liikuttaja.liikutaHahmoa("liiku ylös", luola, hahmo);
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());
        
        liikuttaja.liikutaHahmoa("liiku oikealle", luola, hahmo);
        assertEquals(ss, hahmo.getSijainti());
        
        liikuttaja.liikutaHahmoa("liiku alas", luola, hahmo);
        liikuttaja.liikutaHahmoa("liiku oikealle", luola, hahmo);
        liikuttaja.liikutaHahmoa("liiku ylös", luola, hahmo);
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
