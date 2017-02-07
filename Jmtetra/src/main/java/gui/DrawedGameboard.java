/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import theGame.Gameclass;

/**
 *
 * @author mikko
 */
public class DrawedGameboard extends JPanel {

    private Gameclass gameclass;

    public DrawedGameboard(Gameclass gameclass) {
        this.gameclass = gameclass;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < gameclass.getGameboard().getHeight(); y++) {
            for (int x = 0; x < gameclass.getGameboard().getWidth(); x++) {
                Color c = gameclass.getGameboard().setCharacterColors(y, x);
                g.setColor(gameclass.getGameboard().setCharacterColors(y, x));
                g.fill3DRect(y, x, 200, 200, true);
            }
        }

    }

    public void update() {
       super.repaint();
    }
}
