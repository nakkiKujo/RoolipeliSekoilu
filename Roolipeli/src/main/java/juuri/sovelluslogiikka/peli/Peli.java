package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

//Tämä luokka toimii eräänlaisena runkona koko ohjelman toiminnalle. Oleellisin metodi on
//pelaaPeli, joka pyörittää looppia, jonka aikana peli pelataan. Kun looppi loppuu, peli päättyy.
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
        
        //ensin luodaan pelaajan hahmo, tästä huolehtii hahmonluoja
        Hahmonluoja luoja = new Hahmonluoja(lukija, keskustelija);
        pelaajanHahmo = luoja.luoHahmo();
        
        //sitten luodaan luolasto seikkailua varten
        this.luolasto = new Luolasto(4, 4);
        luolasto.luoTaso1();
        
        //nyt olemme valmiit pelaamaan peliä
        pelaaPeli();
    }

    public void pelaaPeli() {
        System.out.println("Luolasto on luotu, peli alkaa!\n\n~~~~~~~~~~~~~~~~\n");
        String komento = "";
        
        
        //looppi jatkuu, kunnes hahmo kuolee
        while(!komento.equals("kuolema")) {
            System.out.println(keskustelija.kysySuuntaa());
            komento = lukija.lueString();
            
            Kohde minneHahmoLiikkui = liikuttaja.liikutaHahmoa(komento, luolasto, pelaajanHahmo);
            if(minneHahmoLiikkui == null) {
                System.out.println(keskustelija.vaaraKomento());
                continue;
            }
            
            Tapahtuma tapahtuma = minneHahmoLiikkui.getTapahtuma();
        }
    }
    
}
