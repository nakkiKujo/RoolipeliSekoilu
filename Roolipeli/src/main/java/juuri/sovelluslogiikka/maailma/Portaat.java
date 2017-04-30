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
        this.vari = Color.ORANGE;
        this.voikoKulkea = false;
    }
}
