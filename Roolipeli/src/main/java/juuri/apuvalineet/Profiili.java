package juuri.apuvalineet;

import juuri.sovelluslogiikka.esineet.TaisteluEsine;

/**
 * Profiili kuvastaa hahmon, hirviön tai esineen ominaisuuksia. Profiiliin
 * kuuluu seuraavat ominaisuudet: voima, taikavoima, elämäpisteet, ketteryys ja
 * taikapuolustus.
 *
 * Pelaajan ja hirviön profiili muuttuu sen mukaan, mitä esineitä hahmo tai
 * hirviö käyttää.
 */
public class Profiili {

    private int voima;
    private int taikaVoima;
    private int ketteryys;
    private int elamaPisteet;
    private int taikaPuolustus;

    public Profiili() {
        this.voima = 0;
        this.taikaVoima = 0;
        this.ketteryys = 0;
        this.elamaPisteet = 0;
        this.taikaPuolustus = 0;
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
    }

    public int getElamaPisteet() {
        return elamaPisteet;
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

    /**
     * Metodi lisää esineen antamat kyvyt profiilille. Jos siis hahmo rupeaa
     * käyttämää miekkaa, lisätään miekan ominaisuudet eli miekan profiili
     * hahmon profiiliin.
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
     * Metodi poistaa esineen profiilin käytöstä. Profiilin ominaisuuksista siis
     * vähennetään esineen profiilin ominaisuudet.
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
