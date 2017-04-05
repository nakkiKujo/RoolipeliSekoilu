
package juuri;

import juuri.sovelluslogiikka.peli.Peli;
import juuri.ui.Kayttoliittyma;

public class Main {
    
    public static void main(String[] args) {
        Kayttoliittyma mm = new Kayttoliittyma();
        Peli peli = new Peli();
        peli.aloitaPeli();
        peli.pelaaPeli();
    }
}
