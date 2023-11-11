package pg.pd.lab2.infrastructure.impl.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pg.pd.lab2.model.mongo.User;
import pg.pd.lab2.repository.UserRepository;

import java.util.List;

/**
 * The type User dao authentication provider.
 */
@Service
@RequiredArgsConstructor
public class UserDaoAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = userDao.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .toList();

            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
