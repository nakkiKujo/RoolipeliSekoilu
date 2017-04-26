package juuri.sovelluslogiikka.peli;

import juuri.sovelluslogiikka.esineet.Esine;
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

        return kasvo;
    }
}
