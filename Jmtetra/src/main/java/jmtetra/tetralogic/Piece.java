/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic;

/**
 * Tämä luokka luo Piece, eli pala-luokan ilmentyminä. Jokainen Tetronomi koostuu neljästä palasta,
 * joilla kaikilla on omat y- ja x-koordinaatit, sekä char-muuttuja.
 * @author mikko
 */
public class Piece {
    private int y;
    private int x;
    private char mark;

    /**
     * Konstruktorissa luodaan uusi halutunlainen pala.
     * Parametreina annetaan ylläkin mainitut koordinaatit ja char-muuttuja.
     * 
     * @param y haluttu y-koordinaatti.
     * @param x haluttu x-koordinaatti.
     * @param mark haluttu merkki koordinaatin sijaintiin.
     */
    public Piece(int y, int x, char mark) {
        this.y = y;
        this.x = x;
        this.mark = mark;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Tällä metodilla voidaan tarvittaessa päivittää palan char-muuttujan arvo.
     * Metodi on olennainen, kun pelilautaa päivitetään.
     * 
     * 
     * @param mark palan sijantiin asetettava uusi char muuttuja.
     */

    public void setMark(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }
    
    
    
    
    
    
}
