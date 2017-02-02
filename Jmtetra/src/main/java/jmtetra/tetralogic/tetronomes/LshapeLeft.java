package jmtetra.tetralogic.tetronomes;

import java.util.ArrayList;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.LshapeLeft;

public class LshapeLeft extends Tetronome {

    private Piece[] pieces;
    private Type type;

    public LshapeLeft(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = LshapeLeft;

        createTetronome();
    }

    @Override
    final void createTetronome() {
        int yCord = 0;
        int xCord = 5;
        pieces[0] = new Piece(yCord, xCord, 'L');
        yCord++;

        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'L');
            xCord--;
        }
    }

    @Override
    Piece[] createRotations() {
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
        downCords[0] = this.generatePiece(0, -1);
        downCords[1] = getPieces()[1];
        downCords[2] = this.generatePiece(1, 0);
        downCords[3] = this.generatePiece(2, 0);

        return downCords;
    }

    private Object updateLefCordinates() {
        Piece[] leftCords = new Piece[4];
        leftCords[0] = this.generatePiece(-1, 0);
        leftCords[1] = getPieces()[1];
        leftCords[2] = this.generatePiece(0, -1);
        leftCords[3] = this.generatePiece(0, -2);

        return leftCords;
    }

    private Object updateRightCordinates() {
        Piece[] rightCords = new Piece[4];
        rightCords[0] = this.generatePiece(-1, 0);
        rightCords[1] = getPieces()[1];
        rightCords[2] = this.generatePiece(0, 1);
        rightCords[3] = this.generatePiece(0, 2);

        return rightCords;
    }

    private Object updateUpCordinates() {
        Piece[] upCords = new Piece[4];
        upCords[0] = this.generatePiece(0, 1);
        upCords[1] = getPieces()[1];
        upCords[2] = this.generatePiece(-1, 0);
        upCords[3] = this.generatePiece(-2, 0);

        return upCords;
    }

}
