
package juuri.sovelluslogiikka.hahmo;

import juuri.apuvalineet.Sijainti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmoTest {
    private Hahmo hahmo;
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void druidiLuodaanOikein() {
        hahmo = new Druidi("Jakke");
        assertEquals("Jakke", hahmo.getNimi());
        
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());
        assertEquals(Hahmo.DRUIDI, hahmo.getAmmatti());
    }
    
    @Test
    public void velhoLuodaanOikein() {
        hahmo = new Velho("Anne");
        assertEquals("Anne", hahmo.getNimi());
        
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());
        assertEquals(Hahmo.VELHO, hahmo.getAmmatti());
    }
    
    @Test
    public void soturiLuodaanOikein() {
        hahmo = new Soturi("Tosimies");
        assertEquals("Tosimies", hahmo.getNimi());
        
        Sijainti ss = new Sijainti();
        ss.setSijainti(1, 1);
        assertEquals(ss, hahmo.getSijainti());
        assertEquals(Hahmo.SOTURI, hahmo.getAmmatti());
    }
    
    
}
