package juuri.sovelluslogiikka.peli;

import juuri.ui.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

//Tämä luokka toimii eräänlaisena runkona koko ohjelman toiminnalle. Se liimaa yhteen käyttöliittymän
//sekä sovelluslogiikan.
public class Peli {

    private Lukija lukija;
    private Keskustelija keskustelija;
    private Hahmo pelaajanHahmo;
    private Luolasto luolasto;
    private Hahmonliikuttaja liikuttaja;
    private Hahmonluoja luoja;

    public Peli() {
        this.lukija = new Lukija();
        this.keskustelija = new Keskustelija();
        this.liikuttaja = new Hahmonliikuttaja();
        this.luoja = new Hahmonluoja();
    }

    public void aloitaPeli(String hahmonNimi) {
        pelaajanHahmo = luoja.luoHahmo(hahmonNimi);

        //sitten luodaan luolasto seikkailua varten
        this.luolasto = new Luolasto(9, 9);
        luolasto.luoTaso1();
    }
    
    public Hahmo getPelaajanHahmo() {
        return pelaajanHahmo;
    }
    
    public Luolasto getLuolato() {
        return luolasto;
    }
    
    public Hahmonliikuttaja getLiikuttaja() {
        return liikuttaja;
    }

    public void pelaaPeli() {
        System.out.println("Luolasto on luotu, peli alkaa!\n\n~~~~~~~~~~~~~~~~\n");
        String komento = "";

        //looppi jatkuu, kunnes hahmo kuolee
        while (!komento.equals("kuolema")) {
            System.out.println(keskustelija.kysySuuntaa());
            komento = lukija.lueString();

            Kohde minneHahmoLiikkui = liikuttaja.liikutaHahmoa(komento, luolasto, pelaajanHahmo);
            if (minneHahmoLiikkui == null) {
                System.out.println(keskustelija.vaaraKomento());
                continue;
            }

            Tapahtuma tapahtuma = minneHahmoLiikkui.getTapahtuma();
            if (tapahtuma == null) {
                continue;
            }
            tapahtuma.aloitaTapahtuma(pelaajanHahmo);
        }
    }

}
