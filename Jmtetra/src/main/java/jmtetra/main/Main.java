/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.main;

import gui.GameInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.Type;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.ZshapeLeft;
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.ZshapeRight;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import static jmtetra.tetralogic.Type.Ishape;
import static jmtetra.tetralogic.Type.LshapeLeft;
import static jmtetra.tetralogic.Type.LshapeRight;
import static jmtetra.tetralogic.Type.Squareshape;
import static jmtetra.tetralogic.Type.Tshape;
import static jmtetra.tetralogic.Type.ZshapeLeft;

/**
 *
 * @author mikko
 */
import static jmtetra.tetralogic.Type.ZshapeRIght;
import theGame.Gameclass;
import gui.GameInterface;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        Gameclass gc = new Gameclass();
        GameInterface g = new GameInterface(gc);
        
        SwingUtilities.invokeLater(g);
        
        gc.start();
        
        
    
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
