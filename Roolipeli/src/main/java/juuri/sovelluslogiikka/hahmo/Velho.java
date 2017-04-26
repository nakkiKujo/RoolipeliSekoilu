package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Velho on yksi Hahmon perivistä aliluokista. Velholla on enemmän taikavoimaa
 * peli alussa kuin muilla hahmoilla. Lisäksi velho saa peli alussa muutaman
 * riimun taikojen loihtimiseen.
 */
public class Velho extends Hahmo {

    /**
     * Luo uuden Velho-hahmon. Parametrina annetaan hahmon nimi. Konstruktori
     * kutsuu perittävän Hahmo-luokan kontruktoria.
     *
     * Lisäksi asetetaan myös velholle koodi.
     *
     * @param nimi hahmon nimi
     */
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
