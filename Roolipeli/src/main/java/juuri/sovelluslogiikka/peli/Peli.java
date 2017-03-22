
package juuri.sovelluslogiikka.peli;

import juuri.apuvalineet.Lukija;


public class Peli {
    private Lukija lukija;
    private Hahmonluoja luoja;
    
    public Peli() {
        this.lukija = new Lukija();
        this.luoja = new Hahmonluoja(lukija);
    }
    
    public void aloitaPeli() {
        alkuTervehdys();
    }
    
    
    
    
    
    private void alkuTervehdys() {
        System.out.println("Tervetuloa pelaamaan roolipeliä. Tänään seikkailu \ntapahtuu luolassa!");
    }
}
