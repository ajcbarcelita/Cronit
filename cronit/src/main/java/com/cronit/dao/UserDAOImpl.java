package com.cronit.dao;

import com.cronit.model.User;
import com.cronit.util.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UserDAOImpl implements UserDAO {
    
    @Override
    public User getUserById(int user_id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {
         
            pstmt.setInt(1, user_id);
            
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    return new User(
                                    rs.getInt("user_id"), 
                                    rs.getString("username"), 
                                    rs.getString("email"), 
                                    rs.getString("lname"), 
                                    rs.getString("fname"), 
                                    rs.getString("mname"), 
                                    rs.getString("pw_hash"), 
                                    rs.getTimestamp("created_at").toLocalDateTime(), 
                                    rs.getTimestamp("updated_at").toLocalDateTime()
                    );
                }   
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null; // When exception occurs, return null
        }
        return null; // User not found
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("lname"),
                        rs.getString("fname"),
                        rs.getString("mname"),
                        rs.getString("pw_hash"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("lname"),
                        rs.getString("fname"),
                        rs.getString("mname"),
                        rs.getString("pw_hash"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("lname"),
                    rs.getString("fname"),
                    rs.getString("mname"),
                    rs.getString("pw_hash"),
                    rs.getTimestamp("created_at").toLocalDateTime(),
                    rs.getTimestamp("updated_at").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); // safer than null
        }
        return users;
    }

    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (username, email, lname, fname, mname, pw_hash) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getLname());
            pstmt.setString(4, user.getFname());
            pstmt.setString(5, user.getMname());
            pstmt.setString(6, user.getPw_hash());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE users SET username=?, email=?, lname=?, fname=?, mname=?, pw_hash=?, updated_at=CURRENT_TIMESTAMP WHERE user_id=?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getLname());
            pstmt.setString(4, user.getFname());
            pstmt.setString(5, user.getMname());
            pstmt.setString(6, user.getPw_hash());
            pstmt.setInt(7, user.getUser_id());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int user_id) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, user_id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // indicate failure
        }
    }
}