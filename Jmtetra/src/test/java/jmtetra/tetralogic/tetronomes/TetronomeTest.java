/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.Squareshape;
import jmtetra.tetralogic.tetronomes.SshapeLeft;
import jmtetra.tetralogic.tetronomes.SshapeRight;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laimikko
 */
public class TetronomeTest {

    private Tetronome tetronome;
    private Gameboard g;

    public TetronomeTest() {
        this.tetronome = new Ishape(new Piece[4]);
    }

    @Test
    public void allShapesInitialize() {
        Piece[] n = new Piece[4];
        assertNotNull(this.tetronome = new Ishape(n));
        assertNotNull(this.tetronome = new Tshape(n));
        assertNotNull(this.tetronome = new LshapeLeft(n));
        assertNotNull(this.tetronome = new LshapeRight(n));
        assertNotNull(this.tetronome = new Squareshape(n));
        assertNotNull(this.tetronome = new SshapeLeft(n));
        assertNotNull(this.tetronome = new SshapeRight(n));

    }
    
     @Test
    public void moveLeftCreatesCorrectCoordinates() {
        Piece[] oldCoords = this.tetronome.getPieces();
        Piece[] moveLeftCoords = this.tetronome.moveLeft();

        for (int i = 0; i < oldCoords.length; i++) {
            assertEquals(oldCoords[i].getX() - 1, moveLeftCoords[i].getX());
        }
    }


       
    
}
