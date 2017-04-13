
package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;

public class Ansa extends Kohde {
    
    public Ansa() {
        this.koodi = Kohde.ANSA;
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
