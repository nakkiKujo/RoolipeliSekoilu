package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Ovi on Kohteen aliluokka. Ovi voi olla avoin, jolloin pelaaja voi normaalisti
 * kulkea sen läpi. Ovi voi myös olla lukossa, jolloin sen läpi ei voi kulkea
 * ilman esimerkiksi avainta.
 */
public class Ovi extends Kohde {

    private boolean lukittu;
    private YleisEsine avaaja;

    public Ovi(boolean lukitus, Tapahtuma tapahtuma, YleisEsine avaaja) {
        this.koodi = Kohde.OVI;
        this.nimi = "ovi";
        this.lukittu = lukitus;

        //Ovien läpi kulkeminen riippuu sen lukituksesta.
        if (lukitus) {
            this.voikoKulkea = false;
        } else {
            this.voikoKulkea = true;
        }
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
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, mittakaava, mittakaava);
    }

}
