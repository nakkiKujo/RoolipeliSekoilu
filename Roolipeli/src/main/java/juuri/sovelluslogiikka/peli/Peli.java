package juuri.sovelluslogiikka.peli;

import java.awt.Graphics;
import juuri.ui.Keskustelija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Tämä luokka toimii välikätenä käyttöliittymän ja sovelluslogiikan välillä.
 * Tästä luokasta lähetetään käskyjä muun muassa luolaston ja hahmon luomiseen
 * sekä hahmon liikuttamiseen. Se toimii eräänlaisena runkona koko ohjelman
 * toiminnalle.
 */
public class Peli {

    private Hahmo pelaajanHahmo;
    private Luolasto luolasto;
    private Hahmonliikuttaja liikuttaja;
    private Hahmonluoja luoja;

    public Peli() {
        this.liikuttaja = new Hahmonliikuttaja();
        this.luoja = new Hahmonluoja();
    }

    public Hahmo getPelaajanHahmo() {
        return pelaajanHahmo;
    }

    public Luolasto getLuolato() {
        return luolasto;
    }

    public Hahmonliikuttaja getLiikuttaja() {
        return liikuttaja;
    }

    /**
     * Metodi piirtää pelin käyttöliittymän piirtoalustalle. Se lähettää kutsun
     * luolaston piirtometodille sekä pelaajan hahmon piirtometodille.
     *
     * @param g käyttöliittymän piirtoalustan grafiikka
     */
    public void piirra(Graphics g) {
        //TODO: laskea mittaKaava jokaisessa erillisessä tapauksessa
        int mittaKaava = 23;
        luolasto.piirra(g, mittaKaava);
        pelaajanHahmo.piirra(g, mittaKaava);
    }

    /**
     * Metodi luo pelaajan hahmon ja pelin maailman eli luolaston. Hahmo luodaan
     * annetun nimen perusteella.
     *
     * @param hahmonNimi käyttäjän antama nimi hahmolle
     */
    public void aloitaPeli(String hahmonNimi) {
        pelaajanHahmo = luoja.luoHahmo(hahmonNimi);

        this.luolasto = new Luolasto(9, 9);
        luolasto.luoTaso1();
    }

    public Tapahtuma liikutaanJaEtsitaanTapahtumaa(String suunta) {
        //katsotaan, minkä kohteen hahmo kohtaa liikkuessaan
        Kohde minneHahmoLiikkui = liikuttaja.liikutaHahmoa(suunta, luolasto, pelaajanHahmo);

        //Tapahtuma, joka alkaa hahmon kohdatessa kohteen. Jos tapahtuma on null, ei
        //mitään tapahdu.
        Tapahtuma tt = minneHahmoLiikkui.getTapahtuma();
        if (tt == null) {
            return null;
        }

        return tt;
    }
}
