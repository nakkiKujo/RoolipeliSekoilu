package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.peli.HirvionLuoja;
import juuri.sovelluslogiikka.peli.KohteidenLuoja;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;
import org.junit.Before;
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
        luola.luoSeuraavaTaso();
        luola.asetaHirvio(3, 5, HirvionLuoja.NOITA);
        Kohde hh = luola.haeKoordinaateista(3, 5);

        assertEquals("Noita", hh.getNimi());
        assertEquals(Kohde.HIRVIO, hh.getKoodi());
        assertEquals(Tapahtuma.TAISTELU, hh.getTapahtuma().getKoodi());
    }

    @Test
    public void eiAsetaHirviotaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();
        boolean arvo = luola.asetaHirvio(0, 11, HirvionLuoja.SUURIROTTA);
        assertFalse(arvo);

        arvo = luola.asetaHirvio(13, 5, HirvionLuoja.NOKKELANOITA);
        assertFalse(arvo);
    }

    @Test
    public void asettaaAnsanOikein() {
        luola.luoSeuraavaTaso();
        luola.asetaAnsa(12, 10, KohteidenLuoja.ANSAPIIKKI);
        Kohde aa = luola.haeKoordinaateista(12, 10);

        assertEquals("piikkiansa", aa.getNimi());
        assertEquals(Kohde.ANSA, aa.getKoodi());
    }

    @Test
    public void eiAsetaAnsaaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();
        boolean arvo = luola.asetaAnsa(0, -1, KohteidenLuoja.ANSANUOLI);
        assertFalse(arvo);

        arvo = luola.asetaAnsa(12, 11, KohteidenLuoja.ANSANUOLI);
        assertFalse(arvo);
    }

    @Test
    public void asettaaPortaatOikein() {
        luola.luoSeuraavaTaso();
        luola.asetaPortaat(5, 8, KohteidenLuoja.PORTAAT);
        Kohde pp = luola.haeKoordinaateista(5, 8);

        assertEquals("portaat", pp.getNimi());
        assertEquals(Kohde.PORTAAT, pp.getKoodi());
    }

    @Test
    public void eiAsetaPortaitaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();
        boolean arvo = luola.asetaPortaat(7, -3, KohteidenLuoja.PORTAAT);
        assertFalse(arvo);
        arvo = luola.asetaPortaat(-11, 8, KohteidenLuoja.PORTAAT);
        assertFalse(arvo);
    }

    @Test
    public void asettaaAarteenOikein() {
        luola.luoSeuraavaTaso();
        luola.asetaAarre(6, 6, KohteidenLuoja.AARREJOSSAHOPEAAVAIN);

        Kohde haettuKohde = luola.haeKoordinaateista(6, 6);
        assertEquals(Kohde.AARRE, haettuKohde.getKoodi());

        luola.asetaAarre(6, 6, KohteidenLuoja.AARREJOSSAMIEKKA1);
        haettuKohde = luola.haeKoordinaateista(6, 6);
        assertEquals("vanha seikkailijan reppu", haettuKohde.getNimi());
    }

    @Test
    public void eiAsetaAarrettaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();

        boolean arvo = luola.asetaAarre(0, 11, KohteidenLuoja.AARRE2VOIDETTA);
        assertFalse(arvo);

        arvo = luola.asetaAarre(13, 2, KohteidenLuoja.AARREJOSSAHOPEAAVAIN);
        assertFalse(arvo);
    }

    @Test
    public void kohteenAsetusLuolanReunalle() {
        luola.luoSeuraavaTaso();

        boolean tulos = luola.asetaKaytava(0, 0);
        assertTrue(tulos);
        tulos = luola.asetaLukittuOvi(5, 10, KohteidenLuoja.OVIHOPEAAVAAJA);
        assertTrue(tulos);
        tulos = luola.asetaSeina(12, 9, KohteidenLuoja.SEINA);
        assertTrue(tulos);
    }

    @Test
    public void oviAsetusToimiiOikein() {
        luola.luoSeuraavaTaso();

        luola.asetaLukittuOvi(5, 7, KohteidenLuoja.OVIPRONSSIAVAAJA);
        Kohde haettuKohde = luola.haeKoordinaateista(5, 7);
        assertEquals(Kohde.OVI, haettuKohde.getKoodi());

        Ovi haettuOvi = (Ovi) haettuKohde;
        assertEquals(Esine.PRONSSIAVAIN.getNimi(), haettuOvi.getAvaaja().getNimi());
        assertEquals(Tapahtuma.OVENAVAUS, haettuOvi.getTapahtuma().getKoodi());
        assertFalse(haettuOvi.getVoikoKulkea());

        luola.asetaAvoinOvi(3, 1);
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(3, 1).getKoodi());
        haettuOvi = (Ovi) luola.haeKoordinaateista(3, 1);
        assertEquals(Tapahtuma.OVENAVAUS, haettuOvi.getTapahtuma().getKoodi());
    }

    @Test
    public void eiAsetaOveaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();

        boolean arvo = luola.asetaAvoinOvi(4, 11);
        assertFalse(arvo);
        arvo = luola.asetaLukittuOvi(0, -1, KohteidenLuoja.OVIKULTAAVAAJA);
        assertFalse(arvo);
    }

    @Test
    public void kaytavaAsetusToimiiOikein() {
        luola.luoSeuraavaTaso();
        luola.asetaKaytava(0, 0);
        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(0, 0).getKoodi());
    }

    @Test
    public void eiAsetaKaytavaaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();

        boolean arvo = luola.asetaKaytava(0, -1);
        assertFalse(arvo);
    }

    @Test
    public void seinaAsetusToimiiOikein() {
        luola.luoSeuraavaTaso();
        luola.asetaSeina(7, 2, KohteidenLuoja.SEINA);
        assertEquals(Kohde.SEINA, luola.haeKoordinaateista(7, 2).getKoodi());
    }

    @Test
    public void eiAsetaSeinaaVaarillaKoordinaateilla() {
        luola.luoSeuraavaTaso();

        boolean arvo = luola.asetaSeina(-1, 10, KohteidenLuoja.SEINA);
        assertFalse(arvo);

        arvo = luola.asetaSeina(0, -2, KohteidenLuoja.SEINA);
        assertFalse(arvo);
    }

    @Test
    public void osaaHakeaSijainnista() {
        luola.luoSeuraavaTaso();

        Sijainti ss = new Sijainti();
        ss.setSijainti(4, 3);
        luola.asetaLukittuOvi(4, 3, KohteidenLuoja.OVIKULTAAVAAJA);

        Ovi haettuOvi = (Ovi) luola.haeSijainnista(ss);
        assertEquals(Kohde.OVI, haettuOvi.getKoodi());
        assertEquals(Esine.KULTAAVAIN.getNimi(), haettuOvi.getAvaaja().getNimi());
    }

    @Test
    public void sijainninHakuKunUlkopuolella() {
        luola.luoSeuraavaTaso();

        Sijainti ss = new Sijainti();
        ss.setSijainti(4, 13);
        assertEquals(null, luola.haeSijainnista(ss));
    }

    @Test
    public void osaaHakeaKoordinaateista() {
        luola.luoSeuraavaTaso();

        luola.asetaAvoinOvi(4, 3);
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(4, 3).getKoodi());
    }

    @Test
    public void koordinaateinHakuKunUlkopuolella() {
        luola.luoSeuraavaTaso();

        assertEquals(null, luola.haeKoordinaateista(6, -1));
    }

    @Test
    public void poistaaKohteenOikein() {
        luola.luoSeuraavaTaso();

        luola.asetaLukittuOvi(4, 5, KohteidenLuoja.OVIHOPEAAVAAJA);
        assertEquals(Kohde.OVI, luola.haeKoordinaateista(4, 5).getKoodi());
        luola.poistaKohde(luola.haeKoordinaateista(4, 5));

        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(4, 5).getKoodi());
    }
    
    @Test
    public void nykyinenTasoOikein() {
        assertEquals(0, luola.getNykyinenTaso());
        luola.luoSeuraavaTaso();
        assertEquals(1, luola.getNykyinenTaso());
        luola.luoSeuraavaTaso();
        assertEquals(2, luola.getNykyinenTaso());
        luola.luoSeuraavaTaso();
        assertEquals(3, luola.getNykyinenTaso());
        luola.luoSeuraavaTaso();
        assertEquals(3, luola.getNykyinenTaso());
    }

    @Test
    public void luoTaso1EiJataTyhjaa() {
        luola.luoSeuraavaTaso();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                assertFalse(luola.haeKoordinaateista(i, j) == null);
            }
        }
    }

    @Test
    public void luoTaso2EiJataTyhjaa() {
        luola.luoSeuraavaTaso();
        luola.luoSeuraavaTaso();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 11; j++) {
                assertFalse(luola.haeKoordinaateista(i, j) == null);
            }
        }
    }

    @Test
    public void luoTaso3EiJataTyhjaa() {
        luola.luoSeuraavaTaso();
        luola.luoSeuraavaTaso();
        luola.luoSeuraavaTaso();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 11; j++) {
                assertFalse(luola.haeKoordinaateista(i, j) == null);
            }
        }
    }

}
