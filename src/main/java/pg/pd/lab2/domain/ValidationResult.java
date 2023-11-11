package pg.pd.lab2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pg.pd.lab2.domain.exception.math.BaseMathException;

import java.io.Serializable;
import java.util.List;

/**
 * The type Validation result.
 */
@Data
@NoArgsConstructor
@ToString
public class ValidationResult implements Serializable {
    private boolean isValid;
    private List<? extends BaseMathException> errors;

    private ValidationResult(final boolean isValid, final List<? extends BaseMathException> errors) {
        this.isValid = isValid;
        this.errors = errors;
    }

    /**
     * Of validation result.
     *
     * @param errors the errors
     * @return the validation result
     */
    public static ValidationResult of(final List<? extends BaseMathException> errors) {
        return new ValidationResult(errors.isEmpty(), errors);
    }
}