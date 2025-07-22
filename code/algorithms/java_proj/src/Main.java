import core.EntropyUtil;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double alpha = 0.85;
        int[][] testCases = {
                {},
                {5,5,5,5,5,5,5,5,5,5},
                {1,2,3,4,5,6,7,8,9,10},
                {10,9,8,7,6,5,4,3,2,1},
                {3,7,1,9,2,8,6,4,5,0},
                {1,1,1,1,1,2,2,2,3,3},
                {1,2,3,4,5,10,9,8,7,6},
                {1,2,1,2,1,2,1,2,1,2}
        };

        for (int[] arr : testCases) {
            System.out.printf("Input: %-25s  ", Arrays.toString(arr));
            boolean pickDist = EntropyUtil.shouldUseDistributionSort(arr, alpha);
            System.out.printf("→ useDistSort? %s%n", pickDist ? "YES" : "no");
        }
    }
}