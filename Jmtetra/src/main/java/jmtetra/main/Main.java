package jmtetra.main;

import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.tetronomes.Ishape;

public class Main {
    
    public static void main(String[] args) {

//        Gameloop gc = new Gameloop();
//        GameInterface g = new GameInterface(gc);
//        
//        SwingUtilities.invokeLater(g);
//        gc.start();
        Gameboard g = new Gameboard();
        g.addTetronome(new Ishape(new Piece[4]));
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveDown());
        g.updateBoard(g.getCurTetro().moveClockOrCounterClockWise(1));
        g.isRoundOver();
        
//        
        
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
