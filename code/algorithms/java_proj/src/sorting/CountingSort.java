package sorting;

import core.Algorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class CountingSort<T extends Comparable<? super T>>
    implements Algorithm<List<Integer>, List<Integer>> {

    @Override
    public List<Integer> run(List<Integer> input) {
        if (! input.isEmpty()) {
            ArrayList<Integer> copy = new ArrayList<>(input);
            return countingSort(copy);
        }
        return List.of();
    }


    private static ArrayList<Integer> countingSort(List<Integer> arr) {
        int n = arr.size();
        int max = Collections.max(arr);
        System.out.println("Max is: " + max);
        int min = Collections.min(arr);
        int k = max - min + 1;
        int[] counts = new int[max + 1];
        // count frequency of each element
        for (int i = 0; i < n; i++) {
            counts[ arr.get(i) ]++;
        }
        // compute prefix sum
        for (int i = 1; i <= k; i++) {
            counts[i] += counts[i - 1];
        }
        // build output array
        int[] out = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            out[counts[arr.get(i)] - 1] = arr.get(i);
            counts[arr.get(i)]--;
        }

        // convert to arraylist
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : out) {
            res.add(x);
        }
        return res;
    }
}
