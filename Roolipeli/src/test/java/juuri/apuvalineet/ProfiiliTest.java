
package juuri.apuvalineet;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfiiliTest {
    
    private Profiili prof;
    
    @Before
    public void setUp() {
        this.prof = new Profiili();
    }
    
    @Test
    public void lisaaOminaisuuksiaOikein() {
        prof.lisaaElamaPisteet(51);
        prof.lisaaKetteryys(4);
        prof.lisaaKetteryys(-2);
        prof.lisaaTaikaPuolustus(11);
        prof.lisaaTaikaPuolustus(0);
        prof.lisaaTaikaVoima(-3);
        prof.lisaaTaikaVoima(6);
        prof.lisaaVoima(1);
        prof.lisaaVoima(-1);
        
        assertEquals(51, prof.getElamaPisteet());
        assertEquals(2, prof.getKetteryys());
        assertEquals(11, prof.getTaikaPuolustus());
        assertEquals(3, prof.getTaikaVoima());
        assertEquals(0, prof.getVoima());
    }
    
    @Test
    public void asettaaAlkuProfiiliOikein() {
        prof.setSoturiAlkuProfiili();
        
        assertEquals(15, prof.getElamaPisteet());
        assertEquals(3, prof.getKetteryys());
        assertEquals(1, prof.getTaikaPuolustus());
        assertEquals(1, prof.getTaikaVoima());
        assertEquals(4, prof.getVoima());
        
        prof.setVelhoAlkuProfiili();
        
        assertEquals(13, prof.getElamaPisteet());
        assertEquals(2, prof.getKetteryys());
        assertEquals(4, prof.getTaikaPuolustus());
        assertEquals(4, prof.getTaikaVoima());
        assertEquals(1, prof.getVoima());
        
        prof.setDruidiAlkuProfiili();
        
        assertEquals(17, prof.getElamaPisteet());
        assertEquals(4, prof.getKetteryys());
        assertEquals(2, prof.getTaikaPuolustus());
        assertEquals(2, prof.getTaikaVoima());
        assertEquals(1, prof.getVoima());
    }
    
    @Test
    public void asettaaEsineenOikein() {
        TaisteluEsine miekka = new TaisteluEsine("suuri miekka", Esine.MIEKKA);
        Profiili miekanProfiili = miekka.getProfiili();
        
        miekanProfiili.lisaaElamaPisteet(2);
        miekanProfiili.lisaaKetteryys(-2);
        miekanProfiili.lisaaVoima(6);
        miekanProfiili.lisaaTaikaPuolustus(3);
        miekanProfiili.lisaaTaikaVoima(22);
        
        TaisteluEsine kypara = new TaisteluEsine("iso kypärä", Esine.KYPARA);
        Profiili kyparanProfiili = kypara.getProfiili();
        
        kyparanProfiili.lisaaElamaPisteet(1);
        kyparanProfiili.lisaaKetteryys(1);
        kyparanProfiili.lisaaVoima(0);
        kyparanProfiili.lisaaTaikaPuolustus(-2);
        
        prof.setDruidiAlkuProfiili();
        prof.asetaEsine(miekka);
        prof.asetaEsine(kypara);
        
        Profiili vertailuProfiili = new Profiili();
        vertailuProfiili.setDruidiAlkuProfiili();
        assertEquals(vertailuProfiili.getElamaPisteet() + 3, prof.getElamaPisteet());
        assertEquals(vertailuProfiili.getKetteryys() - 1, prof.getKetteryys());
        assertEquals(vertailuProfiili.getTaikaPuolustus() + 1, prof.getTaikaPuolustus());
        assertEquals(vertailuProfiili.getTaikaVoima() + 22, prof.getTaikaVoima());
        assertEquals(vertailuProfiili.getVoima() + 6, prof.getVoima());
    }
    
    @Test
    public void poistaaEsineenOikein() {
        prof.lisaaElamaPisteet(2);
        prof.lisaaKetteryys(-1);
        prof.lisaaTaikaVoima(77);
        
        TaisteluEsine miekka = new TaisteluEsine("suuri miekka", Esine.MIEKKA);
        Profiili miekanProfiili = miekka.getProfiili();
        
        miekanProfiili.lisaaElamaPisteet(10);
        miekanProfiili.lisaaKetteryys(-2);
        miekanProfiili.lisaaVoima(7);
        miekanProfiili.lisaaTaikaPuolustus(-3);
        miekanProfiili.lisaaTaikaVoima(2);
        
        prof.asetaEsine(miekka);
        assertTrue(prof.getElamaPisteet() == 12);
        assertTrue(prof.getKetteryys() == -3);
        assertTrue(prof.getTaikaPuolustus() == -3);
        assertTrue(prof.getTaikaVoima() == 79);
        assertTrue(prof.getVoima() == 7);
        
        prof.poistaEsine(miekka);
        assertTrue(prof.getElamaPisteet() == 2);
        assertTrue(prof.getKetteryys() == -1);
        assertTrue(prof.getTaikaPuolustus() == 0);
        assertTrue(prof.getTaikaVoima() == 77);
        assertTrue(prof.getVoima() == 0);
        
    }
    
    @Test
    public void nykyinenElamaPisteetOikein() {
        prof.lisaaElamaPisteet(12);
        assertTrue(prof.getNykyinenElamaPisteet() == 12);
        prof.lisaaElamaPisteet(-5);
        assertTrue(prof.getNykyinenElamaPisteet() == 7);
        prof.lisaaNykyinenElamaPisteet(-4);
        assertTrue(prof.getElamaPisteet() == 7);
        assertTrue(prof.getNykyinenElamaPisteet() == 3);
        prof.lisaaNykyinenElamaPisteet(10);
        assertTrue(prof.getNykyinenElamaPisteet() == 7);
    }
    
    @Test
    public void asettaaValmiudetOikein() {
        prof.asetaHyokkaysValmius(10);
        prof.asetaPuolustusValmius(5);
        assertTrue(prof.getPuolustusValmius() == 5);
        assertTrue(prof.getHyokkaysValmius() == 10);
        prof.asetaHyokkaysValmius(0);
        assertTrue(prof.getHyokkaysValmius() == 0);
    }
    
    @Test
    public void onkoKuollutToimii() {
        prof.lisaaElamaPisteet(3);
        assertFalse(prof.onkoKuollut());
        prof.lisaaNykyinenElamaPisteet(-3);
        assertTrue(prof.onkoKuollut());
        prof.lisaaElamaPisteet(1);
        assertFalse(prof.onkoKuollut());
    }
    
    @Test
    public void kayttaaVoiteenOikein() {
        prof.lisaaElamaPisteet(15);
        prof.lisaaNykyinenElamaPisteet(-7);
        prof.kaytaParantavaEsine(Esine.RIIMU);
        assertTrue(prof.getNykyinenElamaPisteet() == 8);
        
        prof.kaytaParantavaEsine(Esine.PARANTAVAVOIDE);
        assertTrue(prof.getNykyinenElamaPisteet() == 11);
        
        prof.kaytaParantavaEsine(Esine.PARANTAVAVOIDE);
        assertTrue(prof.getNykyinenElamaPisteet() == 14);
        
        prof.kaytaParantavaEsine(Esine.PARANTAVAVOIDE);
        assertTrue(prof.getNykyinenElamaPisteet() == 15);
    }
}
