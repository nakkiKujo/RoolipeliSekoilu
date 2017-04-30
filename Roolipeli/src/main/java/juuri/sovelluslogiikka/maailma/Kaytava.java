package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;

/**
 * Käytävä on Kohteen aliluokka. Se on luolaston peruselementti, ja suurimman
 * osan ajastaan pelaajan hahmo viettää kulkien käytäviä pitkin.
 *
 * Usein käytävillä ei ole tapahtumia.
 */
public class Kaytava extends Kohde {

    /**
     * Luodaan uusi käytävä. Käytävällä voi kulkea.
     */
    public Kaytava() {
        this.koodi = Kohde.KAYTAVA;
        this.nimi = "käytävä";
        this.vari = new Color(153, 153, 153);
        this.tapahtuma = null;

        //Käytävillä voi kulkea.
        this.voikoKulkea = true;
    }
}
