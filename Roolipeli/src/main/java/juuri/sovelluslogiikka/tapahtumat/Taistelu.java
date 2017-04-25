package juuri.sovelluslogiikka.tapahtumat;

import java.util.Random;
import juuri.apuvalineet.Profiili;
import juuri.apuvalineet.TaisteluLaskin;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.maailma.Hirvio;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Luolasto;

/**
 * Taistelu on tapahtuma, joka liittyy pelaajan hahmon ja luolassa olevan
 * hirviön kohtaamiseen. Pelaaja voi yrittää paeta taistelusta. Voittaessaan
 * pelaaja saa itselleen hirviön kantamat esineet. Taistelu tapahtuu käyttäen
 * apuna TaisteluLaskinta, jonka avulla selvitetään, kuka taistelun voittaa.
 */
public class Taistelu extends Tapahtuma {

    private Hirvio hirvio;
    private Hahmo pelaajanHahmo;
    private TaisteluLaskin laskin;

    /**
     * Luodaan uusi taistelu-olio. Prametrina annetaan taisteluun liittyvä
     * hirviö.
     *
     * Metodissa asetetaan taistelulle koodi ja taistelulaskin, jonka avulla
     * taisteluu liittyviä toimintoja pystytään laskemaan.
     *
     * @param hirvio taisteluun liittyvä hirviö
     */
    public Taistelu(Kohde hirvio) {
        this.koodi = Tapahtuma.TAISTELU;
        this.hirvio = (Hirvio) hirvio;
        this.laskin = new TaisteluLaskin();
    }

    /**
     * Palauttaa taisteluun liittyvän hirviön.
     *
     * @return taistelun hirviö
     */
    public Hirvio getHirvio() {
        return this.hirvio;
    }

    /**
     * Metodi kysyy pelaajalta, tahtooko hän lähteä taistoo vai pyrkiä pakoon.
     * Vaihtoehto yksi on taistella, vaihtoehto kaksi on pyrkiä pakoon.
     *
     * @param hahmo pelaajan hahmo
     */
    @Override
    public void valmisteleTapahtuma(Hahmo hahmo) {
        this.tapahtumaTeksti = "Edessäsi on hirmuinen " + hirvio.getNimi() + "."
                + "\nTaisteluun!?";
        this.vaihtoehtoYksi = "Taistoon!!!";
        this.vaihtoehtoKaksi = "Yritän perääntyä.";
    }

    /**
     * Metodi aloittaa taistelun. Jos hiviön ketteryys on suurempi kuin pelaajan
     * ketteryys, saa hirviö valmistautua taistoon pelaajaa enemmän.
     *
     * @param hahmo
     * @param luola
     */
    @Override
    public void toteutaVaihtoehtoYksi(Hahmo hahmo, Luolasto luola) {
        this.pelaajanHahmo = hahmo;

        if (hirvio.getProfiili().getKetteryys() > pelaajanHahmo.getProfiili().getKetteryys()) {
            Random arpa = new Random();
            int luku = arpa.nextInt(2);
            if (luku == 0) {
                hirvioValmistautuuHyokkaykseen();
            } else {
                hirvioValmistautuuVaistoon();
            }
        }
    }

    /**
     * Metodia ei käytetä.
     *
     * @param hahmo ---
     * @param luola ---
     */
    @Override
    public void toteutaVaihtoehtoKaksi(Hahmo hahmo, Luolasto luola) {
    }

    /**
     * Tämä metodi vastaa taisteluiden vaihtoehtokaksi-metodia. Metodissa
     * kokeillaan, pystyykö pelaajan välttymään taistelulta ennen sen alkamista.
     *
     * Palauttaa true, jos pako onnistuu. Palauttaa false, jos ei pelaaja ei
     * pääse pakenemaan.
     *
     * @param hahmo pelaajan hahmo
     * @return onnistuuko pakeneminen vai ei
     */
    public boolean toteutaVaihtoehtoKaksiTaistelu(Hahmo hahmo) {
        boolean onnistuukoPako = laskin.peraantyminen(hahmo.getProfiili(), hirvio.getProfiili());

        if (onnistuukoPako) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi käsittelee pelaajan hahmon lyönnin. Lyönnistä aiheutuva isku
     * lasketaan taistelulaskimella.
     *
     * Jos isku kohteena ollut hirviö kuolee, asetetaa hirviölle olleet esineet
     * pelaajan hahmo reppuun. Jos hirviö ei kuole, arvotaan hirviölle
     * vastatoiminta.
     *
     * Metodi palauttaa true, jos taistelu jatkuu ja false, jos taistelu
     * päättyy.
     *
     * @return jatkuuko taistelu vai eikö jatku
     */
    public boolean pelaajaLyo() {
        int iskunMaara = laskin.lyonti(pelaajanHahmo.getProfiili(), hirvio.getProfiili());
        hirvio.getProfiili().lisaaNykyinenElamaPisteet(iskunMaara * (-1));

        if (hirvio.getProfiili().onkoKuollut()) {
            //hirviö kuoli, taistelu päättyy
            for (Esine hirviollaOllutEsine : hirvio.getEsineet()) {
                pelaajanHahmo.getReppu().asetaEsineReppuun(hirviollaOllutEsine);
            }

            laskin.taistelunPaatos(pelaajanHahmo.getProfiili(), hirvio.getProfiili());
            return false;
        }

        return arvoHirviolleToiminta();
    }

    /**
     * Metodi suorittaa hirviön lyönnin pelaajaa kohti. Taistelulaskimella
     * lasketaan lyönnin voimakkuus. Jos pelaajan elämäpisteet menevät iskun
     * voimasta alle nollan, pelaajan hahmo kuolee. Tällöin taistelu ja lopulta
     * myös peli päättyy.
     *
     * Metodi palauttaa true, jos taistelu jatkuu, ja false, jos taistelu
     * päättyy.
     *
     * @return jatkuuko taistelu
     */
    public boolean hirvioLyo() {
        int iskunMaara = laskin.lyonti(hirvio.getProfiili(), pelaajanHahmo.getProfiili());
        pelaajanHahmo.getProfiili().lisaaNykyinenElamaPisteet(iskunMaara * (-1));

        return !pelaajanHahmo.getProfiili().onkoKuollut();
    }

    /**
     * Metodi suorittaa pelaajan loitsun loihtimisen. Loitsun kohteena on
     * hirviö. Metodi laskee taistelulaskimen avulla, paljonko vahinkoa loitsu
     * aiheuttaa.
     *
     * Loitsun loihtiminen poistaa pelaajan repusta yhden riimu-esineen.
     *
     * Jos hirviö kuolee, taistelu päättyy ja palautetaan false. Jos hirviö ei
     * kuole, hirviö saa toimia.
     *
     * Palautetaan true, jos taistelu jatkuu, false, jos taistelu päättyy.
     *
     * @return jatkuuko taistelu
     */
    public boolean pelaajaLoihtiiLoitsun() {
        pelaajanHahmo.getReppu().poistaRepusta(Esine.RIIMU);
        int iskunMaara = laskin.taikaLyonti(pelaajanHahmo.getProfiili(), hirvio.getProfiili());
        hirvio.getProfiili().lisaaNykyinenElamaPisteet(iskunMaara * (-1));

        if (hirvio.getProfiili().onkoKuollut()) {
            for (Esine hirviollaOllutEsine : hirvio.getEsineet()) {
                pelaajanHahmo.getReppu().asetaEsineReppuun(hirviollaOllutEsine);
            }

            laskin.taistelunPaatos(pelaajanHahmo.getProfiili(), hirvio.getProfiili());
            return false;
        }

        return arvoHirviolleToiminta();
    }

    /**
     * Metodi toteuttaa hirviön loitsuiskun pelaajaa kohtaan. Taistelulaskimella
     * lasketaan iskun voimakkuus.
     *
     * Jos pelaajan elämäpisteet laskevat nollaan tai alle, pelaajan hahmo
     * kuolee ja taistelu päättyy. Tällöin metodi palauttaa false.
     *
     * Jos taistelu jatkuu, metodi palauttaa true.
     *
     * @return jatkuuko taistelu
     */
    public boolean hirvioLoihtiiLoitsun() {
        int iskunMaara = laskin.taikaLyonti(hirvio.getProfiili(), pelaajanHahmo.getProfiili());
        pelaajanHahmo.getProfiili().lisaaNykyinenElamaPisteet(iskunMaara * (-1));

        return !pelaajanHahmo.getProfiili().onkoKuollut();
    }

    /**
     * Metodi toteuttaa pelaajan valmistautumisen väistämiseen. Tällöin pelaajan
     * profiilille asetetaan puolustusvalmiutta ketteryyden mukaan.
     *
     * Lisäksi arvotaan hirviölle vastatoiminta.
     *
     * Metodi palauttaa tiedon siitä, jatkuuko taistelu vai ei. Palautetaan
     * true, jos jatkuu, ja false, jos taistelu päättyy.
     *
     * @return jatkuuko taistelu
     */
    public boolean pelaajaValmistautuuVaistoon() {
        pelaajanHahmo.getProfiili().asetaPuolustusValmius(1 + pelaajanHahmo.getProfiili().getKetteryys() / 2);

        return arvoHirviolleToiminta();
    }

    /**
     * Metodi toteuttaa hirviön valmistautumisen väistämiseen. Tällöin hirviön
     * profiilille asetetaan puolustusvalmiutta ketteryyden mukaan.
     *
     * Metodi palauttaa true, sillä taistelu jatkuu.
     *
     * @return taistelu jatkuu
     */
    public boolean hirvioValmistautuuVaistoon() {
        hirvio.getProfiili().asetaPuolustusValmius(1 + hirvio.getProfiili().getKetteryys() / 2);
        return true;
    }

    /**
     * Metodi toteuttaa pelaajan valmistautumisen hyökkäykseen. Tällöin pelaajan
     * profiilille asetetaan hyökkäysvalmiutta ketteryyden ja voiman mukaan.
     *
     * Lisäksi arvotaan hirviölle jatkotoiminta. Palautetaan true, jos taistelu
     * jatkuu ja false, jos taistelu ei jatku
     *
     * @return jatkuuko taistelu
     */
    public boolean pelaajaValmistautuuHyokkaykseen() {
        int voima = pelaajanHahmo.getProfiili().getVoima();
        int ketteryys = pelaajanHahmo.getProfiili().getKetteryys();

        pelaajanHahmo.getProfiili().asetaHyokkaysValmius(voima / 2 + ketteryys / 2);

        return arvoHirviolleToiminta();
    }

    /**
     * Metodi toteuttaa hirviön valmistautumisen hyökkäykseen. Tällöin hirviön
     * profiilille asetetaan hyökkäysvalmiutta ketteryyden ja voiman mukaan.
     *
     * Metodi palauttaa true, sillä taistelu jatkuu.
     *
     * @return taistelu jatkuu
     */
    public boolean hirvioValmistautuuHyokkaykseen() {
        int voima = hirvio.getProfiili().getVoima();
        int ketteryys = hirvio.getProfiili().getKetteryys();

        hirvio.getProfiili().asetaHyokkaysValmius(voima / 2 + ketteryys / 2);

        return true;
    }

    /**
     * Metodi toteuttaa pelaajan yrityksen päästä pakoon. Paon onnistuminen
     * lasketaan taistelulaskimella. Jos pako onnistuu, taistelu päättyy. Jos
     * pako epäonnistuu, hirviö saa vastatoimen ja taistelu jatkuu.
     *
     * Palautetaan true, jos taistelu jatkuu. Palautetaan fale, jos taistelu
     * päättyy.
     *
     * @return jatkuuko taistelu
     */
    public boolean pelaajaPyrkiiPakoon() {
        boolean paaseekoPakoon = laskin.peraantyminen(pelaajanHahmo.getProfiili(), hirvio.getProfiili());

        if (paaseekoPakoon) {
            laskin.taistelunPaatos(pelaajanHahmo.getProfiili(), hirvio.getProfiili());
            return false;
        }

        return arvoHirviolleToiminta();
    }

    /**
     * Metodi arpoo hirviölle toiminnon. Toiminnan arpomiseen vaikuttaa, onko
     * hiviöllä ollenkaan taikavoimaa. Jos taikavoimaa ei ole, hirviö ei loihdu
     * loitsuja. Jos hirviöllä on taikavoimaa, se todennäköisemmin loihtii kuin
     * lyö.
     *
     * Tämän lisäksi hirviö voi valmistautua hyökkäämään tai puolustamaan. Jos
     * hirviö on jo valmistautunut jompaan kumpaan, ei se enää uudestaan
     * valmistaudu samalla tavoin.
     *
     * Metodi palauttaa tiedon, jatkuuko taistelu vai ei. Palautetaan true, jos
     * taistelu jatkuu. Palautetaan false, jos taistelu päättyy.
     *
     * @return jatkuuko taistelu
     */
    public boolean arvoHirviolleToiminta() {
        Random arpa = new Random();
        int luku;
        Profiili hirvionP = hirvio.getProfiili();

        if (hirvionP.getTaikaVoima() == 0) {
            if (hirvionP.getHyokkaysValmius() > 0 && hirvionP.getPuolustusValmius() > 0) {
                return hirvioLyo();
            } else if (hirvionP.getHyokkaysValmius() > 0) {
                luku = arpa.nextInt(2);
                if (luku == 0) {
                    return hirvioValmistautuuVaistoon();
                }
                return hirvioLyo();
            } else if (hirvionP.getPuolustusValmius() > 0) {
                luku = arpa.nextInt(2);
                if (luku == 0) {
                    return hirvioValmistautuuHyokkaykseen();
                }
                return hirvioLyo();
            } else {
                luku = arpa.nextInt(3);
                if (luku == 0) {
                    return hirvioValmistautuuVaistoon();
                } else if (luku == 1) {
                    return hirvioValmistautuuHyokkaykseen();
                }
                return hirvioLyo();
            }

        } else {
            if (hirvionP.getHyokkaysValmius() > 0 && hirvionP.getPuolustusValmius() > 0) {
                luku = arpa.nextInt(3);
                if (luku == 0) {
                    return hirvioLyo();
                }
                return hirvioLoihtiiLoitsun();

            } else if (hirvionP.getHyokkaysValmius() > 0) {
                luku = arpa.nextInt(2);
                if (luku == 0) {
                    return hirvioValmistautuuVaistoon();
                }
                luku = arpa.nextInt(3);
                if (luku == 0) {
                    return hirvioLyo();
                }
                return hirvioLoihtiiLoitsun();

            } else if (hirvionP.getPuolustusValmius() > 0) {
                luku = arpa.nextInt(2);
                if (luku == 0) {
                    return hirvioValmistautuuHyokkaykseen();
                }
                luku = arpa.nextInt(3);
                if (luku == 0) {
                    return hirvioLyo();
                }
                return hirvioLoihtiiLoitsun();
            } else {
                luku = arpa.nextInt(3);
                if (luku == 0) {
                    return hirvioValmistautuuVaistoon();
                } else if (luku == 1) {
                    return hirvioValmistautuuHyokkaykseen();
                }

                luku = arpa.nextInt(3);
                if (luku == 0) {
                    return hirvioLyo();
                }
                return hirvioLoihtiiLoitsun();
            }
        }
    }

}
