/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.peli;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.maailma.Aarre;
import juuri.sovelluslogiikka.maailma.Ansa;
import juuri.sovelluslogiikka.maailma.Portaat;
import org.junit.Test;
import static org.junit.Assert.*;


public class KohteidenLuojaTest {
    

    @Test
    public void luoAarteetOikein() {
        Aarre aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJOSSAPRONSSIAVAIN);
        assertTrue(aa.getAarteet().contains(Esine.PRONSSIAVAIN));
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJOSSAMIEKKA1);
        TaisteluEsine taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertTrue(taisteluEsine.getProfiili().getVoima() == 1);
        assertTrue(taisteluEsine.getProfiili().getKetteryys() == 1);
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJOSSAMIEKKA2);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertTrue(taisteluEsine.getProfiili().getVoima() == 3);
        assertTrue(taisteluEsine.getProfiili().getKetteryys() == -1);
        assertTrue(taisteluEsine.getProfiili().getElamaPisteet() == 1);
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREMIEKKA3);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertTrue(taisteluEsine.getProfiili().getVoima() == 3);
        assertTrue(taisteluEsine.getProfiili().getKetteryys() == 1);
        assertTrue(taisteluEsine.getProfiili().getElamaPisteet() == 2);
        assertTrue(taisteluEsine.getProfiili().getTaikaPuolustus() == 2);
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJOSSARIIMUJATAIKASAUVA);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertTrue(taisteluEsine.getProfiili().getTaikaVoima() == 2);
        assertTrue(aa.getAarteet().contains(Esine.RIIMU));
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJOSSARIIMUJAJAMEDALJONKI);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertTrue(aa.getAarteet().contains(Esine.RIIMU));
        assertTrue(taisteluEsine.getProfiili().getElamaPisteet() == 1);
        assertTrue(taisteluEsine.getProfiili().getVoima() == 2);
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARRE5VOIDETTA);
        aa.poistaEsine(Esine.PARANTAVAVOIDE);
        aa.poistaEsine(Esine.PARANTAVAVOIDE);
        aa.poistaEsine(Esine.PARANTAVAVOIDE);
        aa.poistaEsine(Esine.PARANTAVAVOIDE);
        assertTrue(aa.getAarteet().contains(Esine.PARANTAVAVOIDE));
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREKYPARA1);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        TaisteluEsine taisteluEsine2 = (TaisteluEsine) aa.getAarteet().get(1);
        
        assertEquals(1, taisteluEsine.getProfiili().getVoima());
        assertEquals(1, taisteluEsine.getProfiili().getElamaPisteet());
        assertEquals(1, taisteluEsine.getProfiili().getKetteryys());
        assertEquals(-2, taisteluEsine.getProfiili().getTaikaPuolustus());
        assertEquals(-1, taisteluEsine.getProfiili().getTaikaVoima());
        
        assertEquals(1, taisteluEsine2.getProfiili().getElamaPisteet());
        assertEquals(-1, taisteluEsine2.getProfiili().getKetteryys());
        assertEquals(1, taisteluEsine2.getProfiili().getTaikaVoima());
        assertEquals(1, taisteluEsine2.getProfiili().getTaikaPuolustus());
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREKYPARA2);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertEquals(2, taisteluEsine.getProfiili().getVoima());
        assertEquals(2, taisteluEsine.getProfiili().getElamaPisteet());
        assertEquals(1, taisteluEsine.getProfiili().getKetteryys());
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREKYPARA3);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertEquals(3, taisteluEsine.getProfiili().getVoima());
        assertEquals(3, taisteluEsine.getProfiili().getElamaPisteet());
        assertEquals(2, taisteluEsine.getProfiili().getKetteryys());
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJUMALTENHAARNISKA);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertEquals(3, taisteluEsine.getProfiili().getTaikaPuolustus());
        assertEquals(4, taisteluEsine.getProfiili().getElamaPisteet());
        assertEquals(1, taisteluEsine.getProfiili().getVoima());
        
        aa = (Aarre) KohteidenLuoja.luoKohde(KohteidenLuoja.AARREJUMALTENMEDALJONKI);
        taisteluEsine = (TaisteluEsine) aa.getAarteet().get(0);
        assertEquals(2, taisteluEsine.getProfiili().getTaikaVoima());
        assertEquals(2, taisteluEsine.getProfiili().getElamaPisteet());
        assertEquals(2, taisteluEsine.getProfiili().getVoima());
    }
    
    @Test
    public void luoKohdeNullKunKoodiVaara() {
        assertTrue(KohteidenLuoja.luoKohde(0) == null);
    }
    
    @Test
    public void luoAnsanOikein() {
        Ansa aa = (Ansa) KohteidenLuoja.luoKohde(KohteidenLuoja.ANSATHEEND);
        assertEquals(1000, aa.getAnsanTekemaVahinko());
        assertFalse(aa.getTapahtuma() == null);
    }
    
    @Test
    public void luoPortaatOikein() {
        Portaat pp = (Portaat) KohteidenLuoja.luoKohde(KohteidenLuoja.PORTAAT);
        assertTrue(pp.getNimi().equals("portaat"));
        assertFalse(pp.getTapahtuma() == null);
    }
}
