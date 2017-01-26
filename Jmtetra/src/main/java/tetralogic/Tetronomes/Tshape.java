/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.Tshape;

public class Tshape extends Tetronome {

    private Piece[] pieces;
    private Type type;

    public Tshape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = Tshape;
        createTetronome();
    }

    @Override
    final void createTetronome() {
        int yCord = 1;
        int xCord = 4;
        for (int i = 0; i < 3; i++) {
            Piece p = new Piece(yCord, xCord, 'T');
            this.pieces[i] = p;
            xCord++;
        }
        yCord--;
        xCord = 5;
        Piece p = new Piece(yCord, xCord, 'T');
        this.pieces[3] = p;


    }

}
