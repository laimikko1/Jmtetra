/**
 * Luokka vastaa peliloopin pyörittämisestä
 * saaden parametreina pelilaudan ja pelilaudan
 * piirtämisestä vastaavan luokan.
 *
 * Luokalla on myös ActionListener, jonka rajapintaa luokka käyttää. Tämän avulla
 * saadaan käyttöön käyttäjän syötteiden lukeminen.
 * Luokalla on myös Timer, jonka avulla itse looppi toimii,
 * jatkuvasti laskien pelattavan olevaa palaa alaspäin.
 *
 *
 * @author mikko
 *
 */
package jmtetra.gameloop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.Timer;

import jmtetra.gui.GameboardDrawer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import jmtetra.tetralogic.Gameboard;
import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.TetronomeRaffler;
import jmtetra.tetralogic.tetronomes.Tetronome;

public class Gameloop extends Timer implements ActionListener {

    private GameboardDrawer drawedGameboard;
    private Gameboard gameboard;
    private int rowsDestroyed;
    private int points;
    private int level;
    private int velocity;
    private Tetronome nextPiece;
    private TetronomeRaffler tetronomeRaffler;

    /**
     * Konstruktori luo uuden peliloopin. Ensin käytetään perittävän
     * Timer-luokan konstruktoria, asettaen väliksi 1000 millisekuntia. Tämän
     * jälkeen alustetaan muut tarvittavat työkalut, sekä lisätään
     * ActionListener ja asetetaan aluksi sekunnin viive.
     */
    public Gameloop() {
        super(1000, null);
        this.gameboard = new Gameboard();
        this.tetronomeRaffler = new TetronomeRaffler(new Random());
        this.gameboard.addTetronome(this.tetronomeRaffler.returnNewTetronome());
        this.nextPiece = this.tetronomeRaffler.returnNewTetronome();
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
     * Tämä metodi mahdollistaa sen että peliloopin piirtoluokka vastaa
     * käyttöliittymässä luotua. Toisin kuin DrawedGameboard-luokassa, jossa
     * Gameloop luokka annetaan jo konstruktorissa parametrina
     *
     * @see DrawedGameboard(Gameloop gameclass)
     *
     * @param drawedGameboard piirtoalusta, jolle peli piirretään
     */
    /**
     * Perus setteri, mutta käytännössä käytetään aina. Asetetaan pelilauta,
     * johon pelilooppi tuottaa logiikan, jonka pelilauta piirtää ja näyttää
     * pelaajalle.
     *
     * @param drawedGameboard pelilauta, joka joka toimii yhteistyössä
     * peliloopin kanssa
     */
    public void setDrawboard(GameboardDrawer drawedGameboard) {
        this.drawedGameboard = drawedGameboard;
    }

    public GameboardDrawer getDrawedGameboard() {
        return drawedGameboard;
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
            try {
                checkIfGameIsOver();
            } catch (IOException ex) {
                Logger.getLogger(Gameloop.class.getName()).log(Level.SEVERE, null, ex);
            }
            rowsDestroyedThisRound = updateTotalRows(rowsDestroyedThisRound);
            updateStatistics(rowsDestroyedThisRound);
            this.gameboard.addTetronome(nextPiece);
            nextPiece = this.tetronomeRaffler.returnNewTetronome();
        } else {
            this.gameboard.updateBoard(gameboard.getCurTetro().moveDown());
        }
        if (rowsDestroyedThisRound > 0) {
            createAdelayForDestroyedRows();
        }

        this.drawedGameboard.update();
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

    private void checkIfGameIsOver() throws IOException {
        if (this.gameboard.isGameOver()) {

            JOptionPane pane = new JOptionPane("It seems your game is over.\nPoints: " + this.points + "\nPlay again?", JOptionPane.YES_NO_OPTION);
            pane.setOptionType(JOptionPane.YES_NO_OPTION);
            JDialog dialog = pane.createDialog("Game over");

           

            dialog.show();

            if ((Integer) pane.getValue() == 1) {
                System.exit(0);
            } else if ((Integer) pane.getValue() == 0) {
                Runtime.getRuntime().exec("java -jar Jmtetra.jar");
                System.exit(0);
            }
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

    private void updateVelocity() {
        velocity *= 0.8;
        super.setDelay(velocity);
    }

    /**
     * This method is solemly responsible for increasing the players points when
     * he moves down.
     *
     */
    public void addOnePointForMovingDown() {
        this.points++;
    }

    public Tetronome getNextPiece() {
        return nextPiece;
    }

}
