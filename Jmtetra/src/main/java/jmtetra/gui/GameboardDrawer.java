package jmtetra.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    private BufferedImage image;
    private int drawTileNumber;

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
            image = ImageIO.read(new File(System.getProperty("user.home") + "/Jmtetra/Jmtetra/src/main/resources/blue.jpg"));
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
        Font myFont = new Font("SansSerif", Font.BOLD, 10);
        g.setFont(myFont);
        g.setColor(Color.WHITE);
        drawInstructions(g);
        drawGameStatistics(g);
        for (int y = 0; y < gameclass.getGameboard().getHeight(); y++) {
            for (int x = 0; x < gameclass.getGameboard().getWidth(); x++) {
                Color c = setCharacterColors(y, x);
                g.setColor(setCharacterColors(y, x));
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
        g.setFont(new Font("SansSerif", Font.BOLD, 15));
        g.drawString("Points: " + this.gameclass.getPoints(), 6, 470);
        g.drawString("Level: " + this.gameclass.getLevel(), 6, 500);
        g.drawString("Rows: " + this.gameclass.getRowsDestroyed(), 6, 530);
    }

    private void drawInstructions(Graphics g) {
        g.drawString("CONTROLS", 6, 200);
        g.drawString("Left arrow - Move left", 8, 230);
        g.drawString("Right arrow - Move right", 8, 250);
        g.drawString("Down arrow - Move down", 8, 280);
        g.drawString("Space - Drop down", 8, 310);
        g.drawString("Z - Rotate counterclockwise", 8, 330);
        g.drawString("X - Rotate clockwise", 8, 350);
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
            return new Color(230,230,250);

        }

        if (c == 'K') {
            return new Color(230,230,250);

        }

        if (c == 'L') {
            return new Color(230,230,250);

        }

        if (c == 'O') {
            return new Color(135,206,250);

        }

        if (c == 'T') {
            return new Color(135,206,250);

        }

        if (c == 'Z') {
            return new Color(135,206,250);

        }

        if (c == 'X') {
            return new Color(135,206,250);

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
