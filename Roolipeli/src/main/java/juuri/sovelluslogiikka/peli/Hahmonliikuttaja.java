package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

public class Hahmonliikuttaja {

    public Hahmonliikuttaja() {
    }

    public Kohde liikutaHahmoa(String komento, Luolasto luola, Hahmo hahmo) {
        Sijainti hahmonSijainti = hahmo.getSijainti();

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

        //hahmo yritti kulkea seinän sisään, joten täytyy peruuttaa takaisin
        if (loydetty.getKoodi() == 1) {
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
