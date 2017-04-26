package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Ansa;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Luokka kuvaa tapahtumaa, jossa pelaajan hahmo astuu ansaan. Ansaan
 * astumisesta aiheutuu pelaajalle vahinkoa tietty määrä, joka riippuu ansasta.
 *
 * @author PenaJones
 */
public class AnsaanAstuminen extends Tapahtuma {

    private Ansa ansa;

    /**
     * Luo uuden ansaan astumis-tapahtuman. Parametrina annetaan ansa-kohde,
     * johon tapahtuma liittyy.
     *
     * @param ansa ansa, johon tapahtuma liittyy
     */
    public AnsaanAstuminen(Ansa ansa) {
        this.koodi = Tapahtuma.ANSAANASTUMINEN;
        this.ansa = ansa;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {
        this.tapahtumaTeksti = "Auts! Astuit vahingossa " + ansa.getNimi() + "an."
                + "\nHahmosi koki vahinkoa " + ansa.getAnsanTekemaVahinko() + " elämäpistettä.";
        this.vaihtoehtoYksi = "Jatka";
        this.vaihtoehtoKaksi = "Jatka";
    }

    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
        hahmo.getProfiili().lisaaNykyinenElamaPisteet(ansa.getAnsanTekemaVahinko() * (-1));
        luola.poistaKohde(ansa);
    }

    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
        hahmo.getProfiili().lisaaNykyinenElamaPisteet(ansa.getAnsanTekemaVahinko() * (-1));
        luola.poistaKohde(ansa);
    }

}
