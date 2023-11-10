package pg.pd.lab2.infrastructure.spring.devliery.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pg.pd.lab2.api.fibonacci.FibonacciResult;
import pg.pd.lab2.service.Fibonacci;

@Log4j2
@RestController
@RequestMapping("/api/v1/fibonacci")
@RequiredArgsConstructor
public class FibonacciHttpEndpoint {
    private final Fibonacci fibonacciService;

    @GetMapping
    public FibonacciResult getFibonacci(final @RequestParam Integer fibonacciDegree) {
        log.info("Started processing fibonacci calculation request, Degree: {}", fibonacciDegree);

        val result = fibonacciService.calculateFibonacci(fibonacciDegree);
        log.info("Fibonacci number calculate, result: {}", result);

        return result;
    }
}