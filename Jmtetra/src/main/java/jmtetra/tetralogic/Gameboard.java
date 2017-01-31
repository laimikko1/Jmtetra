/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic;

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
        this.tetroInPlay = t;
        for (Piece p : t.getPieces()) {
            gameboard[p.getY()][p.getX()] = p.getMark();
        }
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
            
            
            for (int j = 0; j < tetroInPlay.getPieces().length; j++) {
                   tetroInPlay.getPieces()[j] = dir[j];
            }

        }
    }
}
