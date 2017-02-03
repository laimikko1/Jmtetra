/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import java.util.ArrayList;
import jmtetra.tetralogic.Piece;

public abstract class Tetronome {

    private Piece[] pieces;
    private int rotation;

    public Tetronome(Piece[] pieces) {
        this.pieces = pieces;
        this.rotation = 1;
    }

    public Piece[] moveLeftOrRight(int direction) {

        Piece[] newLoc = new Piece[4];
        int i = 0;

        for (Piece p : this.pieces) {
            newLoc[i] = new Piece(p.getY(), p.getX() + direction, p.getMark());
            i++;
        }
        return newLoc;

    }

    public Piece[] moveDown() {

        Piece[] newLoc = new Piece[4];
        int i = 0;

        for (Piece p : this.pieces) {
            newLoc[i] = new Piece(p.getY() + 1, p.getX(), p.getMark());
            i++;
        }

        return newLoc;
    }

    public Piece[] moveClockOrCounterClockWise(int rotationDirection) {
        this.rotation += rotationDirection;

        if (this.rotation > 4) {
            this.rotation = 1;
        } else if (this.rotation < 1) {
            this.rotation = 4;
        }

        return createRotations();
    }

    abstract void createTetronome();

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

    abstract Piece[] createRotations();

    public Piece generatePiece(int y, int x) {
        return new Piece(this.pieces[1].getY() + y, this.pieces[1].getX() + x, this.pieces[1].getMark());
    }
}
