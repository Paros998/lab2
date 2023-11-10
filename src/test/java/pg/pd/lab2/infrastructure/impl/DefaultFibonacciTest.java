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
    void shouldCalculateFibonacciData(final Integer fibonacciDegree, final BigInteger expectedResult,
                                      final boolean shouldThrowException) {
        // when
        if (shouldThrowException) {
            Assertions.assertThrows(IllegalStateException.class ,() -> fibonacci.calculateFibonacci(fibonacciDegree));
        } else {
            val result = fibonacci.calculateFibonacci(fibonacciDegree);

            // then
            Assertions.assertNotNull(result);
            BigInteger finalNumber = result.getFinalNumber();

            Assertions.assertNotNull(finalNumber);
            Assertions.assertEquals(expectedResult, finalNumber);
        }

    }

    private static Stream<Arguments> shouldCalculateFibonacciData() {
        return Stream.of(
                Arguments.of(1, BigInteger.valueOf(1), false),
                Arguments.of(2, BigInteger.valueOf(2), false),
                Arguments.of(3, BigInteger.valueOf(4), false),
                Arguments.of(4, BigInteger.valueOf(7), false),
                Arguments.of(5, BigInteger.valueOf(12), false),
                Arguments.of(6, BigInteger.valueOf(20), false),
                Arguments.of(7, BigInteger.valueOf(33), false),
                Arguments.of(0, BigInteger.valueOf(0), false),
                Arguments.of(-2, null, true),
                Arguments.of(42, BigInteger.valueOf(701408732), false)
        );
    }
}
