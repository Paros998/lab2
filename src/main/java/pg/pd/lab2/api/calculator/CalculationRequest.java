package pg.pd.lab2.api.calculator;

import lombok.*;
import pg.pd.lab2.domain.CalculationMethod;

/**
 * The type Calculation request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculationRequest {
    @NonNull
    private CalculationMethod method;

    @NonNull
    private Double mainNumber;

    @NonNull
    private Double secondaryNumber;
}