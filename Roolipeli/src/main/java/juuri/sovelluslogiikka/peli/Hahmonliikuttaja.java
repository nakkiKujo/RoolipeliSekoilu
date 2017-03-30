package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

public class Hahmonliikuttaja {

    public Hahmonliikuttaja() {
    }
    
    //Metodi palauttaa Kohteen, johon hahmon liikkuessaan päätyy.
    //Jos hahmo yrittää liikkua luolastosta ulos TAI komento on vääränlainen,
    //palautetaan null.
    public Kohde liikutaHahmoa(String komento, Luolasto luola, Hahmo hahmo) {
        Sijainti hahmonSijainti = hahmo.getSijainti();
        
        //ensin käsitellään komento, joka kertoo, mihin suuntaan liikutaan
        if (komento.equals("liiku alas")) {
            hahmonSijainti.liikuAlas(1);
        } else if (komento.equals("liiku ylös")) {
            hahmonSijainti.liikuYlos(1);
        } else if (komento.equals("liiku oikealle")) {
            hahmonSijainti.liikuOikealle(1);
        } else if (komento.equals("liiku vasemmalle")) {
            hahmonSijainti.liikuVasemmalle(1);
        } else {
            return null;
        }

        Kohde loydetty = luola.haeSijainnista(hahmonSijainti);

        if (loydetty == null) {
            return null;
        }

        //Hahmo yritti kulkea kohteeseen, jonne ei voinut mennä. Täytyy peruuttaa takaisin.
        if (!loydetty.getVoikoKulkea()) {
            if (komento.equals("liiku alas")) {
                hahmonSijainti.liikuAlas(-1);
            } else if (komento.equals("liiku ylös")) {
                hahmonSijainti.liikuYlos(-1);
            } else if (komento.equals("liiku oikealle")) {
                hahmonSijainti.liikuOikealle(-1);
            } else if (komento.equals("liiku vasemmalle")) {
                hahmonSijainti.liikuVasemmalle(-1);
            }
        }

        return loydetty;
    }
}
