package jmtetra.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import jmtetra.gameloop.Gameloop;
import jmtetra.tetralogic.Piece;

/**
 * Tämä luokka vastaa siitä, että pelilauta piirretään ja päivitetään aina
 * tarvittaessa uudelleen. Se perii JPanel-luokan.
 *
 * @author mikko
 *
 */
public class GameboardDrawer extends JPanel {

    private Gameloop gameclass;
    private BufferedImage image;

    /**
     * Saa parametrina Gameloop-luokan, jonka pelilaudan pohjalta piirretään
     * pelikuva graafisena.
     *
     * @param gameclass peliluokka, jonka kanssa piirtoluokka toimii yhdessä.
     */
    public GameboardDrawer(Gameloop gameclass) {
        this.gameclass = gameclass;
        image = null;
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("blue.jpg");
            image = ImageIO.read(is);
        } catch (IOException e) {
        }
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
        g.drawImage(this.image, 0, 0, null);
        Font myFont = new Font("SansSerif", Font.BOLD, 18);
        g.setFont(myFont);
        g.setColor(Color.WHITE);
        drawInstructions(g);
        drawGameStatistics(g);
        drawGameboard(g);
        drawNextPiece(g);
    }

    private void drawGameboard(Graphics g) {
        for (int y = 0; y < gameclass.getGameboard().getHeight(); y++) {
            for (int x = 0; x < gameclass.getGameboard().getWidth(); x++) {
                Color c = setCharacterColors(gameclass.getGameboard().getChar(y, x));
                g.setColor(c);
                int drawx = x + 8;
                int drawy = y + 3;
                if (c == Color.WHITE) {
                    g.draw3DRect(drawx * 30, drawy * 30, 30, 30, true);
                } else {
                    g.fill3DRect(drawx * 30, drawy * 30, 30, 30, true);
                }

            }
        }
    }

    private void drawGameStatistics(Graphics g) {
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("Points: " + this.gameclass.getPoints(), 8, 420);
        g.drawString("Level: " + this.gameclass.getLevel(), 8, 470);
        g.drawString("Rows: " + this.gameclass.getRowsDestroyed(), 8, 520);
    }

    private void drawInstructions(Graphics g) {
        g.drawString("CONTROLS", 6, 110);
        Font myFont = new Font("SansSerif", Font.BOLD, 14);
        g.setFont(myFont);
        g.drawString("Left arrow - Move left", 8, 150);
        g.drawString("Right arrow - Move right", 8, 190);
        g.drawString("Down arrow - Move down", 8, 230);
        g.drawString("Space - Drop down", 8, 270);
        g.drawString("Z - Rotate counterclockwise", 8, 310);
        g.drawString("X - Rotate clockwise", 8, 350);
    }

    private void drawNextPiece(Graphics g) {
        int drawY = 5;
        int drawX = 16;
        g.setColor(Color.white);
        g.drawString("NEXT PIECE", 570, 110);

        for (Piece p : this.gameclass.getNextPiece().getPieces()) {
            int drawY2 = p.getY() + drawY;
            int drawX2 = p.getX() + drawX;
            g.setColor(setCharacterColors(p.getMark()));

            g.fill3DRect(drawX2 * 30, drawY2 * 30, 30, 30, true);
        }
    }

    /**
     * Tämä metodi vastaa siitä, että jokaisen GameLoop-luokan välittämän char
     * [][] -tyyppisen pelilaudan kirjaimet saavat oikean värin palautusarvona.
     * Parametreina tulee x- ja y-koordinaatti, jonka pohjalta haetaan
     * tarkasteltava char-muuttuja pelilaudan metodin kautta.
     *
     * @param c char merkki, jonka pohjalta väri määritetään
     *
     * @see jmtetra.tetralogic.Gameboard#getChar(int, int)
     * @see jmtetra.gameloop.Gameloop#getGameboard()
     *
     * @return Color haluttu väri merkille
     */
    public Color setCharacterColors(char c) {
        if (c == 'I') {
            return new Color(0, 255, 255);

        }

        if (c == 'K') {
            return new Color(255, 0, 0);

        }

        if (c == 'L') {
            return new Color(0, 0, 255);

        }

        if (c == 'O') {
            return new Color(255, 255, 0);

        }

        if (c == 'T') {
            return new Color(153, 0, 153);

        }

        if (c == 'Z') {
            return new Color(255, 0, 0);

        }

        if (c == 'X') {
            return new Color(153, 255, 153);

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

    public Gameloop getGameclass() {
        return gameclass;
    }

}
