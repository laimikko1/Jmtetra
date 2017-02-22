package jmtetra.tetralogic;

import jmtetra.tetralogic.tetronomes.Tetronome;

/**
 * Tämä luokka vastaa pelilaudan luomisesta, ylläpidosta ja päivittämisestä
 * tarvittaessa.
 *
 * @author mikko
 */
public class Gameboard {

    private int height;
    private int width;
    private char[][] gameboard;
    private Tetronome tetroInPlay;

    /**
     * Konstruktorissa luodaan uusi Gameboard, suomeksi pelilauta. Pelilauta on
     * char[][], eli kaksiulotteinen taulukko, jossa on char muuttujia.
     */
    public Gameboard() {
        this.width = 10;
        this.height = 16;
        this.tetroInPlay = null;

        this.gameboard = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameboard[i][j] = '-';
            }
        }
    }

    /**
     * Metodi saa parametrinaan Tetronomin, joka lisätään pelilautaan.
     *
     * @see Tetronome.getPieces()
     * @param t saa parametrina pelilautaan lisättävän Tetronome-luokan
     * ilmentymän
     */
    public void addTetronome(Tetronome t) {
        this.tetroInPlay = t;

        for (Piece p : t.getPieces()) {
            gameboard[p.getY()][p.getX()] = p.getMark();
        }
    }

    /**
     * Metodi välittää tiedon (boolean muuttujan) siitä, onko pala osunut
     * johonkin toiseen palaan. Tämän perusteella pelilooppi osaa tehdä oikean
     * valinnan seuraavasta toiminnosta.
     *
     * @return boolean = onko kierros päättynyt
     */
    public boolean isRoundOver() {
        Piece a = tetroInPlay.getLowestLocation();
        if (a.getY() == 15) {
            return true;
        }

        Piece[] taulukko = this.getCurTetro().getPieces();
        for (Piece p : taulukko) {

            if (!samePieceInBothArrays(new Piece(p.getY() + 1, p.getX(), '-'))) {
                if (getChar(p.getY() + 1, p.getX()) != '-') {
                    return true;
                }
            }

        }

        return false;

    }

    /**
     * Tämä metodi tarkistaa onko koko peli loppunut. Käytännössä katsotaan,
     * onko pala ylimmällä rivillä, jos se osuu jo toiseen palaan (isRoundOver =
     * true)
     *
     * @return boolean = onko peli loppunut
     */
    public boolean isGameOver() {
        if (isRoundOver()) {
            for (Piece p : tetroInPlay.getPieces()) {
                if (p.getY() == 0) {
                    return true;
                }
            }

        }

        return false;
    }

    public Tetronome getCurTetro() {
        return this.tetroInPlay;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getGameboard() {
        return gameboard;
    }

    /**
     * Palauttaa halutun character-muuttujan tietystä koordinaatista taulukossa.
     *
     * @param y y-koordinaatin arvo
     * @param x x-koordinaatin arvo
     * @return character tietystä koordinaatista
     */
    public char getChar(int y, int x) {
        return this.gameboard[y][x];
    }

    /**
     * Asettaa tiettyyn taulukon kohtaan halutun character-muuttujan.
     *
     * @param y y-koordinaatin arvo
     * @param x x-koordinaatin arvo
     * @param c tiettyyn koordinaattiin asetettava character-muuttuja
     */
    public void setChar(int y, int x, char c) {
        this.gameboard[y][x] = c;
    }

    /**
     * Metodi tarkistaa kaikki täydet rivit laudasta.
     *
     * @see jmtetra.tetralogic.Gameboard#moveAllPiecesDown(int)
     * @see jmtetra.tetralogic.Gameboard#checkIfAFullRow(int)
     * @return lukumäärän täysistä riveistä
     */
    public int checkAllRowsForFullOnes() {
        int rowsDestroyed = 0;
        for (int i = 0; i < height; i++) {
            if (checkIfAFullRow(i)) {
                moveAllPiecesDown(i);
                rowsDestroyed++;
            }
        }
        return rowsDestroyed;
    }

    /**
     * Alimetodi, jota ylläoleva metodi checkAllRowsForFullOnes kutsuu.
     *
     * @param height eli tarkistettavan rivin sijainti
     * @return boolean = onko rivi täynnä
     */
    public boolean checkIfAFullRow(int height) {
        for (int i = 0; i < width; i++) {
            if (getChar(height, i) == '-') {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi tarkastaa onko uuden sijainnin koordinaateissa jo olemassa toista
     * tetronomea.
     *
     * @param newLoc koordinaatit, johon nykyistä pelissä olevaa tetronomea
     * halutaan siirtää
     * @return boolean = onko missään uuden sijainnin palassa jo toista palaa
     */
    public boolean checkIfOccupied(Piece[] newLoc) {
        for (Piece p : newLoc) {
            if (samePieceInBothArrays(p)) {
                continue;
            }
            if (p.getX() >= this.getWidth() || p.getX() < 0) {
                return false;
            }
            if (p.getY() >= this.getHeight() || p.getY() < 0) {
                return false;
            }
            if (this.getChar(p.getY(), p.getX()) != '-') {
                return false;
            }
        }
        return true;

    }

    /**
     * Tämä metodi tarkastaa onko alempana/sivulla oleva pala osa samaa
     * tetronomea kuin pelissä oleva pala Käytännössä mahdollistetaan ettei tule
     * vääriä ilmoituksia sijainnissa olevasta palasta, joka onkin vain osa
     * tetronomea, jota halutaan liikuttaa
     *
     * @param p pala, joka tarkastetaan
     * @return boolean = onko pala osa nykyistä tetronomea
     */
    private boolean samePieceInBothArrays(Piece p) {
        for (Piece pi : this.tetroInPlay.getPieces()) {
            if (p.getX() == pi.getX() && p.getY() == pi.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ehkäpä luokan tärkein metodi, joka päivittää aina lautaa vastaamaan
     * nykyistä pelitilannetta. Hyödyntää muita luokan metodeja
     *
     * @see
     * jmtetra.tetralogic.Gameboard#checkIfOccupied(jmtetra.tetralogic.Piece[])
     * @see jmtetra.tetralogic.Gameboard#setChar(int, int, char)
     * @see jmtetra.tetralogic.tetronomes.Tetronome#getPieces()
     * @see jmtetra.tetralogic.tetronomes.Tetronome#setPieces(jmtetra.tetralogic.Piece[])
     * @param newLoc uuden palan sijainnin omaava Piece[] taulukko
     */
    public void updateBoard(Piece[] newLoc) {
        if (this.checkIfOccupied(newLoc)) {
            Piece[] oldCoords = tetroInPlay.getPieces();

            for (Piece p : oldCoords) {
                setChar(p.getY(), p.getX(), '-');
            }

            for (Piece p : newLoc) {
                setChar(p.getY(), p.getX(), p.getMark());
            }

            tetroInPlay.setPieces(newLoc);

        }
    }

    /**
     * Liikuttaa kaikkia laudassa olevia paloja yhden askeleen alaspäin Tämä
     * metodi toteutetaan, jos löytyy täynnä olevia rivejä, joita tuhotaan.
     *
     * @param startingHeight aloituskorkeus, josta ylöspäin kaikkia rivejä
     * siirretään alaspäin
     */
    public void moveAllPiecesDown(int startingHeight) {

        for (int y = startingHeight; y > 0; y--) {
            for (int x = 0; x < width; x++) {
                setChar(y, x, getChar(y - 1, x));
            }
        }
    }

}
