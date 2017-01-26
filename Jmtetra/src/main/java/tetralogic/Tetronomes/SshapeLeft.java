/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic.Tetronomes;

import tetralogic.Piece;
import tetralogic.Type;
import static tetralogic.Type.SshapeLeft;

public class SshapeLeft extends Tetronome {

    private Type type;
    private Piece[] pieces;

    public SshapeLeft(Piece[] pieces) {
        super(pieces);
        this.type = SshapeLeft;
        this.pieces = pieces;
        createTetronome();
    }

    @Override
    final void createTetronome() {
        int yCord = 0;
        int xCord = 5;
        
        for (int i = 0; i < 2; i++) {
            pieces[i] = new Piece(yCord, xCord, 'S');
            xCord--;
        }
        yCord++;
        xCord++;
        
        for (int i = 2; i < 4; i++) {
            pieces[i] = new Piece(yCord, xCord, 'S');
            xCord--;
        }
    }

}
