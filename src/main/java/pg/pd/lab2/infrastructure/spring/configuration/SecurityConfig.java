package pg.pd.lab2.infrastructure.spring.configuration;

import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pg.pd.lab2.domain.Roles;

import java.util.Arrays;

/**
 * The type Security config.
 */
@Configuration
public class SecurityConfig {

    /**
     * B crypt password encoder b crypt password encoder.
     *
     * @return the b crypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    /**
     * Cors configuration source cors configuration source.
     *
     * @return the cors configuration source
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "https://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * Security filter chain security filter chain.
     *
     * @param http                   the http
     * @param authenticationProvider the authentication provider
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(final @NonNull HttpSecurity http,
                                                   final @NonNull AuthenticationProvider authenticationProvider) throws Exception {
        http
                .authenticationProvider(authenticationProvider)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/actuator/**", "/swagger-ui/**", "/swagger-ui.html**", "/v3/api-docs/**").permitAll())

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/v1/fibonacci/**", "/api/v1/calculator/**").hasAnyRole(Roles.USER.name()))

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/v1/users/**").hasAnyRole(Roles.ADMIN.name()))

                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionFixation().migrateSession()
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false))


                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)

                .httpBasic(Customizer.withDefaults())

                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
        ;

        return http.build();
    }
}
