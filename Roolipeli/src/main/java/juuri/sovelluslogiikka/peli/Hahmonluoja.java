package juuri.sovelluslogiikka.peli;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.ui.Keskustelija;
import juuri.sovelluslogiikka.hahmo.Druidi;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.hahmo.Velho;

/**
 * Tämän luokan vastuulla on pelaajan hahmon luominen. Luokka on vielä
 * keskeneräinen. Se täydentyy, kun itse hahmojen ammatit luodaan täydemmin.
 */
public class Hahmonluoja {

    public Hahmonluoja() {
    }

    public Hahmo luoHahmo(String hahmonNimi, int hahmonAmmatti) {
        if (hahmonAmmatti == Hahmo.SOTURI) {
            Soturi soturi = new Soturi(hahmonNimi);
            soturi.getProfiili().setSoturiAlkuProfiili();
            soturi.getReppu().asetaEsineReppuun(Esine.PARANTAVAVOIDE);
            soturi.getReppu().asetaEsineReppuun(Esine.PARANTAVAVOIDE);
            return soturi;

        } else if (hahmonAmmatti == Hahmo.VELHO) {
            Velho velho = new Velho(hahmonNimi);
            velho.getProfiili().setVelhoAlkuProfiili();

            for (int i = 0; i < 3; i++) {
                velho.getReppu().asetaEsineReppuun(Esine.RIIMU);
            }
            return velho;

        } else if (hahmonAmmatti == Hahmo.DRUIDI) {
            Druidi dd = new Druidi(hahmonNimi);
            dd.getProfiili().setDruidiAlkuProfiili();
            dd.getReppu().asetaEsineReppuun(Esine.RIIMU);
            dd.getReppu().asetaEsineReppuun(Esine.PARANTAVAVOIDE);
            return dd;
            
        } else {
            return null;
        }
    }

}
