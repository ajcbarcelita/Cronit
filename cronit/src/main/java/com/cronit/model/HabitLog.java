package com.cronit.model;

import java.time.LocalDateTime;

public class HabitLog {
    private int log_id;
    private int habit_id;
    private LocalDateTime completed_at;

    public HabitLog(int log_id, int habit_id, LocalDateTime completed_at) {
        this.log_id = log_id;
        this.habit_id = habit_id;
        this.completed_at = completed_at;
    }

    public int getLog_id() {
        return log_id;
    }

    public int getHabit_id() {
        return habit_id;
    }

    public void setHabit_id(int habit_id) {
        this.habit_id = habit_id;
    }

    public LocalDateTime getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(LocalDateTime completed_at) {
        this.completed_at = completed_at;
    }
}
