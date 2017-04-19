package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.maailma.Ovi;

/**
 * OvenAvaus on tapahtuma, joka liittyy pelaajan hahmon ja luolaston oven
 * kohtaamiseen. Jos ovi on lukossa, pelaaja usein tarvitsee avaimen sen
 * avatakseen. Pelaaja voi myös päättää olla avaamatta ovea.
 *
 * OvenAvaus tietää aina, mihin oveen se liittyy.
 * 
 * Jos pelaaja onnistuneesti avaa oven, poistuu ovi luolasta.
 *
 * @author PenaJones
 */
public class OvenAvaus extends Tapahtuma {

    private Ovi ovi;
    private boolean lukittuOvi;
    private boolean avainLoytyy;

    public OvenAvaus(Ovi ovi) {
        this.koodi = Tapahtuma.OVENAVAUS;
        this.ovi = ovi;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo pelaajanHahmo) {
        boolean onkoOviLukossa = ovi.onkoLukittu();

        if (onkoOviLukossa) {
            lukittuOvi = true;
            this.tapahtumaTeksti = "Edessäsi on " + ovi.getNimi() + ". "
                    + "Sen avaamiseen tarvitset esineen: " + ovi.getAvaaja().getNimi();

            YleisEsine ovenAvaaja = ovi.getAvaaja();

            if (!pelaajanHahmo.getReppu().onkoRepussa(ovenAvaaja)) {
                avainLoytyy = false;
                this.tapahtumaTeksti = tapahtumaTeksti + "\nSinulla ei ole kyseistä avainta.";
            } else {
                avainLoytyy = true;
                this.tapahtumaTeksti = this.tapahtumaTeksti + "\nSinulta löytyy kyseinen avain.";
            }

        } else {
            lukittuOvi = false;
            this.tapahtumaTeksti = "Edessäsi on " + ovi.getNimi() + ". Ovi ei ole lukossa.";
        }

        vaihtoehtoYksi = "Avaa ovi.";
        vaihtoehtoKaksi = "Älä avaa ovea.";
    }

    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
        if (lukittuOvi) {
            if (avainLoytyy) {
                hahmo.getReppu().poistaRepusta(ovi.getAvaaja());
                luola.poistaKohde(ovi);
            }
        } else {
            luola.poistaKohde(ovi);
        }
    }

    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
        //mitään ei tehdä, koska ovea ei avata
    }

}
