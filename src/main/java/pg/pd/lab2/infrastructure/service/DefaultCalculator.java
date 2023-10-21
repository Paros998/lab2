package pg.pd.lab2.infrastructure.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.domain.CalculationResult;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCalculator implements CalculusService {

    @Override
    public List<? extends RuntimeException> validateDataForCalculation(final Pair<Double, Double> numbers,
                                                                       final CalculationMethod method) {
        return Collections.emptyList();
    }

    @Override
    public CalculationResult calculate(final Pair<Double, Double> numbers, final CalculationMethod method) {
        return null;
    }
}
