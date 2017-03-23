
package juuri.apuvalineet;

import juuri.sovelluslogiikka.hahmo.Druidi;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.hahmo.Velho;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KeskustelijaTest {
    private Keskustelija keskustelija;
    
    @Before
    public void setUp() {
        this.keskustelija = new Keskustelija();
    }
    
    @Test
    public void ammattiInfoAntaaOikeinSoturi() {
        Soturi soturi = new Soturi("Jarkko");
        String teksti = "info soturi";
        
        assertEquals(soturi.ammatinKuvaus(), keskustelija.ammattiInfo(teksti));
    }
    
    @Test
    public void ammattiInfoAntaaOikeinVelho() {
        Velho velho = new Velho("Pekka");
        String teksti = "info velho";
        
        assertEquals(velho.ammatinKuvaus(), keskustelija.ammattiInfo(teksti));
    }
    
    @Test
    public void ammattiInfoAntaaOikeinDruidi() {
        Druidi druidi = new Druidi("Helena");
        String teksti = "info druidi";
        
        assertEquals(druidi.ammatinKuvaus(), keskustelija.ammattiInfo(teksti));
    }
    
    @Test
    public void ammattiInfoNullKunTekstiVaara() {
        String teksti = "InFo DrUIdI";
        assertEquals(null, keskustelija.ammattiInfo(teksti));
    }
    
}
