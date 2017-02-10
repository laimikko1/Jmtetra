
package jmtetra.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import jmtetra.gameloop.Gameloop;

/**
 * Tämä luokka vastaa siitä, että pelilauta piirretään ja päivitetään aina
 * tarvittaessa uudelleen. Se perii JPanel-luokan.
 * @author mikko
 * 
 */
public class GameboardDrawer extends JPanel {

    private Gameloop gameclass;

    
    /**
     * Saa parametrina Gameloop-luokan, jonka pelilaudan pohjalta piirretään
     * pelikuva graafisena.
     * 
     * @param gameclass 
     */
    public GameboardDrawer(Gameloop gameclass) {
        this.gameclass = gameclass;
    }

    
    /**
     * Tämä luokka vastaa piirtämisestä. Se käyttää siinä hyödykseen GameLoop-luokan sisältämää
     * pelilautaa, jonka pohjalta uusi pelikuva päivitetään. Parametrina toimii myös Graphics-olio,
     * jolle tarvittavat arvot annetaan.
     * 
     * @param g 
     */
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
    
    /**
     * Tämä metodi vastaa siitä, että jokaisen GameLoop-luokan välittämän
     * char [][] -tyyppisen pelilaudan kirjaimet saavat  oikean värin palautusarvona.
     * Parametreina tulee x- ja y-koordinaatti, jonka pohjalta haetaan tarkasteltava
     * char-muuttuja pelilaudan metodin kautta.
     * 
     * @param y
     * @param x
     * 
     * @see Gameboard.getChar(int y, int x)
     * @see Gameloop.getGameboard()
     * 
     * @return Color haluttu väri
     */
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

    /**
     * Tämä metodi asettaa uudelleenpiirtämisen jonoon.
     * 
     */

    public void update() {
        repaint();
    }
}
