package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

public class Peli {

    private Lukija lukija;
    private Keskustelija keskustelija;
    private Hahmo pelaajanHahmo;
    private Luolasto luolasto;
    private Hahmonliikuttaja liikuttaja;

    public Peli() {
        this.lukija = new Lukija();
        this.keskustelija = new Keskustelija();
        this.liikuttaja = new Hahmonliikuttaja();
    }

    public void aloitaPeli() {
        keskustelija.alkuTervehdys();
        
        Hahmonluoja luoja = new Hahmonluoja(lukija, keskustelija);
        pelaajanHahmo = luoja.luoHahmo();
        
        this.luolasto = new Luolasto(4, 4);
        luolasto.luoTaso1();
        pelaaPeli();
    }

    private void pelaaPeli() {
        System.out.println("Luolasto on luotu, peli alkaa!\n\n~~~~~~~~~~~~~~~~\n");
        String komento = "";
        
        while(!komento.equals("kuolema")) {
            System.out.println(keskustelija.kysySuuntaa());
            komento = lukija.lueString();
            
            Kohde minneHahmoLiikkui = liikuttaja.liikutaHahmoa(komento, luolasto, pelaajanHahmo);
            if(minneHahmoLiikkui == null) {
                System.out.println(keskustelija.vaaraKomento());
            }
            
            System.out.println(minneHahmoLiikkui.toString());
                    
        }
    }
    
}
