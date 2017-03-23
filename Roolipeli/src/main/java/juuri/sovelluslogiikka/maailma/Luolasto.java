
package juuri.sovelluslogiikka.maailma;

public class Luolasto {
    private Kohde[][] koordinaatisto;
    private int leveys;
    private int korkeus;
    
    public Luolasto(int leveys, int korkeus) {
        this.koordinaatisto = new Kohde[leveys][korkeus];
        this.leveys = leveys;
        this.korkeus = korkeus;
        asetaAlkuperainenLuolasto();
    }
    
    private void asetaAlkuperainenLuolasto() {
        
        //luolaston ulkoreuna on seinää
        for (int i = 0; i < leveys; i++) {
            koordinaatisto[i][0] = new Seina();
            koordinaatisto[i][korkeus - 1] = new Seina();
        }
        
        for (int i = 0; i < korkeus; i++) {
            koordinaatisto[0][i] = new Seina();
            koordinaatisto[leveys - 1][i] = new Seina();
        }
        
        //laitetaan aluksi kaksi ovea, nyt olettaen että luolasto on 10x10
        koordinaatisto[5][1] = new Ovi();
        koordinaatisto[5][8] = new Ovi();
        
        //loput luolaston seinät
        for (int i = 2; i < 6; i++) {
            koordinaatisto[i][2] = new Seina();
        }
        koordinaatisto[2][3] = new Seina();
        koordinaatisto[3][3] = new Seina();
        
        for (int i = 5; i < 9; i++) {
            koordinaatisto[i][3] = new Seina();
        }
        for (int i = 4; i < 8; i++) {
            koordinaatisto[5][i] = new Seina();
        }
        koordinaatisto[2][5] = new Seina();
        koordinaatisto[3][5] = new Seina();
        koordinaatisto[2][6] = new Seina();
        koordinaatisto[2][7] = new Seina();
        koordinaatisto[3][7] = new Seina();
        koordinaatisto[4][7] = new Seina();
        
        //sitten käytävät
        
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                if(koordinaatisto[i][j] == null) {
                    koordinaatisto[i][j] = new Kaytava();
                }
            }
        }
    }
    
    
}
