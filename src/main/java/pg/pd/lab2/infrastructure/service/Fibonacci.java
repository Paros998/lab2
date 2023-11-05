package pg.pd.lab2.infrastructure.service;

import pg.pd.lab2.api.fibonacci.FibonacciResult;

public interface Fibonacci {
    FibonacciResult calculateFibonacci(Integer degree);
}