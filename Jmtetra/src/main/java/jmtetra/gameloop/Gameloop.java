/**
 * Luokka vastaa peliloopin pyörittämisestä
 * saaden parametreina pelilaudan ja pelilaudan
 * piirtämisestä vastaavan luokan.
 *
 * Luokalla on myös ActionListener, jonka avulla
 * se suorittaa käyttäjän antamia toimintoja,
 * sekä Timer, jonka avulla itse looppi toimii,
 * jatkuvasti laskien pelattavan olevaa palaa alaspäin.
 *
 *
 * @author mikko
 *
 */
package jmtetra.gameloop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.Timer;

import jmtetra.gui.GameboardDrawer;
import java.util.logging.Level;
import java.util.logging.Logger;
import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.SquareShape;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import jmtetra.tetralogic.tetronomes.ZshapeLeft;
import jmtetra.tetralogic.tetronomes.ZshapeRight;

public class Gameloop extends Timer implements ActionListener {

    private ArrayList<Tetronome> pieces;
    private GameboardDrawer drawedGameboard;
    private Gameboard gameboard;
    private int rowsDestroyed;
    private int points;
    private int level;
    private int velocity;
    private Tetronome nextPiece;
    /**
     * Konstruktori luo uuden peliloopin. Ensin käytetään perittävän
     * Timer-luokan konstruktoria, asettaen väliksi 1000 millisekuntia. Tämän
     * jälkeen alustetaan muut tarvittavat työkalut, sekä lisätään
     * ActionListener ja asetetaan aluksi sekunnin viive.
     */
    public Gameloop() {
        super(1000, null);
        updatePieces();
        this.gameboard = new Gameboard();
        Collections.shuffle(this.pieces);
        this.gameboard.addTetronome(this.pieces.get(0));
        this.nextPiece = this.pieces.get(1);
        this.points = 0;
        this.level = 0;
        this.rowsDestroyed = 0;
        this.velocity = 1000;

        addActionListener(this);
    }

    public Gameboard getGameboard() {
        return this.gameboard;
    }

    /**
     * Tämä metodi vastaa siitä että luodaan lista, jossa ovat kaikki
     * mahdolliset Tetris-pelin palat. Lista luo jokaisesta palasta uuden
     * ilmentymän.
     *
     *
     */
    private void updatePieces() {
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
     * Tämä metodi mahdollistaa sen että peliloopin piirtoluokka vastaa
     * käyttöliittymässä luotua. Toisin kuin DrawedGameboard-luokassa, jossa
     * Gameloop luokka annetaan jo konstruktorissa parametrina
     *
     * @see DrawedGameboard(Gameloop gameclass)
     *
     * @param drawedGameboard piirtoalusta, jolle peli piirretään
     */
    public void setDrawboard(GameboardDrawer drawedGameboard) {
        this.drawedGameboard = drawedGameboard;
    }

    /**
     * Tämä metodi on pelilooppi, joka pyörittää Tetris-peliä. Se saa
     * parametrina ActionEvent-luokan ilmentymän, jonka avulla tehdään haluttu
     * toiminto.
     *
     * Se myös hyödyntää pelilaudan metodeja, tarkistaakseen onko kierros loppu
     * ja lisää kyseisessä tapauksessa uuden palan hyödyntäen Random-luokkaa.
     *
     * @see Gameboard.addTetronome(Tetronome t)
     * @see Gameboard.isRoundOver()
     * @see Gameboard.updateBoard(Piece[] pieces)
     * @see DrawedGameboard.update()
     *
     * @param e tapahtuma, joka toteutetaan
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowsDestroyedThisRound = 0;

        if (this.gameboard.isRoundOver()) {
            checkIfGameIsOver();
            rowsDestroyedThisRound = updateTotalRows(rowsDestroyedThisRound);
            updateStatistics(rowsDestroyedThisRound);
            this.gameboard.addTetronome(nextPiece);
            updatePieces();
            nextPiece = this.pieces.get(new Random().nextInt(7));
        } else {
            this.gameboard.updateBoard(gameboard.getCurTetro().moveDown());
        }
        if (rowsDestroyedThisRound > 0) {
            createAdelayForDestroyedRows();
        }

        this.drawedGameboard.update();

        setDelay(velocity);
    }

    private void updateStatistics(int rowsDestroyedThisRound) {
        updatePoints(rowsDestroyedThisRound);
        updatelevel();
    }

    private void createAdelayForDestroyedRows() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gameloop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int updateTotalRows(int rowsDestroyedThisRound) {
        rowsDestroyedThisRound = this.gameboard.checkAllRowsForFullOnes();
        rowsDestroyed += rowsDestroyedThisRound;
        return rowsDestroyedThisRound;
    }

    private void checkIfGameIsOver() {
        if (this.gameboard.isGameOver()) {
            System.exit(0);
        }
    }

    private void updatePoints(int rows) {
        if (rows == 1) {
            calculatePoints(rows, 40);
        }

        if (rows == 2) {
            calculatePoints(rows, 100);
        }

        if (rows == 3) {
            calculatePoints(rows, 300);
        }

        if (rows >= 4) {
            calculatePoints(rows, 1200);
        }

    }

    private void calculatePoints(int rows, int multiplier) {
        points += (rows * (multiplier * (level + 1)));
    }

    private void updatelevel() {
        if (rowsDestroyed >= 10 && rowsDestroyed % ((level + 1) * 10) == 0) {
            level++;
            updateVelocity();

        }
    }

    public int getPoints() {
        return points;
    }

    public int getRowsDestroyed() {
        return rowsDestroyed;
    }

    public int getLevel() {
        return level;
    }

    private int updateVelocity() {
        return velocity *= 0.8;
    }
/**
 * This method is solemly responsible for increasing the players points when he moves down.
 *
 */
    public void addOnePointForMovingDown() {
        this.points++;
    }

    public Tetronome getNextPiece() {
        return nextPiece;
    }

}
