package pg.pd.lab2.initializers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import pg.pd.lab2.api.user.UserDto;
import pg.pd.lab2.service.UserService;

import java.util.Set;

/**
 * The type Mongo db users initializer.
 */
@Log4j2
@RequiredArgsConstructor
public class MongoDbUsersInitializer implements ApplicationRunner {
    private final UserService userService;

    @Override
    public void run(final ApplicationArguments args) {
        log.debug("{} running", this.getClass().getSimpleName());
        val user = UserDto.builder()
                .username("Test_1")
                .password("Test_1")
                .roles(Set.of("USER"))
                .build();
        val admin = UserDto.builder()
                .username("Test_2")
                .password("Test_2")
                .roles(Set.of("ADMIN"))
                .build();
        userService.createUser(user);
        userService.createUser(admin);
    }
}
