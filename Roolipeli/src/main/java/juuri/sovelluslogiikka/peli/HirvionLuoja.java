package juuri.sovelluslogiikka.peli;

import java.util.Random;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.maailma.Hirvio;
import juuri.sovelluslogiikka.tapahtumat.Taistelu;

/**
 * Luokan tehtävänä on luoda erilaisia hirviöitä.
 *
 * @author PenaJones
 */
public class HirvionLuoja {

    public static final int NOITA = 1;
    public static final int SUURIROTTA = 2;
    public static final int SUURIROTTAPRONSSIAVAIN = 3;
    public static final int NOKKELANOITA = 4;
    public static final int VALKOKASVO = 5;
    public static final int LUURANKO = 6;
    public static final int MONJAOTUS = 7;
    public static final int SYNKKAHOPEAAVAIN = 8;
    public static final int SYNKKAKULTAVAIN = 9;

    /**
     * Metodi saa parametrina luotavan hirviön koodin, jonka avulla osataan
     * kutsua oikeaa luokan omaa metodia luomaan hirviö. Kutsuttu metodi
     * palauttaa luodun hirviön, jonka tämä metodi puolestaan palauttaa
     * kutsujalle.
     *
     * @param hirvionLuontiKoodi luotavan hirviön koodi, staattinen muuttuja
     * tässä luokassa
     * @return luotu hirviö
     */
    public static Hirvio luoHirvio(int hirvionLuontiKoodi) {
        if (hirvionLuontiKoodi == HirvionLuoja.NOITA) {
            return luoNoita();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.NOKKELANOITA) {
            return luoNokkelaNoita();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.SUURIROTTA) {
            return luoSuuriRotta();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.SUURIROTTAPRONSSIAVAIN) {
            return luoSuuriRottaPronssiavain();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.VALKOKASVO) {
            return luoValkoKasvo();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.LUURANKO) {
            return luoLuuranko();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.MONJAOTUS) {
            return luoMonjaOtus();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.SYNKKAHOPEAAVAIN) {
            return luoSynkkaHopeaAvain();
        }

        if (hirvionLuontiKoodi == HirvionLuoja.SYNKKAKULTAVAIN) {
            return luoSynkkaKultaAvain();
        }
        return null;
    }

    private static Hirvio luoNoita() {
        Hirvio noita = new Hirvio("Noita");
        Taistelu tt = new Taistelu(noita);
        noita.setTapahtuma(tt);

        noita.getProfiili().lisaaVoima(1);
        noita.getProfiili().lisaaTaikaVoima(2);
        noita.getProfiili().lisaaTaikaPuolustus(2);
        noita.getProfiili().lisaaKetteryys(1);
        noita.getProfiili().lisaaElamaPisteet(5);

        noita.lisaaEsine(Esine.RIIMU);
        noita.lisaaEsine(Esine.PARANTAVAVOIDE);

        return noita;
    }

    private static Hirvio luoNokkelaNoita() {
        Hirvio nokkela = new Hirvio("Nokkela noita");
        Taistelu tt = new Taistelu(nokkela);
        nokkela.setTapahtuma(tt);

        nokkela.getProfiili().lisaaVoima(1);
        nokkela.getProfiili().lisaaTaikaVoima(3);
        nokkela.getProfiili().lisaaTaikaPuolustus(2);
        nokkela.getProfiili().lisaaKetteryys(1);
        nokkela.getProfiili().lisaaElamaPisteet(8);

        nokkela.lisaaEsine(Esine.RIIMU);
        nokkela.lisaaEsine(Esine.PARANTAVAVOIDE);
        return nokkela;
    }

    private static Hirvio luoSuuriRotta() {
        Hirvio rotta = new Hirvio("Suuri rotta");
        Taistelu tt = new Taistelu(rotta);
        rotta.setTapahtuma(tt);

        rotta.getProfiili().lisaaVoima(2);
        rotta.getProfiili().lisaaTaikaVoima(0);
        rotta.getProfiili().lisaaTaikaPuolustus(0);
        rotta.getProfiili().lisaaKetteryys(2);
        rotta.getProfiili().lisaaElamaPisteet(8);
        return rotta;
    }

    private static Hirvio luoSuuriRottaPronssiavain() {
        Hirvio rotta = new Hirvio("Suuri rotta");
        Taistelu tt = new Taistelu(rotta);
        rotta.setTapahtuma(tt);

        rotta.getProfiili().lisaaVoima(2);
        rotta.getProfiili().lisaaTaikaVoima(0);
        rotta.getProfiili().lisaaTaikaPuolustus(0);
        rotta.getProfiili().lisaaKetteryys(2);
        rotta.getProfiili().lisaaElamaPisteet(8);

        rotta.lisaaEsine(Esine.PRONSSIAVAIN);
        return rotta;
    }

    private static Hirvio luoValkoKasvo() {
        Hirvio kasvo = new Hirvio("Valkokasvo");
        Taistelu tt = new Taistelu(kasvo);
        kasvo.setTapahtuma(tt);

        kasvo.getProfiili().lisaaVoima(4);
        kasvo.getProfiili().lisaaTaikaVoima(0);
        kasvo.getProfiili().lisaaTaikaPuolustus(3);
        kasvo.getProfiili().lisaaKetteryys(4);
        kasvo.getProfiili().lisaaElamaPisteet(11);

        kasvo.lisaaEsine(Esine.PARANTAVAVOIDE);

        Random arpa = new Random();
        int luku = arpa.nextInt(5);
        if (luku == 0) {
            TaisteluEsine medaljonki = new TaisteluEsine("Mystinen medaljonki", Esine.MEDALJONKI);
            medaljonki.getProfiili().lisaaElamaPisteet(2);
            medaljonki.getProfiili().lisaaTaikaVoima(1);
            medaljonki.getProfiili().lisaaTaikaPuolustus(1);

            kasvo.lisaaEsine(medaljonki);
        } else if (luku == 1) {
            kasvo.lisaaEsine(Esine.RIIMU);
        }

        return kasvo;
    }

    private static Hirvio luoLuuranko() {
        Hirvio ranko = new Hirvio("Luuranko");
        Taistelu tt = new Taistelu(ranko);
        ranko.setTapahtuma(tt);

        ranko.getProfiili().lisaaVoima(3);
        ranko.getProfiili().lisaaTaikaVoima(0);
        ranko.getProfiili().lisaaTaikaPuolustus(3);
        ranko.getProfiili().lisaaKetteryys(5);
        ranko.getProfiili().lisaaElamaPisteet(6);

        Random arpa = new Random();
        int luku = arpa.nextInt(5);
        if (luku == 3) {
            TaisteluEsine kypara = new TaisteluEsine("Jousimiehen hattu", Esine.KYPARA);
            kypara.getProfiili().lisaaElamaPisteet(1);
            kypara.getProfiili().lisaaKetteryys(3);

            ranko.lisaaEsine(kypara);
        }

        return ranko;
    }

    private static Hirvio luoMonjaOtus() {
        Hirvio monja = new Hirvio("Mönjäotus");
        Taistelu tt = new Taistelu(monja);
        monja.setTapahtuma(tt);

        monja.getProfiili().lisaaVoima(2);
        monja.getProfiili().lisaaTaikaVoima(0);
        monja.getProfiili().lisaaTaikaPuolustus(7);
        monja.getProfiili().lisaaKetteryys(7);
        monja.getProfiili().lisaaElamaPisteet(4);

        return monja;
    }

    private static Hirvio luoSynkkaHopeaAvain() {
        Hirvio synkka = new Hirvio("Synkkä olento");
        Taistelu tt = new Taistelu(synkka);
        synkka.setTapahtuma(tt);

        synkka.getProfiili().lisaaVoima(4);
        synkka.getProfiili().lisaaTaikaVoima(5);
        synkka.getProfiili().lisaaTaikaPuolustus(4);
        synkka.getProfiili().lisaaKetteryys(4);
        synkka.getProfiili().lisaaElamaPisteet(12);

        synkka.lisaaEsine(Esine.HOPEAAVAIN);
        synkka.lisaaEsine(Esine.RIIMU);
        synkka.lisaaEsine(Esine.PARANTAVAVOIDE);

        Random arpa = new Random();
        int luku = arpa.nextInt(3);
        if (luku == 1) {
            TaisteluEsine sauva = new TaisteluEsine("Myyttinen taikasauva", Esine.MIEKKA);
            sauva.getProfiili().lisaaTaikaVoima(3);
            sauva.getProfiili().lisaaElamaPisteet(1);
            sauva.getProfiili().lisaaTaikaPuolustus(2);

            synkka.lisaaEsine(sauva);
        }

        return synkka;
    }

    private static Hirvio luoSynkkaKultaAvain() {
        Hirvio synkka = new Hirvio("Synkkä olento");
        Taistelu tt = new Taistelu(synkka);
        synkka.setTapahtuma(tt);

        synkka.getProfiili().lisaaVoima(4);
        synkka.getProfiili().lisaaTaikaVoima(5);
        synkka.getProfiili().lisaaTaikaPuolustus(4);
        synkka.getProfiili().lisaaKetteryys(4);
        synkka.getProfiili().lisaaElamaPisteet(12);

        synkka.lisaaEsine(Esine.KULTAAVAIN);
        synkka.lisaaEsine(Esine.RIIMU);
        synkka.lisaaEsine(Esine.PARANTAVAVOIDE);

        Random arpa = new Random();
        int luku = arpa.nextInt(3);
        if (luku == 1) {
            TaisteluEsine sauva = new TaisteluEsine("Myyttinen taikasauva", Esine.MIEKKA);
            sauva.getProfiili().lisaaTaikaVoima(3);
            sauva.getProfiili().lisaaElamaPisteet(1);
            sauva.getProfiili().lisaaTaikaPuolustus(2);

            synkka.lisaaEsine(sauva);
        }

        return synkka;
    }
}
