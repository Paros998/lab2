package pg.pd.lab2.loader;

import pg.pd.lab2.model.mongo.connection.MongoDbConnection;

public interface MongoDbConfigLoader {
    MongoDbConnection getMongoDbConnectionModel();
}