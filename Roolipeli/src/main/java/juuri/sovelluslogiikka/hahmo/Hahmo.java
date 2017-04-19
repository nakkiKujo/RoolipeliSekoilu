package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;
import juuri.apuvalineet.Profiili;
import juuri.apuvalineet.Sijainti;

/**
 * Tämä abstrakti luokka kuvastaa pelaajan pelissä seikkailevaa hahmoa. Luokalla
 * on aliluokkina ammatit, jotka määräävät, millainen hahmo on. Esimerkiksi
 * soturi on hahmona erilainen verrattuna velhoon, ja tämä ero näkyy hahmon 
 * profiilissa.
 */
public abstract class Hahmo {
    
    public static final int SOTURI = 1;
    public static final int VELHO = 2;
    public static final int DRUIDI = 3;
    
    protected String nimi;
    protected int ammatti;
    protected Sijainti sijainti;
    protected Reppu reppu;
    protected Profiili hahmonProfiili;

    /**
     * Hahmon sijainti on pelin alussa aina (1,1). Hahmo luodaan pelaajan
     * syöttämän nimen mukaisesti.
     *
     * @param nimi Käyttäjän antama nimi hahmolle
     */
    public Hahmo(String nimi) {
        this.nimi = nimi;
        this.sijainti = new Sijainti();
        sijainti.setSijainti(1, 1);
        this.reppu = new Reppu();
        this.hahmonProfiili = new Profiili();
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getAmmatti() {
        return this.ammatti;
    }

    public Sijainti getSijainti() {
        return this.sijainti;
    }
    
    public Reppu getReppu() {
        return this.reppu;
    }
    
    public Profiili getProfiili() {
        return this.hahmonProfiili;
    }

    /**
     * Piirtää hahmon käyttöliittymän piirtoalustalle.
     *
     * @param g Piirtoalustaan liittyvä grafiikka.
     * @param mittaKaava Määrää, minkä kokoisena hahmo piirretään.
     */
    public void piirra(Graphics g, int mittaKaava) {
        int x = this.sijainti.getX() * mittaKaava;
        int y = this.sijainti.getY() * mittaKaava;

        g.setColor(Color.red);

        g.fillOval(x, y, mittaKaava, mittaKaava);
    }
}
