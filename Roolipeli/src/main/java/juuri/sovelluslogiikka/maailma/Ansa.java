package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Ansat ovat luolaston kohteita, joihin pelaaja voi tahtomattaan joutua. Ne
 * yleensä aiheuttavat pelaajan hahmolle jonkinlaista vahinkoa.
 */
public class Ansa extends Kohde {

    private int vahinko;

    /**
     * Luo uuden ansan. Parametreina annetaan ansalle nimi ja luku, joka vastaa
     * ansan tekemää vahinkoa pelaajan hahmoon.
     *
     * @param ansanNimi ansalle annettava nimi
     * @param ansanTekemaVahinko vahingon määrä, jonka pelaaja kokee astuessaan
     * ansaan
     */
    public Ansa(String ansanNimi, int ansanTekemaVahinko) {
        this.koodi = Kohde.ANSA;
        this.nimi = ansanNimi;
        this.vari = new Color(204, 204, 204);
        this.voikoKulkea = true;
        this.vahinko = ansanTekemaVahinko;
    }

    public int getAnsanTekemaVahinko() {
        return this.vahinko;
    }
}
