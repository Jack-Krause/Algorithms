package test.dp;

import core.Algorithm;
import dp.BottomUpLCS;
import dp.LCSInput;

public class BottomUpLCSTest extends AbstractLCSTest {

    @Override
    protected Algorithm<LCSInput, Integer> alg() {
        return new BottomUpLCS();
    }


}
