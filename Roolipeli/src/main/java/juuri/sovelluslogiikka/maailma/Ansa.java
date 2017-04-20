package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Ansat ovat luolaston kohteita, joihin pelaaja voi tahtomattaan joutua. Ne
 * yleensä aiheuttavat pelaajan hahmolle jonkinlaista vahinkoa.
 */
public class Ansa extends Kohde {

    public Ansa() {
        this.koodi = Kohde.ANSA;
        this.nimi = "ansa";
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
