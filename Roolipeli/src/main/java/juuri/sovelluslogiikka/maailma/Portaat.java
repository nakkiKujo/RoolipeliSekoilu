package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;

/**
 * Portaat ovat luolaston kohde, jonka kautta pelaaja voi edetä syvemmälle
 * luolaan. Edetessään portaissa ei pelaaja voi enää palata takaisin ylemmälle
 * luolaston tasolle.
 */
public class Portaat extends Kohde {

    /**
     * Metodi luo uudet portaat. Portaiden läpi ei voi kulkea.
     */
    public Portaat() {
        this.koodi = Kohde.PORTAAT;
        this.nimi = "portaat";
        this.voikoKulkea = false;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());

        if (etaisyysHahmoonX > 1 || etaisyysHahmoonY > 1) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.ORANGE);
        }

        g.fillRect(x, y, mittakaava, mittakaava);
    }

}
