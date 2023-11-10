package pg.pd.lab2.utils.fibonacci;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pg.pd.lab2.api.fibonacci.FibonacciResult;

import java.math.BigInteger;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FibonacciResultFactory {

    public static FibonacciResult instantiate(final Integer degree) {
        return switch (degree) {
            case 0 -> none();
            case 1 -> first();
            default -> throw new IllegalStateException("Unexpected value: " + degree);
        };
    }

    public static FibonacciResult instantiate(final @NonNull BigInteger result, final @NonNull List<BigInteger> numbers) {
        return FibonacciResult.builder()
                .fibonacciNumbers(numbers)
                .finalNumber(result)
                .build();
    }

    private static FibonacciResult none() {
        return FibonacciResult.builder()
                .finalNumber(BigInteger.valueOf(0))
                .build();
    }

    private static FibonacciResult first() {
        return FibonacciResult.builder()
                .fibonacciNumbers(List.of(BigInteger.valueOf(1)))
                .finalNumber(BigInteger.valueOf(1))
                .build();
    }

}