package test.dp;

import core.Algorithm;
import dp.RodCutInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractRodCuttingTest {

//    protected abstract Algorithm<MemoizedRodCutting.Input, Integer> rcAlg();
    protected abstract Algorithm<RodCutInput, Integer> rcAlg();

    @Test void zeroTest() {
        var input = new RodCutInput(new int[]{0}, 0);
        assertEquals(0, rcAlg().run(input));
    }

    @Test void singleTest() {
        var input = new RodCutInput(new int[]{0, 7}, 1);
        assertEquals(7, rcAlg().run(input));
    }

    @Test void clrsTest() {
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] exp = {0, 1, 5, 8, 10, 13, 17, 18, 22, 25, 30};
        int n = p.length;

        for (int i = 0; i < n; i++) {
            assertEquals(
                    exp[i],
                    rcAlg().run(
                            new RodCutInput(p, i)
                    )
            );
        }
    }



}
