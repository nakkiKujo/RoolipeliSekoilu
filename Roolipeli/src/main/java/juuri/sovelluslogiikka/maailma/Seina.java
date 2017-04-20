package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Seinä on Kohteen aliluokka. Seinä rajaa luolastoa ja antaa sille rakenteen.
 * Pelaaja ei normaalisti voi kulkea seinän sisälle.
 */
public class Seina extends Kohde {

    public Seina(Tapahtuma tapahtuma) {
        this.koodi = Kohde.SEINA;
        this.nimi = "seinä";
        this.tapahtuma = tapahtuma;
        
        this.voikoKulkea = false;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
