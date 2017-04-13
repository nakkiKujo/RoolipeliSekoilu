package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Hirviöt ovat luolastossa olevia Kohteita, joiden kanssa pelaaja pääsee
 * taistelemaan.
 */
public class Hirvio extends Kohde {

    public Hirvio(Tapahtuma tt, String nimi) {
        this.koodi = Kohde.HIRVIO;
        this.nimi = nimi;
        this.tapahtuma = tt;

        //hirviön läpi ei voi kulkea
        this.voikoKulkea = false;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
