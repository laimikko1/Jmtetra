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
import tetralogic.Tetronomes.Square;
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
        assertEquals(g.getWidth(), 12);
    }

    @Test
    public void addingSquareWorks() {
        Square sq = new Square(new Piece[4]);
        g.addTetronome(sq);

        assertTrue(checkPieces('0', sq));

    }

    @Test
    public void addingTWorks() {
        Tshape t = new Tshape(new Piece[4]);
        g.addTetronome(t);
        
        assertTrue(checkPieces('T', t));

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
