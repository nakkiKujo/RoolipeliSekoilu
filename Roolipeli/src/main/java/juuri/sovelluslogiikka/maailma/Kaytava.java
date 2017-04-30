package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;
import juuri.sovelluslogiikka.hahmo.Hahmo;

/**
 * Käytävä on Kohteen aliluokka. Se on luolaston peruselementti, ja suurimman
 * osan ajastaan pelaajan hahmo viettää kulkien käytäviä pitkin.
 *
 * Usein käytävillä ei ole tapahtumia.
 */
public class Kaytava extends Kohde {

    /**
     * Luodaan uusi käytävä. Käytävällä voi kulkea.
     */
    public Kaytava() {
        this.koodi = Kohde.KAYTAVA;
        this.nimi = "käytävä";
        this.tapahtuma = null;

        //Käytävillä voi kulkea.
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y, Hahmo pelaajanHahmo, Luolasto luola) {
        int etaisyysHahmoonX = pelaajanHahmo.getSijainti().getX() - this.sijainti.getX();
        int etaisyysHahmoonY = pelaajanHahmo.getSijainti().getY() - this.sijainti.getY();

        if(Math.abs(etaisyysHahmoonX) > 2 || Math.abs(etaisyysHahmoonY) > 2) {
            g.setColor(Color.BLACK);
            return;
        }
        
        if(this.sijainti.getX() == pelaajanHahmo.getSijainti().getX()) {
            
        }
        
        
        
        
        if (etaisyysHahmoonX > 2 || etaisyysHahmoonY > 2) {
            g.setColor(Color.BLACK);
        } else {
            if(this.sijainti.getX() == pelaajanHahmo.getSijainti().getX()) {
                if(etaisyysHahmoonY < 2) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    
                }
            } else if(this.sijainti.getY() == pelaajanHahmo.getSijainti().getY()) {
                if(etaisyysHahmoonX < 2) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    
                }
            } else if(true) {
                
            }
            
            
            
            g.setColor(new Color(153, 153, 153));
        }

        g.fillRect(x, y, mittakaava, mittakaava);
    }
}
