
package juuri.sovelluslogiikka.maailma;

import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public class Ovi extends Kohde {
    private boolean lukittu;
    
    public Ovi(boolean lukitus, Tapahtuma tapahtuma) {
        this.koodi = 3;
        this.nimi = "ovi";
        this.lukittu = lukitus;
        
        //Ovien läpi kulkeminen riippuu sen lukituksesta.
        this.voikoKulkea = lukitus;
        this.tapahtuma = tapahtuma;
    }
    
    public boolean onkoLukittu() {
        return lukittu;
    }
    
    
    
}
