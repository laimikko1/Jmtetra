package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import static jmtetra.tetralogic.Type.LshapeLeft;

public  class LshapeLeft extends Tetronome {

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
    void createOrUpdateRotations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
