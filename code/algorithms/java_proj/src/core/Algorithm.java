package core;

/**
 * top-level interface for creating algorithms
 * exposes run operation for all algorithms
 * abstraction, allowing clients to depend on only the interface, rather than
 *      each concrete class
 * allows for compile-time safety
 * Goal: implement using OOP strategy pattern
 * @param <I>
 * @param <O>
 */
public interface Algorithm<I, O> {
    O run(I input);
}