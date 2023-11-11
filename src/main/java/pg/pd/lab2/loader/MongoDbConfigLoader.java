package pg.pd.lab2.loader;

import pg.pd.lab2.model.mongo.connection.MongoDbConnection;

/**
 * The interface Mongo db config loader.
 */
public interface MongoDbConfigLoader {
    /**
     * Gets mongo db connection model.
     *
     * @return the mongo db connection model
     */
    MongoDbConnection getMongoDbConnectionModel();
}