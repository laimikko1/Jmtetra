/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.SshapeRight;

public class SshapeRight extends Tetronome {

    private Type type;
    private Piece[] pieces;

    public SshapeRight(Piece[] pieces) {
        super(pieces);
        this.type = SshapeRight;
        this.pieces = pieces;
        createTetronome();
    }

    @Override
    final void createTetronome() {
        int yCord = 1;
        int xCord = 3;
        for (int i = 0; i < 2; i++) {
            pieces[i] = new Piece(yCord, xCord, 'S');
            xCord++;
        }
        xCord--;
        yCord--;

        for (int i = 2; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'S');
            xCord++;
        }
    }

}
