
package juuri.apuvalineet;

import java.util.Scanner;

public class Lukija {
    
    private Scanner lukija;
    
    public Lukija() {
        this.lukija = new Scanner(System.in);
    }
    
    public String lueString() {
        return lukija.nextLine();
    }
}
