
package juuri.sovelluslogiikka.hahmo;

import juuri.apuvalineet.Sijainti;

public abstract class Hahmo {
    protected String nimi;
    protected String ammatti;
    protected Sijainti sijainti;
    protected int voima;
    protected int taikaVoima;
    protected int elamaPisteet;
    protected int ketteryys;
    
    public Hahmo(String nimi) {
        this.nimi = nimi;
        this.sijainti = new Sijainti();
        sijainti.setSijainti(1, 1);
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String getAmmatti() {
        return this.ammatti;
    }
    
    public abstract String ammatinKuvaus();
    //antaa kuvauksen ammatista, käytössä ammattiInfossa ammattia luodessa
    
    public Sijainti getSijainti() {
        return this.sijainti;
    }
}
