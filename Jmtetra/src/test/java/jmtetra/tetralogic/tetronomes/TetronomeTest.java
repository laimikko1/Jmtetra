/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import jmtetra.tetralogic.Piece;
import jmtetra.tetralogic.tetronomes.Ishape;
import jmtetra.tetralogic.tetronomes.LshapeLeft;
import jmtetra.tetralogic.tetronomes.LshapeRight;
import jmtetra.tetralogic.tetronomes.Squareshape;
import jmtetra.tetralogic.tetronomes.SshapeLeft;
import jmtetra.tetralogic.tetronomes.SshapeRight;
import jmtetra.tetralogic.tetronomes.Tetronome;
import jmtetra.tetralogic.tetronomes.Tshape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laimikko
 */
public class TetronomeTest {

    private Tetronome tetronome;

    public TetronomeTest() {
        this.tetronome = new Tshape(new Piece[4]);
    }
    
    @Test
    public void allShapesInitialize() {
        Piece[] n = new Piece[4];
        assertNotNull(this.tetronome = new Ishape(n));
        assertNotNull(this.tetronome = new Tshape(n));
        assertNotNull(this.tetronome = new LshapeLeft(n));
        assertNotNull(this.tetronome = new LshapeRight(n));
        assertNotNull(this.tetronome = new Squareshape(n));
        assertNotNull(this.tetronome = new SshapeLeft(n));
        assertNotNull(this.tetronome = new SshapeRight(n));
        
    
}

// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
}
