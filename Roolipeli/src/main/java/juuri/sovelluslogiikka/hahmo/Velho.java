package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.esineet.Esine;

/**
 * Tämä luokka on yksi Hahmon perivistä aliluokista. TODO: Eroavaisuus muista
 * ammateista.
 */
public class Velho extends Hahmo {

    public Velho(String nimi) {
        super(nimi);
        this.ammatti = Hahmo.VELHO;
    }

    @Override
    public void piirra(Graphics g, int mittaKaava) {
        int x = this.sijainti.getX() * mittaKaava;
        int y = this.sijainti.getY() * mittaKaava;

        g.setColor(Color.BLUE);

        g.fillOval(x, y, mittaKaava, mittaKaava);
    }
}
