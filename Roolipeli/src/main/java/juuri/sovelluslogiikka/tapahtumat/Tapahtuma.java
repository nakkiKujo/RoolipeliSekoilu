package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;

/**
 * Tapahtumat liittyvä pelaajan hahmon ja luolaston kohteiden välisiin
 * interaktioihin.
 */
public interface Tapahtuma {
    
    public static final int TAISTELU = 1;
    public static final int OVENAVAUS = 2;
    
    /**
     *
     * @param hahmo
     */
    public void valmisteleTapahtuma(Hahmo hahmo);
}
