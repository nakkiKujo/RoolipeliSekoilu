/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.peli;


import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.maailma.Hirvio;
import org.junit.Test;
import static org.junit.Assert.*;


public class HirvionLuojaTest {

    @Test
    public void luoNoidanOikein() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.NOITA);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        hh.getEsineet().remove(Esine.RIIMU);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
        assertTrue(hh.getProfiili().getVoima() == 1);
        assertTrue(hh.getProfiili().getTaikaVoima() == 2);
        assertTrue(hh.getProfiili().getKetteryys() == 1);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 2);
        assertTrue(hh.getProfiili().getElamaPisteet() == 5);
    }
    
    @Test
    public void luoPronssiAvainRotanOikein() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.SUURIROTTAPRONSSIAVAIN);
        assertTrue(hh.getEsineet().contains(Esine.PRONSSIAVAIN));
        
        assertTrue(hh.getProfiili().getVoima() == 2);
        assertTrue(hh.getProfiili().getTaikaVoima() == 0);
        assertTrue(hh.getProfiili().getKetteryys() == 2);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 0);
        assertTrue(hh.getProfiili().getElamaPisteet() == 8);
    }
    
    @Test
    public void luoNokkelaNoita() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.NOKKELANOITA);
        
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        hh.getEsineet().remove(Esine.RIIMU);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        hh.getEsineet().remove(Esine.RIIMU);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        
        assertTrue(hh.getProfiili().getVoima() == 1);
        assertTrue(hh.getProfiili().getTaikaVoima() == 3);
        assertTrue(hh.getProfiili().getKetteryys() == 1);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 2);
        assertTrue(hh.getProfiili().getElamaPisteet() == 8);
    }
    
    @Test
    public void luoValkokasvo() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.VALKOKASVO);
        
        assertTrue(hh.getProfiili().getVoima() == 4);
        assertTrue(hh.getProfiili().getTaikaVoima() == 0);
        assertTrue(hh.getProfiili().getKetteryys() == 4);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 3);
        assertTrue(hh.getProfiili().getElamaPisteet() == 11);
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
    }
    
    @Test
    public void luoLuuranko() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.LUURANKO);
        
        assertTrue(hh.getProfiili().getVoima() == 3);
        assertTrue(hh.getProfiili().getTaikaVoima() == 0);
        assertTrue(hh.getProfiili().getKetteryys() == 5);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 3);
        assertTrue(hh.getProfiili().getElamaPisteet() == 6);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
    }
    
    @Test
    public void luoMonjaOtus() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.MONJAOTUS);
        
        assertTrue(hh.getProfiili().getVoima() == 2);
        assertTrue(hh.getProfiili().getTaikaVoima() == 0);
        assertTrue(hh.getProfiili().getKetteryys() == 7);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 7);
        assertTrue(hh.getProfiili().getElamaPisteet() == 4);
    }
    
    @Test
    public void luoSynkkkaHopeaAvain() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.SYNKKAHOPEAAVAIN);
        
        assertTrue(hh.getProfiili().getVoima() == 4);
        assertTrue(hh.getProfiili().getTaikaVoima() == 5);
        assertTrue(hh.getProfiili().getKetteryys() == 4);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 4);
        assertTrue(hh.getProfiili().getElamaPisteet() == 10);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
        assertTrue(hh.getEsineet().contains(Esine.HOPEAAVAIN));
    }
    
    @Test
    public void luoSynkkaKultaAvain() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.SYNKKAKULTAVAIN);
        
        assertTrue(hh.getProfiili().getVoima() == 4);
        assertTrue(hh.getProfiili().getTaikaVoima() == 5);
        assertTrue(hh.getProfiili().getKetteryys() == 4);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 4);
        assertTrue(hh.getProfiili().getElamaPisteet() == 10);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
        assertTrue(hh.getEsineet().contains(Esine.KULTAAVAIN));
    }
    
    @Test
    public void luoSynkka() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.SYNKKA);
        
        assertTrue(hh.getProfiili().getVoima() == 4);
        assertTrue(hh.getProfiili().getTaikaVoima() == 5);
        assertTrue(hh.getProfiili().getKetteryys() == 4);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 4);
        assertTrue(hh.getProfiili().getElamaPisteet() == 10);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
    }
    
    @Test
    public void luoEpakuollutVelho() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.EPAKUOLLUTVELHO);
        
        assertTrue(hh.getProfiili().getVoima() == 3);
        assertTrue(hh.getProfiili().getTaikaVoima() == 9);
        assertTrue(hh.getProfiili().getKetteryys() == 3);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 6);
        assertTrue(hh.getProfiili().getElamaPisteet() == 12);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
    }
    
    @Test
    public void luoEpakuollutJatti() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.EPAKUOLLUTJATTILAINEN);
        
        assertTrue(hh.getProfiili().getVoima() == 6);
        assertTrue(hh.getProfiili().getTaikaVoima() == 0);
        assertTrue(hh.getProfiili().getKetteryys() == 4);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 3);
        assertTrue(hh.getProfiili().getElamaPisteet() == 14);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
    }
    
    @Test
    public void luoEpakuollutJattiPronssiAvain() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.EPAKUOLLUTJATTIPRONSSIAVAIN);
        
        assertTrue(hh.getProfiili().getVoima() == 6);
        assertTrue(hh.getProfiili().getTaikaVoima() == 0);
        assertTrue(hh.getProfiili().getKetteryys() == 4);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 3);
        assertTrue(hh.getProfiili().getElamaPisteet() == 14);
        assertTrue(hh.getEsineet().contains(Esine.RIIMU));
        assertTrue(hh.getEsineet().contains(Esine.PARANTAVAVOIDE));
        assertTrue(hh.getEsineet().contains(Esine.PRONSSIAVAIN));
    }
    
    @Test
    public void luoPiru() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.PIRU);
        
        assertTrue(hh.getProfiili().getVoima() == 9);
        assertTrue(hh.getProfiili().getTaikaVoima() == 9);
        assertTrue(hh.getProfiili().getKetteryys() == 9);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 9);
        assertTrue(hh.getProfiili().getElamaPisteet() == 17);
        assertTrue(hh.getEsineet().contains(Esine.KULTAAVAIN));
    }
    
    @Test
    public void luoLangennut() {
        Hirvio hh = HirvionLuoja.luoHirvio(HirvionLuoja.LANGENNUTENKELI);
        
        assertTrue(hh.getProfiili().getVoima() == 7);
        assertTrue(hh.getProfiili().getTaikaVoima() == 5);
        assertTrue(hh.getProfiili().getKetteryys() == 7);
        assertTrue(hh.getProfiili().getTaikaPuolustus() == 5);
        assertTrue(hh.getProfiili().getElamaPisteet() == 15);
        
        TaisteluEsine kk = (TaisteluEsine) hh.getEsineet().get(0);
        assertTrue(kk.getProfiili().getVoima() == 4);
        assertTrue(kk.getProfiili().getTaikaVoima() == 3);
        assertTrue(kk.getProfiili().getKetteryys() == 3);
        assertTrue(kk.getProfiili().getTaikaPuolustus() == 3);
        assertTrue(kk.getProfiili().getElamaPisteet() == 4);
    }
}
