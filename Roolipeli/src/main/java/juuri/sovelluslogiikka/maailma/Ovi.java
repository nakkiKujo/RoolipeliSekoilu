package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Ovi on Kohteen aliluokka. Ovi voi olla avoin, jolloin pelaaja voi normaalisti
 * kulkea sen läpi oven avattua. Ovi voi myös olla lukossa, jolloin sen läpi ei
 * voi kulkea ilman esimerkiksi avainta.
 */
public class Ovi extends Kohde {

    private boolean lukittu;
    private YleisEsine avaaja;

    /**
     * Luo uuden oven. Parametri onkoLukittu kertoo, luodaanko avointa vai
     * lukittua ovea. Avaaja kertoo, mikä esine pystyy avaamaan oven. Lisäksi
     * asetetaan ovelle nimi.
     *
     * @param onkoLukittu onko ovi lukittu
     * @param avaaja esine, jolla oven voi avata
     * @param ovenNimi ovelle annettava nimi
     */
    public Ovi(boolean onkoLukittu, YleisEsine avaaja, String ovenNimi) {
        this.koodi = Kohde.OVI;
        this.nimi = ovenNimi;
        this.vari = new Color(51, 51, 0);
        this.lukittu = onkoLukittu;

        //Ovien läpi ei voi kulkea
        this.voikoKulkea = false;

        this.avaaja = avaaja;
    }

    /**
     * Kertoo, onko ovi lukossa. Palauttaa true, jos on lukossa, false, jos ei
     * ole lukossa.
     *
     * @return onko ovi lukossa
     */
    public boolean onkoLukittu() {
        return lukittu;
    }

    public YleisEsine getAvaaja() {
        return this.avaaja;
    }
}
