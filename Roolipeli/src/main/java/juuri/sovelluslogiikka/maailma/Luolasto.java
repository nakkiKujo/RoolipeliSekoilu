
package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;

public class Luolasto {
    private Kohde[][] koordinaatisto;
    private int leveys;
    private int korkeus;
    
    public Luolasto(int leveys, int korkeus) {
        this.koordinaatisto = new Kohde[leveys][korkeus];
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    public void luoTaso1() {
        
        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            koordinaatisto[i][0] = new Seina();
            koordinaatisto[i][korkeus - 1] = new Seina();
        }
        for (int i = 1; i < korkeus - 1; i++) {
            koordinaatisto[0][i] = new Seina();
            koordinaatisto[leveys - 1][i] = new Seina();
        }
        
        //sisusta on käytävää
        for (int i = 1; i < leveys - 1; i++) {
            for (int j = 1; j < korkeus - 1; j++) {
                koordinaatisto[i][j] = new Kaytava();
            }
        }
    }
    
    public boolean asetaSeina(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        koordinaatisto[x][y] = new Seina();
        return true;
    }
    
    public boolean asetaKaytava(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        koordinaatisto[x][y] = new Kaytava();
        return true;
    }
    
    public boolean asetaOvi(int x, int y) {
        if(x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        koordinaatisto[x][y] = new Ovi();
        return true;
    }
    
    public Kohde haeKoordinaateista(int x, int y) {
        return koordinaatisto[x][y];
    }
    
    public Kohde haeSijainnista(Sijainti ss) {
        int x = ss.getX();
        int y = ss.getY();
        
        return koordinaatisto[x][y];
    }
    
}
