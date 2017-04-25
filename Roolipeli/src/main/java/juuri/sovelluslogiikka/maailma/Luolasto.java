package juuri.sovelluslogiikka.maailma;

import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.peli.HirvionLuoja;
import juuri.sovelluslogiikka.peli.KohteidenLuoja;
import juuri.sovelluslogiikka.tapahtumat.OvenAvaus;

/**
 * Tämä luokka kuvastaa pelin maailmaa, jossa pelaajan hahmo seikkailee.
 * Luolaston rakennetta ylläpidetään taulukossa, joka sisältää erilaisia
 * kohteita. Luokalla on metodit kohteiden lisäämistä ja poistamista varten.
 *
 * Luolasto koostuu useammasta eri kerroksesta, joissa aina syvemmälle mentäessä
 * peli vaikeutuu.
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
     */
    public void luoTaso1() {
        this.leveys = 13;
        this.korkeus = 11;

        this.koordinaatisto = new Kohde[leveys][korkeus];

        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            asetaSeina(i, 0, KohteidenLuoja.SEINA);
            asetaSeina(i, korkeus - 1, KohteidenLuoja.SEINA);
        }
        for (int i = 1; i < korkeus - 1; i++) {
            asetaSeina(0, i, KohteidenLuoja.SEINA);
            asetaSeina(leveys - 1, i, KohteidenLuoja.SEINA);
        }

        //asetetaan seinät luolan sisälle
        asetaSeina(2, 2, KohteidenLuoja.SEINA);
        asetaSeina(2, 3, KohteidenLuoja.SEINA);
        asetaSeina(2, 4, KohteidenLuoja.SEINA);
        asetaSeina(2, 6, KohteidenLuoja.SEINA);
        asetaSeina(2, 7, KohteidenLuoja.SEINA);
        asetaSeina(2, 8, KohteidenLuoja.SEINA);
        asetaSeina(3, 2, KohteidenLuoja.SEINA);
        asetaSeina(3, 6, KohteidenLuoja.SEINA);
        asetaSeina(3, 8, KohteidenLuoja.SEINA);
        asetaSeina(4, 2, KohteidenLuoja.SEINA);
        asetaSeina(4, 3, KohteidenLuoja.SEINA);
        asetaSeina(4, 4, KohteidenLuoja.SEINA);
        asetaSeina(4, 6, KohteidenLuoja.SEINA);
        asetaSeina(4, 8, KohteidenLuoja.SEINA);
        asetaSeina(5, 2, KohteidenLuoja.SEINA);
        asetaSeina(5, 8, KohteidenLuoja.SEINA);
        asetaSeina(6, 2, KohteidenLuoja.SEINA);
        asetaSeina(6, 4, KohteidenLuoja.SEINA);
        asetaSeina(6, 6, KohteidenLuoja.SEINA);
        asetaSeina(6, 8, KohteidenLuoja.SEINA);
        asetaSeina(7, 2, KohteidenLuoja.SEINA);
        asetaSeina(7, 4, KohteidenLuoja.SEINA);
        asetaSeina(7, 6, KohteidenLuoja.SEINA);
        asetaSeina(7, 8, KohteidenLuoja.SEINA);
        asetaSeina(7, 9, KohteidenLuoja.SEINA);
        asetaSeina(8, 2, KohteidenLuoja.SEINA);
        asetaSeina(8, 4, KohteidenLuoja.SEINA);
        asetaSeina(8, 6, KohteidenLuoja.SEINA);
        asetaSeina(8, 8, KohteidenLuoja.SEINA);
        asetaSeina(8, 9, KohteidenLuoja.SEINA);
        for (int i = 2; i < 10; i++) {
            asetaSeina(9, i, KohteidenLuoja.SEINA);
        }
        for (int i = 1; i < 10; i++) {
            asetaSeina(11, i, KohteidenLuoja.SEINA);
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
        asetaHirvio(3, 5, HirvionLuoja.NOITA);
        asetaHirvio(4, 9, HirvionLuoja.SUURIROTTAPRONSSIAVAIN);
        asetaHirvio(10, 5, HirvionLuoja.NOKKELANOITA);

        //asetetaan aarteet
        asetaAarre(3, 3, KohteidenLuoja.AARREJOSSAMIEKKA1);
        asetaAarre(8, 7, KohteidenLuoja.AARREJOSSARIIMUJATAIKASAUVA);
        asetaAarre(6, 9, KohteidenLuoja.AARREJOSSAHOPEAAVAIN);
        asetaAarre(8, 5, KohteidenLuoja.AARRE2VOIDETTA);

        //asetetaan ansa
        asetaAnsa(6, 5);

        //portaat
        asetaPortaat(10, 9);

        //ovet
        asetaLukittuOvi(10, 2, KohteidenLuoja.OVIHOPEAAVAAJA);
        asetaLukittuOvi(3, 4, KohteidenLuoja.OVIPRONSSIAVAAJA);
        asetaAvoinOvi(5, 4);
        asetaAvoinOvi(5, 6);
    }

    public void luoTaso2() {

    }

    public void luoTaso3() {

    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle hirviön.
     *
     * Hirviö luodaan HirvionLuoja-luokkaa käyttäen metodille parametrina
     * annetun koodin avulla.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param hirvionLuontiKoodi annettu koodi, jolla hirviö luodaan
     * @return onnistuiko hirviön asetus
     */
    public boolean asetaHirvio(int x, int y, int hirvionLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Hirvio hh = HirvionLuoja.luoHirvio(hirvionLuontiKoodi);
        hh.setSijainti(x, y);
        koordinaatisto[x][y] = hh;

        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle ansan.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onnistuiko ansan asetus
     */
    public boolean asetaAnsa(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Ansa aa = new Ansa();
        aa.setSijainti(x, y);
        koordinaatisto[x][y] = aa;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle portaat.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onnistuiko portaiden asetus
     */
    public boolean asetaPortaat(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Portaat pp = new Portaat();
        pp.setSijainti(x, y);
        koordinaatisto[x][y] = pp;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle aarteen. Metodissa
     * annetaan parametrina koodi, joka välitetään KohteidenLuojalle. Näin
     * saadaan luotua haluttu aarre.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi luotavaa aarretta vastaava koodi, staattinen
     * muuttuja luokassa KohteidenLuoja
     * @return onnistuiko aarteen asetus
     */
    public boolean asetaAarre(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Aarre aa = (Aarre) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        aa.setSijainti(x, y);
        koordinaatisto[x][y] = aa;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle seinän. Parametrina
     * annettaa koodi, jonka avulla seinä luodaan Kohteidenluojassa.
     * 
     * Koodi on oleellinen, jos halutaan esimerkiksi luoda erilaisia seiniä.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi koodi, jonka avulla seinä luodaan
     * @return onnistuiko seinän asetus
     */
    public boolean asetaSeina(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Seina ss = (Seina) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        ss.setSijainti(x, y);
        koordinaatisto[x][y] = ss;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle käytävän.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onnistuiko käytävän asetus
     */
    public boolean asetaKaytava(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Kaytava kk = new Kaytava(null);
        kk.setSijainti(x, y);
        koordinaatisto[x][y] = kk;
        return true;
    }

    /**
     * Asettaa luolaston koordinaateihin (x, y) lukitun oven. Metodille annetaan
     * parametrina koodi, joka välitetään KohteidenLuojalle. Sieltä saadaan
     * koodia vastaava kohde takaisin.
     *
     * Jos oven luominen ja asettaminen ei onnistu, palauttaa metodi false.
     * Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi luotavaa ovea vastaava KohteidenLuoja-koodi
     * @return onnistuiko oven asetus
     */
    public boolean asetaLukittuOvi(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Ovi ovi = (Ovi) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        ovi.setSijainti(x, y);
        koordinaatisto[x][y] = ovi;

        return true;
    }

    /**
     * Asettaa luolaston koordinaatteihin (x, y) avoimen oven.
     *
     * Jos ovea ei pystytä luomaan, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onnistuiko oven asetus
     */
    public boolean asetaAvoinOvi(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Ovi ovi = (Ovi) KohteidenLuoja.luoKohde(KohteidenLuoja.OVIAVOIN);
        ovi.setSijainti(x, y);
        koordinaatisto[x][y] = ovi;

        return true;
    }

    /**
     * Hakee luolastosta kohteen parametrein annettujen koodinaattien kohdalta.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return löydetty kohde
     */
    public Kohde haeKoordinaateista(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }
        return koordinaatisto[x][y];
    }

    /**
     * Metodi hakee luolastosta kohteen sille parametrina annetun sijainnin
     * osoittamasata kohdasta.
     *
     * @param ss sijainti, jonka kohdalla oleva kohde halutaan löytää
     * @return löydetty kohde
     */
    public Kohde haeSijainnista(Sijainti ss) {
        int x = ss.getX();
        int y = ss.getY();

        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }

        return koordinaatisto[x][y];
    }

    /**
     * Poistaa parametrina annetun kohteen luolastosta. Tilalle laitetaan
     * käytävä, jossa ei ole tapahtumaa.
     *
     * @param kk poistettava kohde
     */
    public void poistaKohde(Kohde kk) {
        int x = kk.getSijainti().getX();
        int y = kk.getSijainti().getY();

        asetaKaytava(x, y);
    }

    /**
     * Piirtää luolaston käyttöliittymän piirtotaululle. Metodi kutsuu
     * luolatossa olevien kohteiden piirtometodeja. Kohteita piirretään sen
     * mukaan, ovatko ne tarpeeksi lähellä pelaajan hahmoa. Jos kohde on liian
     * kaukana, ei sitä piirretä. Tämän vuoksi pelaajan hahmoa kuljetetaan
     * piirtometodissa.
     *
     * @param g käyttöliittyymän grafiikkaolio
     * @param mittaKaava mittakaava, jossa piirretään
     * @param pelaajanHahmo pelaajan hahmo
     */
    public void piirra(Graphics g, int mittaKaava, Hahmo pelaajanHahmo) {
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                int x = i * mittaKaava;
                int y = j * mittaKaava;
                koordinaatisto[i][j].piirra(g, mittaKaava, x, y, pelaajanHahmo);
            }
        }
    }
}
