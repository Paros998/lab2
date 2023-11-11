package pg.pd.lab2.infrastructure.spring.delivery.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pg.pd.lab2.api.user.UserDto;
import pg.pd.lab2.service.UserService;

import java.util.List;

/**
 * The type User http endpoint.
 */
@Log4j2
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserHttpEndpoint {
    private final UserService userService;

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
