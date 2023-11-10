package pg.pd.lab2.infrastructure.spring.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import pg.pd.lab2.loader.MongoDbConfigLoader;
import pg.pd.lab2.model.mongo.connection.MongoDbConnection;

@Configuration
@Log4j2
public class MongoDbConfig extends AbstractMongoClientConfiguration {
    private final MongoDbConnection connection;

    public MongoDbConfig(final MongoDbConfigLoader configLoader) {
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
        log.info("Mongo DB connection: {}", connection.generateConnectionString());
        return MongoClients.create(connection.generateConnectionString());
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
