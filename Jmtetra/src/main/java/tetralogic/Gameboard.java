/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetralogic;

import tetralogic.Tetronomes.Tetronome;

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

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
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

    public void updateBoard(Piece[] dir) {
        if (tetroInPlay.checkIfOccupied(this, dir)) {
            Piece[] oldCoords = tetroInPlay.getPieces();
            char c = dir[0].getMark();

            for (Piece p : oldCoords) {
                setChar(p.getY(), p.getX(), '-');
            }

            for (Piece p : dir) {
                setChar(p.getY(), p.getX(), p.getMark());
            }

            tetroInPlay.setNewPieces(dir);

            this.printBoard();

        }
    }
}
