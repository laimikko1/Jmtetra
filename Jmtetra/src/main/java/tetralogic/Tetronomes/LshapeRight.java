/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.LshapeRight;

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
        int xCord = 4;
        int yCord = 0;

        pieces[0] = new Piece(xCord, yCord, 'L');
        yCord++;

        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(xCord, yCord, 'L');
            xCord++;
        }
    }

}
