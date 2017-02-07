/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import jmtetra.tetralogic.Gameboard;

/**
 *
 * @author mikko
 */
public class GameInterface implements Runnable {

    private Gameboard gameboard;
    private JFrame frame;

    public GameInterface(Gameboard g) {
        this.gameboard = g;
    }

    @Override
    public void run() {
        this.gameboard = new Gameboard();
        frame = new JFrame("Tetris");
        frame.setPreferredSize(new Dimension(500, 450));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(this.frame.getContentPane());
        
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {
        
    }

}
