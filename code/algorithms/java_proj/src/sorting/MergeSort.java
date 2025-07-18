package sorting;

import core.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>>
    implements Algorithm<List<T>, List<T>> {
    /**
     * Performs the MergeSort algorithm on a list of type T
     * @param input List to sort
     * @return sorted list of type T
     */
    @Override
    public List<T> run(List<T> input) {
        List<T> copy = new ArrayList<>(input);
        mergeSortRec(copy, 0, copy.size() - 1);
        return copy;
    }

    private void mergeSortRec(List<T> input, int low, int high) {
        if (low < high) {
            // find the middle
            int mid = low + (high - low) / 2;

            // sort each half
            mergeSortRec(input, low, mid);
            mergeSortRec(input, mid + 1 , high);

            // merge sorted halves
            merge(input, low, mid, high);
        }

    }

    private void merge(List<T> input, int low, int mid, int high) {

        List<T> left = new ArrayList<>(input.subList(low, mid + 1));
        List<T> right = new ArrayList<>(input.subList(mid + 1, high + 1));

        int i = 0;
        int j = 0;
        int k = low;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                input.set(k, left.get(i));
                i++;
            } else {
                input.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            input.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            input.set(k, right.get(j));
            j++;
            k++;
        }
    }

}
