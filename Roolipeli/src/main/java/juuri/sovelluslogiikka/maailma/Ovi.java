package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public class Ovi extends Kohde {

    private boolean lukittu;

    public Ovi(boolean lukitus, Tapahtuma tapahtuma) {
        this.koodi = Kohde.OVI;
        this.nimi = "ovi";
        this.lukittu = lukitus;

        //Ovien läpi kulkeminen riippuu sen lukituksesta.
        if (lukitus) {
            this.voikoKulkea = false;
        } else {
            this.voikoKulkea = true;
        }
        this.tapahtuma = tapahtuma;
    }

    public boolean onkoLukittu() {
        return lukittu;
    }

}
