package pg.pd.lab2.domain.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.EqualsAndHashCode;

@JsonSerialize(using = ToStringSerializer.class)
@EqualsAndHashCode(callSuper = false)
public class BaseMathException extends RuntimeException {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}