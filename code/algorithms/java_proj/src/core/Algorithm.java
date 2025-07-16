package core;

/**
 * Strategy Interface (part 2)
 * Specifies the set of methods all concrete strategies (algorithms)
 * must implement.
 *
 * Agreement: guarantees all (strategies ~= algorithms) must follow the same set of rules
 * and are interchangeable by the context (part 1)
 * In this case, the agreement is the generic input I and output O
 * and implementing the run method.
 * @param <I>
 * @param <O>
 */
public interface Algorithm<I, O> {
    O run(I input);
}


