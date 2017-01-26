/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.jmtetra;

import tetralogic.Gameboard;
import tetralogic.Piece;
import tetralogic.Tetronomes.Ishape;
import tetralogic.Tetronomes.LshapeLeft;
import tetralogic.Tetronomes.LshapeRight;
import tetralogic.Tetronomes.SshapeRight;
import tetralogic.Tetronomes.Squareshape;
import tetralogic.Tetronomes.SshapeLeft;
import tetralogic.Tetronomes.Tetronome;
import tetralogic.Tetronomes.Tshape;
import static tetralogic.Type.Ishape;
import static tetralogic.Type.LshapeLeft;
import static tetralogic.Type.Tshape;
import static tetralogic.Type.Squareshape;
import static tetralogic.Type.SshapeLeft;

/**
 *
 * @author mikko
 */
public class Main {

    public static void main(String[] args) {

        Gameboard g = new Gameboard();
        g.printBoard();

//        g.addTetronome(square);
        g.addTetronome(new Tshape(new Piece[4]));
        g.printBoard();
        System.out.println("");
        System.out.println("");
        g.updateBoard(g.getCurTetro().moveLeft());

    }

}
