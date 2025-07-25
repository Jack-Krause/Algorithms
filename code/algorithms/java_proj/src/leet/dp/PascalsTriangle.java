package leet.dp;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {

    private static List<List<Integer>> generateTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0) return triangle;

        triangle.add(0, new ArrayList<>(Collections.singletonList(1)));

        for (int row = 1; row < numRows; row++) {
            List<Integer> prev = triangle.get(row - 1);
            // there are (row + 1) entries at each level (where row = depth = 0, 1, ...)
            List<Integer> curr = new ArrayList<>(row + 1);

            curr.add(1);
            for (int j = 1; j < row; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);

            triangle.add(row, curr);
        }

        return triangle;
    }


    public static void main(String[] args) {
        List<List<Integer>> t1 = generateTriangle(1);
        System.out.println(t1);
        System.out.println("exp: [1]");

        System.out.println(generateTriangle(5));
        System.out.println("exp: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]");
    }



}
