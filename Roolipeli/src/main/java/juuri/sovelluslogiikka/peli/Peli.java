package juuri.sovelluslogiikka.peli;

import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Tämä luokka toimii välikätenä käyttöliittymän ja sovelluslogiikan välillä.
 * Tästä luokasta lähetetään käskyjä muun muassa luolaston ja hahmon luomiseen
 * sekä hahmon liikuttamiseen.
 *
 * Luokka myös ylläpitää tietoa pelin tällä hetkellä käynnissä olevasta
 * tapahtumasta.
 */
public class Peli {

    private Hahmo pelaajanHahmo;
    private Luolasto luolasto;
    private Hahmonliikuttaja liikuttaja;
    private Hahmonluoja luoja;
    private Tapahtuma nykyinenTapahtuma;

    /**
     * Luo uuden pelin. Pelille luodaan hahmonluoja sekä hahmonliikuttaja.
     */
    public Peli() {
        this.liikuttaja = new Hahmonliikuttaja();
        this.luoja = new Hahmonluoja();
    }

    public Hahmo getPelaajanHahmo() {
        return pelaajanHahmo;
    }

    public Luolasto getLuolasto() {
        return luolasto;
    }

    public Hahmonliikuttaja getLiikuttaja() {
        return liikuttaja;
    }

    public Tapahtuma getNykyinenTapahtuma() {
        return nykyinenTapahtuma;
    }

    /**
     * Metodi piirtää pelin käyttöliittymän piirtoalustalle. Se lähettää kutsun
     * luolaston piirtometodille sekä pelaajan hahmon piirtometodille.
     *
     * Luolaston piirtometodille annetaan parametrina pelaajan hahmo, jotta
     * tiedetään, mitkä luolaston kohteet tulee piirtää näkyviin. Liian kaukana
     * hahmosta olvat kohteet jäävät piirtämättä.
     *
     * @param g käyttöliittymän piirtoalustan grafiikka
     */
    public void piirra(Graphics g) {
        //TODO: laskea mittaKaava jokaisessa erillisessä tapauksessa
        int mittaKaava = 18;
        luolasto.piirra(g, mittaKaava, pelaajanHahmo);
        pelaajanHahmo.piirra(g, mittaKaava);
    }

    /**
     * Metodi luo pelaajan hahmon ja pelin maailman eli luolaston. Hahmo luodaan
     * annetun nimen ja ammatin koodin perusteella.
     *
     * @param hahmonNimi käyttäjän antama nimi hahmolle
     * @param hahmonAmmatti ammattia vastaava koodi
     */
    public void aloitaPeli(String hahmonNimi, int hahmonAmmatti) {
        this.pelaajanHahmo = luoja.luoHahmo(hahmonNimi, hahmonAmmatti);

        this.luolasto = new Luolasto();
        luolasto.luoSeuraavaTaso();
    }

    /**
     * Metodin avulla liikutetaan pelaajan hahmoa. Metodi kutsuu
     * hahmonliikuttajaa, jolle annetaan parametrina saatu suunta. Saatu suunta
     * on muotoa "alas", "ylös", "vasen" tai "oikea".
     *
     * Liikkuessaan hahmo löytää jonkin Kohteen, johon saattaa liittyä
     * tapahtuma. Jos tapahtumaa ei ole, palautetaan null. Jos tapahtuma löytyy,
     * palautetaan se. Metodissa myös asetetaan muistiin, mikä tapahtuma on
     * kyseessä.
     *
     * @param suunta saatu suunta, johon hahmoa halutaan liikuttaa
     * @return tapahtuma, joka kohteesta löytyi
     */
    public Tapahtuma liikutaanJaEtsitaanTapahtumaa(String suunta) {
        Kohde minneHahmoLiikkui = liikuttaja.liikutaHahmoa(suunta, luolasto, pelaajanHahmo);

        if (minneHahmoLiikkui == null) {
            return null;
        }

        nykyinenTapahtuma = minneHahmoLiikkui.getTapahtuma();
        if (nykyinenTapahtuma == null) {
            return null;
        }

        return nykyinenTapahtuma;
    }
}
