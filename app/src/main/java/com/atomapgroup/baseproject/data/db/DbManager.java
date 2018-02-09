package com.atomapgroup.baseproject.data.db;

/**
 * This is singleton DbManager class and used to manage all kinds of database operation
 * Created by Mobarak on 09-Feb-18.
 */

public class DbManager implements IDbHelper {

    /**
     * DbManager instsnce
     */
    private static DbManager instance;

    /**
     * Default construct
     */
    private DbManager() {

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
}
