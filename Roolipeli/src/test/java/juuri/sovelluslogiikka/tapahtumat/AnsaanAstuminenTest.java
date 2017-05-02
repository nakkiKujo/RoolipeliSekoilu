/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Ansa;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.peli.KohteidenLuoja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnsaanAstuminenTest {
    
    private Ansa ansa;
    private AnsaanAstuminen astu;
    private Soturi soturi;
    private Luolasto luola;
    
    @Before
    public void setUp() {
        this.ansa = (Ansa) KohteidenLuoja.luoKohde(KohteidenLuoja.ANSALIEKKI);
        ansa.setSijainti(3, 3);
        this.astu = (AnsaanAstuminen) ansa.getTapahtuma();
        this.soturi = new Soturi("pekka");
        soturi.getProfiili().setSoturiAlkuProfiili();
        this.luola = new Luolasto();
        
    }
    
    @Test
    public void valmisteluOikein() {
        astu.valmisteleTapahtuma(soturi);
        assertTrue(astu.getTapahtumateksti().equals("Auts! Astuit vahingossa helvetilliseen liekkiansaan.\n"
                + "Hahmosi koki vahinkoa 10 elämäpistettä."));
    }
    
    @Test
    public void toteuttaaOikein() {
        luola.luoSeuraavaTaso();
        luola.asetaAnsa(3, 3, KohteidenLuoja.ANSALIEKKI);
        astu.valmisteleTapahtuma(soturi);
        astu.toteutaVaihtoehtoYksi(soturi, luola);
        Soturi vertailuSoturi = new Soturi("kalle");
        vertailuSoturi.getProfiili().setSoturiAlkuProfiili();
        
        assertEquals(vertailuSoturi.getProfiili().getNykyinenElamaPisteet() - 10, soturi.getProfiili().getNykyinenElamaPisteet());
        assertEquals(Kohde.KAYTAVA, luola.haeSijainnista(ansa.getSijainti()).getKoodi());
    }
    
    @Test
    public void toteuttaaOikein2() {
        luola.luoSeuraavaTaso();
        luola.asetaAnsa(3, 3, KohteidenLuoja.ANSALIEKKI);
        astu.valmisteleTapahtuma(soturi);
        astu.toteutaVaihtoehtoKaksi(soturi, luola);
        Soturi vertailuSoturi = new Soturi("kalle");
        vertailuSoturi.getProfiili().setSoturiAlkuProfiili();
        
        assertEquals(vertailuSoturi.getProfiili().getNykyinenElamaPisteet() - 10, soturi.getProfiili().getNykyinenElamaPisteet());
        assertEquals(Kohde.KAYTAVA, luola.haeSijainnista(ansa.getSijainti()).getKoodi());
    }
    
}
