package juuri.sovelluslogiikka.hahmo;

import java.util.ArrayList;
import java.util.HashMap;
import juuri.sovelluslogiikka.esineet.Esine;

/**
 * Reppu pitää kirjaa pelaajan keräämistä esineistä.
 */
public class Reppu {
    
    private HashMap<Integer, ArrayList<Esine>> esineet;
    
    public Reppu() {
        this.esineet = new HashMap<>();
    }
    
    public void asetaEsineReppuun(Esine ee) {
        int esineenKoodi = ee.getKoodi();
        
        if(!esineet.containsKey(esineenKoodi)) {
            esineet.put(esineenKoodi, new ArrayList<>());
        }
        
        esineet.get(esineenKoodi).add(ee);
    }
    
    public boolean onkoRepussa(Esine ee) {
        int esineenKoodi = ee.getKoodi();
        
        if(esineet.get(esineenKoodi) == null) {
            return false;
        }
        
        return esineet.get(esineenKoodi).contains(ee);
    }
    
    public void poistaRepusta(Esine ee) {
        if(!onkoRepussa(ee)) {
            return;
        }
        
        esineet.get(ee.getKoodi()).remove(ee);
    }
    
}
