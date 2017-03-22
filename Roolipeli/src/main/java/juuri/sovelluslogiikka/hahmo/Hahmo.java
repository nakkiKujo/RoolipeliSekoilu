
package juuri.sovelluslogiikka.hahmo;

public abstract class Hahmo {
    private String nimi;
    protected String ammatti;
    
    public Hahmo(String nimi) {
        this.nimi = nimi;
    }
    
    public abstract void setAmmatti(String am) ;
    //asettaa hahmolle sille kuuluvan ammatin
    
    public abstract String getAmmatti();
    //hakee hahmon ammatin muodossa "ammatti", esim velho tai soturi
}
