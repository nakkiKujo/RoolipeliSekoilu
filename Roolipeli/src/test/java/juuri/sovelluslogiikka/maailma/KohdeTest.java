
package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.OvenAvaus;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KohdeTest {
    private Seina seina;
    private Kaytava kaytava;
    private Ovi avoinOvi;
    private Ovi lukittuOvi;
    
    @Before
    public void setUp() {
        seina = new Seina(null);
        kaytava = new Kaytava(null);
        
        avoinOvi = new Ovi(false, null);
        lukittuOvi = new Ovi(true, null);
        Tapahtuma ovenAvaus1 = new OvenAvaus(avoinOvi);
        avoinOvi.setTapahtuma(ovenAvaus1);
        Tapahtuma ovenAvaus2 = new OvenAvaus(lukittuOvi);
        lukittuOvi.setTapahtuma(ovenAvaus2);
    }
    
    
    
    
}
