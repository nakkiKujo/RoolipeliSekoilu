
package juuri.sovelluslogiikka.hahmo;

import java.awt.Color;
import java.awt.Graphics;
import juuri.apuvalineet.Sijainti;

public abstract class Hahmo {
    protected String nimi;
    protected String ammatti;
    protected Sijainti sijainti;
    protected int voima;
    protected int taikaVoima;
    protected int elamaPisteet;
    protected int ketteryys;
    
    public Hahmo(String nimi) {
        this.nimi = nimi;
        this.sijainti = new Sijainti();
        sijainti.setSijainti(1, 1);
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String getAmmatti() {
        return this.ammatti;
    }
    
    public Sijainti getSijainti() {
        return this.sijainti;
    }
    
    public void piirra(Graphics g, int mittaKaava) {
        int x = this.sijainti.getX() * mittaKaava;
        int y = this.sijainti.getY() * mittaKaava;
        
        g.setColor(Color.red);
        
        g.fillOval(x, y, mittaKaava, mittaKaava);
    }
}
