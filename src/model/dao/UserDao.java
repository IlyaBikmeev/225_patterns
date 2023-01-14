package model.dao;

import model.User;

import java.util.List;

/**
 * CRUD - CREATE READ UPDATE DELETE
 */
public interface UserDao {
    List<User> allUsers();
    User findById(int id);
    boolean register(User user);
    boolean auth(User user);
    default void save() {
        throw new UnsupportedOperationException();
    }
}
