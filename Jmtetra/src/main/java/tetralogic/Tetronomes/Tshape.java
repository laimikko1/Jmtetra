/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.T;

public class Tshape extends Tetronome {

    private Piece[] pieces;
    private Type type;

    public Tshape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = T;
        createTetronome();
    }

    @Override
    boolean moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean canIMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void turnClockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void turnCounterClockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void createTetronome() {
        int xCord = 6;
        int yCord = 0;

        Piece p = new Piece(xCord, yCord, 'T');
        xCord--;
        yCord++;
        this.pieces[0] = p;

        for (int i = 1; i < 4; i++) {
            p = new Piece(xCord, yCord, 'T');
            this.pieces[i] = p;
            xCord++;
        }
    }

}
