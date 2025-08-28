package com.cronit.dao;

import com.cronit.model.Tag;
import com.cronit.util.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TagDAOImpl implements TagDAO {
    public Tag getTagById(int tag_id) {
        String sql = "SELECT * FROM tags WHERE tag_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, tag_id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Tag(
                        rs.getInt("tag_id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("color")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // When exception occurs, return null
        }

        return null;
    }

    public List<Tag> getTagsByUserId(int user_id) {
        String sql = "SELECT * FROM tags WHERE user_id = ?";
        List<Tag> tags = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, user_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Tag tag = new Tag(
                        rs.getInt("tag_id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("color")
                    );
                    tags.add(tag);
                }
                return tags; // Return the list of tags, even if empty
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }
    }

    public boolean insertTag(Tag tag) {
        String sql = "INSERT INTO tags(user_id, name, color) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, tag.getUser_id());
            pstmt.setString(2, tag.getName());
            pstmt.setString(3, tag.getColor());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTag(Tag tag) {
        String sql = "UPDATE tags SET name=?, color=? WHERE tag_id=?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, tag.getName());
            pstmt.setString(2, tag.getColor());
            pstmt.setInt(3, tag.getTag_id());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTag(int tag_id) {
        String sql = "DELETE FROM tags WHERE tag_id=?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, tag_id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTagsByUserId(int user_id) {
        String sql = "DELETE FROM tags WHERE user_id=?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, user_id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
