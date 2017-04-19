package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.tapahtumat.AarteenLoytaminen;
import juuri.sovelluslogiikka.tapahtumat.OvenAvaus;
import juuri.sovelluslogiikka.tapahtumat.Taistelu;

/**
 * Tämä luokka kuvastaa pelin maailmaa, jossa pelaajan hahmo seikkailee.
 * Luolaston rakennetta ylläpidetään taulukossa, joka sisältää erilaisia
 * kohteita.
 */
public class Luolasto {

    private Kohde[][] koordinaatisto;
    private int leveys;
    private int korkeus;

    /**
     * Luodaan luolasto ja sen koordinaatisto.
     */
    public Luolasto() {
        this.koordinaatisto = null;
    }

    /**
     * Luo luolaston ensimmäisen tason, joka on samalla tasoista helpoin.
     * Luolasto koostuu useammasta eri kerroksesta, joista aina syvemmälle
     * mentäessä peli vaikeutuu.
     */
    public void luoTaso1() {
        this.leveys = 13;
        this.korkeus = 11;

        this.koordinaatisto = new Kohde[leveys][korkeus];

        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            asetaSeina(i, 0);
            asetaSeina(i, korkeus - 1);
        }
        for (int i = 1; i < korkeus - 1; i++) {
            asetaSeina(0, i);
            asetaSeina(leveys - 1, i);
        }

        //asetetaan seinät luolan sisälle
        asetaSeina(2, 2);
        asetaSeina(2, 3);
        asetaSeina(2, 4);
        asetaSeina(2, 6);
        asetaSeina(2, 7);
        asetaSeina(2, 8);
        asetaSeina(3, 2);
        asetaSeina(3, 6);
        asetaSeina(3, 8);
        asetaSeina(4, 2);
        asetaSeina(4, 3);
        asetaSeina(4, 4);
        asetaSeina(4, 6);
        asetaSeina(4, 8);
        asetaSeina(5, 2);
        asetaSeina(5, 8);
        asetaSeina(6, 2);
        asetaSeina(6, 4);
        asetaSeina(6, 6);
        asetaSeina(6, 8);
        asetaSeina(7, 2);
        asetaSeina(7, 4);
        asetaSeina(7, 6);
        asetaSeina(7, 8);
        asetaSeina(7, 9);
        asetaSeina(8, 2);
        asetaSeina(8, 4);
        asetaSeina(8, 6);
        asetaSeina(8, 8);
        asetaSeina(8, 9);
        for (int i = 2; i < 10; i++) {
            asetaSeina(9, i);
        }
        for (int i = 1; i < 10; i++) {
            asetaSeina(11, i);
        }

        //asetetaan käytävät
        for (int i = 1; i < 10; i++) {
            asetaKaytava(1, i);
        }
        for (int i = 2; i < 11; i++) {
            asetaKaytava(i, 1);
        }
        for (int i = 5; i < 9; i++) {
            asetaKaytava(i, 3);
        }
        asetaKaytava(2, 5);
        asetaKaytava(4, 5);
        asetaKaytava(5, 5);
        asetaKaytava(7, 5);
        for (int i = 3; i < 9; i++) {
            asetaKaytava(i, 7);
        }
        asetaKaytava(2, 9);
        asetaKaytava(3, 9);
        asetaKaytava(5, 9);
        asetaKaytava(10, 3);
        asetaKaytava(10, 4);
        asetaKaytava(10, 6);
        asetaKaytava(10, 7);
        asetaKaytava(10, 8);

        //asetetaan hirviöt
        asetaHirvio(3, 5);
        asetaHirvio(4, 9);
        asetaHirvio(10, 5);

        //asetetaan aarteet
        asetaAarre(3, 3, "epäilyttävä aarre");
        asetaAarre(8, 5, "huikea aarre");
        asetaAarre(6, 9, "huikea aarre");

        //asetetaan ansa
        asetaAnsa(6, 5);

        //portaat
        asetaPortaat(10, 9);

        //ovet
        asetaLukittuOvi(10, 2, "pronssiavain");
        asetaLukittuOvi(3, 4, "hopea-avain");
        asetaAvoinOvi(5, 4);
        asetaAvoinOvi(5, 6);
        asetaLukittuOvi(2, 1, "pronssiavain");
        asetaAvoinOvi(3, 1);
    }

    public void luoTaso2() {

    }

    public void luoTaso3() {

    }

    public boolean asetaHirvio(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Hirvio hh = new Hirvio(null, "Noita");
        Taistelu tt = new Taistelu(hh);
        hh.setTapahtuma(tt);
        hh.setSijainti(x, y);
        koordinaatisto[x][y] = hh;

        return true;
    }

    public boolean asetaAnsa(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Ansa aa = new Ansa();
        aa.setSijainti(x, y);
        koordinaatisto[x][y] = aa;
        return true;
    }

    public boolean asetaPortaat(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Portaat pp = new Portaat();
        pp.setSijainti(x, y);
        koordinaatisto[x][y] = pp;
        return true;
    }

    public boolean asetaAarre(int x, int y, String aarteenNimi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Aarre aa = new Aarre(null, aarteenNimi);
        AarteenLoytaminen loyto = new AarteenLoytaminen(aa);
        aa.setSijainti(x, y);
        aa.setTapahtuma(loyto);
        koordinaatisto[x][y] = aa;
        return true;
    }

    public boolean asetaSeina(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Seina ss = new Seina(null);
        ss.setSijainti(x, y);
        koordinaatisto[x][y] = ss;
        return true;
    }

    public boolean asetaKaytava(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Kaytava kk = new Kaytava(null);
        kk.setSijainti(x, y);
        koordinaatisto[x][y] = kk;
        return true;
    }

    public boolean asetaLukittuOvi(int x, int y, String avaajanNimi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        YleisEsine avain = new YleisEsine(avaajanNimi, Esine.AVAIN);

        Ovi ovi = new Ovi(true, null, avain);
        OvenAvaus ovenAvaus = new OvenAvaus(ovi);
        ovi.setTapahtuma(ovenAvaus);
        ovi.setSijainti(x, y);
        koordinaatisto[x][y] = ovi;

        return true;
    }

    public boolean asetaAvoinOvi(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Ovi ovi = new Ovi(false, null, null);
        OvenAvaus ovenAvaus = new OvenAvaus(ovi);
        ovi.setTapahtuma(ovenAvaus);
        ovi.setSijainti(x, y);
        koordinaatisto[x][y] = ovi;

        return true;
    }

    public Kohde haeKoordinaateista(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }
        return koordinaatisto[x][y];
    }

    public Kohde haeSijainnista(Sijainti ss) {
        int x = ss.getX();
        int y = ss.getY();

        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }

        return koordinaatisto[x][y];
    }

    public boolean poistaKohde(Kohde kk) {
        int x = kk.getSijainti().getX();
        int y = kk.getSijainti().getY();

        asetaKaytava(x, y);
        return true;
    }

    public void piirra(Graphics g, int mittaKaava) {
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                int x = i * mittaKaava;
                int y = j * mittaKaava;
                koordinaatisto[i][j].piirra(g, mittaKaava, x, y);
            }
        }
    }
}
