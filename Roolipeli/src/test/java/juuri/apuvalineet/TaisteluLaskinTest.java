
package juuri.apuvalineet;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaisteluLaskinTest {
    
    private TaisteluLaskin laskin;
    private Profiili lyoja;
    private Profiili lyotava;
    
    @Before
    public void setUp() {
        this.laskin = new TaisteluLaskin(new Random());
        this.lyoja = new Profiili();
        this.lyotava = new Profiili();
    }
    
    @Test
    public void valmiudetNollaLyonninJalkeen() {
        lyotava.asetaHyokkaysValmius(10);
        lyotava.asetaPuolustusValmius(10);
        lyoja.asetaHyokkaysValmius(12);
        lyoja.asetaPuolustusValmius(12);
        laskin.lyonti(lyoja, lyotava);
        
        assertTrue(lyoja.getHyokkaysValmius() == 0);
        assertTrue(lyoja.getPuolustusValmius() == 12);
        assertTrue(lyotava.getHyokkaysValmius() == 10);
        assertTrue(lyotava.getPuolustusValmius() == 0);
    }
    
    @Test
    public void lyontiMolemmatNolla() {
        int maara = laskin.lyonti(lyoja, lyotava);
        assertTrue(maara == 0);
    }
    
    @Test
    public void lyontiMeneeLapi() {
        lyotava.lisaaKetteryys(4);
        lyoja.lisaaVoima(12);
        lyoja.lisaaKetteryys(12);
        
        int maara = laskin.lyonti(lyoja, lyotava);
        assertTrue( maara >= 1 && maara <= 11);
    }
    
    @Test
    public void lyontiKunMolemmillaKaikkiYliNolla() {
        lyotava.lisaaKetteryys(2);
        lyotava.lisaaVoima(2);
        lyoja.lisaaKetteryys(10);
        lyoja.lisaaVoima(10);
        
        int maara = laskin.lyonti(lyoja, lyotava);
        assertTrue(maara >= 1 && maara <= 10);
    }
    
    @Test
    public void taikaLyontiKunKaikkiNolla() {
        int maara = laskin.taikaLyonti(lyoja, lyotava);
        assertTrue(maara == 0);
    }
    
    @Test
    public void taikaLyontiMeneeLapi() {
        lyoja.lisaaTaikaVoima(6);
        
        int maara = laskin.taikaLyonti(lyoja, lyotava);
        assertTrue(maara >= 1 && maara <= 7);
    }
    
    @Test
    public void taikaLyontiMolemmatYliNollia() {
        lyoja.lisaaTaikaVoima(4);
        lyotava.lisaaTaikaPuolustus(14);
        
        assertTrue(laskin.taikaLyonti(lyoja, lyotava) == 0);
    }
    
    @Test
    public void taikaLyontiMolemmatYliNollia2() {
        lyoja.lisaaTaikaVoima(16);
        lyotava.lisaaTaikaPuolustus(1);
        
        int maara = laskin.taikaLyonti(lyoja, lyotava);
        assertTrue(maara >= 1 && maara <= 17);
    }
    
    @Test
    public void peraantyminenToimiiEiPakoon() {
        lyoja.lisaaKetteryys(10);
        lyotava.lisaaKetteryys(2);
        
        assertFalse(laskin.peraantyminen(lyotava, lyoja));
    }
    
    @Test
    public void peraantyminenToimiiPakoon() {
        lyotava.lisaaKetteryys(12);
        lyoja.lisaaKetteryys(2);
        
        assertTrue(laskin.peraantyminen(lyotava, lyoja));
    }
    
    @Test
    public void taistelunPaatosToimii() {
        lyotava.asetaHyokkaysValmius(12);
        lyotava.asetaPuolustusValmius(11);
        lyoja.asetaHyokkaysValmius(44);
        lyoja.asetaPuolustusValmius(55);
        
        lyotava.lisaaElamaPisteet(15);
        lyotava.lisaaNykyinenElamaPisteet(-10);
        
        laskin.taistelunPaatos(lyoja, lyotava);
        assertTrue(lyoja.getHyokkaysValmius() == 0);
        assertTrue(lyoja.getPuolustusValmius() == 0);
        assertTrue(lyotava.getPuolustusValmius() == 0);
        assertTrue(lyotava.getHyokkaysValmius() == 0);
        assertTrue(lyotava.getNykyinenElamaPisteet() == 15);
    }
    
    @Test
    public void taistelunPaatosToimii2() {
        lyotava.lisaaElamaPisteet(12);
        lyotava.lisaaNykyinenElamaPisteet(-13);
        
        laskin.taistelunPaatos(lyoja, lyotava);
        assertTrue(lyotava.getNykyinenElamaPisteet() <= 0);
    }
    
}
