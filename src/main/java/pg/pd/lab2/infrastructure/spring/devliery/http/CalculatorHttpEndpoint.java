package pg.pd.lab2.infrastructure.spring.devliery.http;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pg.pd.lab2.api.CalculationRequest;
import pg.pd.lab2.api.CalculationResult;
import pg.pd.lab2.infrastructure.service.Calculator;

@Log4j2
@RestController
@RequestMapping("/api/v1/calculator")
@RequiredArgsConstructor
public class CalculatorHttpEndpoint {
    private final Calculator calculator;

    @PostMapping
    public CalculationResult tryToCalculate(final @Valid @RequestBody CalculationRequest request) {
        log.info("Started processing calculation request {}", request);

        return calculator.calculate(Pair.of(request.getMainNumber(), request.getSecondaryNumber()),
                request.getMethod());
    }
}