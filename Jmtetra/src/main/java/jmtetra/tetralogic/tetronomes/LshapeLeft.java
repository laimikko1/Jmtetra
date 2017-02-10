package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;

/**
 *
 * LshapeLeft on yksi Tetrispelin palamuodoista.
 *
 * @author mikko
 */
public class LshapeLeft extends Tetronome {

    private Piece[] pieces;

    /**
     * {@inheritDoc}
     *
     */
    public LshapeLeft(Piece[] pieces) {
        super(pieces);
        super.setType(Type.LshapeLeft);
        this.pieces = pieces;
        createTetronome();
        createRotations();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void createTetronome() {
        int yCord = 1;
        int xCord = 5;

        for (int i = 0; i < 3; i++) {
            pieces[i] = new Piece(yCord, xCord, 'K');
            xCord--;
        }
        pieces[3] = new Piece(0, 5, 'K');
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    final Piece[] createRotations() {

        if (this.getRotation() == 1) {
            return (Piece[]) updateLefCordinates();
        }
        if (this.getRotation() == 2) {
            return (Piece[]) updateUpCordinates();
        }

        if (this.getRotation() == 3) {
            return (Piece[]) updateRightCordinates();
        } else {
            return (Piece[]) updateDownCordinates();

        }
    }

    private Object updateDownCordinates() {
        Piece[] downCords = new Piece[4];
        downCords[0] = this.generatePiece(-1, 0);
        downCords[1] = getPieces()[1];
        downCords[2] = this.generatePiece(1, 0);
        downCords[3] = this.generatePiece(-1, -1);

        return downCords;
    }

    private Object updateLefCordinates() {

        Piece[] leftCords = new Piece[4];
        leftCords[0] = this.generatePiece(0, 1);
        leftCords[1] = getPieces()[1];
        leftCords[2] = this.generatePiece(0, -1);
        leftCords[3] = this.generatePiece(-1, 1);

        return leftCords;
    }

    private Object updateRightCordinates() {

        Piece[] rightCords = new Piece[4];
        rightCords[0] = this.generatePiece(0, -1);
        rightCords[1] = getPieces()[1];
        rightCords[2] = this.generatePiece(0, 1);
        rightCords[3] = this.generatePiece(1, -1);

        return rightCords;
    }

    private Object updateUpCordinates() {
        Piece[] upCords = new Piece[4];
        upCords[0] = this.generatePiece(-1, 0);
        upCords[1] = getPieces()[1];
        upCords[2] = this.generatePiece(1, 0);
        upCords[3] = this.generatePiece(1, 1);

        return upCords;
    }

}
