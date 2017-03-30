
package juuri.sovelluslogiikka.maailma;

import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public abstract class Kohde {
    protected Sijainti sijainti;
    
    //Erilaisten Kohteiden koodit:
//    seinä = 1,
//    käytävä = 2,
//    ovi = 3
    protected int koodi;
    protected String nimi;
    protected boolean voikoKulkea;
    
    //Jokaisella Kohteella voi olla yksi Tapahtuma, jolloin pelaajan siis liikkuessa Kohteeseen
    //tapahtuu jotain. Jos Kohteen Tapahtuma on null, mitään ei tapahdu.
    protected Tapahtuma tapahtuma;
    
    public Kohde() {
    }
    
    public int getKoodi() {
        return koodi;
    }
    
    public boolean getVoikoKulkea() {
        return voikoKulkea;
    }
    
    public void setTapahtuma(Tapahtuma tt) {
        this.tapahtuma = tt;
    }
    
    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }
    
    @Override
    public boolean equals(Object o) {
        Kohde toinen = (Kohde) o;
        if(this.koodi == toinen.getKoodi()) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "Olet kohteessa: " + this.nimi;
    }
}
