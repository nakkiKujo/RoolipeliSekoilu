
package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.tapahtumat.OvenAvaus;

//Luolaston rakennetta ylläpidetään taulukossa "koordinaatisto",
//joka sisältää Kohteita. Jokaisella Kohteella on oma koodi, jolla
//ne voidaan tunnistaa:

//seina = 1,
//käytävä = 2,
//ovi = 3


public class Luolasto {
    private Kohde[][] koordinaatisto;
    private int leveys;
    private int korkeus;
    
    public Luolasto(int leveys, int korkeus) {
        this.koordinaatisto = new Kohde[leveys][korkeus];
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    //Luolasto koostuu useammasta eri kerroksesta. 
    public void luoTaso1() {
        
        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            asetaSeina(i, 0);
            asetaSeina(i, korkeus - 1);
        }
        for (int i = 1; i < korkeus - 1; i++) {
            asetaSeina(0, i);
            asetaSeina(leveys - 1, i);
        }
        
        //sisusta on käytävää
        for (int i = 1; i < leveys - 1; i++) {
            for (int j = 1; j < korkeus - 1; j++) {
                asetaKaytava(i, j);
            }
        }
        
        //asetetaan lukittu ovi kohtaan 2,1
        asetaLukittuOvi(2, 1);
    }
    
    public void luoTaso2() {
        
    }
    
    public void luoTaso3() {
        
    }
    
    public boolean asetaSeina(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        koordinaatisto[x][y] = new Seina(null);
        return true;
    }
    
    public boolean asetaKaytava(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        koordinaatisto[x][y] = new Kaytava(null);
        return true;
    }
    
    public boolean asetaLukittuOvi(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        
        Ovi ovi = new Ovi(true, null);
        OvenAvaus ovenAvaus = new OvenAvaus(ovi);
        ovi.setTapahtuma(ovenAvaus);
        koordinaatisto[x][y] = ovi;
        
        return true;
    }
    
    public boolean asetaAvoinOvi(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        
        Ovi ovi = new Ovi(false, null);
        OvenAvaus ovenAvaus = new OvenAvaus(ovi);
        ovi.setTapahtuma(ovenAvaus);
        koordinaatisto[x][y] = ovi;
        
        return true;
    }
    
    public Kohde haeKoordinaateista(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }
        return koordinaatisto[x][y];
    }
    
    public Kohde haeSijainnista(Sijainti ss) {
        int x = ss.getX();
        int y = ss.getY();
        
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }
        
        return koordinaatisto[x][y];
    }
    
}
