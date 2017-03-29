
package juuri.sovelluslogiikka.maailma;

public class Ovi extends Kohde {
    private boolean lukittu;
    
    public Ovi(boolean lukitus) {
        this.koodi = 3;
        this.nimi = "ovi";
        this.lukittu = lukitus;
    }
    
}
