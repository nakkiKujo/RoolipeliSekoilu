package juuri.sovelluslogiikka.esineet;

/**
 * Yleisesineet ovat esineitä, joita pelaajan hahmo ei voi kantaa yllään.
 * Yleiesineitä ovat esimerkiksi avaimet ja erilaiset juomat tai parantavat
 * voiteet.
 */
public class YleisEsine extends Esine {

    /**
     * Luo uuden yleisesineen. Parametreina annetaan esineen nimi ja koodi,
     * jotka annetaan perittävän luokan Esine konstruktorille.
     *
     * @param nimi esineen nimi
     * @param koodi esineen koodi, staattinen muuttuja luokassa Esine
     */
    public YleisEsine(String nimi, int koodi) {
        super(nimi, koodi);
    }
}
