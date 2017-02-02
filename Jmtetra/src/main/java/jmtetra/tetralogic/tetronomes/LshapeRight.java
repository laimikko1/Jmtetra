/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.LshapeRight;

public class LshapeRight extends Tetronome {

    private Type type;
    public Piece[] pieces;

    public LshapeRight(Piece[] pieces) {
        super(pieces);
        this.type = LshapeRight;
        this.pieces = pieces;
        createTetronome();
    }

    @Override
    void createTetronome() {
        int yCord = 0;
        int xCord = 4;

        pieces[0] = new Piece(yCord, xCord, 'L');
        xCord++;

        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'L');
            yCord++;
        }
    }

    @Override
    Piece[] createRotations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
