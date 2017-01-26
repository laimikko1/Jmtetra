/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic.Tetronomes;

import tetralogic.Piece;


public abstract class Tetronome {

    private Piece[] pieces;

    public Tetronome(Piece[] pieces) {
        this.pieces = pieces;

    }

    public void moveLeft() {
        for (Piece p : this.pieces) {
            p.setY(p.getY() - 1);

        }
    }

    abstract void createTetronome();

    public Piece[] getPieces() {
        return this.pieces;
    }

}
