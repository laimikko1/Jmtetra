/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;

/**
 * Tetronome-luokka on kaikkien palojen yliluokka. Jokainen Tetrispelin pala
 * perii sen.
 *
 * @author mikko
 */
public abstract class Tetronome {

    private Piece[] pieces;
    private int rotation;
    private Type type;

    /**
     * Luo uuden Tetronomen. Määrittää ensin rotaatioksi 1, joka, riippuen
     * pelipalan muodosta, on aloitussuunta. Saa parametrinaan Piece[] tyyppisen
     * taulukon.
     *
     * @param pieces
     */
    public Tetronome(Piece[] pieces) {
        this.pieces = pieces;
        this.rotation = 1;
        this.type = null;
    }

    /**
     * Liikuttaa palaa joko oikealle tai vasemmalle, riippuen parametrista.
     *
     * @param syote käyttäjän antama suunta
     *
     * @see Gameboard.updateBoard(Piece[] pieces)
     * @return (Piece[] uusiSijainti, koordinaatit taulukkona
     */
    public Piece[] moveLeftOrRight(int direction) {

        Piece[] newLoc = new Piece[4];
        int i = 0;

        for (Piece p : this.pieces) {
            newLoc[i] = new Piece(p.getY(), p.getX() + direction, p.getMark());
            i++;
        }
        return newLoc;

    }

    /**
     * Liikuttaa palaa alaspäin pelilaudalla.
     *
     * @return Piece[] uusiSijanti, koordinaatit taulukkona
     */
    public Piece[] moveDown() {

        Piece[] newLoc = new Piece[4];
        int i = 0;

        for (Piece p : this.pieces) {
            newLoc[i] = new Piece(p.getY() + 1, p.getX(), p.getMark());
            i++;
        }

        return newLoc;
    }

    /**
     * Kääntää palaa, joko myötä tai vastasuuntaan.
     *
     * @param rotationDirection, käyttäjän antama suunta, joko -1 (vastapäivään)
     * tai 1(myötäpäivään)
     *
     * @return uudet palan koordinaatit taulukossa, Piece[]-tyyppisenä
     *
     */
    public Piece[] moveClockOrCounterClockWise(int rotationDirection) {
        this.rotation += rotationDirection;

        if (this.rotation > 4) {
            this.rotation = 1;
        } else if (this.rotation < 1) {
            this.rotation = 4;
        }

        return createRotations();
    }

    /**
     * Luo uuden palan. Tämä metodi on uniikki kaikille eri paloille. Vastaa
     * myös palan koordinaattien päivittämisestä, kun pala on pelattavana.
     */
    
    abstract public void createTetronome();

    public Piece getLowestLocation() {
        int lowestY = 0;
        Piece lowestP = null;
        for (Piece p : this.pieces) {
            if (p.getY() > lowestY) {
                lowestP = p;
                lowestY = p.getY();
            }
        }
        if (lowestP == null) {
            return new Piece(0, 0, this.pieces[0].getMark());
        }
        return lowestP;
    }

    public Piece[] getPieces() {
        return this.pieces;
    }

    public void setPieces(Piece[] p) {
        System.arraycopy(p, 0, this.pieces, 0, getPieces().length);
    }

    public int getRotation() {
        return this.rotation;
    }

    /**
     * Palauttaa uudet koordinaatit, joihin pala siirtyy kun sitä käännetään
     * myötä- tai vastapäivään. Hyödyntää kaikille palaluokille uniikkeja
     * metodeja, jotka luovat tarvittavat koordinaatit palojen kääntymisiä
     * varten.
     *
     * @return Piece[] uudetKoordinaatit
     */
    abstract Piece[] createRotations();

    public Piece generatePiece(int y, int x) {
        return new Piece(this.pieces[1].getY() + y, this.pieces[1].getX() + x, this.pieces[1].getMark());
    }

    public Type getType() {
        return this.type;

    }

    public void setType(Type type) {
        this.type = type;
    }

}
