package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Hirviöt ovat luolastossa olevia Kohteita, joiden kanssa pelaaja pääsee
 * taistelemaan.
 */
public class Hirvio extends Kohde {

    public Hirvio(Tapahtuma tt, String nimi) {
        this.koodi = Kohde.HIRVIO;
        this.nimi = nimi;
        this.tapahtuma = tapahtuma;

        //hirviön läpi ei voi kulkea
        this.voikoKulkea = false;
    }
}
