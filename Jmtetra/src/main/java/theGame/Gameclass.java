/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import gui.DrawedGameboard;
import java.util.Collections;
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
public class Gameclass extends Timer implements ActionListener {

    private ArrayList<Tetronome> pieces;
    private boolean roundIsOver;
    private boolean gameIsOver;
    private DrawedGameboard drawedGameboard;
    private Gameboard gameboard;

    public Gameclass() {
        super(1000, null);
        createListOfPieces();
        this.roundIsOver = false;
        this.gameIsOver = false;
        this.gameboard = new Gameboard();

        addActionListener(this);
        setInitialDelay(1000);
    }

    public Gameboard getGameboard() {
        return this.gameboard;
    }

    public void startGame() {

    }

    private void createListOfPieces() {
        this.pieces = new ArrayList();
        this.pieces.add(new Ishape(new Piece[4]));
        this.pieces.add(new LshapeLeft(new Piece[4]));
        this.pieces.add(new LshapeRight(new Piece[4]));
        this.pieces.add(new SquareShape(new Piece[4]));
        this.pieces.add(new Tshape(new Piece[4]));
        this.pieces.add(new ZshapeLeft(new Piece[4]));
        this.pieces.add(new ZshapeRight(new Piece[4]));
    }

    public void setDrawboard(DrawedGameboard drawedGameboard) {
        this.drawedGameboard = drawedGameboard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        while (true) {
            Collections.shuffle(pieces);
            this.gameboard.addTetronome(pieces.get(0));
            while (!this.gameboard.isRoundOver()) {
                this.gameboard.updateBoard(gameboard.getCurTetro().moveDown());

                this.drawedGameboard.update();
            }
        }

    }

}
