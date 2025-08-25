package com.cronit.model;

import java.time.LocalDateTime;

public class User {
    private int user_id;
    private String username;
    private String email;
    private String lname;
    private String fname;
    private String mname;
    private String pw_hash;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public User(int user_id, String username, String email, String lname, String fname, String mname, String pw_hash, LocalDateTime created_at, LocalDateTime updated_at) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.lname = lname;
        this.fname = fname;
        this.mname = mname;
        this.pw_hash = pw_hash;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPw_hash() {
        return pw_hash;
    }

    public void setPw_hash(String pw_hash) {
        this.pw_hash = pw_hash;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
}
