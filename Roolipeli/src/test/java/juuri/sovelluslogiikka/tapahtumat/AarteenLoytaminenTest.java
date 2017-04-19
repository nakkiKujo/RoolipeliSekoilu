
package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Aarre;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AarteenLoytaminenTest {
    
    private Luolasto luola;
    private AarteenLoytaminen loyto;
    private Aarre aarre;
    private Soturi hahmo;
    private TaisteluEsine miekka;
    private YleisEsine kampa;
    
    @Before
    public void setUp() {
        this.luola = new Luolasto();
        luola.luoTaso1();
        luola.asetaAarre(3, 3, "pekan aarre");
        this.aarre = (Aarre) luola.haeKoordinaateista(3, 3);
        this.miekka = new TaisteluEsine("miekkanen", Esine.MIEKKA);
        this.kampa = new YleisEsine("kiva kampa", Esine.KYPARA);
        aarre.lisaaAarre(miekka);
        aarre.lisaaAarre(kampa);
        this.loyto = (AarteenLoytaminen) aarre.getTapahtuma();
        this.hahmo = new Soturi("pekka");
    }
    
    @Test
    public void toteuttaaAarteenOttamisenOikein() {
        loyto.valmisteleTapahtuma(hahmo);
        loyto.toteutaVaihtoehtoYksi(hahmo, luola);
        
        assertEquals(Kohde.KAYTAVA, luola.haeKoordinaateista(3, 3).getKoodi());
        assertTrue(hahmo.getReppu().onkoRepussa(miekka));
        assertTrue(hahmo.getReppu().onkoRepussa(kampa));
    }
            
    
}
