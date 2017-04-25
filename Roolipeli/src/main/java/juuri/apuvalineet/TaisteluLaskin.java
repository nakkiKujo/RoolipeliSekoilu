package juuri.apuvalineet;

import java.util.Random;

/**
 * Taistelulaskin laskee taisteluun liittyvät laskutoimitukset. Sen avulla
 * selvitetään , osuvatko iskut, paljonko iskut tekevät vahinkoa sekä
 * pakenemiseen liittyvät lasktoimitukset.
 *
 * Laskin käyttää Random-oliota luomaan satunnaisuutta laskuihin.
 *
 * @author PenaJones
 */
public class TaisteluLaskin {

    private Random arpoja;

    /**
     * Luodaan uusi taistelulaskin. Laskin käyttää laskusuorituksissaan paljon
     * satunnaisuutta, joten asetetaan oliomuuttujaksi Random-olio.
     */
    public TaisteluLaskin() {
        this.arpoja = new Random();
    }

    /**
     * Metodi laskee, osuuko taistelussa tehtävä lyönti. Jos lyönti osuu,
     * lasketaan, kuinka paljon vahinkoa lyönti aiheuttaa.
     *
     * Parametreina annetaan taistelun osapuolten profiilit, joiden
     * ominaisuuksien avulla lyöntiin liittyvät laskut lasketaan.
     *
     * @param lyoja lyövän otuksen profiili
     * @param lyotava lyötävän otuksen profiili
     * @return palautetaan tehtävän vahingon määrä
     */
    public int lyonti(Profiili lyoja, Profiili lyotava) {
        int lyojanKetteryys = lyoja.getKetteryys();
        int lyotavanKetteryys = lyotava.getKetteryys();

        int lyojanVoima = lyoja.getVoima();
        int lyotavanVoima = lyotava.getVoima();

        int hyokkays = arpoja.nextInt(lyojanVoima + lyojanKetteryys + 1 + lyoja.getHyokkaysValmius()) + 1 + (lyojanKetteryys / 2) + (lyojanVoima / 2);
        int puolustus = arpoja.nextInt(lyotavanVoima + lyotavanKetteryys + 1 + lyotava.getPuolustusValmius()) + 1 + (lyotavanKetteryys / 2) + (lyotavanVoima / 2);

        lyoja.asetaHyokkaysValmius(0);
        lyotava.asetaPuolustusValmius(0);

        if (puolustus >= hyokkays) {
            return 0;
        }

        int lyotavaVahinko = arpoja.nextInt(lyojanVoima + 1) + 1 - (lyotavanKetteryys / 2);
        if (lyotavaVahinko <= 0) {
            return 1;
        }

        return lyotavaVahinko;
    }

    /**
     * Metodi laskee taikahyökkäykseen liittyvät laskut. Metodi selvittää ensin,
     * osuuko taiottu loitsu. Tämän jälkeen lasketaan syntynyt vahinko.
     *
     * Metodille annetaan taistelun osapuolten profiilit, joiden ominaisuuksilla
     * lasketaan taikahyökkäyksen kulku.
     *
     * Metodi palauttaa tehdyn vahingon määrän.
     *
     * @param lyoja hyökkäävän osapuolen profiili
     * @param lyotava puolustavan osapuolen profiili
     * @return palautetaan tehty vanhinko
     */
    public int taikaLyonti(Profiili lyoja, Profiili lyotava) {
        int lyojanTaikaVoima = lyoja.getTaikaVoima();
        int lyotavanTaikaPuolustus = lyotava.getTaikaPuolustus();

        int hyokkays = arpoja.nextInt(lyojanTaikaVoima + 1) + 1 + (lyojanTaikaVoima / 2);
        int puolustus = arpoja.nextInt(lyotavanTaikaPuolustus + 1) + 1 + (lyotavanTaikaPuolustus / 2);

        if (puolustus >= hyokkays) {
            return 0;
        }

        int lyotavaVahinko = arpoja.nextInt(lyojanTaikaVoima + 1) + 2;
        return lyotavaVahinko;
    }

    /**
     * Metodi selvittää, pääseekö pekeneva osapuoli karkaamaan taistelusta. Jos
     * pako onnistuu, palautetaan true. Jos pako epäonnistuu, palautetaan false.
     *
     * Metodille annetaan parametreina taistelun osapuolten profiilit. Niiden
     * avulla selvitetään, onnistuuko pako vai eikö.
     *
     * @param pakenija pakenevan osapuolen profiili
     * @param hyokkaaja toisen osapuolen profiili
     * @return palautetaan, onnistuuko pako vai ei
     */
    public boolean peraantyminen(Profiili pakenija, Profiili hyokkaaja) {
        int pakenijanKetteryys = pakenija.getKetteryys();
        int hyokkaajanKetteryys = hyokkaaja.getKetteryys();

        int pakoYritys = arpoja.nextInt(5) + 1 + (pakenijanKetteryys / 2);
        int alaKarkaa = arpoja.nextInt(7) + 1 + (hyokkaajanKetteryys / 2);

        if (pakoYritys <= alaKarkaa) {
            return false;
        }

        return true;
    }

    /**
     * Taistelun päätteeksi asetetaan valmiudet nollaan. Jos hirviö on jäänyt
     * henkiin, sen elämäpisteet palautetaan normaaliin arvoon.
     *
     * @param pelaaja pelaajan profiili
     * @param hirvio hirviön profiili
     */
    public void taistelunPaatos(Profiili pelaaja, Profiili hirvio) {
        pelaaja.asetaHyokkaysValmius(0);
        pelaaja.asetaPuolustusValmius(0);

        if (!hirvio.onkoKuollut()) {
            hirvio.lisaaNykyinenElamaPisteet(10000);
            hirvio.asetaHyokkaysValmius(0);
            hirvio.asetaPuolustusValmius(0);
        }
    }
}
