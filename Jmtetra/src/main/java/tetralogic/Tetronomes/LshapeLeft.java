package tetralogic.Tetronomes;

import tetralogic.Gameboard;
import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.LshapeLeft;

public final class LshapeLeft extends Tetronome {

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

}
