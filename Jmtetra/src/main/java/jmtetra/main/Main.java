/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.main;

import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.SshapeRight;
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.SshapeLeft;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import static jmtetra.tetralogic.Type.Ishape;
import static jmtetra.tetralogic.Type.LshapeLeft;
import static jmtetra.tetralogic.Type.Tshape;
import static jmtetra.tetralogic.Type.Squareshape;
import static jmtetra.tetralogic.Type.SshapeLeft;

/**
 *
 * @author mikko
 */
public class Main {

    public static void main(String[] args) {

        Gameboard g = new Gameboard();
        printBoard(g);

//        g.addTetronome(square);
        g.addTetronome(new Tshape(new Piece[4]));
        printBoard(g);
        System.out.println("");
        System.out.println("");
        g.updateBoard(g.getCurTetro().moveLeft());
        
        printBoard(g);

    }

    public static void printBoard(Gameboard gameboard) {

        for (int i = 0; i < gameboard.getHeight(); i++) {
            for (int j = 0; j < gameboard.getWidth(); j++) {
                System.out.print(gameboard.getGameboard()[i][j]);
            }
            System.out.println();

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}
