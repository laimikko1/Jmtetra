/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import java.util.List;
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
public class IshapeTest {

    private Ishape i;
    private Gameboard g;

    public IshapeTest() {
        this.i = new Ishape(new Piece[4]);
        this.g = new Gameboard();
    }

    @Test
    public void rotationsAreCorrectAtBeginning() {
        Piece[] testList = createUpwardsRotation();
        Piece[] up = i.moveClockOrCounterClockWise(1);
        int a = 0;
        for (Piece p : up) {
            assertEquals(p.getX(), testList[a].getX());
            assertEquals(p.getY(), testList[a].getY());
            assertEquals(p.getMark(), testList[a].getMark());
            a++;
        }

    }

    private Piece[] createUpwardsRotation() {
        Piece[] testList = new Piece[4];
        testList[0] = new Piece(this.i.getPieces()[1].getY() - 1, i.getPieces()[1].getX(), i.getPieces()[1].getMark());
        testList[1] = i.getPieces()[1];
        testList[2] = new Piece(i.getPieces()[1].getY() + 1, i.getPieces()[1].getX(), i.getPieces()[1].getMark());
        testList[3] = new Piece(i.getPieces()[1].getY() + 2, i.getPieces()[1].getX(), i.getPieces()[1].getMark());
        return testList;
    }

    @Test
    public void rotationsAreCorrectAfterMoving() {
        i.setPieces(i.moveDown());
        i.createOrUpdateRotations();

        rotationsAreCorrectAtBeginning();
    }

    @Test
    public void IshapeClockwiseWorksCorrect() {
        g.addTetronome(new Ishape(new Piece[4]));
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));
        char[][] testBoard = new char[][]{
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', 'I', 'I', 'I', 'I', '-', '-', '-', '-'},
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

        char[][] testBoard3 = new char[][]{
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', 'I', '-', '-', '-', '-', '-'},
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
        
            assertArrayEquals(testBoard3, g.getGameboard());
            
            g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));
            
            char[][] testBoard4 = new char[][]{
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', 'I', 'I', 'I', 'I', '-', '-', '-'},
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
        
            assertArrayEquals(testBoard4, g.getGameboard());
    }

//    @Test
//    public void multipleRotationsWorkCorrect() {
//        IshapeRotationsWorkCorrect();
//        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(-1));
//
//        char[][] testBoard2 = new char[][]{
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', 'I', 'I', 'I', 'I', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
//
//        assertArrayEquals(testBoard, g.getGameboard());
//    }
//    @Test
//    public void ishapeRotationsDontGoOutOfBounds() {
//        g.addTetronome(new Ishape(new Piece[4]));
//
//        for (int j = 0; j < 5; j++) {
//            g.updateBoard(g.getCurTetro().moveLeftOrRight(1));
//        }
//
//        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));
//        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(-1));
//        char[][] testBoard = new char[][]{
//            {'-', '-', '-', '-', '-', '-', 'I', 'I', 'I', 'I'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
//
//        assertArrayEquals(testBoard, g.getGameboard());
//    }
//    @Test
//    public void ishapeRotationsDontGoOutOfBounds2() {
//        g.addTetronome(this.i);
//        g.updateBoard(g.getCurTetro().moveDown());
//    }
//}
}
