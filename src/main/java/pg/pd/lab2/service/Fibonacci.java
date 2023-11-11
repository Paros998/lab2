package pg.pd.lab2.service;

import pg.pd.lab2.api.fibonacci.FibonacciResult;

/**
 * The interface Fibonacci.
 */
public interface Fibonacci {
    /**
     * Calculate fibonacci fibonacci result.
     *
     * @param degree the degree
     * @return the fibonacci result
     */
    FibonacciResult calculateFibonacci(Integer degree);
}