package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Tapahtumat liittyvä pelaajan hahmon ja luolaston kohteiden välisiin
 * interaktioihin. Tapahtuma ensin valmistellaan. Tämän jälkeen on kaksi
 * vaihtoehtoa, miten tapahtuma voi edetä.
 */
public abstract class Tapahtuma {

    public static final int TAISTELU = 1;
    public static final int OVENAVAUS = 2;
    public static final int PORTAISSAKULEMINEN = 3;
    public static final int AARTEENLOYTAMINEN = 4;

    protected int koodi;
    protected String tapahtumaTeksti;
    protected String vaihtoehtoYksi;
    protected String vaihtoehtoKaksi;

    /**
     * Metodi palauttaa tekstin, joka tapahtumalle asetetaan sitä
     * valmistellessa. Tämä teksti näytetään pelaajalle käyttöliittymän
     * välityksellä.
     *
     * @return tapahtumaan liittyvä teksti
     */
    public String getTapahtumateksti() {
        return tapahtumaTeksti;
    }

    /**
     * Metodi palauttaa tekstin, joka liittyy tapahtuman ensimmäiseen tapaan
     * ratketa. Tämä teksti näytetään pelaajalle käyttöliittymän välityksellä.
     *
     * @return vaihtoehtoon liittyvä teksti
     */
    public String getVaihtoehtoYksi() {
        return vaihtoehtoYksi;
    }

    /**
     * Metodi palauttaa tekstin, joka liittyy tapahtuman toiseen tapaan ratketa.
     * Tämä teksti näytetään pelaajalle käyttöliittymän välityksellä.
     *
     * @return vaihtoehtoon liittyvä teksti
     */
    public String getVaihtoehtoKaksi() {
        return vaihtoehtoKaksi;
    }

    /**
     * Metodi palauttaa tapahtumalle ominaisen koodin. Erilaisilla tapahtumilla
     * on erilaiset koodit.
     *
     * @return tapahtuman koodi
     */
    public int getKoodi() {
        return koodi;
    }

    /**
     * Metodi suoritetaan hahmon kohdatessa tapahtumaan liittyvän kohteen. Se
     * valmistelee kaiken valmiiksi tapahtumaa varten, ja muun muassa muokkaa
     * tapahtumaan liittyvät tekstit hahmon ja kohteen mukaisiksi.
     *
     * @param hahmo pelaajan hahmo
     */
    public abstract void valmisteleTapahtuma(Hahmo hahmo);

    /**
     * Metodi suoritetaan, kun tapahtuma tavalla tai toisella päätyy tapahtumaan
     * tavalla yksi.
     *
     * @param hahmo pelaajan hahmo
     * @param luola luolasto, jossa pelaajan hahmo ja tapahtuman kohde ovat
     */
    public abstract void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola);

    /**
     * Metodi suoritetaan, kun tapahtuma päätyy tapahtumaan tavalla numero
     * kaksi.
     *
     * @param hahmo pelaajan hahmo
     * @param luola luolasto, jossa pelaajan hahmo ja tapahtumaan liittyvä kohde
     * ovat
     */
    public abstract void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola);
}
