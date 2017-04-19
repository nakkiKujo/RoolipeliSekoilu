package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LuolastoTest {

    private Luolasto luola;

    @Before
    public void setUp() {
        this.luola = new Luolasto();
    }

    @Test
    public void asettaaHirvionOikein() {
        luola.luoTaso1();
        luola.asetaHirvio(3, 5);
        Kohde hh = luola.haeKoordinaateista(3, 5);

        assertEquals("Noita", hh.getNimi());
        assertEquals(Kohde.HIRVIO, hh.getKoodi());
        assertEquals(Tapahtuma.TAISTELU, hh.getTapahtuma().getKoodi());
    }

    @Test
    public void eiAsetaHirviotaVaarillaKoordinaateilla() {
        luola.luoTaso1();
        boolean arvo = luola.asetaHirvio(0, 11);
        assertFalse(arvo);

        arvo = luola.asetaHirvio(13, 5);
        assertFalse(arvo);
    }

    @Test
    public void asettaaAnsanOikein() {
        luola.luoTaso1();
        luola.asetaAnsa(12, 10);
        Kohde aa = luola.haeKoordinaateista(12, 10);

        assertEquals("ansa", aa.getNimi());
        assertEquals(Kohde.ANSA, aa.getKoodi());
    }

    @Test
    public void eiAsetaAnsaaVaarillaKoordinaateilla() {
        luola.luoTaso1();
        boolean arvo = luola.asetaAnsa(0, -1);
        assertFalse(arvo);

        arvo = luola.asetaAnsa(12, 11);
        assertFalse(arvo);
    }

    @Test
    public void asettaaPortaatOikein() {
        luola.luoTaso1();
        luola.asetaPortaat(5, 8);
        Kohde pp = luola.haeKoordinaateista(5, 8);

        assertEquals("portaat", pp.getNimi());
        assertEquals(Kohde.PORTAAT, pp.getKoodi());
    }

    @Test
    public void eiAsetaPortaitaVaarillaKoordinaateilla() {
        luola.luoTaso1();
        boolean arvo = luola.asetaPortaat(7, -3);
        assertFalse(arvo);
        arvo = luola.asetaPortaat(-11, 8);
        assertFalse(arvo);
    }

    @Test
    public void asettaaAarteenOikein() {
        luola.luoTaso1();
        luola.asetaAarre(6, 6, "midaksen aarre");

        Kohde haettuKohde = luola.haeKoordinaateista(6, 6);
        assertEquals(Kohde.AARRE, haettuKohde.getKoodi());

        luola.asetaAarre(6, 6, "perseuksen lipas");
        haettuKohde = luola.haeKoordinaateista(6, 6);
        assertEquals("perseuksen lipas", haettuKohde.getNimi());
    }

    @Test
    public void eiAsetaAarrettaVaarillaKoordinaateilla() {
        luola.luoTaso1();

        boolean arvo = luola.asetaAarre(0, 11, "vÃ¤Ã¤rÃ¤ aarre");
        assertFalse(arvo);

        arvo = luola.asetaAarre(13, 2, "toinen vÃ¤Ã¤rÃ¤ aarre");
        assertFalse(arvo);
    }

    @Test
    public void kohteenAsetusLuolanReunalle() {
        luola.luoTaso1();

        boolean tulos = luola.asetaKaytava(0, 0);
        assertTrue(tulos);
        tulos = luola.asetaLukittuOvi(5, 10, "pronssiavain");
        assertTrue(tulos);
        tulos = luola.asetaSeina(12, 9);
        assertTrue(tulos);
    }

    @Test
    public void oviAsetusToimiiOikein() {
        luola.luoTaso1();

        luola.asetaLukittuOvi(5, 7, "avain");
        Kohde haettuKohde = luola.haeKoordinaateista(5, 7);
        assertEquals(Kohde.OVI, haettuKohde.getKoodi());

        Ovi haettuOvi = (Ovi) haettuKohde;
        assertEquals("avain", haettuOvi.getAvaaja().getNimi());
        assertEquals(Tapahtuma.OVENAVAUS, haettuOvi.getTapahtuma().getKoodi());
        assertFalse(haettuOvi.getVoikoKulkea());

        luola.asetaAvoinOvi(3, 1);
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(3, 1).getKoodi());
        haettuOvi = (Ovi) luola.haeKoordinaateista(3, 1);
        assertEquals(Tapahtuma.OVENAVAUS, haettuOvi.getTapahtuma().getKoodi());
        assertTrue(haettuOvi.getVoikoKulkea());
    }

    @Test
    public void eiAsetaOveaVaarillaKoordinaateilla() {
        luola.luoTaso1();

        boolean arvo = luola.asetaAvoinOvi(4, 11);
        assertFalse(arvo);
        arvo = luola.asetaLukittuOvi(0, -1, "avain");
        assertFalse(arvo);
    }

    @Test
    public void kaytavaAsetusToimiiOikein() {
        luola.luoTaso1();
        luola.asetaKaytava(0, 0);
        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(0, 0).getKoodi());
    }

    @Test
    public void eiAsetaKaytavaaVaarillaKoordinaateilla() {
        luola.luoTaso1();

        boolean arvo = luola.asetaKaytava(0, -1);
        assertFalse(arvo);
    }

    @Test
    public void seinaAsetusToimiiOikein() {
        luola.luoTaso1();
        luola.asetaSeina(7, 2);
        assertEquals(Kohde.SEINA, luola.haeKoordinaateista(7, 2).getKoodi());
    }

    @Test
    public void eiAsetaSeinaaVaarillaKoordinaateilla() {
        luola.luoTaso1();

        boolean arvo = luola.asetaSeina(-1, 10);
        assertFalse(arvo);

        arvo = luola.asetaSeina(0, -2);
        assertFalse(arvo);
    }

    @Test
    public void osaaHakeaSijainnista() {
        luola.luoTaso1();

        Sijainti ss = new Sijainti();
        ss.setSijainti(4, 3);
        luola.asetaLukittuOvi(4, 3, "kulta-avain");

        Ovi haettuOvi = (Ovi) luola.haeSijainnista(ss);
        assertEquals(Kohde.OVI, haettuOvi.getKoodi());
        assertEquals("kulta-avain", haettuOvi.getAvaaja().getNimi());
    }

    @Test
    public void sijainninHakuKunUlkopuolella() {
        luola.luoTaso1();
        
        Sijainti ss = new Sijainti();
        ss.setSijainti(4, 13);
        assertEquals(null, luola.haeSijainnista(ss));
    }

    @Test
    public void osaaHakeaKoordinaateista() {
        luola.luoTaso1();
        
        luola.asetaAvoinOvi(4, 3);
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(4, 3).getKoodi());
    }

    @Test
    public void koordinaateinHakuKunUlkopuolella() {
        luola.luoTaso1();
        
        assertEquals(null, luola.haeKoordinaateista(6, -1));
    }

    @Test
    public void poistaaKohteenOikein() {
        luola.luoTaso1();
        
        luola.asetaLukittuOvi(4, 5, "kiva avain");
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(4, 5).getKoodi());
        luola.poistaKohde(luola.haeKoordinaateista(4, 5));
        
        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(4, 5).getKoodi());
    }
    
    @Test
    public void luoTaso1EiJataTyhjaa() {
        luola.luoTaso1();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                assertFalse(luola.haeKoordinaateista(i, j) == null);
            }
        }
    }

}
