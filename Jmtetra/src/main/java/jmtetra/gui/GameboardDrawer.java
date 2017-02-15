package jmtetra.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import jmtetra.gameloop.Gameloop;

/**
 * Tämä luokka vastaa siitä, että pelilauta piirretään ja päivitetään aina
 * tarvittaessa uudelleen. Se perii JPanel-luokan.
 *
 * @author mikko
 *
 */
public class GameboardDrawer extends JPanel {
    
    private Gameloop gameclass;

    /**
     * Saa parametrina Gameloop-luokan, jonka pelilaudan pohjalta piirretään
     * pelikuva graafisena.
     *
     * @param gameclass peliluokka, jonka kanssa piirtoluokka toimii yhdessä.
     */
    public GameboardDrawer(Gameloop gameclass) {
        this.gameclass = gameclass;
    }

    /**
     * Tämä luokka vastaa piirtämisestä. Se käyttää siinä hyödykseen
     * GameLoop-luokan sisältämää pelilautaa, jonka pohjalta uusi pelikuva
     * päivitetään. Parametrina toimii myös Graphics-olio, jolle tarvittavat
     * arvot annetaan.
     *
     * @param g Graphic-luokan ilmentymä, johon piirtäminen tehdään.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font myFont = new Font("Serif", Font.PLAIN, 20);
        g.setFont(myFont);
        g.drawString("Points: " + this.gameclass.getPoints(), 4, 615);
        g.drawString("Level: " + this.gameclass.getLevel(), 4, 650);
        g.drawString("Rows: " + this.gameclass.getRowsDestroyed(), 4, 580);
        for (int y = 0; y < gameclass.getGameboard().getHeight(); y++) {
            for (int x = 0; x < gameclass.getGameboard().getWidth(); x++) {
                Color c = setCharacterColors(y, x);
                g.setColor(setCharacterColors(y, x));
                int drawx = x + 8;
                int drawy = y + 3;
                if (c != Color.GRAY) {
                    g.fill3DRect(drawx * 33, drawy * 33, 33, 33, true);
                } else {
                    g.fillRect(drawx * 33, drawy * 33, 33, 33);
                }
                
            }
        }
        
    }

    /**
     * Tämä metodi vastaa siitä, että jokaisen GameLoop-luokan välittämän char
     * [][] -tyyppisen pelilaudan kirjaimet saavat oikean värin palautusarvona.
     * Parametreina tulee x- ja y-koordinaatti, jonka pohjalta haetaan
     * tarkasteltava char-muuttuja pelilaudan metodin kautta.
     *
     * @param y koordinaatti, Int arvo, jonka käyttäjä antaa
     * @param x koordinaatti, Int arvo, jonka käyttäjä antaa
     *
     * @see jmtetra.tetralogic.Gameboard#getChar(int, int)
     * @see jmtetra.gameloop.Gameloop#getGameboard()
     *
     * @return Color haluttu väri merkille
     */
    public Color setCharacterColors(int y, int x) {
        char c = gameclass.getGameboard().getChar(y, x);
        if (c == 'I') {
            return Color.CYAN;
        }
        
        if (c == 'K') {
            return Color.BLUE;
        }
        
        if (c == 'L') {
            return Color.ORANGE;
        }
        
        if (c == 'O') {
            return Color.YELLOW;
        }
        
        if (c == 'T') {
            return Color.MAGENTA;
        }
        
        if (c == 'Z') {
            return Color.GREEN;
        }
        
        if (c == 'X') {
            return Color.RED;
        }
        
        return Color.GRAY;
        
    }

    /**
     * Tämä metodi asettaa uudelleenpiirtämisen jonoon.
     *
     */
    public void update() {
        repaint();
    }
}
