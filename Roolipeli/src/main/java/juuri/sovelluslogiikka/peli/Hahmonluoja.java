package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Keskustelija;
import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Druidi;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.hahmo.Velho;

public class Hahmonluoja {

    private Lukija lukija;
    private Keskustelija keskustelija;

    public Hahmonluoja(Lukija ll, Keskustelija kk) {
        this.lukija = ll;
        this.keskustelija = kk;
    }

    public Hahmo luoHahmo() {
        String nimi = hahmonNimenValinta();
        String hahmonAmmatti = hahmonAmmatinValinta();
        
        return luodaanHahmoAmmatinMukaan(hahmonAmmatti, nimi);
    }

    private String hahmonNimenValinta() {
        System.out.println("~~~~~~~~~~~~~~");
        System.out.print("Anna ensin hahmollesi nimi: ");
        String nimi = lukija.lueString();
        nimi.trim();
        System.out.println("Ah, " + nimi + ", siinäpä oikein osuva nimi urhealle pelurille!");
        return nimi;
    }

    private String hahmonAmmatinValinta() {
        
        //tämä täytyy muokata niin, että pystytään laajentamaan helpommin
        System.out.println(keskustelija.ammatinValintaEsittely());
        String teksti = lukija.lueString();
        teksti.toLowerCase();
        
        // palautetaan ammatti stringinä
        return kasitteleAmmatinValintaTeksti(teksti);
    }

    private String kasitteleAmmatinValintaTeksti(String teksti) {
        while (!(teksti.equals("soturi")) && !(teksti.equals("velho")) && !(teksti.equals("druidi"))) {
            if ( (teksti.equals("info velho")) || teksti.equals("info soturi") || teksti.equals("info druidi")) {
                System.out.println(keskustelija.ammattiInfo(teksti));
                System.out.println("Anna uusi komento: ");
            } else {
                System.out.print("Hups, annoit väärän komennon! Kokeile uudestaan: ");
            }

            teksti = lukija.lueString();
            teksti.toLowerCase();
        }
        
        return teksti;
    }
    
    private Hahmo luodaanHahmoAmmatinMukaan(String ammatti, String hahmonNimi) {
        
        
        
        
        
        //oikaistaan hieman ja luodaan suoraan vain soturi
        return new Soturi(hahmonNimi);
    }

}
