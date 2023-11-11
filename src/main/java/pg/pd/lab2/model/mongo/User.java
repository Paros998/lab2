package pg.pd.lab2.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * The type User.
 */
@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean enabled;
    private Set<String> roles;

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param password the password
     * @param enabled  the enabled
     * @param roles    the roles
     */
    public User(String username, String password, boolean enabled, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

}