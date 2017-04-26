package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Käytävä on Kohteen aliluokka. Se on luolaston peruselementti, ja suurimman
 * osan ajastaan pelaajan hahmo viettää kulkien käytäviä pitkin.
 *
 * Usein käytävillä ei ole tapahtumia.
 */
public class Kaytava extends Kohde {

    /**
     * Luodaan uusi käytävä. Käytävällä voi kulkea.
     */
    public Kaytava() {
        this.koodi = Kohde.KAYTAVA;
        this.nimi = "käytävä";
        this.tapahtuma = null;

        //Käytävillä voi kulkea.
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());

        if (etaisyysHahmoonX > 1 || etaisyysHahmoonY > 1) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(new Color(153, 153, 153));
        }

        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
