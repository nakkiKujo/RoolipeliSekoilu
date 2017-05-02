package juuri.sovelluslogiikka.hahmo;

import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReppuTest {

    private Reppu reppu;
    private TaisteluEsine miekka;
    private TaisteluEsine kypara;
    private TaisteluEsine haarukka;

    @Before
    public void setUp() {
        this.reppu = new Reppu();
        this.miekka = new TaisteluEsine("iso miekka", Esine.MIEKKA);
        this.kypara = new TaisteluEsine("ruma kypärä", Esine.KYPARA);
        this.haarukka = new TaisteluEsine("tuhti haarukka", Esine.MIEKKA);
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
    public void hakeeEsineetOikein() {
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(kypara);
        reppu.asetaEsineReppuun(Esine.KULTAAVAIN);

        ArrayList<Esine> esineet = reppu.getEsineet();
        assertTrue(esineet.contains(miekka));
        assertTrue(esineet.contains(kypara));
        assertTrue(esineet.contains(Esine.KULTAAVAIN));
    }

    @Test
    public void eiAsetaYliKuuttaEsinetta() {
        reppu.asetaEsineReppuun(Esine.KULTAAVAIN);
        reppu.asetaEsineReppuun(Esine.PRONSSIAVAIN);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(kypara);
        reppu.asetaEsineReppuun(haarukka);

        assertFalse(reppu.onkoRepussa(haarukka));
        assertTrue(reppu.onkoRepussa(kypara));
        assertTrue(reppu.onkoRepussa(miekka));
    }

    @Test
    public void asettaaRiimutJaVoiteetOikein() {
        reppu.asetaEsineReppuun(Esine.RIIMU);
        reppu.asetaEsineReppuun(Esine.PARANTAVAVOIDE);
        assertEquals(1, reppu.getVoiteita());
        assertEquals(1, reppu.getRiimuja());

        reppu.asetaEsineReppuun(Esine.RIIMU);
        reppu.asetaEsineReppuun(Esine.RIIMU);
        reppu.asetaEsineReppuun(Esine.RIIMU);
        reppu.asetaEsineReppuun(Esine.PARANTAVAVOIDE);
        reppu.asetaEsineReppuun(Esine.PARANTAVAVOIDE);

        assertEquals(4, reppu.getRiimuja());
        assertEquals(3, reppu.getVoiteita());
    }

    @Test
    public void poistaaRiimutJaVoiteetOikein() {
        reppu.asetaEsineReppuun(Esine.RIIMU);
        reppu.poistaRepusta(Esine.RIIMU);
        assertEquals(0, reppu.getRiimuja());

        reppu.poistaRepusta(Esine.RIIMU);
        assertEquals(0, reppu.getRiimuja());

        reppu.asetaEsineReppuun(Esine.PARANTAVAVOIDE);
        reppu.poistaRepusta(Esine.PARANTAVAVOIDE);
        assertEquals(0, reppu.getVoiteita());

        reppu.poistaRepusta(Esine.PARANTAVAVOIDE);
        assertEquals(0, reppu.getVoiteita());
    }

    @Test
    public void poistaaEsineenRepusta() {
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(Esine.HOPEAAVAIN);
        reppu.asetaEsineReppuun(Esine.HOPEAAVAIN);
        reppu.asetaEsineReppuun(Esine.PRONSSIAVAIN);

        reppu.poistaRepusta(miekka);
        boolean arvo = reppu.onkoRepussa(miekka);
        assertTrue(arvo);

        reppu.poistaRepusta(miekka);
        arvo = reppu.onkoRepussa(miekka);
        assertFalse(arvo);

        reppu.poistaRepusta(Esine.PRONSSIAVAIN);
        arvo = reppu.onkoRepussa(Esine.PRONSSIAVAIN);
        assertFalse(arvo);

        assertTrue(reppu.onkoRepussa(Esine.HOPEAAVAIN));
    }

    @Test
    public void hakeeEsineNumeroOikeinKunNull() {
        Esine eiOle1 = reppu.getEsine1();

        boolean arvo = false;
        if (eiOle1 == null) {
            arvo = true;
        }
        assertTrue(arvo);

        reppu.asetaEsineReppuun(Esine.PRONSSIAVAIN);
        Esine avain = reppu.getEsine1();
        assertTrue(avain.equals(Esine.PRONSSIAVAIN));

        Esine eiOle2 = reppu.getEsine2();
        Esine eiOle3 = reppu.getEsine3();
        Esine eiOle4 = reppu.getEsine4();
        Esine eiOle5 = reppu.getEsine5();
        Esine eiOle6 = reppu.getEsine6();

        arvo = false;
        if (eiOle2 == null && eiOle3 == null && eiOle4 == null && eiOle5 == null && eiOle6 == null) {
            arvo = true;
        }

        assertTrue(arvo);
    }
    
    @Test
    public void hakeeEsineNumeroOikein() {
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(haarukka);
        
        Esine e1 = reppu.getEsine1();
        Esine e2 = reppu.getEsine2();
        
        assertTrue(e1.equals(miekka));
        assertTrue(e2.equals(haarukka));
        
        reppu.poistaRepusta(miekka);
        
        assertTrue(reppu.getEsine1().equals(haarukka));
        
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(miekka);
        reppu.asetaEsineReppuun(kypara);
        reppu.asetaEsineReppuun(Esine.PRONSSIAVAIN);
        
        Esine e3 = reppu.getEsine3();
        Esine e5 = reppu.getEsine5();
        Esine e6 = reppu.getEsine6();
        
        assertTrue(e3.equals(miekka));
        assertTrue(e5.equals(kypara));
        assertTrue(e6.equals(Esine.PRONSSIAVAIN));
    }

}
