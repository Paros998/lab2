package pg.pd.lab2.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pg.pd.lab2.domain.CalculationMethod;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationRequest {
    @NonNull
    private CalculationMethod method;

    @NonNull
    private Double mainNumber;

    @NonNull
    private Double secondaryNumber;
}