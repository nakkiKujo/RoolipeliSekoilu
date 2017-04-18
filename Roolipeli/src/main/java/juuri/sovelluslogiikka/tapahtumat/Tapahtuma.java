package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Tapahtumat liittyvä pelaajan hahmon ja luolaston kohteiden välisiin
 * interaktioihin.
 * Tapahtuma ensin valmistellaan. Tämän jälkeen on kaksi vaihtoehtoa, miten 
 * tapahtuma voi edetä.
 */
public abstract class Tapahtuma {
    
    public static final int TAISTELU = 1;
    public static final int OVENAVAUS = 2;
    public static final int PORTAISSAKULEMINEN = 3;
    public static final int AARTEENLOYTAMINEN = 4;
    
    protected int koodi;
    protected String tapahtumaTeksti;
    protected String vaihtoehtoYksi;
    protected String vaihtoehtoKaksi;
    
    public String getTapahtumateksti() {
        return tapahtumaTeksti;
    }
    
    public String getVaihtoehtoYksi() {
        return vaihtoehtoYksi;
    }
    
    public String getVaihtoehtoKaksi() {
        return vaihtoehtoKaksi;
    }
    
    public int getKoodi() {
        return koodi;
    }
    
    /**
     *
     * @param hahmo
     */
    public abstract void valmisteleTapahtuma(Hahmo hahmo);
    
    public abstract void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola);
    
    public abstract void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola);
}
