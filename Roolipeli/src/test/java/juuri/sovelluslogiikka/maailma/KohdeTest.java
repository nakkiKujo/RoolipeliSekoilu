
package juuri.sovelluslogiikka.maailma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KohdeTest {
    private Seina seina;
    private Kaytava kaytava;
    private Ovi ovi;
    
    @Before
    public void setUp() {
        this.seina = new Seina();
        this.kaytava = new Kaytava();
        this.ovi = new Ovi();
    }
    
    
}
