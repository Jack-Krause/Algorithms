package dp;

import core.Algorithm;

import java.util.Arrays;

public class MemoizedRodCutting implements Algorithm<MemoizedRodCutting.Input, Integer> {


    // special input conforming to the Algorithm interface for Rod-Cutting problems
    public static record Input(int[] prices, int n) {}


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

    /**
     * Top-down memoized implementation of the Rod-Cut algorithm
     * @param input input = (int[] p, int n)
     * @return int of optimal revenue
     */
    private int memoizedRodCut(Input input) {
        int[] p = input.prices;
        int n = input.n;

        int[] r = new int[n];
        Arrays.fill(r, Integer.MIN_VALUE);

        return memoizedRodCutAux(p, n, r);
    }


    private int memoizedRodCutAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) return r[n];

        int q = Integer.MIN_VALUE;
        if (n == 0) q = 0;

        for (int i = 1; i < n; i++) {
            q = Math.max(
                    q,
                    p[i] + memoizedRodCutAux(p, n-i, r)
            );
        }

        r[n] = q;
        return q;
    }



}
