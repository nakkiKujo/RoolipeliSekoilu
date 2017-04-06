package juuri.sovelluslogiikka.maailma;

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
    public static final int SEINA = 1;
    public static final int KAYTAVA = 2;
    public static final int OVI = 3;
    public static final int HIRVIO = 4;

    protected int koodi;
    protected String nimi;
    protected boolean voikoKulkea;

    protected Tapahtuma tapahtuma;

    public Kohde() {
    }

    public int getKoodi() {
        return koodi;
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

    @Override
    public boolean equals(Object o) {
        Kohde toinen = (Kohde) o;
        if (this.koodi == toinen.getKoodi()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Olet kohteessa: " + this.nimi;
    }
}
