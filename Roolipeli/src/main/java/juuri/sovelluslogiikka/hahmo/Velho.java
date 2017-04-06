package juuri.sovelluslogiikka.hahmo;

/**
 * Tämä luokka on yksi Hahmon perivistä aliluokista. TODO: Eroavaisuus muista
 * ammateista.
 */
public class Velho extends Hahmo {

    public Velho(String nimi) {
        super(nimi);
        this.ammatti = "velho";
        this.voima = 1;
        this.taikaVoima = 6;
        this.elamaPisteet = 5;
        this.ketteryys = 2;
    }
}
