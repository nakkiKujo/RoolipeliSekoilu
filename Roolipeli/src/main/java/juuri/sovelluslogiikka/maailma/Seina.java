package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

/**
 * Seinä on Kohteen aliluokka. Seinä rajaa luolastoa ja antaa sille rakenteen.
 */
public class Seina extends Kohde {

    public Seina(Tapahtuma tapahtuma) {
        this.koodi = Kohde.SEINA;
        this.nimi = "seinä";
        this.tapahtuma = tapahtuma;

        //Seinään ei voi kulkea.
        this.voikoKulkea = false;
    }
}
