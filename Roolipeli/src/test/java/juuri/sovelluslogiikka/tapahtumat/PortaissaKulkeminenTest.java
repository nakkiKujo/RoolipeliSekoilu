/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.maailma.Portaat;
import juuri.sovelluslogiikka.peli.KohteidenLuoja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PortaissaKulkeminenTest {
    
    Portaat pp;
    PortaissaKulkeminen kulku;
    Luolasto luola;
    
    @Before
    public void setUp() {
        this.pp = (Portaat) KohteidenLuoja.luoKohde(KohteidenLuoja.PORTAAT);
        this.kulku = (PortaissaKulkeminen) pp.getTapahtuma();
        this.luola = new Luolasto();
    }
    
    @Test
    public void valmisteleeOikein() {
        kulku.valmisteleTapahtuma(new Soturi("pekka"));
        assertTrue(kulku.getVaihtoehtoYksi().equals("Mene alas."));
        assertTrue(kulku.getVaihtoehtoKaksi().equals("En ole vielä valmis."));
    }
    
    @Test
    public void toteuttaaOikeinTasolle2() {
        Soturi pekka = new Soturi("pekka");
        luola.luoSeuraavaTaso();
        kulku.toteutaVaihtoehtoYksi(pekka, luola);
        assertTrue(pekka.getSijainti().getX() == 7);
        assertTrue(pekka.getSijainti().getY() == 4);
        assertTrue(luola.getNykyinenTaso() == 2);
    }
    
    @Test
    public void toteuttaaOikeinTasolle3() {
        Soturi pekka = new Soturi("pekka");
        luola.luoSeuraavaTaso();
        luola.luoSeuraavaTaso();
        kulku.toteutaVaihtoehtoYksi(pekka, luola);
        assertTrue(pekka.getSijainti().getX() == 7);
        assertTrue(pekka.getSijainti().getY() == 1);
        assertTrue(luola.getNykyinenTaso() == 3);
    }

}
