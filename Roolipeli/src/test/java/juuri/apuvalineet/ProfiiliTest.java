
package juuri.apuvalineet;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        
        assertEquals(8, prof.getElamaPisteet());
        assertEquals(2, prof.getKetteryys());
        assertEquals(1, prof.getTaikaPuolustus());
        assertEquals(1, prof.getTaikaVoima());
        assertEquals(3, prof.getVoima());
        
        prof.setVelhoAlkuProfiili();
        
        assertEquals(7, prof.getElamaPisteet());
        assertEquals(2, prof.getKetteryys());
        assertEquals(2, prof.getTaikaPuolustus());
        assertEquals(3, prof.getTaikaVoima());
        assertEquals(1, prof.getVoima());
        
        prof.setDruidiAlkuProfiili();
        
        assertEquals(9, prof.getElamaPisteet());
        assertEquals(3, prof.getKetteryys());
        assertEquals(1, prof.getTaikaPuolustus());
        assertEquals(1, prof.getTaikaVoima());
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
        assertEquals(vertailuProfiili.getTaikaVoima(), prof.getTaikaVoima());
        assertEquals(vertailuProfiili.getVoima() + 6, prof.getVoima());
    }
    
    @Test
    public void poistaaEsineenOikein() {
        prof.setVelhoAlkuProfiili();
        
        TaisteluEsine miekka = new TaisteluEsine("suuri miekka", Esine.MIEKKA);
        Profiili miekanProfiili = miekka.getProfiili();
        
        miekanProfiili.lisaaElamaPisteet(10);
        miekanProfiili.lisaaKetteryys(-2);
        miekanProfiili.lisaaVoima(0);
        miekanProfiili.lisaaTaikaPuolustus(-3);
        miekanProfiili.lisaaTaikaVoima(2);
        
        prof.poistaEsine(miekka);
        
        Profiili vertailuProfiili = new Profiili();
        vertailuProfiili.setVelhoAlkuProfiili();
        
        assertEquals(vertailuProfiili.getElamaPisteet() - 10, prof.getElamaPisteet());
        assertEquals(vertailuProfiili.getKetteryys() + 2, prof.getKetteryys());
        assertEquals(vertailuProfiili.getTaikaPuolustus() + 3, prof.getTaikaPuolustus());
        assertEquals(vertailuProfiili.getTaikaVoima() - 2, prof.getTaikaVoima());
        assertEquals(vertailuProfiili.getVoima(), prof.getVoima());
    }
}
