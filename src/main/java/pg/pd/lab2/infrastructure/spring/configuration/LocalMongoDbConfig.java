package pg.pd.lab2.infrastructure.spring.configuration;

import de.flapdoodle.embed.mongo.spring.autoconfigure.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pg.pd.lab2.initializers.MongoDbUsersInitializer;
import pg.pd.lab2.service.UserService;

/**
 * The type Local mongo db config.
 */
@Configuration
@Profile({"devlocal"})
public class LocalMongoDbConfig extends EmbeddedMongoAutoConfiguration {

    /**
     * Mongo db users initializer application runner.
     *
     * @param userService the user service
     * @return the application runner
     */
    @Bean
    public ApplicationRunner mongoDbUsersInitializer(final UserService userService) {
        return new MongoDbUsersInitializer(userService);
    }
}
