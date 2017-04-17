package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Ovi;

public class OvenAvaus implements Tapahtuma {

    //Jokainen OvenAvaus-tapahtuma tietää, mihin oveen se on kytkettynä.
    private Ovi ovi;
    private int koodi;
    private String teksti;
    public String vaihtoEhtoYksi;
    public String vaihtoEhtoKaksi;

    public OvenAvaus(Ovi ovi) {
        this.koodi = Tapahtuma.OVENAVAUS;
        this.ovi = ovi;
        this.teksti = teksti;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo pelaajanHahmo) {
        boolean onkoOviLukossa = ovi.onkoLukittu();

        if (onkoOviLukossa) {
            teksti = "Edessäsi on " + ovi.getNimi() + ". "
                    + "Sen avaamiseen tarvitset esineen: " + ovi.getAvaaja().getNimi();

            YleisEsine ovenAvaaja = ovi.getAvaaja();

            if (!pelaajanHahmo.getReppu().onkoRepussa(ovenAvaaja)) {
                teksti = teksti + " \nSinulla ei ole kyseistä avainta.";
            } else {
                teksti = teksti + "\nSinulta löytyy kyseinen avain.";
            }

        } else {
            teksti = "Edessäsi on " + ovi.getNimi() + ". Ovi ei ole lukossa.";
        }

    }
    
    
}
