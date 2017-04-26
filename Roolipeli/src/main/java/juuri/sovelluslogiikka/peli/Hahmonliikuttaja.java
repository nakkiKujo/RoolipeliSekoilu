package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Tämän luokan vastuulla on liikuttaa pelaajan hahmoa luolastossa.
 */
public class Hahmonliikuttaja {

    /**
     * Metodi palauttaa kohteen, johon hahmo liikkuessaan päätyy. Liikkuminen
     * tapahtuu annetun komennon mukaisesti. Jos hahmo yrittää liikkua
     * luolastosta ulos, palauttaa metodi arvon null.
     *
     * Jos hahmo yrittää liikkua kohteeseen, johon se ei voi mennä, estetään
     * kyseinen liike. Metodi kuitenkin palauttaa kohteen, johon hahmo yritti
     * kulkea.
     *
     * @param komento minne suuntaan hahmoa liikutetaan
     * @param luola hahmo liikkuu luolastossa
     * @param hahmo liikkuva hahmo
     * @return kohde, johon hahmo liikkui
     */
    public Kohde liikutaHahmoa(String komento, Luolasto luola, Hahmo hahmo) {
        Sijainti hahmonSijainti = hahmo.getSijainti();

        if (komento.equals("alas")) {
            hahmonSijainti.liikuAlas(1);
        } else if (komento.equals("ylös")) {
            hahmonSijainti.liikuYlos(1);
        } else if (komento.equals("oikea")) {
            hahmonSijainti.liikuOikealle(1);
        } else if (komento.equals("vasen")) {
            hahmonSijainti.liikuVasemmalle(1);
        } else {
            return null;
        }

        Kohde loydetty = luola.haeSijainnista(hahmonSijainti);

        if (loydetty == null) {
            return null;
        }

        if (!loydetty.getVoikoKulkea()) {
            if (komento.equals("alas")) {
                hahmonSijainti.liikuAlas(-1);
            } else if (komento.equals("ylös")) {
                hahmonSijainti.liikuYlos(-1);
            } else if (komento.equals("oikea")) {
                hahmonSijainti.liikuOikealle(-1);
            } else if (komento.equals("vasen")) {
                hahmonSijainti.liikuVasemmalle(-1);
            }
        }

        return loydetty;
    }
}
