package pg.pd.lab2.service;

import org.apache.commons.lang3.tuple.Pair;
import pg.pd.lab2.api.calculator.CalculationResult;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.domain.exception.math.BaseMathException;

import java.util.List;

/**
 * The interface Calculator.
 */
public interface Calculator {
    /**
     * Validate data for calculation list.
     *
     * @param numbers the numbers
     * @param method  the method
     * @return the list
     */
    List<BaseMathException> validateDataForCalculation(Pair<Double, Double> numbers, CalculationMethod method);

    /**
     * Calculate calculation result.
     *
     * @param numbers the numbers
     * @param method  the method
     * @return the calculation result
     */
    CalculationResult calculate(Pair<Double, Double> numbers, CalculationMethod method);
}