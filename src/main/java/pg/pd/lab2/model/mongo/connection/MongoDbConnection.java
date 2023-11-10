package pg.pd.lab2.model.mongo.connection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MongoDbConnection {
    private String login;
    private String password;
    private String database;
    private String host;

    public String generateConnectionString() {
        return "mongodb://" + this.login + ":" + this.password + "@" + this.host + "/" + this.database
                + "?authMechanism=SCRAM-SHA-1&authSource=" + this.database;
    }
}