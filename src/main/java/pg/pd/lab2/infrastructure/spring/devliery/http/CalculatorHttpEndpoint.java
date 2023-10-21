package pg.pd.lab2.infrastructure.spring.devliery.http;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pg.pd.lab2.api.CalculationRequest;
import pg.pd.lab2.domain.CalculationResult;
import pg.pd.lab2.infrastructure.service.CalculusService;

@RestController
@RequestMapping("api/v1/calculator")
@RequiredArgsConstructor
public class CalculatorHttpEndpoint {
    private final CalculusService calculusService;

    @PostMapping
    public CalculationResult tryToCalculate(final @RequestBody CalculationRequest request) {
        return calculusService.calculate(Pair.of(request.getSecondaryNumber(), request.getMainNumber()),
                request.getMethod());
    }
}