/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;

public abstract class Tetronome {

    private Piece[] pieces;

    public Tetronome(Piece[] pieces) {
        this.pieces = pieces;
    }

    public Piece[] moveLeft() {
        Piece[] newLoc = new Piece[4];
        int i = 0;
        for (Piece p : this.pieces) {
            newLoc[i] = new Piece(p.getY(), p.getX() - 1, p.getMark());
            i++;
        }
        return newLoc;
    }

    public Piece getLowestLoc() {
        return new Piece(1, 2, '0');
    }

    public boolean checkIfReachedBottom() {
        return true;
    }

    public boolean checkIfOccupied(Gameboard g, Piece[] newLoc) {
        for (Piece p : newLoc) {
            if (samePieceInBothArrays(p)) {
                continue;
            }
            if (p.getX() > g.getWidth() || p.getX() < 0) {
                return false;
            }
            if (p.getY() >= g.getHeight()) {
                return false;
            }
            if (g.getChar(p.getY(), p.getX()) != '-') {
                return false;
            }
        }
        return true;

    }

    private boolean samePieceInBothArrays(Piece p) {
        for (Piece pi : this.pieces) {
            if (p.getX() == pi.getX() && p.getY() == pi.getY()) {
                return true;
            }
        }
        return false;
    }

    abstract void createTetronome();

    public Piece[] getPieces() {
        return this.pieces;
    }

    public void setNewPieces(Piece[] p) {
        this.pieces = p;
    }

}
