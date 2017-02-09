/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic;

import java.awt.Color;
import jmtetra.tetralogic.tetronomes.Tetronome;

/**
 *
 * @author laimikko
 */
public class Gameboard {

    private int height;
    private int width;
    private char[][] gameboard;
    private Tetronome tetroInPlay;

    public Gameboard() {
        this.width = 10;
        this.height = 16;
        this.tetroInPlay = null;

        this.gameboard = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameboard[i][j] = '-';
            }
        }
    }

    public void addTetronome(Tetronome t) {
        t.createTetronome();
        this.tetroInPlay = t;

        for (Piece p : t.getPieces()) {
            gameboard[p.getY()][p.getX()] = p.getMark();
        }
    }

    public boolean isRoundOver() {
        Piece p = tetroInPlay.getLowestLocation();
        if (p.getY() == 15) {
            return true;
        }

        boolean isroundover = getChar(p.getY() + 1, p.getX()) != '-';
        return isroundover;
    }

    public Tetronome getCurTetro() {
        return this.tetroInPlay;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getGameboard() {
        return gameboard;
    }

    public char getChar(int y, int x) {
        return this.gameboard[y][x];
    }

    public void setChar(int y, int x, char c) {
        this.gameboard[y][x] = c;
    }

    public boolean checkIfOccupied(Piece[] newLoc) {
        for (Piece p : newLoc) {
            if (samePieceInBothArrays(p)) {
                continue;
            }
            if (p.getX() >= this.getWidth() || p.getX() < 0) {
                return false;
            }
            if (p.getY() >= this.getHeight() || p.getY() < 0) {
                return false;
            }
            if (this.getChar(p.getY(), p.getX()) != '-') {
                return false;
            }
        }
        return true;

    }

    private boolean samePieceInBothArrays(Piece p) {
        for (Piece pi : this.tetroInPlay.getPieces()) {
            if (p.getX() == pi.getX() && p.getY() == pi.getY()) {
                return true;
            }
        }
        return false;
    }

    public void updateBoard(Piece[] dir) {
        if (this.checkIfOccupied(dir)) {
            Piece[] oldCoords = tetroInPlay.getPieces();

            for (Piece p : oldCoords) {
                setChar(p.getY(), p.getX(), '-');
            }

            for (Piece p : dir) {
                setChar(p.getY(), p.getX(), p.getMark());
            }

            tetroInPlay.setPieces(dir);

        }
    }

    public Color setCharacterColors(int y, int x) {
        if (getChar(y, x) == 'I') {
            return Color.CYAN;
        }

        if (getChar(y, x) == 'K') {
            return Color.BLUE;
        }

        if (getChar(y, x) == 'L') {
            return Color.ORANGE;
        }

        if (getChar(y, x) == 'O') {
            return Color.YELLOW;
        }

        if (getChar(y, x) == 'T') {
            return Color.MAGENTA;
        }

        if (getChar(y, x) == 'Z') {
            return Color.GREEN;
        }

        if (getChar(y, x) == 'X') {
            return Color.RED;
        }

        return Color.WHITE;

    }
}
