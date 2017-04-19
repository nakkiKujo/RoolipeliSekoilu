
package juuri.sovelluslogiikka.hahmo;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReppuTest {
    
    private Reppu reppu;
    private TaisteluEsine miekka;
    private TaisteluEsine kypara;
    private TaisteluEsine haarukka;
    private YleisEsine kupariAvain;
    private YleisEsine hopeaAvain;
   
    @Before
    public void setUp() {
        this.reppu = new Reppu();
        this.miekka = new TaisteluEsine("iso miekka", Esine.MIEKKA);
        this.kypara = new TaisteluEsine("ruma kypärä", Esine.KYPARA);
        this.haarukka = new TaisteluEsine("tuhti haarukka", Esine.MIEKKA);
        this.kupariAvain = new YleisEsine("hyi mikä avain", Esine.AVAIN);
        this.hopeaAvain = new YleisEsine("oi mikä avain", Esine.AVAIN);
    }
    
    @Test
    public void asettaaEsineenReppuunJaTunnistaaSenSiella() {
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(kypara);
        
        boolean arvo = reppu.onkoRepussa(miekka);
        assertTrue(arvo);
        
        arvo = reppu.onkoRepussa(kypara);
        assertTrue(arvo);
        
        arvo = reppu.onkoRepussa(haarukka);
        assertFalse(arvo);
    }
    
    @Test
    public void poistaaEsineenRepusta() {
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(hopeaAvain);
        reppu.asetaEsineReppuun(hopeaAvain);
        reppu.asetaEsineReppuun(kupariAvain);
        
        reppu.poistaRepusta(miekka);
        boolean arvo = reppu.onkoRepussa(miekka);
        assertTrue(arvo);
        
        reppu.poistaRepusta(miekka);
        arvo = reppu.onkoRepussa(miekka);
        assertFalse(arvo);
        
        reppu.poistaRepusta(kupariAvain);
        arvo = reppu.onkoRepussa(kupariAvain);
        assertFalse(arvo);
        
        assertTrue(reppu.onkoRepussa(hopeaAvain));
    }
    
}
