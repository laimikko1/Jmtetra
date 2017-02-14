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
 * @author Mikko
 * 
 */
package jmtetra.gameloop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import jmtetra.gui.GameboardDrawer;
import java.util.Random;
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
    private boolean roundIsOver;
    private boolean gameIsOver;
    private GameboardDrawer drawedGameboard;
    private Gameboard gameboard;
    private Random random;

    /**
     * Konstruktori luo uuden peliloopin. Ensin käytetään perittävän
     * Timer-luokan konstruktoria, asettaen väliksi 1000 millisekuntia.
     * Tämän jälkeen alustetaan muut tarvittavat työkalut, sekä lisätään
     * ActionListener ja asetetaan aluksi sekunnin viive.
     */
    
    
    public Gameloop() {
        super(1000, null);
        createListOfPieces();
        this.roundIsOver = false;
        this.gameIsOver = false;
        this.gameboard = new Gameboard();
        this.gameboard.addTetronome(this.pieces.get(0));
        this.random = new Random();

        addActionListener(this);
        setInitialDelay(1000);
    }

    
    public Gameboard getGameboard() {
        return this.gameboard;
    }

    
    /**
     * Tämä metodi vastaa siitä että luodaan lista, jossa ovat kaikki mahdolliset Tetris-pelin
     * palat. Lista luo jokaisesta palasta uuden ilmentymän.
     * 
     * @see Tetronome
     */

    private void createListOfPieces() {
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
     * Tämä metodi mahdollistaa sen että peliloopin piirtoluokka vastaa käyttöliittymässä luotua.
     * Toisin kuin DrawedGameboard-luokassa, jossa Gameloop luokka annetaan jo konstruktorissa parametrina
     * 
     * @see DrawedGameboard(Gameloop gameclass)
     *
     * @param drawedGameboard 
     */

    public void setDrawboard(GameboardDrawer drawedGameboard) {
        this.drawedGameboard = drawedGameboard;
    }

    
    /**
     * Tämä metodi on pelilooppi, joka pyörittää Tetris-peliä.
     * Se saa parametrina ActionEvent-luokan ilmentymän, jonka avulla tehdään haluttu toiminto.
     * 
     * Se myös hyödyntää pelilaudan metodeja, tarkistaakseen onko kierros loppu ja lisää kyseisessä tapauksessa uuden palan
     * hyödyntäen Random-luokkaa.
     * 
     * @see Gameboard.addTetronome(Tetronome t)
     * @see Gameboard.isRoundOver()
     * @see Gameboard.updateBoard(Piece[] pieces)
     * @see DrawedGameboard.update()
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.gameboard.isRoundOver()) {
            this.gameboard.checkAllRowsForFullOnes();
            createListOfPieces();
            this.gameboard.addTetronome(pieces.get(this.random.nextInt(7)));
            
        } else {
            this.gameboard.updateBoard(gameboard.getCurTetro().moveDown());
        }

        this.drawedGameboard.update();
        setDelay(1000);

    }

}
