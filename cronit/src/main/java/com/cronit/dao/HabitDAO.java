package com.cronit.dao;

import com.cronit.model.Habit;
import java.util.List;

public interface HabitDAO {
    Habit getHabitById(int habit_id);
    List<Habit> getHabitsByUserId(int userId);
    void insertHabit(Habit habit);
    void updateHabit(Habit habit);
    void deleteHabit(int habit_id);
}
