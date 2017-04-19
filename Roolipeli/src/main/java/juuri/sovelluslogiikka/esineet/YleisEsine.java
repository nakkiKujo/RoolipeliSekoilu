package juuri.sovelluslogiikka.esineet;

/**
 * Yleisesineet ovat esineitä, joita pelaajan hahmo ei voi kantaa yllään.
 * Yleiesineitä ovat esimerkiksi avaimet ja erilaiset juomat tai parantavat
 * voiteet.
 */
public class YleisEsine extends Esine {

    public YleisEsine(String nimi, int koodi) {
        super(nimi, koodi);
    }
}
