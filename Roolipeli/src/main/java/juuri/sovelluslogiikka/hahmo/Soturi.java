package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Soturi on yksi Hahmon perivistä aliluokista. Soturilla on enemmän voimaa
 * pelin alussa kuin muilla hahmoilla. Soturi saa myös peli alussa muutaman
 * parantavan voiteen haavojen parantamista varten.
 */
public class Soturi extends Hahmo {

    /**
     * Luo uuden Soturi-hahmon. Parametrina annetaan hahmon nimi. Konstruktori
     * kutsuu perittävän Hahmo-luokan kontruktoria.
     *
     * Lisäksi asetetaan myös soturille koodi.
     *
     * @param nimi hahmon nimi
     */
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
