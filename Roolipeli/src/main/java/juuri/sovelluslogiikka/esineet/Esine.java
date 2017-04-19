
package juuri.sovelluslogiikka.esineet;

/**
 * Esineet ovat tavaroita, joita pelaaja löytää luolassa seikkaillessaan.
 * Esineitä voi löytyä hirviöiltä tai aarteista. Ne säilötään pelaajan
 * reppuun.
 */
public abstract class Esine {
    
    protected int koodi;
    protected String nimi;
    
    public static final int AVAIN = 1;
    public static final int MIEKKA = 2;
    public static final int KYPARA = 3;
    
    public Esine(String nimi, int koodi) {
        this.nimi = nimi;
        this.koodi = koodi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getKoodi() {
        return this.koodi;
    }
    
    @Override
    public boolean equals(Object o) {
        Esine ee = (Esine) o;
        
        if(ee.getNimi().equals(this.nimi) && ee.getKoodi() == this.koodi) {
            return true;
        }
        
        return false;
    }
}
