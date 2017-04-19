package juuri.sovelluslogiikka.hahmo;

import java.util.ArrayList;
import java.util.HashMap;
import juuri.sovelluslogiikka.esineet.Esine;

/**
 * Reppu pitää kirjaa pelaajan keräämistä esineistä.
 */
public class Reppu {

    private HashMap<Integer, ArrayList<Esine>> esineet;

    /**
     * Repun esineet säilötään hajautusrakenteeseen. Tällöin tiettyjen esineiden
     * etsiminen repusta on nopeampaa kuin listalta etsiminen.
     */
    public Reppu() {
        this.esineet = new HashMap<>();
    }

    /**
     * Metodi asettaa esineen reppuun.
     *
     * @param ee Reppuun asetettava esine.
     */
    public void asetaEsineReppuun(Esine ee) {
        int esineenKoodi = ee.getKoodi();

        if (!esineet.containsKey(esineenKoodi)) {
            esineet.put(esineenKoodi, new ArrayList<>());
        }

        esineet.get(esineenKoodi).add(ee);
    }

    /**
     * Metodi tarkastaa, onko parametrina annettu esine repussa. Jos on,
     * palauttaa true. Jos ei ole, palauttaa false.
     *
     * @param ee Tarkastettava esine.
     * @return
     */
    public boolean onkoRepussa(Esine ee) {
        int esineenKoodi = ee.getKoodi();

        if (esineet.get(esineenKoodi) == null) {
            return false;
        }

        return esineet.get(esineenKoodi).contains(ee);
    }

    /**
     * Metodi poistaa parametrina annetun esineen repusta. Jos repussa on
     * useampi samanlainen esine, poistuu repusta vain yksi sellainen esine.
     *
     * @param ee Repusta poistettava esine.
     */
    public void poistaRepusta(Esine ee) {
        if (!onkoRepussa(ee)) {
            return;
        }

        esineet.get(ee.getKoodi()).remove(ee);
    }

}
