/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import jmtetra.tetralogic.Gameboard;

/**
 * Luokka vastaa siitä että käyttäjän antamat syötteet kuunnellaan ja
 * toteutetaan.
 *
 * @author mikko
 */
public class InputListener implements KeyListener {

    private Gameboard gameboard;
    private GameboardDrawer gameboardDrawer;

    /**
     * Keylistener-luokka saa parametrinaan char[][] tyyppisen pelilaudan, johon
     * tehdään muutoksia, kun käyttäjän antama komento rekisteröidään.
     *
     * @param gameboard pelilauta jolle keyListener välittää päivitykset.
     * @param gameboardDrawer pelilaudan piirtäjä välitetään myös. Tämä on
     * tarpeellista, jotta käyttäjän antamat toiminnot, kuten käännökset ja
     * liikkuminen alaspäin päivittyvät "realiajassa", eivätkä vasta kun
     * seuraavan kerran liikutaan automaattisesti alas gameloop-luokan antaman
     * komennon toimesta
     */
    public InputListener(Gameboard gameboard, GameboardDrawer gameboardDrawer) {
        this.gameboard = gameboard;
        this.gameboardDrawer = gameboardDrawer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metodi vastaa siitä, että jokainen käyttäjän komento suoritetaan oikein.
     * Se hyödyntää parametrina saamaansa Gameboard-luokkaa, jonka metodeilla
     * muutokset tehdään.
     *
     * @see jmtetra.tetralogic.Gameboard#updateBoard(Piece[])
     * @see jmtetra.tetralogic.tetronomes.Tetronome#moveDown()
     * @see jmtetra.tetralogic.tetronomes.Tetronome#moveLeftOrRight(int)
     * @see jmtetra.tetralogic.tetronomes.Tetronome#isRoundOver()
     * @param e tapahtuma, joka halutaan toteuttaa
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.gameboard.updateBoard(this.gameboard.getCurTetro().moveLeftOrRight(-1));
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.gameboard.updateBoard(this.gameboard.getCurTetro().moveLeftOrRight(1));
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.gameboard.updateBoard(this.gameboard.getCurTetro().moveDown());
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) {
            this.gameboard.updateBoard(this.gameboard.getCurTetro().moveClockOrCounterClockWise(-1));
        }

        if (e.getKeyCode() == KeyEvent.VK_X) {
            this.gameboard.updateBoard(this.gameboard.getCurTetro().moveClockOrCounterClockWise(1));
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            while (!this.gameboard.isRoundOver()) {
                this.gameboard.updateBoard(this.gameboard.getCurTetro().moveDown());
            }
        }
        this.gameboardDrawer.update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
