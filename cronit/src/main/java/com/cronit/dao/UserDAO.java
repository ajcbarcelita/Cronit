package com.cronit.dao;

import com.cronit.model.User;
import java.util.List;

public interface UserDAO {
    User getUserById(int user_id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int user_id);
}
