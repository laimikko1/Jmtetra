/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;

/**
 *
 * LshapeRight on yksi Tetrispelin palamuodoista.
 *
 * @author mikko
 */
public class LshapeRight extends Tetronome {

    public Piece[] pieces;

    public LshapeRight(Piece[] pieces) {
        super(pieces);
        super.setType(Type.LshapeRight);
        this.pieces = pieces;
        createTetronome();
    }

    /**
     * {@inheritDoc}
     *
     *
     */
    @Override
    public void createTetronome() {
        int yCord = 1;
        int xCord = 3;

        for (int i = 0; i < 3; i++) {
            pieces[i] = new Piece(yCord, xCord, 'L');
            xCord++;
        }

        pieces[3] = new Piece(0, 3, 'L');
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    Piece[] createRotations() {
        if (this.getRotation() == 1) {
            return (Piece[]) updateRightCordinates();
        }
        if (this.getRotation() == 2) {
            return (Piece[]) updateDownCordinates();
        }

        if (this.getRotation() == 3) {
            return (Piece[]) updateLeftCordinates();
        } else {
            return (Piece[]) updateUpCordinates();

        }
    }

    private Object updateRightCordinates() {

        Piece[] rightCords = new Piece[4];
        rightCords[0] = this.generatePiece(0, -1);
        rightCords[1] = getPieces()[1];
        rightCords[2] = this.generatePiece(0, 1);
        rightCords[3] = this.generatePiece(-1, -1);

        return rightCords;
    }

    private Object updateUpCordinates() {
        Piece[] upCords = new Piece[4];
        upCords[0] = this.generatePiece(-1, 0);
        upCords[1] = getPieces()[1];
        upCords[2] = this.generatePiece(1, 0);
        upCords[3] = this.generatePiece(1, -1);

        return upCords;
    }

    private Object updateLeftCordinates() {

        Piece[] leftCords = new Piece[4];
        leftCords[0] = this.generatePiece(0, 1);
        leftCords[1] = getPieces()[1];
        leftCords[2] = this.generatePiece(0, -1);
        leftCords[3] = this.generatePiece(1, 1);

        return leftCords;
    }

    private Object updateDownCordinates() {
        Piece[] downCords = new Piece[4];
        downCords[0] = this.generatePiece(-1, 0);
        downCords[1] = getPieces()[1];
        downCords[2] = this.generatePiece(1, 0);
        downCords[3] = this.generatePiece(-1, 1);

        return downCords;
    }

}
