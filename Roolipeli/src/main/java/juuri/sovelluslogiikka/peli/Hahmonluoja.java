package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Druidi;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.hahmo.Velho;

public class Hahmonluoja {

    private Lukija lukija;

    public Hahmonluoja(Lukija ll) {
        this.lukija = ll;
    }

    public Hahmo luoHahmo() {
        String nimi = hahmonNimenValinta();
        Hahmo uusiHahmo = hahmonAmmatinValinta(nimi);

        return uusiHahmo;
    }

    private String hahmonNimenValinta() {
        System.out.println("~~~~~~~~~~~~~~");
        System.out.print("Anna ensin hahmollesi nimi: ");
        String nimi = lukija.lueString();
        nimi.trim();
        System.out.println("Ah, " + nimi + ", siinäpä oikein osuva nimi urhealle pelurille!");
        return nimi;
    }

    private Hahmo hahmonAmmatinValinta(String hahmonNimi) {
        
        //tämä täytyy muokata niin, että pystytään laajentamaan helpommin
        
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Seuraavaksi sinun tulee valita hahmosi ammatti. Voit valita seuraavista:");
        System.out.println("- Soturi");
        System.out.println("- Velho");
        System.out.println("- Druidi");
        System.out.println("Jos haluat tietää ammatista enemmän, voit kirjoittaa ''info *ammatti*'' \n"
                + "esim ''info velho''");
        System.out.println("Kun olet tehnyt valintasi, kirjoita ''ammatti'' , esim. ''soturi''");

        String teksti = lukija.lueString();
        teksti.toLowerCase();

        String valittuAmmatti = kasitteleTeksti(teksti);
        
        Hahmo uusiHahmo = null;
        if (teksti.equals("soturi")) {
            uusiHahmo = new Soturi(hahmonNimi);
            uusiHahmo.setAmmatti("soturi");
        } else if (teksti.equals("velho")) {
            uusiHahmo = new Velho(hahmonNimi);
            uusiHahmo.setAmmatti("velho");
        } else {
            uusiHahmo = new Druidi(hahmonNimi);
            uusiHahmo.setAmmatti("druidi");
        }
        
        System.out.println("Onneksi olkoon, olet luonut " + uusiHahmo.getAmmatti() + "n, jonka nimi on " + hahmonNimi + 
                ".");
        
        return uusiHahmo;
    }

    private String kasitteleTeksti(String teksti) {
        while (!(teksti.equals("soturi")) && !(teksti.equals("velho")) && !(teksti.equals("druidi"))) {
            if ( (teksti.equals("info velho")) || teksti.equals("info soturi") || teksti.equals("info druidi")) {
                ammattiInfo(teksti);
                System.out.println("Anna uusi komento: ");
            } else {
                System.out.print("Hups, annoit väärän komennon! Kokeile uudestaan: ");
            }

            teksti = lukija.lueString();
            teksti.toLowerCase();
        }
        
        return teksti;
    }
    
    private void ammattiInfo(String teksti) {
        if(teksti.equals("info velho")) {
            System.out.println("Velhot ovat kivoja.");
        }else if(teksti.equals("info soturi")) {
            System.out.println("Soturit ovat hurjia.");
        }else if(teksti.equals("info druidi")) {
            System.out.println("Druidit pitävät kukista.");
        }
    }

}
