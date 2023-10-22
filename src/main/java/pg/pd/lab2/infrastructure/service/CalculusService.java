package pg.pd.lab2.infrastructure.service;

import org.apache.commons.lang3.tuple.Pair;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.domain.CalculationResult;
import pg.pd.lab2.domain.exception.BaseMathException;

import java.util.List;

public interface CalculusService {
    List<BaseMathException> validateDataForCalculation(Pair<Double, Double> numbers, CalculationMethod method);

    CalculationResult calculate(Pair<Double, Double> numbers, CalculationMethod method);
}