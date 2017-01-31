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
import jmtetra.tetralogic.tetronomes.SquareShape;
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
        assertNotNull(this.tetronome = new SquareShape(n));
        assertNotNull(this.tetronome = new SshapeLeft(n));
        assertNotNull(this.tetronome = new SshapeRight(n));

    }
    
     @Test
    public void moveLeftOrRightCreatesCorrectCoordinatesWhenMovingLeft() {
        Piece[] oldCoords = this.tetronome.getPieces();
        Piece[] moveLeftCoords = this.tetronome.moveLeftOrRight(-1);

        for (int i = 0; i < oldCoords.length; i++) {
            assertEquals(oldCoords[i].getX() - 1, moveLeftCoords[i].getX());
        }
    }
    
    @Test
    public void moveLeftOrRightCreatesCorrectCoordinatesWhenMovingRight() {
        Piece[] oldCords = this.tetronome.getPieces();
        Piece[] moveRightCords = this.tetronome.moveLeftOrRight(+1);
        
        for (int i = 0; i < oldCords.length; i++) {
            assertEquals(oldCords[i].getX() + 1, moveRightCords[i].getX());
        }
    }
    
    @Test
    public void moveDownCreatesCorrectCoordinates() {
        Piece[] oldCords = this.tetronome.getPieces();
        Piece[] moveDownCords = this.tetronome.moveDown();
    
        for (int i = 0; i < oldCords.length; i++) {
            assertEquals(oldCords[i].getY() + 1, moveDownCords[i].getY());
        }
    }
    
  
    
    
    


       
    
}
