package pg.pd.lab2.infrastructure.impl.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pg.pd.lab2.api.user.UserDto;
import pg.pd.lab2.model.mongo.User;
import pg.pd.lab2.repository.UserRepository;
import pg.pd.lab2.service.UserService;
import pg.pd.lab2.utils.user.UserConverter;

import java.util.List;

/**
 * The type Default user service.
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class DefaultUserService implements UserService {
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user with the given login does not exist:" + username);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.isEnabled())
                .roles(user.getRoles().toArray(new String[0]))
                .build();
    }

    @Override
    public String createUser(final UserDto createDto) {
        log.info("Starting processing user creation request: {}", createDto);

        val user = UserConverter.toUser(createDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userDao.addUser(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.findAll().stream()
                .map(UserConverter::toUserDto)
                .toList();
    }
}
