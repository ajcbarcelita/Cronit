package com.cronit.dao;

import com.cronit.model.Tag;
import java.util.List;

public interface TagDAO {
    Tag getTagById(int tag_id);
    List<Tag> getTagsByUserId(int user_id);
    boolean insertTag(Tag tag);
    boolean updateTag(Tag tag);
    boolean deleteTag(int tag_id);
    boolean deleteTagsByUserId(int user_id);
}
