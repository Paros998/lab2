package pg.pd.lab2.api;

import lombok.*;
import pg.pd.lab2.domain.CalculationMethod;
import pg.pd.lab2.domain.ValidationResult;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@ToString
public final class CalculationResult implements Serializable {
    private Double mainNumber;
    private Double secondaryNumber;
    private CalculationMethod method;
    private Double result;
    private ValidationResult validationResult;

    public boolean failedValidation() {
        return !validationResult.isValid();
    }
}