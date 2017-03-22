package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;

public class Peli {

    private Lukija lukija;
    private Hahmonluoja luoja;
    private Hahmo pelaajanHahmo;
    private Luolasto luola;

    public Peli() {
        this.lukija = new Lukija();
        this.luoja = new Hahmonluoja(lukija);
    }

    public void aloitaPeli() {
        alkuTervehdys();
        hahmonLuonti();
        luolastonLuonti();
    }

    private void alkuTervehdys() {
        System.out.println("Tervetuloa pelaamaan roolipeliä. Tänään seikkailu \ntapahtuu luolassa!");
    }

    private void hahmonLuonti() {
        this.pelaajanHahmo = luoja.luoHahmo();
    }

    private void luolastonLuonti() {
        
    }
}
