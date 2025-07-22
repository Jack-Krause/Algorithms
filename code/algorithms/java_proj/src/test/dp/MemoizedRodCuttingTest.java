package test.dp;

import core.Algorithm;
import dp.MemoizedRodCutting;
import dp.RodCutInput;

public class MemoizedRodCuttingTest extends AbstractRodCuttingTest {

    @Override
    protected Algorithm<RodCutInput, Integer> rcAlg() {
        return new MemoizedRodCutting();
    }
}
