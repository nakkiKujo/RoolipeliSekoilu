
package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public class Kaytava extends Kohde {
    
    public Kaytava(Tapahtuma tapahtuma) {
        this.koodi = 2;
        this.nimi = "käytävä";
        this.tapahtuma = tapahtuma;
        
        //Käytävillä voi kulkea.
        this.voikoKulkea = true;
    }
}
