package juuri.sovelluslogiikka.esineet;

/**
 * Esineet ovat tavaroita, joita pelaaja löytää luolassa seikkaillessaan.
 * Esineitä voi löytyä hirviöiltä tai aarteista. Ne säilötään pelaajan reppuun.
 */
public abstract class Esine {

    protected int koodi;
    protected String nimi;
    protected boolean onkoTaisteluEsine;

    public static final int AVAIN = 1;
    public static final int MIEKKA = 2;
    public static final int KYPARA = 3;
    public static final int MEDALJONKI = 4;
    public static final int TORSO = 5;
    
    public static final YleisEsine RIIMU = new YleisEsine("Riimu", 201);
    public static final YleisEsine PARANTAVAVOIDE = new YleisEsine("Parantava voide", 200);
    
    public static final YleisEsine PRONSSIAVAIN = new YleisEsine("Pronssiavain", Esine.AVAIN);
    public static final YleisEsine HOPEAAVAIN = new YleisEsine("Hopea-avain", Esine.AVAIN);
    public static final YleisEsine KULTAAVAIN = new YleisEsine("Kulta-avain", Esine.AVAIN);
    
    /**
     * Esineen konstruktori. Parametrina annetaan esineen nimi ja sen koodi.
     * @param nimi esineen nimi
     * @param koodi esineen koodi, staattinen muuttuja luokassa Esine
     */
    public Esine(String nimi, int koodi) {
        this.nimi = nimi;
        this.koodi = koodi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getKoodi() {
        return this.koodi;
    }

    @Override
    public boolean equals(Object o) {
        Esine ee = (Esine) o;

        if (ee.getNimi().equals(this.nimi) && ee.getKoodi() == this.koodi) {
            return true;
        }

        return false;
    }
}
