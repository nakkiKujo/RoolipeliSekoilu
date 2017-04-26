package juuri.sovelluslogiikka.esineet;

import juuri.apuvalineet.Profiili;

/**
 * Taisteluesineet ovat esineitä, joita pelaajan hahmo voi kantaa yllään. Ne
 * parantavat tai heikentävät hahmon taistelukykyjä. Esineen profiili määrittää,
 * kuinka paljon esine parantaa tai heikentää hahmon kykyjä.
 */
public class TaisteluEsine extends Esine {

    private Profiili esineenProfiili;

    /**
     * Luo uuden taisteluesineen. Parametreina annetaan esineen nimi ja koodi,
     * jotka annettaan perittävän luokan Esine konstruktorille.
     * 
     * Lisäksi taisteluesineelle luodaan oma Profiili.
     *
     * @param nimi esineen nimi
     * @param koodi esineen koodi, staattinen muuttuja luokassa Esine
     */
    public TaisteluEsine(String nimi, int koodi) {
        super(nimi, koodi);
        this.esineenProfiili = new Profiili();
    }

    public Profiili getProfiili() {
        return esineenProfiili;
    }
}
