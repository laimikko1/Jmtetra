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

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Gameboard g = new Gameboard();
        ArrayList<Tetronome> lista = new ArrayList<>();
        lista.add(new Ishape(new Piece[4]));
        lista.add(new LshapeLeft(new Piece[4]));
        lista.add(new SquareShape(new Piece[4]));
        lista.add(new ZshapeRight(new Piece[4]));
        lista.add(new ZshapeLeft(new Piece[4]));
        lista.add(new LshapeRight(new Piece[4]));
        lista.add(new Tshape(new Piece[4]));

//        while (true) {
//            Collections.shuffle(lista);
//
//            g.addTetronome(lista.get(0));
//
//            while (g.isRoundOver()) {
//                Timer timer = new Timer();
//                int begin = 1000;
//                int timeinterval = 1000;
//                timer.scheduleAtFixedRate(new TimerTask() {
//                    @Override
//                    public void run() {
//                        g.getCurTetro().moveDown();
//                    }
//                }, begin, timeinterval);
//                System.out.print("kommand: ");
//                String k = reader.nextLine();
//
//                if (k.equals("a")) {
//                    g.updateBoard(g.getCurTetro().moveLeftOrRight(-1));
//                }
//                if (k.equals("d")) {
//                    g.updateBoard(g.getCurTetro().moveLeftOrRight(1));
//                }
//                if (k.equals("z")) {
//                    g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(-1));
//                }
//                if (k.equals("x")) {
//                    g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));
//                }
//                if (k.equals("s")) {
//                    g.updateBoard(g.getCurTetro().moveDown());
//                }
//                
//                printBoard(g);
//            
//            }
//        }
        GameInterface ga = new GameInterface(g);
        ga.run();

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
