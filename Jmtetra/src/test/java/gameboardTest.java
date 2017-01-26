/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jmtetra.jmtetra.Main;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetralogic.Gameboard;
import tetralogic.Piece;
import tetralogic.Tetronomes.Ishape;
import tetralogic.Tetronomes.LshapeLeft;
import tetralogic.Tetronomes.LshapeRight;
import tetralogic.Tetronomes.Squareshape;
import tetralogic.Tetronomes.SshapeLeft;
import tetralogic.Tetronomes.SshapeRight;
import tetralogic.Tetronomes.Tetronome;
import tetralogic.Tetronomes.Tshape;

/**
 *
 * @author mikko
 */
public class gameboardTest {

    private Gameboard g;

    public gameboardTest() {
        this.g = new Gameboard();
    }

    @Test
    public void SizeIsRight() {
        assertEquals(g.getHeight(), 16);
        assertEquals(g.getWidth(), 10);
    }

    @Test
    public void addingSquareWorks() {
        Squareshape sq = new Squareshape(new Piece[4]);
        g.addTetronome(sq);

        assertTrue(checkPieces('0', sq));

    }

    @Test
    public void addingTWorks() {
        Tshape t = new Tshape(new Piece[4]);
        g.addTetronome(t);
        
        assertTrue(checkPieces('T', t));

    }
    
    @Test
    public void addingLRightWorks() {
        LshapeRight l = new LshapeRight(new Piece[4]);
        g.addTetronome(l);
    
        assertTrue(checkPieces('L', l));
    }
    
    @Test
    public void addingLLeftWorks() {
        LshapeLeft l = new LshapeLeft(new Piece[4]);
        g.addTetronome(l);
        
        assertTrue(checkPieces('L', l));
    }
    
    @Test
    public void addingIworks() {
        Ishape  i= new Ishape(new Piece[4]);
        g.addTetronome(i);
        
        assertTrue(checkPieces('I', i));
    }
    
    @Test
    public void SshapeRight() {
        SshapeRight s = new SshapeRight(new Piece[4]);
        g.addTetronome(s);
        
        assertTrue(checkPieces('S', s));
    }
    
    @Test
    public void SshapeLeft() {
        SshapeLeft s = new SshapeLeft(new Piece[4]);
        g.addTetronome(s);
        
        assertTrue(checkPieces('S', s));
    }

    private boolean checkPieces(char c, Tetronome t) {
        for (Piece p : t.getPieces()) {
            if (g.getChar(p.getX(), p.getY()) != c) {
                return false;
            }

        }
        return true;
    }
}
