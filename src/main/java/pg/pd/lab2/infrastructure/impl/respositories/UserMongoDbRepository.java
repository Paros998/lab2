package pg.pd.lab2.infrastructure.impl.respositories;

import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pg.pd.lab2.model.mongo.User;
import pg.pd.lab2.repository.UserRepository;

import java.util.List;

/**
 * The interface User mongo db repository.
 */
@Repository
public interface UserMongoDbRepository extends MongoRepository<User, String>, UserRepository {

    User findByUsername(final String username);

    @NonNull
    List<User> findAll();

    @Override
    default String addUser(final User user) {
        User insertedUser = this.insert(user);
        return insertedUser.getId();
    }
}