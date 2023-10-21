package pg.pd.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;
import pg.pd.lab2.domain.exception.DivideByZero;

import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public enum CalculationMethod {
    ADDITION(Collections.emptyMap()),
    SUBTRACTION(Collections.emptyMap()),
    MULTIPLICATION(Collections.emptyMap()),
    DIVISION(Map.of((numbers -> !numbers.getRight().equals(0d)), DivideByZero.class));

    private final Map<Predicate<Pair<Double, Double>>, Class<? extends RuntimeException>> requiredValidations;

//    public boolean areNumbersValid(final Pair<Double, Double> calculationNumbers) {
//        return requiredValidations.entrySet()
//                .stream().map()
//                .map(validation -> validation.test(calculationNumbers))
//                .reduce(Boolean::logicalAnd)
//                .orElse(false);
//    }

}