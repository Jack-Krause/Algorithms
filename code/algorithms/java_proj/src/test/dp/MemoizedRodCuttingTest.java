package test.dp;

import core.Algorithm;
import dp.MemoizedRodCutting;

public class MemoizedRodCuttingTest extends AbstractRodCuttingTest {

    @Override
    protected Algorithm<MemoizedRodCutting.Input, Integer> rcAlg() {
        return new MemoizedRodCutting();
    }
}
