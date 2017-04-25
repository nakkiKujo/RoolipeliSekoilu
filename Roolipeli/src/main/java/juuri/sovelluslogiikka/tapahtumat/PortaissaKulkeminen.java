package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;
import juuri.sovelluslogiikka.maailma.Portaat;

public class PortaissaKulkeminen extends Tapahtuma {

    private Portaat portaat;

    public PortaissaKulkeminen(Portaat portaat) {
        this.portaat = portaat;
    }

    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {
        this.tapahtumaTeksti = "Edessäsi on portaat. Haluatko edetä syvemmälle"
                + " luolaan? Et voi enää palata takaisin.";
        this.vaihtoehtoYksi = "Mene alas.";
        this.vaihtoehtoKaksi = "En ole vielä valmis.";
    }

    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
        luola.luoSeuraavaTaso();
    }

    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
        //mitään ei tehdä, pelaaja ei liiku luolan seuraavaan osaan
    }

}
