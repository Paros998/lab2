package pg.pd.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.tuple.Pair;
import pg.pd.lab2.domain.exception.BaseMathException;
import pg.pd.lab2.domain.exception.DivideByZeroException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * The enum Calculation method.
 */
@AllArgsConstructor
@Log4j2
public enum CalculationMethod {
    /**
     * Addition calculation method.
     */
    ADDITION(Collections.emptyMap()),
    /**
     * Subtraction calculation method.
     */
    SUBTRACTION(Collections.emptyMap()),
    /**
     * Multiplication calculation method.
     */
    MULTIPLICATION(Collections.emptyMap()),
    /**
     * The Division.
     */
    DIVISION(Map.of((numbers -> numbers.getRight().equals(0d)), new DivideByZeroException()));

    private final Map<Predicate<Pair<Double, Double>>, ? extends BaseMathException> requiredValidations;

    /**
     * Validate numbers list.
     *
     * @param calculationNumbers the calculation numbers
     * @return the list
     */
    public List<BaseMathException> validateNumbers(final Pair<Double, Double> calculationNumbers) {
        List<BaseMathException> caughtErrors = new ArrayList<>();

        requiredValidations.forEach((predicate, error) -> {
            if (predicate.test(calculationNumbers)) caughtErrors.add(error);
        });

        if (!caughtErrors.isEmpty()) {
            log.warn("Numbers {} for calculation method {} are invalid, caughtErrors: {}", calculationNumbers,
                    toString(), caughtErrors);
        }

        return caughtErrors;
    }

}