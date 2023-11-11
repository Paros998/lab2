package pg.pd.lab2.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pg.pd.lab2.api.user.UserDto;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService extends UserDetailsService {

    /**
     * Create user string.
     *
     * @param createDto the creation dto
     * @return the string
     */
    String createUser(UserDto createDto);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<UserDto> getAllUsers();

}