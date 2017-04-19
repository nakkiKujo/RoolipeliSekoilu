package juuri.sovelluslogiikka.hahmo;

/**
 * Tämä luokka on yksi Hahmon perivistä aliluokista. TODO: Eroavuus muista
 * ammateista.
 */
public class Druidi extends Hahmo {

    public Druidi(String nimi) {
        super(nimi);
        this.ammatti = Hahmo.DRUIDI;
    }
}
