package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.Ishape;

public class Ishape extends Tetronome {

    private Type type;
    private Piece[] pieces;

    public Ishape(Piece[] pieces) {
        super(pieces);
        this.type = Ishape;
        this.pieces = pieces;
        createTetronome();
    }

    @Override
    final void createTetronome() {
        int xCord = 3;
        int yCord = 0;
        

        pieces[0] = new Piece(xCord, yCord, 'I');
        xCord++;
        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(xCord, yCord, 'I');
            xCord++;
        }
    }

}
