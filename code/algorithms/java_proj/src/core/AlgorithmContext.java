package core;

public class AlgorithmContext<I, O> {
    private Algorithm<I, O> strategy;

    public AlgorithmContext(Algorithm<I, O> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Algorithm<I, O> strategy) {
        this.strategy = strategy;
        System.out.println("Strategy set");
    }

    public O execute(I input) {
        return strategy.run(input);
    }

}
