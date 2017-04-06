package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Käytävä on Kohteen aliluokka. Se on luolaston peruselementti, ja suurimman
 * osan ajastaan pelaajan hahmo viettää kulkien käytäviä pitkin.
 *
 * Usein käytävien tapahtuma on null.
 */
public class Kaytava extends Kohde {

    public Kaytava(Tapahtuma tapahtuma) {
        this.koodi = Kohde.KAYTAVA;
        this.nimi = "käytävä";
        this.tapahtuma = tapahtuma;

        //Käytävillä voi kulkea.
        this.voikoKulkea = true;
    }
}
