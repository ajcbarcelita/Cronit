package com.cronit.controller;

import com.cronit.model.User;
import com.cronit.dao.UserDAO;
import com.cronit.dao.UserDAOImpl;
import com.cronit.util.*;
import java.util.List;

public class UserController {
    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAOImpl();
    }

    public boolean loginUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user == null) return false;
        return PasswordUtil.verifyPassword(password, user.getPw_hash());
    }

    public boolean registerUser(User user) {
        if (userDAO.getUserByUsername(user.getUsername()) != null ||
            userDAO.getUserByEmail(user.getEmail()) != null) {
            return false;
        }
        return ((UserDAOImpl)userDAO).insertUser(user);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public boolean updateUser(User user) {
        return ((UserDAOImpl)userDAO).updateUser(user);
    }

    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
