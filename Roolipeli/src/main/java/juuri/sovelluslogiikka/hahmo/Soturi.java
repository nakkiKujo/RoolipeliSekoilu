package juuri.sovelluslogiikka.hahmo;

/**
 * Tämä luokka on yksi Hahmon perivistä aliluokista. Soturia käyetään ohjelman
 * testaamisessa ja rakentamisessa ennen muiden ammattien yksityiskohtaista
 * luomista.
 */
public class Soturi extends Hahmo {

    public Soturi(String nimi) {
        super(nimi);
        this.ammatti = Hahmo.SOTURI;
    }
}
