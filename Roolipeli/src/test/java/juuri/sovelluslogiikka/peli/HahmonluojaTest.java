
package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Lukija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PenaJones
 */
public class HahmonluojaTest {
    private Hahmonluoja luoja;
    @Before
    public void setUp() {
        Lukija ll = new Lukija();
        luoja = new Hahmonluoja(ll);
    }
    
    
    
    
}
