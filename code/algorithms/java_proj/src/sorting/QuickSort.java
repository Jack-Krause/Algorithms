package sorting;

import core.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// T extends Comparable<? super T> allows us to sort T when its compareTo
//     method was declared on a supertype (e.g. Comparable<Insect> for Ant)
public class QuickSort<T extends Comparable<? super T>>
    implements Algorithm<List<T>, List<T>> {


    /**
     * Returns a sorted list of Type T
     * @param input - List of (usually ints) to sort
     * @return sorted list of type T
     */
    @Override
    public List<T> run(List<T> input) {
        List<T> copy = new ArrayList<>(input);
        quickSortRec(copy, 0, copy.size() - 1);
        return copy;
    }

    private void quickSortRec(List<T> input, int low, int high) {
        if (low < high) {
            int p = partition(input, low, high);
            quickSortRec(input, low, p - 1);
            quickSortRec(input, p + 1, high);
        }
    }


    /**
     * Partition function. Returns index where array is of the form:
     * [(elements < p), p, (elements > p)]
     * p is in its sorted position upon return
     * @param input
     * @param low
     * @param high
     * @return
     */
    private int partition(List<T> input, int low, int high) {
        // choose the last element in the array as the pivot
        T pivot = input.get(high);
        // track the index of positions less than the pivot element
        int j = low - 1;

        for (int i = low; i < high; i++) {
            T el = input.get(i);
            // if inp[i] "<" pivot:
            if (el.compareTo(pivot) < 0) {
                // swap the elements
                j++;
                Collections.swap(input, j, i);
            }
        } // end for

        // insert the pivot into its rightfully sorted position
        j++;
        Collections.swap(input, j, high);
        return j;
    }




}
