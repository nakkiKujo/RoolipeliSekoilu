
package juuri.apuvalineet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SijaintiTest {
    
    private Sijainti yksi;
    private Sijainti kaksi;
    
    @Before
    public void setUp() {
        yksi = new Sijainti();
        kaksi = new Sijainti();
    }
    
    @Test
    public void samatSijainnitHuomataanSamoiksi() {
        yksi.setX(5);
        yksi.setY(4);
        
        kaksi.setX(5);
        kaksi.setY(4);
        
        assertTrue(yksi.equals(kaksi));
    }
    
    @Test
    public void eriSijainnitHuomataanEriksi() {
        yksi.setX(-1);
        yksi.setY(7);
        
        kaksi.setX(-1);
        kaksi.setY(-7);
        
        assertFalse(kaksi.equals(yksi));
    }
    
    @Test
    public void sijainninLiikutusYlosToimii() {
        yksi.setX(2);
        yksi.setY(2);
        yksi.liikuYlos(1);
        assertEquals(1, yksi.getY());
    }
    
    @Test
    public void sijainninLiikutusAlasToimii() {
        yksi.liikuAlas(1);
        assertEquals(1, yksi.getY());
    }
    
    @Test
    public void sijainninLiikutusVasemmalleToimii() {
        yksi.liikuVasemmalle(2);
        assertEquals(-2, yksi.getX());
    }
    
    @Test
    public void sijainninLiikutusOikealleToimii() {
        yksi.liikuOikealle(4);
        yksi.liikuOikealle(2);
        assertEquals(6, yksi.getX());
    }
    
    @Test
    public void yleinenSijainninLiikutusToimii() {
        yksi.liikuAlas(3);
        yksi.liikuYlos(5);
        yksi.liikuVasemmalle(0);
        yksi.liikuOikealle(6);
        yksi.liikuAlas(4);
        yksi.liikuVasemmalle(2);
        
        assertEquals(2, yksi.getY());
        assertEquals(4, yksi.getX());
    }
}
