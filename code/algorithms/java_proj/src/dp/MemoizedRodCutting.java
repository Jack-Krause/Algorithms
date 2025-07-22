package dp;

import core.Algorithm;

import java.util.Arrays;

public class MemoizedRodCutting implements Algorithm<RodCutInput, Integer> {


    /**
     * @param input
     * @return
     */
    @Override
    public Integer run(RodCutInput input) {
        return memoizedRodCut(input);
    }


    /**
     * Top-down memoized implementation of the Rod-Cut algorithm
     * @param input input = (int[] p, int n)
     * @return int of optimal revenue
     */
    private int memoizedRodCut(RodCutInput input) {
        int[] p = input.prices();
        int n = input.n();

        if (n == 0) return 0;

        int[] r = new int[n + 1];
        Arrays.fill(r, Integer.MIN_VALUE);
        r[0] = 0;

        return memoizedRodCutAux(p, n, r);
    }


    private int memoizedRodCutAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) return r[n];

        int q = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            q = Math.max(
                    q,
                    p[i] + memoizedRodCutAux(p, n-i, r)
            );
        }

        r[n] = q;
        return q;
    }



}
