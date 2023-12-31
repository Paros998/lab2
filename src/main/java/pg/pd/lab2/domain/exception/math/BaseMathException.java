package pg.pd.lab2.domain.exception.math;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.EqualsAndHashCode;

/**
 * The type Base math exception.
 */
@JsonSerialize(using = ToStringSerializer.class)
@EqualsAndHashCode(callSuper = false)
public class BaseMathException extends RuntimeException {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}