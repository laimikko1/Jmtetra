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
    Piece[] createOrUpdateRotations() {
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
        downCords[0] = new Piece(this.pieces[1].getY(), this.pieces[1].getX() - 1, this.pieces[1].getMark());
        downCords[1] = getPieces()[1];
        downCords[2] = new Piece(this.pieces[1].getY() + 1, this.pieces[1].getX(), this.pieces[1].getMark());
        downCords[3] = new Piece(this.pieces[1].getY() + 2, this.pieces[1].getX(), this.pieces[1].getMark());

        return downCords;
    }

    private Object updateLefCordinates() {
        Piece[] leftCords = new Piece[4];
        leftCords[0] = new Piece(this.pieces[1].getY() - 1, this.pieces[1].getX(), this.pieces[1].getMark());
        leftCords[1] = getPieces()[1];
        leftCords[2] = new Piece(this.pieces[1].getY(), this.pieces[1].getX() - 1, this.pieces[1].getMark());
        leftCords[3] = new Piece(this.pieces[1].getY(), this.pieces[1].getX() - 2, this.pieces[1].getMark());

        return leftCords;
    }

    private Object updateRightCordinates() {
        Piece[] rightCords = new Piece[4];
        rightCords[0] = new Piece(this.pieces[1].getY() - 1, this.pieces[1].getX(), this.pieces[1].getMark());
        rightCords[1] = getPieces()[1];
        rightCords[2] = new Piece(this.pieces[1].getY(), this.pieces[1].getX() + 1, this.pieces[1].getMark());
        rightCords[3] = new Piece(this.pieces[1].getY(), this.pieces[1].getX() + 2, this.pieces[1].getMark());

        return rightCords;
    }

    private Object updateUpCordinates() {
        Piece[] upCords = new Piece[4];
        upCords[0] = new Piece(this.pieces[1].getY(), this.pieces[1].getX() + 1, this.pieces[1].getMark());
        upCords[1] = getPieces()[1];
        upCords[2] = new Piece(this.pieces[1].getY() - 1, this.pieces[1].getX(), this.pieces[1].getMark());
        upCords[3] = new Piece(this.pieces[1].getY() - 2, this.pieces[1].getX(), this.pieces[1].getMark());

        return upCords;
    }

}
