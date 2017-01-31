package jmtetra.tetralogic.tetronomes;

import java.util.ArrayList;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.Ishape;

public class Ishape extends Tetronome {

    private Type type;
    private Piece[] pieces;
    private ArrayList rotations;

    public Ishape(Piece[] pieces) {
        super(pieces);
        this.type = Ishape;
        this.pieces = pieces;
        createTetronome();
        createOrUpdateRotations();
    }

    @Override
    final void createTetronome() {
        int yCord = 0;
        int xCord = 3;

        pieces[0] = new Piece(yCord, xCord, 'I');
        xCord++;
        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'I');
            xCord++;
        }
    }

    @Override
    final void createOrUpdateRotations() {
        this.rotations = getRotations();
        this.rotations.clear();
        updateUpOrDownCords();
        this.rotations.add(getPieces());
        
    }

    private void updateUpOrDownCords() {
        Piece[] upOrDown = new Piece[4];
        upOrDown[0] = new Piece(this.pieces[1].getY() - 1, this.pieces[1].getX(), this.pieces[1].getMark());
        upOrDown[1] = this.pieces[1];
        upOrDown[2] = new Piece(this.pieces[1].getY() + 1, this.pieces[1].getX(), this.pieces[1].getMark());
        upOrDown[3] = new Piece(this.pieces[1].getY() + 2, this.pieces[1].getX(), this.pieces[1].getMark());
        
        this.rotations.add(upOrDown);
    }

}
