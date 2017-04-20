
package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Portaat ovat luolaston kohde, jonka kautta pelaaja voi edetä syvemmälle 
 * luolaan. Edetessään portaissa ei pelaaja voi enää palata takaisin ylemmälle
 * luolaston tasolle.
 */
public class Portaat extends Kohde {
    
    public Portaat() {
        this.koodi = Kohde.PORTAAT;
        this.nimi = "portaat";
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
            
}
