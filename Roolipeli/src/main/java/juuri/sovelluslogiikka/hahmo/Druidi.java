package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Druidi on yksi Hahmon perivistä aliluokista. Druidilla on pelin alussa
 * enemmän elämäpisteitä ja ketteryyttä kuin muilla hahmoilla. Druidi saa peli
 * alussa riimun ja parantavan voiteen.
 */
public class Druidi extends Hahmo {

    /**
     * Luo uuden Druidi-hahmon. Parametrina annetaan hahmon nimi. Konstruktori
     * kutsuu perittävän Hahmo-luokan kontruktoria.
     *
     * Lisäksi asetetaan myös druidille koodi.
     *
     * @param nimi hahmon nimi
     */
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
