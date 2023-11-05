package pg.pd.lab2.infrastructure.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pg.pd.lab2.api.fibonacci.FibonacciResult;
import pg.pd.lab2.infrastructure.factory.FibonacciResultFactory;
import pg.pd.lab2.infrastructure.service.Fibonacci;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultFibonacci implements Fibonacci {

    @Override
    public FibonacciResult calculateFibonacci(final Integer degree) {
        if (degree < 2) {
            return FibonacciResultFactory.instantiate(degree);
        }

        BigInteger first = BigInteger.valueOf(1), second = BigInteger.valueOf(1), iterationResult;
        final List<BigInteger> fibonacciNumbers = new LinkedList<>(List.of(first, second));

        for (int i = 2; i < degree; i++) {
            iterationResult = first.add(second);
            first = second;
            second = iterationResult;
            fibonacciNumbers.add(iterationResult);
        }

        return FibonacciResultFactory.instantiate(
                fibonacciNumbers.stream().reduce(BigInteger::add).orElse(BigInteger.valueOf(0)), fibonacciNumbers);
    }
}