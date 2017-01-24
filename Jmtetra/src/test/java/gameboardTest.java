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
import tetralogic.Square;
import tetralogic.Tetronome;

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
        
        for(Piece p : sq.getPieces()) {
            assertEquals(g.getChar(p.getX(), p.getY()), '0');
            
        }
        
    }
}
