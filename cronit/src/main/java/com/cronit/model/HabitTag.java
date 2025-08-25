package com.cronit.model;

public class HabitTag {
    private int habit_id;
    private int tag_id;

    public HabitTag(int habit_id, int tag_id) {
        this.habit_id = habit_id;
        this.tag_id = tag_id;
    }

    public int getHabit_id() {
        return habit_id;
    }

    public int getTag_id() {
        return tag_id;
    }
}
