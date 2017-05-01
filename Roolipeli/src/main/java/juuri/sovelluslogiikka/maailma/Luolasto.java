package juuri.sovelluslogiikka.maailma;

import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;
import juuri.sovelluslogiikka.hahmo.Hahmo;
import juuri.sovelluslogiikka.peli.HirvionLuoja;
import juuri.sovelluslogiikka.peli.KohteidenLuoja;

/**
 * Tämä luokka kuvastaa pelin maailmaa, jossa pelaajan hahmo seikkailee.
 * Luolaston rakennetta ylläpidetään taulukossa, joka sisältää erilaisia
 * kohteita. Luokalla on metodit kohteiden lisäämistä ja poistamista varten.
 *
 * Luolasto koostuu useammasta eri kerroksesta, joissa aina syvemmälle mentäessä
 * peli vaikeutuu.
 */
public class Luolasto {

    private Kohde[][] koordinaatisto;
    private int nykyinenTaso;
    private int leveys;
    private int korkeus;

    /**
     * Luodaan luolasto ja sen koordinaatisto.
     */
    public Luolasto() {
        this.koordinaatisto = null;
        this.nykyinenTaso = 0;
    }

    public int getNykyinenTaso() {
        return nykyinenTaso;
    }

    /**
     * Metodi tarkastaa, missä tasossa luolasto on nyt ja luo sitä seuraavan
     * tason. Mitä syvemmälle luolassa edetään, sitä vaikeammaksi pelaaminen
     * muuttuu. Siis seuraava taso on aina edeltävää haastavampi.
     */
    public void luoSeuraavaTaso() {
        if (nykyinenTaso == 0) {
            luoTaso1();
        } else if (nykyinenTaso == 1) {
            luoTaso2();
        } else if (nykyinenTaso == 2) {
            luoTaso3();
        }
    }

    private void luoTaso1() {
        nykyinenTaso = 1;
        this.leveys = 13;
        this.korkeus = 11;

        this.koordinaatisto = new Kohde[leveys][korkeus];

        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            asetaSeina(i, 0, KohteidenLuoja.SEINA);
            asetaSeina(i, korkeus - 1, KohteidenLuoja.SEINA);
        }
        for (int i = 1; i < korkeus - 1; i++) {
            asetaSeina(0, i, KohteidenLuoja.SEINA);
            asetaSeina(leveys - 1, i, KohteidenLuoja.SEINA);
        }

        //asetetaan seinät luolan sisälle
        asetaSeina(2, 2, KohteidenLuoja.SEINA);
        asetaSeina(2, 3, KohteidenLuoja.SEINA);
        asetaSeina(2, 4, KohteidenLuoja.SEINA);
        asetaSeina(2, 6, KohteidenLuoja.SEINA);
        asetaSeina(2, 7, KohteidenLuoja.SEINA);
        asetaSeina(2, 8, KohteidenLuoja.SEINA);
        asetaSeina(3, 2, KohteidenLuoja.SEINA);
        asetaSeina(3, 6, KohteidenLuoja.SEINA);
        asetaSeina(3, 8, KohteidenLuoja.SEINA);
        asetaSeina(4, 2, KohteidenLuoja.SEINA);
        asetaSeina(4, 3, KohteidenLuoja.SEINA);
        asetaSeina(4, 4, KohteidenLuoja.SEINA);
        asetaSeina(4, 6, KohteidenLuoja.SEINA);
        asetaSeina(4, 8, KohteidenLuoja.SEINA);
        asetaSeina(5, 2, KohteidenLuoja.SEINA);
        asetaSeina(5, 8, KohteidenLuoja.SEINA);
        asetaSeina(6, 2, KohteidenLuoja.SEINA);
        asetaSeina(6, 4, KohteidenLuoja.SEINA);
        asetaSeina(6, 6, KohteidenLuoja.SEINA);
        asetaSeina(6, 8, KohteidenLuoja.SEINA);
        asetaSeina(7, 2, KohteidenLuoja.SEINA);
        asetaSeina(7, 4, KohteidenLuoja.SEINA);
        asetaSeina(7, 6, KohteidenLuoja.SEINA);
        asetaSeina(7, 8, KohteidenLuoja.SEINA);
        asetaSeina(7, 9, KohteidenLuoja.SEINA);
        asetaSeina(8, 2, KohteidenLuoja.SEINA);
        asetaSeina(8, 4, KohteidenLuoja.SEINA);
        asetaSeina(8, 6, KohteidenLuoja.SEINA);
        asetaSeina(8, 8, KohteidenLuoja.SEINA);
        asetaSeina(8, 9, KohteidenLuoja.SEINA);
        for (int i = 2; i < 10; i++) {
            asetaSeina(9, i, KohteidenLuoja.SEINA);
        }
        for (int i = 1; i < 10; i++) {
            asetaSeina(11, i, KohteidenLuoja.SEINA);
        }

        //asetetaan käytävät
        for (int i = 1; i < 10; i++) {
            asetaKaytava(1, i);
        }
        for (int i = 2; i < 11; i++) {
            asetaKaytava(i, 1);
        }
        for (int i = 5; i < 9; i++) {
            asetaKaytava(i, 3);
        }
        asetaKaytava(2, 5);
        asetaKaytava(4, 5);
        asetaKaytava(5, 5);
        asetaKaytava(7, 5);
        for (int i = 3; i < 9; i++) {
            asetaKaytava(i, 7);
        }
        asetaKaytava(2, 9);
        asetaKaytava(3, 9);
        asetaKaytava(5, 9);
        asetaKaytava(10, 3);
        asetaKaytava(10, 4);
        asetaKaytava(10, 6);
        asetaKaytava(10, 7);
        asetaKaytava(10, 8);

        //asetetaan hirviöt
        asetaHirvio(3, 5, HirvionLuoja.NOITA);
        asetaHirvio(4, 9, HirvionLuoja.SUURIROTTAPRONSSIAVAIN);
        asetaHirvio(10, 5, HirvionLuoja.NOKKELANOITA);

        //asetetaan aarteet
        asetaAarre(3, 3, KohteidenLuoja.AARREJOSSAMIEKKA1);
        asetaAarre(8, 7, KohteidenLuoja.AARREJOSSARIIMUJATAIKASAUVA);
        asetaAarre(6, 9, KohteidenLuoja.AARREJOSSAHOPEAAVAIN);
        asetaAarre(8, 5, KohteidenLuoja.AARRE2VOIDETTA);
        asetaAarre(8, 3, KohteidenLuoja.AARREKYPARA1);

        //asetetaan ansa
        asetaAnsa(6, 5, KohteidenLuoja.ANSANUOLI);

        //portaat
        asetaPortaat(10, 9, KohteidenLuoja.PORTAAT);

        //ovet
        asetaLukittuOvi(10, 2, KohteidenLuoja.OVIHOPEAAVAAJA);
        asetaLukittuOvi(3, 4, KohteidenLuoja.OVIPRONSSIAVAAJA);
        asetaAvoinOvi(5, 4);
        asetaAvoinOvi(5, 6);
    }

    private void luoTaso2() {
        nykyinenTaso = 2;
        this.leveys = 16;
        this.korkeus = 11;

        this.koordinaatisto = new Kohde[leveys][korkeus];

        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            asetaSeina(i, 0, KohteidenLuoja.SEINA);
            asetaSeina(i, korkeus - 1, KohteidenLuoja.SEINA);
        }
        for (int i = 1; i < korkeus - 1; i++) {
            asetaSeina(0, i, KohteidenLuoja.SEINA);
            asetaSeina(leveys - 1, i, KohteidenLuoja.SEINA);
        }

        //asetetaan seinät luolan sisälle
        asetaSeina(6, 1, KohteidenLuoja.SEINA);
        asetaSeina(6, 2, KohteidenLuoja.SEINA);
        asetaSeina(5, 2, KohteidenLuoja.SEINA);
        asetaSeina(5, 3, KohteidenLuoja.SEINA);
        asetaSeina(4, 3, KohteidenLuoja.SEINA);
        asetaSeina(3, 3, KohteidenLuoja.SEINA);
        asetaSeina(1, 3, KohteidenLuoja.SEINA);
        asetaSeina(2, 5, KohteidenLuoja.SEINA);
        asetaSeina(3, 5, KohteidenLuoja.SEINA);
        asetaSeina(4, 5, KohteidenLuoja.SEINA);
        asetaSeina(5, 5, KohteidenLuoja.SEINA);
        asetaSeina(5, 6, KohteidenLuoja.SEINA);
        asetaSeina(6, 6, KohteidenLuoja.SEINA);
        asetaSeina(6, 7, KohteidenLuoja.SEINA);
        asetaSeina(6, 8, KohteidenLuoja.SEINA);
        asetaSeina(6, 9, KohteidenLuoja.SEINA);
        asetaSeina(8, 1, KohteidenLuoja.SEINA);
        asetaSeina(8, 2, KohteidenLuoja.SEINA);
        asetaSeina(9, 1, KohteidenLuoja.SEINA);
        asetaSeina(9, 2, KohteidenLuoja.SEINA);
        asetaSeina(9, 3, KohteidenLuoja.SEINA);
        asetaSeina(11, 3, KohteidenLuoja.SEINA);
        asetaSeina(11, 4, KohteidenLuoja.SEINA);
        asetaSeina(11, 5, KohteidenLuoja.SEINA);
        asetaSeina(11, 6, KohteidenLuoja.SEINA);
        asetaSeina(12, 5, KohteidenLuoja.SEINA);
        asetaSeina(13, 5, KohteidenLuoja.SEINA);
        asetaSeina(14, 5, KohteidenLuoja.SEINA);
        asetaSeina(9, 5, KohteidenLuoja.SEINA);
        asetaSeina(9, 6, KohteidenLuoja.SEINA);
        asetaSeina(8, 6, KohteidenLuoja.SEINA);
        asetaSeina(8, 7, KohteidenLuoja.SEINA);
        asetaSeina(8, 8, KohteidenLuoja.SEINA);
        asetaSeina(9, 8, KohteidenLuoja.SEINA);
        asetaSeina(10, 8, KohteidenLuoja.SEINA);
        asetaSeina(11, 8, KohteidenLuoja.SEINA);
        asetaSeina(11, 9, KohteidenLuoja.SEINA);
        asetaSeina(14, 9, KohteidenLuoja.SEINA);
        asetaSeina(13, 9, KohteidenLuoja.SEINA);
        asetaSeina(2, 7, KohteidenLuoja.SEINA);
        asetaSeina(3, 7, KohteidenLuoja.SEINA);
        asetaSeina(3, 8, KohteidenLuoja.SEINA);
        asetaSeina(2, 8, KohteidenLuoja.SEINA);
        asetaSeina(3, 9, KohteidenLuoja.SEINA);

        //asetetaan ovet
        asetaLukittuOvi(7, 1, KohteidenLuoja.OVIKULTAAVAAJA);
        asetaAvoinOvi(10, 3);
        asetaAvoinOvi(10, 5);
        asetaLukittuOvi(7, 6, KohteidenLuoja.OVIPRONSSIAVAAJA);
        asetaLukittuOvi(1, 5, KohteidenLuoja.OVIHOPEAAVAAJA);

        //asetetaan hirviöt
        asetaHirvio(3, 4, HirvionLuoja.LUURANKO);
        asetaHirvio(4, 1, HirvionLuoja.VALKOKASVO);
        asetaHirvio(1, 8, HirvionLuoja.NOITA);
        asetaHirvio(4, 9, HirvionLuoja.SYNKKAKULTAVAIN);
        asetaHirvio(7, 9, HirvionLuoja.MONJAOTUS);
        asetaHirvio(13, 3, HirvionLuoja.SUURIROTTA);
        asetaHirvio(11, 7, HirvionLuoja.VALKOKASVO);
        asetaHirvio(13, 8, HirvionLuoja.SYNKKAHOPEAAVAIN);

        //asetetaan aarteet
        asetaAarre(5, 1, KohteidenLuoja.AARREKAAPUTAIHAARNISKA);
        asetaAarre(1, 1, KohteidenLuoja.AARRE2VOIDETTA);
        asetaAarre(4, 6, KohteidenLuoja.AARRE1VOIDE1RIIMU);
        asetaAarre(2, 9, KohteidenLuoja.AARREKYPARA2);
        asetaAarre(14, 1, KohteidenLuoja.AARREJOSSAPRONSSIAVAIN);
        asetaAarre(14, 8, KohteidenLuoja.AARREJOSSAMIEKKA2);
        asetaAarre(10, 9, KohteidenLuoja.AARREJOSSARIIMUJAJAMEDALJONKI);
        asetaAarre(12, 9, KohteidenLuoja.AARRE2VOIDETTA);

        //portaat
        asetaPortaat(7, 0, KohteidenLuoja.PORTAAT);

        //ansat
        asetaAnsa(1, 2, KohteidenLuoja.ANSAPIIKKI);
        asetaAnsa(13, 1, KohteidenLuoja.ANSAPIIKKI);
        asetaAnsa(13, 2, KohteidenLuoja.ANSAPIIKKI);
        asetaAnsa(11, 2, KohteidenLuoja.ANSANUOLI);
        asetaAnsa(12, 4, KohteidenLuoja.ANSAPIIKKI);
        asetaAnsa(13, 7, KohteidenLuoja.ANSANUOLI);
        asetaAnsa(14, 7, KohteidenLuoja.ANSANUOLI);
        asetaAnsa(3, 2, KohteidenLuoja.ANSAKUILU);

        //käytävät
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                asetaKaytava(i, j);
            }
        }
        asetaKaytava(9, 4);
        asetaKaytava(10, 4);
        asetaKaytava(10, 2);
        asetaKaytava(10, 1);
        asetaKaytava(11, 1);
        asetaKaytava(12, 1);
        asetaKaytava(12, 2);
        asetaKaytava(12, 3);
        asetaKaytava(13, 4);
        asetaKaytava(14, 4);
        asetaKaytava(14, 3);
        asetaKaytava(14, 2);
        asetaKaytava(7, 2);
        asetaKaytava(5, 4);
        asetaKaytava(4, 4);
        asetaKaytava(2, 4);
        asetaKaytava(1, 4);
        asetaKaytava(2, 3);
        asetaKaytava(2, 2);
        asetaKaytava(2, 1);
        asetaKaytava(3, 1);
        asetaKaytava(4, 2);
        asetaKaytava(1, 6);
        asetaKaytava(2, 6);
        asetaKaytava(3, 6);
        asetaKaytava(4, 7);
        asetaKaytava(5, 7);
        asetaKaytava(1, 7);
        asetaKaytava(1, 9);
        asetaKaytava(4, 8);
        asetaKaytava(5, 8);
        asetaKaytava(5, 9);
        asetaKaytava(7, 7);
        asetaKaytava(7, 8);
        asetaKaytava(8, 9);
        asetaKaytava(9, 9);
        asetaKaytava(10, 6);
        asetaKaytava(10, 7);
        asetaKaytava(9, 7);
        asetaKaytava(12, 6);
        asetaKaytava(13, 6);
        asetaKaytava(14, 6);
        asetaKaytava(12, 7);
        asetaKaytava(12, 8);
    }

    private void luoTaso3() {
        nykyinenTaso = 3;
        this.leveys = 16;
        this.korkeus = 11;

        this.koordinaatisto = new Kohde[leveys][korkeus];

        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            asetaSeina(i, 0, KohteidenLuoja.SEINA);
            asetaSeina(i, korkeus - 1, KohteidenLuoja.SEINA);
        }
        for (int i = 1; i < korkeus - 1; i++) {
            asetaSeina(0, i, KohteidenLuoja.SEINA);
            asetaSeina(leveys - 1, i, KohteidenLuoja.SEINA);
        }
        
        //asetetaan seinät luolan sisälle
        asetaSeina(2, 2, KohteidenLuoja.SEINA);
        asetaSeina(3, 2, KohteidenLuoja.SEINA);
        asetaSeina(4, 2, KohteidenLuoja.SEINA);
        asetaSeina(5, 2, KohteidenLuoja.SEINA);
        asetaSeina(5, 3, KohteidenLuoja.SEINA);
        asetaSeina(6, 3, KohteidenLuoja.SEINA);
        asetaSeina(2, 3, KohteidenLuoja.SEINA);
        asetaSeina(2, 4, KohteidenLuoja.SEINA);
        asetaSeina(1, 4, KohteidenLuoja.SEINA);
        asetaSeina(8, 3, KohteidenLuoja.SEINA);
        asetaSeina(9, 3, KohteidenLuoja.SEINA);
        asetaSeina(9, 2, KohteidenLuoja.SEINA);
        asetaSeina(10, 2, KohteidenLuoja.SEINA);
        asetaSeina(11, 2, KohteidenLuoja.SEINA);
        asetaSeina(12, 2, KohteidenLuoja.SEINA);
        asetaSeina(13, 2, KohteidenLuoja.SEINA);
        asetaSeina(13, 3, KohteidenLuoja.SEINA);
        asetaSeina(13, 4, KohteidenLuoja.SEINA);
        asetaSeina(14, 4, KohteidenLuoja.SEINA);
        asetaSeina(6, 5, KohteidenLuoja.SEINA);
        asetaSeina(5, 5, KohteidenLuoja.SEINA);
        asetaSeina(4, 5, KohteidenLuoja.SEINA);
        asetaSeina(4, 6, KohteidenLuoja.SEINA);
        asetaSeina(4, 7, KohteidenLuoja.SEINA);
        asetaSeina(4, 8, KohteidenLuoja.SEINA);
        asetaSeina(3, 8, KohteidenLuoja.SEINA);
        asetaSeina(2, 8, KohteidenLuoja.SEINA);
        asetaSeina(1, 8, KohteidenLuoja.SEINA);
        asetaSeina(8, 5, KohteidenLuoja.SEINA);
        asetaSeina(9, 5, KohteidenLuoja.SEINA);
        asetaSeina(10, 5, KohteidenLuoja.SEINA);
        asetaSeina(11, 5, KohteidenLuoja.SEINA);
        asetaSeina(11, 6, KohteidenLuoja.SEINA);
        asetaSeina(11, 7, KohteidenLuoja.SEINA);
        asetaSeina(11, 8, KohteidenLuoja.SEINA);
        asetaSeina(12, 8, KohteidenLuoja.SEINA);
        asetaSeina(13, 8, KohteidenLuoja.SEINA);
        asetaSeina(13, 9, KohteidenLuoja.SEINA);
        asetaSeina(13, 6, KohteidenLuoja.SEINA);
        asetaSeina(14, 6, KohteidenLuoja.SEINA);
        asetaSeina(8, 7, KohteidenLuoja.SEINA);
        asetaSeina(8, 8, KohteidenLuoja.SEINA);
        asetaSeina(8, 9, KohteidenLuoja.SEINA);
        asetaSeina(6, 7, KohteidenLuoja.SEINA);
        asetaSeina(6, 8, KohteidenLuoja.SEINA);
        asetaSeina(6, 9, KohteidenLuoja.SEINA);
        
        //asetetaan käytävät
        asetaKaytava(1, 2);
        asetaKaytava(2, 1);
        asetaKaytava(4, 1);
        asetaKaytava(5, 1);
        asetaKaytava(6, 1);
        asetaKaytava(6, 2);
        asetaKaytava(7, 2);
        asetaKaytava(7, 1);
        asetaKaytava(8, 2);
        asetaKaytava(8, 1);
        asetaKaytava(9, 1);
        asetaKaytava(10, 1);
        asetaKaytava(11, 1);
        asetaKaytava(12, 1);
        asetaKaytava(13, 1);
        asetaKaytava(14, 2);
        asetaKaytava(4, 4);
        asetaKaytava(5, 4);
        asetaKaytava(6, 4);
        asetaKaytava(7, 4);
        asetaKaytava(8, 4);
        asetaKaytava(9, 4);
        asetaKaytava(3, 4);
        asetaKaytava(3, 3);
        asetaKaytava(3, 5);
        asetaKaytava(1, 5);
        asetaKaytava(2, 6);
        asetaKaytava(10, 3);
        asetaKaytava(11, 3);
        asetaKaytava(11, 4);
        asetaKaytava(12, 4);
        asetaKaytava(12, 5);
        asetaKaytava(12, 6);
        asetaKaytava(13, 7);
        asetaKaytava(14, 8);
        asetaKaytava(6, 6);
        asetaKaytava(7, 6);
        asetaKaytava(8, 6);
        asetaKaytava(9, 6);
        asetaKaytava(9, 7);
        asetaKaytava(9, 8);
        asetaKaytava(9, 9);
        asetaKaytava(10, 9);
        asetaKaytava(5, 7);
        asetaKaytava(5, 9);
        asetaKaytava(2, 9);
        
        //asetetaan ovet
        asetaLukittuOvi(7, 3, KohteidenLuoja.OVIPRONSSIAVAAJA);
        asetaLukittuOvi(13, 5, KohteidenLuoja.OVIPRONSSIAVAAJA);
        asetaLukittuOvi(7, 5, KohteidenLuoja.OVIHOPEAAVAAJA);
        asetaLukittuOvi(7, 7, KohteidenLuoja.OVIKULTAAVAAJA);
        
        //asetetaan ansat
        asetaAnsa(3, 6, KohteidenLuoja.ANSALIEKKI);
        asetaAnsa(1, 6, KohteidenLuoja.ANSALIEKKI);
        asetaAnsa(5, 6, KohteidenLuoja.ANSALIEKKI);
        asetaAnsa(5, 8, KohteidenLuoja.ANSALIEKKI);
        asetaAnsa(4, 9, KohteidenLuoja.ANSALIEKKI);
        asetaAnsa(3, 9, KohteidenLuoja.ANSALIEKKI);
        asetaAnsa(7, 8, KohteidenLuoja.ANSATHEEND);
        
        //asetetaan hirviöt
        asetaHirvio(3, 1, HirvionLuoja.NOKKELANOITA);
        asetaHirvio(1, 1, HirvionLuoja.SYNKKA);
        asetaHirvio(10, 4, HirvionLuoja.LUURANKO);
        asetaHirvio(14, 1, HirvionLuoja.EPAKUOLLUTVELHO);
        asetaHirvio(12, 7, HirvionLuoja.EPAKUOLLUTVELHO);
        asetaHirvio(14, 7, HirvionLuoja.EPAKUOLLUTVELHO);
        asetaHirvio(2, 5, HirvionLuoja.EPAKUOLLUTJATTILAINEN);
        asetaHirvio(2, 7, HirvionLuoja.EPAKUOLLUTJATTILAINEN);
        asetaHirvio(14, 9, HirvionLuoja.EPAKUOLLUTJATTIPRONSSIAVAIN);
        asetaHirvio(1, 9, HirvionLuoja.PIRU);
        asetaHirvio(11, 9, HirvionLuoja.LANGENNUTENKELI);
        
        //asetetaan aarteet
        asetaAarre(14, 3, KohteidenLuoja.AARREJOSSAPRONSSIAVAIN);
        asetaAarre(4, 3, KohteidenLuoja.AARRE1VOIDE1RIIMU);
        asetaAarre(1, 7, KohteidenLuoja.AARREJOSSAHOPEAAVAIN);
        asetaAarre(10, 6, KohteidenLuoja.AARRE1VOIDE1RIIMU);
        asetaAarre(10, 7, KohteidenLuoja.AARRE1VOIDE1RIIMU);
        asetaAarre(10, 8, KohteidenLuoja.AARRE1VOIDE1RIIMU);
        asetaAarre(1, 3, KohteidenLuoja.AARREKYPARA3);
        asetaAarre(12, 3, KohteidenLuoja.AARREMIEKKA3);
        asetaAarre(14, 5, KohteidenLuoja.AARREJUMALTENHAARNISKA);
        asetaAarre(12, 9, KohteidenLuoja.AARRE5VOIDETTA);
        asetaAarre(3, 7, KohteidenLuoja.AARREJUMALTENMEDALJONKI);
        asetaAarre(7, 9, KohteidenLuoja.AARRE2VOIDETTA);
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle hirviön.
     *
     * Hirviö luodaan HirvionLuoja-luokkaa käyttäen metodille parametrina
     * annetun koodin avulla.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param hirvionLuontiKoodi annettu koodi, jolla hirviö luodaan
     * @return onnistuiko hirviön asetus
     */
    public boolean asetaHirvio(int x, int y, int hirvionLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Hirvio hh = HirvionLuoja.luoHirvio(hirvionLuontiKoodi);
        hh.setSijainti(x, y);
        koordinaatisto[x][y] = hh;

        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle ansan. Parametrina
     * annettu luontikoodi annetaan KohteidenLuojalle, jolta saadaan koodin
     * mukainen ansa.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi luotavan ansan luontikoodi
     * @return onnistuiko ansan asetus
     */
    public boolean asetaAnsa(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Ansa aa = (Ansa) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        aa.setSijainti(x, y);
        koordinaatisto[x][y] = aa;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle portaat. Parametrina
     * saadaan KohteidenLuojalle annettava luontikoodi, jonka avulla portaat
     * luodaan.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi KohteidenLuojalle välitettävä koodi
     * @return onnistuiko portaiden asetus
     */
    public boolean asetaPortaat(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Portaat pp = (Portaat) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        pp.setSijainti(x, y);
        koordinaatisto[x][y] = pp;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle aarteen. Metodissa
     * annetaan parametrina koodi, joka välitetään KohteidenLuojalle. Näin
     * saadaan luotua haluttu aarre.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi luotavaa aarretta vastaava koodi, staattinen
     * muuttuja luokassa KohteidenLuoja
     * @return onnistuiko aarteen asetus
     */
    public boolean asetaAarre(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Aarre aa = (Aarre) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        aa.setSijainti(x, y);
        koordinaatisto[x][y] = aa;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle seinän. Parametrina
     * annettaa koodi, jonka avulla seinä luodaan Kohteidenluojassa.
     *
     * Koodi on oleellinen, jos halutaan esimerkiksi luoda erilaisia seiniä.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi koodi, jonka avulla seinä luodaan
     * @return onnistuiko seinän asetus
     */
    public boolean asetaSeina(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }
        Seina ss = (Seina) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        ss.setSijainti(x, y);
        koordinaatisto[x][y] = ss;
        return true;
    }

    /**
     * Asettaa luolastoon annettujen koodinaattien kohdalle käytävän.
     *
     * Jos asetus ei onnistu, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onnistuiko käytävän asetus
     */
    public boolean asetaKaytava(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Kaytava kk = new Kaytava();
        kk.setSijainti(x, y);
        koordinaatisto[x][y] = kk;
        return true;
    }

    /**
     * Asettaa luolaston koordinaateihin (x, y) lukitun oven. Metodille annetaan
     * parametrina koodi, joka välitetään KohteidenLuojalle. Sieltä saadaan
     * koodia vastaava kohde takaisin.
     *
     * Jos oven luominen ja asettaminen ei onnistu, palauttaa metodi false.
     * Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @param kohteenLuontiKoodi luotavaa ovea vastaava KohteidenLuoja-koodi
     * @return onnistuiko oven asetus
     */
    public boolean asetaLukittuOvi(int x, int y, int kohteenLuontiKoodi) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Ovi ovi = (Ovi) KohteidenLuoja.luoKohde(kohteenLuontiKoodi);
        ovi.setSijainti(x, y);
        koordinaatisto[x][y] = ovi;

        return true;
    }

    /**
     * Asettaa luolaston koordinaatteihin (x, y) avoimen oven.
     *
     * Jos ovea ei pystytä luomaan, palautetaan false. Muuten palautetaan true.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onnistuiko oven asetus
     */
    public boolean asetaAvoinOvi(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return false;
        }

        Ovi ovi = (Ovi) KohteidenLuoja.luoKohde(KohteidenLuoja.OVIAVOIN);
        ovi.setSijainti(x, y);
        koordinaatisto[x][y] = ovi;

        return true;
    }

    /**
     * Hakee luolastosta kohteen parametrein annettujen koodinaattien kohdalta.
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return löydetty kohde
     */
    public Kohde haeKoordinaateista(int x, int y) {
        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }
        return koordinaatisto[x][y];
    }

    /**
     * Metodi hakee luolastosta kohteen sille parametrina annetun sijainnin
     * osoittamasata kohdasta.
     *
     * @param ss sijainti, jonka kohdalla oleva kohde halutaan löytää
     * @return löydetty kohde
     */
    public Kohde haeSijainnista(Sijainti ss) {
        int x = ss.getX();
        int y = ss.getY();

        if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
            return null;
        }

        return koordinaatisto[x][y];
    }

    /**
     * Poistaa parametrina annetun kohteen luolastosta. Tilalle laitetaan
     * käytävä, jossa ei ole tapahtumaa.
     *
     * @param kk poistettava kohde
     */
    public void poistaKohde(Kohde kk) {
        int x = kk.getSijainti().getX();
        int y = kk.getSijainti().getY();

        asetaKaytava(x, y);
    }

    /**
     * Piirtää luolaston käyttöliittymän piirtotaululle. Metodi kutsuu
     * luolatossa olevien kohteiden piirtometodeja. Kohteita piirretään sen
     * mukaan, ovatko ne tarpeeksi lähellä pelaajan hahmoa. Jos kohde on liian
     * kaukana, ei sitä piirretä. Tämän vuoksi pelaajan hahmoa kuljetetaan
     * piirtometodissa. Lisäksi kutsuttavassa metodissa tarkistetaan, onko
     * kyseinen kohde seinän tai oven takana. Tällöin kyseistä kohdetta ei
     * piirretä.
     *
     * @param g käyttöliittyymän grafiikkaolio
     * @param mittaKaava mittakaava, jossa piirretään
     * @param pelaajanHahmo pelaajan hahmo
     */
    public void piirra(Graphics g, int mittaKaava, Hahmo pelaajanHahmo) {
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                int x = i * mittaKaava;
                int y = j * mittaKaava;
                koordinaatisto[i][j].piirra(g, mittaKaava, x, y, pelaajanHahmo, this);
            }
        }
    }
}
