
package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;

/**
 * Aarteet ovat luolaston kohteita, joista pelaaja voi saada lisää esineitä.
 * @author PenaJones
 */
public class Aarre extends Kohde {
    
    private ArrayList<Esine> aarteet;
    
    public Aarre(String nimi) {
        this.nimi = nimi;
        this.koodi = Kohde.AARRE;
        this.voikoKulkea = false;
        this.aarteet = new ArrayList<>();
    }
    
    /**
     * Metodi lisää esineen aarteeseen.
     * @param ee lisättävä esine
     */
    public void lisaaAarre(Esine ee) {
        this.aarteet.add(ee);
    }
    
    /**
     * Metodi palauttaa aarteessa olevat esineet ja samalla poistaa 
     * esineet aarteesta.
     * @return lista esineistä
     */
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
