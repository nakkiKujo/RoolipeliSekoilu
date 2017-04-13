
package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;

public class Aarre extends Kohde {
    
    public Aarre() {
        this.koodi = Kohde.AARRE;
        this.voikoKulkea = false;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
