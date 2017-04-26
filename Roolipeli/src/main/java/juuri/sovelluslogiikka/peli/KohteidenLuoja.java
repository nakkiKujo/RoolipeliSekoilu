package juuri.sovelluslogiikka.peli;

import java.util.ArrayList;
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

    public static final int AARREJOSSAHOPEAAVAIN = 20;
    public static final int AARREJOSSAMIEKKA1 = 21;
    public static final int AARREJOSSARIIMUJATAIKASAUVA = 22;
    public static final int AARRE2VOIDETTA = 23;

    public static final int ANSAPIIKKI = 30;
    public static final int ANSANUOLI = 31;

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
        if (koodi == KohteidenLuoja.AARREJOSSARIIMUJATAIKASAUVA) {
            ArrayList<Esine> lista = new ArrayList<>();
            TaisteluEsine sauva = new TaisteluEsine("Vanha taikasauva", Esine.TAIKASAUVA);
            sauva.getProfiili().lisaaTaikaVoima(2);
            lista.add(sauva);
            lista.add(Esine.RIIMU);
            return luoAarre(lista, "taianomainen laatikko");
        }
        if (koodi == KohteidenLuoja.AARRE2VOIDETTA) {
            ArrayList<Esine> lista = new ArrayList<>();
            lista.add(Esine.PARANTAVAVOIDE);
            lista.add(Esine.PARANTAVAVOIDE);
            return luoAarre(lista, "luiden ympäröimä säkki");
        }

        //ansat
        if (koodi == KohteidenLuoja.ANSANUOLI) {
            return luoAnsa("nuoliansa", 4);
        }
        if (koodi == KohteidenLuoja.ANSAPIIKKI) {
            return luoAnsa("piikkiansa", 6);
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
