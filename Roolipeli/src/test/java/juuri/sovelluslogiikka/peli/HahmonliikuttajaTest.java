
package juuri.sovelluslogiikka.peli;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmonliikuttajaTest {
    
    private Hahmo hahmo;
    private Luolasto luola;
    private Hahmonliikuttaja liikuttaja;
    
    @Before
    public void setUp() {
        this.liikuttaja = new Hahmonliikuttaja();
        this.hahmo = new Soturi("Janne");
        
        //luodaan 4x4 luola, jossa ulkoreunat seinää ja sisällä on käytävää, sisällä myös yksi ovi
        this.luola = new Luolasto(4, 4);
    }
    
    @Test
    public void hahmonLiikuttaminenVaarallaKomennollaOnNull() {
        String komento = "liiku vasenmalle";
        Kohde kk = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        boolean onkoTosi = true;
        if(!(kk == null)) {
            onkoTosi = false;
        }
        
        assertTrue(onkoTosi);
    }
    
    @Test
    public void hahmonLiikuttaminenAlas() {
        String komento = "liiku alas";
        Kohde loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(2, loydettyKohde.getKoodi());
        
        loydettyKohde = liikuttaja.liikutaHahmoa(komento, luola, hahmo);
        assertEquals(1, loydettyKohde.getKoodi());
    }
    
    private void luoLuola() {
        for (int i = 0; i < 4; i++) {
            luola.asetaSeina(0, i);
            luola.asetaSeina(i, 0);
            luola.asetaSeina(3 - i, 3);
            luola.asetaSeina(3, 3 - i);
        }
        
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                luola.asetaKaytava(i, j);
            }
        }
        
        luola.asetaOvi(2, 1);
    }
    
}
