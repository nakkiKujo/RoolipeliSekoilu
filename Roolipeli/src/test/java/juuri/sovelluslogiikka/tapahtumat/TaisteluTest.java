/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.maailma.Hirvio;
import juuri.sovelluslogiikka.peli.HirvionLuoja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaisteluTest {

    Hirvio hh;
    Soturi ss;
    Taistelu tt;

    @Before
    public void setUp() {
        this.hh = new Hirvio("kalle");
        this.tt = new Taistelu(hh);
        hh.setTapahtuma(tt);
        this.ss = new Soturi("kalle");
    }

    @Test
    public void hakeeHirvion() {
        assertTrue(tt.getHirvio().equals(hh));
    }

    @Test
    public void toteuttaaVaihtoehdonYksi() {
        ss.getProfiili().lisaaKetteryys(2);
        hh.getProfiili().lisaaKetteryys(2);
        tt.toteutaVaihtoehtoYksi(ss, null);
        assertTrue(hh.getProfiili().getHyokkaysValmius() == 0);
        assertTrue(hh.getProfiili().getPuolustusValmius() == 0);

        hh.getProfiili().lisaaKetteryys(1);
        tt.toteutaVaihtoehtoYksi(ss, null);
        assertTrue(hh.getProfiili().getHyokkaysValmius() > 0 || hh.getProfiili().getPuolustusValmius() > 0);
    }

    @Test
    public void toteuttaaVaihtoehdonKaksiEiPakoon() {
        hh.getProfiili().lisaaKetteryys(8);

        boolean pako = tt.toteutaVaihtoehtoKaksiTaistelu(ss);
        assertFalse(pako);
    }

    @Test
    public void toteuttaaVaihtoehdonKaksiPaaseePakoon() {
        ss.getProfiili().lisaaKetteryys(10);

        boolean pako = tt.toteutaVaihtoehtoKaksiTaistelu(ss);
        assertTrue(pako);
    }

    @Test
    public void pelaajaLyoHirvioKuolee() {
        tt.toteutaVaihtoehtoYksi(ss, null);

        hh.getProfiili().lisaaElamaPisteet(-100);
        boolean jatkuuko = tt.pelaajaLyo();
        assertFalse(jatkuuko);
    }

    @Test
    public void hirvioLyoPelaajaKuolee() {
        tt.toteutaVaihtoehtoYksi(ss, null);
        boolean jatkuuko = tt.hirvioLyo();
        assertFalse(jatkuuko);
    }

    @Test
    public void pelaajaLyoHirvioKuoleeSaaEsineet() {
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.NOITA);
        ss.getProfiili().setSoturiAlkuProfiili();
        ss.getProfiili().asetaPuolustusValmius(10);

        hh.getProfiili().lisaaElamaPisteet(-100);

        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        boolean jatkuuko = tt.pelaajaLyo();

        assertFalse(jatkuuko);
        assertTrue(ss.getProfiili().getPuolustusValmius() == 0);
        assertTrue(ss.getReppu().onkoRepussa(Esine.RIIMU));
    }
    
    @Test
    public void pelaajaLyoHirvioEiKuole() {
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.SUURIROTTA);
        hh.getProfiili().lisaaVoima(-10);
        ss.getProfiili().setSoturiAlkuProfiili();

        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        boolean jatkuuko = tt.pelaajaLyo();

        assertTrue(jatkuuko);
        assertTrue(hh.getProfiili().getNykyinenElamaPisteet() >= 4);
        assertTrue(hh.getProfiili().getNykyinenElamaPisteet() <= 7);
    }

    @Test
    public void pelaajaLoihtiiHirvioKuolee() {
        tt.toteutaVaihtoehtoYksi(ss, null);

        hh.getProfiili().lisaaElamaPisteet(-100);
        boolean jatkuuko = tt.pelaajaLoihtiiLoitsun();
        assertFalse(jatkuuko);
    }
    
    @Test
    public void pelaajaLoihtiiHirvioEiKuole() {
        ss.getProfiili().setVelhoAlkuProfiili();
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.SUURIROTTA);
        
        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        boolean jatkuuko = tt.pelaajaLoihtiiLoitsun();

        assertTrue(jatkuuko);
        assertTrue(hh.getProfiili().getNykyinenElamaPisteet() >= 3);
        assertTrue(hh.getProfiili().getNykyinenElamaPisteet() <= 7);
    }

    @Test
    public void pelaajaLoihtiiHirvioKuoleeSaaEsineet() {
        Soturi kalle = new Soturi("kalle");
        kalle.getProfiili().setVelhoAlkuProfiili();
        kalle.getProfiili().asetaPuolustusValmius(10);
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.SUURIROTTAPRONSSIAVAIN);
        hh.getProfiili().lisaaElamaPisteet(-100);

        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(kalle, null);
        tt.pelaajaLoihtiiLoitsun();

        assertTrue(kalle.getProfiili().getPuolustusValmius() == 0);
        assertTrue(kalle.getReppu().onkoRepussa(Esine.PRONSSIAVAIN));
    }

    @Test
    public void hirvioLoihtiiPelaajaKuolee() {
        tt.toteutaVaihtoehtoYksi(ss, null);
        boolean jatkuuko = tt.hirvioLoihtiiLoitsun();
        assertFalse(jatkuuko);
    }

    @Test
    public void hirvioLoihtiiPelaajaEiKuole() {
        ss.getProfiili().setDruidiAlkuProfiili();
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.NOKKELANOITA);

        tt.toteutaVaihtoehtoYksi(ss, null);
        boolean jatkuuko = tt.hirvioLoihtiiLoitsun();
        assertTrue(jatkuuko);
    }
    
    @Test
    public void pelaajaValmistautuuVaistoon() {
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.NOKKELANOITA);
        tt = (Taistelu) hh.getTapahtuma();
        
        ss.getProfiili().setDruidiAlkuProfiili();
        
        tt.toteutaVaihtoehtoYksi(ss, null);
        tt.pelaajaValmistautuuVaistoon();
        
        assertTrue(ss.getProfiili().getPuolustusValmius() == 0 || ss.getProfiili().getPuolustusValmius() == 3);
    }
    
    @Test
    public void pelaajaValmistautuuLyomaan() {
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.NOKKELANOITA);
        tt = (Taistelu) hh.getTapahtuma();
        
        ss.getProfiili().setDruidiAlkuProfiili();
        ss.getProfiili().lisaaVoima(1);
        
        tt.toteutaVaihtoehtoYksi(ss, null);
        tt.pelaajaValmistautuuHyokkaykseen();
        
        assertTrue(ss.getProfiili().getHyokkaysValmius() == 3);
    }
    
    @Test
    public void hirvioValmistautuuVaistoon() {
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.VALKOKASVO);
        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        tt.hirvioValmistautuuVaistoon();
        
        assertTrue(hh.getProfiili().getPuolustusValmius() == 3);
        
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.PIRU);
        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        tt.hirvioValmistautuuVaistoon();
        
        assertTrue(hh.getProfiili().getPuolustusValmius() == 5);
    }
    
    @Test
    public void hirvioValmistautuuLyomaan() {
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.LUURANKO);
        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        tt.hirvioValmistautuuHyokkaykseen();
        
        assertTrue(hh.getProfiili().getHyokkaysValmius() == 3);
        
        hh = HirvionLuoja.luoHirvio(HirvionLuoja.SYNKKA);
        tt = (Taistelu) hh.getTapahtuma();
        tt.toteutaVaihtoehtoYksi(ss, null);
        tt.hirvioValmistautuuHyokkaykseen();
        
        assertTrue(hh.getProfiili().getHyokkaysValmius() == 4);
    }

}
