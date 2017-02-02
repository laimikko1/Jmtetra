package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.Squareshape;

public class SquareShape extends Tetronome {

    private Type type;
    public Piece[] pieces;

    public SquareShape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = Squareshape;
        createTetronome();
    }

    @Override
    public final void createTetronome() {
        int yCord = 0;
        int xCord = 4;
        for (int i = 0; i < 4; i++) {
            Piece p = new Piece(yCord, xCord, '0');
            this.pieces[i] = p;

            xCord++;
            if (i == 1) {
                yCord++;
                xCord = 4;
            }
        }

    }

    @Override
    Piece[] createRotations() {
        return this.pieces;
    }


    


}
