
package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;

public class Aarre extends Kohde {
    
    private ArrayList<Esine> aarteet;
    
    public Aarre(String nimi) {
        this.nimi = nimi;
        this.koodi = Kohde.AARRE;
        this.voikoKulkea = false;
        this.aarteet = new ArrayList<>();
    }
    
    public void lisaaAarre(Esine ee) {
        this.aarteet.add(ee);
    }
    
    public ArrayList<Esine> keraaAarteet() {
        ArrayList<Esine> apu = aarteet;
        aarteet.clear();
        return apu;
    }
    
    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
