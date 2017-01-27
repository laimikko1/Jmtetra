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
//
//    public Piece getLowestLoc() {
//        return new Piece(0, 0, '0'); //Not done 
//    }

//    public boolean checkIfReachedBottom() {//Not done
//        return true;
//    }
    
    
    abstract void createTetronome();

    public Piece[] getPieces() {
        return this.pieces;
    }

    public void setNewPieces(Piece[] p) {
        this.pieces = p;
    }

}
