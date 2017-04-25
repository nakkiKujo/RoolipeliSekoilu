package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Tämä luokka on yksi Hahmon perivistä aliluokista. Soturia käyetään ohjelman
 * testaamisessa ja rakentamisessa ennen muiden ammattien yksityiskohtaista
 * luomista.
 */
public class Soturi extends Hahmo {

    public Soturi(String nimi) {
        super(nimi);
        this.ammatti = Hahmo.SOTURI;
    }

    @Override
    public void piirra(Graphics g, int mittaKaava) {
        int x = this.sijainti.getX() * mittaKaava;
        int y = this.sijainti.getY() * mittaKaava;

        g.setColor(Color.red);

        g.fillOval(x, y, mittaKaava, mittaKaava);
    }
}
