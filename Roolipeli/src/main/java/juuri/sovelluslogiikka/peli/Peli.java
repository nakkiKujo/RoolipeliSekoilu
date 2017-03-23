package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;

public class Peli {

    private Lukija lukija;
    private Keskustelija keskustelija;
    private Hahmonluoja luoja;
    private Hahmo pelaajanHahmo;
    private Luolasto luolasto;

    public Peli() {
        this.lukija = new Lukija();
        this.keskustelija = new Keskustelija();
        this.luoja = new Hahmonluoja(lukija, keskustelija);
    }

    public void aloitaPeli() {
        Peli peli = new Peli(lukija, keskustelija);
        alkuTervehdys();
        hahmonLuonti();
        luolastonLuonti();
    }

    private void alkuTervehdys() {
        keskustelija.alkuTervehdys();
    }

    private void luolastonLuonti() {
        this.luolasto = new Luolasto(10, 10);
    }
}
