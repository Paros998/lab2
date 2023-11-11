package pg.pd.lab2.api.fibonacci;

import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * The type Fibonacci result.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciResult implements Serializable {
    private List<BigInteger> fibonacciNumbers;
    private BigInteger finalNumber;
}