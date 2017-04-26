package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Aarteet ovat luolaston kohteita, joista pelaaja voi saada lisää esineitä.
 */
public class Aarre extends Kohde {

    private ArrayList<Esine> aarteet;

    /**
     * Luo uuden Aarteen. Parametrina annetaan aarteen nimi. Lisäksi metodi luo
     * aarteella listan sen sisältämistä esineistä. Lista on aluksi tyhjä.
     *
     * @param nimi aarteen nimi
     */
    public Aarre(String nimi) {
        this.nimi = nimi;
        this.koodi = Kohde.AARRE;
        this.voikoKulkea = false;
        this.aarteet = new ArrayList<>();
    }

    /**
     * Metodi lisää esineen aarteeseen.
     *
     * @param ee lisättävä esine
     */
    public void lisaaAarre(Esine ee) {
        this.aarteet.add(ee);
    }

    /**
     * Metodi palauttaa aarteessa olevat esineet ja samalla poistaa esineet
     * aarteesta.
     *
     * @return lista aarteen esineistä
     */
    public ArrayList<Esine> keraaAarteet() {
        ArrayList<Esine> apu = new ArrayList<>();

        for (Esine aarteenEsine : aarteet) {
            apu.add(aarteenEsine);
        }

        aarteet.clear();
        return apu;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());

        if (etaisyysHahmoonX > 1 || etaisyysHahmoonY > 1) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(new Color(255, 255, 0));
        }

        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
