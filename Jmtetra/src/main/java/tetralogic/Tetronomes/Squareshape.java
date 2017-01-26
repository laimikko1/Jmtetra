package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.Squareshape;

public class Squareshape extends Tetronome {

    private Type type;
    public Piece[] pieces;

    public Squareshape(Piece[] pieces) {
        super(pieces);
        this.pieces = pieces;
        this.type = Squareshape;
        createTetronome();
    }

    @Override
    public final void createTetronome() {
        int xKoord = 4;
        int Ykoord = 0;
        for (int i = 0; i < 4; i++) {
            Piece p = new Piece(xKoord, Ykoord, '0');
            this.pieces[i] = p;

            xKoord++;
            if (i == 1) {
                Ykoord++;
                xKoord = 5;
            }
        }

    }

    


}
