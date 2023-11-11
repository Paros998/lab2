package pg.pd.lab2.utils.mongo;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pg.pd.lab2.model.mongo.connection.MongoDbConnection;
import pg.pd.lab2.loader.MongoDbConfigLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * The type Properties based mongo db config loader.
 */
@Service
@Log4j2
public class PropertiesBasedMongoDbConfigLoader implements MongoDbConfigLoader {
    @Resource
    private final Properties properties = new Properties();

    @Override
    public MongoDbConnection getMongoDbConnectionModel() {
        final Path path = Paths.get(System.getProperty("user.dir"), "Mongo-DB-connection.properties");
        try (
                InputStream inputStream = Files.newInputStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("Error loading config file: " + e.getMessage());
            return null;
        }

        return MongoDbConnection.builder()
                .login(properties.getProperty("login"))
                .password(properties.getProperty("password"))
                .database(properties.getProperty("database"))
                .host(properties.getProperty("host"))
                .build();
    }
}
