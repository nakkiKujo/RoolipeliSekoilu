package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;
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
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());
        
        if(etaisyysHahmoonX > 1 || etaisyysHahmoonY > 1) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(new Color(153, 102, 0));
        }
        
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
