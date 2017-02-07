/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 */
public class ZshapeRightTest {

    private Gameboard g;
    private ZshapeRight z;

    public ZshapeRightTest() {
        this.g = new Gameboard();
        this.z = new ZshapeRight(new Piece[4]);
    }

    @Test
    public void rotationsWork() {
        this.g.addTetronome(z);
        g.updateBoard(g.getCurTetro().moveDown());

        char[][] testBoard = new char[][]{
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'X', 'X', '-', '-', '-', '-'},
            {'-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};

        assertArrayEquals(testBoard, g.getGameboard());

        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));

        char[][] testBoard2 = new char[][]{
            {'-', '-', '-', 'X', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'X', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};

        assertArrayEquals(testBoard2, g.getGameboard());

        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));

        assertArrayEquals(testBoard, g.getGameboard());

        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));

        assertArrayEquals(testBoard2, g.getGameboard());

        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));

        
        assertArrayEquals(testBoard, g.getGameboard());

    }

}
