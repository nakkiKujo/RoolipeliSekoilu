
package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public class Hirvio extends Kohde {
    
    public Hirvio(Tapahtuma tt, String nimi) {
        this.koodi = Kohde.HIRVIO;
        this.nimi = nimi;
        this.tapahtuma = tapahtuma;
        
        //hirviön läpi ei voi kulkea
        this.voikoKulkea = false;
    }
}
