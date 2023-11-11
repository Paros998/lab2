package pg.pd.lab2.utils.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pg.pd.lab2.api.user.UserDto;
import pg.pd.lab2.domain.Roles;
import pg.pd.lab2.domain.exception.user.UserRoleNotExistException;
import pg.pd.lab2.model.mongo.User;

import java.util.Arrays;
import java.util.List;

/**
 * The type User converter.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {
    /**
     * To user dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
    public static UserDto toUserDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .enabled(user.isEnabled())
                .roles(user.getRoles())
                .build();
    }

    /**
     * To user user.
     *
     * @param userDto the user dto
     * @return the user
     */
    public static User toUser(final UserDto userDto) {
        List<String> roles = Arrays.stream(Roles.values()).map(Enum::name).toList();

        userDto.getRoles().forEach(role -> {
            if (!roles.contains(role)) throw new UserRoleNotExistException(role);
        });

        return new User(userDto.getUsername(), userDto.getPassword(), true, userDto.getRoles());
    }
}