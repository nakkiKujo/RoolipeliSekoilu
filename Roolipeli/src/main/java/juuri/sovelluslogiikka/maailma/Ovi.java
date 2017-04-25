package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Ovi on Kohteen aliluokka. Ovi voi olla avoin, jolloin pelaaja voi normaalisti
 * kulkea sen läpi oven avattua. Ovi voi myös olla lukossa, jolloin sen läpi ei voi kulkea
 * ilman esimerkiksi avainta.
 */
public class Ovi extends Kohde {

    private boolean lukittu;
    private YleisEsine avaaja;

    public Ovi(boolean onkoLukittu, Tapahtuma tapahtuma, YleisEsine avaaja, String ovenNimi) {
        this.koodi = Kohde.OVI;
        this.nimi = ovenNimi;
        this.lukittu = onkoLukittu;

        //Ovien läpi ei voi kulkea
        this.voikoKulkea = false;

        this.tapahtuma = tapahtuma;
        this.avaaja = avaaja;
    }

    public boolean onkoLukittu() {
        return lukittu;
    }

    public YleisEsine getAvaaja() {
        return this.avaaja;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());

        if (etaisyysHahmoonX > 1 || etaisyysHahmoonY > 1) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(new Color(51, 51, 0));
        }

        g.fillRect(x, y, mittakaava, mittakaava);
    }

}
