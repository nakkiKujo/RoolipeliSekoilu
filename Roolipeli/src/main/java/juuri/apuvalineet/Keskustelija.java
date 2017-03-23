
package juuri.apuvalineet;

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
    
    public String ammattiInfo(String teksti) {
        if(teksti.equals("info velho")) {
            return "Velhot ovat kivoja.";
        }else if(teksti.equals("info soturi")) {
            return "Soturit ovat hurjia.";
        }else if(teksti.equals("info druidi")) {
            return "Druidit pitävät kukista.";
        }
        
        return null;
    }
}
