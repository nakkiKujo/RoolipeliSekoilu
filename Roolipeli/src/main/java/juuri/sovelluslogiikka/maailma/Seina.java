package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;

/**
 * Seinä on Kohteen aliluokka. Seinä rajaa luolastoa ja antaa sille rakenteen.
 * Pelaaja ei normaalisti voi kulkea seinän sisälle.
 */
public class Seina extends Kohde {

    /**
     * Luo uuden seinän.
     */
    public Seina() {
        this.koodi = Kohde.SEINA;
        this.nimi = "seinä";
        this.vari = new Color(153, 102, 0);
        this.tapahtuma = null;

        this.voikoKulkea = false;
    }
}
