/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.jmtetra;

import tetralogic.Gameboard;
import tetralogic.Piece;
import tetralogic.Square;
import tetralogic.Tetronome;
import static tetralogic.Type.Square;
import static tetralogic.Type.T;

/**
 *
 * @author mikko
 */
public class Main {

    public static void main(String[] args) {

        Gameboard g = new Gameboard();
        g.printBoard();
        Square square = new Square(new Piece[4]);

        g.addTetronome(square);
        
        System.out.println("");
        System.out.println("");
        
        g.printBoard();

    }

}
