package pg.pd.lab2.repository;

import pg.pd.lab2.model.mongo.User;

import java.util.List;

/**
 * The interface User repository.
 */
public interface UserRepository {
    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Add user.
     *
     * @param user the user
     * @return the id
     */
    String addUser(User user);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();
}