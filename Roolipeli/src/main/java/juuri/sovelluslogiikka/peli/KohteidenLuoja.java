package juuri.sovelluslogiikka.peli;

import java.util.ArrayList;
import java.util.Random;
import juuri.sovelluslogiikka.esineet.Esine;
import juuri.sovelluslogiikka.esineet.TaisteluEsine;
import juuri.sovelluslogiikka.esineet.YleisEsine;
import juuri.sovelluslogiikka.maailma.Aarre;
import juuri.sovelluslogiikka.maailma.Ansa;
import juuri.sovelluslogiikka.maailma.Kohde;
import juuri.sovelluslogiikka.maailma.Ovi;
import juuri.sovelluslogiikka.maailma.Portaat;
import juuri.sovelluslogiikka.maailma.Seina;
import juuri.sovelluslogiikka.tapahtumat.AarteenLoytaminen;
import juuri.sovelluslogiikka.tapahtumat.AnsaanAstuminen;
import juuri.sovelluslogiikka.tapahtumat.OvenAvaus;
import juuri.sovelluslogiikka.tapahtumat.PortaissaKulkeminen;

/**
 * Tämä luokka vastaa luolaston kohteiden luomisesta.
 *
 * @author PenaJones
 */
public class KohteidenLuoja {

    public static final int SEINA = Kohde.SEINA;
    public static final int OVIPRONSSIAVAAJA = 10;
    public static final int OVIHOPEAAVAAJA = 11;
    public static final int OVIKULTAAVAAJA = 12;
    public static final int OVIAVOIN = 13;

    public static final int AARREJOSSAHOPEAAVAIN = 200;
    public static final int AARREJOSSAPRONSSIAVAIN = 201;
    public static final int AARREJOSSAMIEKKA1 = 211;
    public static final int AARREJOSSAMIEKKA2 = 212;
    public static final int AARREMIEKKA3 = 213;
    public static final int AARREJOSSARIIMUJAJAMEDALJONKI = 221;
    public static final int AARREJOSSARIIMUJATAIKASAUVA = 222;
    public static final int AARRE2VOIDETTA = 231;
    public static final int AARRE5VOIDETTA = 233;
    public static final int AARRE1VOIDE1RIIMU = 232;
    public static final int AARREKYPARA1 = 24;
    public static final int AARREKYPARA2 = 241;
    public static final int AARREKYPARA3 = 242;
    public static final int AARREKAAPUTAIHAARNISKA = 25;
    public static final int AARREJUMALTENHAARNISKA = 261;
    public static final int AARREJUMALTENMEDALJONKI = 262;

    public static final int ANSAPIIKKI = 40;
    public static final int ANSANUOLI = 41;
    public static final int ANSAKUILU = 42;
    public static final int ANSALIEKKI = 43;
    public static final int ANSATHEEND = 44;

    public static final int PORTAAT = Kohde.PORTAAT;

    /**
     * Metodi kutsuu parametrina annetun koodin määrittämää metodia ja luo
     * kohteen. Luotu kohde palautetaan.
     *
     * Annettava koodi on KohteidenLuojan staattinen attribuutti.
     *
     * @param koodi luotavan kohteen luontikoodi
     * @return luotu kohde
     */
    public static Kohde luoKohde(int koodi) {
        if (koodi == KohteidenLuoja.SEINA) {
            return luoSeina();
        }

        //ovet
        if (koodi == KohteidenLuoja.OVIAVOIN) {
            return luoOvi(null, "puinen ovi");
        }
        if (koodi == KohteidenLuoja.OVIPRONSSIAVAAJA) {
            return luoOvi(Esine.PRONSSIAVAIN, "puinen ovi");
        }
        if (koodi == KohteidenLuoja.OVIHOPEAAVAAJA) {
            return luoOvi(Esine.HOPEAAVAIN, "tuhti metallinen ovi");
        }
        if (koodi == KohteidenLuoja.OVIKULTAAVAAJA) {
            return luoOvi(Esine.KULTAAVAIN, "koristeellinen ovi");
        }

        //aarteet
        if (koodi == KohteidenLuoja.AARREJOSSAPRONSSIAVAIN) {
            ArrayList<Esine> lista = new ArrayList<>();
            lista.add(Esine.PRONSSIAVAIN);
            return luoAarre(lista, "pieni metallinen lipas");
        }
        if (koodi == KohteidenLuoja.AARREJOSSAHOPEAAVAIN) {
            ArrayList<Esine> lista = new ArrayList<>();
            lista.add(Esine.HOPEAAVAIN);
            return luoAarre(lista, "suuri aarrearkku");
        }
        if (koodi == KohteidenLuoja.AARREJOSSAMIEKKA1) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine miekka = new TaisteluEsine("Kelpo miekka", Esine.MIEKKA);
            miekka.getProfiili().lisaaVoima(1);
            miekka.getProfiili().lisaaKetteryys(1);
            lista.add(miekka);
            return luoAarre(lista, "vanha seikkailijan reppu");
        }
        if (koodi == KohteidenLuoja.AARREJOSSAMIEKKA2) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine miekka = new TaisteluEsine("Roima miekka", Esine.MIEKKA);
            miekka.getProfiili().lisaaVoima(3);
            miekka.getProfiili().lisaaKetteryys(-1);
            miekka.getProfiili().lisaaElamaPisteet(1);
            lista.add(miekka);
            return luoAarre(lista, "vanha seikkailijan reppu");
        }
        if (koodi == KohteidenLuoja.AARREMIEKKA3) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine miekka = new TaisteluEsine("Tulinen miekka", Esine.MIEKKA);
            miekka.getProfiili().lisaaVoima(3);
            miekka.getProfiili().lisaaKetteryys(1);
            miekka.getProfiili().lisaaElamaPisteet(2);
            miekka.getProfiili().lisaaTaikaPuolustus(2);
            lista.add(miekka);
            return luoAarre(lista, "vanha seikkailijan reppu");
        }
        if (koodi == KohteidenLuoja.AARREJOSSARIIMUJATAIKASAUVA) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine sauva = new TaisteluEsine("Vanha taikasauva", Esine.MIEKKA);
            sauva.getProfiili().lisaaTaikaVoima(2);
            lista.add(sauva);
            lista.add(Esine.RIIMU);
            return luoAarre(lista, "taianomainen laatikko");
        }
        if (koodi == KohteidenLuoja.AARREJOSSARIIMUJAJAMEDALJONKI) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine medaljonki = new TaisteluEsine("Uhmakas medaljonki", Esine.MEDALJONKI);
            medaljonki.getProfiili().lisaaElamaPisteet(1);
            medaljonki.getProfiili().lisaaVoima(2);
            lista.add(medaljonki);
            lista.add(Esine.RIIMU);
            return luoAarre(lista, "jykevä puinen laatikko");
        }
        if (koodi == KohteidenLuoja.AARRE2VOIDETTA) {
            ArrayList<Esine> lista = new ArrayList<>();
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.PARANTAVAVOIDE);
            return luoAarre(lista, "luiden ympäröimä säkki");
        }
        if(koodi == KohteidenLuoja.AARRE5VOIDETTA) {
            ArrayList<Esine> lista = new ArrayList<>();
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.PARANTAVAVOIDE);
            return luoAarre(lista, "luiden ympäröimä säkki");
        }
        if (koodi == KohteidenLuoja.AARRE1VOIDE1RIIMU) {
            ArrayList<Esine> lista = new ArrayList<>();
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.RIIMU);
            return luoAarre(lista, "luiden ympäröimä säkki");
        }
        if (koodi == KohteidenLuoja.AARREKYPARA1) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine kypara = new TaisteluEsine("Maallikon kypärä", Esine.KYPARA);
            kypara.getProfiili().lisaaElamaPisteet(1);
            kypara.getProfiili().lisaaVoima(1);
            kypara.getProfiili().lisaaKetteryys(1);
            kypara.getProfiili().lisaaTaikaPuolustus(-2);
            kypara.getProfiili().lisaaTaikaVoima(-1);
            TaisteluEsine velhoHattu = new TaisteluEsine("Nuhjuinen hattu", Esine.KYPARA);
            velhoHattu.getProfiili().lisaaElamaPisteet(1);
            velhoHattu.getProfiili().lisaaKetteryys(-1);
            velhoHattu.getProfiili().lisaaTaikaVoima(1);
            velhoHattu.getProfiili().lisaaTaikaPuolustus(1);
            lista.add(kypara);
            lista.add(velhoHattu);
            return luoAarre(lista, "luuranko, jolla on päässä päähineitä");
        }
        if (koodi == KohteidenLuoja.AARREKYPARA2) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine kypara = new TaisteluEsine("Ritarin kypärä", Esine.KYPARA);
            kypara.getProfiili().lisaaElamaPisteet(2);
            kypara.getProfiili().lisaaVoima(2);
            kypara.getProfiili().lisaaKetteryys(1);
            lista.add(kypara);
            return luoAarre(lista, "luuranko, jolla on päässä kypärä");
        }
        if (koodi == KohteidenLuoja.AARREKYPARA3) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine kypara = new TaisteluEsine("Sankarin kypärä", Esine.KYPARA);
            kypara.getProfiili().lisaaElamaPisteet(3);
            kypara.getProfiili().lisaaVoima(3);
            kypara.getProfiili().lisaaKetteryys(2);
            lista.add(kypara);
            return luoAarre(lista, "luuranko, jolla on päässä kypärä");
        }
        if (koodi == KohteidenLuoja.AARREKAAPUTAIHAARNISKA) {
            Random arpa = new Random();
            ArrayList<Esine> lista = new ArrayList<>();

            int luku = arpa.nextInt(2);
            if (luku == 0) {
                TaisteluEsine kaapu = new TaisteluEsine("Velhon kaapu", Esine.TORSO);
                kaapu.getProfiili().lisaaElamaPisteet(1);
                kaapu.getProfiili().lisaaTaikaPuolustus(2);
                kaapu.getProfiili().lisaaTaikaVoima(2);
                kaapu.getProfiili().lisaaKetteryys(-2);
                lista.add(kaapu);
            } else {
                TaisteluEsine haarniska = new TaisteluEsine("Soturin haarniska", Esine.TORSO);
                haarniska.getProfiili().lisaaElamaPisteet(2);
                haarniska.getProfiili().lisaaTaikaPuolustus(-1);
                haarniska.getProfiili().lisaaVoima(1);
                lista.add(haarniska);
            }

            return luoAarre(lista, "mystinen arkku");
        }
        if (koodi == KohteidenLuoja.AARREJUMALTENHAARNISKA) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine haarniska = new TaisteluEsine("Jumalten haarniska", Esine.TORSO);
            haarniska.getProfiili().lisaaElamaPisteet(4);
            haarniska.getProfiili().lisaaTaikaPuolustus(3);
            haarniska.getProfiili().lisaaVoima(1);
            lista.add(haarniska);
            
            return luoAarre(lista, "mystinen arkku");
        }
        if(koodi == KohteidenLuoja.AARREJUMALTENMEDALJONKI) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine medaljonki = new TaisteluEsine("Jumalten medaljonki", Esine.MEDALJONKI);
            medaljonki.getProfiili().lisaaElamaPisteet(2);
            medaljonki.getProfiili().lisaaVoima(2);
            medaljonki.getProfiili().lisaaTaikaVoima(2);
            lista.add(medaljonki);
            return luoAarre(lista, "mystinen laatikko");
        }

        //ansat
        if (koodi == KohteidenLuoja.ANSANUOLI) {
            return luoAnsa("nuoliansa", 4);
        }
        if (koodi == KohteidenLuoja.ANSAPIIKKI) {
            return luoAnsa("piikkiansa", 5);
        }
        if (koodi == KohteidenLuoja.ANSAKUILU) {
            return luoAnsa("kuiluansa", 10);
        }
        if (koodi == KohteidenLuoja.ANSALIEKKI) {
            return luoAnsa("helvetilliseen liekkiansa", 10);
        }
        if(koodi == KohteidenLuoja.ANSATHEEND) {
            return luoAnsa("pelin viimeiseen ansa", 1000);
        }

        //portaat
        if (koodi == KohteidenLuoja.PORTAAT) {
            return luoPortaat();
        }

        return null;
    }

    private static Kohde luoOvi(YleisEsine avaaja, String ovenNimi) {
        Ovi ovi;
        if (avaaja == null) {
            ovi = new Ovi(false, avaaja, ovenNimi);
        } else {
            ovi = new Ovi(true, avaaja, ovenNimi);
        }

        OvenAvaus ovenAvaus = new OvenAvaus(ovi);
        ovi.setTapahtuma(ovenAvaus);
        return ovi;
    }

    private static Kohde luoSeina() {
        Seina ss = new Seina();
        return ss;
    }

    private static Kohde luoAarre(ArrayList<Esine> laitettavatAarteet, String aarteenNimi) {
        Aarre aa = new Aarre(aarteenNimi);
        AarteenLoytaminen loyto = new AarteenLoytaminen(aa);
        aa.setTapahtuma(loyto);
        for (Esine esine : laitettavatAarteet) {
            aa.lisaaAarre(esine);
        }

        return aa;
    }

    private static Kohde luoAnsa(String ansanNimi, int ansanTekemaVahinko) {
        Ansa ansa = new Ansa(ansanNimi, ansanTekemaVahinko);
        AnsaanAstuminen aa = new AnsaanAstuminen(ansa);
        ansa.setTapahtuma(aa);
        return ansa;
    }

    private static Kohde luoPortaat() {
        Portaat pp = new Portaat();
        PortaissaKulkeminen kulku = new PortaissaKulkeminen(pp);
        pp.setTapahtuma(kulku);
        return pp;
    }

}
