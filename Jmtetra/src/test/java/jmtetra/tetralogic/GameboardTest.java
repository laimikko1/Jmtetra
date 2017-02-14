package jmtetra.tetralogic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.ZshapeLeft;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import jmtetra.tetralogic.tetronomes.ZshapeRight;

/**
 *
 * @author mikko
 */
public class GameboardTest {

    private Gameboard g;
    private Tetronome tetronome;

    public GameboardTest() {
        this.g = new Gameboard();
        this.tetronome = new Ishape(new Piece[4]);
    }

    @Test
    public void gameBoardIsCorrect() {
        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
        assertArrayEquals(g.getGameboard(), testBoard);
    }

    @Test
    public void sizeGettersWorkRight() {
        assertEquals(g.getHeight(), 16);
        assertEquals(g.getWidth(), 10);
    }

    @Test
    public void getCharReturnsCorrect() {
        assertEquals(g.getChar(0, 0), '-');
    }

    @Test
    public void setCharWorks() {
        g.setChar(0, 0, 'T');
        assertEquals('T', g.getChar(0, 0));
    }

    @Test
    public void currentTetronomeIsNullAtBeginning() {
        assertNull(g.getCurTetro());
    }

    @Test
    public void currentTetronomeWorksWhenSigned() {
        Ishape i = new Ishape(new Piece[4]);
        g.addTetronome(i);
        assertEquals(g.getCurTetro(), i);
    }

    @Test
    public void addingSquareWorks() {
        SquareShape sq = new SquareShape(new Piece[4]);
        g.addTetronome(sq);

        assertTrue(checkPieces('O', sq));

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

        assertTrue(checkPieces('K', l));
    }

    @Test
    public void addingIworks() {
        Ishape i = new Ishape(new Piece[4]);
        g.addTetronome(i);

        assertTrue(checkPieces('I', i));
    }

    @Test
    public void addingZhapeRightWorks() {
        ZshapeRight s = new ZshapeRight(new Piece[4]);
        g.addTetronome(s);

        assertTrue(checkPieces('X', s));
    }

    @Test
    public void addingZshapeLeftWorks() {
        ZshapeLeft s = new ZshapeLeft(new Piece[4]);
        g.addTetronome(s);

        assertTrue(checkPieces('Z', s));
    }

    private boolean checkPieces(char c, Tetronome t) {
        for (Piece p : t.getPieces()) {
            if (g.getChar(p.getY(), p.getX()) != c) {
                return false;
            }

        }
        return true;
    }

    @Test
    public void checkIfOccupiedReturnsFalseWhenPieceTakenOnLeft() {
        g.setChar(0, 2, 'x');
        g.addTetronome(this.tetronome);
        assertFalse(g.checkIfOccupied(this.tetronome.moveLeftOrRight(-1)));
    }

    @Test
    public void checkIfOccupiedReturnsTrueWhenPieceNotTakenOnLeft() {
        g.addTetronome(this.tetronome);
        assertTrue(g.checkIfOccupied(this.tetronome.moveLeftOrRight(-1)));
    }

    @Test
    public void checkIfOccupiedReturnsFalseWhenPieceTakenOnRight() {
        g.setChar(0, 7, 'x');
        g.addTetronome(this.tetronome);
        assertFalse(g.checkIfOccupied(this.tetronome.moveLeftOrRight(1)));
    }

    @Test
    public void checkIfOccupiedReturnsTrueWhenPieceNotTakenOnRight() {
        g.addTetronome(tetronome);
        assertTrue(g.checkIfOccupied(this.tetronome.moveLeftOrRight(1)));
    }

    @Test
    public void checkIfOccupiedReturnsFalseWhenPieceTakenBelow() {
        g.setChar(1, 4, 'x');
        g.addTetronome(this.tetronome);
        assertFalse(g.checkIfOccupied(this.tetronome.moveDown()));
    }

    @Test
    public void checkIfOccupiedReturnsTrueWhenPieceNotTakenBelow() {
        g.addTetronome(tetronome);
        assertTrue(g.checkIfOccupied(this.tetronome.moveDown()));
    }

    @Test
    public void updateBoardMovesPiecesCorrectly() {
        g.addTetronome(tetronome);

        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};

        assertArrayEquals(g.getGameboard(), testBoard);

        g.updateBoard(this.tetronome.moveLeftOrRight(-1));

        testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};

        assertArrayEquals(g.getGameboard(), testBoard);
    }

    @Test
    public void updateBoardDoesntGoOutOfBoundsOnLeft() {
        g.addTetronome(tetronome);

        for (int i = 0; i < 5; i++) {
            g.updateBoard(tetronome.moveLeftOrRight(-1));
        }

        char[][] testBoard = new char[][]{
            {'I', 'I', 'I', 'I', '-', '-', '-', '-', '-', '-'},
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};

        assertArrayEquals(g.getGameboard(), testBoard);
    }

    @Test
    public void updateBoardDoesntGoOutOfBoundMovingRIght() {
        g.addTetronome(tetronome);
        char[][] testBoard = new char[][]{
            {'-', '-', '-', '-', '-', '-', 'I', 'I', 'I', 'I'},
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};

        for (int i = 0; i < 5; i++) {
            g.updateBoard(tetronome.moveLeftOrRight(1));

        }
        assertArrayEquals(g.getGameboard(), testBoard);

    }

    @Test
    public void updateBoardDoesntGoOutOfBoundMovingDown() {
        g.addTetronome(tetronome);

        for (int i = 0; i < 20; i++) {
            g.updateBoard(this.tetronome.moveDown());

        }

        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', 'I', 'I', 'I', 'I', '-', '-', '-'},};

        assertArrayEquals(g.getGameboard(), testBoard);

    }

    @Test
    public void roundIsOverWhenPieceHasReachedBottom() {
        this.g.addTetronome(tetronome);
        for (int i = 0; i < 15; i++) {
            g.updateBoard(g.getCurTetro().moveDown());
        }
        assertTrue(this.g.isRoundOver());
    }

    @Test
    public void roundIsOverReturnsFalseWhenPiecesBelowNotTaken() {
        g.addTetronome(this.tetronome);
        assertFalse(g.isRoundOver());
    }

    @Test
    public void roundIsOverReturnsFalseEvenIfOwnPieceIsBelow() {
        g.addTetronome(tetronome);
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));
        assertFalse(g.isRoundOver());
    }

    @Test
    public void roundIsOverReturnsTrueWhenPiecesTakenBelow() {
        g.addTetronome(tetronome);
        g.updateBoard(g.getCurTetro().moveDown());
        g.addTetronome(new Ishape(new Piece[4]));
        assertTrue(g.isRoundOver());
    }

    @Test
    public void checkIfaFullRowReturnsFalseWhenRowNotFull() {
        assertFalse(this.g.checkIfAFullRow(0));
    }

    @Test
    public void checkIfFullRowReturnsTrueWhenRowIsFull() {
        for (int i = 0; i < g.getWidth(); i++) {
            g.setChar(0, i, 'T');
        }
        assertTrue(this.g.checkIfAFullRow(0));
    }

    @Test
    public void moveAllPiecesDownMovesPiecesDown() {
        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', 'I'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', 'I'},
            {'-', 'T', '-', '-', '-', '-', 'Z', 'Z', '-', 'I'},
            {'T', 'T', 'T', '-', '-', '-', '-', 'Z', 'Z', 'I'},
            {'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T'},};

        initializeGameBoardsToTest(testBoard);

        this.g.moveAllPiecesDown(g.getHeight() - 1);

        char[][] testBoard2 = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', 'I'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', 'I'},
            {'-', 'T', '-', '-', '-', '-', 'Z', 'Z', '-', 'I'},
            {'T', 'T', 'T', '-', '-', '-', '-', 'Z', 'Z', 'I'},};

        assertArrayEquals(testBoard2, this.g.getGameboard());

    }

    @Test
    public void checkAllFullRowsDoesntDeleteWhenNoFullRows() {
        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', 'I'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', 'I'},
            {'-', 'T', '-', '-', '-', '-', 'Z', 'Z', '-', 'I'},
            {'T', 'T', 'T', 'T', 'T', 'T', '-', 'Z', 'Z', 'I'},
            {'T', 'T', 'T', '-', 'T', 'T', 'T', 'T', 'T', 'T'},};

        initializeGameBoardsToTest(testBoard);

        this.g.checkAllRowsForFullOnes();
        assertArrayEquals(this.g.getGameboard(), testBoard);
    }

    @Test
    public void checkAllFullRowsDeletesIfOneRullRow() {
        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'T', 'I', 'I', 'I', 'I', 'I', 'I', 'Z', 'Z', 'T'},};

        initializeGameBoardsToTest(testBoard);

        char[][] testBoard2 = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
        this.g.checkAllRowsForFullOnes();

        assertArrayEquals(this.g.getGameboard(), testBoard2);
    }

    @Test
    public void checkAllFullRowsDeletesMultipleFullRows() {
        char[][] testBoard = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'T', 'T', 'T', 'T', 'I', 'I', 'I', 'I', 'I', 'Z'},
            {'O', 'T', 'Z', 'I', 'S', 'Z', 'T', 'T', 'T', 'T'},
            {'T', 'I', 'I', 'I', 'I', 'I', 'I', 'Z', 'Z', 'T'},};

        initializeGameBoardsToTest(testBoard);

        this.g.checkAllRowsForFullOnes();
        
           char[][] testBoard2 = new char[][]{
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
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
           
           assertArrayEquals(testBoard2, this.g.getGameboard());
    }

    private void initializeGameBoardsToTest(char[][] testBoard) {
        for (int y = 0; y < g.getHeight(); y++) {
            for (int x = 0; x < g.getWidth(); x++) {
                this.g.setChar(y, x, testBoard[y][x]);
            }
        }
    }

}
