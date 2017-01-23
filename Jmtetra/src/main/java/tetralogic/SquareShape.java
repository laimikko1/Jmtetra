/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic;

import static tetralogic.Type.Square;

public final class SquareShape extends Tetronome {

    private Type type;
    private Piece[] pieces;

    public SquareShape(Type type, Piece[] pieces) {
        super(Square, pieces);
        createTetronome();
    }

    @Override
    void turnRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void turnLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void createTetronome() {
        int xKoord = 5;
        int Ykoord = 0;
        for (int i = 0; i < 10; i++) {
            this.pieces[i].setX(xKoord);
            this.pieces[i].setY(Ykoord);
            this.pieces[i].setMark('O');

            xKoord++;
            if (i == 2) {
                Ykoord++;
                xKoord = 5;
            }
        }

    }
}
