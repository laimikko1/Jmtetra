/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.jmtetra;

import tetralogic.Gameboard;
import tetralogic.Piece;
import tetralogic.SquareShape;
import tetralogic.Tetronome;
import static tetralogic.Type.Square;

/**
 *
 * @author mikko
 */
public class Main {

    public static void main(String[] args) {
        

//        Gameboard g = new Gameboard();
//        g.printBoard();
        Tetronome square = new SquareShape(Square, new Piece[4]);
    }

}
