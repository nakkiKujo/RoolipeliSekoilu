
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
}
