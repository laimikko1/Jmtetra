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
    private ArrayList<Piece[]> rotations;
    private int rotation;

    public Tetronome(Piece[] pieces) {
        this.pieces = pieces;
        this.rotations = new ArrayList<>();
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
        this.createOrUpdateRotations();
        
        this.rotation += rotationDirection;
        if (this.rotation == this.rotations.size()) {
            this.rotation = 0;
        } else if (this.rotation < 0) {
            this.rotation = this.rotations.size() - 1;
        }
        return this.rotations.get(rotation);
    }

    abstract void createTetronome();

    public Piece[] getPieces() {
        return this.pieces;
    }

    public void setPieces(Piece[] p) {
       this.pieces = p;
    }

    public ArrayList getRotations() {
        return this.rotations;
    }

    abstract void createOrUpdateRotations();

}
