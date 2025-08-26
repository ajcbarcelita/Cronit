package com.cronit.dao;

import java.util.List;

public interface HabitTagDAO {
    void addTagToHabit(int habit_id, int tag_id);
    void removeTagFromHabit(int habit_id, int tag_id);
    List<Integer> getTagIdsByHabitId(int habit_id);
    List<Integer> getHabitIdsByTagId(int tag_id);
}
