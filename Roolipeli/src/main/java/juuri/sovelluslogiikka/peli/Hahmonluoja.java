
package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Lukija;
import juuri.sovelluslogiikka.hahmo.Hahmo;

public class Hahmonluoja {
    
    private Lukija lukija;
    
    public Hahmonluoja(Lukija ll) {
        this.lukija = ll;
    }
    
    public Hahmo luoHahmo() {
        String nimi = hahmonNimenValinta();
        Hahmo uusiHahmo = hahmonAmmatinValinta(nimi);
        
        
        return null;
    }
    
    private String hahmonNimenValinta() {
        System.out.println("~~~~~~~~~~~~~~");
        System.out.print("Anna ensin hahmollesi nimi:");
        String nimi = lukija.lueString();
        System.out.println("Ah, " + nimi + ", siinäpä oikein osuva nimi urhealle pelurille!");
        return nimi;
    }
    
    private Hahmo hahmonAmmatinValinta(String hahmonNimi) {
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
        
        while( !(teksti.equals("soturi")) && !(teksti.equals("velho")) && !(teksti.equals("druidi")) ) {
            System.out.print("Hups, annoit väärän komennon! Kokeile uudestaan: ");
            teksti = lukija.lueString();
            teksti.toLowerCase();
        }
        
        if(teksti.equals("soturi")) {
            
        } else if(teksti.equals("velho")) {
            
        } else if(teksti.equals("druidi")) {
            
        }
        
        
        
        return null;
    }
}
