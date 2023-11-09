package pg.pd.lab2.infrastructure.impl;

import lombok.val;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pg.pd.lab2.api.calculator.CalculationRequest;
import pg.pd.lab2.api.calculator.CalculationResult;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.domain.ValidationResult;
import pg.pd.lab2.domain.exception.DivideByZeroException;
import pg.pd.lab2.infrastructure.service.Calculator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class DefaultCalculatorTest {
    private final Calculator calculator = new DefaultCalculator();

    @ParameterizedTest
    @MethodSource("shouldProperlyCalculateParams")
    void shouldProperlyCalculate(final CalculationRequest request, final CalculationResult expectedResult) {
        // when
        val result = calculator.calculate(Pair.of(request.getMainNumber(), request.getSecondaryNumber()), request.getMethod());

        // then
        Assertions.assertEquals(expectedResult.getResult(), result.getResult());
        Assertions.assertEquals(expectedResult.getValidationResult(), result.getValidationResult());
    }

    private static Stream<Arguments> shouldProperlyCalculateParams() {
        val requestBuilder = CalculationRequest.builder();
        val resultBuilder = CalculationResult.builder();
        return Stream.of(
                Arguments.of(
                        requestBuilder.mainNumber(1d).secondaryNumber(2d).method(CalculationMethod.ADDITION).build(),
                        resultBuilder.result(3d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(1d).secondaryNumber(2d).method(CalculationMethod.SUBTRACTION).build(),
                        resultBuilder.result(-1d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(1d).secondaryNumber(2d).method(CalculationMethod.MULTIPLICATION).build(),
                        resultBuilder.result(2d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(1d).secondaryNumber(2d).method(CalculationMethod.DIVISION).build(),
                        resultBuilder.result(.5d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(1.23d).secondaryNumber(2.1d).method(CalculationMethod.ADDITION).build(),
                        resultBuilder.result(3.33d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(92323d).secondaryNumber(821d).method(CalculationMethod.SUBTRACTION).build(),
                        resultBuilder.result(91502d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(5d).secondaryNumber(12d).method(CalculationMethod.MULTIPLICATION).build(),
                        resultBuilder.result(60d).validationResult(ValidationResult.of(Collections.emptyList())).build()
                ),
                Arguments.of(
                        requestBuilder.mainNumber(1d).secondaryNumber(0d).method(CalculationMethod.DIVISION).build(),
                        resultBuilder.result(null).validationResult(ValidationResult.of(List.of(new DivideByZeroException()))).build()
                )
        );
    }
}