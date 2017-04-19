
package juuri.sovelluslogiikka.maailma;

import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AarreTest {
    
    private Aarre aarre;
    
    @Before
    public void setUp() {
        this.aarre = new Aarre(null, "suuri aarre");
    }
    
    @Test
    public void osaaLisataEsineen() {
        Esine lisattavaEsine = new YleisEsine("haarukka", Esine.MIEKKA);
        aarre.lisaaAarre(lisattavaEsine);
        
        ArrayList<Esine> esineLista = aarre.keraaAarteet();
        boolean arvo = esineLista.contains(lisattavaEsine);
        assertTrue(arvo);
    }
    
    @Test
    public void osaaKerataAarteen() {
        Esine lisattava = new YleisEsine("pallonpuolikas", Esine.KYPARA);
        Esine toinen = new TaisteluEsine("sukkanauha", Esine.KYPARA);
        Esine kolmas = new YleisEsine("liito-orava", Esine.AVAIN);
        
        aarre.lisaaAarre(lisattava);
        aarre.lisaaAarre(toinen);
        aarre.lisaaAarre(kolmas);
        
        ArrayList<Esine> esineLista = aarre.keraaAarteet();
        assertTrue(esineLista.contains(lisattava));
        assertTrue(esineLista.contains(toinen));
        assertTrue(esineLista.contains(kolmas));
        
        assertTrue(aarre.keraaAarteet().isEmpty());
    }
    
    
}
