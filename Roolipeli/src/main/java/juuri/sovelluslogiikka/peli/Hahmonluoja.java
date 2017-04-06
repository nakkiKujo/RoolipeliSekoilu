package juuri.sovelluslogiikka.peli;

import juuri.ui.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Druidi;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.hahmo.Velho;

public class Hahmonluoja {
    
    public Hahmonluoja() {
    }

    public Hahmo luoHahmo(String hahmonNimi) {
        return luodaanHahmoAmmatinMukaan(null, hahmonNimi);
    }

    private Hahmo luodaanHahmoAmmatinMukaan(String ammatti, String hahmonNimi) {

        //oikaistaan hieman ja luodaan suoraan vain soturi
        return new Soturi(hahmonNimi);
    }

}
