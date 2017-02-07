/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
        for (int i = 0; i < gameclass.getGameboard().getHeight(); i++) {
            for (int j = 0; j < gameclass.getGameboard().getWidth(); j++) {
                g.setColor(gameclass.getGameboard().setCharacterColors(i, j));
                g.fill3DRect(j, i, 200, 200, true);
            }
        }

    }

    public void update() {
        repaint();
    }
}
