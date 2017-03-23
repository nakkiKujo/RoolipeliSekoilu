
package juuri.apuvalineet;

public class Sijainti {
    private int x;
    private int y;
    
    public Sijainti() {
        this.x = 0;
        this.y = 0;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setSijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void liikuOikealle(int maara) {
        this.x += maara;
    }
    
    public void liikuVasemmalle(int maara) {
        this.x =- maara;
    }
    
    public void liikuYlos(int maara) {
        this.y =+ maara;
    }
    
    public void liikuAlas(int maara) {
        this.y =- maara;
    }
    
    @Override
    public boolean equals(Object o) {
        Sijainti toinen = (Sijainti) o;
        
        if(toinen.getX() == this.x && toinen.getY() == this.y) {
            return true;
        }
        
        return false;
    }
}
