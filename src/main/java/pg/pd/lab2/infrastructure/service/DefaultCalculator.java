package pg.pd.lab2.infrastructure.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.api.CalculationResult;
import pg.pd.lab2.domain.ValidationResult;
import pg.pd.lab2.domain.exception.BaseMathException;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class DefaultCalculator implements Calculator {

    @Override
    public List<BaseMathException> validateDataForCalculation(final Pair<Double, Double> numbers,
                                                                        final CalculationMethod method) {
        return method.validateNumbers(numbers);
    }

    @Override
    public CalculationResult calculate(final Pair<Double, Double> numbers, final CalculationMethod method) {
        val result = CalculationResult.builder()
                .mainNumber(numbers.getLeft())
                .secondaryNumber(numbers.getRight())
                .method(method)
                .validationResult(ValidationResult.of(validateDataForCalculation(numbers, method)))
                .build();

        if (result.failedValidation()) {
            return result;
        }

        result.setResult(switch (method) {
            case ADDITION -> numbers.getLeft() + numbers.getRight();
            case SUBTRACTION -> numbers.getLeft() - numbers.getRight();
            case DIVISION -> numbers.getLeft() / numbers.getRight();
            case MULTIPLICATION -> numbers.getLeft() * numbers.getRight();
        });

        log.info("Numbers {} for calculation method {} were calculated, result: {}", numbers, method,
                result.getResult());

        return result;
    }
}