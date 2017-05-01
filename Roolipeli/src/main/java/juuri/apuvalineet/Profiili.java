package juuri.apuvalineet;

import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;

/**
 * Profiili kuvastaa hahmon, hirviön tai esineen ominaisuuksia. Profiiliin
 * kuuluu seuraavat ominaisuudet: voima, taikavoima, elämäpisteet, ketteryys
 * ja taikapuolustus.
 *
 * Puolustusvalmius liittyy taisteluihin: pelaaja voi hyökkäämisen sijaan
 * valmistella hahmoa vastaan tulevaan hyökkäykseen. Tämä parantaa pelaajan
 * mahdollisuutta torjua puolustus. Samoin toimii hyökkäysvalmius.
 *
 * Pelaajan ja hirviön profiili muuttuu sen mukaan, mitä esineitä hahmo tai
 * hirviö käyttää.
 */
public class Profiili {

    private int voima;
    private int taikaVoima;
    private int ketteryys;
    private int elamaPisteet;
    private int nykyinenElamaPisteet;

    private int taikaPuolustus;

    private int puolustusValmius;
    private int hyokkaysValmius;

    /**
     * Metodi luo uuden profiilin. Uuden profiilin kaikki ominaisuudet ovat 0.
     */
    public Profiili() {
        this.voima = 0;
        this.taikaVoima = 0;
        this.ketteryys = 0;
        this.elamaPisteet = 0;
        this.nykyinenElamaPisteet = 0;
        this.taikaPuolustus = 0;
        this.puolustusValmius = 0;
        this.hyokkaysValmius = 0;
    }

    /**
     * Metodi kasvattaa profiilin voimaa parametrin verran. Jos parametrina
     * annettu luku on negatiivinen, voiman arvo laskee.
     *
     * @param v haluttu voiman muutos
     */
    public void lisaaVoima(int v) {
        this.voima += v;
    }

    public int getVoima() {
        return voima;
    }

    /**
     * Metodi kasvattaa profiilin taikavoimaa parametrin verran. Negatiivisella
     * parametrilla taikavoiman arvo laskee.
     *
     * @param tv haluttu taikavoiman muutos
     */
    public void lisaaTaikaVoima(int tv) {
        this.taikaVoima += tv;
    }

    public int getTaikaVoima() {
        return taikaVoima;
    }

    /**
     * Metodi kasvattaa profiilin ketteryyttä parametrin verran. Negatiivisella
     * parametrilla ketteryyden arvo laskee.
     *
     * @param k haluttu ketteryyden muutos
     */
    public void lisaaKetteryys(int k) {
        this.ketteryys += k;
    }

    public int getKetteryys() {
        return ketteryys;
    }

    /**
     * Metodi kasvattaa profiilin elämäpisteitä parametrin verran.
     * Negatiivisella parametrilla elämäpisteiden arvo laskee.
     *
     * Metodia käytetään muuttamaan peruselämäpisteiden arvoa. Esimerkiksi
     * taisteluihin liittyvään elämäpisteiden vähennykseen käytetää metodia
     * lisaaNykyinenElamaPisteet. Nykyiset elämäpisteet pitävät yllä nykyistä
     * tilannetta, peruselämäpisteet ns. "perustasoa".
     *
     * @param e haluttu elämäpisteiden muutos
     */
    public void lisaaElamaPisteet(int e) {
        this.elamaPisteet += e;
        lisaaNykyinenElamaPisteet(e);
    }

    /**
     * Metodi muuttaa profiilin nykyistä elämäpistetilannetta. Negatiivinen
     * parametrin arvo vähentää elämäpisteitä, positiivinen kasvattaa.
     *
     * @param e haluttu nykyisten elämäpisteiden muutos
     */
    public void lisaaNykyinenElamaPisteet(int e) {
        this.nykyinenElamaPisteet += e;
        if (nykyinenElamaPisteet > elamaPisteet) {
            nykyinenElamaPisteet = elamaPisteet;
        }
    }

    public int getElamaPisteet() {
        return elamaPisteet;
    }

    public int getNykyinenElamaPisteet() {
        return this.nykyinenElamaPisteet;
    }

    /**
     * Metodi kasvattaa profiilin taikapuolustusta parametrin verran.
     * Negatiivisella parametrilla taikapuolustuksen arvo laskee.
     *
     * @param tp haluttu taikapuolustuksen muutos
     */
    public void lisaaTaikaPuolustus(int tp) {
        this.taikaPuolustus += tp;
    }

    public int getTaikaPuolustus() {
        return taikaPuolustus;
    }
    
    /**
     * Asettaa profiilille soturin alkuominaisuudet.
     * Soturilla on:
     * voimaa 3,
     * taikavoimaa 1,
     * taikapuolustusta 1,
     * ketteryyttä 2,
     * elämäpisteitä 8.
     */
    public void setSoturiAlkuProfiili() {
        this.voima = 4;
        this.taikaVoima = 1;
        this.taikaPuolustus = 1;
        this.ketteryys = 3;
        this.elamaPisteet = 15;
        this.nykyinenElamaPisteet = 15;
    }
    
    /**
     * Asettaa profiilille velhon alkuominaisuudet.
     * Velholla on:
     * voimaa 1,
     * taikavoimaa 3,
     * taikapuolustusta 2,
     * ketteryyttä 2,
     * elämäpisteitä 7.
     */
    public void setVelhoAlkuProfiili() {
        this.voima = 1;
        this.taikaVoima = 4;
        this.taikaPuolustus = 4;
        this.ketteryys = 2;
        this.elamaPisteet = 13;
        this.nykyinenElamaPisteet = 13;
    }
    
    /**
     * Asettaa profiilille druidin alkuominaisuudet.
     * Druidilla on:
     * voimaa 1,
     * taikavoimaa 1,
     * taikapuolustusta 1,
     * ketteryyttä 3,
     * elämäpisteitä 9.
     */
    public void setDruidiAlkuProfiili() {
        this.voima = 1;
        this.taikaVoima = 2;
        this.taikaPuolustus = 2;
        this.ketteryys = 4;
        this.elamaPisteet = 17;
        this.nykyinenElamaPisteet = 17;
    }
    
    /**
     * Asettaa profiilin puolustusvalmiuteen luvun x verran.
     * @param x kuinka suureen valmiuteen profiili asetetaan
     */
    public void asetaPuolustusValmius(int x) {
        this.puolustusValmius = x;
    }

    public int getPuolustusValmius() {
        return this.puolustusValmius;
    }
    
    /**
     * Asettaa profiilin hyökkäysvalmiuteen luvun x verran.
     * @param x kuinka suureen valmiuteen profiili asetetaan
     */
    public void asetaHyokkaysValmius(int x) {
        this.hyokkaysValmius = x;
    }

    public int getHyokkaysValmius() {
        return this.hyokkaysValmius;
    }

    /**
     * Metodi tarkastaa, onko hahmo tai hirviö kuollut. Hahmo tai hirviö kuolee,
     * jos sen elämäpisteet laskevat nollaan.
     *
     * @return onko kuollut
     */
    public boolean onkoKuollut() {
        return this.nykyinenElamaPisteet <= 0;
    }

    /**
     * Metodi lisää esineen antamat kyvyt profiilille. Jos siis hahmo rupeaa
     * käyttämään miekkaa, lisättävän miekan ominaisuudet eli miekan
     * profiili hahmon profiiliin.
     *
     * @param esine lisättävä esine
     */
    public void asetaEsine(TaisteluEsine esine) {
        Profiili esineenProfiili = esine.getProfiili();

        lisaaVoima(esineenProfiili.getVoima());
        lisaaTaikaVoima(esineenProfiili.getTaikaVoima());
        lisaaKetteryys(esineenProfiili.getKetteryys());
        lisaaElamaPisteet(esineenProfiili.getElamaPisteet());
        lisaaTaikaPuolustus(esineenProfiili.getTaikaPuolustus());
    }

    /**
     * Metodi poistaa esineen profiilin käytöstä. Profiilin ominaisuuksista
     * siis vähennetään esineen profiilin ominaisuudet.
     *
     * @param esine poistettava esine
     */
    public void poistaEsine(TaisteluEsine esine) {
        Profiili esineenProfiili = esine.getProfiili();

        lisaaVoima(esineenProfiili.getVoima() * (-1));
        lisaaTaikaVoima(esineenProfiili.getTaikaVoima() * (-1));
        lisaaKetteryys(esineenProfiili.getKetteryys() * (-1));
        lisaaElamaPisteet(esineenProfiili.getElamaPisteet() * (-1));
        lisaaTaikaPuolustus(esineenProfiili.getTaikaPuolustus() * (-1));
    }

    /**
     * Metodi käyttää parantavan esineen, jolloin profiilin nykyiset
     * elämäpisteet parantuvat.
     *
     * @param esine käytettävä esine
     */
    public void kaytaParantavaEsine(YleisEsine esine) {
        if (esine.equals(Esine.PARANTAVAVOIDE)) {
            this.lisaaNykyinenElamaPisteet(3);
        }

    }

}
