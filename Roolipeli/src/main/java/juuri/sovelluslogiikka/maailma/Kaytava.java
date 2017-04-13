package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Käytävä on Kohteen aliluokka. Se on luolaston peruselementti, ja suurimman
 * osan ajastaan pelaajan hahmo viettää kulkien käytäviä pitkin.
 *
 * Usein käytävien tapahtuma on null.
 */
public class Kaytava extends Kohde {

    public Kaytava(Tapahtuma tapahtuma) {
        this.koodi = Kohde.KAYTAVA;
        this.nimi = "käytävä";
        this.tapahtuma = tapahtuma;

        //Käytävillä voi kulkea.
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
