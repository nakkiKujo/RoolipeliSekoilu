
package juuri.ui;

import juuri.sovelluslogiikka.hahmo.Druidi;
import juuri.sovelluslogiikka.hahmo.Soturi;
import juuri.sovelluslogiikka.hahmo.Velho;

public class Keskustelija {
    
    public Keskustelija() {
        
    }
    
    public String alkuTervehdys() {
        return "Tervetuloa pelaamaan roolipeliä. Tänään seikkailu \ntapahtuu luolassa!";
    }
    
    public String ammatinValintaEsittely() {
        String teksti = "";
        teksti = teksti + "~~~~~~~~~~~~~~\nSeuraavaksi sinun tulee valita hahmosi ammatti. Voit valita"
                + "seuraavista:\n- Soturi\n- Velho\n- Druidi\n"
                + "Jos haluat tietää ammatista enemmän, voit kirjoittaa 'info ammatti', esim. 'info velho'.\n"
                + "Kun olet tehnyt valintasi, kirjoita 'ammatti', esim. 'velho'.";
        
        return teksti;
    }
    
    public String kysySuuntaa() {
        return "Minne haluaisit mennä? Voit mennä vasemmalle, oikealle, alas tai ylös."
                    + " Anna komento muodossa'liiku alas'";
    }
    
    public String vaaraKomento() {
        return "Hups, annoit väärän komennon! Kokeile uudestaan.";
    }
}
