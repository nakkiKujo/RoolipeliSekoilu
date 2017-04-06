package juuri.sovelluslogiikka.peli;

import java.awt.Graphics;
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

    public Hahmo getPelaajanHahmo() {
        return pelaajanHahmo;
    }

    public Luolasto getLuolato() {
        return luolasto;
    }

    public Hahmonliikuttaja getLiikuttaja() {
        return liikuttaja;
    }
    
    public void piirra(Graphics g) {
        //TODO: laskea mittaKaava jokaisessa erillisessä tapauksessa
        int mittaKaava = 23;
        luolasto.piirra(g, mittaKaava);
        pelaajanHahmo.piirra(g, mittaKaava);
    }
    
    public void aloitaPeli(String hahmonNimi) {
        pelaajanHahmo = luoja.luoHahmo(hahmonNimi);

        //sitten luodaan luolasto seikkailua varten
        this.luolasto = new Luolasto(9, 9);
        luolasto.luoTaso1();
    }
    
    public Tapahtuma liikutaanJaEtsitaanTapahtumaa(String suunta) {
        //katsotaan, minkä kohteen hahmo kohtaa liikkuessaan
        Kohde minneHahmoLiikkui = liikuttaja.liikutaHahmoa(suunta, luolasto, pelaajanHahmo);
        
        //Tapahtuma, joka alkaa hahmon kohdatessa kohteen. Jos tapahtuma on null, ei
        //mitään tapahdu.
        Tapahtuma tt = minneHahmoLiikkui.getTapahtuma();
        if(tt == null) {
            return null;
        }
        
        return tt;
    }
}
