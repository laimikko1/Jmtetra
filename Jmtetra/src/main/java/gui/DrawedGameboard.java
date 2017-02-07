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

    }

}
