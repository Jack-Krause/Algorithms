package dp;

import core.Algorithm;

import java.util.Arrays;

public class BottomUpRodCutting implements Algorithm<RodCutInput, Integer> {


    @Override
    public Integer run(RodCutInput input) {
        return bottomUpRodCut(input);
    }


    private int bottomUpRodCut(RodCutInput input) {
        int n = input.n();
        int[] r = new int[n + 1];
        int[] p = input.prices();

        Arrays.fill(r, 0);

        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;

            for (int i = 1; i <= j; i++) {
                q = Math.max(
                        q,
                        p[i] + r[j - i]
                );
            }

            r[j] = q;
        }

        return r[n];
    }


}
