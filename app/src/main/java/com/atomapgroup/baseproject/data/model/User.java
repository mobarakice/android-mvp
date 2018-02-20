package com.atomapgroup.baseproject.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mobarak on 09-Feb-18.
 */
@Entity(indices = {@Index(value = {"user_email", "user_mobile"}, unique = true)})
public class User {
    @PrimaryKey
    @ColumnInfo(name = "uid")
    private int userId;
    @ColumnInfo(name = "user_name")
    private String name;
    @ColumnInfo(name = "user_email")
    private String email;
    @ColumnInfo(name = "user_mobile")
    private String mobile;

    //    @ColumnInfo(name = "user_password")
    @Ignore
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nMobile: " + mobile;
    }
}
