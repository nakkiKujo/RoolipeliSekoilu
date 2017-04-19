package juuri.apuvalineet;

/**
 * Luokka ylläpitää sijaintia luolastossa. Pelaajan hahmolla ja luolaston
 * kohteilla on sijainti.
 */
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

    /**
     * Metodi muuttaa sijaintia oikealle annetun parametrin verran. Tämä siis
     * muuttaa sijainnin x-koordinaattia.
     *
     * @param maara Tämän verran muutetaan.
     */
    public void liikuOikealle(int maara) {
        this.x = x + maara;
    }

    /**
     * Metodi muuttaa sijaintia vasemmalle annetun parametrin verran. Tämä siis
     * muuttaa sijainnin x-koordinaattia.
     *
     * @param maara Tämän verran muutetaan.
     */
    public void liikuVasemmalle(int maara) {
        this.x = x - maara;
    }

    /**
     * Metodi muuttaa sijaintia ylös annetun parametrin verran. Tämä siis
     * muuttaa sijainnin y-koordinaattia.
     *
     * @param maara Tämän verran muutetaan.
     */
    public void liikuYlos(int maara) {
        this.y = y - maara;
    }

    /**
     * Metodi muuttaa sijaintia alas annetun parametrin verran. Tämä siis
     * muuttaa sijainnin y-koordinaattia.
     *
     * @param maara Tämän verran muutetaan.
     */
    public void liikuAlas(int maara) {
        this.y = y + maara;
    }

    @Override
    public boolean equals(Object o) {
        Sijainti toinen = (Sijainti) o;

        if (toinen.getX() == this.x && toinen.getY() == this.y) {
            return true;
        }

        return false;
    }
}
