package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.Ishape;

public class Ishape extends Tetronome {

    private Type type;
    private Piece[] pieces;

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
    final Piece[] createOrUpdateRotations() {

        if (super.getRotation() == 1) {
            return updateRightCords();
        }
        if (super.getRotation() == 2) {
            return updateDownCords();
        }
        if (super.getRotation() == 3) {
            return updateLeftCords();
        }

        return updateUpCords();

    }

    private Piece[] updateDownCords() {
        Piece[] down = new Piece[4];
        down[0] = this.generatePiece(-1, 0);
        down[1] = this.pieces[1];
        down[2] = this.generatePiece(1, 0);
        down[3] = this.generatePiece(2, 0);

        return down;
    }

    private Piece[] updateLeftCords() {
        Piece[] left = new Piece[4];
        left[0] = this.generatePiece(0, 1);
        left[1] = this.pieces[1];
        left[2] = this.generatePiece(0, -1);
        left[3] = this.generatePiece(0, -2);
        return left;
    }

    private Piece[] updateRightCords() {
        Piece[] right = new Piece[4];
        right[0] = this.generatePiece(0, -1);
        right[1] = this.pieces[1];
        right[2] = this.generatePiece(0, 1);
        right[3] = this.generatePiece(0, 2);
        return right;
    }

    private Piece[] updateUpCords() {
        Piece[] up = new Piece[4];
        up[0] = this.generatePiece(+1, 0);
        up[1] = this.pieces[1];
        up[2] = this.generatePiece(-1, 0);
        up[3] = this.generatePiece(-2, 0);
        return up;
    }

}
