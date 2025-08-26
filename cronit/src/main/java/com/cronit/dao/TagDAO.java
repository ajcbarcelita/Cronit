package com.cronit.dao;

import com.cronit.model.Tag;
import java.util.List;

public interface TagDAO {
    Tag getTagById(int tag_id);
    List<Tag> getTagsByUserId(int user_id);
    void insertTag(Tag tag);
    void updateTag(Tag tag);
    void deleteTag(int tag_id);
}
