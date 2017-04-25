package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Ansat ovat luolaston kohteita, joihin pelaaja voi tahtomattaan joutua. Ne
 * yleensä aiheuttavat pelaajan hahmolle jonkinlaista vahinkoa.
 */
public class Ansa extends Kohde {
    
    private int vahinko;
    
    public Ansa(String ansanNimi, Tapahtuma tapahtuma, int ansanTekemaVahinko) {
        this.koodi = Kohde.ANSA;
        this.nimi = ansanNimi;
        this.tapahtuma = tapahtuma;
        this.voikoKulkea = true;
        this.vahinko = ansanTekemaVahinko;
    }
    
    public int getAnsanTekemaVahinko() {
        return this.vahinko;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());
        
        if(etaisyysHahmoonX > 1 || etaisyysHahmoonY > 1) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.GREEN);
        }
        
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
