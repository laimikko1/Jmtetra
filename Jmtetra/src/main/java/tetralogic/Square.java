package tetralogic;

import static tetralogic.Type.Square;

public class Square extends Tetronome {

    private Type type;
    public Piece[] pieces;

    public Square(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = Square;
        createTetronome();
    }

    @Override
    public void createTetronome() {
        int xKoord = 5;
        int Ykoord = 0;
        for (int i = 0; i < 4; i++) {
            Piece p = new Piece(xKoord, Ykoord, '0');
            this.pieces[i] = p;

            xKoord++;
            if (i == 1) {
                Ykoord++;
                xKoord = 5;
            }
        }

    }

    @Override
    public void turnClockwise() {
    }

    @Override
    public void turnCounterClockwise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canIMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Piece[] getPieces() {
        return this.pieces; //To change body of generated methods, choose Tools | Templates.
    }

}
