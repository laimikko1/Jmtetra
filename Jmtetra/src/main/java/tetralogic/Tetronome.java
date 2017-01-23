/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic;

import java.util.List;

public abstract class Tetronome {

    private Type type;
    private Piece[] pieces;

    public Tetronome(Type type, Piece[] pieces) {
        this.pieces = new Piece[4];
        this.type = type;

    }

    abstract void turnRight();

    abstract void turnLeft();

    abstract void createTetronome();

    public void moveDown() {

    }
    
    public boolean canIMove() {
        return false;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public Type getType() {
        return type;
    }

}
