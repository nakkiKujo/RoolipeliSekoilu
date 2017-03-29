
package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;
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
        //luodaan 10x10 kokoinen luola
        this.luola = new Luolasto(10, 10);
    }
    
    @Test
    public void kohteenAsetusLuolanUlkopuolelle() {
        boolean tulos = luola.asetaKaytava(-1, 6);
        assertFalse(tulos);
        tulos = luola.asetaAvoinOvi(9, 10);
        assertFalse(tulos);
    }
    
    @Test
    public void kohteenAsetusLuolanReunalle() {
        boolean tulos = luola.asetaKaytava(9, 0);
        assertTrue(tulos);
        tulos = luola.asetaLukittuOvi(5, 0);
        assertTrue(tulos);
        tulos = luola.asetaSeina(7, 9);
        assertTrue(tulos);
    }
    
    @Test
    public void oviAsetusToimiiOikein() {
        luola.asetaLukittuOvi(5, 7);
        assertEquals(3, luola.haeKoordinaateista(5, 7).getKoodi());
        luola.asetaAvoinOvi(3, 1);
        assertEquals(3, luola.haeKoordinaateista(3, 1).getKoodi());
    }
    
    @Test
    public void kaytavaAsetusToimiiOikein() {
        luola.asetaKaytava(0, 0);
        assertEquals(2, luola.haeKoordinaateista(0, 0).getKoodi());
    }
    
    @Test
    public void seinaAsetusToimiiOikein() {
        luola.asetaSeina(7, 2);
        assertEquals(1, luola.haeKoordinaateista(7, 2).getKoodi());
    }
    
    @Test
    public void osaaHakeaSijainnista() {
        Sijainti ss = new Sijainti();
        ss.setSijainti(4, 3);
        luola.asetaLukittuOvi(4, 3);
        
        assertEquals(3, luola.haeSijainnista(ss).getKoodi());
    }
    
    @Test
    public void sijainninHakuKunUlkopuolella() {
        Sijainti ss = new Sijainti();
        ss.setSijainti(4, 10);
        assertEquals(null, luola.haeSijainnista(ss));
    }
    
    @Test
    public void osaaHakeaKoordinaateista() {
        luola.asetaAvoinOvi(4, 3);
        assertEquals(3, luola.haeKoordinaateista(4, 3).getKoodi());
    }
    
    @Test
    public void koordinaateinHakuKunUlkopuolella() {
        assertEquals(null, luola.haeKoordinaateista(6, -1));
    }
    
    
}
