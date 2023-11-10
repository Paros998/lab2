package pg.pd.lab2.service;

import pg.pd.lab2.api.fibonacci.FibonacciResult;

public interface Fibonacci {
    FibonacciResult calculateFibonacci(Integer degree);
}