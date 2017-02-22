/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic;

import java.util.ArrayList;
import java.util.Random;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import jmtetra.tetralogic.tetronomes.ZshapeLeft;
import jmtetra.tetralogic.tetronomes.ZshapeRight;

/**
 * Luokka, joka arpoo Gameloop-luokalle seuraavat pelattavat palat.
 *
 * @author mikko
 */
public class TetronomeRaffler {

    private ArrayList<Tetronome> pieces;
    private Random drawer;

    /**
     * Luodaan uusi random, jonka avulla pala arvotaan, sekä annetaan ArrayList,
     * jossa palojen ilmentymiä pidetään. Random annetaan parametrina, jotta testaus helpottuu. Injektointi ftw!
     * @param random random-luokan ilmentymä, jonka avulla palat arvotaan
     */
    public TetronomeRaffler(Random random) {
        this.drawer = random;
        this.pieces = new ArrayList<>();
    }

    private void updateTetronomes() {
        this.pieces = new ArrayList();
        this.pieces.add(new Ishape(new Piece[4]));
        this.pieces.add(new LshapeLeft(new Piece[4]));
        this.pieces.add(new LshapeRight(new Piece[4]));
        this.pieces.add(new SquareShape(new Piece[4]));
        this.pieces.add(new Tshape(new Piece[4]));
        this.pieces.add(new ZshapeLeft(new Piece[4]));
        this.pieces.add(new ZshapeRight(new Piece[4]));

    }

    /**
     * Ensin kutsutaan updatePieces, joka päivittää palat (eli luo uudet). Tämän
     * otetaan indeksistä 0-6 pala ja palautetaan se.
     *
     * @return seuraavaksi peliin asetettava pala
     */
    public Tetronome returnNewTetronome() {
        updateTetronomes();
        return this.pieces.get(drawer.nextInt(7));
    }
}
