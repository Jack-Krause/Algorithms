package test.dp;

import core.Algorithm;
import dp.RodCutInput;
import dp.BottomUpRodCutting;

public class BottomUpRodCuttingTest extends AbstractRodCuttingTest {
    /**
     * @return
     */
    @Override
    protected Algorithm<RodCutInput, Integer> rcAlg() {
        return new BottomUpRodCutting();
    }
}
