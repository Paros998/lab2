package pg.pd.lab2.api.calculator;

import lombok.*;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.domain.ValidationResult;

import java.io.Serializable;

/**
 * The type Calculation result.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public final class CalculationResult implements Serializable {
    private Double mainNumber;
    private Double secondaryNumber;
    private CalculationMethod method;
    private Double result;
    private ValidationResult validationResult;

    /**
     * Failed validation boolean.
     *
     * @return the boolean
     */
    public boolean failedValidation() {
        return !validationResult.isValid();
    }
}