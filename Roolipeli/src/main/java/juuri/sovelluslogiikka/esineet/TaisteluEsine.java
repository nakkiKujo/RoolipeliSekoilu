/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.esineet;

import juuri.apuvalineet.Profiili;

/**
 * Taisteluesineet ovat esineitä, joita pelaajan hahmo voi kantaa yllään. Ne
 * parantavat hahmon taistelukykyjä. Esineen profiili määrittää, kuinka paljon 
 * esine parantaa tai heikentää hahmon kykyjä.
 * @author PenaJones
 */
public class TaisteluEsine extends Esine {
    
    private Profiili esineenProfiili;
    
    public TaisteluEsine(String nimi, int koodi) {
        super(nimi, koodi);
        this.esineenProfiili = new Profiili();
    }
    
    public Profiili getProfiili() {
        return esineenProfiili;
    }
}
