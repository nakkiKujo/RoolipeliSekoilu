package juuri.sovelluslogiikka.tapahtumat;

import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Reppu;
import juuri.sovelluslogiikka.maailma.Aarre;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Tämä luokka käsittelee tapahtuman, jossa pelaaja löytää aarteen. Pelaaja voi
 * ottaa aarteen tai jättää sen ottamatta.
 *
 * Jos pelaaja ottaa aarteen, siirtyvät aarteeseen kuuluuneet esineet pelaajan
 * reppuun. Lisäksi aarre poistuu luolasta.
 */
public class AarteenLoytaminen extends Tapahtuma {

    private Aarre aarre;

    /**
     * Luodaan uusi aarteenlöytämis-tapahtuma. Tapahtumalle annetaan parametrina
     * aarre, johon se liittyy.
     *
     * @param aa aarre, johon tapahtuma liittyy
     */
    public AarteenLoytaminen(Aarre aa) {
        this.koodi = Tapahtuma.AARTEENLOYTAMINEN;
        this.aarre = aa;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {
        this.tapahtumaTeksti = "Edessäsi on " + aarre.getNimi() + "."
                + "\nHaluatko ottaa aarteen?";
        this.vaihtoehtoYksi = "Ota aarre.";
        this.vaihtoehtoKaksi = "Älä ota.";

    }

    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
        Reppu hahmonReppu = hahmo.getReppu();
        ArrayList<Esine> poistettavatAarteet = new ArrayList<>();
        
        for (Esine aarteestaSaatuEsine : aarre.getAarteet()) {
            boolean mahtuiko = hahmonReppu.asetaEsineReppuun(aarteestaSaatuEsine);
            if (mahtuiko) {
                poistettavatAarteet.add(aarteestaSaatuEsine);
            }
        }
        
        for (Esine poistettava : poistettavatAarteet) {
            aarre.poistaEsine(poistettava);
        }

        if (aarre.getAarteet().isEmpty()) {
            luola.poistaKohde(aarre);
        }
    }

    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
        //aarre jätetään sikseen
    }

}
