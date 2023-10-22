package pg.pd.lab2.domain;

import lombok.*;

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