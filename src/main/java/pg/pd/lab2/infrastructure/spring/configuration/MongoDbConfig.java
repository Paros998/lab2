package pg.pd.lab2.infrastructure.spring.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import pg.pd.lab2.loader.MongoDbConfigLoader;
import pg.pd.lab2.model.mongo.connection.MongoDbConnection;

/**
 * The type Mongo db config.
 */
@Configuration
@Profile({"!devlocal"})
@Log4j2
public class MongoDbConfig extends AbstractMongoClientConfiguration {
    private final MongoDbConnection connection;

    /**
     * Instantiates a new Mongo db config.
     *
     * @param configLoader the config loader
     */
    public MongoDbConfig(final @NonNull MongoDbConfigLoader configLoader) {
        this.connection = configLoader.getMongoDbConnectionModel();
    }

    @Override
    @NonNull
    protected String getDatabaseName() {
        return connection.getDatabase();
    }

    @Override
    @NonNull
    public MongoClient mongoClient() {
        log.info("Mongo DB connection: {}", connection.generateConnection());
        return MongoClients.create(connection.generateConnection());
    }

    /**
     * Mongo template mongo template.
     *
     * @return the mongo template
     */
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
