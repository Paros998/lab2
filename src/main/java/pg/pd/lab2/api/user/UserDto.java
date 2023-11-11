package pg.pd.lab2.api.user;

import lombok.*;

import java.util.Set;

/**
 * The type User dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class UserDto {
    private String id;
    private String username;
    private String password;
    private boolean enabled;
    private Set<String> roles;
}