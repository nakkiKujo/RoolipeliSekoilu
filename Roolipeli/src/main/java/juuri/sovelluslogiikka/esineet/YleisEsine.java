/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juuri.sovelluslogiikka.esineet;

/**
 * Yleisesineet ovat esineitä, joita pelaajan hahmo ei voi kantaa yllään.
 * Yleiesineitä ovat esimerkiksi avamet ja erilaiset juomat tai parantavat
 * voiteet.
 * @author PenaJones
 */
public class YleisEsine extends Esine {
    
    public YleisEsine(String nimi, int koodi) {
        super(nimi, koodi);
    }
}
