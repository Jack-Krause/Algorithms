package test;

import core.AlgorithmContext;
import core.Algorithm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractSortingTest {

    protected abstract Algorithm<List<Integer>, List<Integer>> sortAlg();

    @Test void emptyList() {
        var ctx = new AlgorithmContext<>(sortAlg());
        assertTrue(ctx.execute(List.of()).isEmpty());
    }

    @Test void singletonList() {
        var context = new AlgorithmContext<>(sortAlg());
        assertEquals(List.of(200), context.execute(List.of(200)));
    }

    @Test void randomOrder() {
        var context = new AlgorithmContext<>(sortAlg());
        List<Integer> input = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertEquals(List.of(1, 1, 3, 4, 5, 9), context.execute(input));
    }





}
