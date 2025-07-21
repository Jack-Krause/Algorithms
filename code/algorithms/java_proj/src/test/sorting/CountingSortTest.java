package test.sorting;

import core.Algorithm;
import sorting.CountingSort;
import test.AbstractSortingTest;

import java.util.List;

public class CountingSortTest extends AbstractSortingTest {

    @Override
    protected Algorithm<List<Integer>, List<Integer>> sortAlg() {
        return new CountingSort<>();
    }
}
