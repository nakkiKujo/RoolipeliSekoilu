package juuri.sovelluslogiikka.hahmo;

import java.util.ArrayList;
import juuri.sovelluslogiikka.esineet.Esine;

/**
 * Reppu pitää kirjaa pelaajan keräämistä esineistä. Reppuun mahtuu rajaton
 * määrä riimuja ja parantavia voiteita. Muita esineitä reppuun mahtuu enintään
 * 6.
 */
public class Reppu {

    private ArrayList<Esine> esineet;
    private int riimuja;
    private int voiteita;

    /**
     * Repun esineet säilötään listaan. Voiteiden ja riimujen lukumäärää pidetää
     * yllä muuttujissa.
     */
    public Reppu() {
        this.esineet = new ArrayList<>();
        this.riimuja = 0;
        this.voiteita = 0;
    }

    public ArrayList<Esine> getEsineet() {
        return this.esineet;
    }

    public int getRiimuja() {
        return this.riimuja;
    }

    public int getVoiteita() {
        return this.voiteita;
    }

    /**
     * Hakee repusta esineen numero 1. Jos repussa ei ole esineitä, palauttaa
     * null.
     *
     * @return palautetaan esine numero 1 tai null, jos ei esineitä repussa
     */
    public Esine getEsine1() {
        if (esineet.isEmpty()) {
            return null;
        }
        return esineet.get(0);
    }

    /**
     * Hakee repusta esineen numero 2. Jos repussa on vain yksi esine, palauttaa
     * null.
     *
     * @return palautetaan esine numero 2 tai null, jos repussa on alle 2
     * esinettä
     */
    public Esine getEsine2() {
        if (esineet.size() <= 1) {
            return null;
        }
        return esineet.get(1);
    }

    /**
     * Hakee repusta esineen numero 3. Jos repussa on alle kolme esinettä,
     * palauttaa null.
     *
     * @return palautetaan esine numero 3 tai null, jos esineitä on repussa alle
     * kolme
     */
    public Esine getEsine3() {
        if (esineet.size() <= 2) {
            return null;
        }
        return esineet.get(2);
    }

    /**
     * Hakee repusta esineen numero 4. Jos repussa on alle neljä esinettä,
     * palauttaa null.
     *
     * @return palautetaan esine numero 4 tai null, jos repussa on esineitä alle
     * neljä
     */
    public Esine getEsine4() {
        if (esineet.size() <= 3) {
            return null;
        }
        return esineet.get(3);
    }

    /**
     * Hakee repusta esineen numero 5. Jos repussa on alle viisi esinettä,
     * palauttaa null.
     *
     * @return palautetaan esine numero 5 tai null, jos repussa on alle viisi
     * esinettä
     */
    public Esine getEsine5() {
        if (esineet.size() <= 4) {
            return null;
        }
        return esineet.get(4);
    }

    /**
     * Hakee repusta esineen numero 6. Jos repussa on alle kuusi esinettä,
     * palauttaa null.
     *
     * @return palautetaan esine numero 6 tai null, jos esineitä on repussa alle
     * kuusi
     */
    public Esine getEsine6() {
        if (esineet.size() <= 5) {
            return null;
        }
        return esineet.get(5);
    }

    /**
     * Metodi asettaa esineen reppuun. Jos reppu on täynnä, ei esinettä laiteta
     * reppuun.
     *
     * Jos esine saadaan reppuun, palautetaan true. Jos esine ei mahdu reppuun,
     * palautetaan false.
     *
     * @param ee Reppuun asetettava esine.
     * @return mahtuiko esine reppuun
     */
    public boolean asetaEsineReppuun(Esine ee) {
        int esineenKoodi = ee.getKoodi();

        if (esineenKoodi == Esine.RIIMU.getKoodi()) {
            riimuja++;
            return true;
        } else if (esineenKoodi == Esine.PARANTAVAVOIDE.getKoodi()) {
            voiteita++;
            return true;
        } else {
            if (esineet.size() == 6) {
                return false;
            }
            esineet.add(ee);
            return true;
        }
    }

    /**
     * Metodi tarkastaa, onko parametrina annettu esine repussa. Jos on,
     * palauttaa true. Jos ei ole, palauttaa false.
     *
     * @param ee Tarkastettava esine.
     * @return onko esine repussa vai ei
     */
    public boolean onkoRepussa(Esine ee) {
        if (ee.getKoodi() == Esine.RIIMU.getKoodi()) {
            return this.riimuja > 0;
        } else if (ee.getKoodi() == Esine.PARANTAVAVOIDE.getKoodi()) {
            return this.voiteita > 0;
        } else {
            for (Esine esineRepussa : esineet) {
                if (ee.equals(esineRepussa)) {
                    return true;
                }
            }

            return false;
        }

    }

    /**
     * Metodi poistaa parametrina annetun esineen repusta. Jos repussa on
     * useampi samanlainen esine, poistuu repusta vain yksi sellainen esine.
     *
     * @param ee Repusta poistettava esine.
     */
    public void poistaRepusta(Esine ee) {
        if (ee.getKoodi() == Esine.RIIMU.getKoodi()) {
            if (riimuja > 0) {
                riimuja--;
            }
        } else if (ee.getKoodi() == Esine.PARANTAVAVOIDE.getKoodi()) {
            if (voiteita > 0) {
                voiteita--;
            }
        } else {
            if (!onkoRepussa(ee)) {
                return;
            }

            esineet.remove(ee);
        }

    }

}
