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
        int yCord = 0;
        int xCord = 3;
        

        pieces[0] = new Piece(yCord, xCord, 'I');
        xCord++;
        for (int i = 1; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'I');
            xCord++;
        }
    }

}
