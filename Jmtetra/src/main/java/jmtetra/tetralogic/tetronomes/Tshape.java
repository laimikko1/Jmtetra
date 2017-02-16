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
 * Tshape on yksi Tetrispelin palamuodoista.
 *
 * @author mikko
 */
public class Tshape extends Tetronome {

    private Piece[] pieces;

    /**
     * Konstruktorissa luodaan uusi pala, sille annetaan parametrina Piece[]
     * taulukko, johon sen palat laitetaan. Myös yliluokan, eli Tetronomen
     * konstruktoria hyödynnetään asetettaessa tyyppi ja luotaessa yllämainittu
     * taulukko.
     *
     * @param pieces jokainen pala saa Piece[] taulukon, jossa tarvittava tila
     * koordinaateille
     
     */
    public Tshape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        super.setType(Type.Tshape);
        createTetronome();
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public final void createTetronome() {
        int yCord = 1;
        int xCord = 3;
        for (int i = 0; i < 3; i++) {
            Piece p = new Piece(yCord, xCord, 'T');
            this.pieces[i] = p;
            xCord++;
        }
        yCord--;
        xCord = 4;
        Piece p = new Piece(yCord, xCord, 'T');
        this.pieces[3] = p;

    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    Piece[] createRotations() {
        if (super.getRotation() == 1) {
            return updateUpCords();
        }
        if (super.getRotation() == 2) {
            return updateRightCords();
        }
        if (super.getRotation() == 3) {
            return updateDownCords();
        }

        return updateLeftCords();

    }

    private Piece[] updateUpCords() {
        Piece[] up = new Piece[4];
        up[0] = this.generatePiece(0, -1);
        up[1] = this.pieces[1];
        up[2] = this.generatePiece(0, 1);
        up[3] = this.generatePiece(-1, 0);
        return up;
    }

    private Piece[] updateRightCords() {
        Piece[] right = new Piece[4];
        right[0] = this.generatePiece(-1, 0);
        right[1] = this.pieces[1];
        right[2] = this.generatePiece(0, 1);
        right[3] = this.generatePiece(1, 0);
        return right;
    }

    private Piece[] updateDownCords() {
        Piece[] down = new Piece[4];
        down[0] = this.generatePiece(0, 1);
        down[1] = this.pieces[1];
        down[2] = this.generatePiece(0, -1);
        down[3] = this.generatePiece(1, 0);

        return down;
    }

    private Piece[] updateLeftCords() {
        Piece[] left = new Piece[4];
        left[0] = this.generatePiece(1, 0);
        left[1] = this.pieces[1];
        left[2] = this.generatePiece(-1, 0);
        left[3] = this.generatePiece(0, -1);
        return left;
    }

}
