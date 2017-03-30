
package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public class Seina extends Kohde {
    
    public Seina(Tapahtuma tapahtuma) {
        this.koodi = 1;
        this.nimi = "seinä";
        this.tapahtuma = tapahtuma;
        
        //Seinään ei voi kulkea.
        this.voikoKulkea = false;
    }
}
