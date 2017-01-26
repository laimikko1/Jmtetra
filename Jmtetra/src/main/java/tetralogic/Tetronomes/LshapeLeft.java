package tetralogic.Tetronomes;

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
        int xCord = 5;
        int yCord = 0;
        pieces[0] = new Piece(xCord, yCord, 'L');
        yCord++;
        
        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(xCord, yCord, 'L');
            xCord--;
        }
    }

}
