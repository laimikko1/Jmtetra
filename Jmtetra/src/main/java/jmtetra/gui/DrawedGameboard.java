/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import jmtetra.gameloop.Gameloop;

/**
 *
 * @author mikko
 */
public class DrawedGameboard extends JPanel {

    private Gameloop gameclass;

    public DrawedGameboard(Gameloop gameclass) {
        this.gameclass = gameclass;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < gameclass.getGameboard().getHeight(); y++) {
            for (int x = 0; x < gameclass.getGameboard().getWidth(); x++) {
                Color c = setCharacterColors(y, x);
                g.setColor(setCharacterColors(y, x));
                g.fill3DRect(x * 35, y * 35, 35, 35, true);
            }
        }

    }
    
    public Color setCharacterColors(int y, int x) {
        char c = gameclass.getGameboard().getChar(y, x);
        if (c == 'I') {
            return Color.CYAN;
        }

        if (c == 'K') {
            return Color.BLUE;
        }

        if (c  == 'L') {
            return Color.ORANGE;
        }

        if (c  == 'O') {
            return Color.YELLOW;
        }

        if (c  == 'T') {
            return Color.MAGENTA;
        }

        if (c  == 'Z') {
            return Color.GREEN;
        }

        if (c  == 'X') {
            return Color.RED;
        }

        return Color.WHITE;

    }


    public void update() {
        repaint();
    }
}
