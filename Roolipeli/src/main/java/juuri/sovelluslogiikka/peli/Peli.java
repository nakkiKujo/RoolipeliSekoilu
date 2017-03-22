package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;

public class Peli {

    private Lukija lukija;
    private Hahmonluoja luoja;
    private Hahmo pelaajanHahmo;

    public Peli() {
        this.lukija = new Lukija();
        this.luoja = new Hahmonluoja(lukija);
    }

    public void aloitaPeli() {
        alkuTervehdys();
        hahmonLuonti();

    }

    private void alkuTervehdys() {
        System.out.println("Tervetuloa pelaamaan roolipeliä. Tänään seikkailu \ntapahtuu luolassa!");
    }

    private void hahmonLuonti() {
        this.pelaajanHahmo = luoja.luoHahmo();
    }
}
