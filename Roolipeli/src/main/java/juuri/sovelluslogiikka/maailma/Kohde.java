package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Tämä abstrakti luokka kuvastaa Luolastossa esiintyviä erilaisia asioita, eli
 * kohteita. Jokaisella kohteella voi olla yksi Tapahtuma. Pelaajan liikkuessa
 * kohteeseen aktivoituu tapahtuma, eli jotain siis tapahtuu. Jos kohteen
 * tapahtuma on null, mitään ei tapahdu.
 */
public abstract class Kohde {

    /**
     * Jokaisella kohteella on oma koodinsa, jolla se voidaan tunnistaa.
     */
    public static final int SEINA = 111;
    public static final int KAYTAVA = 2;
    public static final int OVI = 333;
    public static final int HIRVIO = 4;
    public static final int AARRE = 5;
    public static final int PORTAAT = 6;
    public static final int ANSA = 7;

    protected int koodi;
    protected String nimi;
    protected boolean voikoKulkea;
    protected Sijainti sijainti;
    protected Color vari;
    protected boolean piirtyi;

    protected Tapahtuma tapahtuma;

    public int getKoodi() {
        return koodi;
    }

    public String getNimi() {
        return nimi;
    }

    public Sijainti getSijainti() {
        return this.sijainti;
    }

    /**
     * Asettaa kohteen sijainniksi (x, y). Jos kohteella ei vielä ole sijaintia,
     * luodaan ensin sille sijainti.
     *
     * @param x asetettava x-koordinaatti
     * @param y asetettava y-koordinaatti
     */
    public void setSijainti(int x, int y) {
        if (this.sijainti == null) {
            sijainti = new Sijainti();
        }
        sijainti.setSijainti(x, y);
    }

    /**
     * Metodi kertoo, voiko pelaajan hahmo kulkea kohteen päälle.
     *
     * @return tieto kulkemiskelpoisuudesta
     */
    public boolean getVoikoKulkea() {
        return voikoKulkea;
    }

    public void setTapahtuma(Tapahtuma tt) {
        this.tapahtuma = tt;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }

    /**
     * Metodi piirtää kohteen käyttöliittymän piirtotaululle. Kohde piirretään
     * sen omalla värillä, joka on kohteen oliomuuttuja.
     *
     * Metodi tarkistaa, onko piirrettävä Kohde liian kaukana pelaajan hahmosta
     * tai oven tai seinän takana. Jos näin on, kohde piirretään mustana eli se
     * ei näy.
     *
     * @param g piirtotaulun grafiikka-olio
     * @param mittakaava mittakaava, jossa piirretään
     * @param x kohteen x-koordinaatti mittakaavaan laskettuna
     * @param y kohteen y-koordinaatti mittakaavaan laskettuna
     * @param pelaajanHahmo pelaajan hahmo
     * @param luola pelin luolasto
     */
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo, Luolasto luola) {
        int etaisyysHahmoonX = pelaajanHahmo.getSijainti().getX() - this.sijainti.getX();
        int etaisyysHahmoonY = pelaajanHahmo.getSijainti().getY() - this.sijainti.getY();
        int xx = this.sijainti.getX();
        int yy = this.sijainti.getY();

        if (Math.abs(etaisyysHahmoonX) > 2 || Math.abs(etaisyysHahmoonY) > 2) {
            g.setColor(Color.BLACK);
            this.piirtyi = false;
            g.fillRect(x, y, mittakaava, mittakaava);
            return;
        }

        if (Math.abs(etaisyysHahmoonX) <= 1 && Math.abs(etaisyysHahmoonY) <= 1) {
            g.setColor(this.vari);
            this.piirtyi = true;
            g.fillRect(x, y, mittakaava, mittakaava);
            return;
        }

        int valissaKoodi;

        if (xx == pelaajanHahmo.getSijainti().getX() && yy == pelaajanHahmo.getSijainti().getY() - 2) {
            valissaKoodi = luola.haeKoordinaateista(xx, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() && yy == pelaajanHahmo.getSijainti().getY() + 2) {
            valissaKoodi = luola.haeKoordinaateista(xx, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 2 && yy == pelaajanHahmo.getSijainti().getY()) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 2 && yy == pelaajanHahmo.getSijainti().getY()) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 1 && yy == pelaajanHahmo.getSijainti().getY() - 2) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 1 && yy == pelaajanHahmo.getSijainti().getY() - 2) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 2 && yy == pelaajanHahmo.getSijainti().getY() - 2) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 2 && yy == pelaajanHahmo.getSijainti().getY() - 2) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 2 && yy == pelaajanHahmo.getSijainti().getY() - 1) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 2 && yy == pelaajanHahmo.getSijainti().getY() + 1) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 2 && yy == pelaajanHahmo.getSijainti().getY() - 1) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy + 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 2 && yy == pelaajanHahmo.getSijainti().getY() + 1) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 2 && yy == pelaajanHahmo.getSijainti().getY() + 2) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() - 1 && yy == pelaajanHahmo.getSijainti().getY() + 2) {
            valissaKoodi = luola.haeKoordinaateista(xx + 1, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 1 && yy == pelaajanHahmo.getSijainti().getY() + 2) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }

        if (xx == pelaajanHahmo.getSijainti().getX() + 2 && yy == pelaajanHahmo.getSijainti().getY() + 2) {
            valissaKoodi = luola.haeKoordinaateista(xx - 1, yy - 1).getKoodi();
            hoidaValissa(g, mittakaava, x, y, valissaKoodi);
        }
    }

    private void hoidaValissa(Graphics g, int mittakaava, int x, int y, int koodi) {
        if (koodi == Kohde.OVI || koodi == Kohde.SEINA) {
            g.setColor(Color.BLACK);
            this.piirtyi = false;
            g.fillRect(x, y, mittakaava, mittakaava);
        } else {
            g.setColor(this.vari);
            this.piirtyi = true;
            g.fillRect(x, y, mittakaava, mittakaava);
        }
    }

    @Override
    public boolean equals(Object o) {
        Kohde toinen = (Kohde) o;
        if (this.koodi == toinen.getKoodi()) {
            return true;
        }

        return false;
    }
}
