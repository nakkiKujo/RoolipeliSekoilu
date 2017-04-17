/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.maailma;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Portaat ovat luolaston kohde, jonka kautta pelaaja voi edetä syvemmälle 
 * luolaan. Edetessään portaissa ei pelaaja voi enää palata takaisin ylemmälle
 * luolaston tasolle.
 * @author PenaJones
 */
public class Portaat extends Kohde {
    
    public Portaat() {
        this.koodi = Kohde.PORTAAT;
        this.voikoKulkea = true;
    }

    @Override
    public void piirra(Graphics g, int mittakaava, int x, int y) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, mittakaava, mittakaava);
    }
            
}
