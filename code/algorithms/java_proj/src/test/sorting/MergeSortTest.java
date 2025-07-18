package test.sorting;

import core.Algorithm;
import sorting.MergeSort;
import test.AbstractSortingTest;

import java.util.List;

public class MergeSortTest extends AbstractSortingTest {

    @Override
    protected Algorithm<List<Integer>, List<Integer>> sortAlg() { return new MergeSort<>(); }

}
