package jmtetra.main;

import javax.swing.SwingUtilities;
import jmtetra.gameloop.Gameloop;
import jmtetra.gui.GameInterface;

/**
 * Main-luokka luo Gameloop-luokan, kutsuu käyttöliittymää ja käynnistää pelin.
 *
 * @author mikko
 */
public class Main {

    /**
     * Käynnistää uuden pelin.
     * @param args jokin mystinen mainin parametri
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        Gameloop gc = new Gameloop();
        GameInterface g = new GameInterface(gc);

        SwingUtilities.invokeLater(g);
        gc.start();

//        
    }

}
