package pg.pd.lab2.infrastructure.impl;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pg.pd.lab2.infrastructure.service.Fibonacci;

import java.math.BigInteger;
import java.util.stream.Stream;

class DefaultFibonacciTest {
    private final Fibonacci fibonacci = new DefaultFibonacci();

    @ParameterizedTest
    @MethodSource("shouldCalculateFibonacciData")
    void shouldCalculateFibonacciData(final Integer fibonacciDegree, final BigInteger expectedResult) {
        // when
        val result = fibonacci.calculateFibonacci(fibonacciDegree);

        // then
        Assertions.assertNotNull(result);
        BigInteger finalNumber = result.getFinalNumber();

        Assertions.assertNotNull(finalNumber);
        Assertions.assertEquals(expectedResult, finalNumber);
    }

    private static Stream<Arguments> shouldCalculateFibonacciData() {
        return Stream.of(
                Arguments.of()
        );
    }
}
