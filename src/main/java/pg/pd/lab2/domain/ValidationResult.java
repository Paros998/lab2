package pg.pd.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResult implements Serializable {
    private boolean isValid;
    private List<RuntimeException> errors;

    @Override
    public String toString() {
        return "ValidationResult{" +
                "isValid=" + isValid +
                ", errors=" + errors +
                '}';
    }
}