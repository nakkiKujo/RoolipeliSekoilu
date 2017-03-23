package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;

public class Peli {

    private Lukija lukija;
    private Keskustelija keskustelija;
    private Hahmo pelaajanHahmo;
    private Luolasto luolasto;

    public Peli() {
        this.lukija = new Lukija();
        this.keskustelija = new Keskustelija();
    }

    public void aloitaPeli() {
        keskustelija.alkuTervehdys();
        
        Hahmonluoja luoja = new Hahmonluoja(lukija, keskustelija);
        pelaajanHahmo = luoja.luoHahmo();
        
        this.luolasto = new Luolasto(10, 10);
        pelaaPeli();
    }

    private void pelaaPeli() {
        
    }
    
}
