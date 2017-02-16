/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import jmtetra.gameloop.Gameloop;

/**
 * Luokka on käyttöliittymä, joka alustetaan välittömästi ohjelman aloitettua
 * toimintansa.
 *
 * @author mikko
 */
public class GameInterface implements Runnable {

    private GameboardDrawer gameboardDrawer;
    private Gameloop gameclass;
    private JFrame frame;

    /**
     * Konstruktorissa annetaan parametrina Gameloop-luokan ilmentymä, joka
     * välitetään myös DrawedGameboard-luokalle.
     *
     *
     * @param gameclass Gameloop luokan ilmentymä ,johon luodaan tarvittava
     * looppi pelille
     */
    public GameInterface(Gameloop gameclass) {

        this.gameclass = gameclass;
        this.gameboardDrawer = new GameboardDrawer(this.gameclass);
        this.gameclass.setDrawboard(gameboardDrawer);
    }

    /**
     * Metodi luo halutun kokoisen Framen ja lisää siihen pelin toiminnan
     * kannalta vaaditut komponentit.
     *
     *
     */
    @Override
    public void run() {
        frame = new JFrame("Tetris");
        frame.setPreferredSize(new Dimension(600, 620));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * Metodi saa parametrina ContentPane-luokan ilmentymän, johon lisätään sekä
     * piirtoluokan ilmentymä (Gameboard) ja alkuperäinen pelilauta, joka on
     * tyypiltään char[][]. Tämä saadaan Gameloop-luokan metodin kautta.
     *
     * @param contentPane sisältö, johon lisätään halutut komponentit.
     */
    private void createComponents(Container contentPane) {
        contentPane.add(this.gameboardDrawer);
        frame.addKeyListener(new InputListener(this.gameclass.getGameboard(), this.gameboardDrawer));

    }

    public GameboardDrawer getDrawedGameboard() {
        return gameboardDrawer;
    }

    public Gameloop getGame() {
        return this.gameclass;
    }

}
