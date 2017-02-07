/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theGame;

import java.util.ArrayList;
import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import jmtetra.tetralogic.tetronomes.ZshapeLeft;
import jmtetra.tetralogic.tetronomes.ZshapeRight;

/**
 *
 * @author mikko
 */
public class Gameclass {

    private Gameboard gameboard;
    private ArrayList<Tetronome> pieces;
    private boolean roundIsOver;
    private boolean gameIsOver;

    public Gameclass() {
        this.gameboard = new Gameboard();
        this.pieces = new ArrayList<>();
        createListOfPieces();
        this.roundIsOver = false;
        this.gameIsOver = false;
    }

    public Gameboard getGameboard() {
        return gameboard;
    }

    public void startGame() {

    }

    private void createListOfPieces() {
        this.pieces.add(new Ishape(new Piece[4]));
        this.pieces.add(new LshapeLeft(new Piece[4]));
        this.pieces.add(new LshapeRight(new Piece[4]));
        this.pieces.add(new SquareShape(new Piece[4]));
        this.pieces.add(new Tshape(new Piece[4]));
        this.pieces.add(new ZshapeLeft(new Piece[4]));
        this.pieces.add(new ZshapeRight(new Piece[4]));
    }

}
