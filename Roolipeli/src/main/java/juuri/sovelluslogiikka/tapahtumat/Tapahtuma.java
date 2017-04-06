package juuri.sovelluslogiikka.tapahtumat;

import juuri.sovelluslogiikka.hahmo.Hahmo;

/**
 * Tapahtumat liittyvä pelaajan hahmon ja luolaston kohteiden välisiin
 * interaktioihin.
 */
public interface Tapahtuma {

    public void aloitaTapahtuma(Hahmo hahmo);
}
