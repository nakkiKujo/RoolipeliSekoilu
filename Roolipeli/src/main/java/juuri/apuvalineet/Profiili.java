package juuri.apuvalineet;

import juuri.sovelluslogiikka.esineet.TaisteluEsine;

/**
 * Profiili kuvastaa hahmon, hirviÃ¶n tai esineen ominaisuuksia. Profiiliin
 * kuuluu seuraavat ominaisuudet: voima, taikavoima, elÃ¤mÃ¤pisteet, ketteryys
 * ja taikapuolustus.
 *
 * Puolustusvalmius liittyy taisteluihin: pelaaja voi hyökkäämisen sijaan
 * valmistella hahmoa vastaan tulevaan hyökkäykseen. Tämä parantaa pelaajan
 * mahdollisuutta torjua puolustus. Samoin toimii hyökkäysvalmius.
 * 
 * Pelaajan ja hirviÃ¶n profiili muuttuu sen mukaan, mitÃ¤ esineitÃ¤ hahmo tai
 * hirviÃ¶ kÃ¤yttÃ¤Ã¤.
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

    public Profiili() {
        this.voima = 0;
        this.taikaVoima = 0;
        this.ketteryys = 0;
        this.elamaPisteet = 0;
        this.taikaPuolustus = 0;
        this.puolustusValmius = 0;
        this.hyokkaysValmius = 0;
    }

    public void lisaaVoima(int v) {
        this.voima += v;
    }

    public int getVoima() {
        return voima;
    }

    public void lisaaTaikaVoima(int tv) {
        this.taikaVoima += tv;
    }

    public int getTaikaVoima() {
        return taikaVoima;
    }

    public void lisaaKetteryys(int k) {
        this.ketteryys += k;
    }

    public int getKetteryys() {
        return ketteryys;
    }

    public void lisaaElamaPisteet(int e) {
        this.elamaPisteet += e;
        lisaaNykyinenElamaPisteet(e);
    }

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

    public void lisaaTaikaPuolustus(int tp) {
        this.taikaPuolustus += tp;
    }

    public int getTaikaPuolustus() {
        return taikaPuolustus;
    }

    public void setSoturiAlkuProfiili() {
        this.voima = 3;
        this.taikaVoima = 1;
        this.taikaPuolustus = 1;
        this.ketteryys = 2;
        this.elamaPisteet = 6;
    }

    public void setVelhoAlkuProfiili() {
        this.voima = 1;
        this.taikaVoima = 3;
        this.taikaPuolustus = 2;
        this.ketteryys = 2;
        this.elamaPisteet = 5;
    }

    public void setDruidiAlkuProfiili() {
        this.voima = 1;
        this.taikaVoima = 1;
        this.taikaPuolustus = 1;
        this.ketteryys = 3;
        this.elamaPisteet = 7;
    }

    public void asetaPuolustusValmius(int x) {
        this.puolustusValmius = x;
    }

    public int getPuolustusValmius() {
        return this.puolustusValmius;
    }

    public void asetaHyokkaysValmius(int x) {
        this.hyokkaysValmius = x;
    }

    public int getHyokkaysValmius() {
        return this.hyokkaysValmius;
    }

    /**
     * Metodi lisÃ¤Ã¤ esineen antamat kyvyt profiilille. Jos siis hahmo rupeaa
     * kÃ¤yttÃ¤mÃ¤Ã¤ miekkaa, lisÃ¤tÃ¤Ã¤n miekan ominaisuudet eli miekan
     * profiili hahmon profiiliin.
     *
     * @param esine lisÃ¤ttÃ¤vÃ¤ esine
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
     * Metodi poistaa esineen profiilin kÃ¤ytÃ¶stÃ¤. Profiilin ominaisuuksista
     * siis vÃ¤hennetÃ¤Ã¤n esineen profiilin ominaisuudet.
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

}
