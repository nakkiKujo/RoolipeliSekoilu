package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Tämä luokka on yksi Hahmon perivistä aliluokista. TODO: Eroavuus muista
 * ammateista.
 */
public class Druidi extends Hahmo {

    public Druidi(String nimi) {
        super(nimi);
        this.ammatti = Hahmo.DRUIDI;
    }

    @Override
    public void piirra(Graphics g, int mittaKaava) {
        int x = this.sijainti.getX() * mittaKaava;
        int y = this.sijainti.getY() * mittaKaava;

        g.setColor(new Color(0, 153, 0));

        g.fillOval(x, y, mittaKaava, mittaKaava);
    }
}
