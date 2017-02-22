/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmtetra.tetralogic.tetronomes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import jmtetra.tetralogic.TetronomeRaffler;
import jmtetra.tetralogic.Type;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class TetronomeRafflerTest {

    private TetronomeRaffler raffler;
    private RandomStubb stubb;

    public TetronomeRafflerTest() {
        this.stubb = new RandomStubb(0, 1, 2, 3, 4, 5, 6);
        this.raffler = new TetronomeRaffler(stubb);
    }

    @Test
    public void rafflerReturnsCorrectTetronomes() {

        assertEquals(raffler.returnNewTetronome().getType(), Type.Ishape);
        assertEquals(raffler.returnNewTetronome().getType(), Type.LshapeLeft);
        assertEquals(raffler.returnNewTetronome().getType(), Type.LshapeRight);
        assertEquals(raffler.returnNewTetronome().getType(), Type.Squareshape);
        assertEquals(raffler.returnNewTetronome().getType(), Type.Tshape);
        assertEquals(raffler.returnNewTetronome().getType(), Type.ZshapeLeft);
        assertEquals(raffler.returnNewTetronome().getType(), Type.ZshapeRight);

    }
}

class RandomStubb extends Random {

    List<Integer> numbers;

    public RandomStubb(Integer... luvut) {
        numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(luvut));
    }

    @Override
    public int nextInt(int bound) {
        return numbers.remove(0);
    }

}
