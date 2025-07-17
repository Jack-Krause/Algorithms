package test.sorting;

import core.Algorithm;
import core.AlgorithmContext;
import org.junit.jupiter.api.Test;
import sorting.QuickSort;
import test.AbstractSortingTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class QuickSortTest extends AbstractSortingTest {

    @Override
    protected Algorithm<List<Integer>, List<Integer>> sortAlg() {
        return new QuickSort<>();
    }

}
