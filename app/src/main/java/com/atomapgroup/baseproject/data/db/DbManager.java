package com.atomapgroup.baseproject.data.db;

import android.arch.persistence.room.Room;

import com.atomapgroup.baseproject.data.model.User;
import com.atomapgroup.baseproject.ui.base.AndroidBaseApp;

import java.util.List;

/**
 * This is singleton DbManager class and used to manage all kinds of database operation
 * Created by Mobarak on 09-Feb-18.
 */

public class DbManager implements IDbHelper{

    /**
     * DbManager instsnce
     */
    private static DbManager instance;
    private static final String DB_NAME = "test-room";

    private AppDatabase db;

    /**
     * Default construct
     */
    private DbManager() {
        db = Room.databaseBuilder(AndroidBaseApp.getAppContext(), AppDatabase.class, DB_NAME).build();
    }

    /**
     * Invoke to get DbManager instance. If instance is null,
     * then create new object otherwise return previous one
     *
     * @return mInstance
     */
    public static DbManager getInstance() {
        if (instance == null) {
            synchronized (DbManager.class) {
                if (instance == null) {
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        return db.userDao().getAll();
    }

    @Override
    public List<User> loadAllByIds(int[] userIds) {
        return db.userDao().loadAllByIds(userIds);
    }

    @Override
    public User findByName(String name) {
        return db.userDao().findByName(name);
    }

    @Override
    public void insertAll(User... users) {
        db.userDao().insertAll(users);
    }

    @Override
    public void insert(User user) {
        db.userDao().insert(user);
    }

    @Override
    public void delete(User user) {
        db.userDao().delete(user);
    }

    @Override
    public void update(User user) {
        db.userDao().update(user);
    }
}
