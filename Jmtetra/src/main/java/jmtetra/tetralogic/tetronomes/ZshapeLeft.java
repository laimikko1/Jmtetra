/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;

public class ZshapeLeft extends Tetronome {

 
    private Piece[] pieces;

    public ZshapeLeft(Piece[] pieces) {
        super(pieces);
        super.setType(Type.ZshapeLeft);
        this.pieces = pieces;
        createTetronome();
    }

    @Override
    public final void createTetronome() {
        int yCord = 0;
        int xCord = 3;
        for (int i = 0; i < 2; i++) {
            pieces[i] = new Piece(yCord, xCord, 'Z');
            xCord++;
        }
        xCord--;
        yCord++;

        for (int i = 2; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'Z');
            xCord++;
        }
    }

    @Override
    Piece[] createRotations() {
        if (this.getRotation() % 2 != 0) {
            return (Piece[]) horizontalCords();
        }

        return (Piece[]) verticalCords();

    }

    private Object horizontalCords() {
        Piece[] downCords = new Piece[4];
        downCords[0] = this.generatePiece(0, -1);
        downCords[1] = getPieces()[1];
        downCords[2] = this.generatePiece(1, 0);
        downCords[3] = this.generatePiece(1, 1);

        return downCords;
    }

    private Object verticalCords() {

        Piece[] leftCords = new Piece[4];
        leftCords[0] = this.generatePiece(-1, 0);
        leftCords[1] = getPieces()[1];
        leftCords[2] = this.generatePiece(0, -1);
        leftCords[3] = this.generatePiece(1, -1);

        return leftCords;
    }





}
