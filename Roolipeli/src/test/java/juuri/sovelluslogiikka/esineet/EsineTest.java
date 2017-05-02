/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.esineet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PenaJones
 */
public class EsineTest {
    
    @Test
    public void tunnistaaKaksiEsinettaSamaksi() {
        Esine miekka = new TaisteluEsine("hieno miekka", Esine.MIEKKA);
        Esine toinenMiekka = new TaisteluEsine("hieno miekka", Esine.MIEKKA);
        
        assertTrue(miekka.equals(toinenMiekka));
        assertTrue(toinenMiekka.equals(miekka));
        
        Esine haarukka = new YleisEsine("fork", Esine.AVAIN);
        Esine toinenHaarukka = new YleisEsine("fork", Esine.AVAIN);
        
        assertTrue(haarukka.equals(toinenHaarukka));
        assertTrue(toinenHaarukka.equals(haarukka));
    }
    
    @Test
    public void tunnistaaKaksiEsinettaErilaisiksi() {
        Esine kypara = new TaisteluEsine("iso kypra", Esine.KYPARA);
        Esine kypara2 = new TaisteluEsine("iso kypar", Esine.KYPARA);
        Esine kypara3 = new TaisteluEsine("iso kypra", Esine.MIEKKA);
        
        assertFalse(kypara.equals(kypara2));
        assertFalse(kypara.equals(kypara3));
    }
    
    @Test
    public void tunnistaaKaksiEsinettaErilaisiksiKaksi() {
        Esine haarukka = new YleisEsine("forg", Esine.AVAIN);
        Esine haarukka2 = new YleisEsine("fork", Esine.AVAIN);
        Esine haarukka3 = new YleisEsine("forg", Esine.MIEKKA);
        
        assertFalse(haarukka.equals(haarukka2));
        assertFalse(haarukka.equals(haarukka3));
    }
    
    @Test
    public void tunnistaaTaisteluJaYleisEsineet() {
        YleisEsine avain = new YleisEsine("oih", Esine.AVAIN);
        assertFalse(avain.getOnkoTaisteluEsine());
        TaisteluEsine miekka = new TaisteluEsine("miegga", Esine.MIEKKA);
        assertTrue(miekka.getOnkoTaisteluEsine());
    }
    
    @Test
    public void tunnistaaOnkoKaytossa() {
        TaisteluEsine miekka = new TaisteluEsine("oi mika miekka", Esine.MIEKKA);
        assertFalse(miekka.getOnkoKaytossa());
        miekka.setOnkoKaytossa(true);
        assertTrue(miekka.getOnkoKaytossa());
        miekka.setOnkoKaytossa(false);
        assertFalse(miekka.getOnkoKaytossa());
    }
    
}
