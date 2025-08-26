package com.cronit.dao;

import com.cronit.model.HabitLog;
import java.util.List;

public interface HabitLogDAO {
    HabitLog getLogById(int log_id);
    List<HabitLog> getLogsByHabitId(int habit_id);
    void insertLog(HabitLog log);
    void deleteLog(int log_id);
}

