package dp;

import core.Algorithm;

import java.util.List;

public class RodCutting implements Algorithm<RodCutting.Input, Integer> {

    /**
     * Calls RodCutting methods, returning an int result for now.
     * @param input int[] of prices for i = 0 to n
     * int n length of rod
     * @return integer of optimal revenue from cuts (modify to return the specific cuts)
     */
    @Override
    public Integer run(Input input) {
        return 0;
    }

    // special input conforming to the Algorithm interface for Rod-Cutting problems
    public static record Input(int[] prices, int n) {}



}
