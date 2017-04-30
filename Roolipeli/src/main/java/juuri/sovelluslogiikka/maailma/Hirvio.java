package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import juuri.apuvalineet.Profiili;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Hirviöt ovat luolastossa olevia Kohteita, joiden kanssa pelaaja pääsee
 * taistelemaan. Hirviön vahvuuden määrittelee sen profiili.
 */
public class Hirvio extends Kohde {

    private ArrayList<Esine> hirvionEsineet;
    private Profiili hirvioProfiili;

    /**
     * Luo uuden hirviön. Parametrinä annetaan hirviön nimi.
     *
     * Konstruktori luo myös hirviölle listan esineistä, joita hirviö kantaa.
     * Lisäksi hirviöllle luodaan oma Profiili.
     *
     * @param nimi hirviölle annettava nimi
     */
    public Hirvio(String nimi) {
        this.koodi = Kohde.HIRVIO;
        this.nimi = nimi;
        this.hirvionEsineet = new ArrayList<>();
        this.hirvioProfiili = new Profiili();
        //hirviön läpi ei voi kulkea
        this.voikoKulkea = false;
    }

    public Profiili getProfiili() {
        return hirvioProfiili;
    }

    public ArrayList<Esine> getEsineet() {
        return hirvionEsineet;
    }

    /**
     * Lisää esineen hirviön kannettavaksi.
     * @param ee hirviölle lisättävä esine
     */
    public void lisaaEsine(Esine ee) {
        hirvionEsineet.add(ee);
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo) {
        int etaisyysHahmoonX = Math.abs(pelaajanHahmo.getSijainti().getX() - this.sijainti.getX());
        int etaisyysHahmoonY = Math.abs(pelaajanHahmo.getSijainti().getY() - this.sijainti.getY());

        if (etaisyysHahmoonX > 2 || etaisyysHahmoonY > 2) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(new Color(153, 0, 153));
        }

        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
