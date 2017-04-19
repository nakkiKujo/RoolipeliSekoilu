package juuri.sovelluslogiikka.esineet;

import juuri.apuvalineet.Profiili;

/**
 * Taisteluesineet ovat esineitä, joita pelaajan hahmo voi kantaa yllään. Ne
 * parantavat tai heikentävät hahmon taistelukykyjä. Esineen profiili määrittää,
 * kuinka paljon esine parantaa tai heikentää hahmon kykyjä.
 */
public class TaisteluEsine extends Esine {

    private Profiili esineenProfiili;

    public TaisteluEsine(String nimi, int koodi) {
        super(nimi, koodi);
        this.esineenProfiili = new Profiili();
    }

    public Profiili getProfiili() {
        return esineenProfiili;
    }
}
